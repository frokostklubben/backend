package dk.kea.project1backend.dto;


import dk.kea.project1backend.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FridgeRequest {

  private Integer id;

  private List<IngredientRequest> ingredients;

}
