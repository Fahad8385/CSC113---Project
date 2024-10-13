import javax.swing.*;

public abstract class Member {
    // Attributes
    protected String name;
    protected String userName;
    protected String password;
    protected int points;
    protected Flight[] bookedFlights;
    protected int flightsCounter;
    ;

    // Parameterized Constructor
    public Member(String name, String username, String password) {
        this.name = name;
        this.userName = username;
        this.password = password;
        bookedFlights = new Flight[3];
    }

    // No-Arguments Constructor
    public Member() {
    }

    // Abstract Methods
//    public abstract Member createMemeber(String name, String username, String password);

    public abstract void addPoints(int distance);

    public abstract void subtractPoints(double distance);

    // Setters & Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }

    public int getFlightsCounter() {
        return flightsCounter;
    }

    ;

    public boolean addFlight(Flight flight) {
        // No need for this part
//        for(int i = 0; i < flightsCounter; i++)
//            if (bookedFlights[i].equals(flight))
//                return false;
//
//        if(flightsCounter >= bookedFlights.length)
//            return false;

        bookedFlights[flightsCounter] = flight;
        flightsCounter++;
        return true;
    }
}