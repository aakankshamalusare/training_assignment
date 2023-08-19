/*
 * 
 * Problem Statement: Exploring Constructors in Java
 * 
 * Develop a Java program that illustrates the use of constructors by modeling a simple student
 * information system.
 * 
 */

package com.student;

public class Main {

	public static void main(String[] args) {

		Student s1 = new Student();
		System.out.println(s1);
		
		System.out.println("----------------");
		
		Student s2 = new Student("AK",22);
		System.out.println(s2);
		
		System.out.println("----------------");
		
		Student s3 = new Student("AB",22,3);
		System.out.println(s3);
		
		
	}

}
