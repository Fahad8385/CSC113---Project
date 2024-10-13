public class Flight {
    // Attributes
    private String flightNum = "R1";
    private static int flightCounter;
    private int passengerCounter;
    private Member[] passengers;
    private String from; // "e.g" : Riyadh
    private String to; // "e.g" : Jeddah
    private int distance; // 954.6 KM - I look up for it in google (: // Well done, details are important ofc ;)

    // Parametrized Constructor
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
        this.from = flight.getFrom();
        this.to = flight.getTo();
        this.distance = flight.getDistance();
        this.flightNum = flight.getFlightNum();
        this.passengers = flight.passengers;
        this.passengerCounter = flight.passengerCounter;
    }

    //check member in flight
    public boolean hasMember(Member member) {
        for (int i = 0; i < passengerCounter; i++) {
            if (passengers[i].equals(member)) {
                return true;  // Member found in this flight
            }
        }
        return false;
    }

    // Add member to flight
    public boolean addMember(Member member) {
        // hasMember(member); // No need for it here

        if (passengerCounter >= passengers.length)
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

    public String getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

}