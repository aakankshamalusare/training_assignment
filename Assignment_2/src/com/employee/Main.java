/*
 * 
 * Problem Statement: Building an Inheritance-based Employee
 * System in Java
 * 
 * Develop a Java program that demonstrates inheritance by creating a hierarchy of employees in an
 * organization.
 * 
 */

package com.employee;

public class Main {

	public static void main(String[] args) {
		
		Employee manager = new Manager(1,"AB","Human Resources");
		manager.displayInfo();
		
		System.out.println("------------------");
		
		Employee developer =  new Developer(1,"AK","Java");
		developer.displayInfo();
		
		System.out.println("------------------");
	}

}
