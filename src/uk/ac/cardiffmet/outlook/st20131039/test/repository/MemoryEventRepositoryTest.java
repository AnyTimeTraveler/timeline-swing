package uk.ac.cardiffmet.outlook.st20131039.test.repository;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import uk.ac.cardiffmet.outlook.st20131039.model.repository.EventRepository;
import uk.ac.cardiffmet.outlook.st20131039.model.repository.MemoryEventRepository;

public class MemoryEventRepositoryTest {

	private EventRepository memory;
	
	@Before
	public void setUp(){
		this.memory = new MemoryEventRepository(); 
	}
	
	
}
