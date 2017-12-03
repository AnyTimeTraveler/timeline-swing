package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controller.Controller;
import ui.NewEventPanel;

public class SaveNewEventActionListener implements ActionListener {

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
		NewEventPanel j = (NewEventPanel) arg0.getSource();
		System.out.println(j.getEventTitle());; 
		//super.addEvent(title, description, startDate, endDate); 
	}

}
