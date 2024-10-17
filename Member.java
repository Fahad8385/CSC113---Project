public abstract class Member {
    // Attributes
    protected String name;
    protected String userName;
    protected String password;
    protected int points;
    protected Flight[] bookedFlights;
    protected int flightsCounter;

    // No-Arguments Constructor
    public Member() {}

    // Parameterized Constructor
    public Member(String name, String username, String password) {
    	this.name = name;
    	this.userName = username;
    	this.password = password;
    	bookedFlights = new Flight[50];
    }

    // Abstract Methods    
    public abstract void addPoints(int distance);
    public abstract void substractPointsDistanceBased(int distance);
    public abstract String getMemberShipLevel();
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
    		System.out.println("Your reached max of booking filght which is 3");
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
				System.out.println((i + 1) + " - # From: " + bookedFlights[i].getFrom() + "  " + "To: " + bookedFlights[i].getTo() + "  " + "Flight Number: " + bookedFlights[i].getFlightNum() +" ");
			}
            return true;
		} else {
			System.out.println("There is no flights");
            return false;
		}
	}
    
    public void subtractPointsPointsToUpgradeBased(int points) {
    	this.points -= points;
    }

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
}