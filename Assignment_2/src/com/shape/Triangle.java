package com.shape;

public class Triangle implements Shape {
	
	private double base;
	private double height;
	private double side1;
	private double side2;
	
	public Triangle(double base, double height, double side1, double side2) {
		
		if(base>0 && height>0 && side1>0 && side2>0) {
			
			this.base = base;
			this.height = height;
			this.side1 = side1;
			this.side2 = side2;
	    }else {
	    	
	    	System.out.println("Invalid data values");
	    }
	}
	
	@Override
	public void calculateArea() {
		
		System.out.println("Area of Triangle: "+(0.5*base*height));
		
	}

	@Override
	public void calculatePerimeter() {
		
		System.out.println("Perimeter "+(base+side1+side2));
		
	}
	

}
