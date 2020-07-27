package dev.felipemarinho.collaborator.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.felipemarinho.collaborator.api.dtos.CollaboratorDto;
import dev.felipemarinho.collaborator.api.entities.Collaborator;
import dev.felipemarinho.collaborator.api.response.Response;
import dev.felipemarinho.collaborator.api.services.CollaboratorService;

@RestController
@RequestMapping("/api/collaborator")
@CrossOrigin(origins = "*")
public class CollaboratorController {
	
	private static final Logger log = LoggerFactory.getLogger(CollaboratorController.class);
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	public CollaboratorController() {}
	
	/**
	 * Cadastra um Collaborator no sistema.
	 * 
	 * @param collaboradorDto
	 * @param result
	 * @return ResponseEntity<Response<Collaborator>>
	 */
	@PostMapping
	public ResponseEntity<Response<CollaboratorDto>> create(@Valid @RequestBody CollaboratorDto collaboradorDto, BindingResult result) {
		log.info("Cadastrando Colaborador: {}", collaboradorDto.toString());
		Response<CollaboratorDto> response = new Response<CollaboratorDto>();
		
		validCollaborator(collaboradorDto, result);
		
		if (result.hasErrors()) {
			log.error("Erro validando dados do cadastro colaborador: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Collaborator collaborator = CollaboratorDto.convertDtoForCollaborator(collaboradorDto, result);
		
		this.collaboratorService.persistir(collaborator);
		
		response.setData(CollaboratorDto.convertCollaboratorDto(collaborator));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<Page<CollaboratorDto>>> index(
			@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		log.info("Listando Colaborador");
		Response<Page<CollaboratorDto>> response = new Response<Page<CollaboratorDto>>();

		PageRequest pageRequest = PageRequest.of(pag, 6);
		Page<Collaborator> collaborators = this.collaboratorService.buscarColaboradores(pageRequest);
		Page<CollaboratorDto> collaboratorsDto = collaborators.map(collaborator -> CollaboratorDto.convertCollaboratorDto(collaborator));
		
		response.setData(collaboratorsDto);
		return ResponseEntity.ok(response);
	}

	/**
	 * Verifica se algo a respeito do colaborator que será inserido.
	 * 
	 * @param collaboradorDto
	 * @param result
	 */
	private void validCollaborator(CollaboratorDto collaboradorDto, BindingResult result) {
		
	}

}
