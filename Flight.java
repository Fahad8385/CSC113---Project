import java.io.Serializable;

public class Flight implements Serializable {
    // Attributes
    private String flightNum = "SV84";
    private static int flightCounter;
    private Member[] passengers;
    private int passengerCounter;
    private String departure;
    private String destination;
    private int distance;

    // Parameterized Constructor
    public Flight(String from, String destination, int distance) {
        flightNum += (flightCounter + 1);
        flightCounter++;
        this.departure = from;
        this.destination = destination;
        this.distance = distance;
        passengers = new Member[15];
    }

    // Copy Constructor
    public Flight(Flight flight) {
        this.departure = flight.departure;
        this.destination = flight.destination;
        this.distance = flight.distance;
        this.flightNum = flight.flightNum;
        this.passengers = flight.passengers;
        this.passengerCounter = flight.passengerCounter;

    }

    // Add member to flight
    public boolean addMember(Member member) {
        // Checking if member is already booked the flight
        if (hasMember(member)) {
            System.out.println("You have already booked this flight");
            return false;
        }

        // Check if the flight is full
        if (passengerCounter == passengers.length) {
            System.out.println("Apologies, this flight is fully booked.");
            return false;
        }

        // Add the Member to passengers
        passengers[passengerCounter++] = member;
        return true;
    }

    public boolean hasMember(Member member) {
        for (int i = 0; i < passengerCounter; i++) {
            if (passengers[i].getUsername().equals(member.getUsername())) {
                return true; // Member found in this flight
            }
        }
        return false;
    }

    // Getters
    public String getFlightNum() {
        return flightNum;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public boolean removePassenger(Member member) {
        boolean found = false;
        // Find the member in the passengers array
        for (int i = 0; i < passengerCounter; i++) {
            if (passengers[i].getUsername().equals(member.getUsername())) {
                // Shift all passengers after the one to be removed
                for (int j = i; j < passengerCounter - 1; j++) {
                    passengers[j] = passengers[j + 1];
                }
                // Reduce the passenger count and set the last one to null
                passengers[--passengerCounter] = null;
                found = true;
                break;
            }
        }

        return found; // Return true if the member was found and removed
    }
}