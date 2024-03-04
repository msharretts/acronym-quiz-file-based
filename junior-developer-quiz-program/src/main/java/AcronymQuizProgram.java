package main.java;

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
        // Print the main menu
        userInterface.printIntroMenu();

        // Prompt a selection from the user
        int selection = userInterface.mainMenuSelection();

        // Use the parsed user input to select the appropriate method for each menu option
        if (selection == 5) {

            // Exit the program
            System.exit(1);

        } else if (selection == 1) {

            // Print a list of teams and prompt user input
            displayTeamsMenuChoice();

        } else if (selection == 2) {

            // Print list of teams and initiate a trade
            makeATrade();

        } else if (selection == 3) {

            // Display players from the waiver wire and prompt user to select a player
            pickUpPlayerFromWaiverWire();

        } else if (selection == 4) {

            // Prompt the user to search for a player
            searchForPlayer();

        }
    }

    // Display team summaries to user
    public void displayTeamsMenuChoice() {

        // Print the list of teams
        userInterface.displayTeams(listOfTeams);

        // Prompt the user to select a team by number
        String selection = userInterface.makeTeamSelection();

        // Check if the user input is "Q" (and quit) or can be parsed to return integer
        int teamSelectedInt = checkIfSelectionIsQOrInt(selection);

        // Check that the returned integer corresponds to the number of team options available
        if (teamSelectedInt > 0 && teamSelectedInt <= listOfTeams.size()) {

            // Establish the team selected by using the input integer to determine the team picked
            Team teamSelected = listOfTeams.get(teamSelectedInt - 1);

            // Call a method to print the team roster and prompt the user to select a player
            Player validPlayer = printPlayerListAndPromptSelection(teamSelected);

            // Display the player's info, including stats
            userInterface.displayPlayerStats(validPlayer);

            // Prompt the user as to whether or not they wish to waive the player
            String yOrN = userInterface.promptToWaivePlayer();

            // If the user selects yes for waiving
            if (yOrN.equalsIgnoreCase("y") || yOrN.equalsIgnoreCase("yes")) {

                // Initialize a player list and add the player to waive
                List<Player> playerToWaive = new ArrayList<>();
                playerToWaive.add(validPlayer);

                // log waived player
                transactionLogger.logWaivedPlayer(playerToWaive);

                // Remove the player from their current team
                teamSelected.removePlayerOrPLayersFromTeam(playerToWaive);

                // Add the player to the waiver wire and inform the user of a successful transaction
                waiverWire.addPlayerOrPlayersToTeam(playerToWaive);
                userInterface.transactionCompleted();

                // Return to the main menu
                mainMenuMethod();

                // If the user selects no, return to the main menu without making a trade
            } else if (yOrN.equalsIgnoreCase("n") || yOrN.equalsIgnoreCase("no")){

                mainMenuMethod();

            } else {        // Otherwise, inform the user of an invalid input and return to the main menu

                userInterface.invalidSelection();
                mainMenuMethod();

            }

        } else {            // If the input is an integer outside the range of team options

            // Inform the user of an invalid selection and return to main menu
            userInterface.invalidSelection();
            mainMenuMethod();

        }

        mainMenuMethod();

    }
}
