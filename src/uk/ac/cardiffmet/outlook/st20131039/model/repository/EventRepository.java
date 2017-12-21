package uk.ac.cardiffmet.outlook.st20131039.model.repository;

import java.util.List;
import java.util.Map;

import uk.ac.cardiffmet.outlook.st20131039.model.Event;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public interface EventRepository {

	/**
	 * Get all the stored events
	 * 
	 * @return {@link List}&lt;{@link uk.ac.cardiffmet.outlook.st20131039.model.Event}&gt;
	 */
	public Map<Integer, List<Event>> getEvents();

	/**
	 * Add a new event
	 * 
	 * @param event
	 *            The new event to add
	 */
	public void addEvent(Event event);

	/**
	 * Remove the event with the specified id
	 * 
	 * @param id String
	 *            The id of the event to remove
	 */
	public void removeEvent(String id);

	/**
	 * Get the event with the specified id
	 * 
	 * @param id String
	 *            The id of the event to get
	 * @return Event The event with the specified id
	 */
	public Event getEvent(String id);

	/**
	 * Add events to the repo
	 * @param events Map with key year and value a List of Event
	 */
	public void addEvents(Map<Integer, List<Event>> events);

	/**
	 * Get all the events in a specific year
	 * @param year year
	 * @return List of Events in a specific year
	 */
	public List<Event> getEventsByYear(int year);
}
