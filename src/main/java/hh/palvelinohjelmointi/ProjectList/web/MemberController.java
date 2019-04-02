package hh.palvelinohjelmointi.ProjectList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepo;
	
	
	@RequestMapping(value= {"/memberCatalog"})
	public String membersListed(Model model) {
		
		model.addAttribute("members", memberRepo.findAll());
		
		return "memberCatalog";
		
	}

}
