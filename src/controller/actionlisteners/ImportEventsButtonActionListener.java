package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class ImportEventsButtonActionListener implements ActionListener {

	private Controller controller;
	
	public ImportEventsButtonActionListener(Controller controller){
		this.controller = controller; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.changeToImportPanel(); 
	}

}
