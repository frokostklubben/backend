package dk.kea.project1backend.service;
import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemberService {
  MemberRepository memberRepository;
  //User with roles repo
  public List<MemberResponse> getMembers() {
    List<Member> members = memberRepository.findAll();
    return members.stream().map(MemberResponse::new).toList();
  }


  public void deleteMemberByUsername(String username) {
    memberRepository.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    memberRepository.deleteById(username);
  }



}
