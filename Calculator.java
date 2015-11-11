import java.util.*;

//Alex Aquino
//Homework 6 - class Calculator solves math problems
public class Calculator {
	
	String[] question;
	int quest_size;
	
	public Calculator(String[] args) {
		question = args;
		quest_size = question.length;
	}
	
	public double solve() throws IllegalArgumentException {
		//call check funtion to make sure input is good
		check();
		
		//Works on operations using *, /, and % since they are higher in precedence
		for(int i = 0; i < quest_size; i++) {
			if(question[i].equals("*") || question[i].equals("/") || question[i].equals("%")) {
				if(question[i].equals("*")) {
					question[i - 1] = Double.toString(Double.parseDouble(question[i - 1]) 
						* Double.parseDouble(question[i + 1]));
					for(int j = i; j < quest_size - 2; j++) {
						question[j] = question[j + 2];
					}
					quest_size -= 2;
					i--;
				}
				else if(question[i].equals("/")) {
					question[i - 1] = Double.toString(Double.parseDouble(question[i - 1]) 
						/ Double.parseDouble(question[i + 1]));
					for(int j = i; j < quest_size - 2; j++) {
						question[j] = question[j + 2];
					}
					quest_size -= 2;
					i--;
				}
				else if(question[i].equals("%")) {
					question[i - 1] = Double.toString(Double.parseDouble(question[i - 1]) 
						% Double.parseDouble(question[i + 1]));
					for(int j = i; j < quest_size - 2; j++) {
						question[j] = question[j + 2];
					}
					quest_size -= 2;
					i--;
				}
			}
		}
		
		//Works on operations using +, and -
		for(int i = 0; i < quest_size; i++) {
			if(question[i].equals("+") || question[i].equals("-")) {
				if(question[i].equals("+")) {
					question[i - 1] = Double.toString(Double.parseDouble(question[i - 1]) 
						+ Double.parseDouble(question[i + 1]));
					for(int j = i; j < quest_size - 2; j++) {
						question[j] = question[j + 2];
					}
					quest_size -= 2;
					i--;
				}
				else if(question[i].equals("-")) {
					question[i - 1] = Double.toString(Double.parseDouble(question[i - 1]) 
						- Double.parseDouble(question[i + 1]));
					for(int j = i; j < quest_size - 2; j++) {
						question[j] = question[j + 2];
					}
					quest_size -= 2;
					i--;
				}
			}
		}
		return Double.parseDouble(question[0]);
	}
	
	private void check() throws IllegalArgumentException {
		int operationCounter = 0;
		int numberCounter = 0;
		
		for(int i = 0; i < question.length; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < question[i].length(); j++) {
					if(!Character.isDigit(question[i].charAt(j)) && !(question[i].charAt(j) == '.')) {
						throw new NotANumberException(question[i]);
					}
				}
				
				numberCounter++;
			}
			else {
				if(!question[i].equals("+") && !question[i].equals("-") && !question[i].equals("*") 
					&& !question[i].equals("/") && !question[i].equals("%")) {
						throw new IllegalOperationException(question[i]);
				}
				if(question[i].equals("/") || question[i].equals("%") && question[i + 1] != null) {
					if(question[i + 1].equals("0")) {
						throw new ArithmeticException();
					}
				}
				operationCounter++;
			}	
		}
		if(!(operationCounter == numberCounter - 1)) {
			throw new NotEnoughNumbersException();
		}
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator(args);
		
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
		}
		
		try {
			System.out.println("\nAnswer: " + calculator.solve());
		} catch(IllegalArgumentException e) {
			System.out.println("\n" + e);
			System.out.println("Try again...");
		}
	}
}
