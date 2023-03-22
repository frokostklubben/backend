package dk.kea.project1backend.repository;

import dk.kea.project1backend.entity.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FridgeRepository extends JpaRepository<Fridge, Integer> {
}
