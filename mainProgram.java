public class mainProgram {
    public static void main(String[] args) {
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        UserInterface userInterface = new UserInterface();

        // Flights
        Flight f1 = new Flight("Riyadh", "Jeddah", 25000);
        Flight f2 = new Flight("Jeddah", "Dammam", 50000);
        Flight f3 = new Flight("Tabuk", "Riyadh", 674);
        Flight f4 = new Flight("Riyadh", "Cairo", 1002);
        Flight f5 = new Flight("Riyadh", "Dubai", 542);
        Flight f6 = new Flight("Cairo", "Kuwait", 1004);
        Flight f7 = new Flight("Jeddah", "Khartoum", 995);
        Flight f8 = new Flight("Riyadh", "Muscat", 873);
        Flight f9 = new Flight("Jeddah", "London", 2889);
        Flight f10 = new Flight("Cairo", "Rome", 1330);
        Flight f11 = new Flight("Riyadh", "Istanbul", 1563);
        Flight f12 = new Flight("Jeddah", "Doha", 820);
        Flight f13 = new Flight("Riyadh", "Paris", 2892);
        Flight f14 = new Flight("Jeddah", "New York", 6635);
        Flight f15 = new Flight("Riyadh", "Mumbai", 1716);


        // Array of flights
        Flight[] flightsArr = new Flight[]{
                f1, f2, f3, f4, f5, f6, f7, f8,
                f9, f10, f11, f12, f13, f14, f15
        };

        // Adding flights to loyaltyProgram
        for (Flight f : flightsArr) {
            loyaltyProgram.addFlight(f);
        }

        boolean state1 = true;
        while (state1) {
            String choice = userInterface.firstInterface();

            switch (choice) {

                // ===[Register]=== //
                case "1":
                    if (userInterface.backToMainMenu())
                        break;
                    Member member = userInterface.createMember();
                    loyaltyProgram.addMembers(member);
                    break;
                // ===[Login]=== //
                case "2":
                    if (userInterface.backToMainMenu())
                        break;
                    member = loyaltyProgram.login();
                    boolean isExist = false;
                    if (member != null) {
                        isExist = true;
                    }
                    if (isExist) {
                        boolean state2 = true;
                        while (state2) {
                            choice = userInterface.secondInterface(member);
                            switch (choice) {
                                case "1": // Book Flight
                                    if (userInterface.backToMainMenu())
                                        break;
                                    if (loyaltyProgram.bookFlight(member))
                                        state2 = false;
                                    break;
                                case "2": // Cancel Flight
                                    if (userInterface.backToMainMenu())
                                        break;
                                    loyaltyProgram.deleteFlight(member);
                                    break;
                                case "3": // show info
                                    loyaltyProgram.viewMemberDetails(member);
                                    break;
                                case "4": // logout
                                    if (userInterface.backToMainMenu())
                                        break;
                                    System.out.println("Log out");
                                    state2 = false;
                                    break;
                                case "q": // quit
                                    if (userInterface.backToMainMenu())
                                        break;
                                    System.out.println("Quit Program");
                                    state1 = false;
                                    state2 = false;
                                    break;
                            }
                        }
                    }
                    break;

                // ===[Quit]=== //
                case "q":
                    System.out.println("Quit");
                    state1 = false;
                    break;
            }
        }
        userInterface.exitMessage();
    }
}