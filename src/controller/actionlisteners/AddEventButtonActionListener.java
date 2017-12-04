package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class AddEventButtonActionListener implements ActionListener {

	private Controller controller;  
	
	public AddEventButtonActionListener(Controller controller){
		this.controller = controller; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.changeToAddNewEventPanel();
	}

}
