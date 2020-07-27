package dev.felipemarinho.collaborator.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import dev.felipemarinho.collaborator.api.entities.User;
import dev.felipemarinho.collaborator.api.enums.ProfileEnum;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	private static final String EMAIL = "fulano@email.com";
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setUp() throws Exception {
		User user = new User();
		user.setEmail(EMAIL);
		user.setName("Fulano da Silva");
		user.setProfile(ProfileEnum.ROLE_ADMIN);
		user.setPassword("123");
		this.userRepository.save(user);
	}

	@After
	public final void tearDown() {
		this.userRepository.deleteAll();
	}
	
	@Test
	public void testFindByEmail() {
		User user = this.userRepository.findByEmail(EMAIL);
		assertEquals(user.getEmail(), EMAIL);
	}
	
}
