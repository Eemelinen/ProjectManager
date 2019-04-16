package hh.palvelinohjelmointi.ProjectList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.ProjectList.model.Member;
import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTests {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void findSingleMember() {	
		Member member = memberRepo.findByUsername("Eemelinen");
		assertThat(member.getLastName()).isEqualTo("Surakka");
	}
	
	@Test
	public void findAllMembers() {
		Iterable<Member> members = memberRepo.findAll();
		assertThat(members).isNotNull();
	}
	
}
