package dk.kea.project1backend.service;

import dk.kea.project1backend.dto.MemberRequest;
import dk.kea.project1backend.dto.MemberResponse;
import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberServiceTest {

  @Autowired
  public MemberRepository memberRepository;

  private MemberService memberService;

  boolean dataIsReady = false;

  @BeforeEach
  void setUp() {
    if(!dataIsReady){
      // String username, String email, String password, String firstName
      memberRepository.save(new Member("pokemon", "seb@gmail.com", "test12", "Sebastian"));
      memberRepository.save(new Member("skiordie", "tommyT@gmail.com", "test12", "Tommy"));

      dataIsReady = true;
      memberService = new MemberService(memberRepository); //Real DB is mocked away with H2
    }
  }

  @Test
  void getMembers() {
    List<MemberResponse> members = memberService.getMembers();
    assertEquals(2,members.size());
  }

  @Test
  void editMember(){
    if (memberRepository.existsById("skiordie")){
      Member member = memberRepository.findById("skiordie").get();
      MemberRequest request = new MemberRequest(member);
      request.setFirstName("Marcus");
      memberService.editMember(request,"skiordie");
      assertEquals("Marcus", request.getFirstName());
    }
  }
}