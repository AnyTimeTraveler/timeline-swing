package controller;

import model.service.EventService;
import model.service.Service;
import ui.View;

public class EventController implements Controller{

	private View view; 
	private Service service; 
	
	public EventController(){
		String repositoryType = "Memory";
		this.service = new EventService(repositoryType);
		View view = new View();
	}
	
	
}
