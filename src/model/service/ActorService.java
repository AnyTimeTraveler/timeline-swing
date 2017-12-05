package model.service;

import model.Actor;
import model.repository.ActorRepository;
import model.repository.MemoryActorRepository;

public class ActorService {

	private ActorRepository actorRepository; 
	
	public ActorService(String repositoryType){
		switch(repositoryType){
		case "memory": 
			this.actorRepository = new MemoryActorRepository(); 
		break; 
		default:
			this.actorRepository = new MemoryActorRepository(); 
			break; 
		}
		
	}
	
	public void addActor(Actor actor){
		this.actorRepository.addActor(actor); 
	}
	
	public Actor getActor(int id){
		return this.actorRepository.getActor(id); 
	}
	
	public void removeActor(int id){
		this.actorRepository.removeActor(id); 
	}
	
}
