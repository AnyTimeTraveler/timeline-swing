package model.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

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
		//add sample events
		/*Date myDate = this.getRandomDate(); 
		Event event1A = new Event("KingsDay in London", "This is the first event", myDate, this.getRandomDate());
		Actor a1 = new Actor("Jane", "1");
		event1A.addActor(a1.getId());
		Event event1B = new Event("Another event special", "This is the first event", myDate, this.getRandomDate());
		Actor a2 = new Actor("Dave", "1");
		Actor BAAAAA = new Actor("Herald", "1");
		event1B.addActor(BAAAAA.getId());
		Event event1C = new Event("KingsDay in London", "This is the first event", myDate, this.getRandomDate());
		Actor a3 = new Actor("Bob", "1");
		event1C.addActor(a3.getId());
		this.addEvent(event1A);
		this.addEvent(event1B);
		this.addEvent(event1C);*/
		Date myDate = this.getRandomDate(); 
		Event event2 = new Event("AAAAAAAAA", "This is the second event",myDate, this.getRandomDate());
		this.addEvent(event2);
		Event event2B = new Event("A2A2A2A2A2A2A2A", "This is the second event",myDate, this.getRandomDate());
		this.addEvent(event2B);
		Event event3 = new Event("BBBBBBBBBB", "This is the thrid event", this.getRandomDate(), this.getRandomDate());
		this.addEvent(event3);
		Event event4 = new Event("CCCCCCCCCCCCC", "This is the first event", this.getRandomDate(),this.getRandomDate());
		this.addEvent(event4);
		Event event5 = new Event("DDDDDDDDDDDD", "This is the second event", this.getRandomDate(), this.getRandomDate());
		this.addEvent(event5);
		Event event6 = new Event("EEEEEEEEEEEEEE", "This is the thrid event", this.getRandomDate(), this.getRandomDate());
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
