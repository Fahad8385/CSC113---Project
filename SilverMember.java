
public class SilverMember extends Member{

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
	public void setPoints(int distance) {
		
	}

	@Override
	public void substractPoints(double distance) {
		
	}
	
	@Override
	public String getMemberShipLevel() {
		return "Silver";
	}
	
}
