
//Class NotANumberException should be used when a value is not a number
public class NotANumberException extends IllegalArgumentException {
	String reason;
		
	public NotANumberException(String reason) {
		this.reason = reason;
	}
		
	public String toString() {
		return reason + " is not a number";
	}
}