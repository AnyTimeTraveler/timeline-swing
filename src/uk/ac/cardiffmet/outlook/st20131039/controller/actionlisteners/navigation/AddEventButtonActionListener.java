
package uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class AddEventButtonActionListener implements ActionListener {

	/**
	 * The {@link Controller} of the
	 * {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller;

	/**
	 * Assign parameter to Controller
	 * 
	 * @param controller
	 *            The {@link Controller} of the
	 *            {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public AddEventButtonActionListener(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Change the working panel to
	 * {@link uk.ac.cardiffmet.outlook.st20131039.ui.NewEventPanel}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.changeToAddNewEventPanel();
	}

}
