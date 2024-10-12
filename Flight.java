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
        flightNum += (flightCounter++);
        flightCounter++;
        this.from = from;
        this.to = to;
        this.distance = distance;
        passengers = new Member[10];
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