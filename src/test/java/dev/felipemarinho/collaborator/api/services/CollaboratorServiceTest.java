package dev.felipemarinho.collaborator.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import dev.felipemarinho.collaborator.api.entities.Collaborator;
import dev.felipemarinho.collaborator.api.repositories.CollaboratorRepository;

@SpringBootTest
@ActiveProfiles("test")
public class CollaboratorServiceTest {
	
	@MockBean
	private CollaboratorRepository collaboratorRepository;
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	private static final Long ID = new Long(1);
	
	@BeforeEach
	public void setUp() throws Exception {
		BDDMockito.given(this.collaboratorRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Collaborator()));
		BDDMockito.given(this.collaboratorRepository.save(Mockito.any(Collaborator.class))).willReturn(new Collaborator());
	}
	
	@Test
	public void testFindCollaboratorById() {
		Optional<Collaborator> collaborator = this.collaboratorService.buscarPorId(ID);
		assertTrue(collaborator.isPresent());
	}
	
	@Test
	public void testCreateCollaborator() {
		Collaborator collaborator = this.collaboratorService.persistir(new Collaborator());
		assertNotNull(collaborator);
	}

}
