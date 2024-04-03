package userinterface;

import models.Employee;

public class App {

	public static void main(String[] args) {
		Employee anilEmployeeRef = new Employee(1, "anil", 1000, 2000, 3000);
		Employee[] employees = new Employee[2];
		employees[0] = anilEmployeeRef;
		float anilSalary = anilEmployeeRef.calculateSalary();
		System.out.println(anilSalary);
	}

}
