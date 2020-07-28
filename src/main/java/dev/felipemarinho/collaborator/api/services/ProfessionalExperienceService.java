package dev.felipemarinho.collaborator.api.services;

import java.util.List;

import dev.felipemarinho.collaborator.api.entities.ProfessionalExperiences;

public interface ProfessionalExperienceService {

	/**
	 * Cadastra uma lista de experiências de um profissional
	 * 
	 * @param professionalExperiences
	 * @return List<ProfessionalExperiences>
	 */
	List<ProfessionalExperiences> persistirExperiencias(List<ProfessionalExperiences> professionalExperiences);
	
}
