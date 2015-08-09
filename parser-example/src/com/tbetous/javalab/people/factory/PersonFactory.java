package com.tbetous.javalab.people.factory;

import com.tbetous.javalab.people.data.Person;
import com.tbetous.javalab.people.data.Person.Sex;;

public class PersonFactory {
    public static Person create(String firstName, String lastName, String gender) {
        // Check firstName Parameter
        if(firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("The firstName argument expect to not be null or empty");
        }
        
        // Check lastName Parameter
        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("The lastName argument expect to not be null or empty");
        }
        
        // Check gender Parameter
        if(gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("The gender argument expect to not be null or empty");
        } else {
            switch(gender) {
            case "M":
                return new Person(firstName, lastName, Sex.MALE);
            case "F":
                return new Person(firstName, lastName, Sex.FEMALE);
            default:
                throw new IllegalArgumentException("The gender parameter is supposed to be either 'M' for male or 'F' for Female");
            }
        }
    }
}

