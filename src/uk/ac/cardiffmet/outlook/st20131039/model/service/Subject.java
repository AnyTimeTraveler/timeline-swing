package uk.ac.cardiffmet.outlook.st20131039.model.service;

import java.util.ArrayList;
import java.util.List;

import uk.ac.cardiffmet.outlook.st20131039.ui.Observer;

/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public interface Subject {
	/**
	 * {@link List} of {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} 
	 */
	public static List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Update all the registered {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer}
	 */
	public void notifyObservers() ;
	/**
	 * Register a new {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer}
	 * @param observer The {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} to add
	 */
	public void register(Observer observer) ;

	/**
	 * Remove an {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} that is registered
	 * @param observer The {@link uk.ac.cardiffmet.outlook.st20131039.ui.Observer} to remove
	 */
	public void removeRegister(Observer observer) ;
	
}
