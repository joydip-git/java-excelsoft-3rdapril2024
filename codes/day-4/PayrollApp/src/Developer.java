
public class Developer extends Employee {
// data members
	private double incentivePayment;

	// constructors
	public Developer() {
	}

	public Developer(int id, String name, double basicPayment, double daPayment, double hraPayment,
			double incentivePayment) {
		super(id, name, basicPayment, daPayment, hraPayment);
		this.incentivePayment = incentivePayment;
	}

	// getters and setters
	public double getIncentivePayment() {
		return incentivePayment;
	}

	public void setIncentivePayment(double incentivePayment) {
		this.incentivePayment = incentivePayment;
	}
	
	//methods
	@Override
	public double calculateSalary() {
		return super.calculateSalary() + incentivePayment;
	}

}
