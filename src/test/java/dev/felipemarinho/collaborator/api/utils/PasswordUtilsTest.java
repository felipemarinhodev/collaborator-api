package dev.felipemarinho.collaborator.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PasswordUtilsTest {
	
	private static final String SENHA = "123456";
	private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNula() throws Exception {
		assertNull(PasswordUtils.buildBcrypt(null));
	}
	
	@Test
	public void testGenerateHashPassword() throws Exception {
		String hash = PasswordUtils.buildBcrypt(SENHA);
		assertTrue(bCryptEncoder.matches(SENHA, hash));
	}

}
