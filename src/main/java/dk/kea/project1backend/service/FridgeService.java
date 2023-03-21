package dk.kea.project1backend.service;


import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.entity.Ingredient;
import dk.kea.project1backend.repository.FridgeRepository;
import org.springframework.stereotype.Service;


@Service
public class FridgeService {

FridgeRepository fridgeRepository;

  public FridgeService(FridgeRepository fridgeRepository) {
    this.fridgeRepository = fridgeRepository;
  }

  public void addIngredient(Fridge fridge) {
    fridgeRepository.save(fridge);
  }
}
