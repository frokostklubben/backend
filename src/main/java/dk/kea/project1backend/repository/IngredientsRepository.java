package dk.kea.project1backend.repository;

import dk.kea.project1backend.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredient,Integer> {
}
