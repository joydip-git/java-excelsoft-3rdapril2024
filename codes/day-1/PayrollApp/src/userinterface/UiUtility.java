package userinterface;

import java.util.Scanner;

import models.Employee;

public final class UiUtility {
	public static void printEmployeeInfo(Employee[] employees) {
		for (Employee employee : employees) {
			if (employee != null)
				System.out.println("salary of " + employee.getName() + " is " + employee.calculateSalary());
			else
				System.out.println("no employee data");
		}
	}

	public static void saveEmployeeInStorage(Scanner scanner, Employee[] employees) {
		for (int index = 0; index < employees.length; index++) {
			Employee employee = createEmployee(scanner);
			employees[index] = employee;
		}
	}

	public static int getEmployeeRecordCount(Scanner scanner) {
		System.out.print("how many records? ");
		int count = scanner.nextInt();
		return count;
	}

	private static Employee createEmployee(Scanner scanner) {

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

}
