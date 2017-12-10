package model.repository;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Event;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class MemoryActorRepository implements ActorRepository{

	/**
	 * {@link List} where {@link model.Actor} are stored
	 */
	private List<Actor> actors; 
	
	/**
	 * The {@link List}&lt;{@link model.Actor}&gt; actors is initialised
	 */
	public MemoryActorRepository(){
		this.actors = new ArrayList<Actor>(); 
		Actor a1 = new Actor("Jane", "1");
		Actor a2 = new Actor("Dave", "2");
		Actor a3 = new Actor("Bob", "3");
		this.actors.add(a1); 
		this.actors.add(a2); 
		this.actors.add(a3); 
	}
	/**
	 * Get all the stored {@link model.Actor}
	 * @return {@link List}&lt;{@link model.Actor}&gt; List of actors
	 */
	@Override
	public List<Actor> getActors() {
		return this.actors; 
	}

	/**
	 * Add a new {@link model.Actor}
	 * @param actor New {@link model.Actor} to add
	 */
	@Override
	public void addActor(Actor actor) {
		try{
		this.actors.add(actor); 
		}catch(Exception e){
		}	
	}

	/**
	 * Remove an {@link model.Actor} with a specified id
	 * @param id The id of the Actor
	 */
	@Override
	public void removeActor(String id) {
		for(int i = 0;i<this.actors.size() ; i++){
			if(actors.get(i).getId() == id){
				this.actors.remove(i);
			}
		}
	}

	/**
	 * Get an {@link model.Actor} with a specified id
	 * @param id The id of the {@link model.Actor} to get
	 * @return Actor The Actor with the specified id
	 */
	@Override
	public Actor getActor(String id) {
		for(int i = 0;i<this.actors.size() ; i++){
			if(actors.get(i).getId() == id){ 
				return this.actors.get(i); 
			}
		}
		return null; 
	}

	
	@Override
	public List<Actor> getAllActors(){
		return this.actors; 
	}
	
}
