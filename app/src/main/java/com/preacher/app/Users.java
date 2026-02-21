package com.preacher.app;

public class Users {


    public Users() {

    }

    String FirstName, LastName, PhoneNumber, Country, City, Region, church, Email;

    public String getFirstName() {
        return FirstName;
    }

    public String getChurch() {
        return church;
    }

    public void setChurch(String church) {
        this.church = church;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Users(String firstName, String lastName, String phoneNumber, String country, String city, String region,String church, String email) {
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Country = country;
        City = city;
        Region = region;
        Email = email;
        this.church = church;
    }

}
