package uk.ac.cardiffmet.outlook.st20131039.model.repository;

public class EventRepositoryFactory {

	public static EventRepository getEventRepository(String repositoryType){
		switch(repositoryType){
		case "memory" : 
			return new MemoryEventRepository(); 
		default: 
			return new MemoryEventRepository(); 
		}
	}
}
