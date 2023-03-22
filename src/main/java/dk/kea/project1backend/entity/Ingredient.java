package dk.kea.project1backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    Fridge fridge;

    public Ingredient(String name, Fridge fridge) {
        this.name = name;
        this.fridge = fridge;
    }

    public Ingredient(int id, String name, Fridge fridge) {
        this.id = id;
        this.name = name;
        this.fridge = fridge;
    }
}
