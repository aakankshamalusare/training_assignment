package com.vehicle;

public class Motorcycle implements Vehicle {

	@Override
	public void start() {
		
		System.out.println("Motorcycle starting...!");
		
	}

	@Override
	public void accelerate() {
		
		System.out.println("Motorcycle acclerating...!");
		
	}

	@Override
	public void brake() {
		
		System.out.println("Motorcycle braking...! ");
		
	}
}
