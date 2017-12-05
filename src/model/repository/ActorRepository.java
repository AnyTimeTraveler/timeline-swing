
package model.repository;

import java.util.List;

import model.Actor;
import model.Event;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public interface ActorRepository {
	/**
	 * Get all the stored {@link model.Actor}
	 * @return {@link List}&lt;{@link model.Actor}&gt; List of actors
	 */
	public List<Actor> getActors();
	/**
	 * Add a new {@link model.Actor}
	 * @param actor New {@link model.Actor} to add
	 */
	public void addActor(Actor actor);
	/**
	 * Remove an {@link model.Actor} with a specified id
	 * @param id The id of the Actor
	 */
	public void removeActor(String id);
	/**
	 * Get an {@link model.Actor} with a specified id
	 * @param id The id of the {@link model.Actor} to get
	 * @return Actor The Actor with the specified id
	 */
	public Actor getActor(String id);
	public List<Actor> getAllActors(); 
}