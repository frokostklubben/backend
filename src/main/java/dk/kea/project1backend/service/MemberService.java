package dk.kea.project1backend.service;
import dk.kea.project1backend.dto.MemberRequest;
import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemberService {
  MemberRepository memberRepository;


  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }



  //User with roles repo
  public List<MemberResponse> getMembers() {
    List<Member> members = memberRepository.findAll();
    return members.stream().map(member -> new MemberResponse(member)).toList();
  }


  public ResponseEntity<Boolean> editMember(MemberRequest body, String username){
    Member memberToEdit = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with this ID does not exist"));
    memberToEdit.setPassword(body.getPassword());
    memberToEdit.setEmail(body.getEmail());
    memberToEdit.setFirstName(body.getFirstName());
    memberRepository.save(memberToEdit);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }
}
