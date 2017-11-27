package model.repository.exception;

public class RepositoryException extends RuntimeException{

	public RepositoryException(){
		super(); 
	}

	public RepositoryException(String message){
		super(message); 
	}
	
	public RepositoryException(Throwable throwable){
		super(throwable); 
	}
	
	public RepositoryException(String message, Throwable throwable){
		super(message, throwable); 
	}

}
