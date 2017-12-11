package uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.workingpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;

public class SaveNewActorActionListener implements ActionListener{

	/**
	 * The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller; 
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public SaveNewActorActionListener(Controller controller){
		this.controller = controller;
	}
	
	/**
	 * Download the Json through the controller
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.controller.saveNewActor(); 
	}

	
	
}
