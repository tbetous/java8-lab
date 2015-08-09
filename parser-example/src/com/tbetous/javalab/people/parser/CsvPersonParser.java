package com.tbetous.javalab.people.parser;

import java.util.function.Function;

import com.tbetous.javalab.people.data.Person;
import com.tbetous.javalab.utils.TriFunction;

public class CsvPersonParser {
    
    // Currying style
    public Person parseLine(String line, String separator, Function<String, Function<String, Function<String, Person>>> creator) {
        String[] separedLine = line.split(separator);
        String firstName = separedLine[0];
        String lastName = separedLine[1];
        String gender = separedLine[2];
        return creator.apply(firstName).apply(lastName).apply(gender);
    }
    
    // New Functionnal interface style
    public Person parseLine(String line, String separator, TriFunction<String, String, String, Person> creator) {
        String[] separedLine = line.split(separator);
        String firstName = separedLine[0];
        String lastName = separedLine[1];
        String gender = separedLine[2];
        return creator.apply(firstName, lastName, gender);
    }
}
