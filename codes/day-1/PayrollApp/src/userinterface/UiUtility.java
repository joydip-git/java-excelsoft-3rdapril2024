package userinterface;

import java.util.Scanner;
import models.Employee;

public final class UiUtility {
	private static Employee[] employees;
	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
		employees = new Employee[getEmployeeRecordCount()];
	}

	private static int getEmployeeRecordCount() {
		System.out.print("how many records? ");
		int count = scanner.nextInt();
		return count;
	}

	private static Employee createEmployee() {

		System.out.print("\nid: ");
		int id = scanner.nextInt();

		Employee employee = new Employee(id);

		System.out.print("\nname: ");
		String name = scanner.next();
		employee.setName(name);

		System.out.print("\nbasic: ");
		float basic = scanner.nextFloat();
		employee.setBasicPayment(basic);

		System.out.print("\nda: ");
		float da = scanner.nextFloat();
		employee.setDaPayment(da);

		System.out.print("\nhra: ");
		float hra = scanner.nextFloat();
		employee.setHraPayment(hra);

		return employee;
	}

	public static void saveEmployeeInStorage() {
		for (int index = 0; index < employees.length; index++) {
			Employee employee = createEmployee();
			employees[index] = employee;
		}
	}

	public static void printEmployeeInfo() {
		for (Employee employee : employees) {
			if (employee != null)
				System.out.println("salary of " + employee.getName() + " is " + employee.calculateSalary());
			else
				System.out.println("no employee data");
		}
	}

	public static void dispose() {
		if (scanner != null)
			scanner.close();
	}
}
