package dev.felipemarinho.collaborator.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipemarinho.collaborator.api.entities.ProfessionalExperiences;

public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperiences, Long> {

}
