package com;


/*
 * Encapsulation and Access Control:
 */

public class BankAccount {

	private long accountNumber;
	private static double balance = 0;
	private String ownerName;
	

	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		
		if(balance>0) {
		
			BankAccount.balance = balance;
		}else {
			
			System.out.println("Invalid Amount");
		}
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
	public void deposit(double deposit) {
		
		if(deposit>0) {
			balance+=deposit;
			
			System.out.println("Deposit Amount: "+deposit+
					"\nBalance: "+balance);
		}else {
		
			System.out.println("Invalid Amount");
		}
		
		
	}
	
	
	public void withDraw(double withdraw) {
		
		if(balance>withdraw) {
			
			balance-= withdraw;
			System.out.println("WithDrawal Amount: "+withdraw+
								"\nBalance: "+balance);
		}else {
			
			System.out.println("Insufficient Balance");
		}
	}
	
	
   public static void main(String...args) {
	   
	   BankAccount client = new BankAccount();
	   
	   client.setAccountNumber(13332);
	   client.setOwnerName("AK");
	   client.setBalance(10000);
	   
	   System.out.println(client.getBalance());
	   client.withDraw(1000);
	   
	   client.deposit(1000);
	   
	   
   }
	
}
