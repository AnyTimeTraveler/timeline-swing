package ui.datasets.timeline;

import java.util.Date;
import java.util.List;

import ui.datasets.timeline.Event;
import ui.datasets.actor.Actor;
/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class Event{

	/**
	 * List of {@link ui.datasets.actor}
	 */
	public List<Actor> actors;
	/**
	 * Title of Event
	 */
	public String title; 
	/**
	 * Description of event
	 */
	public String description;
	/**
	 * Id of the event
	 */
	public String id;
	/**
	 * Start date of event
	 */
	public Date startDate;
	/**
	 * end date of event
	 */
	public Date EndDate; 
}
