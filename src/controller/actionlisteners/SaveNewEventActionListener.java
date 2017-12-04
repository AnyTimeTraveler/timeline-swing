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
		//test
		this.controller.addEvent("Niewetitle", "DXFHCGJVHKBNK", new Date(), new Date());
		System.out.println("Nieuwe toegevoedg");
		/*
		String title = this.eventTitleField.getText(); 
		String description = this.eventDescriptionField.getText(); 
		String startDate = this.eventStartDateField.getText(); 
		String endDate = this.eventEndDateField.getText();
		controller.addEvent(title, description, new Date(), new Date()); 
		*/
	}

}
