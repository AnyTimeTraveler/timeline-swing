/**
* @author  Jeroen Vandevenne
* @version 1.0
*/

package uk.ac.cardiffmet.outlook.st20131039.model.service;

import java.util.Date;

import com.google.gson.Gson;

import uk.ac.cardiffmet.outlook.st20131039.model.Actor;
import uk.ac.cardiffmet.outlook.st20131039.ui.Observer;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class Service implements Subject {

	/**
	 * The ActorService
	 */
	private ActorService actorService;
	/**
	 * The EventService
	 */
	private EventService eventService;

	/**
	 * Instance of {@link Service} used in Singleton
	 */
	private static Service instance;

	/**
	 * Initializes new services
	 */
	private Service() {

		// Initialises a new ActorService
		this.actorService = new ActorService("memory");

		// Initialises a new ActorService
		this.eventService = new EventService("memory");
	}

	/**
	 * Get instance of this class, Singleton pattern
	 * 
	 * @return Service one instace of Service
	 */
	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	/**
	 * Update all the registered {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer}
	 */
	public void notifyObservers() {
		for (Observer o : Subject.observers) {
			o.update(this.getAllEvents(), this.getAllActors());
		}
	}

	/**
	 * Register a new {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer}
	 * 
	 * @param observer
	 *            The {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} to add
	 */
	public void register(Observer observer) {
		Subject.observers.add(observer);
	}

	/**
	 * Remove an {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} that is registered
	 * 
	 * @param observer
	 *            The {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} to remove
	 */
	public void removeRegister(Observer observer) {
		for (int i = 0; i < Subject.observers.size(); i++) {
			if (Subject.observers.get(i) == observer) {
				Subject.observers.remove(i);
			}
		}
	}

	/**
	 * Add new event
	 * 
	 * @param title
	 *            The title of the event
	 * @param description
	 *            The description of the event
	 * @param startDate
	 *            The start date of event
	 * @param endDate
	 *            The end date of event
	 * @param actors
	 *            the Actors in array
	 * @param actorsInvolvementDescription
	 *            the involvement of the actors
	 */
	public void addEvent(String title, String description, Date startDate, Date endDate, String[] actors,
			String actorsInvolvementDescription) {
		String[] actorIds = this.actorService.getActorIds(actors);
		this.eventService.addEvent(title, description, startDate, endDate, actorIds, actorsInvolvementDescription);
		this.notifyObservers();
	}

	/**
	 * Remove an Event by id
	 * 
	 * @param id
	 *            The id of the {@link uk.ac.cardiffmet.outlook.st20131039.model.Event}
	 */
	public void removeEvent(String id) {
		this.eventService.removeEvent(id);
		this.notifyObservers();
	}

	/**
	 * Get all the events in Json in the Repository
	 * 
	 * @return String all event as JSON
	 */
	public String getAllEvents() {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getAllEvents());
		return jsonInString;
	}

	/**
	 * Get an event in Json with a specified id
	 * 
	 * @param id
	 *            The id of the Event
	 * @return String the event as JSON
	 */
	public String getEventById(String id) {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.eventService.getEventById(id));
		return jsonInString;
	}

	/**
	 * Add a new actor
	 * 
	 * @param actor
	 *            Json actor
	 */
	public void addActor(String actor) {
		this.actorService.addActor(actor);
		notifyObservers();
	}

	/**
	 * Get an actor by id
	 * 
	 * @param id
	 *            The id of the actor
	 * @return String the Actor in Json
	 * 
	 */
	public String getActor(String id) {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getActor(id));
		return jsonInString;
	}

	/**
	 * Get all the actors in Json
	 * 
	 * @return all the actors in Json
	 */
	public String getAllActors() {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this.actorService.getAllActors());
		System.out.println("JSON = " + jsonInString);
		return jsonInString;
	}

	/**
	 * Remove an actor by and id
	 * 
	 * @param id
	 *            The id of the actor to remove
	 */
	public void removeActor(String id) {
		this.actorService.removeActor(id);
		notifyObservers();
	}

	/**
	 * Replace by new events
	 * 
	 * @param eventsInJson
	 *            Events to add in JSON format
	 */
	public void addEvents(String eventsInJson) {
		this.eventService.addEvents(eventsInJson);
		this.notifyObservers();
	}

	/**
	 * Replace current actors by new actors
	 * 
	 * @param actors
	 *            Json actors to import
	 */
	public void addActors(String actors) {
		this.actorService.addActors(actors);
		this.notifyObservers();
	}

	/**
	 * Get all events in a specified year
	 * 
	 * @param year
	 *            in which we want all the events
	 * @return Json of all events in the specified year
	 */
	public String getEventsByYear(int year) {
		return this.eventService.getEventsByYear(year);
	}
}
