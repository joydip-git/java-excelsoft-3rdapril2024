import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {

	static void useTreeSet() {
		Set<Integer> numbers = new TreeSet<Integer>();
		numbers.add(12);
		numbers.add(1);
		numbers.add(13);
		numbers.add(1);

		for (Integer item : numbers) {
			System.out.println(item);
		}
	}

	static void useMap() {
//		Map<String, String> map = new HashMap<String, String>();
		/*
		 * Map<String, String> map = new TreeMap<String, String>(); map.put("country",
		 * "India"); map.put("company", "excelsoft"); map.put("city", "mysore");
		 * map.put("state", "karnataka");
		 * 
		 * map.remove("country"); System.out.println(map.containsKey("city"));
		 * System.out.println(map.containsValue("bangalore")); map.replace("city",
		 * "mysuru"); // map.replace("city", "mysore", "mysuru");
		 * 
		 * Set<Entry<String, String>> entries = map.entrySet(); for (Entry<String,
		 * String> entry : entries) { System.out.println(entry.getKey() + ":" +
		 * entry.getValue()); }
		 */
		Map<Student, List<Integer>> studentResults = new TreeMap<Student, List<Integer>>();

		List<Integer> malleshMarks = new ArrayList<Integer>();
		malleshMarks.add(30);
		malleshMarks.add(35);
		malleshMarks.add(40);
		studentResults.put(new Student("mallesh", "Java", 2), malleshMarks);

		List<Integer> geethahMarks = new ArrayList<Integer>();
		geethahMarks.add(32);
		geethahMarks.add(37);
		geethahMarks.add(42);
		studentResults.put(new Student("Geetha", "DotNet", 1), geethahMarks);

		Set<Entry<Student, List<Integer>>> statistics = studentResults.entrySet();
		for (Entry<Student, List<Integer>> entry : statistics) {
			System.out.println("Name: " + entry.getKey());
			System.out.println("--------------------------------------");
			List<Integer> marks = entry.getValue();
			for (Integer mark : marks) {
				System.out.println(mark);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		// useTreeSet();
		// useMap();
		Map<Product, Set<SalesInfo>> salesRecords = new TreeMap<Product, Set<SalesInfo>>();
		
		Product dellLaptop = new Product(2, "dell xps", 120000);
		Set<SalesInfo> salesInfoOfDell = new TreeSet<SalesInfo>();
		salesInfoOfDell.add(new SalesInfo(Month.January, 360000, 3, 2));
		salesInfoOfDell.add(new SalesInfo(Month.February, 600000, 5, 1));
		salesInfoOfDell.add(new SalesInfo(Month.March, 480000, 4, 3));

		Product hpLaptop = new Product(1, "hp probook", 130000);
		Set<SalesInfo> salesInfoOfHp = new TreeSet<SalesInfo>();
		salesInfoOfHp.add(new SalesInfo(Month.January, 520000, 4, 1));
		salesInfoOfHp.add(new SalesInfo(Month.February, 260000, 2, 3));
		salesInfoOfHp.add(new SalesInfo(Month.March, 650000, 5, 2));

		Product lenovoLaptop = new Product(3, "lenovo thinkpad", 100000);
		Set<SalesInfo> salesInfoOfLenovo = new TreeSet<SalesInfo>();
		salesInfoOfLenovo.add(new SalesInfo(Month.January, 500000, 5, 3));
		salesInfoOfLenovo.add(new SalesInfo(Month.February, 700000, 7, 2));
		salesInfoOfLenovo.add(new SalesInfo(Month.March, 600000, 6, 1));

		salesRecords.put(dellLaptop, salesInfoOfDell);
		salesRecords.put(hpLaptop, salesInfoOfHp);
		salesRecords.put(lenovoLaptop, salesInfoOfLenovo);
		
		Set<Entry<Product,Set<SalesInfo>>> entries = salesRecords.entrySet();
		for (Entry<Product, Set<SalesInfo>> entry : entries) {
			System.out.println("Product: "+entry.getKey());
			System.out.println("------------------------------------");
			Set<SalesInfo> sales = entry.getValue();
			for (SalesInfo sale : sales) {
				System.out.println(sale);
			}
			System.err.println("\n");
		}
	}

}
