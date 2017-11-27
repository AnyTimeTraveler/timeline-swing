package controller;

import model.service.EventService;
import model.service.Service;
import ui.View;

public class EventController extends Controller{

	public EventController(){
		super(new EventService(), new View() ); 
	}
	
	
}
