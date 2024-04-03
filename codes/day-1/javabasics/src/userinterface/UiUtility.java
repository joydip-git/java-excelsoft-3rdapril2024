package userinterface;

import java.util.Scanner;

import logic.Calculation;

public class UiUtility {
	public static void printChoices() {
		System.out.println("1. Add \n2. Subtract \n3. Multiply \n4.Divide");
	}

	public static int getChoice(Scanner scanner) {
		System.out.print("enter choice[1/2/3/4]: ");
		return scanner.nextInt();
	}

	public static int getValue(Scanner scanner) {
		System.out.print("\nenter value: ");
		return scanner.nextInt();
	}

	public static Integer performCalculation(int first, int second, int choice, Calculation calculation) {
		Integer result = null;
		switch (choice) {
		case 1:
			result = calculation.add(first, second);
			break;

		case 2:
			result = calculation.subtract(first, second);
			break;

		case 3:
			result = calculation.multiply(first, second);
			break;

		case 4:
			result = calculation.divide(first, second);
			break;

		default:
			break;
		}
		return result;
	}

	public static char decideToContinue(Scanner scanner) {
		System.out.print("\nwould you like to continue[type n/N to discontinue]: ");
		char decision = scanner.next().charAt(0);
		if (Character.isUpperCase(decision)) {
			decision = Character.toLowerCase(decision);
		}
		return decision;
	}
}
