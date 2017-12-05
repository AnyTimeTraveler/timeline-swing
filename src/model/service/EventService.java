package model.service;

import java.util.Date;
import java.util.List;

import model.Event;
import model.repository.EventRepository;
import model.repository.MemoryEventRepository;


public class EventService{

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
	
	public boolean addEvent(String title, String description, Date startDate, Date endDate){
		Event event = new Event(title, description, startDate, endDate); 
		boolean result = this.eventRepository.addEvent(event);
		return result;
	}
	
	public boolean removeEvent(int id){
		boolean result = this.eventRepository.removeEvent(id);
		return result;
	}
	
	public List<Event> getAllEvents(){
		return this.eventRepository.getEvents(); 
	}
	
	public Event getEventById(int id){
		return this.eventRepository.getEvent(id); 
	}
}
