package dev.felipemarinho.collaborator.api.dtos;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;

import dev.felipemarinho.collaborator.api.entities.Collaborator;
import dev.felipemarinho.collaborator.api.entities.Contact;
import dev.felipemarinho.collaborator.api.entities.ProfessionalExperiences;
import dev.felipemarinho.collaborator.api.enums.RoleEnum;
import dev.felipemarinho.collaborator.api.enums.TeamEnum;

public class CollaboratorDto {

	private Long id;
	private String name;
	private TeamEnum team;
	private RoleEnum role;
	private List<ProfessionalExperiences> experiences;
	private List<Contact> contacts;
	private String local;
	
	public CollaboratorDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 245, message = "Nome deve conter entre 3 e 245 caracteres")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = "Time não pode ser vazio.")
	public TeamEnum getTeam() {
		return team;
	}

	public void setTeam(TeamEnum team) {
		this.team = team;
	}

	@NotNull(message = "Cargo não pode ser vazio.")
	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	@NotNull(message = "Experiência Profissional não pode ser vazio.")
	public List<ProfessionalExperiences> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ProfessionalExperiences> experiences) {
		this.experiences = experiences;
	}

//	@NotNull(message = "Informe pelo menos um contato")
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "CollaboratorDto [id=" + id + ", name=" + name + ", team=" + team + ", role=" + role + ", experiences="
				+ experiences + ", contacts=" + contacts + ", local=" + local + "]";
	}
	
	/**
	 * Popula o DTO cadastro com os dados do Collaborator.
	 * 
	 * @param collaborator
	 * @return CollaboratorDto
	 */
	public static CollaboratorDto convertCollaboratorDto(Collaborator collaborator) {
		CollaboratorDto collaboratorDto = new CollaboratorDto();
		collaboratorDto.setName(collaborator.getName());
		collaboratorDto.setTeam(collaborator.getTeam());
		collaboratorDto.setRole(collaborator.getRole());
		collaboratorDto.setExperiences(collaborator.getProfessionalExperiences());
//		collaboratorDto.setContacts(collaborator.getContacts());
		collaboratorDto.setLocal(collaborator.getLocal());
		collaboratorDto.setId(collaborator.getId());
		return collaboratorDto;
	}

	/**
	 * Converter os dados do DTO para empresa
	 * 
	 * @param collaboradorDto
	 * @param result
	 * @return Collaborator
	 */
	public static Collaborator convertDtoForCollaborator(@Valid CollaboratorDto collaboradorDto, BindingResult result) {
		Collaborator collaborator = new Collaborator();
		collaborator.setName(collaboradorDto.getName());
		collaborator.setTeam(collaboradorDto.getTeam());
		collaborator.setRole(collaboradorDto.getRole());
		collaborator.setProfessionalExperiences(collaboradorDto.getExperiences());
//		collaborator.setContacts(collaboradorDto.getContacts());
		collaborator.setLocal(collaboradorDto.getLocal());
		
		return collaborator;
	}
	
	
}
