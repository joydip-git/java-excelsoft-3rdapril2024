
public class App {

	public static void main(String[] args) {

		Developer anilDeveloper = new Developer(1, "anil", 1000, 2000, 3000, 4000);
		Hr sunilHr = new Hr(2, "sunil", 1200, 2200, 3200, 4200);
		
		Employee[] employees = new Employee[2];
		employees[0]= anilDeveloper;
		employees[1]= sunilHr;
//		printSalary(anilDeveloper);
//		printSalary(sunilHr);
		
		for (Employee employee : employees) {
			printSalary(employee);
		}
	}

	// all Developer and Hr instances will be up-casted to Employee
	static void printSalary(Employee employee) {
		if (employee != null) {
			System.out.println(employee.getName() + " got salary of " + employee.calculateSalary());
//			if(employee instanceof Developer) {
//				//down-casting
//				Developer developer = (Developer)employee;
//				System.out.println(developer.getIncentivePayment());
//			}
//			if(employee instanceof Hr) {
//				//down-casting
//				Hr hr = (Hr)employee;
//				System.out.println(hr.getGratuityPayment());
//			}
		}
	}
//	static void printSalary(Developer developer) {
//		System.out.println(developer.calculateSalary());
//	}
//	static void printSalary(Hr hr) {
//		System.out.println(hr.calculateSalary());
//	}

}
