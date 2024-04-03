import java.io.InputStream;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		Scanner scanner = new Scanner(inputStream);
		int[] numbers = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			// System.out.println(numbers[i]);
			numbers[i] = scanner.nextInt();
		}
		for (int i : numbers) {
			System.out.println(i);
		}
		
		String[] people = new String[2];
		people[0]="anil";
		people[1]="sunil";
				
		scanner.close();
	}

}
