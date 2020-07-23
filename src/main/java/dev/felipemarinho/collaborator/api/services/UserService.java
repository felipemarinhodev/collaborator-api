package dev.felipemarinho.collaborator.api.services;

import java.util.Optional;

import dev.felipemarinho.collaborator.api.entities.User;

public interface UserService {
	/**
	 * Busca e retorna um usuário dado um E-mail
	 * 
	 * @param email
	 * @return Optional<User>
	 */
	Optional<User> buscarPorEmail(String email); 
	
	/**
	 * Busca e retorna um usuário dado um id
	 * 
	 * @param id
	 * @return Optional<User>
	 */
	Optional<User> buscarPorId(Long id); 
}
