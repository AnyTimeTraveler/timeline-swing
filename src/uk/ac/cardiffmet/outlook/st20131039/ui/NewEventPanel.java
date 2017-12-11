package uk.ac.cardiffmet.outlook.st20131039.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.DefaultListModel;
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

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class NewEventPanel extends JPanel {

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
	 * Label to hold actors info
	 */
	private JLabel actorsLabel;

	/**
	 * JList to display actor names
	 */
	private JList list;

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
	 * Json of all the Actors
	 */
	private String actors;

	/**
	 * Field to enter description about actors' involvement
	 */
	private JTextField actorsDescriptionField;

	/**
	 * Label to {@link actorsDescriptionField}
	 */
	private JLabel actorsDescriptionLabel;

	/**
	 * Initialise fields and set config setting
	 */
	public NewEventPanel(String actors) {
		super();
		this.eventTitleField = new JTextField();
		this.eventDescriptionField = new JTextField();
		this.eventTitleLabel = new JLabel("Title");
		this.eventDescriptionLabel = new JLabel("Description");
		this.eventStartDateLabel = new JLabel("Start Date");
		this.eventEndDateLabel = new JLabel("End Date");
		this.saveEventButton = new JButton("Save");
		this.actorsLabel = new JLabel("Select actors you want to add to the event");
		this.actorsDescriptionLabel = new JLabel("Enter info about these actors' involvement");
		this.actorsDescriptionField = new JTextField();
		this.actors = actors;

		// Initialize datepickers

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

		// Initialise JList
		String[] actorsArray = getActorNames(this.actors);
		list = new JList(actorsArray);
		list.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void setSelectionInterval(int index0, int index1) {
				if (super.isSelectedIndex(index0)) {
					super.removeSelectionInterval(index0, index1);
				} else {
					super.addSelectionInterval(index0, index1);
				}
			}
		});

		// Set Layout to panel
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		// Define constraints & add components
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(this.eventTitleLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.eventTitleField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.eventDescriptionLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(this.eventDescriptionField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.eventStartDateLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.eventStartDateField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(this.eventEndDateLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(this.eventEndDateField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(this.saveEventButton, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(this.actorsLabel, gbc);

		gbc.gridy = 1;
		this.add(new JScrollPane(list), gbc);

		gbc.gridy = 2;
		this.add(this.actorsDescriptionLabel, gbc);

		gbc.gridy = 3;
		this.add(this.actorsDescriptionField, gbc);
	}

	/**
	 * Transform Json of actors to Array of actorNames
	 * 
	 * @param actorList
	 *            Json of all Actors
	 * @return String[] array of actornames
	 */
	private String[] getActorNames(String actorList) {
		JsonElement root = new JsonParser().parse(actorList);
		JsonElement actorsJsonElement = root.getAsJsonArray();

		String[] result = new String[root.getAsJsonArray().size()];
		for (int index = 0; index < root.getAsJsonArray().size(); index++) {
			result[index] = actorsJsonElement.getAsJsonArray().get(index).getAsJsonObject().get("name").getAsString();
		}
		return result;
	}

	/**
	 * Add an {@link ActionListener} to the {@link saveEventButton}
	 * 
	 * @param addButtonActionListener
	 *            The Action Listener for the {@link saveEventButton}
	 */
	public void addSaveButtonActionListener(ActionListener addButtonActionListener) {
		this.saveEventButton.addActionListener(addButtonActionListener);
	}

	/**
	 * Get the title inserted in the {@link eventTitleField}
	 * 
	 * @return String the title inserted in the {@link eventTitleField}
	 */
	public String getEventTitle() {
		return this.eventTitleField.getText();
	}

	/**
	 * Get all the data inserted in the form
	 * 
	 * @return {@link java.util.List}&lt;{@link java.lang.String},
	 *         {@link java.lang.String}&gt; with all the fields in the form
	 */
	public Map<String, String> getSaveNewEventData() {
		// New DateLabelFormatter
		DateLabelFormatter dlf = new DateLabelFormatter();

		// Put all fields in Map
		Map<String, String> result = new HashMap<String, String>();
		result.put("title", this.eventTitleField.getText());
		result.put("description", this.eventDescriptionField.getText());
		result.put("startDate", eventStartDateField.getJFormattedTextField().getText());
		result.put("endDate", eventStartDateField.getJFormattedTextField().getText());
		result.put("actorsInvolvement", this.actorsDescriptionField.getText());
		result.put("actorsIds", list.getSelectedValuesList().toString());

		// return the Map
		return result;
	}

	/**
	 * Set new actors on the class variable and on the JList
	 * 
	 * @param actors
	 */
	public void setActors(String actors) {
		// Set class variable
		this.actors = actors;

		// Set new actors in JList
		DefaultListModel listModel = new DefaultListModel();
		String[] actorsArray = getActorNames(actors);
		for (int i = 0; i < actorsArray.length; i++) {
			listModel.addElement(actorsArray[i]);
		}

		// Update JList
		this.list.setModel(listModel);
	}

	/**
	 * Clear all fields in Panel
	 */
	public void clearNewEventFields() {
		this.actorsDescriptionField.setText("");
		this.eventTitleField.setText("");
		this.eventDescriptionField.setText("");
		this.eventStartDateField.getJFormattedTextField().setText("");
		this.eventEndDateField.getJFormattedTextField().setText("");
	}

}
