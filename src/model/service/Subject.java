package model.service;

import java.util.ArrayList;
import java.util.List;

import ui.Observer;

/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public interface Subject {
	/**
	 * {@link List} of {@link ui.Observer} 
	 */
	public static List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Update all the registered {@link ui.Observer}
	 */
	public void notifyObservers() ;
	/**
	 * Register a new {@link ui.Observer}
	 * @param observer The {@link ui.Observer} to add
	 */
	public void register(Observer observer) ;

	/**
	 * Remove an {@link ui.Observer} that is registered
	 * @param observer The {@link ui.Observer} to remove
	 */
	public void removeRegister(Observer observer) ;
	
}
