package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.actionlisteners.AddEventButtonActionListener;
import controller.actionlisteners.ImportEventsButtonActionListener;
import controller.actionlisteners.TimelineButtonActionListener;

public class ButtonPanel extends JPanel {

	private Color buttonBackground; 
	private MainFrame frame; 
	
	public ButtonPanel(MainFrame frame){
		super();
		this.frame = frame;
		
		this.buttonBackground = new Color(29, 84, 173);
		
		GridLayout experimentLayout = new GridLayout(3,0);
		this.setLayout(experimentLayout);
		  
	    JButton addEventButton = this.getButton("Add Event", new AddEventButtonActionListener(frame));
	    this.add(addEventButton);

	    JButton importEventsButton = this.getButton("Import Events", new ImportEventsButtonActionListener(frame));
	    this.add(importEventsButton );
	    
	}
	
	public JButton getButton(String buttonName, ActionListener al){
		JButton button = new JButton();
		button.addActionListener(al);
		button.setBackground(this.buttonBackground);
		JLabel label = new JLabel(buttonName); 
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setForeground(Color.white);
		button.add(label);
		return button;
	}
	
}
