package model.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import model.Actor;
import model.Event;
import model.repository.exception.RepositoryException;
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
	 * Initialise the {@link List}&lt;{@link model.Event}&gt; events, add sample data, sort the List
	 */
	public MemoryEventRepository(){
		//Inititale Arraylist of Events
		this.events = new TreeMap<Integer, List<Event>>(); 
		
		Date myDate = this.getRandomDate(); 
		Event event2 = new Event("AAAAAAAAA", "This is the second event",myDate, this.getRandomDate()); 
		event2.addActor("1");
		event2.addActor("2");
		event2.addActor("3");
		this.addEvent(event2);
	
		Event event2B = new Event("A2A2A2A2A2A2A2A", "This is the second event",myDate, this.getRandomDate());
		event2B.addActor("1");
		event2B.addActor("2");
		event2B.addActor("3");
		this.addEvent(event2B);
		Event event3 = new Event("BBBBBBBBBB", "This is the thrid event", this.getRandomDate(), this.getRandomDate());
		event3.addActor("1");
		event3.addActor("2");
		event3.addActor("3");
		this.addEvent(event3);
		Event event4 = new Event("CCCCCCCCCCCCC", "This is the first event", this.getRandomDate(),this.getRandomDate());
		event4.addActor("1");
		event4.addActor("2");
		event4.addActor("3");
		this.addEvent(event4);
		Event event5 = new Event("DDDDDDDDDDDD", "This is the second event", this.getRandomDate(), this.getRandomDate());
		event5.addActor("1");
		event5.addActor("2");
		event5.addActor("3");
		this.addEvent(event5);
		Event event6 = new Event("EEEEEEEEEEEEEE", "This is the thrid event", this.getRandomDate(), this.getRandomDate());
		event6.addActor("1");
		event6.addActor("2");
		event6.addActor("3");
		this.addEvent(event6);
	}
	
	
	/**
	 * Not for public use. Generate random date for sample data
	 * @return Date Random date for testing purposes
	 */
	private Date getRandomDate(){
		Random  rnd;
	     Date    dt;
	     long    ms;
	     // Get a new random instance, seeded from the clock
	     rnd = new Random();
	     // Get an Epoch value roughly between 1940 and 2010
	     // -946771200000L = January 1, 1940
	     // Add up to 70 years to it (using modulus on the next long)
	     ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));

	     // Construct a date
	     dt = new Date(ms);
	     return dt; 
	}
	
	/**
	 * Get all the stored events
	 * @return {@link List}&lt;{@link model.Event}&gt;
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
			System.out.println("Error" + e.getMessage());
		}
		if(this.getEvents().containsKey(2017)){
		System.out.println("ALL EVENTS CURRENTLY ADDED: "+ this.getEvents().get(2017).get(0).getActors());
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
