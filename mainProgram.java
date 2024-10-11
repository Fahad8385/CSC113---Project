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
		loyaltyProgram.addFlights(f1);
		loyaltyProgram.addFlights(f2);
		loyaltyProgram.addFlights(f3);
		loyaltyProgram.addFlights(f4);

        /* LoyaltyProgram = new LoyaltyProgram(); // reCreated it before creating the flights */
		UserInterface userInterface = new UserInterface();
		
		boolean state = true;
		
		while (state) {
			String choice = userInterface.firstInterface(); // possible values for choice is ["1" || "2" || "q"]
			
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
					boolean isExist = loyaltyProgram.login();
					if (isExist) {
						choice = userInterface.loginInterface();
						switch (choice) {
							case "1":
								break;
							case "2":
								break;
							case "3":
								break;
							case "4":
								break;
							case "5":
								break;
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