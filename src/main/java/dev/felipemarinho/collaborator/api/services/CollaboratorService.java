package dev.felipemarinho.collaborator.api.services;

import java.util.Optional;

import dev.felipemarinho.collaborator.api.entities.Collaborator;

public interface CollaboratorService {

	/**
	 * Retorna uma colaborador pelo seu id;
	 * 
	 * @param id
	 * @return Collaborator
	 */
	Optional<Collaborator> buscarPorId(Long id);
	
	/**
	 * Cadastra um novo colaborador na base de dados;
	 * 
	 * @param colaborador
	 * @return Collaborator
	 */
	Collaborator persistir(Collaborator colaborador);
}
