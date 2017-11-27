package controller;

import model.service.Service;
import ui.View;

public class Controller {
	
	private Service service;
	private View view;
	
	public Controller(Service service, View view){
		this.service = service; 
		this.view = view;
	}
}

