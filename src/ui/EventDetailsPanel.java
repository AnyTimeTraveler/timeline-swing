package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
			this.eventTitleLabel = new JLabel(e.title);
			this.add(this.eventTitleLabel, getGridBagConstraints(this.eventsInSpecificYear.size(), i, 0));
			this.eventDescriptionLabel = new JLabel(e.description);
			this.add(this.eventDescriptionLabel, getGridBagConstraints(this.eventsInSpecificYear.size(), i, 1));
			this.eventStartDateLabel = new JLabel(dateFormatter.format(e.startDate));
			this.add(this.eventStartDateLabel, getGridBagConstraints(this.eventsInSpecificYear.size(), i, 2));
			this.eventEndDateLabel = new JLabel(dateFormatter.format(e.EndDate)); 
			this.add(this.eventEndDateLabel, getGridBagConstraints(this.eventsInSpecificYear.size(), i, 3));
			i++; 
	}
	}
	
	private GridBagConstraints getGridBagConstraints(int listSize, int eventIndex, int attributeIndex ){
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.fill = GridBagConstraints.BOTH; 
		gbc.gridx = 0 + attributeIndex; 
		gbc.gridy = 0+eventIndex; 
		return gbc; 
	}
	
	
}
