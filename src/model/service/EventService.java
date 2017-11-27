package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Event;

public class EventService extends Service{

	private List<Event> events; 

	public EventService(){
		this.events = new ArrayList<Event>();
		
		//Dummy Examples
		Event event1 = new Event("Event 1", "This is the first event");
		event1.addActor(new Actor("Dave"));
		Event event2 = new Event("Event 2", "This is the second event");
		event2.addActor(new Actor("John"));
		Event event3 = new Event("Event 3", "This is the thrid event");
		event3.addActor(new Actor("Kate"));
		this.addEvent(event1);
		this.addEvent(event2);
		this.addEvent(event3);
		
	}
	
	public boolean addEvent(Event event){
		try{
		this.events.add(event);
		return true;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return false; 
		}
	}
	
	public boolean removeEvent(int id){
		for(int i = 0; i<this.events.size(); i++){
			if(this.events.get(i).getId() ==  id){
				this.events.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<Event> getAllEvents(){
		return this.events;
	}
	
	
}
