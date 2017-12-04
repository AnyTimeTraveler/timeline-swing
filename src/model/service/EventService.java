package model.service;

import java.util.Date;

import com.google.gson.Gson;

import model.Event;
import model.repository.EventRepository;
import model.repository.MemoryEventRepository;
import ui.Observer;

public class EventService implements Subject {

	private EventRepository eventRepository;
	//private List<Observer> observers = new ArrayList<Observer>(); 
	
	
	public EventService(){
		String repositoryType = "memory"; 
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
	
	public String getAllEvents(){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventRepository.getEvents());
		return jsonInString; 
	}
	
	//Observer pattern
	public void notifyObservers() {

		for(Observer o : Subject.observers){
			o.update(this.getAllEvents());
		}
	}

	public void register(Observer observer) {
		Subject.observers.add(observer);
	}

	public void removeRegister(Observer observer) {
		for(int i = 0;i<Subject.observers.size() ; i++){
			if(Subject.observers.get(i) == observer){
				Subject.observers.remove(i);
			}
		}
	}
}
