package com;

public class Student {
	

	private long studentID;
	private String name;
	private static int totalStudents=0;
	
	
	
	public long getStudentID() {
		return studentID;
	}


	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static int getTotalStudents() {
		return totalStudents;
	}


	public void enroll() {
		
		totalStudents++;
		System.out.println("Enrolled Successfully!"+
						"\nTotalStudents: "+totalStudents);
	}
	
	
	
	public void drop() {
		
		if(totalStudents>0) {
			
			totalStudents--;
			System.out.println("Dropped Successfully!"+
						"\nTotalStudents: "+totalStudents);
		}else {
			
			System.out.println("There is no one to dropped");
		}
	}

	public static void main(String[] args) {
	
		Student s1 = new Student();
		s1.drop();

	}

}
