package dk.kea.project1backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import dk.kea.project1backend.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MemberResponse {
  String username; //Remember this is the primary key
  String email;
  String firstName;

  // Fridge object?


  //Convert Member Entity to Member DTO
  public MemberResponse(Member m) {
    this.username = m.getUsername();
    this.email = m.getEmail();
    this.firstName =m.getFirstName();

    }
  }
