package controller;

import model.service.EventService;
import ui.View;

public class Controller {

	protected EventService eventService; 
	
	public Controller(){
		String repositoryType = "Memory";
		this.eventService = new EventService(repositoryType);
}
	
}
