package hh.palvelinohjelmointi.ProjectList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.ProjectList.model.Member;
import hh.palvelinohjelmointi.ProjectList.model.MemberRepository;
import hh.palvelinohjelmointi.ProjectList.model.Membership;
import hh.palvelinohjelmointi.ProjectList.model.MembershipRepository;
import hh.palvelinohjelmointi.ProjectList.model.Project;
import hh.palvelinohjelmointi.ProjectList.model.ProjectRepository;

@SpringBootApplication
public class ProjectListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectListApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(ProjectListApplication.class);
	
	@Bean
	public CommandLineRunner membershipTestData(MembershipRepository membershipRepository, MemberRepository memberRepo) {
		
		return (args) -> {
			
			memberRepo.save(new Member("Eemeli", "Surakka", "eemeli89@hotmail.fi", "044 9564 970", "Interested in 3D-printing and Machine-learning."));
			memberRepo.save(new Member("Jaakko", "Hurme", "Jaakko89@hotmail.fi", "045 9565 235", "Math expert and techno poet."));
			memberRepo.save(new Member("Jake", "Castro", "Jakeman@hotmail.com", "042 3566 970", "Multitasker and web developer"));
			memberRepo.save(new Member("Trey", "Gosling", "GoslingToMoon@moonboy.com", "044 9237 344", "Interested in aviation and rocketry."));
			memberRepo.save(new Member("Jane", "Hash", "Hashed@Gaus.com", "033 5618 223", "Passionate reader and tech enthusiast."));
			
			membershipRepository.save(new Membership("YOyo", "To You", memberRepo.findByLastName("Gosling").get(0)));
			
			for (Membership membership : membershipRepository.findAll()) {
				log.info(membership.toString());
			}
		};	
	}
	
	
	
	@Bean
	public CommandLineRunner projectTestData(ProjectRepository projectRepo) {
		
		return (args) -> {
			
			projectRepo.save(new Project("Mars rover", "The goal of the project is"
					+ " to build a functional Mars rover from scrap."));
			
			projectRepo.save(new Project("From Nand to Tetris", "Building your own computer starting from Nand-logic"
					+ " gates and finishing with programming of classic game Tetris."));
			
			projectRepo.save(new Project("Wisdom generator", "Build a machine that combines old proverbs from famous"
					+ " intellectuels into new ones using artificial intelligence."));
						
		};	
	}
}
