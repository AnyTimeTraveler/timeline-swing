
package uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class SaveNewEventActionListener implements ActionListener {

	/**
	 * The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller; 
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public SaveNewEventActionListener(Controller controller){
		this.controller = controller; 
	}
	
	/**
	 * Save a new event
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) { 
		this.controller.saveNewEvent();
	}

}
