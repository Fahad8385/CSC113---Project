public class GoldMember extends SilverMember {

	/* - Just to remember the attributes
	 	protected String name;
	    protected String userName;
	    protected String password;
	    protected int points;
	    protected Flight[] bookedFlights;
	    protected int flightsCounter;
	 */
	
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
	public void substractPoints(int distance) {
		points -= distance * 1;
	}
	
	@Override
	public String getMemberShipLevel() {
		return "Gold";
	}
    
}
