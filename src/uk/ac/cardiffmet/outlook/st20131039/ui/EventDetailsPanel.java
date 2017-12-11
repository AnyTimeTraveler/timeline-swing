package uk.ac.cardiffmet.outlook.st20131039.ui;

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
	 * GridBagConstraints that define the position of each event in a specific
	 * year
	 */
	private GridBagConstraints gbc;

	/**
	 * Json String of all the events in the chosen year
	 */
	private String eventsInSpecificYear;

	/**
	 * Json String of all the stored actors
	 */
	private String actorsJson;

	/**
	 * Initates the {@link eventsInSpecificYear} and {@link actorsJson} andother
	 * variables.
	 * 
	 * @param eventsInSpecificYear
	 *            Json with events of one year
	 * @param actorsJson
	 *            Json with all the actors in application
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

	/**
	 * Sets Layout and adds components to panel
	 */
	public void init() {

		// Set layout
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		// Parse JSON to Jlabels
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
			relatedActorsString = "";
			JsonObject object = array.get(index).getAsJsonObject();
			GridBagLayout gridBaglay = new GridBagLayout();

			try {
				startDate = object.get("startDate").toString().substring(1,
						object.get("startDate").toString().length() - 12);
			} catch (Exception e) {
				startDate = " - ";
				System.out.println(e.getMessage());

			}
			try {
				endDate = object.get("EndDate").toString().substring(1, object.get("EndDate").toString().length() - 12);
			} catch (Exception e) {
				endDate = " - ";
				System.out.println(e.getMessage());
			}

			try {
				title = object.get("title").toString().substring(1, object.get("title").toString().length() - 1);
			} catch (Exception e) {
				title = " - ";
				System.out.println(e.getMessage());
			}

			try {
				description = object.get("description").toString().substring(1,
						object.get("description").toString().length() - 1);
			} catch (Exception e) {
				description = " - ";
				System.out.println(e.getMessage());
			}

			try {
				actorsInvolvement = object.get("actorsInvolvementDescription").toString().substring(1,
						object.get("actorsInvolvementDescription").toString().length() - 1);
			} catch (Exception e) {
				actorsInvolvement = " - ";
				System.out.println(e.getMessage());
			}
			JsonElement actors = new JsonParser().parse(this.actorsJson);
			JsonArray actorsArray = actors.getAsJsonArray();
			for (int j = 0; j < actorsArray.size(); j++) {
				JsonObject actorsObject = actorsArray.get(j).getAsJsonObject();
				String id1 = actorsObject.get("id").toString();
				String name1 = actorsObject.get("name").toString().substring(1,
						actorsObject.get("name").toString().length() - 1);
				JsonElement thisEventActorsElement = object.get("actorsIds");
				JsonArray thisEventActorsArray = thisEventActorsElement.getAsJsonArray();
				for (int a = 0; a < thisEventActorsArray.size(); a++) {
					String id2 = thisEventActorsArray.get(a).toString();

					if (id1.equals(id2)) {
						relatedActorsString = relatedActorsString + name1 + ", ";
					}
				}

			}

			// Remove last comma
			if (relatedActorsString.length() > 2) {
				relatedActorsString = relatedActorsString.substring(0, relatedActorsString.length() - 2);
			}

			JPanel panel = new JPanel();
			panel.setLayout(gridBaglay);
			panel.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gridbagc = new GridBagConstraints();
			gridbagc.weightx = 1;
			gridbagc.fill = GridBagConstraints.BOTH;
			gridbagc.gridy = 0;
			JLabel dates = new JLabel(startDate + " - " + endDate + "  :  " + title);
			dates.setFont(new Font("Arial", Font.BOLD, 16));
			dates.setBorder(new EmptyBorder(20, 20, 10, 20));
			panel.add(dates, gridbagc);
			gridbagc.gridy = 1;
			JLabel descLabel = new JLabel("Description:  " + description);
			descLabel.setBorder(new EmptyBorder(10, 20, 10, 20));
			panel.add(descLabel, gridbagc);
			gridbagc.gridy = 2;
			JLabel relatedActorsLabel = new JLabel("Actors:  " + relatedActorsString);
			relatedActorsLabel.setBorder(new EmptyBorder(10, 20, 10, 20));
			panel.add(relatedActorsLabel, gridbagc);
			gridbagc.gridy = 3;
			JLabel actorsInvolvementLabel = new JLabel("Involvement Actors:  " + actorsInvolvement);
			actorsInvolvementLabel.setBorder(new EmptyBorder(10, 20, 20, 20));
			panel.add(actorsInvolvementLabel, gridbagc);

			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createLineBorder(new Color(240, 129, 15), 10, false));

			// Set panel Config
			gbc.gridy = i;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1;
			this.add(panel, gbc);

			// Increment loop
			i++;
		}

	}
}
