package dk.kea.project1backend.service;


import dk.kea.project1backend.dto.FridgeRequest;
import dk.kea.project1backend.dto.FridgeResponse;
import dk.kea.project1backend.dto.IngredientRequest;
import dk.kea.project1backend.dto.IngredientResponse;
import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.entity.Ingredient;
import dk.kea.project1backend.repository.FridgeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FridgeService {

  FridgeRepository fridgeRepository;

  public FridgeService(FridgeRepository fridgeRepository) {
    this.fridgeRepository = fridgeRepository;
  }

  public FridgeResponse createFridge(FridgeRequest fridgeRequest) {
    Fridge fridgeToEdit = new Fridge();

    List<Ingredient> ingredients = fridgeRequest.getIngredients().stream().
            map(ingredientRequest -> new Ingredient(ingredientRequest.getName(),fridgeToEdit)).toList();
    fridgeToEdit.setIngredients(ingredients);

    Fridge saved = fridgeRepository.save(fridgeToEdit);

    return new FridgeResponse(saved);
  }

  public FridgeResponse updateFridge(FridgeRequest fridgeRequest, int id) {
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

    Fridge saved = fridgeRepository.save(fridgeToEdit);
    return new FridgeResponse(saved);
  }

  public FridgeResponse readFridge(int id) {
    Fridge fridgeToEdit = fridgeRepository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fridge with this ID does not exist"));

    return new FridgeResponse(fridgeToEdit);
  }
}
