public class PlatinumMember extends SilverMember {

	// For Future Using
	// public static final int pointsToUpgrade = 50000;

	// No-Arguments Constructor
	public PlatinumMember() {};
	
	// Parameterized Constructor
	public PlatinumMember(String name, String username, String password) {
		super(name, username, password);
	}
	
	// Copy Constructor
	public PlatinumMember(Member member) {
		this.name = member.name;
		this.userName = member.userName;
		this.password = member.password;
		this.points = member.points;
		this.bookedFlights = member.bookedFlights;
		this.flightsCounter = member.flightsCounter;
	}
	
	// Methods
	@Override
	public void addPoints(int distance) {
		points += distance * 2;
	}

	@Override
	public void substractPointsDistanceBased(int distance) {
		points -= distance * 1;
	}
	
	@Override
	public String getMemberShipLevel() {
		return "Platinum";
	}

	// For Future Using
    // public int getPointsToUpgrade() {
	// 	return POINTS_TO_UPGRADE;
	// }
}
