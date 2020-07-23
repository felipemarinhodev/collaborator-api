package dev.felipemarinho.collaborator.api.utils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
