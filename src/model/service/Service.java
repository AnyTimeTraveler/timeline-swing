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
	
	 private static Service instance;
	    
	/**
	 * Initializes new services
	 */
	private Service(){
		/* Initialises a new ActorService */
		this.actorService = new ActorService("memory"); 
		/* Initialises a new ActorService */
		this.eventService = new EventService("memory"); 
	}
	
	public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }
	
	
	
	/**
	 * Update all the registered {@link ui.Observer}
	 */
		public void notifyObservers() {
			for(Observer o : Subject.observers){
				o.update(this.getAllEvents(), this.getAllActors());
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
	public void addEvent(String title, String description, Date startDate, Date endDate, String[] actors, String actorsInvolvementDescription ){
		String[] actorIds = this.actorService.getActorIds(actors); 	
		this.eventService.addEvent(title, description, startDate, endDate, actorIds, actorsInvolvementDescription);
			this.notifyObservers();
		}
		
	/**
	 * Remove an {@link model.Event} by id
	 * @param id
	 * The id of the {@link model.Event}
	 */
	public void removeEvent(String id){
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
	public String getEventById(String id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getEventById(id));
		return jsonInString; 
	}
	
	/**
	 * Add a new {@link model.Actor}
	 * @param actor
	 * The {@link model.Actor} to be added
	 */
	public void addActor(String actor){
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
	public String getActor(String id){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getActor(id));
		return jsonInString;  
	}
	
	public String getAllActors(){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getAllActors());
		System.out.println("JSON = "+jsonInString);
		return jsonInString; 
	}
	
	/**
	 * Remove an {@link model.Actor} by and id
	 * @param id
	 * The id of the {@link model.Actor} to remove
	 */
	public void removeActor(String id){
		this.actorService.removeActor(id); 
		notifyObservers(); 
	}
	
	/**
	 * Replace by new events
	 * @param eventsInJson Events to add in JSON format
	 */
	public void addEvents(String eventsInJson){
		this.eventService.addEvents(eventsInJson);
		this.notifyObservers();
	}
	
	public void addActors(String actors){
		this.actorService.addActors(actors);
		this.notifyObservers();
	}
	
	public String getEventsByYear(int year){
		return this.eventService.getEventsByYear(year);   
	}
}
