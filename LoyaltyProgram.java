//import java.util.Scanner;
//import java.io.*;
//
//public class LoyaltyProgram {
//    // Attributes
//    private Scanner scanner = new Scanner(System.in);
//    private Member[] members;
//    private Flight[] flights;
//    private int numOfMembers;
//    private int numOfFlights;
//
//    // Parameterized Constructor
//    public LoyaltyProgram() {
//        members = new Member[3];
//        flights = new Flight[50];
//    }
//
//    // Adding members to our system
//    public boolean addMembers(Member member) {
//        if (numOfMembers < members.length && !searchForMember(member)) {
//            members[numOfMembers++] = new SilverMember(member);
//            System.out.println("Member has been created successfully");
//            return true;
//        }
//        if (searchForMember(member)) {
//            System.out.println("Member already exists");
//        }
//        if (numOfMembers == members.length) {
//            System.out.println("Sorry... You have reached maximum of members");
//        }
//        return false;
//    }
//
//    public void addFlight(Flight flight) {
//        flights[numOfFlights++] = new Flight(flight);
//    }
//
//    // Login member to the system
////    public Member login(String username, String password) throws CustomException { // Added Custom Ex. (1)
////        int attempts = 0;
////        boolean found = false;
////        while (attempts < 3) {
////            // System.out.print("Enter username: ");
////            username = scanner.next().toLowerCase();
////            // System.out.print("Enter password: ");
////            password = scanner.next();
////
////            // Checking if the input is valid
////            for (int i = 0; i < numOfMembers; i++) {
////                if (username.equals(members[i].getUsername()) && password.equals(members[i].getPassword())) {
////                    // System.out.println("Logging in...");
////                    found = true;
////                    return members[i];
////                }
////            }
////            if (!found) {
////                // System.out.println("username or password is incorrect");
////                attempts++;
////                // System.out.println("Left Attempts: " + (3 - attempts));
////            }
////        } // end while loop
////        throw new CustomException("You reached maximum attempts");
////    }
////
////    // Searching for members
////    public boolean searchForMember(Member member) {
////        for (int i = 0; i < numOfMembers; i++) {
////            if (members[i].getUsername().equals(member.getUsername()))
////                return true;
////        }
////        return false;
////    }
//
//    public Member login(String username, String password) throws CustomException {
//        // Check if the input matches any registered member
//        for (int i = 0; i < numOfMembers; i++) {
//            if (username.equalsIgnoreCase(members[i].getUsername()) && password.equals(members[i].getPassword())) {
//                return members[i];  // Successful login
//            }
//        }
//
//        // If no match is found, throw an exception
//        throw new CustomException("Invalid credentials. Please try again.");
//    }
//
//
//    public boolean listFlights() {
//        if (numOfFlights > 0) {
//            System.out.println(" - Available Flights: ");
//            for (int i = 0; i < numOfFlights; i++) {
//                System.out.printf("%-3d # Departure: %-9s # Destination: %-9s # Flight Number: %s%n",
//                        (i + 1), flights[i].getDeparture(), flights[i].getDestination(), flights[i].getFlightNum());
//            }
//            return true;
//        } else {
//            System.out.println("There are no flights available.");
//            return false;
//        }
//    }
//
//    // Book Flight
//    public boolean bookFlight(Member member) {
//        int attempts = 0;
//        // Check if the member has been reached max of booking
//        if (member.getFlightsCounter() == member.bookedFlights.length) { // added Unchecked Ex. (1)
//            throw new IllegalStateException("Sorry... You have reached maximum of booked flights.");
//        }
//
//        String choice;
//        boolean state = false;
//
//        // Printing Flights Details
//
//        if (!listFlights())
//            return false;
//        do {
//            System.out.print("Enter the flight number you'd like to book: ");
//            choice = scanner.next().toUpperCase();
//
//            for (int i = 0; i < numOfFlights; i++) {
//                if (choice.equals(flights[i].getFlightNum())) {
//                    // 1. Add the member to passengers, Add the flight to bookedFlights
//                    if (member.addFlight(flights[i])) {
//                        flights[i].addMember(member);
//                        System.out.println("Flight booked successfully!");
//                        state = true;
//                    } else {
//                        return false;
//                    }
//
//                    // 2. Add points to the member
//                    member.addPoints(flights[i].getDistance());
//
//                    // 3. if the member reached specific points upgrade the membership level to the next level
//                    if (member.getPoints() >= member.getPointsToUpgrade() && member.getMembershipLevel().equalsIgnoreCase("Silver")) {
//                        for (int j = 0; j < numOfMembers; j++) {
//                            if (member.getUsername().equalsIgnoreCase(members[j].getUsername())) {
//                                member.subtractByPointsToUpgrade(members[j].getPointsToUpgrade()); // members[j].pointsToUpgrade
//                                members[j] = new GoldMember(member);
//                                System.out.println("CONGRATULATIONS, YOUR MEMBERSHIP HAS BEEN UPGRADED TO GOLD MEMBERSHIP SUCCESSFULLY");
//
//                                // 4. Return to main menu
//                                return true;
//                            }
//                        }
//                    } else if (member.getPoints() >= member.getPointsToUpgrade() && member.getMembershipLevel().equalsIgnoreCase("Gold")) {
//                        for (int j = 0; j < numOfMembers; j++) {
//                            if (member.getUsername().equalsIgnoreCase(members[j].getUsername())) {
//                                member.subtractByPointsToUpgrade(members[j].getPointsToUpgrade()); // members[j].pointsToUpgrade
//                                members[j] = new PlatinumMember(member);
//                                System.out.println("CONGRATULATIONS, YOUR MEMBERSHIP HAS BEEN UPGRADED TO PLATINUM MEMBERSHIP SUCCESSFULLY");
//
//                                // 4. Return to main menu
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//            if (!state) {
//                System.out.println("Invalid flight number. Please try again.");
//                attempts++;
//            }
//            if (attempts >= 3) {
//                System.out.println("Too many invalid tries..."); // added a try limit
//                break;
//            }
//
//        } while (!state);
//        return false;
//    }
//
//    // View Member Details Method
//    public void viewMemberDetails(Member member) {
//        String name = member.getName();
//        String username = member.getUsername();
//        String password = member.getPassword();
//        int points = member.getPoints();
//        System.out.println("==========================[Member Information]==========================");
//        System.out.println("- Name: " + name);
//        System.out.println("- Username: " + username);
//        System.out.println("- Loyalty Points: " + points);
//        System.out.println("- Booked Flights");
//        member.printBookedFlights();
//        System.out.println("========================================================================");
//    }
//
//    // Delete Flight
//    public void deleteFlight(Member member) {
//        String choice;
//        boolean found = false;
//        boolean exist;
//
//        do {
//            // Print booked flights
//            System.out.println("==========================[Booked Flights]==========================");
//            exist = member.printBookedFlights();
//            if (!exist) {
//                break;
//            }
//
//            System.out.print("Enter the flight number you'd like to delete: ");
//            choice = scanner.next();
//
//            for (int i = 0; i < member.flightsCounter; i++) {
//                if (choice.equalsIgnoreCase(member.bookedFlights[i].getFlightNum())) {
//                    // Subtract points
//                    member.subtractPointsByDistance(member.bookedFlights[i].getDistance());
//
//
//                    boolean removedFromFlight = member.bookedFlights[i].removePassenger(member);
//
//                    if (removedFromFlight) {
//
//                        // Shift all elements after the removed flight
//                        for (int j = i; j < member.flightsCounter - 1; j++) {
//                            member.bookedFlights[j] = member.bookedFlights[j + 1];
//                        }
//                        // Decrease flight counter and set the last flight to null
//                        // member.bookedFlights[--member.flightsCounter] = null;
//
//                        found = true;
//                        System.out.println("Flight canceled and passenger removed...");
//                    } else {
//                        System.out.println("Passenger not found in the flight.");
//                    }
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("Invalid flight number. Please try again.");
//            }
//        } while (!found);
//    }
//
//    public void exitProgram() {
//        System.out.println("Exited...");
//        try {
//            this.saveMembersToFile("members.dat");
//            this.saveFlightsToFile("flights.dat");
//            System.out.println("Data saved successfully.");
//        } catch (IOException e) {
//            System.out.println("Error saving data: " + e.getMessage());
//        }
//    }
//
//
//    public void saveMembersToFile(String filename) throws IOException { // Save members list to file
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
//            oos.writeObject(members);
//            oos.writeInt(numOfMembers);
//        }
//    }
//
//    public void loadMembersFromFile(String filename) throws IOException, ClassNotFoundException { // Load members list from file
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
//            members = (Member[]) ois.readObject();
//            numOfMembers = ois.readInt();
//        }
//    }
//
//    public void saveFlightsToFile(String filename) throws IOException { // Save flights list to file
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
//            oos.writeObject(flights);
//            oos.writeInt(numOfFlights);
//        }
//    }
//
//    public void loadFlightsFromFile(String filename) throws IOException, ClassNotFoundException { // Load flights list from file
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
//            flights = (Flight[]) ois.readObject();
//            numOfFlights = ois.readInt();
//        }
//    }
//}

import java.io.*;

public class LoyaltyProgram {
    private Member[] members;
    private Flight[] flights;
    private int numOfMembers;
    private int numOfFlights;

    public LoyaltyProgram() {
        members = new Member[3];
        flights = new Flight[50];
    }

    // Login method now accepts username and password directly (no Scanner)
    public Member login(String username, String password) throws CustomException {
        // Check if the input matches any registered member
        for (int i = 0; i < numOfMembers; i++) {
            if (username.equalsIgnoreCase(members[i].getUsername()) && password.equals(members[i].getPassword())) {
                return members[i];  // Successful login
            }
        }
        throw new CustomException("Username or Password is incorrect. Please try again.");
    }

    // Other methods (addMembers, addFlight, etc.) remain unchanged
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
            System.out.println("Sorry... You have reached the maximum number of members");
        }
        return false;
    }

    public boolean searchForMember(Member member) {
        for (int i = 0; i < numOfMembers; i++) {
            if (members[i].getUsername().equals(member.getUsername()))
                return true;
        }
        return false;
    }

    // Saving and loading data to/from files remains unchanged
    public void saveMembersToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(members);
            oos.writeInt(numOfMembers);
        }
    }

    public void loadMembersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            members = (Member[]) ois.readObject();
            numOfMembers = ois.readInt(); // Read the number of members
        } catch (FileNotFoundException e) {
            System.out.println("No saved members found. Starting fresh.");
            members = new Member[50]; // Initialize with a default size if no file is found
            numOfMembers = 0;
        }
    }


    public void saveFlightsToFile(String filename) throws IOException { // Save flights list to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(flights);
            oos.writeInt(numOfFlights);
        }
    }

    public void loadFlightsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            flights = (Flight[]) ois.readObject();
            numOfFlights = ois.readInt(); // Read the number of flights
        } catch (FileNotFoundException e) {
            System.out.println("No saved flights found. Starting fresh.");
            flights = new Flight[50]; // Initialize with a default size if no file is found
            numOfFlights = 0;
        }
    }


    public String listFlights() {
        StringBuilder flightList = new StringBuilder();
        if (numOfFlights > 0) {
            // Format the flight information into a string
            for (int i = 0; i < numOfFlights; i++) {
                if (flights[i] != null) {
                    flightList.append(String.format("%-3d # Departure: %-9s # Destination: %-9s # Flight Number: %s%n",
                            (i + 1), flights[i].getDeparture(), flights[i].getDestination(), flights[i].getFlightNum()));
                }
            }
        } else {
            flightList.append("There are no flights available.");
        }
        return flightList.toString(); // Return the formatted string
    }




    public Flight[] getFlights() {
        return flights;  // Ensure that it returns the correct array of flights
    }

    public boolean bookFlight(Member member, Flight flight) {
        // Check if the member has reached their max number of booked flights
        if (member.getFlightsCounter() == member.bookedFlights.length) {
            throw new IllegalStateException("Sorry... You have reached the maximum number of booked flights.");
        }

        // Add the flight to the member's booked flights
        member.addFlight(flight);

        // Add points to the member based on the flight distance
        member.addPoints(flight.getDistance());

        // Optionally, upgrade membership if applicable
        upgradeMembershipIfNeeded(member);

        return true; // Return true to indicate successful booking
    }

    private void upgradeMembershipIfNeeded(Member member) {
        // Example of membership upgrade logic
        if (member.getPoints() >= member.getPointsToUpgrade()) {
            // Handle membership upgrade
        }
    }


    public boolean cancelFlight(Member member, Flight flight) {
        // Remove the flight from the member's booked flights
        if (member.removeFlight(flight)) {
            // Subtract points for the canceled flight
            member.subtractPointsByDistance(flight.getDistance());

            return true;
        } else {
            return false; // Return false if the flight was not found in the booked list
        }
    }

    public void addMockMembers() {
        // Create mock members and add them to the array
        members[numOfMembers++] = new SilverMember("usm", "usm", "123456");
        members[numOfMembers++] = new GoldMember("Jane Smith", "jane", "pass456");
        members[numOfMembers++] = new PlatinumMember("Alex Johnson", "alex", "password789");
        System.out.println("Mock members added.");
    }

}

