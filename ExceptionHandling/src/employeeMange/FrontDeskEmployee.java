package employeeMange;

public class FrontDeskEmployee extends Employee {

	public FrontDeskEmployee(String name, int id) {
		super(name, id);
		
	}
	
	
	public void checkInGuests() {
		
		System.out.println(name + " is checking in guests.");
	}
	
    @Override
    public void performWork() {
        checkInGuests();
    }


}
