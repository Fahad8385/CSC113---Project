public abstract class Member {
    // Attributes
    protected String name;
    protected String userName;
    protected String password;
    protected int points;

    // Parameterized Constructor
    public Member(String name, String username, String password) {
    	this.name = name;
    	this.userName = username;
    	this.password = password;
    }
    
    // No-Arguments Constructor
    public Member() {}

    // Abstract Methods
//    public abstract Member createMemeber(String name, String username, String password);
    
    public abstract void setPoints(int distance);
    
    public abstract void substractPoints(double distance);
    
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