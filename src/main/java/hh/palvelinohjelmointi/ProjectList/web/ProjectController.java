package hh.palvelinohjelmointi.ProjectList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.palvelinohjelmointi.ProjectList.model.Member;
import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;
import hh.palvelinohjelmointi.ProjectList.model.Membership;
import hh.palvelinohjelmointi.ProjectList.model.MembershipCreatorObject;
import hh.palvelinohjelmointi.ProjectList.model.MembershipRepository;
import hh.palvelinohjelmointi.ProjectList.model.Project;
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
	
	@RequestMapping(value= {"/memberDetails/{memberId}"})
	public String memberDetails(@PathVariable("memberId") Long id, Model model) {
				
		model.addAttribute("members", memberRepo.findAll());
				
		model.addAttribute("member", memberRepo.findByMemberId(id));
		
		model.addAttribute("memberships", membershipRepo.FindAllMembershipsForMember(id));
		
		return "memberDetails";
	}
	
	@RequestMapping(value= "/projectDetails/{projectId}/{username}")
	public String projectDetails(@PathVariable("projectId") Long id, Model model) {
		
		model.addAttribute("project", projectRepo.findByProjectId(id));
				
		model.addAttribute("projects", projectRepo.findAll());
								
		model.addAttribute("memberships", membershipRepo.FindAllRelevantMembershipsIndexed(id));
	
		return "projectDetails";
	}
	
	@RequestMapping(value= {"/newProject"})
	public String newProject(Model model) {
		
		model.addAttribute("project", new Project());

		return "newProject";
	}
	
	@RequestMapping(value= "/saveProject", method=RequestMethod.POST)
	public String saveProject(Project project) {
		projectRepo.save(project);
		return "redirect:/projectCatalog";
	}
	
	@RequestMapping(value= "/joinProject/{projectId}/{username}", method=RequestMethod.POST)
	public String joinProject(@PathVariable("projectId") Long urlId, @PathVariable("username") String username) {
		
//		model.addAttribute("mObject", new MembershipCreatorObject());
				
//		model.addAttribute("project", projectRepo.findByProjectId(urlId));
		
		Project projectToAdd = projectRepo.findByProjectId(urlId);
		
		Member memberToAdd = memberRepo.findByUsername(username);
		
		Membership membershipToAdd = new Membership("Waiting for a task.", memberToAdd, projectToAdd);
		
		membershipRepo.save(membershipToAdd);
		
		return "redirect:/projectDetails/{projectId}/{username}";
	}
	
//	@RequestMapping(value="/saveMembership", method=RequestMethod.POST)
//	public String saveMembership(MembershipCreatorObject mObject) {
//		
//		String id = mObject.getId();
//		
//		Long idConverted = Long.parseLong(id);
//		
//		String username = mObject.getUsername();
//		
//		String description = mObject.getJobDescription();
//				
//		Project projectToAdd = projectRepo.findByProjectId(idConverted);
//		
//		Member memberToAdd = memberRepo.findByUsername(username);
//	
//		Membership membershipToAdd = new Membership(description, memberToAdd, projectToAdd);
//		
//		membershipRepo.save(membershipToAdd);
//		
//		return "redirect:/project";
//	}

	@RequestMapping(value="/register")
	public String register(Model model) {
		model.addAttribute("member", new Member());
		return "register";
	}
}
