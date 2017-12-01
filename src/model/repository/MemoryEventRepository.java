package model.repository;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Event;
import model.repository.exception.RepositoryException;
import ui.Observer;

public class MemoryEventRepository implements EventRepository, Subject {

	private List<Observer> observers; 
	private List<Event> events; 
	
	public MemoryEventRepository(){
		observers = new ArrayList<Observer>();
		
		//Inititale Arraylist of Events
		this.events = new ArrayList<Event>(); 
		
		//add sample events
		Event event1 = new Event("Event 1", "This is the first event", "5 Sep 2010", "8 Sep 2010");
		event1.addActor(new Actor("Dave"));
		Event event2 = new Event("Event 2", "This is the second event", "5 Sep 2010", "8 Sep 2010");
		event2.addActor(new Actor("John"));
		Event event3 = new Event("Event 3", "This is the thrid event", "5 Sep 2010", "8 Sep 2010");
		event3.addActor(new Actor("Kate"));
		this.addEvent(event1);
		this.addEvent(event2);
		this.addEvent(event3);
		
	}
	
	@Override
	public List<Event> getEvents() {
		return this.events;
	}

	@Override
	public boolean addEvent(Event event) {
		try{
			this.events.add(event);
			this.notifyObservers();
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
				this.notifyObservers();
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

	@Override
	public void notifyObservers() {
		for(Observer o : observers){
			o.update();
		}
	}

	@Override
	public void register(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeRegister(Observer observer) {
		for(int i = 0;i<this.observers.size() ; i++){
			if(this.observers.get(i) == observer){
				this.observers.remove(i);
			}
		}
	}

}
