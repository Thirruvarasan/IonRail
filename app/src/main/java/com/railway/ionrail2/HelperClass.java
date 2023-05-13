package com.railway.ionrail2;

public class HelperClass {
    String name, email, username, password;
    int userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public HelperClass(String name, String email, String username, String password, int userType) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public HelperClass() {
    }
}
