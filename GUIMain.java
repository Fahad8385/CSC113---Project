import java.io.IOException;

public class GUIMain {
    public static void main(String[] args) {
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();

        // Load members and flights from the respective files
        try {
            loyaltyProgram.loadMembersFromFile("members.dat");
            loyaltyProgram.loadFlightsFromFile("flights.dat");
            System.out.println("Data loaded successfully.");

            // Debug: Print the flights to verify they are loaded correctly
            Flight[] flights = loyaltyProgram.getFlights();
            for (Flight flight : flights) {
                if (flight != null) {
                    System.out.println("Loaded flight: " + flight.getFlightNum() + " from " + flight.getDeparture() + " to " + flight.getDestination());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
            // Add mock data if no files are found
            loyaltyProgram.addMockMembers();
            // loyaltyProgram.addMockFlights();
        }

        // Start the login frame
        new LoginFrame(loyaltyProgram);
    }
}