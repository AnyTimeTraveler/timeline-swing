package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.service.EventService;
import ui.View;

public class AddEventButtonActionListener implements ActionListener {

	private View view; 
	private EventService eventService; 
	
	public AddEventButtonActionListener(View view, EventService eventService){
		this.view = view; 
		this.eventService = eventService; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.changeToAddNewEventPanel();
	}

}
