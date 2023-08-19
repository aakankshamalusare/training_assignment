package com;

import java.util.Date;

public class Room {
	
	private int roomNumber;
	private int capacity;
	private double pricePerNight;
	private boolean reserved = false;
	
	public Room(int roomNumber,int capacity,int pricePerNight){
		
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.pricePerNight = pricePerNight;
		
	}
	
	public boolean checkAvailability() {
		
		if(!reserved) {
			
			reserved = true;
			return true;
		}
		
		return false;
	}
	
	
	public void makeReservation() {
		
		if(checkAvailability()) {
			
			System.out.println("Room Reserved");
		}else {
			
			System.out.println("Room already reserved");
		}
	}
	
	
	public void makeReservation(Date date) {
		
		if(checkAvailability()) {
			
			System.out.println("Room Reserved");
		}else {
			
			System.out.println("Room already reserved");
		}
		
	}
	@Override
	public String toString() {
		
		return "Room Number: "+roomNumber+
				"\nCapacity: "+capacity+
				"\nPricePerNight: "+pricePerNight;
		
	}
	

	public static void main(String[] args) {
		
		Room r1 =  new Room(101,2,45);
		r1.makeReservation();
		//r1.makeReservation();
		
		System.out.println(r1);
		
		

	}

}
