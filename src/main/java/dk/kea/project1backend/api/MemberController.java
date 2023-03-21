package dk.kea.project1backend.api;

import dk.kea.project1backend.dto.MemberRequest;
import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin
public class MemberController {

  final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  //@PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping
  List<MemberResponse> getMembers(){
    return memberService.getMembers();
  }

  // Eventually we will change it to use the currently logged-in user
  @PutMapping("/{username}")
  public ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
    return memberService.editMember(body, username);
  }



}
