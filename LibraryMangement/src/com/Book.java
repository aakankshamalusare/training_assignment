package com;

public class Book extends LibraryItem{
	
	private String author;

	public Book() {
		
	}
	
	public Book(String title,int itemID,String author) {
		
		super(title,itemID);
		this.author = author;
	}
	
	
	public String getAuthor() {
		return author;
	}
	
	@Override
	public void displayInfo() {
		
		System.out.println("Title: "+getTitle()+
							"\nAuthor: "+getAuthor());
	}
	
	

}
