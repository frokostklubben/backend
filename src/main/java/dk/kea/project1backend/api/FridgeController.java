package dk.kea.project1backend.api;

import dk.kea.project1backend.service.FridgeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/fridge")
@RestController
@CrossOrigin
public class FridgeController {

  FridgeService fridgeService;

  public FridgeController(FridgeService fridgeService) {
    this.fridgeService = fridgeService;
  }

  @PostMapping
  void addIngredient(){ }

}
