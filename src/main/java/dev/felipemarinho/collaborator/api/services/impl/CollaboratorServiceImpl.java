package dev.felipemarinho.collaborator.api.services.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import dev.felipemarinho.collaborator.api.dtos.CollaboratorDto;
import dev.felipemarinho.collaborator.api.entities.Collaborator;
import dev.felipemarinho.collaborator.api.repositories.CollaboratorRepository;
import dev.felipemarinho.collaborator.api.services.CollaboratorService;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {
	
	private static final Logger log = LoggerFactory.getLogger(CollaboratorServiceImpl.class); 
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	@Override
	public Optional<Collaborator> buscarPorId(Long id) {
		log.info("Buscando um colaborador com o id {}", id);
		return collaboratorRepository.findById(id);
	}

	@Override
	public Collaborator persistir(Collaborator colaborador) {
		log.info("Persistindo o colaborador: {}", colaborador);
		return collaboratorRepository.save(colaborador);
	}

	@Override
	public Page<Collaborator> buscarColaboradores(PageRequest pageRequest) {
		log.info("Busca dos colaborador paginada");
		return this.collaboratorRepository.findAll(pageRequest);
	}

	@Override
	public Collaborator atualizarCollaborador(Long id, @Valid CollaboratorDto collaboradorDto, BindingResult result) {
		log.info("Atualiza dos colaborador");
		Optional<Collaborator> collaboratorOptional = collaboratorRepository.findById(id);
		if (collaboratorOptional.isPresent()) {
			Collaborator collaborator = CollaboratorDto.convertDtoForCollaborator(collaboradorDto, result);
			collaborator.setId(id);
			collaborator.setCreatedAt(collaboratorOptional.get().getCreatedAt());
			collaborator.setUpdatedAt(collaboratorOptional.get().getUpdatedAt());
			return collaboratorRepository.save(collaborator);
		}
		return null;
	}	

}
