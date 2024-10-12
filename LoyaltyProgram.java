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
		while (attempts < 3) {
			System.out.print("Enter username: ");
			String username = scanner.next().toLowerCase();
			System.out.print("Enter password: ");
			String password = scanner.next();
			
			// Checking if the input is valid
			for (int i = 0; i < numOfMembers; i++) {
				if (username.equals(members[i].getUserName()) && password.equals(members[i].getPassword())) {
					System.out.println("Member found.");
					return members[i];
				} else {
					System.out.println("username or password is incorrect");
					attempts++;
					System.out.println("Left Attempts: " + (3 - attempts));
					break;
				}
			}
			if (numOfMembers == 0) {
				System.out.println("There is no members");
				break;
			}
		}
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
	public void bookFlight() {
		listFlights();
		
//		System.out.print("Please enter your choice (R11, R12, R13, R14 or R15): ");
		String choice;
		boolean state = false; // it means we didn't find the flight
		
		do {
			System.out.print("Please enter flight number: ");
			choice = scanner.next().toUpperCase(); // R14
			
			for (int i = 0; i < numOfFlights; i++) {
				if (choice.equals(flights[i].getFlightNum())) {
					/*
					 	1- Add member to flight passengers (Flight)
						2- increase flight capacity (Flight)
						3- add flight to member's booked flights (Member)
						4- increase member points (Member -> level)
						5- return to login menu (flow)
					 */
					System.out.println("Flight found.");
					state = true;// it means we found the flight
					break;
				}
			}
			if (!state) {
				System.out.println("Not found");
			}
			
		} while (!state);
	}
}
