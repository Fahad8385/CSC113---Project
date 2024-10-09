
public class LoyaltyProgram {
	// Attributes
	private Member [] members; // We assume that the system can take max 5 members
	private int numOfMembers;
	private Flight [] flights;
	private int numOfFlights;
	
	// Parameterized Constructor
	public LoyaltyProgram() {
		members = new Member[5];
	}
	
	// Methods
	public boolean addMembers(Member member) {
		if (numOfMembers < members.length) {
			members[numOfMembers++] = new SilverMember(member);
			return true;
		}
		return false;
	}
}
