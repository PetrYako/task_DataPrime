package model;

public class User {

    private String name;
    private boolean isOnline;

    public User(String name) {
        this.name = name;
        this.isOnline = true;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
