import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);



    // First Interface
    public String firstInterface() {
        System.out.println("======Welcome to Loyalty Program======");
			System.out.println("1. Register a new member");
			System.out.println("2. Login");
			System.out.println("Q. Quit Program");
			
			System.out.print("Please enter your choice (1, 2 or Q): ");
            String choice = scanner.next().toLowerCase();
            
            while (!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("q"))) {
                System.err.println("Oops.. You entered incorrect value.");
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
    	while (!(backToMain.equalsIgnoreCase("yes") || backToMain.equalsIgnoreCase("no"))) {
    		System.err.println("Oops.. You entered incorrect value.");
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
    	System.out.print("Name: ");
    	String name = scanner.next();
    	System.out.print("Username: ");
    	String username = scanner.next();
    	System.out.print("password: ");
    	String password = scanner.next();
    	Member member = new SilverMember(name, username, password);
    	System.out.println("Member has created successfully");
    	return member;
    }
}
