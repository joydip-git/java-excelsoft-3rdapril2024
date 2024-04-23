
public class Outer {
	private String name;
	private static String staticName;
	static {
		staticName = "Anil";
	}

	public Outer() {
	}

	public Outer(String _name) {
		name = _name;
	}

	static class Inner {
		public String sayHello() {
			// return "Hello..." + name;
			return "Hello " + staticName;
		}
	}
}
