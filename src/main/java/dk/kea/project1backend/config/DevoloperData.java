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

    Fridge f1 = new Fridge();
    ArrayList<Ingredient> ingredients1 = new ArrayList<>();
    Ingredient f1_i1 = new Ingredient("f1name1",f1);
    Ingredient f1_i2 = new Ingredient("f1name2",f1);
    Ingredient f1_i3 = new Ingredient("f1name3",f1);
    ingredients1.add(f1_i1);
    ingredients1.add(f1_i2);
    ingredients1.add(f1_i3);
    f1.setIngredients(ingredients1);
    fridgeRepository.save(f1);

    Fridge f2 = new Fridge();
    ArrayList<Ingredient> ingredients2 = new ArrayList<>();
    Ingredient f2_i1 = new Ingredient("f2name1",f2);
    Ingredient f2_i2 = new Ingredient("f2name2",f2);
    Ingredient f2_i3 = new Ingredient("f2name3",f2);
    ingredients2.add(f2_i1);
    ingredients2.add(f2_i2);
    ingredients2.add(f2_i3);
    f2.setIngredients(ingredients2);
    fridgeRepository.save(f2);

    Fridge f3 = new Fridge();
    ArrayList<Ingredient> ingredients3 = new ArrayList<>();
    Ingredient f3_i1 = new Ingredient("f3name1",f3);
    Ingredient f3_i2 = new Ingredient("f3name2",f3);
    Ingredient f3_i3 = new Ingredient("f3name3",f3);
    ingredients3.add(f3_i1);
    ingredients3.add(f3_i2);
    ingredients3.add(f3_i3);
    f3.setIngredients(ingredients3);
    fridgeRepository.save(f3);




  }
}
