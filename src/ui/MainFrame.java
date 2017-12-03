package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.datasets.timeline.Event;

public class MainFrame extends JFrame{
	
	private JPanel currentPanel;
	private GridBagConstraints gbcLeft = new GridBagConstraints(); 
	private GridBagConstraints gbcRight = new GridBagConstraints(); 
	private TimelinePanel timelinePanel;
	private Color defaultColor; 

	
	public MainFrame(){
		super();
		System.out.println("MainFraime: constructor (na super())");
		this.setTitle("Timeline");
		this.defaultColor = Color.WHITE;
		setLayoutContent();
		
	}
	
	private void setLayoutContent(){
		System.out.println("MainFraim: setLayoutContent");
		timelinePanel= new TimelinePanel(this.getWidth(), this.getHeight());
		//Set Screen same as screen
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameDim = new Dimension(screenDim.width-200, screenDim.height-200); 
		
		this.setSize(frameDim);
		
		//Close Application properly
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Center Frame on screen
		this.setLocation(screenDim.width/2-this.getSize().width/2, screenDim.height/2-this.getSize().height/2);
		
		//Initiate Flexible GridBagLayout
		GridBagLayout gbl = new GridBagLayout(); 
		this.setLayout(gbl);        
	    
		GridBagConstraints gbc = new GridBagConstraints(); 
		//gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.5;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		
		 //Set default right panel scrollable
	  	this.currentPanel = this.getTimelinePanel();
	  	currentPanel.setBackground(this.defaultColor);
	    JScrollPane scrollPane = new JScrollPane(this.currentPanel);
	    this.getContentPane().add(scrollPane, gbc);
		
		JPanel buttonPanel = new ButtonPanel();
		buttonPanel.setBackground(this.defaultColor);
		
		JPanel workingPanel = new NewEventPanel(); 
		workingPanel.setBackground(this.defaultColor);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.1;
		gbc.gridwidth = 1;
		this.add(buttonPanel, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.9;
		this.add(workingPanel, gbc);
	
	}
	
	
	private JPanel getTimelinePanel(){
		return timelinePanel;
	}
	
	public void setEvents(List<Event> events){
		this.timelinePanel.setEvents(events);
	}
}
