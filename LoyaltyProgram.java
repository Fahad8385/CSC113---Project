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
		flights[numOfFlights++] = flight;
	}

	// Login member to the system
	public boolean login() {
		int attempts = 0;
		while (attempts < 3) {
			System.out.print("Enter username: ");
			String username = scanner.next();
			System.out.print("Enter password: ");
			String password = scanner.next();
			
			// Checking if the input is valid
			for (int i = 0; i < numOfMembers; i++) {
				if (username.equals(members[i].getUserName()) && password.equals(members[i].getPassword())) {
					System.out.println("Member found.");
					return true;
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
			return false;
		}
		return false;
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

	// Will add: Flights List getter
}
