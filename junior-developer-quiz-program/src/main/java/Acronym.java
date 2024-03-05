package main.java;

public class Acronym {
    private String acronymLetters;
    private String acronymStandsFor;
    private String description;
    private int acronymListNumber;

    public Acronym(String acronymLetters, String acronymStandsFor, String description) {
        this.acronymLetters = acronymLetters;
        this.acronymStandsFor = acronymStandsFor;
        this.description = description;
    }

    public Acronym(String acronymLetters, String acronymStandsFor, String description, int acronymListNumber) {
        this.acronymLetters = acronymLetters;
        this.acronymStandsFor = acronymStandsFor;
        this.description = description;
        this.acronymListNumber = acronymListNumber;
    }

    public String getAcronymLetters() {
        return acronymLetters;
    }

    public void setAcronymLetters(String acronymLetters) {
        this.acronymLetters = acronymLetters;
    }

    public String getAcronymStandsFor() {
        return acronymStandsFor;
    }

    public void setAcronymStandsFor(String acronymStandsFor) {
        this.acronymStandsFor = acronymStandsFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Acronym searchByLetters(String acronymLetters) {
        return null;
    }

    public int getAcronymListNumber() {
        return acronymListNumber;
    }

    public void setAcronymListNumber(int acronymListNumber) {
        this.acronymListNumber = acronymListNumber;
    }

    @Override
    public String toString() {
        return acronymLetters + ":\n\n" + acronymStandsFor + "\n\n-" + description;
    }
}
