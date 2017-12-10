package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Event;

public class EventTest {
	
	private List<String> actors; 
	private String description; 
	private Date startDate; 
	private Date endDate;
	private String name; 
	
	@Before
	public void setUp(){
		//Setup valid values
		actors = new ArrayList<String>(); 
		description = "desc"; 
		startDate = new Date(); 
		endDate = new Date(); 
		name = "James"; 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithEmptyNameThrowException(){
		this.name = ""; 
		Event event = new Event(this.actors, this.name, this.description, this.startDate, this.endDate); 
	}

	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueNameThrowException(){
		Event event = new Event(this.actors, null, this.description, this.startDate, this.endDate); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueActorsThrowException(){
		Event event = new Event(null, this.name, this.description, this.startDate, this.endDate); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueDescriptionThrowException(){
		Event event = new Event(this.actors, this.name, null, this.startDate, this.endDate); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithEmptyDescriptionThrowException(){
		this.description = ""; 
		Event event = new Event(this.actors, this.name, this.description, this.startDate, this.endDate); 
	}

	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueStartDateThrowException(){
		Event event = new Event(this.actors, this.name, this.description, null, this.endDate); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueEndDateThrowException(){
		Event event = new Event(this.actors, this.name, this.description, this.startDate, null); 
	}
	
	@Test
	public void createValidEvent(){
		System.out.println(this.actors);
		Event event = new Event(this.actors, this.name, this.description, this.startDate, this.endDate); 
		assertEquals(this.actors, event.getActors()); 
		assertEquals(this.name, event.getTitle());
		assertEquals(this.description, event.getDescription());
		assertEquals(this.startDate, event.getStartDate());
		assertEquals(this.endDate, event.getEndDate()); 
	}
	
	
}
