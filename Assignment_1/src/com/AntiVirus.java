package com;

class Transaction{
	
	
	private static final int productKey = 123456789;
	
	public static boolean transactionDone(int key) {
		
		if(productKey == key) {
			
		
				return true;
		}
		
		return false;
		
	}
	
}

public class AntiVirus {
	
	
	
	public AntiVirus() {
		
		System.out.println("You are using free version ,please upgrade");
	}
	
	public AntiVirus(int productKey) {
		
		if(Transaction.transactionDone(productKey)) {
			
			System.out.println("Using Antivirus");
		
		}else {
			
			System.out.println("Trancation is not done - please pay first to activate product key");
		}
	}
		
	
	public static void main(String...args) {
		
		AntiVirus a1 = new AntiVirus(123456789);
		
	}

}
