package uk.ac.cardiffmet.outlook.st20131039.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.ac.cardiffmet.outlook.st20131039.model.Actor;

public class ActorTest {

	private String name; 
	private String id; 
	
	@Before
	public void setUp(){
		//Valid variables
		this.name = "Bob";
		this.id = "5"; 
	}
	
	@Test
	public void ActorCreateValidActor() {
		Actor actor = new Actor(this.name ,this.id);  
		assertEquals(this.name, actor.getName());
		assertEquals(this.id, actor.getId()); 
	}
	
	@Test
	public void ActorCreateValidActorWithAutogeneratedId() {
		Actor actor = new Actor(this.name);  
		assertEquals(this.name, actor.getName());
		assertNotNull(this.id, actor.getId()); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ActorCreateActorWithEmptyNameThrowException() {
		Actor actor = new Actor("");  
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ActorCreateActorWithNullValueNameThrowException() {
		Actor actor = new Actor(null);  
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ActorCreateActorWithEmptyIdThrowException() {
		Actor actor = new Actor(this.name, "");  
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ActorCreateActorWithNullValueIdThrowException() {
		Actor actor = new Actor(this.name, null);  
	}

}
