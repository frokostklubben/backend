package dk.kea.project1backend.repository;

import dk.kea.project1backend.entity.Ingredient;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository <Ingredient, Integer> {
}
