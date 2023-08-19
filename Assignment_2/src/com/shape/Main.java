/*
 * 
 * Problem Statement: Implementing Polymorphism in Java
 * 
 * Develop a Java program that demonstrates polymorphism by creating a set of shapes and performing
 * various calculations and operations on them using a common interface.
 *
 */


package com.shape;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		
		
		ArrayList<Shape> shape = new ArrayList<Shape>();
		
		Shape circle =  new Circle(4.54);
		shape.add(circle);
		
		Shape rectangle = new Rectangle(2,3);
		shape.add(rectangle);

			
		Shape triangle = new Triangle(6,4,3,2);
		shape.add(triangle);

		
		Iterator<Shape> iterator = shape.iterator();
		
		while(iterator.hasNext()) {
			
			iterator.next().calculatePerimeter();
			System.out.println("-------------------");
			iterator.next().calculateArea();
		}

		
	}

}
