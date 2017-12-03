package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ui.datasets.timeline.Event;

public class View implements Observer{

	private MainFrame frame; 
	
	public View(){
		System.out.println("View: constructor");
		frame = new MainFrame(); 
	}
	
	public void setVisible(){
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		System.out.println("View: setVisible");
		frame.setVisible(true);
	}
	
	public void setEvents(String timelineJson){
		System.out.println("Vie: setEvents");
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		List<Event> events = gson.fromJson(timelineJson,  new TypeToken<ArrayList<Event>>(){}.getType());
		this.frame.setEvents(events);
	}
	
	@Override
	public void update() {
		
	}
}
