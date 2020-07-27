package dev.felipemarinho.collaborator.api.repositories;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import dev.felipemarinho.collaborator.api.entities.Collaborator;
import dev.felipemarinho.collaborator.api.entities.Contact;
import dev.felipemarinho.collaborator.api.entities.ProfessionalExperiences;
import dev.felipemarinho.collaborator.api.enums.ContactEnum;
import dev.felipemarinho.collaborator.api.enums.RoleEnum;
import dev.felipemarinho.collaborator.api.enums.TeamEnum;

@SpringBootTest
@ActiveProfiles("test")
public class CollaboratorRepositoryTest {
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	@Test
	public void testSaveCollaborator() {
		ProfessionalExperiences professionalExperience = new ProfessionalExperiences();
		professionalExperience.setDescription("Java 8 e Angular 7");
		professionalExperience.setSkills("Angular 7; Java 8; SQLServer;");
		
		List<ProfessionalExperiences> experiences = new ArrayList<ProfessionalExperiences>();
		experiences.add(professionalExperience);
		
		Contact contactTelephone = new Contact();
		contactTelephone.setType(ContactEnum.TELEFONE_CELULAR);
		contactTelephone.setValue("99 999999999");
		
		Contact contactEmail = new Contact();
		contactEmail.setType(ContactEnum.EMAIL);
		contactEmail.setValue("email@email.com");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contactTelephone);
		contacts.add(contactEmail);
		
		Collaborator collaborator = new Collaborator();
		collaborator.setName("Fulano da silva");
		collaborator.setTeam(TeamEnum.CHAPTER_FRONT_END);
		collaborator.setRole(RoleEnum.ANALISTA_PLENO);
		collaborator.setLocal("SQN 311");
		collaborator.setProfessionalExperiences(experiences);
		collaborator.setContacts(contacts);
		
		Collaborator collaboratorSaved = this.collaboratorRepository.save(collaborator);
		
		assertNotNull(collaboratorSaved.getId());
		assertEquals(collaborator.getName(), collaboratorSaved.getName());
		assertEquals(collaborator.getTeam(), collaboratorSaved.getTeam());
		assertEquals(collaborator.getRole(), collaboratorSaved.getRole());
		assertEquals(collaborator.getLocal(), collaboratorSaved.getLocal());
		assertEquals(collaborator.getProfessionalExperiences(), collaboratorSaved.getProfessionalExperiences());
		assertEquals(collaborator.getContacts(), collaboratorSaved.getContacts());
	}

}
