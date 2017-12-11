package uk.ac.cardiffmet.outlook.st20131039.ui;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public interface Observer {

	/**
	 * Updates the View when changes happen in model
	 * 
	 * @param eventsJson
	 *            events in Json format
	 * @param actorsJson
	 *            actors in Json format
	 */
	void update(String eventsJson, String actorsJson);

}
