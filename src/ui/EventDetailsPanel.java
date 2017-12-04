package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import ui.datasets.timeline.Event;

public class EventDetailsPanel extends JPanel{

	private JLabel eventTitleLabel; 
	private JLabel eventDescriptionLabel; 
	private JLabel eventStartDateLabel; 
	private JLabel eventEndDateLabel; 
	private List<Event> eventsInSpecificYear; 
	
	public EventDetailsPanel(List<Event> eventsInSpecificYear){
		super(); 
		this.eventsInSpecificYear = eventsInSpecificYear; 
	 	this.eventTitleLabel = new JLabel("Title");
	 	this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date"); 
		this.eventEndDateLabel = new JLabel("End Date"); 
			//GridbagLayout init
			GridBagLayout gbl = new GridBagLayout(); 
			GridBagConstraints gbc = new GridBagConstraints(); 
			this.setLayout(gbl);
			
		int i = 0; 
		for(Event e : eventsInSpecificYear){
			this.eventTitleLabel = new JLabel(e.title);
			//this.eventDescriptionLabel = new JLabel(e.description);
			//this.eventStartDateLabel = new JLabel(e.startDate);
			//this.eventEndDateLabel = new JLabel(e.EndDate); 
			gbc.gridx = 0; 
			gbc.gridy = 0+i; 
			this.add(this.eventTitleLabel, gbc);
			i++; 
		}
	}
	
	
	
}
