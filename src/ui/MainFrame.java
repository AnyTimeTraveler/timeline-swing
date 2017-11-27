package ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.service.Subject;

public class MainFrame extends JFrame implements Observer{
	
	private JPanel currentPanel;
	private GridBagConstraints gbcLeft = new GridBagConstraints(); 
	private GridBagConstraints gbcRight = new GridBagConstraints(); 

	
	public MainFrame(String title){
		super();
		this.setTitle(title);
		this.setSize(new Dimension(800, 500));
		
		//Close Application properly
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Center Frame on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
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
	    
	    //Set default right panel
	    this.currentPanel = this.getNewEventPanel(); 
	    this.add(this.currentPanel, this.gbcRight);
	}
	
	private JPanel getButtonPanel(){
		JPanel leftPanel = new ButtonPanel();
		return leftPanel; 
	}
	
	private JPanel getTimelinePanel(){
		JPanel timelinePanel = new TimelinePanel();
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
		gbcRight.weightx = 0.7;
	}

	public void updateRightPanel(Subject subject){
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
