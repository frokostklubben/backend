package dk.kea.project1backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "USER_TYPE")
public class Member {
  @Id
  String username;
  String email;
  String password;
  String firstName;

  //One-to-one fridge

  public Member(String username, String email, String password, String firstName) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.firstName = firstName;
  }

}
