package hh.palvelinohjelmointi.ProjectList;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.ProjectList.web.ProjectController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectListApplicationTests {
	
	@Autowired
	private ProjectController projectController;
	
	@Test
	public void contextLoads() throws Exception {

		assertThat(projectController).isNotNull();
		
	}

} 
