package dk.kea.project1backend.service;


import dk.kea.project1backend.dto.FridgeRequest;
import dk.kea.project1backend.dto.FridgeResponse;
import dk.kea.project1backend.dto.IngredientRequest;
import dk.kea.project1backend.dto.IngredientResponse;
import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.entity.Ingredient;
import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.FridgeRepository;
import dk.kea.project1backend.repository.IngredientRepository;
import dk.kea.project1backend.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FridgeService {

  FridgeRepository fridgeRepository;
  MemberRepository memberRepository;
  private final IngredientRepository ingredientRepository;

  public FridgeService(FridgeRepository fridgeRepository,
                       MemberRepository memberRepository,
                       IngredientRepository ingredientRepository) {
    this.fridgeRepository = fridgeRepository;
    this.memberRepository = memberRepository;
    this.ingredientRepository = ingredientRepository;
  }

  public FridgeResponse createFridge(FridgeRequest fridgeRequest, String username) {
    Fridge fridgeToEdit = new Fridge();

    List<Ingredient> ingredients = fridgeRequest.getIngredients().stream().
            map(ingredientRequest -> new Ingredient(ingredientRequest.getName(),fridgeToEdit)).toList();
    fridgeToEdit.setIngredients(ingredients);

    Fridge fridgeSaved = fridgeRepository.save(fridgeToEdit);

    Member member = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    member.setFridge(fridgeSaved);

    memberRepository.save(member);


    return new FridgeResponse(fridgeSaved);
  }

  public FridgeResponse updateFridge(FridgeRequest fridgeRequest, int id, String username) {

    Member member = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    if(member.getFridge() == null || member.getFridge().getId() != id) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not have a fridge with the given id");
    }

    Fridge fridgeToEdit = fridgeRepository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fridge with this ID does not exist"));

    List<Ingredient> ingredients = new ArrayList<>();
    for (IngredientRequest ingredientRequest : fridgeRequest.getIngredients()) {
      if (ingredientRequest.getId() != null) {
        ingredients.add(new Ingredient(ingredientRequest.getId(), ingredientRequest.getName(), fridgeToEdit));
      }
      else {
        ingredients.add(new Ingredient(ingredientRequest.getName(), fridgeToEdit));
      }
    }
    fridgeToEdit.setIngredients(ingredients);

    Fridge fridgeSaved = fridgeRepository.save(fridgeToEdit);

    return new FridgeResponse(fridgeSaved);
  }

  public FridgeResponse readFridge(String username) {

    Member member = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    if(member.getFridge() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not have a fridge");
    }

    Integer id = member.getFridge().getId();

    Fridge fridgeToEdit = fridgeRepository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fridge with this ID does not exist"));

    return new FridgeResponse(fridgeToEdit);
  }

  public void removeIngredient(int id, String username){

    Member member = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));

    if (member.getFridge().getId().equals(ingredient.getFridge().getId())){
      ingredientRepository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not allowed");
    }
  }

}
