package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.actionlisteners.AddEventButtonActionListener;
import controller.actionlisteners.SaveNewEventActionListener;

public class NewEventPanel extends JPanel{

	JLabel eventTitleLabel; 
	JLabel eventDescriptionLabel; 
	JLabel eventStartDateLabel; 
	JLabel eventEndDateLabel; 
	
	JTextField eventTitleField;  
	JTextField eventDescriptionField; 
	//TODO implement date picker
	JTextField eventStartDateField; 
	JTextField eventEndDateField; 
	
	JButton saveEventButton; 
	
	public NewEventPanel(){
		super(); 
		this.eventTitleField = new JTextField();
		this.eventDescriptionField = new JTextField();
		this.eventStartDateField = new JTextField();
		this.eventEndDateField = new JTextField();
		
		this.eventTitleLabel = new JLabel("Title");
		this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date"); 
		this.eventEndDateLabel = new JLabel("End Date"); 
		
		this.saveEventButton = new JButton("Save"); 
		this.saveEventButton.addActionListener(new SaveNewEventActionListener(this.eventTitleField, this.eventDescriptionField, this.eventStartDateField, this.eventEndDateField));
		
		
		//GridbagLayout init
		GridBagLayout gbl = new GridBagLayout(); 
		GridBagConstraints gbc = new GridBagConstraints(); 
		this.setLayout(gbl);
		gbc.anchor = GridBagConstraints.WEST;

		gbc.fill = GridBagConstraints.BOTH; 
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		gbc.weightx = 0.3; 
		gbc.weighty = 1;
		this.add(this.eventTitleLabel, gbc); 
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 1; 
		gbc.weightx = 0.7; 
		this.add(this.eventTitleField, gbc);
		gbc.fill = GridBagConstraints.BOTH; 
		gbc.gridx = 0; 
		gbc.gridy = 1; 
		gbc.weightx = 0.3; 
		this.add(this.eventDescriptionLabel, gbc); 
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 1;
		gbc.weightx = 0.7; 
		this.add(this.eventDescriptionField, gbc); 
		gbc.fill = GridBagConstraints.BOTH; 
		gbc.gridx = 0; 
		gbc.gridy = 2; 
		gbc.weightx = 0.3; 
		this.add(this.eventStartDateLabel, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 1;
		gbc.weightx = 0.7; 
		this.add(this.eventStartDateField, gbc);
		gbc.fill = GridBagConstraints.BOTH; 
		gbc.gridx = 0; 
		gbc.gridy = 3; 
		gbc.weightx = 0.3; 
		this.add(this.eventEndDateLabel, gbc); 
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 1;
		gbc.weightx = 0.7; 
		this.add(this.eventEndDateField, gbc); 
		gbc.fill = GridBagConstraints.NONE; 
		gbc.gridy = 4;
		gbc.gridx = 0;
		
		this.add(this.saveEventButton, gbc);
		
	}	
	
	public String getEventTitle(){
		return this.eventTitleField.getText();
	}
	
}
