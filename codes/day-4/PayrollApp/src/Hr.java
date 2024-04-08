
public class Hr extends Employee {
	//data members
	private double gratuityPayment;

	//constructors
	public Hr() {
	}

	public Hr(int id, String name, double basicPayment, double daPayment, double hraPayment, double gratuityPayment) {
		super(id, name, basicPayment, daPayment, hraPayment);
		this.gratuityPayment = gratuityPayment;
	}

	//getters and setters
	public double getGratuityPayment() {
		return gratuityPayment;
	}

	public void setGratuityPayment(double gratuityPayment) {
		this.gratuityPayment = gratuityPayment;
	}

	//methods
	@Override
	public double calculateSalary() {
		return super.calculateSalary() + this.gratuityPayment;
	}

}
