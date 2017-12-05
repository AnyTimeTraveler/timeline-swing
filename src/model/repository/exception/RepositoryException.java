package model.repository.exception;
/**
* @author  Jeroen Vandevenne
* @version 1.0
*/
public class RepositoryException extends RuntimeException{

	/**
	 * Constructor without params
	 */
	public RepositoryException(){
		super(); 
	}

	/**
	 * Constructor with message
	 * @param message A shown when Exception triggred
	 */
	public RepositoryException(String message){
		super(message); 
	}
	
	/**
	 * Constructor with throwable
	 * @param throwable Throwable to add to Exception
	 */
	public RepositoryException(Throwable throwable){
		super(throwable); 
	}
	
	/**
	 * Constructor with params and throwable
	 * @param message A shown when Exception triggred
	 * @param throwable Throwable to add to Exception
	 */
	public RepositoryException(String message, Throwable throwable){
		super(message, throwable); 
	}

}
