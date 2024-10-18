import java.util.Random;
import java.util.Scanner;
//Bonus
////Validation on user input.  Small main method. 
//References
//// https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
//// https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
//// https://gist.github.com/R3DHULK/b21adcd7bd8904507023880f80934ca0

public class wordsearch {
    // constants object file
    public static final int maxWordCount = 5; // max number of words
    public static final int maxWordLength = 8; // max word length
    public static final int gridSize = (maxWordLength * 3); // in case bigger grid needed

    private static Scanner wordSc = new Scanner(System.in);
    private static String[] words = new String[maxWordCount]; // single array to store user words
    private static int wordCount = 0; // tracks number of words entered. Starts at 0

    public static void main(String[] args) {
        intro();
        enterWords();
        
        // create the grid and fill with non-alpha chars for 
        // visual representation in troubleshooting
        char[][] grid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
                }
        }

        // randomly place words in grid verticial and horizontal (not diagonal)
        Random randPlacement = new Random(); // will pick a random int to use to place words

        // begin filling the grid with the users words.
        for (String placeWord : words) {  // start of for loop to place words in grid
            boolean placed = false; // validate word is not already placed

            while (!placed) { // ! = NOT operator https://www.shehackspurple.dev/what-does-mean-in-java-7
                boolean isHorz = randPlacement.nextBoolean(); // randomly decide direction
                int startRow, startCol;

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
                    placed = true; // Now that word is marked as placed.
                    } // end while loop
            } // end of while loop
        } // end of for loop

            // Print the final grid
            printGrid(grid);
            wordSc.close(); // closing the scanner for efficiencies.
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
public static void printGrid(char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + " ");
        }
        System.out.println(); // Move to the next line after each row
    } // end of for loop
 } // end of method to print Grid with words placed


// Method to ask for, accept, and validate users words.
// While loop to accept user words and validate (for bonus points!)
public static void enterWords () {
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
}  
// end Method to ask for, accept and validate users words. 

public static void intro() {// Introductory Text
    System.out.println("Welcome to Java Wordsearch.");
    System.out.println("Please enter up to and including " + maxWordCount + " words.");
    System.out.println("Each word under " + maxWordLength + " characters.");
    System.out.println("Please no special characters or spaces.");
} // end of intro text

} // end of class