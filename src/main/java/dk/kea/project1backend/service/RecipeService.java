package dk.kea.project1backend.service;

import com.sun.tools.javac.Main;
import dk.kea.project1backend.dto.RecipeAPIResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeService {


  public void findRecipe () {

    RestTemplate restTemplate = new RestTemplate();

    //find køleskob ud fra id

    //hent madvarer ud af køleskabet

    String API_KEY = "0d02a9201e6c4121a93d3f4f1b53b0ed";
    String url = "https://api.spoonacular.com/recipes/findByIngredients?apiKey="+ API_KEY + "&ingredients=apples&number=1&ignorePantry=true&ranking=1";


    RecipeAPIResponse response = restTemplate.getForObject(url, RecipeAPIResponse.class);
//    System.out.println(response.toString());
//    MovieDTO response = restTemplate.getForObject(url, MovieDTO.class);

  }


  public static void main(String[] args) {
    RecipeService recipeService = new RecipeService();
    recipeService.findRecipe();
  }
}
