package model; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import model.Actor;

public class Event {

	private List<Actor> actors = new ArrayList<Actor>();
	private String title; 
	private String description;
	private int id;
	private Date startDate; 
	private Date EndDate; 
	private static AtomicInteger ID_GENERATOR;
	
	public Event(String title, String description, Date startDate, Date endDate) {
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setTitle(title);
		this.setDescription(description);
		ID_GENERATOR = new AtomicInteger(1000);
		this.id = ID_GENERATOR.getAndIncrement();
	}
	
	public Event(List<Actor> actors, String title, String description, Date startDate, Date endDate) {
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setActors(actors); 
		this.setTitle(title);
		this.setDescription(description);
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public int getId(){
		return id; 
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	public void addActor(Actor actor) {
		this.actors.add(actor);
	}
	
	private void setActors(List<Actor> actors){
		this.actors = actors; 
	}
	
	public String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	} 
	
	
	
}
