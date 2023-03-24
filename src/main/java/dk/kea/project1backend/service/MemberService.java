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
    return members.stream().map(MemberResponse::new).toList();
  }


  public void deleteMemberByUsername(String username) {
    // check token if it is the user logged in
    memberRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    memberRepository.deleteById(username);
  }


  public ResponseEntity<Boolean> editMember(MemberRequest body, String username){
    Member memberToEdit = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with this ID does not exist"));
    // check token if it is the user logged in
    memberToEdit.setPassword(body.getPassword());
    memberToEdit.setEmail(body.getEmail());
    memberToEdit.setFirstName(body.getFirstName());
    memberRepository.save(memberToEdit);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  public MemberResponse addMember(MemberRequest body) {
    if(memberRepository.existsById(body.getUsername())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this ID already exists");
    }
    if(memberRepository.existsByEmail(body.getEmail())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this e-mail already exists");
    }

    Member newMember = MemberRequest.getMemberEntity(body);
    //Tilføj rolle til newMember!
    newMember = memberRepository.save(newMember);
    return new MemberResponse(newMember);
  }


  public MemberResponse getMemberByUsername(String username) {
    Member found = memberRepository.findById(username).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    return new MemberResponse(found);
  }

}
