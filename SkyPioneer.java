public class SkyPioneer extends SkyExplorer {

    // For Future Using
    // public static final int pointsToUpgrade = 50000;

    //  No-Arguments Constructor
    public SkyPioneer() {
    }

    ;

    // Parameterized Constructor
    public SkyPioneer(String name, String username, String password) {
        super(name, username, password);
    }

    // Copy Constructor
    public SkyPioneer(Member member) {
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
        return "SkyPioneer";
    }

    // For Future Using
    // public int getPointsToUpgrade() {
    // 	return POINTS_TO_UPGRADE;
    // }
}
