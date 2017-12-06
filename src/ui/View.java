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

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class View implements Observer{

	/**
	 * The main frame
	 */
	private MainFrame mainFrame;  
	
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
		this.mainFrame.setEvents(timelineJson);
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
	 * Add an {@link ActionListener} to the {@link mainFrame}
	 * @param downloadTimelineActionListener The Action Listener for the {@link mainFrame}
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener){
		this.mainFrame.addDownloadTimelineActionListener(downloadTimelineActionListener);
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
	public void setEventDetails(String eventsOfSpecificYear){
		this.mainFrame.setEventDetails(eventsOfSpecificYear);
		this.repaint();
	}
	public int getEventYearByCoordinates(int x, int y){
		return this.mainFrame.getEventYearByCoordinates(x, y); 
	}
	
	/**
	 * Color a rectangle with certain coordinates
	 */
	public void colorRectangleWithcoordinates(){
		this.mainFrame.colorRectangleWithcoordinates();
		this.repaint();
	}
	
	public void setActors(String actorsJson){
		/*GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		List<Actor> actors = gson.fromJson(actorsJson,  new TypeToken<ArrayList<Actor>>(){}.getType());
		this.mainFrame.setActors(actors);*/
	}
}
