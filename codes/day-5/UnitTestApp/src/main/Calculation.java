package main;

public class Calculation {
	public int add(int first, int second) {
		return first + second;
	}

	public int divide(int first, int second) {
		if (second == 0) {
			throw new ArithmeticException("divisor can't be zero");
		}
		return first / second;
	}
}
