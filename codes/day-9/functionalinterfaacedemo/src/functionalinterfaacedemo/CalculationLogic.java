package functionalinterfaacedemo;

@FunctionalInterface
public interface CalculationLogic<TInput extends Number, TResult extends Number> {
	TResult applyCalculationLogic(TInput a, TInput b);

	// int applyCalculationLogic(int a, int b);
	// void applyPrint(int res);
	
	default int result() {
		return 100;
	}
	static String sayHello() {
		return "";
	}
}
