package reservation;

public abstract class Reservation {
	
	protected Guest guest;
	protected String reservationType;
	

	public Reservation(Guest guest, String reservationType) {
		
		this.guest = guest;
		this.reservationType = reservationType;
	}

	
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	
	public abstract double calculateCost();
}
