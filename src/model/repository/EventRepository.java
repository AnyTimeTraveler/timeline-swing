package model.repository;

import java.util.List;

import model.Event;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public interface EventRepository {
	/**
	 * Get all the stored events
	 * @return {@link List}&lt;{@link model.Event}&gt;
	 */
	public List<Event> getEvents(); 
	/**
	 * Add a new event
	 * @param event The new event to add
	 */
	public void addEvent(Event event);
	/**
	 * Remove the event with the specified id
	 * @param id The id of the event to remove
	 */
	public void removeEvent(int id);
	/**
	 * Get the event with the specified id
	 * @param id The id of the event to get
	 * @return Event The event with the specified id
	 */
	public Event getEvent(int id);
}

