package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.service.EventService;
import ui.View;

public class SaveNewEventActionListener implements ActionListener {

	private View view; 
	private EventService eventService; 
	
	public SaveNewEventActionListener(View view, EventService eventService){
		this.view = view; 
		this.eventService = eventService;  
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { 
		/*
		 String title = this.eventTitleField.getText(); 
		String description = this.eventDescriptionField.getText(); 
		String startDate = this.eventStartDateField.getText(); 
		String endDate = this.eventEndDateField.getText();
		controller.addEvent(title, description, new Date(), new Date()); 
		*/
	}

}
