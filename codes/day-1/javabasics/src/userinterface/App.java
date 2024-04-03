package userinterface;

import java.util.Scanner;

import logic.Calculation;

public class App {

	public static void main(String[] args) {

		char toContinue = 'n';
		Scanner scanner = new Scanner(System.in);
		Calculation calculation = new Calculation();
		do {
			UiUtility.printChoices();
			int choice = UiUtility.getChoice(scanner);

			if (choice < 1 || choice > 4) {
				System.out.println("incorrect choice");
			} else {
				int firstValue = UiUtility.getValue(scanner);
				int secondValue = UiUtility.getValue(scanner);

				Integer result = UiUtility.performCalculation(firstValue, secondValue, choice, calculation);
				if (result != null)
					System.out.println("result " + result.intValue());
				else
					System.out.println("could not perform calculation...no result");
			}
			toContinue = UiUtility.decideToContinue(scanner);

		} while (toContinue != 'n');
	}	
}
