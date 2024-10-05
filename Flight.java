public class Flight {
    // Attributes
    private String flightNumber = "R1";
    private static int counter;
    private Member [] passengers;
    private String from; // "e.g" : riyadh
    private String to; // "e.g" : jeddah
    private double distance; // 954,6 KM - I look up for it in google (:

    // Paramertized Constructor
    public Flight(String from, String to, double distance) {
        flightNumber += counter++;
        this.from = from;
        this.to = to;
        this.distance = distance;
        passengers = new Member[10];
    }
    public String getflightNumber() {
        return flightNumber;
    }
}