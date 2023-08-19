package com.employee;

public class Developer extends Employee {

	private String programmingLanguage;
	
	public Developer(int id, String name, String programmingLanguage) {
		
		super(id, name);
		this.programmingLanguage = programmingLanguage;
		
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	
	@Override
	public void displayInfo() {
		
		System.out.println("Id: "+getId()+
							"\nName: "+getName()+
							"\nProgrammingLanguage: "+getProgrammingLanguage());
	}

}
