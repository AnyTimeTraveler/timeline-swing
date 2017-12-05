package ui;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ui.datasets.timeline.Event;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class View implements Observer{

	/**
	 * The main frame
	 */
	private MainFrame mainFrame; 
	
	/**
	 * Initialise attributes
	 */
	public View(){
		mainFrame = new MainFrame(); 
	}
	
	/**
	 * Display the frame and set Maximized on screen
	 */
	public void setVisible(){
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setVisible(true);
	}
	
	/**
	 * Set events to {@link mainFrame} as JSON
	 * @param timelineJson events in JSON format
	 */
	public void setEvents(String timelineJson){
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		List<Event> events = gson.fromJson(timelineJson,  new TypeToken<ArrayList<Event>>(){}.getType());
		this.mainFrame.setEvents(events);
		System.out.println("INIT HIERIN");
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * @param importButtonActionListener The Action Listener for the {@link mainFrame}
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		mainFrame.addImportButtonActionListener(importButtonActionListener); 
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * @param addNewEventButtonActionListener The Action Listener for the {@link mainFrame}
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener){
		mainFrame.addAddNewEventButtonActionListener(addNewEventButtonActionListener);
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * @param saveNewEventActionListener The Action Listener for the {@link mainFrame}
	 */
	public void addSaveNewEventButtonActionListener(ActionListener saveNewEventActionListener){
		this.mainFrame.addSaveNewEventButtonActionListener(saveNewEventActionListener);
	}
	
	/**
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * @param uploadFileActionListener The Action Listener for the {@link mainFrame}
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener){
		this.mainFrame.addUploadFileActionListener(uploadFileActionListener);
	}
	
	/**
	 * Change {@link ui.MainFrame#workingPanel} to {@link ui.MainFrame#newEventPanel} and repaint
	 */
	public void changeToAddNewEventPanel(){
		this.mainFrame.changeToAddNewEventPanel();
		this.repaint();
		
	}
	/**
	 * Change {@link ui.MainFrame#workingPanel} to {@link ui.MainFrame#importPanel} and repaint
	 */
	public void changeToImportPanel(){
		this.mainFrame.changeToImportPanel();
		this.repaint();
	}
	
	/**
	 * Repaint the whole frame
	 */
	private void repaint(){
		this.mainFrame.getContentPane().validate();
		this.mainFrame.getContentPane().repaint();
	}
	
	@Override
	public void update(String eventsJson) {
		System.out.println("EVENTSJSON : "+ eventsJson);
		this.setEvents(eventsJson);
		this.repaint();
	}
	
	/**
	 * Get Save new event data that is entered on the frame
	 * @return {@link Map}&lt;{@link String};{@link String}&gt; key is field name and value is field content
	 */
	public Map<String, String> getSaveNewEventData(){
		return mainFrame.getSaveNewEventData();
	}
	
	/**
	 * Add an {@link MouseListener} to the {@link MainFrame}
	 * @param timelineEventMouseListener The Mouse Listener for the {@link MainFrame}
	 */
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener){
		this.mainFrame.addTimelineEventActionListener(timelineEventMouseListener);
	}
	
	/**
	 * Change {@link ui.MainFrame#workingPanel} to {@link ui.MainFrame#eventDetailsPanel} and repaint
	 * @param x X coordinated that was clicked
	 * @param y Y coordinated that was clicked
	 */
	public void setEventDetailsPanelByCoordinates(int x, int y){
		this.mainFrame.setEventDetailsPanelByCoordinates(x, y);
		this.repaint();
	}
	
	/**
	 * Color a rectangle with certain coordinates
	 */
	public void colorRectangleWithcoordinates(){
		this.mainFrame.colorRectangleWithcoordinates();
		this.repaint();
	}
	
	
}
