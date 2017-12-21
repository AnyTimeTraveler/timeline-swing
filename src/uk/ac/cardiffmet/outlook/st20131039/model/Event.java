package uk.ac.cardiffmet.outlook.st20131039.model; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class Event implements Comparable<Event>{

	/**
	 * List of actors associated with the event
	 */
	private List<String> actorsIds;
	
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
	 * Description about how the actors where involved in the event
	 */
	private String actorsInvolvementDescription; 
	
	/**
	 * Construc a new Event
	 * @param title The title of the event
	 * @param description The description of the event
	 * @param startDate The start date of the event
	 * @param endDate The end date of the event
	 * @param actorIds The ids of the involved actors
	 * @param actorsInvolvementDescription The description about how the actors where involved
	 */
	public Event(String title, String description, Date startDate, Date endDate, String[] actorIds, String actorsInvolvementDescription) {
		id = UUID.randomUUID().toString();
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setTitle(title);
		this.setDescription(description);
		this.actorsIds = new ArrayList<String>(Arrays.asList(actorIds)); 
		this.actorsInvolvementDescription = actorsInvolvementDescription; 
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
		if(startDate == null){
			throw new IllegalArgumentException("The start date cannot be null"); 
		}
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
		if(endDate == null){
			throw new IllegalArgumentException("The end date cannot be null"); 
		}
		this.EndDate = endDate;
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
	 * @return {@link List}&lt;{@link uk.ac.cardiffmet.outlook.st20131039.model.Actor}&gt; List of all actors associated with event 
	 */
	public List<String> getActors() {
		return actorsIds;
	}
	
	/**
	 * Add new Actor to event
	 * @param actorId int New actor to add
	 */
	public void addActor(String actorId) {
	if(actorId == null || actorId.isEmpty()){
		throw new IllegalArgumentException("The actorId cannot be null of empty"); 
	}
		
		this.actorsIds.add(actorId);
	}
	
	/**
	 * Set new List of actor Ids
	 * @param actors List of actor Ids
	 */
	private void setActors(List<String> actors){
		if(actors == null){
			throw new IllegalArgumentException("The actors cannot be null"); 
		}
		this.actorsIds = actors; 
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
		if(title == null || title.isEmpty()){
			throw new IllegalArgumentException("The title cannot be null or empty"); 
		}
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
		if(description == null || description.isEmpty()){
			throw new IllegalArgumentException("The description cannot be null or empty"); 
		}
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
	
	
	/**
	 * Get year out of Date
	 * @return int year
	 */
	public int getStartYear(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return Integer.parseInt(formatter.format(this.startDate)); 
	}

	/**
	 * Get Actors Involvement Description
	 * @return String Actors Involvement Description
	 */
	public String getActorsInvolvementDescription() {
		return actorsInvolvementDescription;
	}
	
	/**
	 * Set new Actors Involvement Description
	 * @param actorsInvolvementDescription new Actors Involvement Description
	 * @throws IllegalArgumentException Exception
	 */
	public void setActorsInvolvementDescription(String actorsInvolvementDescription) {
		if(actorsInvolvementDescription == null || actorsInvolvementDescription.isEmpty()){
			throw new IllegalArgumentException("The actorsInvolvementDescription cannot be null or empty"); 
		}
		this.actorsInvolvementDescription = actorsInvolvementDescription;
	}
	
	
	
}
