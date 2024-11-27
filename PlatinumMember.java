import java.io.Serializable;

public class PlatinumMember extends SilverMember implements Serializable {

    // For Future Using
    // public static final int pointsToUpgrade = 50000;

    //  No-Arguments Constructor
    public PlatinumMember() {
    }

    ;

    // Parameterized Constructor
    public PlatinumMember(String name, String username, String password) {
        super(name, username, password);
    }

    // Copy Constructor
    public PlatinumMember(Member member) {
        this.name = member.name;
        this.username = member.username;
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
    public void subtractPointsByDistance(int distance) {
        points -= distance * 1;
    }

    @Override
    public String getMembershipLevel() {
        return "Platinum";
    }

    // For Future Using
    // public int getPointsToUpgrade() {
    // 	return POINTS_TO_UPGRADE;
    // }
}
