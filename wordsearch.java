import java.util.Scanner;
// import java.util.Random;
//Bonus
////Validation on user input
//References
//// https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
//// https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
//// https://gist.github.com/R3DHULK/b21adcd7bd8904507023880f80934ca0

public class wordsearch {
    // objects
    public static final int maxWordCount = 5; // max number of words
    public static final int maxWordLength = 8;
    public static final int gridSize = (maxWordCount*3);
    // Random placement = new Random();

    public static void main(String[] args) {

        System.out.println("Welcome to Java Wordsearch.");
        System.out.println("Please enter up to " + maxWordCount + " words, each under " + maxWordLength + " characters.");
        System.out.println("Please no special characters or spaces.");

        Scanner wordSc = new Scanner(System.in);
        String[] words = new String[maxWordCount]; // single array to store user words
        int wordCount = 0; // tracks number of words entered. Starts at 0
       
        // for (int maxW=0; maxW<maxWordCount; maxW++) {  // previous try... 
        while (wordCount < maxWordCount) {
            System.out.println("Enter word " + (wordCount + 1) + ": ");
            String input = wordSc.nextLine().toUpperCase();

            if (input.length() <= maxWordLength && input.matches("[A-Z]+")) {
                words[wordCount] = input; // Store valid word
                wordCount++; // Increment the word count
            } else {
                System.out.println("Invalid word. Make sure it's alphabetic, under " + maxWordLength + " characters and with no spaces.");
            }
        } // end while loop to accept and validate user input

        //create the grid
        char[][] grid = new char[gridSize][gridSize]; 


// randomly place words in grid verticial and horizontal (not diagonal)
//Word placement logic (horizontally and vertically).
//Handling overlap, especially with vowels.
//Random word orientation (horizontal or vertical).

// Fill grid with default placeholder - replace with chars later!  Helps with visual representation in troubleshooting 
for (int i = 0; i < gridSize; i++) {
    for (int j = 0; j < gridSize; j++) {
        grid[i][j] = '-'; 
    }
}





        printGrid(gridSize);  // used for testing only
    }

    public static void printGrid(int gridSize) {
        // Loop to print the grid
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                System.out.print("- "); // Print a dash with a space for spacing
            }
            System.out.println(); // Move to the next line after each row
        }
    }

}