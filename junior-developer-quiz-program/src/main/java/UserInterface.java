package main.java;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner userInput = new Scanner(System.in);


    // Print Main menu
    public void printIntroMenu() {
        System.out.println();
        System.out.println("(1) Display Acronyms");
        System.out.println("(2) Add New Acronym");
        System.out.println("(3) Quiz Program");
        System.out.println("(4) Search for Acronym");
        System.out.println("(4) Exit");
        System.out.println();
    }

    // Print a list of acronyms
    public void displayAcronyms(List<Acronym> acronymList) {
        System.out.println();

        // Cycle through each team, printing with a counter number
        int counter = 1;
        for (Acronym acronym : acronymList) {
            System.out.println(counter + ") " + acronym.toString());
            counter++;
        }
    }

    // Print the players on a given team
    public void displayTeamPlayerList(Team currentTeam) {
        System.out.println(currentTeam.getTeamLocationAndName());
        System.out.println("\t " + " Player " + " Position " + " Salary ");
        System.out.println();

        // List players on roster ordered by jersey number
        List<Player> teamRoster = currentTeam.getTeamRoster();

        // Cycle through each player, printing on separate lines
        for (Player player : teamRoster) {
            System.out.println(player.toString());
        }
    }

    // Print an individual player's information
    public void displayPlayerStats(Player player) {
        System.out.println();

        // Display ##) Player Name, Player position, salary
        System.out.println(player.toString());

        // Display stats based on position
        System.out.println(player.getStat1());
        System.out.println(player.getStat2());

    }

    // Display player info including team
    public void displayPlayerWithTeam (Player player) {
        System.out.println();
        System.out.print(player.getPlayerTeamName());
        displayPlayer(player);
    }

    // Display player info without stats included
    public void displayAcronym(Acronym acronym){
        System.out.println();

        // Display ##) Player Name, Player position, salary
        System.out.println(acronym.getJerseyNumber() + ") " +
                player.getFirstName() + " " + player.getLastName() +
                " $" + player.getSalaryAmount());
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

    // Prompt user to select a team and return input
    public String makeAcronymSelection() {
        System.out.println();
        System.out.print(" Select an acronym by entering a number or (Q) for quit: ");
        return userInput.nextLine();
    }

    // Inform the user if their input does not match the requested criteria
    public void invalidSelection() {
        System.out.println("Invalid selection, returning to main menu.");
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

}
