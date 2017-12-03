package controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Event;
import model.service.EventService;
import ui.View;

public class Controller {

	public View view; 
	protected EventService eventService; 
	
	public Controller(EventService eventservice, View view){
		System.out.println("Controller: constructor");
		this.eventService = eventservice; 
		this.view = view; 
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
	
	public void addEvent(String title, String description, String startDate, String endDate){
		eventService.addEvent(title, description, startDate, endDate); 
		view.setEvents(toJson(eventService.getAllEvents()));
	}
	
	
	
	
}