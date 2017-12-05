package model.service;

import java.util.Date;

import com.google.gson.Gson;

import model.Actor;
import model.Event;
import ui.Observer;

public class Service implements Subject{

	private ActorService actorService; 
	private EventService eventService; 
	
	
	//Constructor
	public Service(){
		this.actorService = new ActorService("memory"); 
		this.eventService = new EventService("memory"); 
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
	
	//Methods to interact with the model
		
	public boolean addEvent(String title, String description, Date startDate, Date endDate){
			boolean result = this.eventService.addEvent(title, description, startDate, endDate);
			this.notifyObservers();
			return result;
		}
		
	public boolean removeEvent(int id){
			boolean result = this.eventService.removeEvent(id);
			this.notifyObservers();
			return result;
	}
	
	public String getAllEvents(){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getAllEvents());
		return jsonInString; 
	}
	
	public String getEventById(int id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getEventById(id));
		return jsonInString; 
	}
	
	public void addActor(Actor actor){
		this.actorService.addActor(actor); 
		notifyObservers(); 
	}
	
	public String getActor(int id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getActor(id));
		return jsonInString;  
	}
	
	public void removeActor(int id){
		this.actorService.removeActor(id); 
		notifyObservers(); 
	}
	
}
