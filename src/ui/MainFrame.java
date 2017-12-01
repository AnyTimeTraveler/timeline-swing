package ui;

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

	
	public MainFrame(){
		super();
		System.out.println("MainFraime: constructor (na super())");
		this.setTitle("Timeline");
		setLayoutContent();
	}
	
	private void setLayoutContent(){
		System.out.println("MainFraim: setLayoutContent");
		timelinePanel= new TimelinePanel();
		//Set Screen same as screen
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameDim = new Dimension(screenDim.width-300, screenDim.height-300); 
		
		this.setSize(frameDim);
		
		//Close Application properly
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Center Frame on screen
		this.setLocation(screenDim.width/2-this.getSize().width/2, screenDim.height/2-this.getSize().height/2);
		
		//Initiate Flexible GridBagLayout
		GridBagLayout gbl = new GridBagLayout(); 
		this.setLayout(gbl);        
	    
		//Set Position aka GridBagLayout for LEFT panel
		this.setLeftPanelGridBagLayoutConstraints();
			
		//Add left Panel to frame
	    JPanel leftPanel = getButtonPanel();
	    this.add(leftPanel, this.gbcLeft);
	    
	    //Set Position aka GridBagLayout for RIGHT panel
	  	this.setRightPanelGridBagLayoutConstraints();
	    
	    //Set default right panel scrollable
	    this.currentPanel = this.getTimelinePanel();
        
	     JScrollPane scrollPane = new JScrollPane(this.currentPanel);
	     this.getContentPane().add(scrollPane, this.gbcRight);
	     }
	
	private JPanel getButtonPanel(){
		JPanel leftPanel = new ButtonPanel();
		return leftPanel; 
	}
	
	private JPanel getTimelinePanel(){
		return timelinePanel;
	}
	
	private JPanel getNewEventPanel(){
		JPanel newEventPanel = new NewEventPanel();
		return newEventPanel; 
	}
	
	private void setLeftPanelGridBagLayoutConstraints(){
		gbcLeft.anchor = GridBagConstraints.PAGE_END;
		gbcLeft.fill = GridBagConstraints.BOTH;
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 0;
		gbcLeft.weighty = 1;
		gbcLeft.weightx = 0.3;
	}
	
	private void setRightPanelGridBagLayoutConstraints(){
		gbcRight.anchor = GridBagConstraints.PAGE_END;
		gbcRight.fill = GridBagConstraints.BOTH;
		gbcRight.gridx = 1;
		gbcRight.gridy = 0;
		gbcRight.weighty = 1;
		gbcRight.weightx = 1;
	}
	
	public void setEvents(List<Event> events){
		this.timelinePanel.setEvents(events);
	}
}
