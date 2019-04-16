package hh.palvelinohjelmointi.ProjectList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.ProjectList.model.Project;
import hh.palvelinohjelmointi.ProjectList.model.ProjectRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTests {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Test
	public void findAllProjects() {
		Iterable<Project> projects = projectRepo.findAll();
		assertThat(projects).isNotNull();
	}
	
	@Test
	public void findSingleProject() {
		Project project = projectRepo.findByProjectId((long) 1);
		assertThat(project).isNotNull();
	}
}
