import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(4);
		numbers.add(1);
		numbers.add(5);
		numbers.add(2);
		numbers.add(6);
		numbers.add(3);

		numbers.stream()
		.filter((a) -> a % 2 == 0 ? true : false)
		.sorted((a, b) -> a - b)
		.toList()
		.forEach((n) -> System.out.println(n));

		Function<Integer, Integer> first = x -> x + 2;
		Function<Integer, Integer> second = x -> x - 2;
		Function<Integer, Integer> third = x -> x * 2;
		
		Function<Integer, Integer> resultant = first
		.andThen(second)
		.compose(third);
		
		System.out.println("\n\n");
		Integer result = resultant.apply(10);
		System.out.println(result);

		/*
		 * Stream<Integer> streammableNumbers = numbers.stream();
		 * 
		 * Comparator<Integer> compareNumbers = (a, b) -> a - b; Stream<Integer>
		 * sortedStreammableNumbers = streammableNumbers.sorted(compareNumbers);
		 * 
		 * Predicate<Integer> isEven = (a) -> a % 2 == 0 ? true : false; Stream<Integer>
		 * filteredAndSortedStreammableNumbers =
		 * sortedStreammableNumbers.filter(isEven);
		 * 
		 * Predicate<Integer> isGreater = (n) -> n >= 2; Stream<Integer> finalStream =
		 * filteredAndSortedStreammableNumbers.takeWhile(isGreater); List<Integer>
		 * result = finalStream.toList();
		 * 
		 * Consumer<Integer> print = (n) -> System.out.println(n); ;
		 * result.forEach(print);
		 */
	}
}
