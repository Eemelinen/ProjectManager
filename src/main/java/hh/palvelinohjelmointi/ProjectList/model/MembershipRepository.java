package hh.palvelinohjelmointi.ProjectList.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Membership, Long> {
	
	List<Membership>findByMembershipId(Long membershipId);
	
//	@Query(
//		value = "SELECT * FROM Membership m WHERE m.project_Id = 3",
//		nativeQuery = true)
//	Collection<Membership> FindAllRelevantMembershipsNative();
	
	// == Query ottaa arvon controllerista, joka taas saa arvon URL-parametrina. ==
	@Query(
		value = "SELECT * FROM Membership m WHERE m.project_Id = ?1",
		nativeQuery = true)
	Collection<Membership> FindAllRelevantMembershipsIndexed(Long project_Id);
	
	@Query(
			value = "SELECT * FROM Membership m WHERE m.member_Id = ?1",
			nativeQuery = true)
		Collection<Membership> FindAllMembershipsForMember(Long member_Id);

}
