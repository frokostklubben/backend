package dk.kea.project1backend.service;
import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
  MemberRepository memberRepository;
  //User with roles repo
  public List<MemberResponse> getMembers() {
    List<Member> members = memberRepository.findAll();
    return members.stream().map(member -> new MemberResponse(member)).toList();
  }
}
