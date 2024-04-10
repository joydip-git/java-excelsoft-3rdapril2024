import java.util.Scanner;

public class App {

	static int getCount(Scanner scanner) {
		System.out.print("enter number of records: ");
		return scanner.nextInt();
	}

	static char getChoice(Scanner scanner) {
		System.out.print("enter choice[s/p]: ");
		return scanner.next().charAt(0);
	}

	static Person create(char choice, Scanner scanner) {
		System.out.print("\n enter name: ");
		String name = scanner.next();

		Person person = null;
		switch (choice) {
		case 's':
			System.out.print("enter marks: ");
			double marks = scanner.nextDouble();
			person = new Student(name, marks);
			break;

		case 'p':
			System.out.print("enter number of books published: ");
			int books = scanner.nextInt();
			person = new Professor(name, books);
			break;

		default:
			System.out.println("enter proper choice");
			break;
		}
		return person;
	}

	static void savePeopleInStorage(Person[] people, Scanner scanner) {
		for (int index = 0; index < people.length; index++) {
			System.out.println("1. Student[s] \n2. Professor[p]");
			char choice = getChoice(scanner);
			Person person = create(choice, scanner);
			people[index] = person;
		}
	}

	static void printOutstandingPeople(Person[] people) {
		for (Person person : people) {
			if (person != null) {
				boolean isOutstanding = person.isOutstanding();
				if (isOutstanding) {
					if (person instanceof Student) {
						Student student = (Student) person;
						System.out.println("\n" + student.display());
					}
					if (person instanceof Professor) {
						Professor professor = (Professor) person;
						System.out.println("\n" + professor.print());
					}
				}
			} else
				System.out.println("person record does not exist");
		}
	}

	public static void main(String[] args) {

		Professor anilProf = new Professor("anil", 5);
		Professor sunilProf = new Professor("anil", 5);
		if(anilProf.equals(sunilProf))
			System.out.println("same");
		else
			System.out.println("not same");

		/*
		 * Scanner scanner = new Scanner(System.in); int count = getCount(scanner);
		 * 
		 * Person[] people = new Person[count]; savePeopleInStorage(people, scanner);
		 * 
		 * printOutstandingPeople(people);
		 * 
		 * scanner.close();
		 */
	}

}
