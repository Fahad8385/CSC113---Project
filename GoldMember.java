public class GoldMember extends SilverMember {
	// Attributes
	public static final int POINTS_TO_UPGRADE = 20000;
	
	// No-Arguments Constructor
	public GoldMember() {};
	
	// Parameterized Constructor
	public GoldMember(String name, String username, String password) {
		super(name, username, password);
	}
	
	// Copy Constructor
	public GoldMember(Member member) {
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
		points += distance * 1;
	}

	@Override
	public void substractPointsDistanceBased(int distance) {
		points -= distance * 1;
	}
	
	@Override
	public String getMemberShipLevel() {
		return "Gold";
	}
    
	public int getPointsToUpgrade() {
		return POINTS_TO_UPGRADE;
	}
}
