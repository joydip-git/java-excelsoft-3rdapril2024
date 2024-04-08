
public interface Sample {

	void foo();
}

public interface Abstraction {
	String getPath();

	void setPath(String path);
}

class Implementation implements Sample, Abstraction {

	private String path;

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void foo() {
		System.out.println("foo...");
	}

}

class App {
	public static void main(String[] args) {
		Implementation implementation = new Implementation();
		implementation.setPath("");
		implementation.getPath();
		implementation.foo();
		
		Sample sample = implementation;
		sample.foo();
		
		Abstraction abstraction = implementation;
		abstraction.setPath("");
		abstraction.getPath();
	}
}
