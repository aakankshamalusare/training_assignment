package com;

public class DVD extends LibraryItem {
	
	private double duration;
	
	public DVD() {
		
		
	}
	
	public DVD(String title,int itemID,double duration) {
		
		super(title,itemID);
		this.duration = duration;
	}
	
	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
	@Override
	public void displayInfo() {
		
		System.out.println("Title: "+getTitle()+
							"\nDuration: "+getDuration());
	}

}
