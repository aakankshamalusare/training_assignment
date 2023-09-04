package reservation;

public class RoomReservation extends Reservation {
	
	private int roomNumber;
	private double nightlyRate;
	
	 public RoomReservation(Guest guest, int roomNumber, double nightlyRate ,String roomType) {
		super(guest, roomType);
		this.roomNumber = roomNumber;
		this.nightlyRate = nightlyRate;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getNightlyRate() {
		return nightlyRate;
	}
	public void setNightlyRate(double nightlyRate) {
		this.nightlyRate = nightlyRate;
	}
	
	
	@Override
	public double calculateCost() {
		
		return nightlyRate;
	}
	
	

}
