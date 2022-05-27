package com.example.icovidclusterpredictor.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userEmail;
    private String name;
    private String city;
    private String suburb;
    private String postcode;


    public LoggedInUser(String _email, String _name) {
        this.userEmail = _email;
        this.name = _name;
    }

    public LoggedInUser() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public String isShredInfo() {
        return isShredInfo;
    }

    public void setShredInfo(String shredInfo) {
        isShredInfo = shredInfo;
    }

    private String isShredInfo;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}