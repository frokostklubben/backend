package dk.kea.project1backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    // TODO: double check that this is correct.
    @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();



}
