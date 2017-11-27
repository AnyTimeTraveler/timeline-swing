package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Event;
import model.repository.*;

public class EventService extends Service {

	private EventRepository eventRepository; 

	public EventService(String repositoryType){
		switch(repositoryType){
		case "memory" : 
			this.setUpMemoryRepository();
			break; 
		default: this.setUpMemoryRepository();
		}
	}
	
	private void setUpMemoryRepository(){
		this.eventRepository = new MemoryEventRepository(); 
	}
	
	public boolean addEvent(String title, String description, String startDate, String endDate){
		Event event = new Event(title, description, startDate, endDate); 
		return this.eventRepository.addEvent(event);
	}
	
	public boolean removeEvent(int id){
		return this.eventRepository.removeEvent(id);
	}
	
	public List<Event> getAllEvents(){
		return this.eventRepository.getEvents();
	}
	
	
}
