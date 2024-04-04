package userinterface;

import java.util.Scanner;

import models.Employee;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// ask user to enter how many objects to create
		int count = UiUtility.getEmployeeRecordCount(scanner);

		// create an array of that size to store employee object references
		Employee[] employees = new Employee[count];

		// use for loop to create as many objects (accept values from user and create an
		// employee object with those values)
		// save the object reference in the array
		UiUtility.saveEmployeeInStorage(scanner, employees);

		// iterate through the array, pick up every employee object reference and print
		// his/her name along with calculated salary
		UiUtility.printEmployeeInfo(employees);

		scanner.close();
	}

}
