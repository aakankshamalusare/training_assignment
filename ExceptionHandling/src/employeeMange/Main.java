package employeeMange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static List<FrontDeskEmployee> frontDeskEmployees;
	private static List<HousekeepingEmployee> housekeepingEmployees;
	private Map<String,List<Employee>> taskAssignments;

	public Main() {
		
		frontDeskEmployees = new ArrayList<>();
		housekeepingEmployees = new ArrayList<>();
		taskAssignments = new HashMap<>();
		
	}
	
	

	// Check if an ID is unique within a category
	private boolean isUniqueId(int id, String category) {
	    List<? extends Employee> employees = getCategoryEmployees(category);
	    for (Employee employee : employees) {
	        if (employee.getId() == id) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	//Hire an Employee
	public void hireEmployee(String name,int id,String category)
	throws DuplicateEmployeeException{
		
		Employee newEmployee;
		
		if(category.equalsIgnoreCase("FrontDesk")&& !isUniqueId(id,category)) {
			
			throw new DuplicateEmployeeException
			("Employee with same ID already exists in FrontDesk category");
		
		}else if(category.equalsIgnoreCase("Housekeeping")&& !isUniqueId(id,category)) {
			
			throw new DuplicateEmployeeException
			("Employee with same ID already exists in Housekeeping category");
		}
		
		
		if(category.equalsIgnoreCase("FrontDesk")) {
			
			newEmployee = new FrontDeskEmployee(name,id);
			frontDeskEmployees.add((FrontDeskEmployee) newEmployee);
			
		}else if(category.equalsIgnoreCase("Housekeeping")) {
		
			newEmployee = new HousekeepingEmployee(name,id);
			housekeepingEmployees.add((HousekeepingEmployee) newEmployee);
		}else {
			
			throw new IllegalArgumentException("Invalid employee category");
		}
		
		
		if(!taskAssignments.containsKey(category)) {
			
			taskAssignments.put(category, new ArrayList<>());
		}
		
		if(!taskAssignments.get(category).contains(newEmployee)) {
			
				taskAssignments.get(category).add(newEmployee);
		}else {
			
			throw new DuplicateEmployeeException("Employee with the same name already exists.");

		}
	}
	
	
	
    // Find an employee by name and category
	public Employee findEmployee(String name, String category) {
       
		List<?> employees;
        if (category.equalsIgnoreCase("FrontDesk")) {
            
        	employees = frontDeskEmployees;
        
        } else if (category.equalsIgnoreCase("Housekeeping")) {
        
        	employees = housekeepingEmployees;
        } else {
            
        	return null;
        }

        for (Object employee : employees) {
            if (((Employee) employee).getName().equalsIgnoreCase(name)) {
                return (Employee) employee;
            }
        }
        return null;
    }
	
	// Fire employee
	
	public void fireEmployee(String name, String category) {
        Employee employeeToRemove = findEmployee(name, category);
        
        if (employeeToRemove != null) {
           
        	if (category.equalsIgnoreCase("FrontDesk")) {
            
        		frontDeskEmployees.remove(employeeToRemove);
            
        	} else if (category.equalsIgnoreCase("Housekeeping")) {
             
        		housekeepingEmployees.remove(employeeToRemove);
            
        	} else {
            
        		throw new IllegalArgumentException("Invalid employee category.");
            }

            taskAssignments.get(category).remove(employeeToRemove);
            System.out.println(name + " has been fired.");
        } else {
            System.err.println("Employee not found.");
        }
    }
	
	//Update employee details
	public void updateEmployeeDetails(String oldName, String newName, int newId, String category) throws DuplicateEmployeeException {
	    
		Employee employeeToUpdate = findEmployee(oldName, category);
	    
		if (employeeToUpdate != null) {
	        // Check if the new ID is already assigned to another employee in the same category
	        if (!isUniqueId(newId, category)) {
	            throw new DuplicateEmployeeException("Employee with the same ID already exists in the category.");
	        }

	        employeeToUpdate.name = newName;
	        employeeToUpdate.id = newId;
	        System.out.println("Employee details updated.");
	    } else {
	        System.err.println("Employee not found.");
	    }
	}
	
	
	// Get employees in a specific category
	private List<? extends Employee> getCategoryEmployees(String category) {
	    if (category.equalsIgnoreCase("FrontDesk")) {
	        return frontDeskEmployees;
	    } else if (category.equalsIgnoreCase("Housekeeping")) {
	        return housekeepingEmployees;
	    } else {
	        throw new IllegalArgumentException("Invalid employee category.");
	    }
	}
	
	
	// Assign a task to an employee within the same category
	
    public void assignTask(String category, String task) throws InvalidTaskAssignmentException {
       
    	if (!taskAssignments.containsKey(category)) {
            
    		throw new InvalidTaskAssignmentException("Invalid category for task assignment.");
        }

        List<Employee> employees = taskAssignments.get(category);

        if (employees.isEmpty()) {
            
        	throw new InvalidTaskAssignmentException("No employees in the selected category.");
        }

        Employee assignedEmployee = employees.remove(0);
        System.out.println("Assigned task '" + task + "' to " + assignedEmployee.getName());
    }

	

	public static void main(String[] args) {
		
		Main m = new Main();
		Scanner scanner =  new Scanner(System.in);
		
		
		while (true) {
            
			System.out.println("Employee Management System");
			System.out.println("1. Hire an employee");
            System.out.println("2. Fire an employee");
            System.out.println("3. Update employee details");
            System.out.println("4. Assign a task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
            
            case 1:
                try {
                    
                	System.out.print("Employee Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Employee ID: ");
                    int id = scanner.nextInt();
                   
                    scanner.nextLine();
                    
                    System.out.print("Employee Category (FrontDesk/Housekeeping): ");
                    String category = scanner.nextLine();
                    
                    m.hireEmployee(name, id, category);
                    
                 
                    Employee hiredEmployee = m.findEmployee(name, category);
                    hiredEmployee.greet();
                    hiredEmployee.performWork();

                    System.out.println("Employee hired successfully!");
                } catch (DuplicateEmployeeException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Employee Name to Fire: ");
                String nameToFire = scanner.nextLine();
                
                System.out.print("Employee Category (FrontDesk/Housekeeping): ");
                String categoryToFire = scanner.nextLine();
               
                m.fireEmployee(nameToFire, categoryToFire);
                break;
            case 3:
                System.out.print("Employee Name to Update: ");
                String oldName = scanner.nextLine();
                
                System.out.print("New Employee Name: ");
                String newName = scanner.nextLine();
               
                System.out.print("New Employee ID: ");
                int newId = scanner.nextInt();
               
                scanner.nextLine(); // Consume newline
                
                System.out.print("Employee Category (FrontDesk/Housekeeping): ");
                String categoryToUpdate = scanner.nextLine();
                try {
                	m.updateEmployeeDetails(oldName, newName, newId, categoryToUpdate);
                
                }catch( DuplicateEmployeeException e) {
                	
                	System.err.println("Error: " + e.getMessage());
                }
                break;
            case 4:
                try {
                    System.out.print("Task Category (FrontDesk/Housekeeping): ");
                    String taskCategory = scanner.nextLine();
                   
                    System.out.print("Task Description: ");
                    String task = scanner.nextLine();
                    
                    m.assignTask(taskCategory, task);
                } catch (InvalidTaskAssignmentException e) {
                    System.err.println("Error: " + e.getMessage());
                }
                break;
            case 5:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
		
		

	}

}
