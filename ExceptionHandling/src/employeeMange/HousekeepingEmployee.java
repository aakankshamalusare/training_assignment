package employeeMange;

public class HousekeepingEmployee extends Employee {

	
	public HousekeepingEmployee(String name, int id) {
		
		super(name, id);
		
	}
	
	public void cleanRoom() {
		
        System.out.println(name + " is cleaning a room.");
	}
	
	@Override
	public void performWork() {
		
		cleanRoom();
	}

}
