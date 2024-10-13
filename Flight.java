public class Flight {
    // Attributes
    private String flightNum = "R1";
    private static int flightCounter;
    private int passengerCounter;
    private Member [] passengers;
    private String from; // "e.g" : Riyadh
    private String to; // "e.g" : Jeddah
    private double distance; // 954.6 KM - I look up for it in google (: // Well done, details are important ofc ;)

    // Parametrized Constructor
    public Flight(String from, String to, double distance) {
        flightNum += (flightCounter+1);
        flightCounter++;
        this.from = from;
        this.to = to;
        this.distance = distance;
        passengers = new Member[2];
    }

    // Copy Constructor
    public Flight(Flight flight) {
        this.from = flight.getFrom();
        this.to = flight.getTo();
        this.distance = flight.getDistance();
        this.flightNum = flight.getFlightNum();
        this.passengers = flight.passengers;
        this.passengerCounter = flight.passengerCounter;
    }

    // Add member to flight
    public boolean addMember(Member member) {
        for(int i = 0; i < passengerCounter; i++)
            if (passengers[i].equals(member))
                return false;

        if(passengerCounter >= passengers.length)
            return false;

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

    public String getTo() { return to; }
    public double getDistance() { return distance; }

}