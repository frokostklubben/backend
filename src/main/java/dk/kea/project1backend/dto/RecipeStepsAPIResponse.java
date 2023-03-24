package dk.kea.project1backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeStepsAPIResponse {

  @JsonProperty("name")
  public String name;
  @JsonProperty("steps")
  public List<Step> steps;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class Equipment {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("name")
  public String name;
  @JsonProperty("localizedName")
  public String localizedName;
  @JsonProperty("image")
  public String image;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class Ingredient {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("name")
  public String name;
  @JsonProperty("localizedName")
  public String localizedName;
  @JsonProperty("image")
  public String image;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class Length {

  @JsonProperty("number")
  public Integer number;
  @JsonProperty("unit")
  public String unit;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class Step {

  @JsonProperty("number")
  public Integer number;
  @JsonProperty("step")
  public String step;
  @JsonProperty("ingredients")
  public List<Ingredient> ingredients;
  @JsonProperty("equipment")
  public List<Equipment> equipment;
  @JsonProperty("length")
  public Length length;
}