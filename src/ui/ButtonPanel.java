package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.actionlisteners.*;

public class ButtonPanel extends JPanel {

	public ButtonPanel(){
		super();
		GridBagLayout gbl = new GridBagLayout(); 
		GridBagConstraints gbc = new GridBagConstraints(); 
		this.setLayout(gbl);
		
		gbc.fill = GridBagConstraints.BOTH;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.weightx = 0.1;
	    gbc.weighty = 0.1;
	    JButton timelineButton = this.getButton("Timeline", new TimelineButtonActionListener());
	  	this.add(timelineButton, gbc);
		
	  		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.weightx = 0.1;
	    gbc.weighty = 0.1;
	    JButton addEventButton = this.getButton("Add Event", new AddEventButtonActionListener());
	    this.add(addEventButton, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.weightx = 0.1;
	    gbc.weighty = 0.1;
	    JButton importEventsButton = this.getButton("Import Events", new ImportEventsButtonActionListener());
	    this.add(importEventsButton, gbc);
	
	}
	
	public JButton getButton(String buttonName, ActionListener al){
		JButton button = new JButton(buttonName);
		button.addActionListener(al);
		return button;
	}
	
}
