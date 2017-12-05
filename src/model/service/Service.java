/**
* @author  Jeroen Vandevenne
* @version 1.0
*/

package model.service;

import java.util.Date;

import com.google.gson.Gson;

import model.Actor;
import ui.Observer;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class Service implements Subject{

	
	/**
	 * The ActorService
	 */
	private ActorService actorService; 
	/**
	 * The EventService
	 */
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
	 * Update all the registered {@link ui.Observer}
	 */
		public void notifyObservers() {
			for(Observer o : Subject.observers){
				o.update(this.getAllEvents());
			}
		}

		/**
		 * Register a new {@link ui.Observer}
		 * @param observer The {@link ui.Observer} to add
		 */
		public void register(Observer observer) {
			Subject.observers.add(observer);
		}

		/**
		 * Remove an {@link ui.Observer} that is registered
		 * @param observer The {@link ui.Observer} to remove
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
	 * Remove an {@link model.Event} by id
	 * @param id
	 * The id of the {@link model.Event}
	 */
	public void removeEvent(int id){
			this.eventService.removeEvent(id);
			this.notifyObservers();
	}
	
	/**
	 * Get all the {@link model.Event} that are in the {@link model.repository.EventRepository}
	 * @return String all event as JSON 
	 */
	public String getAllEvents(){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getAllEvents());
		return jsonInString; 
	}
	
	/**
	 * Get an {@link model.Event} with a specified id
	 * @param id 
	 * The id of the {@link model.Event}
	 * @return String the event as JSON
	 */
	public String getEventById(int id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getEventById(id));
		return jsonInString; 
	}
	
	/**
	 * Add a new {@link model.Actor}
	 * @param actor
	 * The {@link model.Actor} to be added
	 */
	public void addActor(Actor actor){
		this.actorService.addActor(actor); 
		notifyObservers(); 
	}
	
	/**
	 * Get an {@link model.Actor} by an id
	 * @param id
	 * The id of the {@link model.Actor}
	 * @return String actor in Json
	 * 
	 */
	public String getActor(int id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getActor(id));
		return jsonInString;  
	}
	
	/**
	 * Remove an {@link model.Actor} by and id
	 * @param id
	 * The id of the {@link model.Actor} to remove
	 */
	public void removeActor(int id){
		this.actorService.removeActor(id); 
		notifyObservers(); 
	}
	
}
