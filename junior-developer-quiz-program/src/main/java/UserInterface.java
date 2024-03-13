package main.java;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserInterface {

    private final Scanner userInput = new Scanner(System.in);


    // Print Main menu
    public void printIntroMenu() {
        System.out.println();
        System.out.println("(1) Display Acronyms");
        System.out.println("(2) Add New Acronym");
        System.out.println("(3) Quiz Program");
        System.out.println("(4) Search for Acronym");
        System.out.println("(5) Exit");
        System.out.println();
    }

    // Prompt the user to make a selection and return the selection as an integer
    public int mainMenuSelection() {
        System.out.print("Make a selection: ");
        String selection = userInput.nextLine();

        // Check that the user input matches the menu options
        while (!selection.trim().equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5")) {

            // While input does not match, continue to prompt for correct input
            System.out.println("Invalid selection, please enter a number 1-5: ");
            selection = userInput.nextLine();
        }
        // Once input matches menu option selection, return string input as an integer
        return Integer.parseInt(selection);
    }

    // Print a list of acronyms
    public void displayAcronymsList(TreeMap<String, Acronym> acronymList) {
        System.out.println();

        // Cycle through each team, printing with a counter number
        int counter = 1;
        for (Map.Entry<String, Acronym> acronymEntry : acronymList.entrySet()) {
            if (counter < 10) {
                System.out.println(counter + ")  " + acronymEntry.getKey());
                acronymEntry.getValue().setAcronymListNumber(counter);
                counter++;
            } else {
                System.out.println(counter + ") " + acronymEntry.getKey());
                acronymEntry.getValue().setAcronymListNumber(counter);
                counter++;
            }

        }
    }

    public void displayAcronym(Acronym acronym) {
        System.out.println();
        System.out.println(acronym.toString());
    }

    public String printAcronymLetters(String acronymLetters) {
        System.out.println();
        System.out.println(acronymLetters);
        String meaning = promptForAcronymMeaning();
        return meaning;
    }

    // Prompt user to select an acronym and return input
    public String makeAcronymSelection() {
        System.out.println();
        System.out.print("Select an acronym by number or (Q) to quit: ");
        return userInput.nextLine();
    }

    // Inform the user if their input does not match the requested criteria
    public void invalidSelection() {
        System.out.println("Invalid selection.");
    }

    public void acronymAlreadyExistsInList(Acronym acronym) {
        System.out.println("Acronym already exists.");
    }

    // Prompt the user as to whether or not they wish to select additional players after initial player selection
    public String selectAnotherAcronym() {
        System.out.println();
        System.out.println("Select another acronym? (Y/N): ");
        return userInput.nextLine();
    }

    // Prompt the user for information to search with
    public String enterInfoToSearchBy() {
        System.out.println();
        System.out.println("Please enter an acronym or enter (Q) to quit: ");
        return userInput.nextLine();
    }

    // Prompt a keystroke before returning to main menu
    public String returnToMainMenu() {
        System.out.println();
        System.out.println("Please hit enter to return to the main menu.");
        return userInput.nextLine();
    }

    public Acronym promptUserForNewAcronymInformation() {
        System.out.println();
        System.out.println("Please enter acronym letters: ");
        String letters = userInput.nextLine().toUpperCase();

        String words = promptForAcronymMeaning();

        String newWords = "";
        String[] letterMeanings = words.split("\\ ");
        for (String word : letterMeanings) {
            word = word.substring(0,1).toUpperCase() + word.substring(1);
            newWords = newWords + word + " ";
        }

        System.out.println("Please enter a short description of the acronym: ");
        String description = userInput.nextLine();

        Acronym acronyn = new Acronym(letters, newWords.trim(), description);
        return acronyn;
    }

    public String promptForAcronymMeaning () {
        System.out.println("Please enter the words represented by the letters: ");
        String words = userInput.nextLine();
        return words;
    }

    public void congratulateUser(Acronym acronym) {
        System.out.println();
        System.out.println("That's correct! Nice work.");
        displayAcronym(acronym);
    }

    public void shameUser(Acronym acronym) {
        System.out.println();
        System.out.println("Shame. Shame. Shame.");
        displayAcronym(acronym);
    }
}
