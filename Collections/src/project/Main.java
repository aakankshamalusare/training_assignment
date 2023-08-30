package project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * Description:
 * 	example of a project management system program in Java that uses HashMap 
 * and Set to manage project details and team members. This program allows users 
 * to add projects, assign team members to projects, view project details, and list 
 * all projects
 */
public class Main {
	
	private static HashMap<String,Project> projects = new HashMap<>();
	Scanner scanner =   new Scanner(System.in);
	
	
	public void addProject() {
		
		System.out.print("Enter project name: ");
        String projectName = scanner.nextLine();
        System.out.print("Enter project Information: ");
        String projectInfo = scanner.nextLine();
        projects.put(projectName, new Project(projectName, projectInfo));
        System.out.println("Project added successfully.");
	}
	
	public void assignMember() {
		
		System.out.print("Enter project name: ");
        String assignProjectName = scanner.nextLine();
        
        if (projects.containsKey(assignProjectName)) {
           
        	System.out.print("Enter team member name: ");
            String teamMemberName = scanner.nextLine();
            projects.get(assignProjectName).addTeamMember(teamMemberName);
            System.out.println("Team member assigned successfully.");
        } else {
            System.out.println("Project not found.");
        }
	}
	
	public void viewProject() {
		
		  System.out.print("Enter project name: ");
          String name = scanner.nextLine();
          if (projects.containsKey(name)) {
              System.out.println("Project Details:");
              System.out.println(projects.get(name));
          } else {
              System.out.println("Project not found.");
          }
	}
	
	public void printProjects() {
		
		if(!projects.isEmpty()) {
			System.out.println("List of All Projects:");
            for (Map.Entry<String, Project> project : projects.entrySet()) {
                System.out.println(project.getValue());
            }
		}else {
			System.out.println("No Project Information available...!");
		}
	}
	
	
	public static void main(String...args) {
		
		Scanner scanner = new Scanner(System.in);
		Main m = new Main();
		while (true) {
	            System.out.println("Project Management System");
	            System.out.println("1. Add Project");
	            System.out.println("2. Assign Team Member to Project");
	            System.out.println("3. View Project Details");
	            System.out.println("4. List All Projects");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
			            scanner.nextLine(); 
				switch (choice) {
		        
				case 1:
		             m.addProject();
		             break;
		
		         
				case 2:
					m.assignMember();
		            break;
		
		         
				case 3:
					m.viewProject();
		            break;
		
		         
				case 4:
					m.printProjects();
		            break;
		
		        
				case 5:
		             System.out.println("Exiting program.");
		             scanner.close();
		             System.exit(0);
		
		         default:
		             System.out.println("Invalid choice. Please select a valid option.");
     }
 }

}
}
