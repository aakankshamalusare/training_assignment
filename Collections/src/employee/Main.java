package employee;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 
 * Description:
 * 	Implement a program in Java that manages employee records using the 
 * Collection Framework. The program should allow users to perform various 
 * operations related to employee records, such as adding employees, viewing 
 * their details, and searching for employees based on their ID. Use suitable data 
 * structures from the Collection Framework to store and manage employee 
 * records
 * 
 */

public class Main {
	
	private static Set<Employee> employees = new LinkedHashSet<>();

    Scanner scanner = new Scanner(System.in);
  
    /*
    * Check whether entered id is unique or not  
    */
    private boolean isUnique(int id) {
    	
    	if(id<0) {
    		return false;
    	}
    	
    	for (Employee employee : employees) {
            if (employee.getId() == id)
            	return false;
    	}
    	
    	return true;
    }
	
    
    /*
     * Add employee to list of employee
     */
    public void addEmployee() {
		
		System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        while(true) {
        	if(!isUnique(id)) {
        		
        		System.out.println("ID must be unique and Valid...!");
        		id = scanner.nextInt();
        	}else {
        		
        		break;
        	}
        	
        }
        scanner.nextLine();
        
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
       
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        
        employees.add(new Employee(id, name, salary));
        
        System.out.println("Employee added successfully!");
	}
    
    /*
     * Print list of employees
     */
    
    public void printEmployees() {
    	
    	
    	if(!employees.isEmpty()) {
		
    		System.out.println("Employee Details:");
       
    		for (Employee employee : employees) {
            
    			System.out.println(employee);
    		}
    	}else {
    		
    		System.out.println("No Employee Information available...!");
    	}
    }
    
    /*
     * Search employee with specified Id
     */
    public void SearchEmployee(int searchId) {
    	
    	boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == searchId) {
                System.out.println("Employee found: " + employee);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + searchId + " not found.");
        }
    	
    	
    }
    
    public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		Main m =  new Main();

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	m.addEmployee();
                    break;
                case 2:
                    m.printEmployees();
                    break;
                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    m.SearchEmployee(searchId);
                    break;
               case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

	}

}





	
}
