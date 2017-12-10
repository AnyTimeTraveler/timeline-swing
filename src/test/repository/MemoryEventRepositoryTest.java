package test.repository;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import model.repository.EventRepository;
import model.repository.MemoryEventRepository;

public class MemoryEventRepositoryTest {

	private EventRepository memory;
	
	@Before
	public void setUp(){
		this.memory = new MemoryEventRepository(); 
	}
	
	
}
