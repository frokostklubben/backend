package dk.kea.project1backend.api;

import dk.kea.project1backend.dto.MemberRequest;
import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.service.MemberService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

  @GetMapping
  List<MemberResponse> getMembers(){
    return memberService.getMembers();
  }


  @PreAuthorize("hasAuthority('USER')")
  @GetMapping("/{username}")
  MemberResponse getMemberByUsername(@PathVariable String username){
    return memberService.getMemberByUsername(username);
  }

  @PreAuthorize("hasAuthority('USER')")
  @DeleteMapping( "/{username}")
  public void deleteMemberByUsername(@PathVariable String username) {
    memberService.deleteMemberByUsername(username);
  }

  //No roles needed to add a member
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  MemberResponse addMember(@RequestBody MemberRequest body){
    return memberService.addMember(body);
  }

  // Eventually we will change it to use the currently logged-in user
  @PreAuthorize("hasAuthority('USER')")
  @PutMapping("/{username}")
  public ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
    return memberService.editMember(body, username);
  }

}
