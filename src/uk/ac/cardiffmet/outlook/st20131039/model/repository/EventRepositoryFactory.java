package uk.ac.cardiffmet.outlook.st20131039.model.repository;

/**
 * @author Jeroen Vandevenne
 * @version 1.0
 */
public class EventRepositoryFactory {

	/**
	 * Return an EventRepository depening on the repositoryType
	 * 
	 * @param repositoryType
	 *            The of repository to return
	 * @return EventRepository based on repositoryType
	 */
	public static EventRepository getEventRepository(String repositoryType) {
		switch (repositoryType) {
		case "memory":
			return new MemoryEventRepository();
		default:
			return new MemoryEventRepository();
		}
	}
}
