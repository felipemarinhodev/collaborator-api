package dev.felipemarinho.collaborator.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipemarinho.collaborator.api.entities.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
	

}
