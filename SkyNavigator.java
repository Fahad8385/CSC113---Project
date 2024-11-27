public class SkyNavigator extends SkyExplorer {
    // Attributes
    private static final int POINTS_TO_UPGRADE = 50000;

    // No-Arguments Constructor
    public SkyNavigator() {
    }

    ;

    // Parameterized Constructor
    public SkyNavigator(String name, String username, String password) {
        super(name, username, password);
    }

    // Copy Constructor
    public SkyNavigator(Member member) {
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
        return "SkyNavigator";
    }

    public int getPointsToUpgrade() {
        return POINTS_TO_UPGRADE;
    }
}
