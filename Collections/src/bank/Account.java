package bank;

public class Account {
	
	private long acNumber;
	private String name;
	private double balance;
	
	
	public long getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(long acNumber) {
		this.acNumber = acNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public Account() {
		
	}
	
	public Account(long acNumber, String name) {
		super();
		this.acNumber = acNumber;
		this.name = name;
		this.balance = 0;
	}
	
	@Override
	public String toString() {
		return "Account [acNumber=" + acNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
	

}
