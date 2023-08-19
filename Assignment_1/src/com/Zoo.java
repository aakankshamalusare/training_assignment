package com;

import java.util.ArrayList;
import java.util.Iterator;


/*
 * Class Inheritance and Polymorphism: You are buliding a system for a zoo.Create a base class Animal with properties like
 * name and age,and a method makeSound()...
 */

class Animal{
	
	private String name;
	private int age;
	
	Animal(){
		
		//System.out.println("In Animal");
	}
	
	Animal(String name,int age){
		
		this.name =  name;
		this.age =  age;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void makeSound() {
		
		System.out.println("Animal Sound");
	}
}


class Lion extends Animal{

	Lion(){
		
	}
	
	Lion(String name,int age){
		
		super(name,age);
	}
	
	
	@Override
	public void makeSound() {
		
		System.out.println("Name: "+getName()+
		           "\nAge: "+getAge()+
		           "\nSound: "+"Lion Sound");
	}
	
}


class Elephant extends Animal{

	Elephant(){
		
	}
	
	Elephant(String name,int age){
		
		super(name,age);
	}
	
	
	@Override
	public void makeSound() {
		
		System.out.println("Name: "+getName()+
				           "\nAge: "+getAge()+
				           "\nSound: "+"Elephant Sound");
	}
	
}



class  Giraffe extends Animal{

	Giraffe(){
		
	}
	
	Giraffe(String name,int age){
		
		super(name,age);
	}
	
	
	@Override
	public void makeSound() {
		
		System.out.println("Name: "+getName()+
		           "\nAge: "+getAge()+
		           "\nSound: "+"Giraffe Sound");
	}
	
}

public class Zoo {

	public static void main(String[] args) {
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		
		Animal a1 = new Lion("ABC",24);
		animalList.add(a1);	
		
		
		Animal a2 = new Elephant("PQR",30);
		animalList.add(a2);	
	
		
		Animal a3 = new Giraffe("XYZ",45);
		animalList.add(a3);	
		
		Iterator<Animal> ll = animalList.iterator();

		while(ll.hasNext()) {
			
			
			ll.next().makeSound();
			System.out.println("-------------------");
		}
	}

}
