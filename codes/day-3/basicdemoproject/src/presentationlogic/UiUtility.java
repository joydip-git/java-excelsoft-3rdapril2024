package presentationlogic;

import java.util.Scanner;

public class UiUtility {
	public static int getValue(Scanner scanner) {
		System.out.println("enter value: ");
		int value = scanner.nextInt();
		return value;
	}
}
