import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	static int getValue(Scanner scanner) throws NullPointerException, InputMismatchException, Exception {

		System.out.print("enter value: ");
		int value = scanner.nextInt();
		return value;

//		try {
//			System.out.print("enter value: ");
//			int value = scanner.nextInt();
//			return value;
//		}catch(InputMismatchException e) {
//			throw e;
//		}catch(Exception e) {
//			throw e;
//		}
	}

	public static void main(String[] args) {
		Scanner scanner = null;

		try {
			// scanner = new Scanner(System.in);
			int value = getValue(scanner);
			System.out.println(value);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getSuperclass().getSuperclass().getName());
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

}
