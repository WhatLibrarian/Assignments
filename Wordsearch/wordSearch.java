package Wordsearch;
/*Programmer: Rowena McKernan
 * Program:  Assignment 1: Wordsearch Puzzle 
 * CS 145 Fall 2024
 * Github: https://github.com/WhatLibrarian/Assignments 
 * 
 * Bonus Point
* Validation on user input.  
* Small main method. 
* Bolded text in title of program.
* Read from file a list of words then create a wordsearch without duplicating methods.
* File exemption check
* Words listed vertically and horizontally.
* Use Switch/Case
* User input validation using do/while loops
* User word validation with char counts++

## The following websites were useful for conceptualization
* https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
* https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
* https://gist.github.com/R3DHULK/b21adcd7bd8904507023880f80934ca0
* https://www.baeldung.com/java-character-ascii-value
* https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

### Chat GPT HELP Documented.
* Overlapping on vowels: https://chatgpt.com/share/6715670a-7e34-8001-8dc5-3e2fc1c42fe5 (didn't use it. But wanted to be transparent). 
 */

import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class wordSearch {

    public static final int maxWordCount = 5; // max number of words
    public static final int maxWordLength = 8; // max word length
    public static final int gridSize = (maxWordLength * 2); // size of grid in relation to word length

    private static Scanner wordSc = new Scanner(System.in); // SCANNER
    private static String[] words = new String[maxWordCount]; // single array to store user words
    private static int wordCount = 0; // tracks number of words entered. Starts at 0
    private static char[][] grid = new char[gridSize][gridSize]; // initializes a mulidimensional Char Array

    // MAIN
    public static void main(String[] args) {
        firstMenu();
    } // end of Main

    // METHODS

    // Method to print Grid
    public static void printSolution() {
        for (char[] row : grid) { // Loops through each row
            for (char cell : row) { // Loops through each cell in row
                System.out.print(cell + " "); // print a space after char
            }
            System.out.println(); // newLine after each row
        } // end of for loop
    } // END of printSolution Method

    // Method to fill grid with random chars.
    public static void randChars() {
        Random rand = new Random();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == '-') { // If the cell is empty, fill it with a random char
                    grid[i][j] = (char) (rand.nextInt(26) + 'a'); // Random lowercase alphabet
                } // end of if loop
            } // end of for loop
        } // end of for loop
    } // End of randChars Method

    // post choice Menu Method
    public static void postChoiceMenu() {
        boolean sameMenu = true;
        while (sameMenu) {
            System.out.println("Thank you choosing!  Now do you want to see:");
            System.out.println("1. The puzzle without the answers.");
            System.out.println("2. The puzzle with solution.");
            System.out.print("Your puzzle viewing choice: ");
            Scanner wordSc = new Scanner(System.in);
            int puzzle = wordSc.nextInt();
            wordSc.nextLine(); // Clear the buffer
            switch (puzzle) {
                case 1:
                    randChars(); // fill grid around words with random letters.
                    printSolution();
                    firstMenu();
                    break;
                case 2:
                    printSolution();
                    firstMenu();
                    break;
                // case 3: // I was trying to loop back originally...
                // sameMenu = false;
                // firstMenu();
                // break;
                default:
                    System.out.println("Please choose either 1 or 2.");
            } // end switch
        } // end while
    } // end postChoiceMenu Method

    // Method to place the word in the grid
    public static void placeWordInGrid(char[][] grid, String word, int startRow, int startCol, boolean isHorz) { // PLACING
        for (int i = 0; i < word.length(); i++) {
            if (isHorz) {
                grid[startRow][startCol + i] = word.charAt(i);
            } else {
                grid[startRow + i][startCol] = word.charAt(i);
            } // end of else
        } // end of if loop
    } // END of placeWordInGrid Method

    private static boolean canPlaceWord(char[][] grid, String word, int startRow, int startCol, boolean isHorz) { // CHECKING
        for (int i = 0; i < word.length(); i++) {
            char gridChar = isHorz ? grid[startRow][startCol + i] : grid[startRow + i][startCol];
            // places words or a dash
            if (gridChar != '-' && gridChar != word.charAt(i)) {
                return false; // Cannot place the word if letter already there.
            }
        }
        return true; // Can place the word
    } // End of canPlaceWord Method check

    // FILL grid with words. The hard part.
    public static void gridFill() {
        Random randPlacement = new Random(); // will pick a random int to use to place words

        // begin filling the grid with the words Horizontally and Vertically
        for (String placeWord : words) { // start of for loop to place words in grid

            boolean placed = false; // validate word is not already in puzzle
            int attempts = 0;

            while (!placed && attempts < maxWordCount) { // ! = NOT operator
                                                         // https://www.shehackspurple.dev/what-does-mean-in-java-7

                boolean isHorz = randPlacement.nextBoolean(); // randomly decide direction
                int startRow = randPlacement.nextInt(isHorz ? gridSize : gridSize - placeWord.length()); // Ternary
                                                                                                         // Operator:
                                                                                                         // https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
                int startCol = randPlacement.nextInt(isHorz ? gridSize - placeWord.length() : gridSize);

                if (canPlaceWord(grid, placeWord, startRow, startCol, isHorz)) {
                    placeWordInGrid(grid, placeWord, startRow, startCol, isHorz);
                    placed = true; // boolean
                } // If you can...do... otherwise keep trying
                attempts++;
            } // end of while loop

        } // end of for loop

    } // end gridFill method. Grid is now filled.

    // Method to clear the grid and initialize, this was important strangely.
    public static void clearGrid() { // initalizes the grid with dashes
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
            }
        }

    } // end of clearGrid method.

    // Method to load puzzle from a file for BONUS POINTS
    public static void puzzleFile(String fileName) {
        try {
            clearGrid(); // Resets the grid
            File puzzleFile = new File(fileName);
            Scanner fileReader = new Scanner(puzzleFile);
            wordCount = 0; // Reset the word count

            // Read words from the file, ensuring we don't exceed the maximum word count
            while (fileReader.hasNextLine() && wordCount < maxWordCount) {
                String fileWords = fileReader.nextLine();
                words[wordCount] = fileWords;
                wordCount++;
            }

            fileReader.close(); // Close the file after reading
            gridFill(); // Fill the grid with the words
        } catch (Exception e) {
            System.out.println("Error: Unable to read from file " + fileName);
            e.printStackTrace(); // Print the error for debugging
        }
        postChoiceMenu();
    } // End of puzzleFile method

    // Method to ask for, accept, and validate users words.
    public static void enterWords() {
        wordCount = 0; // Reset the word count for fresh input
        clearGrid();
        System.out.println("Please enter up to and including " + maxWordCount + " words.");
        System.out.println("Each word under " + maxWordLength + " characters.");
        System.out.println("Please no special characters or spaces.");

        while (wordCount < maxWordCount) {
            System.out.println("Enter word " + (wordCount + 1) + ": ");
            String input = wordSc.nextLine().toLowerCase();

            if (input.length() <= maxWordLength && input.matches("[a-z]+")) {
                words[wordCount] = input; // Store valid word
                wordCount++; // Increment the word count
            } else {
                System.out.println("Invalid word. Make sure it's alphabetic, under " + maxWordLength
                        + " characters and with no spaces.");
            }
        }
        gridFill();
    } // End of Method to enter words from user

    public static void firstMenu() {
        intro();
        boolean menuLoop = true;

        do {
            try {
                System.out.print("Your choice: ");
                int choiceMenu = wordSc.nextInt();
                wordSc.nextLine(); // added to clear a leftover new line

                switch (choiceMenu) {
                    case 1:
                        enterWords(); // starts the user-created wordsearch
                        postChoiceMenu();
                        break;
                    case 2:
                        System.out.println("Flowers");
                        puzzleFile("flowers.txt");
                        break;
                    case 3:
                        System.out.println("Vegetables");
                        puzzleFile("vegetables.txt");
                        break;
                    case 4:
                        System.out.println("Animals");
                        puzzleFile("animals.txt");
                        break;
                    case 5:
                        System.out.println("Thank you and Goodbye!");
                        System.exit(0); // Exit the program
                        break;
                    default:
                        System.out.println("Sorry, please enter a number between 1 and 5.");
                } // end switch case
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                wordSc.nextInt(); // Clear the invalid input
            }
        } // end of do loop
        while (menuLoop);
        wordSc.close(); // close the Scanner used for menu input
    } // end of firstMenu method

    public static void intro() {// Introductory Text
        System.out.println("\u001B[1m \tWelcome to Java Wordsearch! \033[0m");
        System.out.println(
                "You can choose to enter your own word list or choose from a few pre-populated vocab lists - Have Fun!");
        System.out.println("1: Your own words");
        System.out.println("2: Flowers");
        System.out.println("3. Vegetables");
        System.out.println("4: Animals");
        System.out.println("5: Quit");
    } // end of intro text

} // end of class wordSearch