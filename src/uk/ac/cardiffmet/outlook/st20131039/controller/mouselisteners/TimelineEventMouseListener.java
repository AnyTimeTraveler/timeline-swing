
package uk.ac.cardiffmet.outlook.st20131039.controller.mouselisteners;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import uk.ac.cardiffmet.outlook.st20131039.controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class TimelineEventMouseListener implements MouseListener   {

	/**
	 * The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	private Controller controller; 
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link uk.ac.cardiffmet.outlook.st20131039.app.App}
	 */
	public TimelineEventMouseListener(Controller controller){
		this.controller = controller; 
	}

	
	/**
	 * Nothing implemented on mouse exit event
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	/**
	 * Nothing implemented on mouse exit event
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	/**
	 * Nothing implemented on momuse pressed event
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	/**
	 * Nothing implemented on mouse released event
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	/**
	 * Open {@link uk.ac.cardiffmet.outlook.st20131039.ui.EventDetailsPanel} on click on certain coordinates on {@link uk.ac.cardiffmet.outlook.st20131039.ui.TimelinePanel}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.openEventDetailsPanel(e.getX(), e.getY()); 
	}
	
	
	
}
