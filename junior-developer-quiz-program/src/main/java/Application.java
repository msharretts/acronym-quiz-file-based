package main.java;

public class Application {
    public static void main(String[] args) {

        // Create new UserInterface and AcronymBuilder
        UserInterface userInterface = new UserInterface();
        AcronymBuilder acronymBuilder = new AcronymBuilder();


        // Create a new tradeManagerSystem and run it
        AcronymQuizProgram quizProgram = new AcronymQuizProgram(userInterface, acronymBuilder);
        quizProgram.run();

    }
}
