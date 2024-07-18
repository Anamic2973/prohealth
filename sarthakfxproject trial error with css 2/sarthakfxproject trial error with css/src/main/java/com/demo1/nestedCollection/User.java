package com.demo1.nestedCollection;

public class User {
    private String username;
    private String role;
    private String playerImg;

    // Default constructor (required for Firestore deserialization)
    public User() {
    }

    // Parameterized constructor
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
