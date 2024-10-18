import java.util.Scanner;

public class LoyaltyProgram {
    // Attributes
    private Scanner scanner = new Scanner(System.in);
    private Member[] members;
    private Flight[] flights;
    private int numOfMembers;
    private int numOfFlights;

    // Parameterized Constructor
    public LoyaltyProgram() {
        members = new Member[3];
        flights = new Flight[50];
    }

    // Adding members to our system
    public boolean addMembers(Member member) {
        if (numOfMembers < members.length && !searchForMember(member)) {
            members[numOfMembers++] = new SilverMember(member);
            System.out.println("Member has been created successfully");
            return true;
        }
        if (searchForMember(member)) {
            System.out.println("Member already exists");
        }
        if (numOfMembers == members.length) {
            System.out.println("Sorry... You have reached maximum of members");
        }
        return false;
    }

    public void addFlight(Flight flight) {
        flights[numOfFlights++] = new Flight(flight);
    }

    // Login member to the system
    public Member login() {
        int attempts = 0;
        boolean found = false;
        while (attempts < 3) {
            System.out.print("Enter username: ");
            String username = scanner.next().toLowerCase();
            System.out.print("Enter password: ");
            String password = scanner.next();

            // Checking if the input is valid
            for (int i = 0; i < numOfMembers; i++) {
                if (username.equals(members[i].getUsername()) && password.equals(members[i].getPassword())) {
                    System.out.println("Logging in...");
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
            System.out.println("You reached maximum attempts");
            return null;
        }
        return null;
    }

    // Searching for members
    public boolean searchForMember(Member member) {
        for (int i = 0; i < numOfMembers; i++) {
            if (members[i].getUsername().equals(member.getUsername()))
                return true;
        }
        return false;
    }

    public void listFlights() {
        if (numOfFlights > 0) {
            System.out.println(" - Available Flights: ");
            for (int i = 0; i < numOfFlights; i++) {
                System.out.printf("%-3d # Departure: %-9s # Destination: %-9s # Flight Number: %s%n",
                        (i + 1), flights[i].getDeparture(), flights[i].getDestination(), flights[i].getFlightNum());
            }
        } else {
            System.out.println("There are no flights available.");
        }
    }

    // Book Flight
    public boolean bookFlight(Member member) {

        // Check if the member has been reached max of booking
        if (member.getFlightsCounter() == member.bookedFlights.length) {
            System.out.println("Sorry... You have reached maximum of booked flights");
            return false;
        }

        String choice;
        boolean state = false;

        // Printing Flights Details
        listFlights();
        do {
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
                        return false;
                    }

                    // 2. Add points to the member
                    member.addPoints(flights[i].getDistance());

                    // 3. if the member reached specific points upgrade the membership level to the next level
                    if (member.getPoints() >= member.getPointsToUpgrade() && member.getMembershipLevel().equalsIgnoreCase("Silver")) {
                        for (int j = 0; j < numOfMembers; j++) {
                            if (member.getUsername().equalsIgnoreCase(members[j].getUsername())) {
                                member.subtractByPointsToUpgrade(members[j].getPointsToUpgrade()); // members[j].pointsToUpgrade
                                members[j] = new GoldMember(member);
                                System.out.println("CONGRATULATIONS, YOUR MEMBERSHIP HAS BEEN UPGRADED TO GOLD MEMBERSHIP SUCCESSFULLY");

                                // 4. Return to main menu
                                return true;
                            }
                        }
                    } else if (member.getPoints() >= member.getPointsToUpgrade() && member.getMembershipLevel().equalsIgnoreCase("Gold")) {
                        for (int j = 0; j < numOfMembers; j++) {
                            if (member.getUsername().equalsIgnoreCase(members[j].getUsername())) {
                                member.subtractByPointsToUpgrade(members[j].getPointsToUpgrade()); // members[j].pointsToUpgrade
                                members[j] = new PlatinumMember(member);
                                System.out.println("CONGRATULATIONS, YOUR MEMBERSHIP HAS BEEN UPGRADED TO PLATINUM MEMBERSHIP SUCCESSFULLY");

                                // 4. Return to main menu
                                return true;
                            }
                        }
                    }
                }
            }
            if (!state) {
                System.out.println("Invalid flight number. Please try again.");
            }

        } while (!state);
        return false;
    }

    // View Member Details Method
    public void viewMemberDetails(Member member) {
        String name = member.getName();
        String username = member.getUsername();
        String password = member.getPassword();
        int points = member.getPoints();
        System.out.println("==========================[Member Information]==========================");
        System.out.println("- Name: " + name);
        System.out.println("- Username: " + username);
        System.out.println("- Loyalty Points: " + points);
        System.out.println("- Booked Flights");
        member.printBookedFlights();
        System.out.println("========================================================================");
    }

    // Delete Flight
    public void deleteFlight(Member member) {
        String choice;
        boolean found = false;
        boolean exist;

        do {
            // Print booked flights
            System.out.println("==========================[Booked Flights]==========================");
            exist = member.printBookedFlights();
            if (!exist) {
                break;
            }

            System.out.print("Enter the flight number you'd like to delete: ");
            choice = scanner.next();

            for (int i = 0; i < member.flightsCounter; i++) {
                if (choice.equalsIgnoreCase(member.bookedFlights[i].getFlightNum())) {
                    // Subtract points
                    member.subtractPointsByDistance(member.bookedFlights[i].getDistance());
                    boolean removedFromFlight = member.bookedFlights[i].removePassenger(member);

                    if (removedFromFlight) {
                        // Shift all elements after the removed flight
                        for (int j = i; j < member.flightsCounter - 1; j++) {
                            member.bookedFlights[j] = member.bookedFlights[j + 1];
                        }
                        // Decrease flight counter and set the last flight to null
                        member.bookedFlights[--member.flightsCounter] = null;

                        found = true;
                        System.out.println("Flight canceled and passenger removed...");
                    } else {
                        System.out.println("Passenger not found in the flight.");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid flight number. Please try again.");
            }
        } while (!found);
    }

}
