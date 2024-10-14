import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);



    // First Interface
    public String firstInterface() {
        	System.out.println("====== [Welcome to Airline Loyalty Program] ======");
			System.out.println("1. Register a new member");
			System.out.println("2. Login");
			System.out.println("Q. Quit Program");
			System.out.print("Please enter your choice (1, 2 or Q): ");
            String choice = scanner.next().toLowerCase();
            
            while (choice.isEmpty() || !(choice.equals("1") || choice.equals("2") || choice.equals("q"))) {
                System.out.println("Oops.. You entered incorrect value.");
                System.out.print("Please enter your choice (1, 2 or Q): ");
                choice = scanner.next().toLowerCase();
            }
            return choice;
    }
    
    // Back to main menu
    public boolean backToMainMenu() {
    	System.out.println("Do you want to return to the main menu?");
    	System.out.print("Please enter your choice (Yes or No): ");
    	String backToMain = scanner.next().toLowerCase();
    	while (!(backToMain.equals("yes") || backToMain.equals("no"))) {
    		System.out.println("Oops.. You entered incorrect value.");
    		System.out.print("Please enter your choice (Yes or No): ");
    		backToMain = scanner.next().toLowerCase();
    	}
    	if (backToMain.equalsIgnoreCase("yes")) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    // Create Member
    public Member createMember() {
    	System.out.print("First name: ");
    	String fname = scanner.next();
		System.out.print("Last name: ");
		String lname = scanner.next();
    	System.out.print("Username: ");
    	String username = scanner.next().toLowerCase();
    	System.out.print("password: ");
    	String password = scanner.next();
		String name = fname + " " + lname;
    	Member member = new SilverMember(name, username, password);
   		// Member member = new GoldMember(name, username, password);
		// Member member = new PlatinumMember(name, username, password);
    	return member;
    }
    
    // Second Interface
	public String secondInterface(Member member) {
		System.out.println("====== [Welcome Back " + member.getName() + " (" + member.getMemberShipLevel() + ")] ======");
		System.out.println("1. Book a flight");
		System.out.println("2. Cancel a flight");
		System.out.println("3. View Member Information");
		System.out.println("4. Log out");
		System.out.println("Q. Quit Program");

		System.out.print("Please enter your choice (1, 2, 3, 4 or Q): ");
		String choice = scanner.next().toLowerCase();

		while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("q"))) {
			System.out.println("Oops.. You entered incorrect value.");

			System.out.print("Please enter your choice (1, 2, 3, 4 or Q): ");
			choice = scanner.next().toLowerCase();
		}
		return choice;
	}

	public void exitMessage() {
		System.out.println("=".repeat(13));
		System.out.println("See you soon!");
		System.out.println("=".repeat(13));
	}
}
