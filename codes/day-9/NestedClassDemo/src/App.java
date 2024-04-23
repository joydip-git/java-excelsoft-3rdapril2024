
public class App {

	public static void main(String[] args) {
		// Outer outer = new Outer("anil");
		// Outer.Inner inner = outer.new Inner();
		// System.out.println(inner.sayHello());

//		Outer.Inner inner = new Outer.Inner(); 
//		System.out.println(inner.sayHello());

		OuterAbsCls outerAbsCls = new OuterAbsCls() {

			@Override
			public String sayHello() {
				return "hello...";
			}
		};
		System.out.println(outerAbsCls.sayHello());

		Contract contractInnerClassObject = new Contract() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		System.out.println(contractInnerClassObject.add(12, 13));
	}

}
