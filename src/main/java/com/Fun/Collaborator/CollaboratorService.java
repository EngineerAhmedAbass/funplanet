package com.Fun.Collaborator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CollaboratorService {

	@Autowired
	private CollaboratorRepository collaboratorRepository;

	public void AddCollaborator(Collaborator collaborator) {
		
		collaboratorRepository.save(collaborator);
	}

	public List<Collaborator> GetAllCollaboratorGames(String email) {
		List<Collaborator> collaborators=new ArrayList<>();
		collaboratorRepository.findByTId(email)
		.forEach(collaborators::add);
		return collaborators;
	}
	
}
