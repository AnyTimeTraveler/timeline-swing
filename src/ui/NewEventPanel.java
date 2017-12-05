package ui;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ui.datasets.actor.Actor;

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
	 * {@link List} of all {@link ui.datasets.Actor}
	 */
	private List<Actor> actors; 
	/**
	 * Initialise fields and set config setting
	 */
	public NewEventPanel(List<Actor> actors){
		super(); 
		this.eventTitleField = new JTextField(30);
		this.eventDescriptionField = new JTextField(30);
		this.eventTitleLabel = new JLabel("Title");
		this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date"); 
		this.eventEndDateLabel = new JLabel("End Date"); 
		this.saveEventButton = new JButton("Save"); 
		this.actors = actors; 
		
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
		System.out.println("ACTORS = "+this.actors);
		String[] actorsArray = getActorNames(this.actors);   
		   JList list = new JList(actorsArray);
		   list.setSelectionModel(new DefaultListSelectionModel() {
			    @Override
			    public void setSelectionInterval(int index0, int index1) {
			        if(super.isSelectedIndex(index0)) {
			            super.removeSelectionInterval(index0, index1);
			        }
			        else {
			            super.addSelectionInterval(index0, index1);
			        }
			    }
			});
           int[] select = {19, 20, 22};
           list.setSelectedIndices(select);
          
		this.add(new JScrollPane(list)); 
	}	
	
	private String[] getActorNames(List<Actor> actorList){
		String[] result= new String[actorList.size()];
		int i = 0; 
		for(Actor a : actorList){
			result[i] = a.name; 
			i++; 
		}
		return result; 
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
	
	public void setActors(List<Actor> actors){
		this.actors = actors; 
	}
}
