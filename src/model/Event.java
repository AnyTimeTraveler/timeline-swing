package model; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class Event implements Comparable<Event>{

	/**
	 * List of actors associated with the event
	 */
	private List<Actor> actors;
	/**
	 * Title of the event
	 */
	private String title; 
	/**
	 * Description of the event
	 */
	private String description;
	/**
	 * Id of the event
	 */
	private String id;
	/**
	 * Start date of the event
	 */
	private Date startDate; 
	/**
	 * End date of the event
	 */
	private Date EndDate; 
	
	/**
	 * Assigns parameters to variables and generates a new id, initializes an new List of {@link model.Actor}
	 * @param title The title of the event
	 * @param description The description of the event
	 * @param startDate The start date of the event
	 * @param endDate The end date of the event
	 */
	public Event(String title, String description, Date startDate, Date endDate) {
		id = UUID.randomUUID().toString();
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setTitle(title);
		this.setDescription(description);
		this.actors = new ArrayList<Actor>();
	}
	
	/**
	 * Assigns parameters to variables and generates a new id
	 * @param actors List of Actors associated with the event 
	 * @param title The title of the event
	 * @param description The description of the event
	 * @param startDate The start date of the event
	 * @param endDate The end date of the event
	 */
	public Event(List<Actor> actors, String title, String description, Date startDate, Date endDate) {
		id = UUID.randomUUID().toString();
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setActors(actors); 
		this.setTitle(title);
		this.setDescription(description);
	}
	
	
	/**
	 * Get Start date of event
	 * @return Date start date of event
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Set new start date of the event
	 * @param startDate New start date of the event
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get end date of the event
	 * @return Date end date of the event
	 */
	public Date getEndDate() {
		return EndDate;
	}

	/**
	 * Set new end date of the event
	 * @param endDate New end date of the event
	 */
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	/**
	 * Get id of the event
	 * @return int Id of the event
	 */
	public String getId(){
		return id; 
	}
	
	/**
	 * Get List of actors associated with the event
	 * @return {@link List}&lt;{@link model.Actor}&gt; List of all actors associated with event 
	 */
	public List<Actor> getActors() {
		return actors;
	}
	
	/**
	 * Add new Actor to event
	 * @param actor New actor to add
	 */
	public void addActor(Actor actor) {
		this.actors.add(actor);
	}
	
	/**
	 * Set new List of {@link model.Actor}
	 * @param actors List of {@link model.Actor}
	 */
	private void setActors(List<Actor> actors){
		this.actors = actors; 
	}
	
	/**
	 * Get title of the event
	 * @return String Title of the event
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set new title for the Event
	 * @param title New title for Event
	 */
	private void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Get description of the Event
	 * @return String description of the Event
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Set a new description
	 * @param description New description
	 */
	private void setDescription(String description) {
		this.description = description;
	}

/**
 * Method to compare different Events based on date
 * @param event2 The event to compare to 
 */
	@Override
	public int compareTo(Event event2) {
		return this.startDate.compareTo(event2.startDate);
	} 
	
	
	
}
