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
import hh.palvelinohjelmointi.ProjectList.model.User;
import hh.palvelinohjelmointi.ProjectList.model.UserRepository;

@SpringBootApplication
public class ProjectListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectListApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(ProjectListApplication.class);
	
	@Bean
	public CommandLineRunner membershipTestData(MembershipRepository membershipRepo, MemberRepository memberRepo, ProjectRepository projectRepo, UserRepository userRepo) {
		
		return (args) -> {
			
			projectRepo.save(new Project("Mars Rover", "The goal of the project is"
					+ " to build a functional Mars rover from scrap."));
			
			projectRepo.save(new Project("From Nand to Tetris", "Building your own computer starting from Nand-logic"
					+ " gates and finishing with programming of classic game Tetris."));
			
			projectRepo.save(new Project("Wisdom Generator", "Build a machine that combines old proverbs from famous"
					+ " intellectuels into new ones using artificial intelligence."));
			
			memberRepo.save(new Member("Eemeli", "Surakka", "eemeli89@hotmail.fi", "044 9564 970", "Interested in 3D-printing and Machine-learning."));
			memberRepo.save(new Member("Jaakko", "Hurme", "Jaakko89@hotmail.fi", "045 9565 235", "Math expert and techno poet."));
			memberRepo.save(new Member("Jake", "Castro", "Jakeman@hotmail.com", "042 3566 970", "Multitasker and web developer"));
			memberRepo.save(new Member("Trey", "Gosling", "GoslingToMoon@moonboy.com", "044 9237 344", "Interested in aviation and rocketry."));
			memberRepo.save(new Member("Jane", "Hash", "Hashed@Gaus.com", "033 5618 223", "Passionate reader and tech enthusiast."));
			
			membershipRepo.save(new Membership("Working on rocket booster's circuitry.", memberRepo.findByLastName("Gosling").get(0),
					projectRepo.findByProjectName("From Nand to Tetris").get(0)));
			
			membershipRepo.save(new Membership("Studying gravitation pull.", memberRepo.findByLastName("Hash").get(0),
					projectRepo.findByProjectName("From Nand to Tetris").get(0)));
			
			membershipRepo.save(new Membership("Thinking about wisdoms.", memberRepo.findByLastName("Hash").get(0),
					projectRepo.findByProjectName("Wisdom Generator").get(0)));
			
			membershipRepo.save(new Membership("Planning UI.", memberRepo.findByLastName("Hurme").get(0),
					projectRepo.findByProjectName("Wisdom Generator").get(0)));
			
			membershipRepo.save(new Membership("Designer of rover tires.", memberRepo.findByLastName("Surakka").get(0),
					projectRepo.findByProjectName("Mars Rover").get(0)));
			
			User user1 = new User("user", "$2a$10$tLy5ngwYvnltoar6SDFExubXzzeawxuY4rr7N/BOREveJf45x08GW", "USER");
			User user2 = new User("admin", "$2a$10$1Wx77JGem8GZNZ8g3uxybePFIj.aLMS2Hyxf3o2efFWDHAs3A7CZW", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			
//			for (Membership membership : membershipRepo.findAll()) {
//				log.info(membership.toString());
//			}
			
//			for (Project project : projectRepo.findAll()) {
//				log.info(project.toString());
//			}
			
		};	
	}
}
