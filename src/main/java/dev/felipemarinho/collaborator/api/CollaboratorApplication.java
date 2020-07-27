package dev.felipemarinho.collaborator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollaboratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaboratorApplication.class, args);
	}

//	@Autowired
//	private UserService userService;
	
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			User user = new User();
//			user.setName("Fulano da Silva");
//			user.setEmail("fulano@mail.com");
//			user.setPassword("123456");
//			user.setProfile(ProfileEnum.ROLE_ADMIN);
//			userService.save(user);
//		};
//	}

}
