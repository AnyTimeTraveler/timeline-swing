package uk.ac.cardiffmet.outlook.st20131039.model.repository;

public class ActorRepositoryFactory {

	public static ActorRepository getActorRepository(String repositoryType){
		switch(repositoryType){
		case "memory": 
		return new MemoryActorRepository(); 
		default:
			return new MemoryActorRepository(); 
		}	
	}
}
