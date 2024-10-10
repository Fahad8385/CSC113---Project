
public class SilverMember extends Member {

	// Parameterized Constructor
	public SilverMember(String name, String username, String password) {
		super(name, username, password);
	}
	
	// No-Arguments Constructor
	public SilverMember() {};
	
	// Copy Constructor
	public SilverMember (Member member) {
		this.name = member.name;
		this.userName = member.userName;
		this.password = member.password;
		this.points = member.points;
	}
//	@Override
//	public Member createMemeber(String name, String username, String password) {
//		
//	}

	@Override
	public void setPoints(int distance) {
		
	}

	@Override
	public void substractPoints(double distance) {
		
	}
	
}
