
//Class ArithmeticException should be used when division by zero is attempted
public class ArithmeticException extends IllegalArgumentException {
	public String toString() {
		return "Cannot divide by zero";
	}
}