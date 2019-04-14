package hh.palvelinohjelmointi.ProjectList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.ProjectList.model.Membership;
import hh.palvelinohjelmointi.ProjectList.model.MembershipRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MembershipRepositoryTests {
	
	@Autowired
	private MembershipRepository membershipRepo;
	
	@Test
	public void findAllMemberships() {

		Iterable<Membership> memberships = membershipRepo.findAll();
		assertThat(memberships).isNotNull();
	}
	
	@Test
	public void findSingleMembership() {	
		Iterable<Membership> membership = membershipRepo.FindAllRelevantMembershipsIndexed((long) 5);
		assertThat(membership).isNotNull();
	}
}
