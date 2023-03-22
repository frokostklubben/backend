package dk.kea.project1backend.api;

import dk.kea.project1backend.dto.FridgeRequest;
import dk.kea.project1backend.dto.FridgeResponse;
import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.service.FridgeService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/fridge")
@RestController
@CrossOrigin
public class FridgeController {

  FridgeService fridgeService;

  public FridgeController(FridgeService fridgeService) {
    this.fridgeService = fridgeService;
  }

  @GetMapping("/{id}")
  FridgeResponse readFridge(@PathVariable int id){
    return fridgeService.readFridge(id);
  }

  @PostMapping()
  FridgeResponse createFridge(@RequestBody FridgeRequest fridgeRequest){
    return fridgeService.createFridge(fridgeRequest);
  }

  @PutMapping("/{id}")
  FridgeResponse updateFridge(@RequestBody FridgeRequest fridgeRequest, @PathVariable int id){
    return fridgeService.updateFridge(fridgeRequest, id);
  }

}
