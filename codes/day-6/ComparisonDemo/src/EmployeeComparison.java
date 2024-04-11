import java.util.Comparator;

public class EmployeeComparison implements Comparator {

	private int choice;

	public EmployeeComparison() {
	}

	public EmployeeComparison(int choice) {
		this.choice = choice;
	}

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 == o2)
			return 0;

		Employee first = (Employee) o1;
		Employee next = (Employee) o2;

//		if (Integer.compare(first.getId(), next.getId()) == 0)
//			return first.getName().compareTo(next.getName());
//		else
//			return Integer.compare(first.getId(), next.getId());

		int compResult = 0;
		switch (choice) {
		case 1:
			compResult = Integer.compare(first.getId(), next.getId());
			break;

		case 2:
			compResult = first.getName().compareTo(next.getName());
			break;

		default:
			compResult = Integer.compare(first.getId(), next.getId());
			break;
		}
		return compResult;
	}

}
