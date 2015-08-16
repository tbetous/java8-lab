package com.tbetous.javalab.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.tbetous.javalab.people.data.Person;
import com.tbetous.javalab.people.data.Person.Sex;
import com.tbetous.javalab.people.factory.PersonFactory;
import com.tbetous.javalab.people.parser.CsvPersonParser;

public class MainApp2 {

    public static void main(String[] args) {
        final String DATA_FILE_1_PATH = "data_1.csv";
        final String DATA_FILE_2_PATH = "data_2.csv";
        final String DATA_FILE_SEPARATOR = ",";

        CsvPersonParser csvParser = new CsvPersonParser();

        int nbOfMale = (int) Arrays.asList(DATA_FILE_2_PATH, DATA_FILE_1_PATH).parallelStream().mapToLong(
                (filePath) -> {
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(filePath));
                        return br.lines().map(line -> csvParser.parseLine(line, DATA_FILE_SEPARATOR, PersonFactory::create))
                                .filter(person -> Sex.MALE.equals(person.getGender()))
                                .count();
                    } catch (FileNotFoundException fne) {
                        throw new IllegalStateException("File was not found", fne);
                    } catch (IOException ioe) {
                        throw new IllegalStateException("IO Problem", ioe);
                    } finally {
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException ioe) {
                                throw new IllegalStateException("IO Problem", ioe);
                            }
                        }
                    }
                }
        ).sum();

        System.out.println(nbOfMale);
    }
}