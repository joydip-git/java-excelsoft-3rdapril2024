

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