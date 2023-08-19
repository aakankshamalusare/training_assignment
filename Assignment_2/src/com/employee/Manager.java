package com.employee;

public class Manager extends Employee {

	private String department;
	
	public Manager(int id, String name,String department) {
		
		super(id, name);
		this.department = department;
		
	}
	
	public String getDepartment() {
		return department;
	}
	
	@Override
	public void displayInfo() {
		
		System.out.println("Id: "+getId()+
							"\nName: "+getName()+
							"\nDepartment: "+getDepartment());
	}



}
