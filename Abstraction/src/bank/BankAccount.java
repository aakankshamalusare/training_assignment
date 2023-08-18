package bank;

public abstract class BankAccount {
	
	protected String accountNumber;
	protected String accountHolderName;
	protected double balance;
	
	public abstract String getAccountNumber();
	public abstract String getAccountHolderName();
	public abstract double getBalance();
	
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	
	public void displayInfo() {
		
		System.out.println("AccountNumber: "+ accountNumber+
				"\nAccountHolderName: "+accountHolderName+
				"\nBalance: "+getBalance());
	}

}
