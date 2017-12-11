package uk.ac.cardiffmet.outlook.st20131039.model.repository;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class ActorRepositoryFactory {

	/**
	 * Return an ActorRepository depening on the repositoryType
	 * 
	 * @param repositoryType
	 *            The of repository to return
	 * @return ActorRepository based on repositoryType
	 */
	public static ActorRepository getActorRepository(String repositoryType) {
		switch (repositoryType) {
		case "memory":
			return new MemoryActorRepository();
		default:
			return new MemoryActorRepository();
		}
	}
}
