# Junior-Developer-Quiz-Program
A program to quiz myself on programming acronyms. Hopefully to later include vocabulary, keyboard shortcuts, and command words.

    public void addAcronymToList() {

        Acronym acronymToAdd = userInterface.promptUserForNewAcronymInformation();
        if (isAcronymInList(acronymToAdd.getAcronymLetters())) {
            userInterface.acronymAlreadyExistsInList(acronymToAdd);
        } else {

            try (FileOutputStream outputStream = new FileOutputStream("junior-developer-quiz-program/resources/acronyms.txt", true);
                                                  PrintWriter printWriter = new PrintWriter(outputStream)) {
                printWriter.println(acronymToAdd.getAcronymLetters() + "|" + acronymToAdd.getAcronymStandsFor() + "|" + acronymToAdd.getDescription());
                listOfAcronyms.add(acronymToAdd);
            } catch (IOException e) {
                System.out.println("Could not write to acronyms.txt");
            }
        }
    }