//import java.io.*;
//public class mainProgram {
//    public static void main(String[] args) {
//        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
//        UserInterface userInterface = new UserInterface();
//
//        try {
//            loyaltyProgram.loadMembersFromFile("members.dat");
//            loyaltyProgram.loadFlightsFromFile("flights.dat");
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("No saved data found. Starting fresh.");
//        }
//
////        // After I saved flights in the file for the first time, there is no need for the hardcode anymore :D
////        // Flights
////        Flight f1 = new Flight("Riyadh", "Jeddah ", 853);
////        Flight f2 = new Flight("Jeddah", "Dammam ", 1201);
////        Flight f3 = new Flight("Tabuk ", "Riyadh ", 1085);
////        Flight f4 = new Flight("Riyadh", "Cairo  ", 1613);
////        Flight f5 = new Flight("Riyadh", "Dubai", 872);
////        Flight f6 = new Flight("Cairo", "Kuwait", 1615);
////        Flight f7 = new Flight("Jeddah", "Khartoum", 1602);
////        Flight f8 = new Flight("Riyadh", "Muscat", 1405);
////        Flight f9 = new Flight("Jeddah", "London", 4650);
////        Flight f10 = new Flight("Cairo", "Rome", 2140);
////        Flight f11 = new Flight("Riyadh", "Istanbul", 2515);
////        Flight f12 = new Flight("Jeddah", "Doha", 1320);
////        Flight f13 = new Flight("Riyadh", "Paris", 4654);
////        Flight f14 = new Flight("Jeddah", "New York", 10678);
////        Flight f15 = new Flight("Riyadh", "Mumbai", 2761);
////
////        // Array of flights
////        Flight[] flightsArr = new Flight[]{
////                f1, f2, f3, f4, f5, f6, f7, f8,
////                f9, f10, f11, f12, f13, f14, f15
////        };
////
////        // Adding flights to loyaltyProgram
////        for (Flight f : flightsArr) {
////            loyaltyProgram.addFlight(f);
////        }
//
//        boolean state1 = true;
//        while (state1) {
//            String choice = userInterface.firstInterface();
//
//            switch (choice) {
//
//                // ===[Register]=== //
//                case "1":
//                    if (userInterface.backToMainMenu())
//                        break;
//                    Member member = userInterface.createMember();
//                    loyaltyProgram.addMembers(member);
//                    break;
//                // ===[Login]=== //
//                case "2":
//                    try { // Handling Custom Ex. (1)
//                        if (userInterface.backToMainMenu())
//                            break;
//                        member = loyaltyProgram.login();
//                        boolean isExist = false;
//                        if (member != null) {
//                            isExist = true;
//                        }
//                        if (isExist) {
//                            boolean state2 = true;
//                            while (state2) {
//                                choice = userInterface.secondInterface(member);
//                                switch (choice) {
//                                    case "1": // Book Flight
//                                        try { // Handling Unchecked Ex. (1)
//                                            if (userInterface.backToMainMenu())
//                                                break;
//                                            if (loyaltyProgram.bookFlight(member))
//                                                state2 = false;
//                                        } catch (IllegalStateException e) { // End of Handling Unchecked Ex. (1)
//                                            System.out.println(e.getMessage());
//                                        }
//                                        break;
//                                    case "2": // Cancel Flight
//                                        if (userInterface.backToMainMenu())
//                                            break;
//                                        loyaltyProgram.deleteFlight(member);
//                                        break;
//                                    case "3": // show info
//                                        loyaltyProgram.viewMemberDetails(member);
//                                        break;
//                                    case "4": // logout
//                                        if (userInterface.backToMainMenu())
//                                            break;
//                                        System.out.println("Log out");
//                                        state2 = false;
//                                        break;
//                                    case "q": // quit
//                                        loyaltyProgram.exitProgram();
//                                        state1 = false;
//                                        state2 = false;
//                                        break;
//                                }
//                            }
//                        }
//                    } catch (CustomException e) { // End of Handling Custom Ex. (1)
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//
//                // ===[Quit]=== //
//                case "q":
//                    loyaltyProgram.exitProgram();
//                    state1 = false;
//                    break;
//            }
//        }
//        userInterface.exitMessage();
//    }
//}