package hh.palvelinohjelmointi.ProjectList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.ProjectList.model.Member;
import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;
import hh.palvelinohjelmointi.ProjectList.model.Project;
import hh.palvelinohjelmointi.ProjectList.model.ProjectRepository;

@SpringBootApplication
public class ProjectListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner projectTestData(ProjectRepository projectRepo) {
		
		return (args) -> {
			
			projectRepo.save(new Project("Mars rover", "The goal of the project is"
					+ "to build a functional Mars rover from scrap"));
			
			projectRepo.save(new Project("From Nand to Tetris", "Building your own computer starting from Nand-logic"
					+ "gates and finishing with programming of classic game Tetris."));
			
			projectRepo.save(new Project("Wisdom generator", "Build a machine that combines old proverbs from famous"
					+ "intellectuels into new ones using artificial intelligence."));
			
		};	
	}
	
	@Bean
	public CommandLineRunner memberTestData(MemberRepository memberRepo) {
		
		return (args) -> {
			
			memberRepo.save(new Member("Eemeli", "Surakka", "eemeli89@hotmail.fi", "044956970", "Interested in 3D-printing and Machine-learning."));
			memberRepo.save(new Member("Jaakko", "Hurme", "Jaakko89@hotmail.fi", "0449569235", "Math expert and techno poet."));
			memberRepo.save(new Member("Jake", "Castro", "Jakeman@hotmail.com", "042356970", "Multitasker and web developer"));
			memberRepo.save(new Member("Trey", "Gosling", "GoslingToMoon@moonboy.com", "04492344", "Interested in aviation and rocketry."));
			memberRepo.save(new Member("Jane", "Hash", "Hashed@Gaus.com", "03356123", "Passionate reader and tech enthusiast."));

		};
	}

}
