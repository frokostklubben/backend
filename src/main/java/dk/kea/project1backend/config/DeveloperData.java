package dk.kea.project1backend.config;

import dk.kea.project1backend.entity.Member;
import dk.kea.project1backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperData implements ApplicationRunner {

  @Autowired
  MemberRepository memberRepository;

  public DeveloperData(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    makeTestData();
  }

  private void makeTestData() {
    Member member1 = memberRepository.save(new Member("user1", "user1@user.dk", "test12", "Marcus"));
    Member member2 = memberRepository.save(new Member("user2", "user2@user.dk", "test12", "Tommy"));

    //member1.addRole(Role.USER)
    //member2.addRole(Role.USER)
  }
}
