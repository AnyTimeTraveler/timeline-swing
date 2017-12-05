package model.service;

import java.util.Date;
import java.util.List;

import model.Event;
import model.repository.EventRepository;
import model.repository.MemoryEventRepository;

/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class EventService{

	/**
	 * The repository for {@link Event}
	 */
	private EventRepository eventRepository;
	
	/**
	 * Initiates a new repository based on the specified type
	 * @param repositoryType The type of repository to be used
	 */
	public EventService(String repositoryType){
		switch(repositoryType){
		case "memory" : 
			this.setUpMemoryRepository();
			break; 
		default: this.setUpMemoryRepository();
		}
	}
	
	/**
	 * Initialises a new {@link  model.repository.MemoryEventRepository}
	 */
	private void setUpMemoryRepository(){
		this.eventRepository = new MemoryEventRepository(); 
	}
	
	/**
	 * Add new {@link model.Event}
	 * @param title The title of the {@link model.Event}
	 * @param description The description of the {@link model.Event}
	 * @param startDate The start date of the {@link model.Event}
	 * @param endDate The end date of the {@link model.Event}
	 */
	public void addEvent(String title, String description, Date startDate, Date endDate){
		Event event = new Event(title, description, startDate, endDate); 
		this.eventRepository.addEvent(event);
	}
	
	/**
	 * Remove an {@link model.Event} with an id
	 * @param id The id of the {@link model.Event}
	 */
	public void removeEvent(int id){
		this.eventRepository.removeEvent(id);
	}
	
	/**
	 * Get all {@link model.Event}
	 * @return {@link List}&lt;{@link model.Event}&gt; List of All stored event
	 */
	public List<Event> getAllEvents(){
		return this.eventRepository.getEvents(); 
	}
	
	/**
	 * Get {@link model.Event} with a specified id
	 * @param id The id of the {@link model.Event} to get
	 * @return {@link model.Event} The {@link model.Event} with the specified id
	 */
	public Event getEventById(int id){
		return this.eventRepository.getEvent(id); 
	}
}
