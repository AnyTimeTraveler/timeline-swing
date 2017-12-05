package model.service;

import model.Actor;
import model.repository.ActorRepository;
import model.repository.MemoryActorRepository;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class ActorService {

	/**
	 * The repository for {@link Actor}
	 */
	private ActorRepository actorRepository; 
	
	/**
	 * Initiates a new repository based on the specified type
	 * @param repositoryType The type of repository to be used
	 */
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
	
	/**
	 * Add a new actor
	 * @param actor Actor to add
	 */
	public void addActor(Actor actor){
		this.actorRepository.addActor(actor); 
	}
	
	/**
	 * Get an actor by an id
	 * @param id Id of the Actor to get
	 * @return model.Actor The {@link model.Actor} with the specified id
	 */
	public Actor getActor(int id){
		return this.actorRepository.getActor(id); 
	}
	
	/**
	 * Remove an {@link model.Actor} with a specified id
	 * @param id The id of the {@link model.Actor} to remove
	 */
	public void removeActor(int id){
		this.actorRepository.removeActor(id); 
	}
	
}
