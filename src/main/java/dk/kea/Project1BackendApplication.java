package dk.kea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication( exclude = {SecurityAutoConfiguration.class} )
public class Project1BackendApplication {
  public static void main(String[] args) {
    SpringApplication.run(Project1BackendApplication.class, args);
  }
}
