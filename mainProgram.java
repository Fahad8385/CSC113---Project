import java.util.Scanner;
public class mainProgram {
	public static void main(String[] args) {
		LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
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
					System.out.println("Login");
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