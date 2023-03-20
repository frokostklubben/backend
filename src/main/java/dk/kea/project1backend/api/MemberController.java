package dk.kea.project1backend.api;

import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.service.MemberService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
//@CrossOrigin
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


}
