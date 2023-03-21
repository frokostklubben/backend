package dk.kea.project1backend.config;


import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.entity.Ingredient;
import dk.kea.project1backend.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DevoloperData implements CommandLineRunner {

  @Autowired
  FridgeRepository fridgeRepository;

  @Override
  public void run(String... args) throws Exception {
    Fridge fridge = new Fridge();


    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Ingredient gulerod = new Ingredient("gulerod",fridge);
    Ingredient fersken = new Ingredient("fersken",fridge);
    ingredients.add(fersken);
    ingredients.add(gulerod);
    fridge.setIngredients(ingredients);
    fridgeRepository.save(fridge);



  }
}
