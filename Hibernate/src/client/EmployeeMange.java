package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.mysqlx.protobuf.MysqlxCrud.Order;

import configurations.ConfigurationDemo;
import entity.Book;
import entity.Employee;

public class EmployeeMange {
	
    private static Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		
		boolean exit = false;

        while (!exit) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. List All Employees");
            System.out.println("4. Update Employee Details");
            System.out.println("5. Delete Employee");
            System.out.println("6. Employees with Salary > 30000");
            System.out.println("7. Employees in 'Developer' or 'Tester' Departments");
            System.out.println("8. Employees from Departments other than 'Tester'");
            System.out.println("9. Sort Employees by Salary (Descending)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployeeDetailsById();
                    break;
                case 3:
                    listAllEmployees();
                    break;
                case 4:
                    updateEmployeeDetails();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    employeesWithSalaryGreaterThan();
                    break;
                case 7:
                    employeesInDepartments();
                    break;
                case 8:
                    employeesFromNonTesterDepartments();
                    break;
                case 9:
                    sortEmployeesBySalaryDescending();
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting the Employee Management System.");
        scanner.close();
    }

    private static void addEmployee() {
    	
    	SessionFactory  factory = ConfigurationDemo.startSession();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
     	System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lname = scanner.nextLine();

        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        Date dateOfBirth = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirth = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        
        
        session.save(new Employee(fname, lname, dateOfBirth, email, department, salary));
        transaction.commit();
        
        factory.close();
        
        System.out.println("Employee added successfully...!");
    }

    private static void viewEmployeeDetailsById() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter EmpId for which you want to see details");
        int id = scanner.nextInt();
        
        scanner.nextLine();
        
        Employee employee = session.get(Employee.class,id);
        
        if(employee!=null) {
        	
        	
        	System.out.println(employee);
            
                 	
        }else {
        	
        	System.out.println("Employee not found");
        }
     
        
        
        factory.close();

    	
    }

    private static void listAllEmployees() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Criteria criteria = session.createCriteria(Employee.class);
        
        List<Employee> employees = criteria.list();
        
        if(!employees.isEmpty()) {
        	
        	for (Employee employee : employees) {
        		System.out.println(employee);
				
			}
        }else {
        	
        	System.out.println("No Employee details present....");
        }
        
        transaction.commit();
        factory.close();
    }

    private static void updateEmployeeDetails() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter EmpId for which you want to update");
        int id = scanner.nextInt();
        
        scanner.nextLine();
        
        Employee employee = session.get(Employee.class,id);
        
        if(employee!=null) {
        	
        	
        	System.out.print("Enter First Name: ");
            String fname = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lname = scanner.nextLine();

            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            Date dateOfBirth = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateOfBirth = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                return;
            }

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
        	
        	employee.setFname(fname);
        	employee.setLname(lname);
        	employee.setDateOfBirth(dateOfBirth);
        	employee.setEmail(email);
        	employee.setSalary(salary);
        	employee.setDepartment(department);
        	
          
            session.update(employee);
            transaction.commit();

            
            System.out.println("Employee information updated successfully...!");
        	
        }else {
        	
        	System.out.println("Employee not exists...!");
        }
     
        
        
        factory.close();
        
    }

    private static void deleteEmployee() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter employee for whom you want to delete:");
        String name = scanner.nextLine();
        
        Criteria criteria = session.createCriteria(Employee.class);
        
        
        List<Employee> employees = criteria .add(Restrictions.or(
        									Restrictions.eq("fname", name),
        									Restrictions.eq("lname", name)))
        									.list();

            if (!employees.isEmpty()) {
                
                for (Employee employee : employees) {
                    session.delete(employee);
                }
                System.out.println("Deleted " + employees.size() + " employees with first name or last name " + name + ".");
           
            } else {
               
            	System.out.println("No employees found with first name or last name " + name + ".");
            }
        
        
        transaction.commit();
        factory.close();
        
    }

    private static void employeesWithSalaryGreaterThan() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
       
    	System.out.print("Enter Salary:");
    	double salary = scanner.nextDouble();
    	
    	Criteria criteria = session.createCriteria(Employee.class);
    	List<Employee> employees = criteria.add(Restrictions.gt("salary", salary)).list();
    	
    	
    	if(!employees.isEmpty()) {
    	
	    	for (Employee employee : employees) {
			
	    		System.out.println(employee);
			}
    	}else {
    		
    		System.out.println("No employees found with salary greater than " + salary);
    	}
    	
    	transaction.commit();
    	factory.close();
    	
    	
    	
    	
    	
    }

    private static void employeesInDepartments() {
        // employees in 'Developer' or 'Tester' departments 
    	
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
    	Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
         
         
         @SuppressWarnings("unchecked")
		List<Employee> employees = criteria .add(Restrictions.or(
         									Restrictions.eq("department", "developer"),
         									Restrictions.eq("department", "tester")))
         									.list();

             if (!employees.isEmpty()) {
                 
                 for (Employee employee : employees) {
                     System.out.println(employee);
                 }
                 
             } else {
                
             	System.out.println("No employees found with Developer or Tester profile.");
             }
         
         
         transaction.commit();
         factory.close();
    }

    private static void employeesFromNonTesterDepartments() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
    	Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
         
        
          criteria.add(Restrictions.ne("department","tester"));
         									
          List<Employee> employees =criteria.list();

             if (!employees.isEmpty()) {
                 
                 for (Employee employee : employees) {
                	 
                	 System.out.println(employee);
                     
                 }
                 
             } else {
                
             	System.out.println("No employees found other than Tester profile.");
             }
         
         
         transaction.commit();
         factory.close();
    }

    private static void sortEmployeesBySalaryDescending() {
    	
    	SessionFactory factory = ConfigurationDemo.startSession();
    	Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //Criteria criteria = session.createCriteria(Employee.class);
        //criteria.addOrder(Order.desc("salary"));
        
        String query = "FROM Employee as emp ORDER BY emp.salary desc";
        
        List<Employee> employees = session.createQuery(query).list();

       
        for (int i = 0; i < employees.size(); i++) {
			
        	
        	System.out.println(employees.get(i));
		}
    	
    
        transaction.commit();
        factory.close();
        
        
        
      


        
    }
}
		
