package model.service;

import java.util.Date;
import java.util.List;

import model.Event;
import model.repository.EventRepository;
import model.repository.MemoryEventRepository;
import ui.Observer;

public class EventService implements Subject {

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
		this.notifyObservers();
		return result;
	}
	
	public boolean removeEvent(int id){
		boolean result = this.eventRepository.removeEvent(id);
		this.notifyObservers();
		return result;
	}
	
	public List<Event> getAllEvents(){
		return this.eventRepository.getEvents();
	}
	
	//Observer pattern
	public void notifyObservers() {
		for(Observer o : observers){
			o.update();
		}
	}

	public void register(Observer observer) {
		this.observers.add(observer);
	}

	public void removeRegister(Observer observer) {
		for(int i = 0;i<this.observers.size() ; i++){
			if(this.observers.get(i) == observer){
				this.observers.remove(i);
			}
		}
	}
}
