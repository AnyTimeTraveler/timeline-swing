package ui;
/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public interface Observer {
/**
 * Updates the View when changes happen in model
 * @param eventsJson Events in JSON format
 */
	void update(String eventsJson, String actorsJson);
	
}
