package controller;

import java.awt.event.ActionListener;
import java.util.Date;

import com.google.gson.Gson;

import controller.actionlisteners.AddEventButtonActionListener;
import controller.actionlisteners.ImportCSVFileEventListener;
import controller.actionlisteners.ImportEventsButtonActionListener;
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
		this.addImportButtonActionListener(new ImportEventsButtonActionListener(this.view, this.eventService));
		this.addAddNewEventButtonActionListener(new AddEventButtonActionListener(this.view, this.eventService));
		this.addUploadFileButtonActionListener(new ImportCSVFileEventListener(this.view, this.eventService)); 
		
		init();
		this.view.setVisible();
	}
	
	public void init(){
		view.setEvents(toJson(this.eventService.getAllEvents())); 
	}
	
	private String toJson(Object toJson){
		System.out.println("Controller: toJson");
		Gson gson = new Gson();
		String jsonInString = gson.toJson(toJson);
	    return jsonInString;
	}
	
	public void addEvent(String title, String description, Date startDate, Date endDate){
		eventService.addEvent(title, description, startDate, endDate); 
		view.setEvents(toJson(eventService.getAllEvents()));
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
	
	
}