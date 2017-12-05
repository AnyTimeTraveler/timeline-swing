package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class NewEventPanel extends JPanel{

	/**
	 * Label for event title
	 */
	private JLabel eventTitleLabel; 
	/**
	 * Label for event description
	 */
	private JLabel eventDescriptionLabel; 
	/**
	 * Label for event start date
	 */
	private JLabel eventStartDateLabel; 
	/**
	 * Label for event end date
	 */
	private JLabel eventEndDateLabel; 
	/**
	 * Field to enter event title
	 */
	private JTextField eventTitleField; 
	/**
	 * Field to enter event description
	 */
	private JTextField eventDescriptionField; 
	/**
	 * Field to pick an event start date
	 */
	private JDatePickerImpl eventStartDateField; 
	/**
	 * Field to pick an event end date
	 */
	private JDatePickerImpl eventEndDateField; 
	/**
	 * Button to save and add an event
	 */
	private JButton saveEventButton; 
	
	/**
	 * Initialise fields and set config setting
	 */
	public NewEventPanel(){
		super(); 
		this.eventTitleField = new JTextField();
		this.eventDescriptionField = new JTextField();
		this.eventTitleLabel = new JLabel("Title");
		this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date"); 
		this.eventEndDateLabel = new JLabel("End Date"); 
		this.saveEventButton = new JButton("Save"); 
		
		//Initialize datepickers

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		this.eventStartDateField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		model = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		this.eventEndDateField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
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
	
	/**
	 * Add an {@link ActionListener} to the {@link saveEventButton}
	 * @param addButtonActionListener The Action Listener for the {@link saveEventButton}
	 */
	public void addSaveButtonActionListener(ActionListener addButtonActionListener){
		this.saveEventButton.addActionListener(addButtonActionListener); 
	}
	
	/**
	 * Get the title inserted in the {@link eventTitleField}
	 * @return String the title inserted in the {@link eventTitleField} 
	 */
	public String getEventTitle(){
		return this.eventTitleField.getText();
	}

	/**
	 * Get all the data inserted in the form
	 * @return {@link java.util.List}&lt;{@link java.lang.String}, {@link java.lang.String}&gt; with all the fields in the form
	 */
	public Map<String, String> getSaveNewEventData(){
		DateLabelFormatter dlf = new DateLabelFormatter(); 
		Map<String, String> result = new HashMap<String, String>(); 
		result.put("title",this.eventTitleField.getText() ); 
		result.put("description", this.eventDescriptionField.getText()); 
		result.put("startDate", eventStartDateField.getJFormattedTextField().getText()); 
		result.put("endDate", eventStartDateField.getJFormattedTextField().getText()); 
		
		//Clear inserted data from view
		this.eventTitleField.setText("");
		this.eventDescriptionField.setText("");
		this.eventStartDateField.getJFormattedTextField().setText("");
		this.eventEndDateField.getJFormattedTextField().setText("");
		
		//return the Map
		return result; 
	}
}
