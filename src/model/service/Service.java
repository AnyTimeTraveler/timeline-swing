/**
* @author  Jeroen Vandevenne
* @version 1.0
*/

package model.service;

import java.util.Date;

import com.google.gson.Gson;

import model.Actor;
import ui.Observer;

public class Service implements Subject{

	
	private ActorService actorService; 
	private EventService eventService; 
	
	
	/**
	 * Initializes new services
	 */
	public Service(){
		/* Initialises a new ActorService */
		this.actorService = new ActorService("memory"); 
		/* Initialises a new ActorService */
		this.eventService = new EventService("memory"); 
	}
	
	/**
	 * Update all the registered observers
	 */
		public void notifyObservers() {
			for(Observer o : Subject.observers){
				o.update(this.getAllEvents());
			}
		}

		/**
		 * Register a new observer
		 */
		public void register(Observer observer) {
			Subject.observers.add(observer);
		}

		/**
		 * Remove an observer that is registered
		 */
		public void removeRegister(Observer observer) {
			for(int i = 0;i<Subject.observers.size() ; i++){
				if(Subject.observers.get(i) == observer){
					Subject.observers.remove(i);
				}
			}
		}
		
		/**
		 * Add a new event
		 * @param title
		 * The title of the event
		 * @param description
		 * The description of the event
		 * @param startDate
		 * The start date of event
		 * @param endDate
		 * The end date of event
		 */
	public void addEvent(String title, String description, Date startDate, Date endDate){
			this.eventService.addEvent(title, description, startDate, endDate);
			this.notifyObservers();
		}
		
	/**
	 * Remove an event by id
	 * @param id
	 * The id of the event
	 */
	public void removeEvent(int id){
			this.eventService.removeEvent(id);
			this.notifyObservers();
	}
	
	/**
	 * Get all the events that are in the database
	 * @return String all event as JSON 
	 */
	public String getAllEvents(){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getAllEvents());
		return jsonInString; 
	}
	
	/**
	 * Get an event with a specified id
	 * @param id 
	 * The id of the event
	 * @return String the event as JSON
	 */
	public String getEventById(int id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getEventById(id));
		return jsonInString; 
	}
	
	/**
	 * Add a new actor
	 * @param actor
	 * The actor to be added
	 */
	public void addActor(Actor actor){
		this.actorService.addActor(actor); 
		notifyObservers(); 
	}
	
	/**
	 * Get an actor by an id
	 * @param id
	 * The id of the actor
	 * @return String actor in Json
	 * 
	 */
	public String getActor(int id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getActor(id));
		return jsonInString;  
	}
	
	/**
	 * Remove an actor by and id
	 * @param id
	 * The id of the actor to remove
	 */
	public void removeActor(int id){
		this.actorService.removeActor(id); 
		notifyObservers(); 
	}
	
}
