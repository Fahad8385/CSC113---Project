public abstract class Member {
    // Attributes
    protected String name;
    protected String userName;
    protected String password;
    protected int points;

    // No-Arguments Consstructor
    public Member() {}

    // Create new Member
    public boolean createMember(String name, String userName,  String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        return true;
    }


    // Setters & Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void setPoints(int distance);

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }
}