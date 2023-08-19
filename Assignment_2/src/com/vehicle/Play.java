/*
 * 
 * Problem Statement: Implementing Interfaces in Java for Vehicles
 * 
 * Design a Java program that demonstrates how interfaces work by creating different types of vehicles
 * and making them start, accelerate, and brake.
 * 
 */

package com.vehicle;

public class Play {

	public static void main(String[] args) {
		
		Car car =  new Car();
		car.start();
		car.accelerate();
		car.brake();
		
		System.out.println("-------------------");
		
		
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.start();
		motorcycle.accelerate();
		motorcycle.brake();
		
		System.out.println("-------------------");
		

	}

}
