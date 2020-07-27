package dev.felipemarinho.collaborator.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	public PasswordUtils() {}

	/**
	 * Gera um hash utilizando o BCrypt.
	 * 
	 * @param senha
	 * @return String
	 */
	public static String buildBcrypt(String password) {
		if (password == null) {
			return password;
		}
		
		log.info("Building hash with Bcrypt");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(password);
	}
	
	/**
	 * Verifica se a senha é válida
	 * 
	 * @param password
	 * @param passwordEncoded
	 * @return boolean
	 */
	public static boolean validPassword(String password, String passwordEncoded) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(password, passwordEncoded);
	}
}
