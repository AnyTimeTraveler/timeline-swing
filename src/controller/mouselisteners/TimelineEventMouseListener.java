package controller.mouselisteners;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.Controller;

public class TimelineEventMouseListener implements MouseListener   {

	private Controller controller; 
	
	public TimelineEventMouseListener(Controller controller){
		this.controller = controller; 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		controller.colorRectangleWithcoordinates(); 
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		controller.openEventDetailsPanel(e.getX(), e.getY()); 
	}
	
	
	
}
