package com;

public class FacultyMember extends LibraryMember{
	
	
	public FacultyMember() {
		
	}
	
	
	public FacultyMember(int memberID,String name) {
		
		super(memberID,name);
		
	}

	@Override
	public void borrowItem(LibraryItem item) {
		
		System.out.println("MemberID: "+getMemberID()+
				"\nName: "+getName()+
				"\nTitle: "+item.getTitle()+
				"\nItemID: "+item.getItemID());
		
		reserveItem(item);
	}


	@Override
	public void reserveItem(LibraryItem item) {
		
		System.out.println(getName()+" reserved item "+item.getTitle()+" successfully!");
	}
	

}
