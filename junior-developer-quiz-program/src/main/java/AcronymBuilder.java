package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AcronymBuilder {
    private String acronymLetters;
    private String acronymStandsFor;
    private String description;


    public TreeMap<String, Acronym> acronymList = new TreeMap<>();

    public AcronymBuilder() {

        // Create new file using location of acronym data
        File acronymFile = new File("junior-developer-quiz-program/resources/acronyms.txt");

        // Read through each line of the file
        try (Scanner fileReader = new Scanner(acronymFile)) {
            fileReader.nextLine();
            while (fileReader.hasNextLine()) {
                int counter = 1;
                String line = fileReader.nextLine();

                // Create a string array for each acronym
                String[] lineParts = line.split("\\|");
                acronymLetters = (lineParts[0]);
                acronymStandsFor = lineParts[1];
                description = lineParts[2];

                Acronym acronymToAdd = new Acronym(acronymLetters, acronymStandsFor, description, counter);
                acronymList.put(acronymToAdd.getAcronymLetters(),acronymToAdd);
                counter++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }

    public TreeMap<String, Acronym> getAcronymList() {
        return acronymList;
    }
}
