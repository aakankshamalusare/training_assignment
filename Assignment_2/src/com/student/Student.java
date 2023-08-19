package com.student;

public class Student {
	
	private static long uniqueId = 1;
	private String name;
	private int age;
	private long studentId;
	
	public Student(){
		
		this.name = "Unknown";
		this.age = 0;
		this.studentId = uniqueId++;
	}
	
	public Student(String name,int age) {
		
		this.name =  name;
		this.studentId = uniqueId++;
		if(age>0 && age<101) {
			
			this.age = age;
		}else {
			
			System.out.println("Invalid Age");
		}
	}
	
   public Student(String name,int age,long studentId) {
		
		this.name =  name;
		
		if(age>0 && age<101) {
			
			this.age = age;
		}else {
			
			System.out.println("Invalid Age");
		}
		
		if(studentId>=uniqueId) {
			
			this.studentId = studentId;
			uniqueId = studentId+1;
		}else {
			
			System.out.println("StudentId must be unique...!");
		}
	}
	
	
    @Override
    public String toString() {
    	
    	return ("Name:"+name+
    			"\nStudentId:"+studentId+
    			"\nAge:"+age);
    }
	



	
	
	
	

}
