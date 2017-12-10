package model.service;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	public void addActor(String actor){
		JsonElement actors = new JsonParser().parse(actor);
		JsonObject actorsObject= actors.getAsJsonObject(); 
		String name = actorsObject.get("name").toString().substring(1, actorsObject.get("name").toString().length()-1);
		this.actorRepository.addActor(new Actor(name)); 
	}
	
	/**
	 * Get an actor by an id
	 * @param id Id of the Actor to get
	 * @return model.Actor The {@link model.Actor} with the specified id
	 */
	public Actor getActor(String id){
		return this.actorRepository.getActor(id); 
	}
	
	/**
	 * Remove an {@link model.Actor} with a specified id
	 * @param id The id of the {@link model.Actor} to remove
	 */
	public void removeActor(String id){
		this.actorRepository.removeActor(id); 
	}
	
	public List<Actor> getAllActors(){
		return this.actorRepository.getAllActors(); 
	}
	
	public String[] getActorIds(String[] actors){
		String[] ids = new String[actors.length]; 
		for(int i = 0; i<actors.length; i++){
			for(int j = 0;j<this.actorRepository.getAllActors().size() ; j++){
				if(actors[i].equals(this.actorRepository.getAllActors().get(j).getName())){
					ids[i] = this.actorRepository.getAllActors().get(j).getId(); 
				}
			}
		}
		return ids; 
	}
}
