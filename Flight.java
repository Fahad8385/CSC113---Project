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
    }

    // Add member to flight
    public boolean addMember(Member member) {
        for(int i = 0; i < passengerCounter; i++)
            if (passengers[i].equals(member))
                return false;

        if(passengerCounter >= passengers.length)
            return false;
        else
            passengers[passengerCounter] = member;
        passengerCounter++;
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