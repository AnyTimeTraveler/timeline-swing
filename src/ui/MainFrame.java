package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.datasets.timeline.Event;


public class MainFrame extends JFrame{
	
	private TimelinePanel timelinePanel;
	private Color defaultColor;
	private JPanel workingPanel; 
	private NewEventPanel newEventPanel; 
	private ImportPanel importPanel; 
	private ButtonPanel buttonPanel;
	private EventDetailsPanel eventDetailsPanel; 
	private Dimension screenDim;
	private Dimension frameDim; 

	
	public MainFrame(){
		super();
		//Title of application/frame
		this.setTitle("Timeline Jeroen Vandevenne");
		
		//Default background color
		this.defaultColor = Color.WHITE;
		
		//Set initial content
		setLayoutContent();
	}
	
	private void setLayoutContent(){
		
		//Set Screen same as screen
		screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		frameDim = new Dimension(screenDim.width-200, screenDim.height-200); 
		
		//Set Size of Frame
		this.setSize(frameDim);
		
		//Initiate timelinePanel 
		timelinePanel= new TimelinePanel(frameDim.width,frameDim.height/2);
		
		//Close Application properly
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Center Frame on screen
		this.setLocation(screenDim.width/2-this.getSize().width/2, screenDim.height/2-this.getSize().height/2);
		
		//Initiate Flexible GridBagLayout
		GridBagLayout gbl = new GridBagLayout(); 
		this.setLayout(gbl);        
	    
		//Initiate GridBagConstraints for positioning
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.5;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		
		//Set scrollable timeline panel
	  	this.timelinePanel.setBackground(this.defaultColor);
	    JScrollPane scrollPane = new JScrollPane(this.timelinePanel);
	    this.getContentPane().add(scrollPane, gbc);
		
	    //Initialise ButtonPanel & add to frame
		this.buttonPanel = new ButtonPanel();
		this.buttonPanel.setBackground(this.defaultColor);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.1;
		gbc.gridwidth = 1;
		this.getContentPane().add(buttonPanel, gbc);
		
		//Initialise workingPanels and display newEventPanel on init
		this.newEventPanel = new NewEventPanel(); 
		this.importPanel = new ImportPanel(); 
		
		workingPanel = this.importPanel; 
		workingPanel.setBackground(Color.RED);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.9;
		this.getContentPane().add(workingPanel, gbc);
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
		
		System.out.println("CHANGE TO IMPORT PANEL");
	}
	
	public void changeToAddNewEventPanel(){
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.9;
		//Remove current panel
		this.getContentPane().remove(this.workingPanel);
		//Assing new panel as workingPanel
		this.workingPanel = this.newEventPanel;
		//add New panel to frame
		this.getContentPane().add(workingPanel, gbc);
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
	
	public void addSaveNewEventButtonActionListener(ActionListener saveNewEventActionListener){
		this.newEventPanel.addSaveButtonActionListener(saveNewEventActionListener);
	}
	
	public Map<String, String> getSaveNewEventData(){
		return this.newEventPanel.getSaveNewEventData();
	}
	
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener){
		this.timelinePanel.addTimelineEventActionListener(timelineEventMouseListener);
	}
	
	public void setEventDetailsPanelByCoordinates(int x, int y){
		List<Event> eventsInSpecificYear = this.timelinePanel.getEventYearByCoordinates(x, y);
		if(eventsInSpecificYear!=null){
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 0.5;
		gbc.weightx = 0.9;
		//Remove current panel
		this.getContentPane().remove(this.workingPanel);
		//Assing new panel as workingPanel
		this.eventDetailsPanel = new EventDetailsPanel(eventsInSpecificYear); 
		this.workingPanel = this.eventDetailsPanel;
		//add New panel to frame
		this.getContentPane().add(workingPanel, gbc);
		}
	}

}
