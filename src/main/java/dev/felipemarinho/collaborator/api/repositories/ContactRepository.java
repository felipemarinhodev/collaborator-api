package dev.felipemarinho.collaborator.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipemarinho.collaborator.api.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
