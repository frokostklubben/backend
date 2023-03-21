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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberServiceTest {

  @Autowired
  public MemberRepository memberRepository;

  MemberService memberService;
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
  void addMember() {
    Member member = new Member("username1", "test12", "user1@mail.dk", "Tommy");
    MemberRequest memberRequest = new MemberRequest(member);
    MemberResponse memberResponse = memberService.addMember(memberRequest);
    assertEquals("user1@mail.dk", memberResponse.getEmail());
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


  @Test
  void deleteMemberByUsername() {
    // Det burde være 2 members i repo på forhånd fra setup
    memberService.deleteMemberByUsername("skiordie");
    assertEquals(1, memberRepository.findAll().size());
  }

}