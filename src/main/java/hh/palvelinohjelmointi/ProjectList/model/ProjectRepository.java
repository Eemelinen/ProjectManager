package hh.palvelinohjelmointi.ProjectList.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository <Project, Long> {

	List<Project> findByProjectName(String projectName);
	
	List<Project> findByProjectId(Long projectId);
		
}
