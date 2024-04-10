import java.util.Objects;

public class App {

	public static void main(String[] args) {
		Product dellProduct = new Product(1, "dell xps 15", 120000);
		Product hpProduct = new Product(2, "hp probook", 110000);

		// Object class's "equals" method
		// boolean equals(Object obj)
		if (dellProduct.equals(hpProduct)) {
			System.out.println("same");
		} else
			System.out.println("not same");

		// Objects => utility class
		// static boolean equals(Object a, Object b)

		if (Objects.equals(dellProduct, hpProduct)) {
			// if(dellProduct == hpProduct) return true;
			// if(dellProduct.equals(hpProduct)) return true; else return false;

			System.out.println("same");
		} else
			System.out.println("not same");

	}
}
