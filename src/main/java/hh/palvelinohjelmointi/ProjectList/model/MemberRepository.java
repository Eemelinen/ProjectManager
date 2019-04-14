package hh.palvelinohjelmointi.ProjectList.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository <Member, Long> {
	
	List<Member> findByLastName(String lastName);
	
	Member findByUsername(String username);
	
	@Query(
		value = "SELECT * FROM Member m WHERE m.member_Id = ?1",
		nativeQuery = true)
		Collection<Member> FindAllRelevantMembersIndexed(Long member_Id);

}
