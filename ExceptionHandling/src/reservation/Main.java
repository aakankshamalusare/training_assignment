package reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static List<Guest> guests;
	private static List<Reservation> reservations;
	private static List<Room> rooms = new ArrayList<>();
	private Scanner scanner;
	
	public static void addRoom(int roomNumber, String roomType) {
	    Room room = new Room(roomNumber, roomType);
	    rooms.add(room);
	}
	
	static {
		
		for (int roomNumber = 101; roomNumber <= 120; roomNumber++) {
	        String roomType = roomNumber <= 110 ? "Standard" : "Deluxe"; // Example room type assignment
	        addRoom(roomNumber, roomType);
	    }
	}
	
	public Main() {
		
		guests = new ArrayList<>();
		reservations = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	
    private Room findRoom(int roomNumber) {
	    for (Room room : rooms) {
	        if (room.getRoomNumber() == roomNumber) {
	            return room;
	        }
	    }
	    return null;
	}
    
    
    public boolean isRoomAvailable(int roomNumber) {
    	
    	Room room = findRoom(roomNumber);
    	return room!= null  && room.isAvailable();
    }
	
    public void makeRoomReservation(String name, String email, int roomNumber, double nightlyRate)
            throws InvalidReservationException, RoomNotFoundException {
        
    	
        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            throw new InvalidReservationException("Guest name and email are required.");
        }

    
        Room room = findRoom(roomNumber);
       
        if (room != null) {
            
            if (room.isAvailable()) {
                Guest guest = new Guest(name, email);
                RoomReservation reservation = new RoomReservation(guest, roomNumber, nightlyRate,room.getRoomType());
                reservations.add(reservation);
                room.reserve();
                guests.add(guest);
            } else {
                throw new InvalidReservationException("The room is already reserved.");
            }
        } else {
            throw new RoomNotFoundException("Room not found.");
        }
    }
    
    
      public void checkAvailability() {
		
		System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        boolean isAvailable = isRoomAvailable(roomNumber);
        if (isAvailable) {
            System.out.println("Room " + roomNumber + " is available.");
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
	}
    
    public void getData() {
    	
    	System.out.print("Guest Name: ");
        String name = scanner.nextLine();
        System.out.print("Guest Email: ");
        String email = scanner.nextLine();
        System.out.print("Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Nightly Rate: ");
        double nightlyRate = scanner.nextDouble();
        scanner.nextLine();
        
        try {
            
            makeRoomReservation(name, email, roomNumber, nightlyRate);
            System.out.println("Room reservation successful!");
        } catch (InvalidReservationException e) {
            System.err.println( e.getMessage());
        } catch (RoomNotFoundException e) {
            System.err.println( e.getMessage());
        }
    }
    
    
    
    
    public static void main(String...args) {
    	
    
    	Main  m = new Main();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            
        	System.out.println("Reservation Management System");
        	System.out.println("1. Make a room reservation");
            System.out.println("2. Check room availability");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
            	m.displayAvailableRooms();
                m.getData();
                break;
            case 2:
            	 m.checkAvailability();
                 break;
            case 3:
                 
            	 System.out.println("Exiting...");
                 scanner.close();
                 System.exit(0);
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
            
            
     }
   
   }
    
    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Room Type: " + room.getRoomType());
            }
        }
    }


	
}
