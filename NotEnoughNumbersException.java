
//Class NotEnoughNumbersException should be used when the amount of numbers 
//does not match the amount of operations
public class NotEnoughNumbersException extends IllegalArgumentException {	
	public String toString() {
		return "There is not enough numbers";
	}
}