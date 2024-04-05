package inheritancedemoapp;

class Account{
	protected String name;
	protected int id;
	protected double currentBalance;
	
	public Account() {}

	public Account(String name, int id, double currentBalance) {		
		this.name = name;
		this.id = id;
		this.currentBalance = currentBalance;
	}
	
}
class SavingsAccount extends Account{
	private double savingsInterestRate;
	
	public SavingsAccount() {
		
	}
	public SavingsAccount(int id, String name, double currentBalance, double interestRate) {
		this.id= id;
		this.name = name;
		this.currentBalance = currentBalance;
		this.savingsInterestRate = interestRate;
	}
}
public class App {
	public static void main(String[] args) {
		SavingsAccount savingsAccount = new SavingsAccount(1, "anil", 1000, 4.5d);
	}
}
