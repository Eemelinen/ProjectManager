package hh.palvelinohjelmointi.ProjectList.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.ProjectList.model.Member;
import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;
import hh.palvelinohjelmointi.ProjectList.model.Membership;
import hh.palvelinohjelmointi.ProjectList.model.MembershipRepository;
import hh.palvelinohjelmointi.ProjectList.model.Project;
import hh.palvelinohjelmointi.ProjectList.model.ProjectRepository;

@Controller
public class JsonController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private MembershipRepository membershipRepo;
	
    @RequestMapping(value="/showMembershipsJson", method = RequestMethod.GET)
    public @ResponseBody List<Membership> MembershipListRest() {	
        return (List<Membership>) membershipRepo.findAll();
    }
    
    @RequestMapping(value="/showMembershipJson/{membershipId}", method = RequestMethod.GET)
    public @ResponseBody Optional<Membership> findMembershipRest(@PathVariable("membershipId") Long membershipId) {	
    	return membershipRepo.findById(membershipId);
    }
    
    @RequestMapping(value="/showMembersJson", method = RequestMethod.GET)
    public @ResponseBody List<Member> MemberListRest() {	
        return (List<Member>) memberRepo.findAll();
    }
    
    @RequestMapping(value="/showMemberJson/{memberId}", method = RequestMethod.GET)
    public @ResponseBody Optional<Member> findMemberRest(@PathVariable("memberId") Long memberId) {	
    	return memberRepo.findById(memberId);
    }
    
    @RequestMapping(value="/showProjectsJson", method = RequestMethod.GET)
    public @ResponseBody List<Project> ProjectListRest() {	
        return (List<Project>) projectRepo.findAll();
    }
    
    @RequestMapping(value="/showProjectJson/{projectId}", method = RequestMethod.GET)
    public @ResponseBody Optional<Project> findProjectRest(@PathVariable("projectId") Long projectId) {	
    	return projectRepo.findById(projectId);
    }
}
