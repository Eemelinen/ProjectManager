package hh.palvelinohjelmointi.ProjectList.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository <Member, Long> {
	
	List<Member> findByLastName(String lastName);

}
