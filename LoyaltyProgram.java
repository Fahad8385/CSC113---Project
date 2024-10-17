import java.util.Scanner;

public class LoyaltyProgram {
    // Attributes
    private Scanner scanner = new Scanner(System.in);
    private Member[] members; // We assume that the system can take max 5 members
    private Flight[] flights;
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
            System.out.print("Enter username: "); // s
            String username = scanner.next();
            System.out.print("Enter password: "); // s
            String password = scanner.next();
            boolean memberFound = false;
            // Checking if the input is valid // Need to be Edited // update, fixed the major issue, some part left

            for (int i = 0; i < numOfMembers; i++) {
                if (username.equals(members[i].getUserName()) && password.equals(members[i].getPassword())) {
                    System.out.println("Member found.");
                    memberFound = true;
                    return members[i];
                }
            }
            // this part needs to be fixed
            if (!memberFound) {
                System.out.println("username or password is incorrect");
                attempts++;
                System.out.println("Left Attempts: " + (3 - attempts));
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

    // List flight
    public void listFlights() {
        String allFlights = "";
        for (int i = 0; i < numOfFlights; i++)
            System.out.println((i + 1) + ". From: " + flights[i].getFrom() + " To " + flights[i].getTo() + ", Flight Number: " + flights[i].getFlightNum());
    }

//    public void bookFlight(Member member) {
//        String choice;
//        boolean found = false;
//        // Check if the member can book flights (full or not)
//        if (member.getFlightsCounter() >= 3) {
//            System.out.println("Sorry... You have reached maximum of booked flights");
//            found = true;
//        }
//
//        do {
//            listFlights();
//            System.out.print("Enter the flight number you'd like to book: ");
//            choice = scanner.next();
//            found = false;
//
//            for (int i = 0; i < numOfFlights; i++) {
//                if (choice.equals(flights[i].getFlightNum())) {
//                    // Adding the member to the flight and Add Flight to member's booked flights
//                    if (flights[i].addMember(member)) {
//                        member.addFlight(flights[i]);
//                        found = true;
//                        System.out.println("Flight booked successfully!");
//                    } else {
//                        found = true;
//                        System.out.println("Apologies, this flight is fully booked.");
//                        break;
//                    }
//
//                    // Increase flight capacity (No need, already in addMember)
//                    // Increase member points (After implementing Membership levels)
//
//                    break;
//                }
//            }
//
//            if (!found) {
//                System.out.println("Invalid flight number. Please try again.");
//            }
//
//        } while (!found);
//    }
public void bookFlight(Member member) {
    String choice;
    boolean found = false;
    // Check if the member can book flights (full or not)
    if (member.getFlightsCounter() >= 3) {
        System.out.println("Sorry... You have reached maximum of booked flights");
        found = true;
    }

    while (!found) {
        listFlights();
        System.out.print("Enter the flight number you'd like to book: ");
        choice = scanner.next();
        found = false;

        for (int i = 0; i < numOfFlights; i++) {
            if (choice.equals(flights[i].getFlightNum())) {
                // Adding the member to the flight and Add Flight to member's booked flights
                if (flights[i].addMember(member)) {
                    member.addFlight(flights[i]);
                    found = true;
                    System.out.println("Flight booked successfully!");
                } else {
                    found = true;
                    System.out.println("Apologies, this flight is fully booked.");
                    break;
                }

                // Increase flight capacity (No need, already in addMember)
                // Increase member points (After implementing Membership levels)
                /*
                1- member.addPoints(flights[i](getDistance());
                 */

                break;
            }
        }

        if (!found) {
            System.out.println("Invalid flight number. Please try again.");
        }

    }
}
}
