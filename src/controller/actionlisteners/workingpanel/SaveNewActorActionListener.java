package controller.actionlisteners.workingpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class SaveNewActorActionListener implements ActionListener{

	private Controller controller; 
	
	public SaveNewActorActionListener(Controller controller){
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("SaveNewActorActionListener");
		this.controller.saveNewActor(); 
	}

	
	
}
