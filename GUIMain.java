import java.io.IOException;

public class GUIMain {
    public static void main(String[] args) {
        LoyaltyProgramGUI loyaltyProgramGUI = new LoyaltyProgramGUI();

//        // This part can be commented after the first run (after the flights details and members are added into files)
//        Member m1 = new SilverMember("Usama Mohamed", "usm", "123456");
//        Member m2 = new SilverMember("Fahad Alshammari", "fhd", "123456");
//        Member m3 = new SilverMember("Mohamed Bin Horaiwel", "mhd", "123456");
//
//        Flight f1 = new Flight("Riyadh", "Jeddah ", 853);
//        Flight f2 = new Flight("Jeddah", "Dammam ", 1201);
//        Flight f3 = new Flight("Tabuk ", "Riyadh ", 1085);
//        Flight f4 = new Flight("Riyadh", "Cairo  ", 1613);
//        Flight f5 = new Flight("Riyadh", "Dubai", 872);
//        Flight f6 = new Flight("Cairo", "Kuwait", 1615);
//        Flight f7 = new Flight("Jeddah", "Khartoum", 1602);
//        Flight f8 = new Flight("Riyadh", "Muscat", 1405);
//        Flight f9 = new Flight("Jeddah", "London", 4650);
//        Flight f10 = new Flight("Cairo", "Rome", 2140);
//        Flight f11 = new Flight("Riyadh", "Istanbul", 2515);
//        Flight f12 = new Flight("Jeddah", "Doha", 1320);
//        Flight f13 = new Flight("Riyadh", "Paris", 4654);
//        Flight f14 = new Flight("Jeddah", "New York", 10678);
//        Flight f15 = new Flight("Riyadh", "Mumbai", 2761);
//
//        // Array of flights
//        Flight[] flightsArr = new Flight[]{f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15};
//
//        // Adding flights to loyaltyProgram
//        for (Flight f : flightsArr) {
//            loyaltyProgramGUI.addFlight(f);
//        }
//        loyaltyProgramGUI.addMembers(m1);
//        loyaltyProgramGUI.addMembers(m2);
//        loyaltyProgramGUI.addMembers(m3);
//        // End of commented part

        // Load members and flights from files
        try {
            loyaltyProgramGUI.loadMembersFromFile("members.dat");
            loyaltyProgramGUI.loadFlightsFromFile("flights.dat");
            System.out.println("Data loaded successfully.");

            // Print the flights to verify they are loaded correctly in the console
            Flight[] flights = loyaltyProgramGUI.getFlights();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
        }

        // Show login frame
        new LoginFrame(loyaltyProgramGUI);
    }
}