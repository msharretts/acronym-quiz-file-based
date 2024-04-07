# Acronym Quiz Java CLI Application

## Overview
This Java Command Line Interface (CLI) application is designed to help users learn and test their knowledge of common acronyms used in software development. Users can add new acronyms to the database, search for specific acronyms, display all acronyms in the database, and take quizzes to test their understanding.

## Features
- **Display Acronyms**: The application can display alphabetically, all acronyms currently stored in the database.
- **Add Acronyms**: Users can add new acronyms along with their meanings to the database. New acronyms are formatted to capitalize the first letter of each word. In future, I hope to include the option to specialize formatting, such as in the case of RESTful APIs. I would also like to develop a protocol to omit minor words (of, the, a, etc.) from capitalization at a later date.
- **Search Acronyms**: Users can search for specific acronyms by entering their initials.
- **Quiz Mode**: Users can select a quiz option to test their knowledge of acronyms. The application randomly selects acronyms and prompts the user to provide their meanings.
- **File I/O**: This iteration of the application stores and retrieves acronyms using text file-based reading and writing. A second iteration has been created to migrate data to a database so that the quiz program can be expanded to include other vocabulary, keyboard shortcuts (stand alone and by program), and potentially interview questions.

## Getting Started
1. **Clone the Repository to Your Local Machine**:
```plaintext
git clone [https://github.com/msharretts/acronym-quiz-file-based.git]
```
2. **Open the project folder in IntelliJ IDEA or your preferred Java IDE**
3. **Find the Application file within src/main.java and run it**

## Usage
Upon launching the application, users will be presented with a menu of options:
1. **Display Acronyms**: View all acronyms currently stored in the database.
2. **Add New Acronym**: Enter a new acronym and its meaning to add it to the database.
3. **Quiz Program**: Enter quiz mode to test your knowledge of acronyms.
4. **Search for Acronym**: Search for a specific acronym by entering its initials or full name.
5. **Exit**: Quit the application.

Follow the on-screen instructions to navigate through the application and utilize its features.

## Acknowledgements
- Special thanks to Walt Impellicceiri who graciously took the time to help define several acronyms.
