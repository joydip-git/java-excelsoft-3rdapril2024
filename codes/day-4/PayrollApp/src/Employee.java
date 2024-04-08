
public class Employee {

	// data members (fields)
	private int id;
	private String name;
	private double basicPayment;
	private double daPayment;
	private double hraPayment;

	// constructors
	public Employee() {
		super();
	}

	public Employee(int id, String name, double basicPayment, double daPayment, double hraPayment) {
		super();
		this.id = id;
		this.name = name;
		this.basicPayment = basicPayment;
		this.daPayment = daPayment;
		this.hraPayment = hraPayment;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public double getDaPayment() {
		return daPayment;
	}

	public void setDaPayment(double daPayment) {
		this.daPayment = daPayment;
	}

	public double getHraPayment() {
		return hraPayment;
	}

	public void setHraPayment(double hraPayment) {
		this.hraPayment = hraPayment;
	}

	public int getId() {
		return id;
	}

	//method
	public double calculateSalary() {
		return basicPayment + daPayment + hraPayment;
	}

}
