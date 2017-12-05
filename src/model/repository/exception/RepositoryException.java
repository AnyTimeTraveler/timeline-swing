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
	 */
	public RepositoryException(String message){
		super(message); 
	}
	
	/**
	 * Constructor with throwable
	 */
	public RepositoryException(Throwable throwable){
		super(throwable); 
	}
	
	/**
	 * Constructor with params and throwable
	 */
	public RepositoryException(String message, Throwable throwable){
		super(message, throwable); 
	}

}
