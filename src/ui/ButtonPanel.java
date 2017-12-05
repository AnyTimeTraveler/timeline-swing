package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class ButtonPanel extends JPanel {

	/**
	 * The color of panel background
	 */
	private Color buttonBackground; 
	/**
	 * Button to navigate to {@link ui.ImportPanel}
	 */
	private JButton importEventsButton; 
	/**
	 * Button to navigate to {@link ui.NewEventPanel}
	 */
	private JButton addEventButton;
	
	/**
	 * Initialise fields and {@link java.awt.GridLayout}
	 */
	public ButtonPanel(){
		super();
		
		this.setBackground(Color.WHITE);
		this.buttonBackground = new Color(29, 84, 173);
		
		GridLayout experimentLayout = new GridLayout(3,0);
		this.setLayout(experimentLayout);
		  
	    this.addEventButton = this.getButton("Add Event");
	    this.add(addEventButton);

	    this.importEventsButton = this.getButton("Import/Export Timeline");
	    this.add(importEventsButton );
	    
	}
	
	/**
	 * Generate a new Button with a speficied name and default styling
	 * @param buttonName The name to display on the button
	 * @return JButton The button with a speficied name and default styling
	 */
	public JButton getButton(String buttonName){
		JButton button = new JButton();
		button.setBackground(this.buttonBackground);
		JLabel label = new JLabel(buttonName); 
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setForeground(Color.white);
		button.add(label);
		return button;
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link importEventsButton}
	 * @param importButtonActionListener The Action Listener for the {@link importEventsButton}
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		this.importEventsButton.addActionListener(importButtonActionListener); 
	}
	/**
	 * Add an {@link ActionListener} to the {@link addEventButton}
	 * @param addNewEventButtonActionListener The Action Listener for the {@link addEventButton}
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener){
		this.addEventButton.addActionListener(addNewEventButtonActionListener); 
	}
	
}
