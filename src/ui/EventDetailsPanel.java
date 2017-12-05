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
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class EventDetailsPanel extends JPanel{

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
	 * {@link List} that stores the events ordered by year
	 */
	private List<Event> eventsInSpecificYear; 
	
	/**
	 * Initates the {@link eventsInSpecificYear}, sets the {@link java.awt.GridBagConstraints} and {@link java.awt.GridBagLayout}
	 * @param eventsInSpecificYear {@link List}&lt;{@link ui.datasets.timeline}&gt; with the events of one year
	 */
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
