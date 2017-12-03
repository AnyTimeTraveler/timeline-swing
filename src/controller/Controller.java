package controller;

import java.util.Date;

import com.google.gson.Gson;

import model.service.EventService;
import ui.View;

public class Controller {

	public View view; 
	protected EventService eventService; 
	
	public Controller(String repositoryType){
		eventService = new EventService(repositoryType); 
		view = new View(this);
		eventService.register(view);
		init();
		
		this.view.setVisible();
		
		
	}
	
	public void init(){
		System.out.println("Controller: init");
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
	
	
	
	
}