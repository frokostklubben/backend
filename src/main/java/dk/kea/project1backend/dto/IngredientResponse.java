package dk.kea.project1backend.dto;

import dk.kea.project1backend.entity.Fridge;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class IngredientResponse {

    private Integer id;
    private String name;

    public IngredientResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
