package dev.felipemarinho.collaborator.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.felipemarinho.collaborator.api.entities.ProfessionalExperiences;
import dev.felipemarinho.collaborator.api.repositories.ProfessionalExperienceRepository;
import dev.felipemarinho.collaborator.api.services.ProfessionalExperienceService;

@Service
public class ProfessionalExperienceServiceImpl implements ProfessionalExperienceService {
	
	private static final Logger log = LoggerFactory.getLogger(ProfessionalExperienceServiceImpl.class); 
	
	@Autowired
	private ProfessionalExperienceRepository professionalExperienceRepository;
	
	@Override
	public List<ProfessionalExperiences> persistirExperiencias(List<ProfessionalExperiences> professionalExperiences) {
		log.info("Salvando lista de experiências profissionais");
		List<ProfessionalExperiences> experiencesSaved = new ArrayList<>();
		professionalExperiences.forEach(experience -> {
			ProfessionalExperiences saved = professionalExperienceRepository.save(experience);
			experiencesSaved.add(saved);
		});
		return experiencesSaved;
	}
	
	

}
