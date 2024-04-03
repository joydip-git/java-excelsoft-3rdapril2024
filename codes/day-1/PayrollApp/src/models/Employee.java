package models;

public class Employee {
	private int id;
	private String name;
	private float basicPayment;
	private float daPayment;
	private float hraPayment;

	public Employee() {

	}

	public Employee(int id, String name, float basicPayment, float daPayment, float hraPayment) {
		this.id = id;
		this.name = name;
		this.basicPayment = basicPayment;
		this.daPayment = daPayment;
		this.hraPayment = hraPayment;
	}

	public float calculateSalary() {
		return basicPayment + daPayment + hraPayment;
	}

}
