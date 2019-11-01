package tasksJava.exceptions.exceptions;

public class MarkOutOfBoundsException extends Exception {
	
	
	private static final long serialVersionUID = 870153219669278046L;

	public MarkOutOfBoundsException(String message) {
		super(message);
		
	}

	public MarkOutOfBoundsException() {
		super();
	}


	public MarkOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MarkOutOfBoundsException(Throwable cause) {
		super(cause);
		
	}
	
	
}
