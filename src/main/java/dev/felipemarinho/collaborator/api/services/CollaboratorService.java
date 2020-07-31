package dev.felipemarinho.collaborator.api.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;

import dev.felipemarinho.collaborator.api.dtos.CollaboratorDto;
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
	
	/**
	 * Retorna uma lista paginada de Colaboradores
	 * 
	 * @param pageRequest
	 * @return Page<Collaborator>
	 */
	Page<Collaborator> buscarColaboradores(PageRequest pageRequest);

	/**
	 * Atualiza informações do colaborador. 
	 * 
	 * @param id
	 * @param collaboradorDto
	 * @param result 
	 * @return Collaborator
	 */
	Collaborator atualizarCollaborador(Long id, @Valid CollaboratorDto collaboradorDto, BindingResult result);

	/**
	 * Deleta as informações do colaborador
	 */
	void removendoColaborador(Long id);
}
