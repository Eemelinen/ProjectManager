package hh.palvelinohjelmointi.ProjectList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;
import hh.palvelinohjelmointi.ProjectList.model.MembershipRepository;
import hh.palvelinohjelmointi.ProjectList.model.ProjectRepository;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private MembershipRepository membershipRepo;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
    
	// == Kaikki projektit haetaan katalogisivulle näytettäväksi. Näihin tulee linkit sivulle projektin tiedosita. ==
	@RequestMapping(value= {"/", "/projectCatalog"})
	public String projectsListed(Model model) {	
		model.addAttribute("projects", projectRepo.findAll());
		return "projectCatalog";
	}
	
	@RequestMapping(value= {"/memberCatalog"})
	public String membersListed(Model model) {
		model.addAttribute("members", memberRepo.findAll());			
		return "memberCatalog";
	}
	
	@RequestMapping(value= {"/projectDetails/{projectId}"})
	public String projectDetails(@PathVariable("projectId") Long id, Model model) {
				
		model.addAttribute("projects", projectRepo.findAll());
		
		model.addAttribute("project", projectRepo.findById(id));
		
		model.addAttribute("memberships", membershipRepo.FindAllRelevantMembershipsIndexed(id));
		
		return "projectDetails";
	}
	
	@RequestMapping(value= {"/memberDetails/{memberId}"})
	public String memberDetails(@PathVariable("memberId") Long id, Model model) {
				
		model.addAttribute("members", memberRepo.findAll());
		
		model.addAttribute("member", memberRepo.findById(id));
		
		model.addAttribute("memberships", membershipRepo.FindAllMembershipsForMember(id));
		
		return "memberDetails";
	}
}
