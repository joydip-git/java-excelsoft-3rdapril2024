package onlinetransferapp;

public class App {

	public static void main(String[] args) {
		Account joydipAccount = new Account(1, "joydip", 10000);
		Account akashAccount = new Account(2, "akash", 20000);
		
		double amountToTransfer = 5000;
	
		boolean debitStatus = akashAccount.debit(amountToTransfer);
		
		if (debitStatus) {
			boolean creditStatus = joydipAccount.credit(amountToTransfer);
			
			System.out.println("current balance of " + akashAccount.getAccountName() + " is "
					+ akashAccount.getCurrentBalance());
			
			if (creditStatus) {
				System.out.println("transaction complete");
				System.out.println("current balance of " + akashAccount.getAccountName() + " is "
						+ akashAccount.getCurrentBalance());
				System.out.println("current balance of " + joydipAccount.getAccountName() + " is "
						+ joydipAccount.getCurrentBalance());
			} else {
				akashAccount.credit(amountToTransfer);
				System.out.println("could not transfer..any amount debited will be credited to you");
				System.out.println("current balance of " + akashAccount.getAccountName() + " is "
						+ akashAccount.getCurrentBalance());
				System.out.println("current balance of " + joydipAccount.getAccountName() + " is "
						+ joydipAccount.getCurrentBalance());
			}
		} else {
			System.out.println(
					"could not transfer as amount could not be debited..any amount debited will be credited to you");
			System.out.println(
					"current balance of " + akashAccount.getAccountName() + " is " + akashAccount.getCurrentBalance());
			System.out.println("current balance of " + joydipAccount.getAccountName() + " is "
					+ joydipAccount.getCurrentBalance());
		}

	}

}
