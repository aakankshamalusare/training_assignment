package school;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Description:
 * 	simple example of a school management system program in Java. This program 
 * uses the Collection Framework to manage student and teacher records. It allows 
 * users to add students and teachers, display their details, and exit the program
 */


public class Main {
	
	private static Set<Student> students = new LinkedHashSet<>();
	private static Set<Teacher> teachers = new LinkedHashSet<>();

    Scanner scanner = new Scanner(System.in);
  
    /*
    * Check whether entered id is unique or not  
    */
    private boolean isUnique(int id) {
    	
    	if(id<0) {
    		return false;
    	}
    	
    	for (Student student : students) {
            if (student.getId() == id)
            	return false;
    	}
    	
    	return true;
    }
	
    
    /*
     * Add to list 
     */
    public void add(boolean flag) {
		
		System.out.print("Enter ID: ");
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
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
       
        if(flag) {
        	teachers.add(new Teacher(id,name));
        	 System.out.println("Teacher added successfully!");
        }else {
        	
        	students.add(new Student(id,name));
        	System.out.println("Student added successfully!");
        }
        
       
	}
    
    /*
     * Print list
     */
    
    public void printInfo(boolean flag) {
    	
    	if(flag) {
    		
    		if(!teachers.isEmpty()) {
    			
        		System.out.println("Teachers Details:");
           
        		for (Teacher teacher : teachers) {
                
        			System.out.println(teacher);
        		}
        	}else {
        		
        		System.out.println("No Teacher Information available...!");
        	}
    		
    	}else {
    		
    		if(!students.isEmpty()) {
    			
        		System.out.println("Students Details:");
           
        		for (Student student : students) {
                
        			System.out.println(student);
        		}
        	}else {
        		
        		System.out.println("No Teacher Information available...!");
        	}
    		
    		
    	}
    	
    }
    
    
    /*
     * Search with specified Id
     */
    public void search(int searchId,boolean flag) {
    	
    	boolean found = false;
    	
    	if(flag) {
    		
    		for (Teacher teacher: teachers) {
    	            if (teacher.getId() == searchId) {
    	                System.out.println("Teacher found: " + teacher);
    	                found = true;
    	                break;
    	            }
    	        }
    	        if (!found) {
    	            System.out.println("Teacher with ID " + searchId + " not found.");
    	        }
    	}else {
    		
    		for (Student student: students) {
    	            if (student.getId() == searchId) {
    	                System.out.println("Student found: " + student);
    	                found = true;
    	                break;
    	            }
    	        }
    	        if (!found) {
    	            System.out.println("Student with ID " + searchId + " not found.");
    	        }
    		
    	}
     
    	
    	
    }

    
    public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		Main m =  new Main();

        while (true) {
            System.out.println("Student-Teacher Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. View Student Details");
            System.out.println("4. View Teacher Details");
            System.out.println("5. Search Student by Id");
            System.out.println("6. Search Teacher by Id ");
            
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	m.add(false);;
                    break;
                case 2:
                    m.add(true);
                    break;
                case 3:
                	m.printInfo(false);
                    break;
                case 4:
                	m.printInfo(true);
                case 5:{
                	 System.out.print("Enter Student ID to search: ");
                     int searchId = sc.nextInt();
                     m.search(searchId,false);
                }
                case 6:{
                	System.out.print("Enter Teacher ID to search: ");
                    int searchId = sc.nextInt();
                    m.search(searchId,true);
                }
                	
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

	}

}


}
