package model.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.Actor;
import model.Event;
import model.repository.exception.RepositoryException;

public class MemoryEventRepository implements EventRepository {

	private List<Event> events; 
	
	public MemoryEventRepository(){
		//Inititale Arraylist of Events
		this.events = new ArrayList<Event>(); 
		//add sample events
		Date myDate = this.getRandomDate(); 
		Event event1A = new Event("KingsDay in London", "This is the first event", myDate, this.getRandomDate());
		Event event1B = new Event("Another event special", "This is the first event", myDate, this.getRandomDate());
		event1A.addActor(new Actor("Dave"));
		event1B.addActor(new Actor("Dave"));
		this.addEvent(event1A);
		this.addEvent(event1B);
		Event event2 = new Event("Incredible party", "This is the second event", this.getRandomDate(), this.getRandomDate());
		event2.addActor(new Actor("John"));
		System.out.println("EVENTS 3/ + "+event2.getStartDate());
		this.addEvent(event2);
		Event event3 = new Event("Lalaland movie release", "This is the thrid event", this.getRandomDate(), this.getRandomDate());
		event3.addActor(new Actor("Kate"));
		System.out.println("EVENTS 3/ + "+event2.getStartDate());
		this.addEvent(event3);
		Event event4 = new Event("Emmy awards", "This is the first event", this.getRandomDate(),this.getRandomDate());
		event4.addActor(new Actor("Dave"));
		this.addEvent(event4);
		Event event5 = new Event("Birthday John", "This is the second event", this.getRandomDate(), this.getRandomDate());
		event5.addActor(new Actor("John"));
		this.addEvent(event5);
		Event event6 = new Event("Special day Queen", "This is the thrid event", this.getRandomDate(), this.getRandomDate());
		event6.addActor(new Actor("Kate"));
		this.addEvent(event6);
		Collections.sort(events);
	}
	
	
	//testing purposes
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
	
	@Override
	public List<Event> getEvents() {
		
		return this.events;
	}

	@Override
	public boolean addEvent(Event event) {
		try{
			this.events.add(event);
			return true;
		}catch(RepositoryException e){
			System.out.println("Error" + e.getMessage());
			return false;	
		}
	}

	@Override
	public boolean removeEvent(int id) {
		try{
			//Search through all events to find matching id
			for(int i = 0;i<this.events.size() ; i++){
				if(id == this.events.get(i).getId()){
				this.events.remove(i);
				//Return true after event deleted
				return true;
				}
			}
			//Return false if no event was deleted during loop
			return false; 
		}catch(RepositoryException e){
			System.out.println("Error" + e.getMessage());
			return false;	
		}
	}

	@Override
	public Event getEvent(int id) {
		try{
			for(int i = 0;i<this.events.size() ; i++){
				if(id == this.events.get(i).getId()){
				return this.events.get(i);
				}
			}
		}catch(RepositoryException e){
			System.out.println("Error: "+e.getMessage());
			return null; 
		}
		return null; 
	}

}
