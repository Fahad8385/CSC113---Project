import java.util.Scanner;
public class mainProgram {
	public static void main(String[] args) {
		Flight f1 = new Flight("Riyadh", "Jeddah", 954.6);
		System.out.println(f1.getflightNumber());

		Flight f2 = new Flight("Riyadh", "ALUla", 1040.6);
		System.out.println(f2.getflightNumber());
		Scanner input = new Scanner(System.in);
		boolean state = true;
		
		while(state) {
			System.out.println("======Welcome to Loyalty Program======");
			System.out.println("1. Register a new member");
			System.out.println("2. Login");
			System.out.println("Q. Quit Program");
			
			String choice = input.next();
			switch (choice) {
			case "1":
				
			}
		}
	}
}