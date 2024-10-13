public class PlatinumMember extends SilverMember {
    @Override
    public void addPoints(int distance) {
        points += distance * 2;
    }

    @Override
    public void subtractPoints(double distance) {

    }
}
