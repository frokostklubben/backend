package dk.kea.project1backend.dto;

import dk.kea.project1backend.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

  @Getter
  @Setter
  @NoArgsConstructor
  public class MemberRequest {
    String username;
    String email;
    String password;
    String firstName;


    public static Member getMemberEntity(MemberRequest m){
      return new Member(m.getUsername(),m.getPassword(),m.getEmail(), m.getFirstName());
    }

    // Member to MemberRequest conversion
    public MemberRequest(Member m){
      this.username = m.getUsername();
      this.password = m.getPassword();
      this.firstName = m.getFirstName();
      this.email = m.getEmail();
    }
}
