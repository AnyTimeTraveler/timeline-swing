package ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ui.datasets.timeline.Event;

public class View implements Observer{

	private MainFrame mainFrame; 
	
	public View(){
		mainFrame = new MainFrame(); 
	}
	
	public void setVisible(){
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setVisible(true);
	}
	
	public void setEvents(String timelineJson){
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		List<Event> events = gson.fromJson(timelineJson,  new TypeToken<ArrayList<Event>>(){}.getType());
		this.mainFrame.setEvents(events);
		System.out.println("INIT HIERIN");
	}
	
	
	
	public void addImportButtonActionListener(ActionListener importButtonActionListener){
		mainFrame.addImportButtonActionListener(importButtonActionListener); 
	}
	
	public void addAddNewEventButtonActionListener(ActionListener addNewEventButtonActionListener){
		mainFrame.addAddNewEventButtonActionListener(addNewEventButtonActionListener);
	}
	
	public void addUploadFileButtonActionListener(ActionListener uploadFileButtonActionListener){
		this.mainFrame.addUploadFileButtonActionListener(uploadFileButtonActionListener);
	}
	
	public void addSaveNewEventButtonActionListener(ActionListener saveNewEventActionListener){
		this.mainFrame.addSaveNewEventButtonActionListener(saveNewEventActionListener);
	}
	
	public void changeToAddNewEventPanel(){
		this.mainFrame.changeToAddNewEventPanel();
		this.repaint();
		
	}
	
	public void changeToImportPanel(){
		this.mainFrame.changeToImportPanel();
		this.repaint();
	}
	
	private void repaint(){
		this.mainFrame.getContentPane().validate();
		this.mainFrame.getContentPane().repaint();
	}

	@Override
	public void update(String eventsJson) {
		System.out.println("EVENTSJSON : "+ eventsJson);
		this.setEvents(eventsJson);
		this.repaint();
	}
	
	public Map<String, String> getSaveNewEventData(){
		return mainFrame.getSaveNewEventData();
	}
	
	public void addTimelineEventActionListener(MouseListener timelineEventMouseListener){
		this.mainFrame.addTimelineEventActionListener(timelineEventMouseListener);
	}
	
	public void setEventDetailsPanelByCoordinates(int x, int y){
		this.mainFrame.setEventDetailsPanelByCoordinates(x, y);
		this.repaint();
	}
	
	public void colorRectangleWithcoordinates(){
		this.mainFrame.colorRectangleWithcoordinates();
		this.repaint();
	}
	
	
}
