
package controller.actionlisteners.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class AddEventButtonActionListener implements ActionListener {

	/**
	 * The {@link Controller} of the {@link app.App}
	 */
	private Controller controller;  
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link app.App}
	 */
	public AddEventButtonActionListener(Controller controller){
		System.out.println("AddEventButtonActionListener");
		this.controller = controller; 
	}
	
	/**
	 * Change the working panel to {@link ui.NewEventPanel}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.changeToAddNewEventPanel();
	}

}
