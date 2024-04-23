import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Logic {
	boolean applyLogic(int element);
//	class Ano implements Logic{
//		@Override
//		public boolean applyLogic(int element) {
//			return element % 2 == 0;
//		}
//	}
}

@FunctionalInterface
interface CompareLogic {
	int applyComparsionLogic(int a, int b);
}

public class App {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(6);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);

		Logic evenLogic = new Logic() {
			@Override
			public boolean applyLogic(int element) {
				return element % 2 == 0;
			}
		};
		Logic oddLogic = new Logic() {

			@Override
			public boolean applyLogic(int element) {
				return element % 2 != 0;
			}
		};

		CompareLogic ascCompare = new CompareLogic() {

			@Override
			public int applyComparsionLogic(int a, int b) {
				return Integer.compare(a, b);
			}
		};
		
		CompareLogic descCompare = new CompareLogic() {
			
			@Override
			public int applyComparsionLogic(int a, int b) {
				return Integer.compare(b, a);
			}
		};
		// filter method will filter ONLY even numbers from the list passed to it
		// and returns a new list containing those even numbers
		// App app = new App();
		List<Integer> evenNumbers = filter(list, evenLogic);
		if (evenNumbers != null && evenNumbers.size() > 0) {
			for (Integer value : evenNumbers) {
				System.out.println(value);
			}
		}

		System.out.println("\n\n");
		List<Integer> sortedNumbers = sort(list, descCompare);
		for (Integer value : sortedNumbers) {
			System.out.println(value);
		}

	}

	static boolean isEven(int element) {
		return element % 2 == 0;
	}

	private static List<Integer> filter(List<Integer> inputList, Logic logic) {
		List<Integer> outputList = null;

		if (inputList != null && inputList.size() > 0) {
			outputList = new ArrayList<Integer>();

			for (Integer element : inputList) {
				boolean isTrue = logic.applyLogic(element);
				if (isTrue)
					outputList.add(element);
			}
		}

		return outputList;
	}

	static List<Integer> sort(List<Integer> inputList, CompareLogic cmpLogic) {
		if (inputList != null && inputList.size() > 0) {

			for (int i = 0; i < inputList.size(); i++) {
				for (int j = i + 1; j < inputList.size(); j++) {

					// int compRes = Integer.compare(inputList.get(i), inputList.get(j));
					int compRes = cmpLogic.applyComparsionLogic(inputList.get(i), inputList.get(j));
					if (compRes > 0) {
						int temp = inputList.get(i);
						inputList.set(i, inputList.get(j));
						inputList.set(j, temp);
					}
				}
			}
		}
		return inputList;
	}
}
