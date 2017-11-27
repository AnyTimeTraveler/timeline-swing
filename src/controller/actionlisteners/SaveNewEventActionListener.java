package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import controller.Controller;
import model.service.EventService;
import model.Event;

public class SaveNewEventActionListener extends Controller implements ActionListener {

	private JTextField eventTitleField;  
	private JTextField eventDescriptionField; 
	private JTextField eventStartDateField; 
	private JTextField eventEndDateField; 
	
	public SaveNewEventActionListener(JTextField eventTitleField, JTextField eventDescriptionField,JTextField eventStartDateField,  JTextField eventEndDateField){
		this.eventTitleField = eventTitleField; 
		this.eventDescriptionField = eventDescriptionField; 
		this.eventStartDateField = eventStartDateField; 
		this.eventEndDateField = eventEndDateField; 
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { 
		String title = this.eventTitleField.getText(); 
		String description = this.eventDescriptionField.getText(); 
		String startDate = this.eventStartDateField.getText(); 
		String endDate = this.eventEndDateField.getText();
		super.eventService.addEvent(title, description, startDate, endDate); 
	}

}
