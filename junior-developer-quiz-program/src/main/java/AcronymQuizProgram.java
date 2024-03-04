package main.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AcronymQuizProgram {
    private final UserInterface userInterface;

    private final AcronymBuilder acronymBuilder;
    private List<Acronym> listOfAcronyms;

    public AcronymQuizProgram(UserInterface userInterface, AcronymBuilder acronymBuilder) {
        this.userInterface = userInterface;
        this.acronymBuilder = acronymBuilder;
        listOfAcronyms = acronymBuilder.getAcronymList();

    }

    public void run() {

        mainMenuMethod();

    }

    public void mainMenuMethod() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            // Print the main menu and prompt selection
            userInterface.printIntroMenu();
            int selection = userInterface.mainMenuSelection();

            // Use the parsed user input to select the appropriate method for each menu option
            if (selection == 1) {
                displayAcronymsAndPromptSelection();
            } else if (selection == 2) {
                addAcronymToList();
            } else if (selection == 3) {

            } else if (selection == 4) {

                String searchForAcronym = userInterface.enterInfoToSearchBy();
                Acronym acronym = searchByLetters(searchForAcronym);
            } else if (selection == 5) {
                System.exit(1);
            }
        }


    }

    public void displayAcronymsAndPromptSelection() {
        userInterface.displayAcronymsList(listOfAcronyms);
        String selection = userInterface.makeAcronymSelection();
        int selectionAsInt = parseUserInput(selection);
        userInterface.displayAcronym(listOfAcronyms.get(selectionAsInt - 1));
    }

    public void addAcronymToList() {

        Acronym acronymToAdd = userInterface.promptUserForNewAcronymInformation();
        listOfAcronyms.add(acronymToAdd);
        try (FileOutputStream outputStream = new FileOutputStream("junior-developer-quiz-program/resources/acronyms.txt", true);
             PrintWriter printWriter = new PrintWriter(outputStream)) {
                printWriter.println(acronymToAdd.getAcronymLetters() + "|" + acronymToAdd.getAcronymStandsFor() + "|" + acronymToAdd.getDescription());
        } catch (IOException e) {
            System.out.println("Could not write to acronyms.txt");
        }
    }


    public void isUserInputQ(String userInput) {
        if (userInput.equalsIgnoreCase("Q") || userInput.equalsIgnoreCase("quit")) {
        }
    }

    public int parseUserInput(String userInput) {

        // Set integer to -1, as this will never occur as a valid option and will trigger further validity checks elsewhere
        int inputAsInteger = -1;

        try {
            inputAsInteger = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            // Inform the user of an invalid entry and return to the main menu in case of exception
            userInterface.invalidSelection();
        }

        // Otherwise, return the integer
        return inputAsInteger;
    }

    public Acronym searchByLetters(String acronymLetters) {
        return null;
    }
}
