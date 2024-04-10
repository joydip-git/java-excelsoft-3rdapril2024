import java.util.Objects;

public class App {

	public static void main(String[] args) {
		Product dellProduct = new Product(1, "dell xps 15", 120000);
		Product hpProduct = new Product(2, "hp probook", 110000);

		//Object=> boolean equal(Object obj)
		//if (dellProduct.equals(hpProduct)) {	
		
		//Objects => static boolean equals(Object a, Object b){
		// if( (a==b) || (a!=null && a.equals(b)))
		//}
		if (Objects.equals(dellProduct, hpProduct)) {				
			System.out.println("same");
		} else
			System.out.println("not same");
//		int x = 20;
//		int y = 20;
//		if (Objects.equals(x, y)) {
//			System.out.println("same");
//		} else
//			System.out.println("not same");
	}

}
