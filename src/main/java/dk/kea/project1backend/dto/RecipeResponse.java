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
    public List<String> usedIngredientNames = new ArrayList<>();
    public List<String> missedIngredientNames = new ArrayList<>();
    public List<String> steps = new ArrayList<>();

    public RecipeResponse(RecipeAPIResponse recipeAPIResponse, RecipeStepsAPIResponse recipeStepsAPIResponse) {
        this.title = recipeAPIResponse.getTitle();
        this.image = recipeAPIResponse.getImage();

        for (UsedIngredient usedIngredient : recipeAPIResponse.getUsedIngredients()) {
            usedIngredientNames.add(usedIngredient.getOriginalName());
        }

        for (MissedIngredient missedIngredient : recipeAPIResponse.getMissedIngredients()) {
            missedIngredientNames.add(missedIngredient.getOriginalName());
        }
        
        this.steps = recipeStepsAPIResponse.getSteps().stream().map(step -> step.getStep()).toList();

    }
}
