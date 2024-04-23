package functionalinterfaacedemo;

public class App {

	public static void main(String[] args) {
//		PrintLogic<String> printLogic = new PrintLogic<String>() {
//			
//			@Override
//			public void print(String value) {
//				System.out.println(value);
//			}
//		};

		// Lambda syntax
		// Method Reference: Functional interface variable storing reference of
		// a single method
//		PrintLogic<String> printLogic = (String value) -> {
//			System.out.println(value);
//		};
//		PrintLogic<String> printLogic = value -> {
//			System.out.println(value);
//		};
		PrintLogic<String> printLogic = value -> System.out.println(value);
		// PrintLogic printLogic = new Implementation();
		// printLogic.print("joydip");
		display(printLogic, "Joydip");

		// anonymous inner type syntax
		CalculationLogic<Integer, Integer> addLogic = new CalculationLogic<Integer, Integer>() {

			@Override
			public Integer applyCalculationLogic(Integer a, Integer b) {
				return a + b;
			}
//			@Override
//			public void applyPrint(int res) {
//				// TODO Auto-generated method stub
//				
//			}
		};

		PrintLogic<Integer> printIntRes = (res) -> System.out.println(res);
		
		int addRes = addLogic.applyCalculationLogic(12, 13);
		// System.out.println(addRes)		
		display(printIntRes, addRes);

		// Lambda syntax-1: with parenthesis for function body
		CalculationLogic<Float, Float> subtractLogic = (Float a, Float b) -> {
			return a - b;
		};

		float subRes = subtractLogic.applyCalculationLogic(12f, 3f);
		//System.out.println(subRes);
		PrintLogic<Float> printFloatRes = (res) -> System.out.println(res);
		display(printFloatRes, subRes);

		// Lambda syntax-2: without parenthesis for function body and
		// data types for arguments
		CalculationLogic<Double, Double> multiplyLogic = (a, b) -> a * b;
		Double multiplyRes = multiplyLogic.applyCalculationLogic(12d, 3d);
		PrintLogic<Double> printDoubleRes = res->System.err.println(res);
		//System.out.println(multiplyRes);
		display(printDoubleRes, multiplyRes);
	}

	static <T> void display(PrintLogic<T> printLogic, T valueToPrint) {
		printLogic.print(valueToPrint);
	}

}
