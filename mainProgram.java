import java.util.Scanner;

public class mainProgram {
    public static void main(String[] args) {
        // Initializing LoyaltyProgram
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        // Adding flights in the flights array
        Flight f1 = new Flight("Riyadh", "Jeddah", 838);
        Flight f2 = new Flight("Riyadh", "Dammam", 368);
        Flight f3 = new Flight("Jeddah", "Dammam", 1201);
        Flight f4 = new Flight("Tabuk", "Riyadh", 1085);
        Flight[] flightsArr = new Flight[]{f1, f2, f3, f4};
        for (Flight flight : flightsArr) {
            loyaltyProgram.addFlights(flight);
        }
        /* LoyaltyProgram = new LoyaltyProgram(); // reCreated it before creating the flights */
        UserInterface userInterface = new UserInterface();
        String choice;
        boolean state1 = true;

        while (state1) {
            // Suggestion for Quit the program
//            if (choice.equals("q")) {
//                System.out.println("Program Quit...");
//                break;
//            }

            choice = userInterface.firstInterface(); // possible values for choice is ["1" || "2" || "q"]
            switch (choice) {

                // ===[Register]=== //
                case "1":
                    if (userInterface.backToMainMenu()) // possible values is [true => back to main menu || false => continue]
                        break;
                    Member member = userInterface.createMember();
                    loyaltyProgram.addMembers(member);
                    break;
                // ===[Login]=== //
                case "2":
                    if (userInterface.backToMainMenu()) // possible values is [true => back to main menu || false => continue]
                        break;
                    member = loyaltyProgram.login();
                    boolean isExist = false;
                    if (member != null) {
                        isExist = true;
                    }
                    if (isExist) {
                        boolean state2 = true;
                        while (state2) {
                            choice = userInterface.loginInterface();
                            switch (choice) {
                                case "1":
                                    if (userInterface.backToMainMenu())
                                        break; // can replace with continue depending on the situation
                                    loyaltyProgram.bookFlight(member);
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    // Logging out --> going back to main menu
                                    state2 = false;
                                    break;
                                case "q":
                                    // Quit the program
                                    break;
                            }
                        }
                    }
                    break;

                // ===[Quit]=== //
                case "q":
                    break;
            }
        }
    }
}