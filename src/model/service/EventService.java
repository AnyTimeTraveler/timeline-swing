package model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Event;
import model.repository.EventRepository;
import model.repository.EventRepositoryFactory;
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
		this.eventRepository = EventRepositoryFactory.getEventRepository(repositoryType);
	}
	
	/**
	 * Add new {@link model.Event}
	 * @param title The title of the {@link model.Event}
	 * @param description The description of the {@link model.Event}
	 * @param startDate The start date of the {@link model.Event}
	 * @param endDate The end date of the {@link model.Event}
	 */
	public void addEvent(String title, String description, Date startDate, Date endDate, String[] actorIds, String actorsInvolvementDescription){
		Event event = new Event(title, description, startDate, endDate, actorIds, actorsInvolvementDescription); 
		this.eventRepository.addEvent(event);
	}
	
	/**
	 * Remove an {@link model.Event} with an id
	 * @param id The id of the {@link model.Event}
	 */
	public void removeEvent(String id){
		this.eventRepository.removeEvent(id);
	}
	
	/**
	 * Get all {@link model.Event}
	 * @return {@link List}&lt;{@link model.Event}&gt; List of All stored event
	 */
	public Map<Integer, List<Event>> getAllEvents(){
		return this.eventRepository.getEvents(); 
	}
	
	/**
	 * Get {@link model.Event} with a specified id
	 * @param id The id of the {@link model.Event} to get
	 * @return {@link model.Event} The {@link model.Event} with the specified id
	 */
	public Event getEventById(String id){
		return this.eventRepository.getEvent(id); 
	}
	
	public void addEvents(String eventsToAddInJson){
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Map<Integer, List<Event>> events = gson.fromJson(eventsToAddInJson,  new TypeToken<Map<Integer, List<Event>>>(){}.getType());
		this.eventRepository.addEvents(events); 
	}

	public String getEventsByYear(int year){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventRepository.getEventsByYear(year));
		return jsonInString;  
	}
}