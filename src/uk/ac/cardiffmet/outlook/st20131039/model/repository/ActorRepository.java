
package uk.ac.cardiffmet.outlook.st20131039.model.repository;

import java.util.List;

import uk.ac.cardiffmet.outlook.st20131039.model.Actor;
import uk.ac.cardiffmet.outlook.st20131039.model.Event;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public interface ActorRepository {
	/**
	 * Get all the stored {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor}
	 * @return {@link List}&lt;{@link uk.ac.cardiffmet.outlook.st20131039.model.Actor}&gt; List of actors
	 */
	public List<Actor> getActors();
	
	/**
	 * Add a new {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor}
	 * @param actor New {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} to add
	 */
	public void addActor(Actor actor);
	
	/**
	 * Remove an {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} with a specified id
	 * @param id The id of the Actor
	 */
	public void removeActor(String id);
	
	/**
	 * Get an {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} with a specified id
	 * @param id The id of the {@link uk.ac.cardiffmet.outlook.st20131039.model.Actor} to get
	 * @return Actor The Actor with the specified id
	 */
	public Actor getActor(String id);
	
	/**
	 * Get a List of all the stored Actors
	 * @return List of Actors
	 */
	public List<Actor> getAllActors(); 
	
	/**
	 * Add a List of Actors
	 * @param actors List of actors to add
	 */
	public void addActors(List<Actor> actors); 
}