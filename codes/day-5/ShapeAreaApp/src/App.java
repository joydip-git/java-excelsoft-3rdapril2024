import java.util.Scanner;

public class App {

	static int getCount(Scanner scanner) {
		System.out.print("enter number of shapes to create: ");
		return scanner.nextInt();
	}

	static char getChoice(Scanner scanner) {
		System.out.print("enter choice[c/t]: ");
		return scanner.next().charAt(0);
	}

	static Shape create(char choice, Scanner scanner) {

		Shape shape = null;
		switch (choice) {
		case 'c':
			System.out.print("enter radius: ");
			double radius = scanner.nextDouble();
			shape = new Circle(radius);
			break;

		case 't':
			System.out.print("enter base: ");
			double base = scanner.nextDouble();
			System.out.print("enter height: ");
			double height = scanner.nextDouble();
			shape = new Triangle(base, height);
			break;

		default:
			System.out.println("enter proper choice");
			break;
		}
		return shape;
	}

	static void saveShapesInStorage(Shape[] shapes, Scanner scanner) {
		for (int index = 0; index < shapes.length; index++) {
			System.out.println("1. Circle[c] \n2. Triangle[t]");
			char choice = getChoice(scanner);
			Shape shape = create(choice, scanner);
			shapes[index] = shape;
		}
	}

	static void printShapeArea(Shape[] shapes) {
		for (Shape shape : shapes) {
			if (shape != null) {
				double area = shape.calculateArea();
				Class clsInfo = shape.getClass();
				String clsName = clsInfo.getName();
				System.out.println("area of " + clsName + " is " + area);
			} else
				System.out.println("shape record does not exist");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = getCount(scanner);

		Shape[] shapes = new Shape[count];
		saveShapesInStorage(shapes, scanner);
		
		printShapeArea(shapes);

		scanner.close();
	}

}
