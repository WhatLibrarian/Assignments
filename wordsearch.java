import java.util.Random;
import java.util.Scanner;
//Bonus
////Validation on user input
//References
//// https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
//// https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
//// https://gist.github.com/R3DHULK/b21adcd7bd8904507023880f80934ca0

public class wordsearch {
    // objects
    public static final int maxWordCount = 5; // max number of words
    public static final int maxWordLength = 8; // max word length
    public static final int gridSize = (maxWordLength * 3); // in case bigger grid needed

    public static void main(String[] args) {
        System.out.println("Welcome to Java Wordsearch.");
        System.out
                .println("Please enter up to " + maxWordCount + " words, each under " + maxWordLength + " characters.");
        System.out.println("Please no special characters or spaces.");

        Scanner wordSc = new Scanner(System.in);
        String[] words = new String[maxWordCount]; // single array to store user words
        int wordCount = 0; // tracks number of words entered. Starts at 0

        // While loop to accept user words and validate (for bonus points!)
        while (wordCount < maxWordCount) {
            System.out.println("Enter word " + (wordCount + 1) + ": ");
            String input = wordSc.nextLine().toUpperCase();

            if (input.length() <= maxWordLength && input.matches("[A-Z]+")) {
                words[wordCount] = input; // Store valid word
                wordCount++; // Increment the word count
            } else {
                System.out.println("Invalid word. Make sure it's alphabetic, under " + maxWordLength
                        + " characters and with no spaces.");
            }
        } // end while loop to accept and validate user input

        // create the grid
        char[][] grid = new char[gridSize][gridSize];

        // Fill grid with default placeholder - replace with chars later! Helps with
        // visual representation in troubleshooting
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
            }
        }

        // randomly place words in grid verticial and horizontal (not diagonal)
        Random randPlacement = new Random(); // will pick a random int to use to place words

        // begin filling the grid with the users words
        for (String placeWord : words) {
            boolean placed = false;  // validate word is not already placed

            while (!placed) {  // ! is a boolean NOT operator. https://www.shehackspurple.dev/what-does-mean-in-java-7/ 
                boolean isHorz = randPlacement.nextBoolean();
                //boolean isVert = randPlacement.nextBoolean();

                if (isHorz) {
                    int startRow = randPlacement.nextInt(gridSize);
                    int startCol = randPlacement.nextInt(gridSize - placeWord.length()); // isn't outside the grid
                } // end of if isHorz
                //if (isVert){
                //    int startRow = randPlacement.nextInt(gridSize - placeWord.length()); // isn't outside the grid 
                //    int startCol = randPlacement.nextInt(gridSize);
                //} // end of isVert

                
                    
               
                    int startRow = randPlacement.nextInt(gridSize - placeWord.length());
                    int startCol = randPlacement.nextInt(gridSize);

                    // Check if the word fits and can overlap
                    boolean canPlace = true;
                    for (int i = 0; i < placeWord.length(); i++) {
                        if (grid[startRow + i][startCol] != '-'
                                && grid[startRow + i][startCol] != placeWord.charAt(i)) {
                            canPlace = false;
                            break;
                        }
                    }
                    if (canPlace) {
                        for (int i = 0; i < placeWord.length(); i++) {
                            grid[startRow + i][startCol] = placeWord.charAt(i);
                        }
                        placed = true;
                    } //end of if can Place
                } // end of else
            }


        // Print the final grid
        printGrid(grid);
        
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
} // end of class