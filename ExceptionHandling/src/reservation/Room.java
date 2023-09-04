package reservation;

public class Room {
	
	private int roomNumber;
	private String roomType;
	private boolean isAvailable;
	

	public Room(int roomNumber, String roomType) {
		
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.isAvailable = true;
	}
		

	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean reserve() {
		
		if(isAvailable) {
			isAvailable = false;
			return true;
		}
		
		return false;
	}
	
	public void release() {
		
		isAvailable = true;
	}

	
	
}
