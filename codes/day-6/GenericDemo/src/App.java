
public class App {

	// generic function
	// E => type parameter
	static <E1,E2> void add(E1 x, E2 y) {

	}

	public static void main(String[] args) {
		add(12, 13);
		add("anil", "mehta");

//		Sample<String> stringSample = new Sample<String>();
//		stringSample.setData("string data");
//		
//		Sample<Integer> intSample = new Sample<Integer>();
//		intSample.setData(100);
//		
		Sample<Person> peopleSample = new Sample<Person>();
		Person p = new Person("anil");
		peopleSample.setData(p);
		//peopleSample.setData("excelsoft");
		Person pData = peopleSample.getData();

//		Sample sample = new Sample();
//		Person p = new Person("anil");
//		sample.setData(p);
//		sample.setData("excelsoft");
//		Person pData = (Person) sample.getData();
	}

}
