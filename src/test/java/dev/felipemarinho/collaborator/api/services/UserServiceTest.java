package dev.felipemarinho.collaborator.api.services;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import dev.felipemarinho.collaborator.api.entities.User;
import dev.felipemarinho.collaborator.api.repositories.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testFindUserPorid() {	
		BDDMockito.given(this.userRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new User()));
		Optional<User> user = this.userService.buscarPorId(1L);
		assertNotNull(user.isPresent());
	}
	
	@Test
	public void testShouldBeNullIfIDIsInexistent() {	
		Optional<User> user = this.userService.buscarPorId(1L);
		assertTrue(!user.isPresent());
	}

	@Test
	public void testFindUserPorEmail() {
		BDDMockito.given(this.userRepository.findByEmail(Mockito.anyString())).willReturn(new User());
		Optional<User> user = this.userService.buscarPorEmail("teste@email.com");
		assertNotNull(user.isPresent());
	}

	@Test
	public void testShouldBeNullIfEmailIsInexistent() {
		Optional<User> user = this.userService.buscarPorEmail("teste@email.com");
		assertTrue(!user.isPresent());
	}
}
