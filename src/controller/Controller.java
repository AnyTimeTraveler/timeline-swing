package controller;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;

import controller.actionlisteners.AddEventButtonActionListener;
import controller.actionlisteners.ImportEventsButtonActionListener;
import controller.actionlisteners.SaveNewEventActionListener;
import model.service.EventService;
import ui.View;

public class Controller {

	private View view; 
	private EventService eventService; 
	
	public Controller(View view, EventService eventService){
		this.eventService = eventService; 
		this.view = view; 
		eventService.register(view);
		
		//Add initial actionlisteners
		this.addImportButtonActionListener(new ImportEventsButtonActionListener(this));
		this.addAddNewEventButtonActionListener(new AddEventButtonActionListener(this));
		this.saveNewEventButtonActionListener(new SaveNewEventActionListener(this));
		
		//Get initial data from model into view
		init();
		
		//Display UI
		this.view.setVisible();
	}
	
	public void init(){
		view.setEvents(this.eventService.getAllEvents()); 
	}
	
	private String toJson(Object toJson){
		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(toJson);
	    return jsonInString;
	}
	
	public void addEvent(String title, String description, Date startDate, Date endDate){
		this.eventService.addEvent(title, description, startDate, endDate); 
	}
	
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		view.addImportButtonActionListener(importButtonActionListener); 
	}
	public void addAddNewEventButtonActionListener(ActionListener addNewButtonActionListener){
		view.addAddNewEventButtonActionListener(addNewButtonActionListener); 
	}
	
	public void addUploadFileButtonActionListener(ActionListener uploadFileButtonActionListener){
		this.view.addUploadFileButtonActionListener(uploadFileButtonActionListener);
	}
	
	public void saveNewEventButtonActionListener(ActionListener saveNewEventActionListener){
		this.view.addSaveNewEventButtonActionListener(saveNewEventActionListener);
	}
	
	public void changeToAddNewEventPanel(){
		this.view.changeToAddNewEventPanel();
	}
	
	public void changeToImportPanel(){
		this.view.changeToImportPanel();
	}
	
	public void saveNewEvent(){
		Map<String, String> newEvent = this.view.getSaveNewEventData(); 
		System.out.println(newEvent.get("startDate")+" ..........................");
		this.eventService.addEvent(newEvent.get("title"), newEvent.get("description"), new Date(), new Date()); 
	}
	
}