package dk.kea.project1backend.entity;

import dk.kea.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {
  String firstName;
  @OneToOne
  Fridge fridge;

  public Member(String username, String email, String password, String firstName) {
    super(username, password, email);
    this.firstName = firstName;
  }

}
