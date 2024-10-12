import java.util.Scanner;
public class mainProgram {
	public static void main(String[] args) {
		LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
		UserInterface userInterface = new UserInterface();
		// Flight
		Flight f1 = new Flight("Riyadh", "Jeddah", 838);
		Flight f2 = new Flight("Riyadh", "Dammam", 368);
		Flight f3 = new Flight("Jeddah", "Dammam", 1201);
		Flight f4 = new Flight("Tabuk", "Riyadh", 1085);
		Flight f5 = new Flight("Riyadh", "Cairo", 1613);
		
		// Array of flights
		Flight [] flightsArr = new Flight[]{f1, f2, f3, f4, f5};
		
		// Adding flights to loyaltyProgram
		for (Flight f : flightsArr) {
			loyaltyProgram.addFlights(f);
		}
		
		boolean state = true;
		while (state) {
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
							choice = userInterface.secondInterface(member.getName());
							switch (choice) {
								case "1":
									if (userInterface.backToMainMenu())
										break;
									loyaltyProgram.bookFlight();
									break;
								case "2":
									System.out.println("Cancle Flight");
									break;
								case "3":
									System.out.println("View Points");
									break;
								case "4":
									System.out.println("Log out");
									break;
								case "q":
									state2 = false;
									break;
							}
						}
					}
					break;
					
				// ===[Quit]=== //
				case "q":
					System.out.println("Quit");
					state = false;
					break;
			}
		}
	}
}