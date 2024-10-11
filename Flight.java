public class Flight {
    // Attributes
    private String flightNumber = "R1";
    private static int counter;
    private Member [] passengers;
    private String from; // "e.g" : Riyadh
    private String to; // "e.g" : Jeddah
    private double distance; // 954,6 KM - I look up for it in google (:

    // Parametrized Constructor
    public Flight(String from, String to, double distance) {
        flightNumber += counter++;
        this.from = from;
        this.to = to;
        this.distance = distance;
        passengers = new Member[10];
    }

    // Get flight member
    public String getflightNumber() {
        return flightNumber;
    }
}