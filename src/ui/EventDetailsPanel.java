package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class EventDetailsPanel extends JPanel {

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
	private GridBagConstraints gbc;

	private String eventsInSpecificYear; 
	private String actorsJson; 
	
	/**
	 * Initates the {@link eventsInSpecificYear}, sets the
	 * {@link java.awt.GridBagConstraints} and {@link java.awt.GridBagLayout}
	 * 
	 * @param eventsInSpecificYear
	 *            {@link List}&lt;{@link ui.datasets.timeline}&gt; with the
	 *            events of one year
	 */
	
	public EventDetailsPanel(String eventsInSpecificYear, String actorsJson) {
		super();
		this.eventTitleLabel = new JLabel("Title");
		this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date");
		this.eventEndDateLabel = new JLabel("End Date");
		this.gbc = new GridBagConstraints();
		this.eventsInSpecificYear = eventsInSpecificYear; 
		this.actorsJson = actorsJson; 
	}

	public void init() {

		//Set layout
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		int i = 0;
		JsonElement root = new JsonParser().parse(this.eventsInSpecificYear);
		JsonArray array = root.getAsJsonArray();
		String detailLine = ""; 
		String startDate = ""; 
		String endDate = ""; 
		String title = ""; 
		String description = ""; 
		String relatedActorsString = "";
		String actorsInvolvement = ""; 
		for (int index = 0; index < array.size(); index++) {
			JsonObject object = array.get(index).getAsJsonObject();
			GridBagLayout gridBaglay = new GridBagLayout();
			startDate = object.get("startDate").toString().substring(1,
					object.get("startDate").toString().length() - 12);
			endDate = object.get("EndDate").toString().substring(1,
					object.get("EndDate").toString().length() - 12);
			
			title = object.get("title").toString().substring(1,
					object.get("title").toString().length() - 1);
			description = object.get("description").toString().substring(1,
					object.get("description").toString().length() - 1);
	
			
			JsonElement actors = new JsonParser().parse(this.actorsJson);
			JsonArray actorsArray = actors.getAsJsonArray();
			for (int j = 0; j < actorsArray.size(); j++) {
				JsonObject actorsObject = actorsArray.get(j).getAsJsonObject();

				JsonArray thisActorIdsArray = object.get("actorsIds").getAsJsonArray();
				
				for (int k = 0; k < thisActorIdsArray.size(); k++) {
			
					JsonObject thisActorIdsObject = actorsArray.get(k).getAsJsonObject();
					if(thisActorIdsObject.get("name").toString().equals(actorsObject.get("name").toString())){
						String properName = thisActorIdsObject.get("name").toString().substring(1,
								thisActorIdsObject.get("name").toString().length() - 1);

						relatedActorsString = relatedActorsString + properName + ", ";	
					}
				}			
			}
			JPanel panel = new JPanel();
			panel.setLayout(gridBaglay);
			panel.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gridbagc = new GridBagConstraints();
			gridbagc.weightx = 1; 
			gridbagc.fill = GridBagConstraints.BOTH;
			gridbagc.gridy = 0; 
			JLabel dates = new JLabel(startDate + " - "+endDate+ "  :  "+title);
			dates.setFont(new Font("Arial", Font.BOLD, 16));
			dates.setBorder(new EmptyBorder(20, 20, 10, 20)); 
			panel.add(dates, gridbagc);
			gridbagc.gridy = 1;  
			JLabel descLabel = new JLabel("Description:  "+description); 
			descLabel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
			panel.add(descLabel, gridbagc);
			gridbagc.gridy = 2; 
			JLabel relatedActorsLabel = new JLabel("Actors:  "+relatedActorsString);
			relatedActorsLabel.setBorder(new EmptyBorder(10, 20, 10, 20)); 
			panel.add(relatedActorsLabel, gridbagc);
			gridbagc.gridy = 3; 
			JLabel actorsInvolvementLabel = new JLabel("Involvement Actors:  "+actorsInvolvement);
			actorsInvolvementLabel.setBorder(new EmptyBorder(10, 20, 20, 20)); 
			panel.add(actorsInvolvementLabel, gridbagc);
			
		
			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createLineBorder(new Color (240, 129, 15), 10, false)); 
			// Set panel Config
			gbc.gridy = i;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1; 
			this.add(panel, gbc);
			i++;

		}

	}

}
