package hh.palvelinohjelmointi.ProjectList.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Membership, Long> {
	
	List<Membership>findByMembershipId(Long membershipId);

}
