package ui;

import java.awt.Color;
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
	private String eventsInSpecificYear;
	private GridBagConstraints gbc;

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
		this.eventsInSpecificYear = eventsInSpecificYear;
		this.eventTitleLabel = new JLabel("Title");
		this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date");
		this.eventEndDateLabel = new JLabel("End Date");
		this.gbc = new GridBagConstraints();
		// GridbagLayout init
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		int i = 0;
		JsonElement root = new JsonParser().parse(this.eventsInSpecificYear);
		JsonArray array = root.getAsJsonArray();
		for (int index = 0; index < array.size(); index++) {
			JsonObject object = array.get(index).getAsJsonObject();
			GridBagConstraints gridbagc = new GridBagConstraints();
			GridBagLayout gridBaglay = new GridBagLayout();
			;
			JPanel panel = new JPanel();
			panel.setLayout(gridBaglay);
			this.eventTitleLabel = new JLabel(object.get("title").toString());
			panel.add(this.eventTitleLabel, gridbagc);
			this.eventDescriptionLabel = new JLabel(object.get("description").toString());
			panel.add(this.eventDescriptionLabel, gridbagc);
			String startDate = object.get("startDate").toString().substring(1, object.get("startDate").toString().length() - 12);
			this.eventStartDateLabel = new JLabel(startDate);
			panel.add(this.eventStartDateLabel, gridbagc);
			this.eventEndDateLabel = new JLabel(object.get("EndDate").toString());
			// Get actors by comaring their ids
			JsonElement actors = new JsonParser().parse(actorsJson);
			JsonArray actorsArray = actors.getAsJsonArray();
			for (int j = 0; j < actorsArray.size(); j++) {
				JsonObject actorsObject = actorsArray.get(j).getAsJsonObject();
				
				JsonArray thisActorIdsArray = object.get("actorsIds").getAsJsonArray();
				String relatedActorsString = ""; 
				for (int k = 0; k < thisActorIdsArray.size(); k++) {
					JsonObject thisActorIdsObject = actorsArray.get(k).getAsJsonObject();
					relatedActorsString = relatedActorsString +thisActorIdsObject.get("name").toString()+", "; 
				}
				JLabel relatedActorsLabel = new JLabel(); 
				relatedActorsLabel.setText(relatedActorsString);
				panel.setBorder(new EmptyBorder(20, 20, 20, 20)); 
				panel.setBackground(Color.WHITE);
				panel.add(relatedActorsLabel,gridbagc); 
			}
		
			// Set panel Config
			gbc.gridy = i;
			
			
			this.add(panel, gbc);
			i++;

		}
	}

}
