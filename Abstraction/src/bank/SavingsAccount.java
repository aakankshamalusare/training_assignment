package bank;

public class SavingsAccount extends BankAccount{

	private double interestRate;
	
	
	public SavingsAccount(String accountNumber,String accountHolderName,double balance,double interestRate) {
		
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		if(balance>0) {
			
			this.balance = balance;
		}else {
			
			this.balance = 0;
			System.out.println("Balance can't be negative");
		}
		
		if(interestRate>0) {
			
			this.interestRate = interestRate;
		}else {
			
			this.interestRate = 0;
			System.out.println("InterestRate can't be negative");
		}
	}
	
	
	@Override
	public String getAccountNumber() {
		
		return accountNumber;
	}

	@Override
	public String getAccountHolderName() {
		
		return accountHolderName;
	}

	@Override
	public double getBalance() {
		
		return balance;
	}


	@Override
	public void deposit(double amount) {
	
		if(amount>0) {
			
			balance+= amount;
			displayInfo();
		}else {
			
			System.out.println("Invalid deposit Amount");
		}
	}

	@Override
	public void withdraw(double amount) {
	
		if(balance>=amount && amount>0){
			
			balance -= amount;
			displayInfo();
		
		}else {
			
			System.out.println("Insufficient Balance");
		}
		
	}
		
	
	

}
