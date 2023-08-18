package com;

public class Main {

	public static void main(String[] args) {
	
		Book book = new Book("Radhey",1,"Ranjit Desai");
		book.displayInfo();
		
		System.out.println("---------------------------");
		
		DVD dvd =  new DVD("Life of Pi",2,2.30);
		dvd.displayInfo();
		
		System.out.println("---------------------------");
	
		LibraryMember l1 = new StudentMember(123,"AK");
		l1.borrowItem(book);
		//l1.reserveItem(book);
	
		System.out.println("---------------------------");
		
		LibraryMember l2 = new FacultyMember(321,"Faculty");
		l2.borrowItem(dvd);
		//l2.reserveItem(dvd);
		
		System.out.println("---------------------------");
		
		

	}

}
