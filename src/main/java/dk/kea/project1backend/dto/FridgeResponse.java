package dk.kea.project1backend.dto;

import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.entity.Ingredient;
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
public class FridgeResponse {

    private Integer id;

    private List<IngredientResponse> ingredients = new ArrayList<>();

    public FridgeResponse(Fridge fridge) {
        this.id = fridge.getId();

        for (Ingredient ingredient : fridge.getIngredients()) {
            ingredients.add(new IngredientResponse(ingredient.getId(), ingredient.getName()));
        }
    }
}
