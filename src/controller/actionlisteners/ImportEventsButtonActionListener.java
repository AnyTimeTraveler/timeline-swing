
package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class ImportEventsButtonActionListener implements ActionListener {

	/**
	 * The {@link Controller} of the {@link app.App}
	 */
	private Controller controller;
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link app.App}
	 */
	public ImportEventsButtonActionListener(Controller controller){
		this.controller = controller; 
	}
	
	/**
	 * Change to working panel to {@link ui.ImportPanel}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.changeToImportPanel(); 
	}

}
