package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import ui.datasets.timeline.Event;

public class MainFrame extends JFrame{
	
	private JPanel currentPanel;
	private GridBagConstraints gbcLeft = new GridBagConstraints(); 
	private GridBagConstraints gbcRight = new GridBagConstraints(); 
	private TimelinePanel timelinePanel;
	private Color defaultColor;
	private JPanel workingPanel; 
	private JPanel eventPanel; 
	private ImportPanel importPanel; 
	private ButtonPanel buttonPanel; 

	
	public MainFrame(){
		super();
		System.out.println("MainFraime: constructor (na super())");
		this.setTitle("Timeline");
		this.defaultColor = Color.WHITE;
		setLayoutContent();
		
	}
	
	private void setLayoutContent(){
		System.out.println("MainFraim: setLayoutContent");
		//Set Screen same as screen
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameDim = new Dimension(screenDim.width-200, screenDim.height-200); 
		
		this.setSize(frameDim);
		timelinePanel= new TimelinePanel(frameDim.width,frameDim.height/2);
		
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
	    //TODO style scollbar

	    this.getContentPane().add(scrollPane, gbc);
		
		this.buttonPanel = new ButtonPanel();
		this.buttonPanel.setBackground(this.defaultColor);
		
		this.eventPanel = new NewEventPanel(); 
		this.importPanel = new ImportPanel(); 
		
		workingPanel = this.eventPanel; 
		workingPanel.setBackground(Color.RED);
		
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
	
	public void changeToImportPanel(){
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.9;
		this.getContentPane().remove(this.workingPanel);
		
		this.workingPanel = this.importPanel;  
		this.getContentPane().add(workingPanel, gbc);
		this.workingPanel.repaint();
		this.revalidate();
		this.repaint();
		this.getContentPane().validate();
		this.getContentPane().repaint();
		System.out.println("CHANGE TO IMPORT PANEL");
	}
	
	public void changeToAddNewEventPanel(){
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.9;
		this.getContentPane().remove(this.workingPanel);
		
		this.workingPanel = this.eventPanel; 
		this.getContentPane().add(workingPanel, gbc);
		this.workingPanel.repaint();
		this.revalidate();
		this.repaint();
		this.getContentPane().validate();
		this.getContentPane().repaint();
		System.out.println("CHANGE TO NEW EVENT PANEL");
	}
	
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		this.buttonPanel.addImportButtonActionListener(importButtonActionListener); 
	}
	
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener){
		this.buttonPanel.addAddNewEventButtonActionListener(addNewEventButtonActionListener); 
	}
	
	public void addUploadFileButtonActionListener(ActionListener uploadFileButtonActionListener){
		this.importPanel.addUploadFileButtonActionListener(uploadFileButtonActionListener);
	}
	
}
