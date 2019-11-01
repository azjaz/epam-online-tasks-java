package tasksJava.exceptions.exceptions;

public class StudentIsAbsentException extends Exception {
	
	
	private static final long serialVersionUID = -4849930427602036064L;

	public StudentIsAbsentException() {
		super();
		
	}

	public StudentIsAbsentException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StudentIsAbsentException(String message) {
		super(message);
	}	

	public StudentIsAbsentException(Throwable cause) {
		super(cause);
	}	
	
	

}
