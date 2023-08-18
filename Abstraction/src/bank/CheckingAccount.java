package bank;

public class CheckingAccount extends BankAccount{
	
	private final double overdraftLimit = 25;

	
    public CheckingAccount(String accountNumber,String accountHolderName,double balance) {
		
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		
		if(balance>0) {
			
			this.balance = balance;
		}else {
			
			this.balance = 0;
			System.out.println("Balance can't be negative");
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
	/*public void withdraw(double amount) {
	
		if(balance>=amount && amount>0 ){
			
			if(amount<= overdraftLimit){
			
					balance -= amount;
					displayInfo();
			}else {
			
				    balance -= amount;
				    displayInfo();
					System.out.println("Extra charges applied exceeds");
			}
		
		}else {
			
			System.out.println("Insufficient Balance");
		}
		
	}*/
	
	
	public void withdraw(double amount) {
		
		if(amount>0) {
			
			if(balance>=amount || amount-balance<= overdraftLimit) {
				
				if(balance>= amount) {
					
					balance -= amount;
					displayInfo();
					
				}else if(balance<amount && amount-balance<= overdraftLimit){
					
					balance-= amount;
					displayInfo();
					
					System.out.println("Extra charges applied");
					balance =0;
				}
				
			}else {
					
					System.out.println("Insufficient Balance and OverdraftLimit exceeds!");
			 }
				
		}else {
					
				System.out.println("Invalid withdrawal amount ");
			}
		}
	
	
	
	

}
