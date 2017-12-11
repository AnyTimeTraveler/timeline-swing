package uk.ac.cardiffmet.outlook.st20131039.model.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import uk.ac.cardiffmet.outlook.st20131039.model.Actor;
import uk.ac.cardiffmet.outlook.st20131039.model.Event;
import uk.ac.cardiffmet.outlook.st20131039.model.repository.exception.RepositoryException;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class MemoryEventRepository implements EventRepository {

	/**
	 * {@link List} to store all events
	 */
	private Map<Integer, List<Event>> events; 
	
	/**
	 * Initialise the {@link List}&lt;{@link uk.ac.cardiffmet.outlook.st20131039.model.Event}&gt; events, add sample data, sort the List
	 */
	public MemoryEventRepository(){
		//Inititale TreeMap of Events
		this.events = new TreeMap<Integer, List<Event>>(); 
	}
	
	/**
	 * Get all the stored events
	 * @return {@link List}&lt;{@link uk.ac.cardiffmet.outlook.st20131039.model.Event}&gt;
	 */
	@Override
	public Map<Integer, List<Event>> getEvents() {
		return this.events;
	}

	/**
	 * Add a new event
	 * @param event The new event to add
	 */
	@Override
	public void addEvent(Event event) {
		try{
			if(this.events.containsKey(event.getStartYear())){
				this.events.get(event.getStartYear()).add(event); 
			}else{
				List<Event> eventsFromNewYear = new ArrayList<Event>(); 
				eventsFromNewYear.add(event);
				this.events.put(event.getStartYear(), eventsFromNewYear); 
			}
		}catch(RepositoryException e){
		}
	}
	
	
	/**
	 * Remove the event with the specified id
	 * @param id The id of the event to remove
	 */
	@Override
	public void removeEvent(String id) {
		try{
			for(int key: this.events.keySet()){
				for(int i = 0;i<this.events.get(key).size() ; i++){
					if(this.events.get(key).get(i).getId() == id){
						this.events.get(key).remove(i);
					}
				}
			}
		}catch(RepositoryException e){
			System.out.println("Error" + e.getMessage());
		}
	}

	/**
	 * Get the event with the specified id
	 * @param id The id of the event to get
	 * @return Event The event with the specified id
	 */
	@Override
	public Event getEvent(String id) {
		try{
			for(int key: this.events.keySet()){
				for(int i = 0;i<this.events.get(key).size() ; i++){
					if(this.events.get(key).get(i).getId() == id){
						return this.events.get(key).get(i); 
					}
				}
			}
		}catch(RepositoryException e){
			System.out.println("Error" + e.getMessage());
		}
		return null; 
	}


	@Override
	public void addEvents(Map<Integer, List<Event>> events) {
		this.events = events; 
	}


	@Override
	public List<Event> getEventsByYear(int year) {
		return this.events.get(year); 
	}

}
