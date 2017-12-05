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
	
	public void addEvent(String title, String description, Date startDate, Date endDate){
		Event event = new Event(title, description, startDate, endDate); 
		this.eventRepository.addEvent(event);
	}
	
	public void removeEvent(int id){
		this.eventRepository.removeEvent(id);
	}
	
	public List<Event> getAllEvents(){
		return this.eventRepository.getEvents(); 
	}
	
	public Event getEventById(int id){
		return this.eventRepository.getEvent(id); 
	}
}
