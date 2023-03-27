package dk.kea.project1backend.service;

import com.sun.tools.javac.Main;
import dk.kea.project1backend.dto.RecipeAPIResponse;
import dk.kea.project1backend.dto.RecipeResponse;
import dk.kea.project1backend.dto.RecipeStepsAPIResponse;
import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecipeService {

  FridgeRepository fridgeRepository;

  @Value("${app.api-key}")
  private String API_KEY;

  public RecipeService(FridgeRepository fridgeRepository) {
    this.fridgeRepository = fridgeRepository;
  }

  public RecipeResponse findRecipe (Integer id) {

    RestTemplate restTemplate = new RestTemplate();

    //find køleskob ud fra id
    Fridge fridge = fridgeRepository.findById(id).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fridge with this ID does not exist"));

    //hent madvarer ud af køleskabet
    String ingredients = fridge.getIngredients().stream().map(ingredient -> ingredient.getName()+",").collect(Collectors.joining());



    String url = "https://api.spoonacular.com/recipes/findByIngredients?apiKey="+ this.API_KEY + "&ingredients="+ ingredients +"&number=1&ignorePantry=true&ranking=1";

    List<RecipeAPIResponse> responses = Arrays.asList(restTemplate.getForObject(url, RecipeAPIResponse[].class));


    // Get steps to the recipe
    int recipeId = responses.get(0).getId();

    String urlSteps = "https://api.spoonacular.com/recipes/" + recipeId + "/analyzedInstructions?stepBreakdown=true&apiKey=" + this.API_KEY;

    List<RecipeStepsAPIResponse> responsesSteps = Arrays.asList(restTemplate.getForObject(urlSteps, RecipeStepsAPIResponse[].class));

    RecipeResponse recipeResponse = new RecipeResponse(responses.get(0), responsesSteps.get(0));
    return recipeResponse;
  }

}
