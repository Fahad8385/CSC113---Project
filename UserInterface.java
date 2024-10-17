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
		// First Name
    	System.out.print("First name: ");
    	String fname = scanner.next();
		while (fname.length() < 3) {
			System.out.println("Error. Must be greater than 3 characters!");
			System.out.print("First name: ");
    		fname = scanner.next();
		}

		// Last Name
		System.out.print("Last name: ");
		String lname = scanner.next();
		while (lname.length() < 3) {
			System.out.println("Error. Must be greater than 3 characters!");
			System.out.print("Last name: ");
    		lname = scanner.next();
		}

		// Full name
		String name = fname + " " + lname;

		// Username
    	String username = null;
        String characters = "!@#$%^&*()+=-`~\\][|{}/.><,;:''\"\"";
		boolean state;
		do {
			state = false;
			System.out.print("Username: ");
			username = scanner.next().toLowerCase();
			for (int i = 0; i < username.length(); i++) {
				if (characters.contains(String.valueOf(username.charAt(i)))) {
					System.out.println("Characters are not allowed");
					state = true;
					break;
				}
			}
		} while (state);
		// Password
    	System.out.print("password: ");
    	String password = scanner.next();

		while (password.length() < 6) {
			System.out.println("reEnter password");
			System.out.print("password: ");
			password = scanner.next();
		}

    	Member member = new SilverMember(name, username, password);
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
