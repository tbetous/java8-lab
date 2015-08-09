package com.tbetous.javalab.app;

import com.tbetous.javalab.people.data.Person;
import com.tbetous.javalab.people.factory.PersonFactory;
import com.tbetous.javalab.people.parser.CsvPersonParser;

public class App {
    public static void main(String[] args) {
        final String DATA_FILE_SEPARATOR = ",";
        final String FAKE_CSV_LINE = "Jean,Dupont,M";
        
        CsvPersonParser csvParser = new CsvPersonParser();
        Person person;
        
        // Use curryling style
        person = csvParser.parseLine(FAKE_CSV_LINE, DATA_FILE_SEPARATOR, f -> l -> g -> PersonFactory.create(f, l, g));
        System.out.println("Currying style : " + person.getFirstName() + " " + person.getLastName() + " " + person.getGender());
        
        // Use new functionnal interface
        person = csvParser.parseLine(FAKE_CSV_LINE, DATA_FILE_SEPARATOR, PersonFactory::create);
        System.out.println("TriFunction style : " + person.getFirstName() + " " + person.getLastName() + " " + person.getGender());
        
        // Use lambda style
        person = csvParser.parseLine(FAKE_CSV_LINE, DATA_FILE_SEPARATOR, (a,b,c) -> PersonFactory.create(a, b, c));
        System.out.println("Lambda style : " + person.getFirstName() + " " + person.getLastName() + " " + person.getGender());
    }
}
