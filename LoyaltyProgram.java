import java.util.Scanner;

public class LoyaltyProgram {
	// Attributes
	private Scanner scanner = new Scanner(System.in);	
	private Member [] members; // We assume that the system can take max 5 members
	private Flight [] flights;
	private int numOfMembers;
	private static int numOfFlights;
	
	// Parameterized Constructor
	public LoyaltyProgram() {
		members = new Member[5];
		flights = new Flight[5];
	}
	
	// Adding members to our system
	public boolean addMembers(Member member) {
		if (numOfMembers < members.length && !searchForMemeber(member)) {
			members[numOfMembers++] = new SilverMember(member);
//			members[numOfMembers++] = new GoldMember(member);
//			members[numOfMembers++] = new PlatinumMember(member);
	    	System.out.println("Member has been created successfully");
			return true;
		}
		if (searchForMemeber(member)) {
			System.out.println("Member already exists");
		}
		if (numOfMembers == members.length) {
			System.out.println("Sorry... You have reached maximum of members");
		}
		return false;
	}

	public void addFlights(Flight flight) {
		flights[numOfFlights++] = new Flight(flight);
	}

	// Login member to the system
	public Member login() {
		int attempts = 0;
		boolean found = false;
		while (attempts < 3) {
			System.out.print("Enter username: "); // f
			String username = scanner.next().toLowerCase();
			System.out.print("Enter password: "); // f
			String password = scanner.next();
			
			// Checking if the input is valid
			for (int i = 0; i < numOfMembers; i++) {
				if (username.equals(members[i].getUserName()) && password.equals(members[i].getPassword())) {
					System.out.println("Member found.");
					found = true;
					return members[i];
				}
			}
			if (!found) {
				System.out.println("username or password is incorrect");
				attempts++;
				System.out.println("Left Attempts: " + (3 - attempts));
			}
		} // end while loop
		if (attempts == 3) {			 
			System.out.println("You reached maximum attemps");
			return null;
		}
		return null;
	}
	
	// Searching for members
	public boolean searchForMemeber(Member member) {
		for (int i = 0; i < numOfMembers; i++) {
//			if (members[i].getUserName().equals(member.getUserName()) && members[i].getPassword().equals(member.getPassword()));
			if (members[i].getUserName().equals(member.getUserName())) {
				return true;
			} else {
				return false;
			}
		}
//		if (numOfMembers == 0) {
//			System.out.println("There is no members");
//		}
		return false;
	}

	// Print all flights details
	public void listFlights() {
		if (numOfFlights > 0) {
			System.out.println(" - Avilable Flights: ");
			for (int i = 0; i < numOfFlights; i++) {
				System.out.println((i + 1) + " - # From: " + flights[i].getFrom() + "  " + "To: " + flights[i].getTo() + "  " + "Flight Number: " + flights[i].getFlightNum() +" ");
			}
		} else {
			System.out.println("There is no flights");
		}
	}
	
	// Book Flight
	public void bookFlight(Member member) {
		
		// Check if the member has been reached max of booking
		if (member.getFlightsCounter() == member.bookedFlights.length) {
			System.out.println("Sorry... You have reached maximum of booked flights");
			return;
		}
		
		String choice;
		boolean state = false;
		
		do {
			// Printing flights details
			listFlights();
			
			System.out.print("Enter the flight number you'd like to book: ");
			choice = scanner.next().toUpperCase();
			
			for (int i = 0; i < numOfFlights; i++) {
				if (choice.equals(flights[i].getFlightNum())) {
					
					// 1. Add the member to passengers, Add the flight to bookedFlights
					if (flights[i].addMember(member)) {
						member.addFlight(flights[i]);
						System.out.println("Flight booked successfully!");
						state = true;
					} else {
						return;
					}
					
					// 2. Add points to the member
//					member.setPoints();
				}
			}
			if (!state) {
				System.out.println("Invalid flight number. Please try again.");
			}
			
		} while (!state);
	}
}
