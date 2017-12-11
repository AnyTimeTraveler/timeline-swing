package model.repository;

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
