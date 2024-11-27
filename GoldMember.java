import java.io.Serializable;

public class GoldMember extends SilverMember implements Serializable {
    // Attributes
    private static final int POINTS_TO_UPGRADE = 20000;

    // No-Arguments Constructor
    public GoldMember() {
    }

    ;

    // Parameterized Constructor
    public GoldMember(String name, String username, String password) {
        super(name, username, password);
    }

    // Copy Constructor
    public GoldMember(Member member) {
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
        points += distance * 1;
    }

    @Override
    public void subtractPointsByDistance(int distance) {
        points -= distance * 1;
    }

    @Override
    public String getMembershipLevel() {
        return "Gold";
    }

    public int getPointsToUpgrade() {
        return POINTS_TO_UPGRADE;
    }
}
