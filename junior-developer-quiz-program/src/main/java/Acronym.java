package main.java;

public class Acronym {
    private String acronymLetters;
    private String acronymStandsFor;
    private String description;

    public Acronym(String acronymLetters, String acronymStandsFor, String description) {
        this.acronymLetters = acronymLetters;
        this.acronymStandsFor = acronymStandsFor;
        this.description = description;
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
}
