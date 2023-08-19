package com.employee;

public class Employee {
	
	private int id;
	private String name;
	
	public Employee(int id,String name) {
		
		this.name = name;
		
		if(id>0) {
			
			this.id = id;
		}else {
			
			System.out.println("Invalid Id");
		}
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void displayInfo() {
		
	}
	
	
	

}
