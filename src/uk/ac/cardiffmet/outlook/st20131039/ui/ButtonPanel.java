package uk.ac.cardiffmet.outlook.st20131039.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class ButtonPanel extends JPanel {

	/**
	 * The color of panel background
	 */
	private Color buttonBackground;

	/**
	 * Button to navigate to {@link uk.ac.cardiffmet.outlook.st20131039.ui.ImportPanel}
	 */
	private JButton importEventsButton;

	/**
	 * Button to navigate to {@link uk.ac.cardiffmet.outlook.st20131039.ui.NewEventPanel}
	 */
	private JButton addEventButton;

	/**
	 * Button to navigate to {@link uk.ac.cardiffmet.outlook.st20131039.ui.NewActorPanel}
	 */
	private JButton addActorButton;

	/**
	 * Initialise fields and {@link java.awt.GridLayout}
	 */
	public ButtonPanel() {
		super();

		// Color buttons
		this.buttonBackground = new Color(29, 84, 173);

		// Initialise Buttons
		this.addEventButton = this.getButton("Add Event");
		this.importEventsButton = this.getButton("Import/Export Timeline");
		this.addActorButton = this.getButton("Add Actor");

		// Set Background color
		this.setBackground(Color.WHITE);

		// Set layout
		GridLayout layout = new GridLayout(3, 0);
		this.setLayout(layout);

		// Add buttons to layout
		this.add(this.addEventButton);
		this.add(this.importEventsButton);
		this.add(this.addActorButton);
	}

	/**
	 * Generate a new Button with a speficied name and default styling
	 * 
	 * @param buttonName
	 *            The name to display on the button
	 * @return JButton The button with a speficied name and default styling
	 */
	public JButton getButton(String buttonName) {
		//New button
		JButton button = new JButton();
		
		//Set button styles
		button.setBackground(this.buttonBackground);
		
		//Create Label On Button with styles
		JLabel label = new JLabel(buttonName);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setForeground(Color.white);
		
		//Add Label to button
		button.add(label);
		
		//Return button
		return button;
	}

	/**
	 * Add an {@link ActionListener} to the {@link importEventsButton}
	 * 
	 * @param importButtonActionListener
	 *            The Action Listener for the {@link importEventsButton}
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener) {
		this.importEventsButton.addActionListener(importButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link addEventButton}
	 * 
	 * @param addNewEventButtonActionListener
	 *            The Action Listener for the {@link addEventButton}
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener) {
		this.addEventButton.addActionListener(addNewEventButtonActionListener);
	}

	/**
	 * Add an {@link ActionListener} to the {@link addActorButton}
	 * 
	 * @param addActorButtonActionListener
	 *            The Action Listener for the {@link addActorButton}
	 */
	public void addAddActorButtonActionListener(ActionListener addActorButtonActionListener) {
		this.addActorButton.addActionListener(addActorButtonActionListener);
	}
}
