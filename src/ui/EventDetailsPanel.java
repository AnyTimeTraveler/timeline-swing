package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Actor;

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
	private String eventsInSpecificYear;
	private GridBagConstraints gbc;  
	
	/**
	 * Initates the {@link eventsInSpecificYear}, sets the {@link java.awt.GridBagConstraints} and {@link java.awt.GridBagLayout}
	 * @param eventsInSpecificYear {@link List}&lt;{@link ui.datasets.timeline}&gt; with the events of one year
	 */
	public EventDetailsPanel(String eventsInSpecificYear){
		super(); 
		this.eventsInSpecificYear = eventsInSpecificYear; 
	 	this.eventTitleLabel = new JLabel("Title");
	 	this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date"); 
		this.eventEndDateLabel = new JLabel("End Date"); 
		this.gbc = new GridBagConstraints(); 
		//GridbagLayout init
		GridBagLayout gbl = new GridBagLayout(); 
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		gbc.weightx = 0.1; 
		
		int i = 0; 
		JsonElement root = new JsonParser().parse(this.eventsInSpecificYear);
		System.out.println(root);
		JsonArray array = root.getAsJsonArray(); 
					for(int index = 0;index< array.size(); index++){
						JsonObject object = array.get(index).getAsJsonObject(); 
						
				    	JPanel panel = new JPanel(); 
						JPanel eventInfoPanel = new JPanel(); 
						JPanel actorsInfoPanel = new JPanel(); 
						eventInfoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
						actorsInfoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
						eventInfoPanel.setBackground(Color.WHITE);
						actorsInfoPanel.setBackground(Color.WHITE);
						
						this.eventTitleLabel = new JLabel(object.get("title").toString());
						eventInfoPanel.add(this.eventTitleLabel, getGridBagConstraints(array.size(), i, 0));
						this.eventDescriptionLabel = new JLabel(object.get("description").toString());
						eventInfoPanel.add(this.eventDescriptionLabel, getGridBagConstraints(array.size(), i, 1));
						this.eventStartDateLabel = new JLabel(object.get("startDate").toString());
						eventInfoPanel.add(this.eventStartDateLabel, getGridBagConstraints(array.size(), i, 2));
						this.eventEndDateLabel = new JLabel(object.get("EndDate").toString()); 
						eventInfoPanel.add(this.eventEndDateLabel, getGridBagConstraints(array.size(), i, 3));
						/*String actorsString = "";  
						for(Actor a : this.actors){
							actorsString = actorsString + ", "+a.name; 	
						}
						actorsInfoPanel.add(new JLabel(actorsString));
						*/
						panel.add(eventInfoPanel); 
						panel.add(actorsInfoPanel);
						
						//Set panel Config
						gbc.fill = GridBagConstraints.HORIZONTAL; 
						gbc.gridy = i; 
						this.add(panel, gbc);
						i++; 
					
					
					
					
					
					
					
					
					
					
					
					}
		}
	
	
	
	private GridBagConstraints getGridBagConstraints(int listSize, int eventIndex, int attributeIndex ){
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 0 + attributeIndex; 
		gbc.gridy = 1+ eventIndex; 
		gbc.weightx = 0.9; 
		
		return gbc; 
	}
	
	
}
