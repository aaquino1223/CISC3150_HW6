
//Class IllegalOperationException should be used when an operation not supported
//is entered
public class IllegalOperationException extends IllegalArgumentException {
	String reason;
		
	public IllegalOperationException(String reason) {
		this.reason = reason;
	}
		
	public String toString() {
		return reason + " is not an operation";
	}
}