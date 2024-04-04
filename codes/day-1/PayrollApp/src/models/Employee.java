package models;


public class Employee {
	private int id;
	private String name;
	private float basicPayment;
	private float daPayment;
	private float hraPayment;
	// private static String organizationName = "excelsoft";
	private static String organizationName;

	// static block: a block where only static data members are assigned with
	// values. Instance members are not allowed inside this block.

	static {
		organizationName = "excelsoft";
	}

	public Employee() {

	}

	public Employee(int id) {
		this.id = id;
	}
	public Employee(int id, String name, float basicPayment, float daPayment, float hraPayment) {
		this.id = id;
		this.name = name;
		this.basicPayment = basicPayment;
		this.daPayment = daPayment;
		this.hraPayment = hraPayment;
	}

	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(float basicPayment) {
		this.basicPayment = basicPayment;
	}

	public float getDaPayment() {
		return daPayment;
	}

	public void setDaPayment(float daPayment) {
		this.daPayment = daPayment;
	}

	public float getHraPayment() {
		return hraPayment;
	}

	public void setHraPayment(float hraPayment) {
		this.hraPayment = hraPayment;
	}

	public static String getOrganizationName() {
		return organizationName;
	}

	public float calculateSalary() {
		return basicPayment + daPayment + hraPayment;
	}

	/*
	 * public static String printCompanmyInfo() { return "static data " +
	 * organizationName; }
	 */
}
