public class Flight {
    // Attributes
    private String flightNum = "R1";
    private static int flightCounter;
    private int passengerCounter;
    private Member [] passengers;
    private String from;
    private String to;
    private double distance;

    // Parameterized Constructor
    public Flight(String from, String to, double distance) {
        flightNum += (flightCounter + 1);
        flightCounter++;
        this.from = from;
        this.to = to;
        this.distance = distance;
        passengers = new Member[10];
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
        for (int i = 0; i < passengerCounter; i++) {
        	if (passengers[i].getUserName().equals(member.getUserName())) {
            	System.out.println("The member is already booked this flight");
            	return false;
            }
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
}