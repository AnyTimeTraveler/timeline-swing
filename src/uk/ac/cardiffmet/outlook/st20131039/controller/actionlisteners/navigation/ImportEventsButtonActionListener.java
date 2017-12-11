
package uk.ac.cardiffmet.outlook.st20131039.controller.actionlisteners.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class ImportEventsButtonActionListener implements ActionListener {

	/**
	 * The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller;
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public ImportEventsButtonActionListener(Controller controller){
		System.out.println("ImportEventsButtonActionListener");
		this.controller = controller; 
	}
	
	/**
	 * Change to working panel to {@link uk.ac.cardiffmet.outlook.st20131039.ui.ImportPanel}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.changeToImportPanel(); 
	}

}
