package main.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AcronymQuizProgram {
    private final UserInterface userInterface;

    private final AcronymBuilder acronymBuilder;
    private TreeMap<String, Acronym> listOfAcronyms;

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
                quizProgram();
            } else if (selection == 4) {
                searchForAndDisplayAcronym();
            } else if (selection == 5) {
                System.exit(1);
            }
        }


    }

    public void displayAcronymsAndPromptSelection() {
        // Display the list of acronyms and ask use to make a selection
        userInterface.displayAcronymsList(listOfAcronyms);
        String selection = userInterface.makeAcronymSelection();
        if (isUserInputQ(selection)) {
            return;
        }

        // Parse the user input to get an integer, then return the corresponding acronym from the list
        int selectionAsInt = parseUserInput(selection);

        // Check integer is valid number and display selection or inform user of invalid input
        if (selectionAsInt >= 0 && selectionAsInt < listOfAcronyms.size()) {
            Acronym acronymSelection = selectAcronymByListNumber(selectionAsInt);
            System.out.println(acronymSelection.toString());
            userInterface.returnToMainMenu();

        } else {
            userInterface.invalidSelection();
        }
    }

    public void addAcronymToList() {

        Acronym acronymToAdd = userInterface.promptUserForNewAcronymInformation();
        if (isAcronymInList(acronymToAdd.getAcronymLetters())) {
            userInterface.acronymAlreadyExistsInList(acronymToAdd);

        } else {

            try (FileOutputStream outputStream = new FileOutputStream("junior-developer-quiz-program/resources/acronyms.txt", true);
                 PrintWriter printWriter = new PrintWriter(outputStream)) {
                printWriter.println(acronymToAdd.getAcronymLetters() + "|" + acronymToAdd.getAcronymStandsFor() + "|" + acronymToAdd.getDescription());
                System.out.println(acronymToAdd.toString());
                acronymToAdd.setAcronymListNumber(listOfAcronyms.size());
                listOfAcronyms.put(acronymToAdd.getAcronymLetters(), acronymToAdd);
            } catch (IOException e) {
                System.out.println("Could not write to acronyms.txt");
            }
        }
    }

    public void quizProgram() {
        int listNumberOfRandomAcronym = RandomGenerator.getRandom(1, listOfAcronyms.size() + 1);
        if (listNumberOfRandomAcronym > 0 && listNumberOfRandomAcronym <listOfAcronyms.size()){
            Acronym acronymQuizSelection = selectAcronymByListNumber(listNumberOfRandomAcronym);
            if (acronymQuizSelection != null) {
                userInterface.displayAcronym(acronymQuizSelection);
            }
        }
    }

    public void searchForAndDisplayAcronym() {
        String searchForAcronym = userInterface.enterInfoToSearchBy();
        if (!isAcronymInList(searchForAcronym)) {
            System.out.println("Acronym not found, returning to main menu.");
        } else {
            Acronym acronym = findAcronymInList(searchForAcronym);
            userInterface.displayAcronym(acronym);
            userInterface.returnToMainMenu();
        }
    }

    public boolean isUserInputQ(String userInput) {
        if (userInput.equalsIgnoreCase("Q") || userInput.equalsIgnoreCase("quit")) {
            return true;
        }
        return false;
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

    public boolean isAcronymInList(String acronymLetters) {
        for (Map.Entry<String, Acronym> acronymEntry : listOfAcronyms.entrySet()) {
            if (acronymEntry.getKey().equals(acronymLetters)) {
                return true;
            }
        }
        return false;
    }

    public Acronym findAcronymInList(String acronymLetters) {
        for (Map.Entry<String, Acronym> acronymEntry : listOfAcronyms.entrySet()) {
            if (acronymEntry.getKey().equals(acronymLetters)) {
                return acronymEntry.getValue();
            }
        }
        return null;
    }

    private Acronym selectAcronymByListNumber(int selectionInt) {
        Collection<Acronym> acronyms = listOfAcronyms.values();
        for (Acronym acronym : acronyms) {
            if (acronym.getAcronymListNumber() == selectionInt) {
                return acronym;
            }
        }
        return null;
    }

}
