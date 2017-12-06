package exceptions;

/***
 * CustomException
 * 
 * This class is for the custom exceptions that can be generated in the application.
 * 
 * @author joel kass
 *
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 3929045928223848376L;

	/**
	 * CustomException
	 * 
	 * @param message
	 */
	public CustomException(String message) {
		super(message);
	}
}
