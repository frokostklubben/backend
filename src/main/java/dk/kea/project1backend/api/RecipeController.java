package dk.kea.project1backend.api;


import dk.kea.project1backend.dto.RecipeAPIResponse;
import dk.kea.project1backend.dto.RecipeResponse;
import dk.kea.project1backend.service.RecipeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin
public class RecipeController {

RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  //bruger et køleskabs id
  @PreAuthorize("hasAuthority('USER')")
  @GetMapping()
  public RecipeResponse getRecipe(Principal p){
    return recipeService.findRecipe(p.getName());
  }

}
