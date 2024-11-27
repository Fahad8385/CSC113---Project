
public class SkyExplorer extends Member {
    // Attributes
    private static final int POINTS_TO_UPGRADE = 25000;

    // No-Arguments Constructor
    public SkyExplorer() {
    }

    ;

    // Parameterized Constructor
    public SkyExplorer(String name, String username, String password) {
        super(name, username, password);
    }

    // Copy Constructor
    public SkyExplorer(Member member) {
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
        points += (int) (distance * 1);
    }

    @Override
    public void subtractPointsByDistance(int distance) {
        points -= (int) (distance * 0.5);
    }

    @Override
    public String getMembershipLevel() {
        return "SkyExplorer";
    }

    @Override
    public int getPointsToUpgrade() {
        return POINTS_TO_UPGRADE;
    }
}
