package dk.kea.project1backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponse {

    public String title;
    public String image;
    public List<String> ingredientNames = new ArrayList<>();
    public List<String> steps = new ArrayList<>();

    public RecipeResponse(RecipeAPIResponse recipeAPIResponse, RecipeStepsAPIResponse recipeStepsAPIResponse) {
        this.title = recipeAPIResponse.getTitle();
        this.image = recipeAPIResponse.getImage();

        for (UsedIngredient usedIngredient : recipeAPIResponse.getUsedIngredients()) {
            ingredientNames.add(usedIngredient.getOriginalName());
        }
// Can adde step nr when it works
        this.steps = recipeStepsAPIResponse.getSteps().stream().map(step -> step.getStep()).toList();

    }
}
