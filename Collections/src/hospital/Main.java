package hospital;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Description:
 * 	example of a hospital management system program in Java that uses a HashMap 
 * to manage patient records. This program allows users to add patients, view their 
 * details, search for patients by their ID, and list all patients.
 */

public class Main {
	
	private static HashMap<Integer,Patient> patients = new HashMap<>();
	
	Scanner scanner =  new Scanner(System.in);
	
	/*
	 * Check whether entered id is unique or not  
	 */
	
	private boolean isUnique(int id) {
	    	
	    	if(id<0) {
	    		return false;
	    	}
	    	
	    	if(patients.containsKey(id)) {
	    		return false;
	    	}
	    	return true;
	}
	
	
	/*
	 * Add Patient to records
	 */
	
    public void addPatient() {
		
		System.out.print("Enter PatientID: ");
		int id = scanner.nextInt();
        while(true) {
        	if(!isUnique(id)) {
        		
        		System.out.println("PatientID must be unique and Valid...!");
        		id = scanner.nextInt();
        	}else {
        		
        		break;
        	}
        	
        }
        scanner.nextLine();
        
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        
       
        	int age;
        
        
        while(true) {
        	
        	 System.out.print("Enter Patient Age: ");
             age = scanner.nextInt();
        	
        	if(age<=0 || age>100) {
        		System.out.println("Patient Age must be Valid..!");
        		
        	}else {
        		
        		break;
        	}
        }
        scanner.nextLine();
        
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.nextLine();
        
        patients.put(id, new Patient(name,age,gender));
        System.out.println("Patient added successfully!");
	}
    
    /*
     * Print list of Patients
     */
    
    public void printPatients() {
    	
    	
    	if(!patients.isEmpty()) {
		
    		System.out.println("Patient Details:");
    		
    		for (Map.Entry<Integer, Patient>patient:patients.entrySet()) {
            
    			System.out.println(patient.getKey()+":"+patient.getValue());
    		}
    	}else {
    		
    		System.out.println("No Patient Information available...!");
    	}
    }
    
    /*
     *  Search patient with specified ID
     */
    public void searchPatient(int id) {
    	
    	if(patients.containsKey(id)) {
    		
    		System.out.println(patients.get(id));
    	}else {
    		System.out.println("Patient with ID " + id + " not found.");
    	}
    	
    }
    
	
	public static void main(String...args) {
		
		  Scanner scanner = new Scanner(System.in);
		  Main m = new Main();
		  
		  while (true) {
	            System.out.println("Hospital Management System");
	            System.out.println("1. Add Patient");
	            System.out.println("2. Search Patient by ID");
	            System.out.println("3. List All Patients");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
                case 1:
                    m.addPatient();
                    break;

                case 2:
                    System.out.print("Enter patient ID: ");
                    int id = scanner.nextInt();
                    m.searchPatient(id);
                    break;


                case 3:
                	m.printPatients();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
	}

}
