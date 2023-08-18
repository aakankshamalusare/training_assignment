package bank;

public class Main {

	public static void main(String[] args) {
	
		BankAccount b1 = new SavingsAccount("AC0001","AK",1000,1);
		b1.deposit(100);
		System.out.println("-------------------------------------");
		
		BankAccount b2 = new CheckingAccount("AC0002","ABC",100);
		System.out.println("-------------------------------------");
		b2.withdraw(45);
		System.out.println("-------------------------------------");
		b2.withdraw(55);
		System.out.println("-------------------------------------");
		b2.withdraw(25);
		System.out.println("-------------------------------------");
		b2.withdraw(50);
		System.out.println("-------------------------------------");

	}

}
