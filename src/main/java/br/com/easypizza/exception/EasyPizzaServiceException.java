package br.com.easypizza.exception;

public class EasyPizzaServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EasyPizzaServiceException (String message, Throwable cause){
		super(message, cause);
	}

}
