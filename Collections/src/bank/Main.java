package bank;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


/*
 * Description:
 * 	simple bank application program in Java that uses the Collection Framework to 
 *	manage customer accounts. The program allows users to create accounts, 
 * 	deposit and withdraw funds, check balances, and list all accounts
 */
public class Main {
	
	private static Set<Account> accounts = new LinkedHashSet<>();

    Scanner scanner = new Scanner(System.in);
  
    /*
    * Check whether entered acnumber is unique or not  
    */
    private boolean isUnique(long acNumber) {
    	
    	if(acNumber<0) {
    		return false;
    	}
    	
    	for (Account account : accounts) {
            if (account.getAcNumber() == acNumber)
            	return false;
    	}
    	
    	return true;
    }
	
    
    /*
     * Create account
     */
    public void createAccount() {
		
		System.out.print("Enter AccountNumber: ");
		long acNumber = scanner.nextLong();
        while(true) {
        	if(!isUnique(acNumber)) {
        		
        		System.out.println("AccountNumber must be unique and Valid...!");
        		acNumber = scanner.nextInt();
        	}else {
        		
        		break;
        	}
        	
        }
        scanner.nextLine();
        
        System.out.print("Enter Account Name: ");
        String name = scanner.nextLine();
       

        
        accounts.add(new Account(acNumber, name));
        
        System.out.println("Account created successfully!");
	}
    
    /*
     * Print list of Accounts
     */
    
    public void printAccounts() {
    	
    	
    	if(!accounts.isEmpty()) {
		
    		System.out.println("Account Details:");
       
    		for (Account account:accounts) {
            
    			System.out.println(account);
    		}
    	}else {
    		
    		System.out.println("No Account Information available...!");
    	}
    }
    
    /*
     * Check whether account is exists or not
     */
    public Account isExists(long acNumber) {
    	
    	for (Account account : accounts) {
            if (account.getAcNumber() == acNumber) 
            	return account;
        }
       return null;
    }
    
  /*
   * Deposit amount in account
   */
    
  public void deposit(long acNumber,double deposit) {
		
	  	Account account = isExists(acNumber);
	  	if(account!= null) {
	  		
	  		if(deposit>0) {
	  			
	  			account.setBalance(deposit);
	  			System.out.println("Deposit Amount: "+deposit+
						"\nBalance: "+account.getBalance());
	  		}else {
	  			
	  			System.out.println("Invalid Amount");
	  		}
	  		
	  	}else {
	  		
	  		System.out.println("Account not exists..!");
	  	}

	}
	
  /*
   * Withdraw ammount from account
   */
	
	public void withDrawal(long acNumber,double withdraw) {
		
		Account account = isExists(acNumber);
	  	if(account!= null) {
	  		
	  		if(account.getBalance()>withdraw && withdraw>0) {
	  			
	  			account.setBalance(account.getBalance()-withdraw);
	  			System.out.println("WithDrawal Amount: "+withdraw+
						"\nBalance: "+account.getBalance());
	  		}else {
	  			
	  			System.out.println("Invalid Amount");
	  		}
	  		
	  	}else {
	  		
	  		System.out.println("Account not exists..!");
	  	}
	}
	
	/*
	 * Display balance in account
	 */
	public void checkBalnce(long acNumber){
		
		Account account = isExists(acNumber);
	  	if(account!= null) {
	  		
	  		System.out.println(account);
	  		
	  	}else {
	  		
	  		System.out.println("Account not exists..!");
	  	}
		
	}
    
    
    
    public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		Main m =  new Main();

        while (true) {
            System.out.println("Bank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. WithDrawal");
            System.out.println("4. Check Balance");
            System.out.println("5. Account List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	m.createAccount();
                    break;
                case 2:{
                	
                    System.out.print("Enter AcNumber:");
                    long acNumber = sc.nextLong();
                    System.out.print("Enter Amount: ");
                    double deposit = sc.nextDouble();
                    m.deposit(acNumber,deposit);
                    break;
                }
                case 3:{
                	System.out.print("Enter AcNumber:");
                    long acNumber = sc.nextLong();
                    System.out.print("Enter Amount: ");
                    double withdraw = sc.nextDouble();
                    m.withDrawal(acNumber,withdraw);
                    break;
                }

                case 4:{
            	  System.out.print("Enter AcNumber:");
                  long acNumber = sc.nextLong();
                  m.checkBalnce(acNumber);
            	  break;
                }
              
                case 5:{
            	  m.printAccounts();
            	  break;
                }
                  
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

	}

}
}
