import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int[] numbers = new int[] { 2, 1, 5, 7, 3, 8, 0, 9, 4, 6 };
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
//				if (numbers[i] > numbers[j]) {
				int compRes = Integer.compare(numbers[i], numbers[j]);
				if (compRes > 0) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		for (int i : numbers) {
			System.out.println(i);
		}		
		
		Employee[] employees = new Employee[] { 
				new Employee(2, "sunil"), 
				new Employee(1, "joydip"),
				new Employee(3, "anil") 
		};

		System.out.println("1. sort by id \n2. sort by name");
		System.out.print("enter choice[1/2]: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		
		EmployeeComparison comparerObj = new EmployeeComparison(choice);

		for (int i = 0; i < employees.length; i++) {
			for (int j = i + 1; j < employees.length; j++) {

				// int compRes = employees[i].compareTo(employees[j]);
				int compRes = comparerObj.compare(employees[i], employees[j]);
				if (compRes > 0) {
					Employee temp = employees[i];
					employees[i] = employees[j];
					employees[j] = temp;
				}
			}
		}
	}

}
