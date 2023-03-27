package dk.kea.project1backend.api;

import dk.kea.project1backend.dto.FridgeRequest;
import dk.kea.project1backend.dto.FridgeResponse;
import dk.kea.project1backend.entity.Fridge;
import dk.kea.project1backend.service.FridgeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("api/fridge")
@RestController
@CrossOrigin
public class FridgeController {

  FridgeService fridgeService;

  public FridgeController(FridgeService fridgeService) {
    this.fridgeService = fridgeService;
  }

  @PreAuthorize("hasAuthority('USER')")
  @GetMapping()
  FridgeResponse readFridge(Principal p){
    return fridgeService.readFridge(p.getName());

  }

  @PreAuthorize("hasAuthority('USER')")
  @PostMapping()
  FridgeResponse createFridge(@RequestBody FridgeRequest fridgeRequest, Principal p){
    return fridgeService.createFridge(fridgeRequest, p.getName());
  }

  @PreAuthorize("hasAuthority('USER')")
  @PutMapping("/{id}")
  FridgeResponse updateFridge(@RequestBody FridgeRequest fridgeRequest, @PathVariable int id, Principal p){
    return fridgeService.updateFridge(fridgeRequest, id, p.getName());
  }

  @PreAuthorize("hasAuthority('USER')")
  @DeleteMapping("/ingredient/{id}")
  void deleteFridgeItem(@PathVariable int id, Principal p){
    fridgeService.removeIngredient(id,p.getName());
  }


}
