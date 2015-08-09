package com.tbetous.javalab.people.data;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }
    
    private String firstName;
    private String lastName;
    private Sex gender;
    
    public Person(String firstName, String lastName, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Sex getGender() {
        return gender;
    }
}
