package uk.ac.cardiffmet.outlook.st20131039.test.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.ac.cardiffmet.outlook.st20131039.model.Event;

public class EventTest {
	
	private List<String> actors; 
	private String description; 
	private Date startDate; 
	private Date endDate;
	private String name; 
	private String[] actorIds; 
	private String actorDescription; 
	
	@Before
	public void setUp(){
		//Setup valid values
		actors = new ArrayList<String>(); 
		description = "desc"; 
		startDate = new Date(); 
		endDate = new Date(); 
		name = "James"; 
		actorIds = new String[2];
		actorIds[0] = "1";
		actorIds[1] = "2"; 
		actorDescription = "Leader"; 
		this.actors.add("1"); 
		this.actors.add("2");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithEmptyNameThrowException(){
		this.name = ""; 
		Event event = new Event(this.name, this.description, this.startDate, this.endDate, actorIds, actorDescription); 
	}

	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueNameThrowException(){
		Event event = new Event(null, this.description, this.startDate, this.endDate, actorIds, actorDescription); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueDescriptionThrowException(){
		Event event = new Event( this.name, null, this.startDate, this.endDate, actorIds, actorDescription); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithEmptyDescriptionThrowException(){
		this.description = ""; 
		Event event = new Event( this.name, this.description, this.startDate, this.endDate, actorIds, actorDescription); 
	}

	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueStartDateThrowException(){
		Event event = new Event(this.name, this.description, null, this.endDate, actorIds, actorDescription); 
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void createEventWithNullValueEndDateThrowException(){
		Event event = new Event(this.name, this.description, this.startDate, null, actorIds, actorDescription); 
	}
	
	@Test
	public void createValidEvent(){
		Event event = new Event(this.name, this.description, this.startDate, this.endDate, actorIds, actorDescription); 
		
		assertEquals(this.actors, event.getActors()); 
		assertEquals(this.name, event.getTitle());
		assertEquals(this.description, event.getDescription());
		assertEquals(this.startDate, event.getStartDate());
		assertEquals(this.endDate, event.getEndDate());
	}
	
	
}
