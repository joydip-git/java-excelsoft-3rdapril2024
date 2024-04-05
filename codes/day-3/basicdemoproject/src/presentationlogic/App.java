package presentationlogic;

import java.util.Scanner;

import businesslogic.FibonacciLogic;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int value = UiUtility.getValue(scanner);
		
		FibonacciLogic fibonacci = new FibonacciLogic();
		int result = fibonacci.getFibonacci(value);
		
		System.out.println(result);
		scanner.close();
	}
}
