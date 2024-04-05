package onlinetransferapp;

public class Account {
	private int accountId;
	private String accountName;
	private double currentBalance;
	public final static double MINIMUM_BALANCE = 5000;
	public final static double WITHDRAWAL_LIMIT = 15000;

	public Account() {
	}

	public Account(int accountId, String accountName, double currentBalance) {		
		this.accountId = accountId;
		this.accountName = accountName;
		this.currentBalance = currentBalance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountId() {
		return accountId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public boolean debit(double amount) {
		if (amount <= 0)
			return false;
		
		if (amount > WITHDRAWAL_LIMIT)
			return false;

		if (amount > currentBalance)
			return false;		

		currentBalance -= amount;
		return true;
	}

	public boolean credit(double amount) {
		currentBalance += amount;
		return true;
	}
}
