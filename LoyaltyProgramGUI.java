import javax.swing.*;
import java.io.*;

public class LoyaltyProgramGUI {
    private Member[] members;
    private Flight[] flights;
    private int numOfMembers;
    private int numOfFlights;

    public LoyaltyProgramGUI() {
        members = new Member[50];
        flights = new Flight[50];
    }

    // Login method now accepts username and password directly, phase 1 we were using scanner
    public Member login(String username, String password) throws CustomException {
        // Check if the input matches a registered member
        for (int i = 0; i < numOfMembers; i++) {
            if (username.equalsIgnoreCase(members[i].getUsername()) && password.equals(members[i].getPassword())) {
                return members[i];
            }
        }
        throw new CustomException("Username or Password is incorrect. Please try again.");
    }

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

    // Saving and loading data from/to files
    public void saveMembersToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(members);
            oos.writeInt(numOfMembers);
        }
    }

    public void loadMembersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            members = (Member[]) ois.readObject();
            numOfMembers = ois.readInt();
        }
    }


    public void saveFlightsToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(flights);
            oos.writeInt(numOfFlights);
        }
    }

    public void loadFlightsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            flights = (Flight[]) ois.readObject();
            numOfFlights = ois.readInt();
        }
    }

    public void addFlight(Flight flight) {
        flights[numOfFlights++] = new Flight(flight);
    }

    // return the flights in the loyaltyprgram instance
    public Flight[] getFlights() {
        return flights;
    }

    public boolean bookFlight(Member member, Flight flight) {
        // Check if the member has reached the limit of booked flights
        if (member.getFlightsCounter() == member.bookedFlights.length) {
            throw new IllegalStateException("Sorry... You have reached the maximum number of booked flights.");
        }
        // Add the flight to the member's booked flights
        member.addFlight(flight);
        // Add points to the member based on the flight distance
        member.addPoints(flight.getDistance());
        return true;
    }

    public void cancelFlight(Member member, Flight flight) {
        // Subtract points for the canceled flight
        member.subtractPointsByDistance(flight.getDistance());
        // Remove the flight from the member's booked flights
        member.removeFlight(flight);
    }


    public void exitProgram() {
        System.out.println("Exited...");
        try {
            this.saveMembersToFile("members.dat");
            this.saveFlightsToFile("flights.dat");
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}