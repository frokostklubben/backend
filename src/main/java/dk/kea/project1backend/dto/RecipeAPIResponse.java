package dk.kea.project1backend.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RecipeAPIResponse {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("title")
  public String title;
  @JsonProperty("image")
  public String image;
  @JsonProperty("imageType")
  public String imageType;
  @JsonProperty("usedIngredientCount")
  public Integer usedIngredientCount;
  @JsonProperty("missedIngredientCount")
  public Integer missedIngredientCount;
  @JsonProperty("missedIngredients")
  public List<MissedIngredient> missedIngredients;
  @JsonProperty("usedIngredients")
  public List<UsedIngredient> usedIngredients;
  @JsonProperty("unusedIngredients")
  public List<Object> unusedIngredients;
  @JsonProperty("likes")
  public Integer likes;

  }

@JsonInclude(JsonInclude.Include.NON_NULL)


class MissedIngredient {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("amount")
  public Double amount;
  @JsonProperty("unit")
  public String unit;
  @JsonProperty("unitLong")
  public String unitLong;
  @JsonProperty("unitShort")
  public String unitShort;
  @JsonProperty("aisle")
  public String aisle;
  @JsonProperty("name")
  public String name;
  @JsonProperty("original")
  public String original;
  @JsonProperty("originalName")
  public String originalName;
  @JsonProperty("meta")
  public List<Object> meta;
  @JsonProperty("image")
  public String image;

}


@JsonInclude(JsonInclude.Include.NON_NULL)

class UsedIngredient {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("amount")
  public Double amount;
  @JsonProperty("unit")
  public String unit;
  @JsonProperty("unitLong")
  public String unitLong;
  @JsonProperty("unitShort")
  public String unitShort;
  @JsonProperty("aisle")
  public String aisle;
  @JsonProperty("name")
  public String name;
  @JsonProperty("original")
  public String original;
  @JsonProperty("originalName")
  public String originalName;
  @JsonProperty("meta")
  public List<String> meta;
  @JsonProperty("image")
  public String image;

}
