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
import dk.kea.security.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FridgeServiceTest {

    @Autowired
    public FridgeRepository fridgeRepository;

    @Autowired
    public MemberRepository memberRepository;

    public FridgeService fridgeService;

    @Autowired
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {
        this.fridgeService = new FridgeService(fridgeRepository, memberRepository, ingredientRepository);
    }

    @Test
    void createFridge() {
        ArrayList<IngredientRequest> ingredients1 = new ArrayList<>();
        IngredientRequest f1_i1 = new IngredientRequest(null, "f1name1");
        IngredientRequest f1_i2 = new IngredientRequest(null, "f1name2");
        IngredientRequest f1_i3 = new IngredientRequest(null, "f1name3");
        ingredients1.add(f1_i1);
        ingredients1.add(f1_i2);
        ingredients1.add(f1_i3);

        FridgeRequest fridgeRequest1 = new FridgeRequest(null, ingredients1);

        Member member1 = new Member("user1", "user1@user.dk", "test12", "Marcus");
        memberRepository.save(member1);

        FridgeResponse fridgeResponse2 = fridgeService.createFridge(fridgeRequest1, member1.getUsername());

        assertEquals(1, fridgeRepository.findAll().size());
    }

    @Test
    void updateFridge() {
        Fridge f1 = new Fridge();
        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        Ingredient f1_i1 = new Ingredient("f1name1",f1);
        Ingredient f1_i2 = new Ingredient("f1name2",f1);
        ingredients1.add(f1_i1);
        ingredients1.add(f1_i2);
        f1.setIngredients(ingredients1);
        Fridge f1saved = fridgeRepository.save(f1);

        ArrayList<IngredientRequest> ingredients2 = new ArrayList<>();
        IngredientRequest f2_i1 = new IngredientRequest(f1_i1.getId(), "f1name1");
        IngredientRequest f2_i2 = new IngredientRequest(f1_i2.getId(), "f1name2");
        IngredientRequest f2_i3 = new IngredientRequest(null, "f1name3");
        ingredients2.add(f2_i1);
        ingredients2.add(f2_i2);
        ingredients2.add(f2_i3);

        FridgeRequest fridgeRequest1 = new FridgeRequest(f1saved.getId(), ingredients2);

        Member member1 = new Member("user1", "user1@user.dk", "test12", "Marcus");
        member1.setFridge(f1saved);
        memberRepository.save(member1);

        FridgeResponse fridgeResponse = fridgeService.updateFridge(fridgeRequest1, f1saved.getId(), member1.getUsername());

        assertEquals(3, fridgeRepository.findById(f1saved.getId()).get().getIngredients().size());
    }

    @Test
    void readFridge() {
        Fridge f1 = new Fridge();
        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        Ingredient f1_i1 = new Ingredient("f1name1",f1);
        Ingredient f1_i2 = new Ingredient("f1name2",f1);
        Ingredient f1_i3 = new Ingredient("f1name3",f1);
        ingredients1.add(f1_i1);
        ingredients1.add(f1_i2);
        ingredients1.add(f1_i3);
        f1.setIngredients(ingredients1);
        Fridge f1saved = fridgeRepository.save(f1);

        FridgeResponse fridgeResponse1 = new FridgeResponse(f1saved);

        Member member1 = new Member("user1", "user1@user.dk", "test12", "Marcus");
        member1.setFridge(f1saved);
        memberRepository.save(member1);

        FridgeResponse fridgeResponse2 = fridgeService.readFridge(member1.getUsername());

        for (IngredientResponse ingredientResponse1 : fridgeResponse1.getIngredients()) {
            for (IngredientResponse ingredientResponse2 : fridgeResponse2.getIngredients()) {
                if (ingredientResponse1.getId() == ingredientResponse2.getId()) {
                    assertEquals(ingredientResponse1.getName(), ingredientResponse2.getName());
                    break;
                }
            }
        }

    }

}
