package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel {

	private Color buttonBackground; 
	private JButton importEventsButton; 
	private JButton addEventButton;
	
	
	public ButtonPanel(){
		super();
		
		this.setBackground(Color.WHITE);
		this.buttonBackground = new Color(29, 84, 173);
		
		GridLayout experimentLayout = new GridLayout(3,0);
		this.setLayout(experimentLayout);
		  
	    this.addEventButton = this.getButton("Add Event");
	    this.add(addEventButton);

	    this.importEventsButton = this.getButton("Import Events");
	    this.add(importEventsButton );
	    
	}
	
	public JButton getButton(String buttonName){
		JButton button = new JButton();
		button.setBackground(this.buttonBackground);
		JLabel label = new JLabel(buttonName); 
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setForeground(Color.white);
		button.add(label);
		return button;
	}
	
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		this.importEventsButton.addActionListener(importButtonActionListener); 
	}
	
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener){
		this.addEventButton.addActionListener(addNewEventButtonActionListener); 
	}
	
}
