
package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;

import controller.actionlisteners.navigation.AddEventButtonActionListener;
import controller.actionlisteners.navigation.ImportEventsButtonActionListener;
import controller.actionlisteners.workingpanel.DownloadTimelineActionListener;
import controller.actionlisteners.workingpanel.SaveNewEventActionListener;
import controller.actionlisteners.workingpanel.UploadTimelineActionListener;
import controller.mouselisteners.TimelineEventMouseListener;
import model.service.Service;
import ui.View;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class Controller {

	/**
	 * The {@link View} of the app
	 */
	private View view;
	/**
	 * The {@link Service} of the app
	 */
	private Service service; 
	
	/**
	 * Assigns the {@link View} and {@link Service} parameters to the variables
	 * @param view The view of the app
	 * @param service The Service of the app
	 */
	public Controller(View view, Service service){
		this.service = service; 
		this.view = view; 
		service.register(view);
		
		//Add initialize actionlisteners
		this.addImportButtonActionListener(new ImportEventsButtonActionListener(this));
		this.addAddNewEventButtonActionListener(new AddEventButtonActionListener(this));
		this.saveNewEventButtonActionListener(new SaveNewEventActionListener(this));
		this.addTimelineEventActionListener(new TimelineEventMouseListener(this));
		this.addUploadFileActionListener(new UploadTimelineActionListener(this)); 
		this.addDownloadTimelineActionListener(new DownloadTimelineActionListener(this));
		
		//Get initial data from model into view
		init();
		
		//Display UI
		this.view.setVisible();
	}
	
	/**
	 * Sends inital data to {@link View}
	 */
	public void init(){
		System.out.println(this.service.getAllEvents());
		view.setEvents(this.service.getAllEvents()); 
	}
	
	/**
	 * Transform data from object to JSON
	 * @param toJson Object to be transformed
	 * @return String JSON format
	 */
	private String toJson(Object toJson){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(toJson);
	    return jsonInString;
	}
	
	/**
	 * Add a new Event
	 * @param title The title of the event
	 * @param description The description of the event
	 * @param startDate The start date of the event
	 * @param endDate The end date of the event
	 */
	public void addEvent(String title, String description, Date startDate, Date endDate){
		this.service.addEvent(title, description, startDate, endDate); 
	}
	
	/**
	 * Add a new Event
	 * @param title The title of the event
	 * @param description The description of the event
	 * @param startDate The start date of the event
	 * @param endDate The end date of the event
	 */
	public void addEvents(String eventsInJsonFormat){
		this.service.addEvents(eventsInJsonFormat); 
	}
	
	/**
	 * Add {@link ActionListener} to the {@link View}
	 * @param importButtonActionListener The ActionListener for the import button
	 */
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		view.addImportButtonActionListener(importButtonActionListener); 
	}
	
	/**
	 * Add {@link ActionListener} to the {@link View}
	 * @param addNewButtonActionListener The ActionListener for the add new event button
	 */
	public void addAddNewEventButtonActionListener(ActionListener addNewButtonActionListener){
		view.addAddNewEventButtonActionListener(addNewButtonActionListener); 
	}
	
	
	/**
	 * Add {@link ActionListener} to the {@link View}
	 * @param saveNewEventActionListener The ActionListener for the save new event button
	 */
	public void saveNewEventButtonActionListener(ActionListener saveNewEventActionListener){
		this.view.addSaveNewEventButtonActionListener(saveNewEventActionListener);
	}
	
	/**
	 * Add {@link MouseListener} to the {@link View}
	 * @param timelineEventMouseListener The MouseListener for the import button
	 */
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener){
		this.view.addTimelineEventActionListener(timelineEventMouseListener);
	}
	
	/**
	 * Add {@link ActionListener} to the {@link View}
	 * @param uploadFileActionListener The {@link ActionListener} for the upload button
	 */
	public void addUploadFileActionListener(ActionListener uploadFileActionListener){
		this.view.addUploadFileActionListener(uploadFileActionListener);
	}
	
	/**
	 * Change the working panel in the {@link View} to the {@link ui.NewEventPanel}
	 */
	public void changeToAddNewEventPanel(){
		this.view.changeToAddNewEventPanel();
	}
	
	/**
	 * Change the working panel in the {@link View} to the {@link ui.ImportPanel}
	 */
	public void changeToImportPanel(){
		this.view.changeToImportPanel();
	}
	
	/**
	 * Save a new event. Gets displayed data in View and stores it in the model
	 */
	public void saveNewEvent(){
		Map<String, String> newEvent = this.view.getSaveNewEventData(); 
		Date startDate; 
		Date endDate; 
		try {
			startDate = new SimpleDateFormat("dd-MM-yyyy").parse(newEvent.get("startDate"));
			endDate = new SimpleDateFormat("dd-MM-yyyy").parse(newEvent.get("startDate"));
			this.service.addEvent(newEvent.get("title"), newEvent.get("description"), startDate, endDate); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Change the working panel in the {@link View} to the {@link ui.EventDetailsPanel}
	 * @param x The x coordinate of the clicked event
	 * @param y The y coordinate of the clicked event
	 */
	public void openEventDetailsPanel(int x, int y){
		this.view.setEventDetailsPanelByCoordinates(x, y); 
	} 
	
	/**
	 * Color a certain Rectangle
	 */
	//TODO implement coordinates
	public void colorRectangleWithcoordinates(){
		this.view.colorRectangleWithcoordinates(); 
	}
	
	/**
	 * Add {@link ActionListener} to the {@link View}
	 * @param downloadTimelineActionListener The {@link ActionListener} for the view
	 */
	public void addDownloadTimelineActionListener(ActionListener downloadTimelineActionListener){
		this.view.addDownloadTimelineActionListener(downloadTimelineActionListener);
	}
	
	public void saveTimeline(String absolutePathDestination){
		File file = new File(absolutePathDestination+".json");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePathDestination+".json"))) {

			String jsonToWrite = this.service.getAllEvents();

			bw.write(jsonToWrite);
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
}
}