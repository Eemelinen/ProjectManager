package hh.palvelinohjelmointi.ProjectList.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hh.palvelinohjelmointi.ProjectList.model.Membership;
import hh.palvelinohjelmointi.ProjectList.model.MembershipRepository;

@Controller
public class MembershipController {

	@Autowired
	private MembershipRepository membershipRepository;
	
//	public void listMemberships() {
//		
//		List<Membership> memberships = (List<Membership>) membershipRepository.findAll();
//	}
	
}
