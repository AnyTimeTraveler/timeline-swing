
package model;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class Actor {

	/**
	 * The Name of the Actor
	 */
	private String name;
	/**
	 * The id of the Actor
	 */
	private String id; 

	/**
	 * Creates an Actor with a name and generate an id
	 * @param name The name of the actor
	 */
	public Actor(String name){
		this.setName(name);
		this.setId(UUID.randomUUID().toString());
	}
	
	/**
	 * Creates an Actor with a name an id
	 * @param name The name of the actor
	 */
	public Actor(String name, String id){
		this.setName(name);
		this.setId(id);
	}
	
	/**
	 * Get name of Actor
	 * @return String Name of actor
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name of actor
	 * @param name New name of Actor
	 */
	private void setName(String name) {
		if(name == null || name.isEmpty()){
			throw new IllegalArgumentException("The name cannot be null of empty"); 
		}
		this.name = name;
	}

	/**
	 * Get id of Actor
	 * @return String Id of Actor
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set new id for actor
	 * @param id int Id for actor
	 */
	private void setId(String id) {
		if(id == null || id.isEmpty()){
			throw new IllegalArgumentException("The id cannot be null"); 
		}
		this.id = id;
	}
}
