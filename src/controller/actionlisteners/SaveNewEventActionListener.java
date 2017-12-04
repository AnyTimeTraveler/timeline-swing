package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import controller.Controller;

public class SaveNewEventActionListener implements ActionListener {

	private Controller controller; 
	
	public SaveNewEventActionListener(Controller controller){
		this.controller = controller; 
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { 
		this.controller.saveNewEvent();
	}

}
