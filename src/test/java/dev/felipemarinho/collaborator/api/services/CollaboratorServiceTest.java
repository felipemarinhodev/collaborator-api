package dev.felipemarinho.collaborator.api.services;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.collaboratorRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Collaborator()));
		BDDMockito.given(this.collaboratorRepository.save(Mockito.any(Collaborator.class))).willReturn(new Collaborator());
		BDDMockito.given(this.collaboratorRepository.findAll(Mockito.any(PageRequest.class))).willReturn(new PageImpl<Collaborator>(new ArrayList<Collaborator>()));
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
	
	@Test
	public void testFindCollaboratorsPagenate() {
		Page<Collaborator> colaboradores = this.collaboratorService.buscarColaboradores(PageRequest.of(0, 10));
		assertNotNull(colaboradores);
	}

}
