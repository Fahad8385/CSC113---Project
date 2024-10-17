public class Flight {
    // Attributes
    private String flightNum = "SV84";
    private static int flightCounter;
    private Member [] passengers;
    private int passengerCounter;
    private String from;
    private String to;
    private int distance;

    // Parameterized Constructor
    public Flight(String from, String to, int distance) {
        flightNum += (flightCounter + 1);
        flightCounter++;
        this.from = from;
        this.to = to;
        this.distance = distance;
        passengers = new Member[15];
    }
    
    // Copy Constructor
    public Flight(Flight flight) {
    	this.from = flight.from;
    	this.to = flight.to;
    	this.distance = flight.distance;
    	this.flightNum = flight.flightNum;
    	this.passengers = flight.passengers;
    	this.passengerCounter = flight.passengerCounter;
    	
    }

    // Add member to flight
    public boolean addMember(Member member) {
    	// Checking if member is already booked the flight
        if (hasMember(member)) {
            System.out.println("The member is already booked this flight");
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
            if (passengers[i].getUserName().equals(member.getUserName())) {
                return true; // Member found in this flight
            }
        }
        return false;
    }

    // Getters
    public String getFlightNum() {
        return flightNum;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    public int getDistance() {
        return distance;
    }
}