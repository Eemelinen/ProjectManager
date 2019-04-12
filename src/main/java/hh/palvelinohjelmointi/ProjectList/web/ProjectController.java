package hh.palvelinohjelmointi.ProjectList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.palvelinohjelmointi.ProjectList.model.ProjectRepository;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	// == Kaikki projektit haetaan katalogisivulle näytettäväksi. Näihin tulee linkit sivulle projektin tiedosita. ==
	@RequestMapping(value= {"/", "/projectCatalog"})
	public String projectsListed(Model model) {
		
		model.addAttribute("projects", projectRepo.findAll());
		
		return "projectCatalog";
		
	}

}
