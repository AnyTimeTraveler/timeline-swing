package model; 

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import model.Actor;

public class Event {

	private List<Actor> actors = new ArrayList<Actor>();
	private String title; 
	private String description;
	private int id;
	private static AtomicInteger ID_GENERATOR;
	
	public Event(String title, String description) {
		this.setTitle(title);
		this.setDescription(description);
		ID_GENERATOR = new AtomicInteger(1000);
		this.id = ID_GENERATOR.getAndIncrement();
	}
	
	public Event(List<Actor> actors, String title, String description) {
		this.setActors(actors); 
		this.setTitle(title);
		this.setDescription(description);
		
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
