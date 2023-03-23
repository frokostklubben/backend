package dk.kea.project1backend.config;

import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.entity.Ingredient;
import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.FridgeRepository;
import dk.kea.project1backend.repository.MemberRepository;
import dk.kea.project1backend.service.RecipeService;
import dk.kea.security.entity.Role;
import dk.kea.security.entity.UserWithRoles;
import dk.kea.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//@Configuration
@Component
//public class DeveloperData implements ApplicationRunner {
public class DeveloperData implements CommandLineRunner {

  FridgeRepository fridgeRepository;

  MemberRepository memberRepository;

  //temp
  RecipeService recipeService;

  @Autowired
  UserWithRolesRepository userWithRolesRepository;

  public DeveloperData(FridgeRepository fridgeRepository, MemberRepository memberRepository,RecipeService recipeService) {
    this.fridgeRepository = fridgeRepository;
    this.memberRepository = memberRepository;
    this.recipeService = recipeService;
  }

  final String passwordUsedByAll = "test12";

  private void setupUserWithRoleUsers() {

    System.out.println("******************************************************************************");
    System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
    System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
    System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
    System.out.println("******************************************************************************");
    UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
    UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
    UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
    UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
    user1.addRole(Role.USER);
    user1.addRole(Role.ADMIN);
    user2.addRole(Role.USER);
    user3.addRole(Role.ADMIN);
    //No Role assigned to user4
    userWithRolesRepository.save(user1);
    userWithRolesRepository.save(user2);
    userWithRolesRepository.save(user3);
    userWithRolesRepository.save(user4);
  }

  private void makeFridgeTestData() {

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

  private void makeMemberTestData() {
    Member member1 = new Member("user1", "user1@user.dk", "test12", "Marcus");
    Member member2 = new Member("user2", "user2@user.dk", "test12", "Tommy");

    member1.addRole(Role.USER);
    member2.addRole(Role.USER);

    memberRepository.save(member1);
    memberRepository.save(member2);
  }

  @Override
  public void run(String... args) throws Exception {
    //setupUserWithRoleUsers();
//    makeMemberTestData();
    recipeService.findRecipe();
  }
}
