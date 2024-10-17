
public class SilverMember extends Member {
	// Attributes
	public static final int POINTS_TO_UPGRADE = 5000;
	
	// No-Arguments Constructor
		public SilverMember() {};
	
	// Parameterized Constructor
	public SilverMember(String name, String username, String password) {
		super(name, username, password);
	}
	
	// Copy Constructor
	public SilverMember (Member member) {
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
		points += distance * 0.5;
	}

	@Override
	public void substractPointsDistanceBased(int distance) {
		points -= distance * 0.5;
	}
	
	@Override
	public String getMemberShipLevel() {
		return "Silver";
	}
	
	@Override
	public int getPointsToUpgrade() {
		return POINTS_TO_UPGRADE;
	}
}
