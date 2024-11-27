import java.io.Serializable;

public abstract class Member implements Serializable {
    // Attributes
    protected String name;
    protected String username;
    protected String password;
    protected int points;
    protected Flight[] bookedFlights;
    protected int flightsCounter;

    // No-Arguments Constructor
    public Member() {
    }

    // Parameterized Constructor
    public Member(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        bookedFlights = new Flight[3];
    }

    // Abstract Methods    
    public abstract void addPoints(int distance);

    public abstract void subtractPointsByDistance(int distance);

    public abstract String getMembershipLevel();

    public abstract int getPointsToUpgrade();

    // Methods
    public boolean addFlight(Flight flight) {
        // Check if the flight is already exist;
        for (int i = 0; i < flightsCounter; i++) {
            if (flight.getFlightNum().equals(bookedFlights[i].getFlightNum())) {
                System.out.println("The flight is already booked");
                return false;
            }
        }

        // Checking if the bookedFlights is full
        if (flightsCounter == bookedFlights.length) {
            System.out.println("Your reached max of booking fight which is 3");
            return false;
        }

        // Add the flight to bookedFlights
        bookedFlights[flightsCounter++] = flight;
        return true;
    }


    public int getFlightsCounter() {
        return flightsCounter;
    }

    public boolean printBookedFlights() {
        if (flightsCounter > 0) {
            for (int i = 0; i < flightsCounter; i++) {
                System.out.printf("%-3d # Departure: %-9s # Destination: %-9s # Flight Number: %s%n",
                        (i + 1), bookedFlights[i].getDeparture(), bookedFlights[i].getDestination(), bookedFlights[i].getFlightNum());
            }
            return true;
        } else {
            System.out.println("There is no flights to cancel...");
            return false;
        }
    }

    public void subtractByPointsToUpgrade(int points) {
        this.points -= points;
    }

    // Setters & Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }
}