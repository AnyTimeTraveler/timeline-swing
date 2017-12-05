
package controller.mouselisteners;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.Controller;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class TimelineEventMouseListener implements MouseListener   {

	/**
	 * The {@link Controller} of the {@link App}
	 */
	private Controller controller; 
	
	/**
	 * Assign parameter to Controller
	 * @param controller The {@link Controller} of the {@link app.App}
	 */
	public TimelineEventMouseListener(Controller controller){
		this.controller = controller; 
	}

	
	/**
	 * Color rectangle with specified coordinates on hover 
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		controller.colorRectangleWithcoordinates(); 
	}

	/**
	 * Nothing implemented on mouse exit event
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Nothing implemented on momuse pressed event
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Nothing implemented on mouse released event
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Open {@link ui.EventDetailsPanel} on click on certain coordinates on {@link ui.TimelinePanel}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.openEventDetailsPanel(e.getX(), e.getY()); 
	}
	
	
	
}
