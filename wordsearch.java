import java.util.Random;
import java.util.Scanner;
public class wordsearch {
    // constants object file
    public static final int maxWordCount = 5; // max number of words
    public static final int maxWordLength = 8; // max word length
    public static final int gridSize = (maxWordLength * 3); // in case bigger grid needed

    private static Scanner wordSc = new Scanner(System.in);
    private static String[] words = new String[maxWordCount]; // single array to store user words
    private static int wordCount = 0; // tracks number of words entered. Starts at 0

    private static char[][] grid = new char[gridSize][gridSize];  // initializes a mulidimensional Char Array

    public static void main(String[] args) {
        intro();
        firstMenu();
        
           /*  Scanner wordSc = new Scanner(System.in);
            int choiceMenu = wordSc.nextInt();

            switch (choiceMenu) {
                case 1:
                    for (int i = 0; i < gridSize; i++) {  // initializes a grid with '-'
                        for (int j = 0; j < gridSize; j++) {
                            grid[i][j] = '-';
                        }
                    }
                    enterWords(); // starts the user created wordsearch
                    System.out.println("TEST TEST TEST!");
                    break;
                case 2:
                    // print grid from file
                    //Ask if user wants to see the answers
                    break;
                case 3:
                    // print grid from file
                    break;
                case 4: 
                    // print grid from file
                    break;
                default:
                    System.out.println("Sorry, please enter a number between 1 and 4");
            }//end of switch */
        //wordSc.close(); // closing the scanner for efficiencies.
} // end of Main

// Method to check if the word can be placed in the grid
private static boolean canPlaceWord(char[][] grid, String word, int startRow, int startCol, boolean isHorz) {
    for (int i = 0; i < word.length(); i++) {
        char gridChar = isHorz ? grid[startRow][startCol + i] : grid[startRow + i][startCol];
        if (gridChar != '-' && gridChar != word.charAt(i)) {
            return false; // Cannot place the word
        }
    }
    return true; // Can place the word
}

// Method to place the word in the grid
public static void placeWordInGrid(char[][] grid, String word, int startRow, int startCol, boolean isHorz) {
    for (int i = 0; i < word.length(); i++) {
        if (isHorz) {
            grid[startRow][startCol + i] = word.charAt(i);
        } else {
            grid[startRow + i][startCol] = word.charAt(i);
        }
    }
}

// Method to print Grid with words
public static void printSolution(char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + " ");
        }
        System.out.println(); // Move to the next line after each row
    } // end of for loop
 } // end of method to print Grid with words placed


// Method to ask for, accept, and validate users words.
public static void enterWords () {
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

    // randomly place words in grid verticial and horizontal (not diagonal)
    Random randPlacement = new Random(); // will pick a random int to use to place words

     //begin filling the grid with the users words.
    for (String placeWord : words) {  // start of for loop to place words in grid
        //boolean placed = false; // validate word is not already placed

        //while (!placed) {  // ! = NOT operator https://www.shehackspurple.dev/what-does-mean-in-java-7
            boolean isHorz = randPlacement.nextBoolean(); // randomly decide direction
            int startRow = randPlacement.nextInt(gridSize - placeWord.length());
            int startCol = randPlacement.nextInt(gridSize - placeWord.length());

            if (isHorz) {
                startRow = randPlacement.nextInt(gridSize);
                startCol = randPlacement.nextInt(gridSize - placeWord.length()); // isn't outside the grid horizontally
            } else {
                startRow = randPlacement.nextInt(gridSize - placeWord.length()); //isn't outside the grid vertically
                startCol = randPlacement.nextInt(gridSize); 
                }
        
            // Can the word be placed?
            if (canPlaceWord (grid, placeWord, startRow, startCol, isHorz)) { // if the method canPlaceWord
               placeWordInGrid (grid, placeWord, startRow, startCol, isHorz);
               //placed = true; // Now that word is marked as placed.
               } // end if true loop
        } //end of for loop 

    System.out.println("Thank you for your words!  Now do you want to see:");
    System.out.println("1. The puzzle without the answers.");
    System.out.println("2. The puzzle with solution.");
    Scanner wordSc = new Scanner(System.in);
    int puzzle = wordSc.nextInt(); 
    switch (puzzle) {
        case 1: 
            //puzzle with alpha chars
            break;
        case 2:
            printSolution(grid);
            break;
        default:
            System.out.println("Please choose either 1 or 2");
    } 
}  
// end Method to ask for, accept and validate users words. 

public static void firstMenu() {
    System.out.println("Your choice: "); 
    int choiceMenu = wordSc.nextInt();

    switch (choiceMenu) {
        case 1:
            // Initialize the grid with '-'
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    grid[i][j] = '-';
                }
            }
            enterWords(); // starts the user-created wordsearch
            break;
        case 2:
            System.out.println("Display a pre-made wordsearch.");
            // Code for pre-made wordsearch
            break;
        case 3:
            System.out.println("Another option selected.");
            // Handle another case
            break;
        case 4:
            System.out.println("Another option selected.");
            // Handle another case
            break;
        default:
            System.out.println("Sorry, please enter a number between 1 and 4.");
    }

    wordSc.close(); // close the Scanner used for menu input
}

public static void intro() {// Introductory Text
    System.out.println("Welcome to Java Wordsearch.");
    System.out.println("You can choose to enter your own word list or choose from a few pre-populated vocab lists");
    System.out.println("1: Your own words");
    System.out.println("2: Flowers");
    System.out.println("3. Vegetables");
    System.out.println("4: Animals");
} // end of intro text

} // end of class