package com;

public abstract class LibraryMember implements Reservable {
	
	private int memberID;
	private String name;
	
	
	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public LibraryMember() {
		
		
	}
	
	public LibraryMember(int memberID,String name) {
		
		this.memberID = memberID;
		this.name = name;
	}
	
	public abstract void borrowItem(LibraryItem item);

}
