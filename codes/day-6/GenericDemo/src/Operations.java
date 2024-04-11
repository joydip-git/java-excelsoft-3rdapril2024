public interface Operations<T1 extends Number, T2 extends Number, TR extends Number> {
	TR add(T1 a, T2 b);

	TR subtract(T1 a, T2 b);
}

class CalculationOperations implements Operations<Double, Double, Double>{

	@Override
	public Double add(Double a, Double b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double subtract(Double a, Double b) {
		// TODO Auto-generated method stub
		return null;
	}

	
}