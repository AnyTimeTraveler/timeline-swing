package uk.ac.cardiffmet.outlook.st20131039.model.service;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import uk.ac.cardiffmet.outlook.st20131039.model.Actor;
import uk.ac.cardiffmet.outlook.st20131039.model.repository.ActorRepository;
import uk.ac.cardiffmet.outlook.st20131039.model.repository.ActorRepositoryFactory;
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
		this.actorRepository = ActorRepositoryFactory.getActorRepository(repositoryType);
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
	 * @return model.Actor The {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} with the specified id
	 */
	public Actor getActor(String id){
		return this.actorRepository.getActor(id); 
	}
	
	/**
	 * Remove an {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} with a specified id
	 * @param id The id of the {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} to remove
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
	
	public void addActors(String actorsJson){
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		List<Actor> actors = gson.fromJson(actorsJson,  new TypeToken<List<Actor>>(){}.getType());
		this.actorRepository.addActors(actors); 
	}
}
