
public class App {
	int id;
	static int someData = 10;
	static {
		someData = 10;
	}

	public App() {
		// this.id = 0;
	}

	public App(int id) {
		this.id = id;
	}

	public void add(int x, int y) {
	}

	public long add(int x, int y, int z) {
	}

	public void add(int x, int y, long c) {
	}

	public void add(int x, long c, int y) {

	}

	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.id);
		// String message = null;

		// DO NOT:
		// 1. include any keyword in the name
		// 2. start with _ or include _ in the name: _first, first_number
		// 3. include digit or start with digit: 123first, first1
		// 4. use complete upper case FIRST or should not complete lower case

		int firstNumber = 12;
		System.out.println(++firstNumber);

		float floatingPointData = 12.34f;
		double doubleData = 12.34d;
		float another = 12;
		boolean b = true;
		Boolean status = true;// new Boolean(true)
		if (status != null) {
			System.out.println(status.booleanValue());
		}
		System.out.println(status);
		System.out.println(floatingPointData);
		System.out.println(doubleData);
		System.out.println(another);

		String message = createWelcomeMessage("anil");
		System.out.println(message);
	}

	// [access-specifier] [access-modifier] return-type methodName(data-type arg1,
	// data-type arg2,...)
	public static String createWelcomeMessage(String name) {
		return "Welcome " + name;
	}
}
