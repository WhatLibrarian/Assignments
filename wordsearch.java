import java.util.Random;
import java.util.Scanner;
import java.io.File;  // Import the File class

public class wordsearch {
    // constants object file
    public static final int maxWordCount = 5; // max number of words
    public static final int maxWordLength = 8; // max word length
    public static final int gridSize = (maxWordLength * 2); // in case bigger grid needed

    private static Scanner wordSc = new Scanner(System.in);
    private static String[] words = new String[maxWordCount]; // single array to store user words
    private static int wordCount = 0; // tracks number of words entered. Starts at 0

    private static char[][] grid = new char[gridSize][gridSize];  // initializes a mulidimensional Char Array

public static void main(String[] args) {
        firstMenu();
        wordSc.close(); // closing the scanner for efficiencies.
} // end of Main


private static boolean canPlaceWord(char[][] grid, String word, int startRow, int startCol, boolean isHorz) {
    String vowels = "aeiou";
    
    for (int i = 0; i < word.length(); i++) {
        char gridChar = isHorz ? grid[startRow][startCol + i] : grid[startRow + i][startCol];
        char wordChar = word.charAt(i);

        // Allow placement if the cell is empty ('-') or if it's a vowel and we prioritize vowels
        if (gridChar != '-' && gridChar != wordChar) {
            // Allow vowel overlap regardless of exact match
            if (!(vowels.indexOf(gridChar) >= 0 && vowels.indexOf(wordChar) >= 0)) {
                return false; // Cannot place the word if it's not a vowel or a matching character
            }
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

//Method to clear the grid
public static void clearGrid () {  // initalizes the grid with dashes
    for (int i=0; i < gridSize; i++) {
        for (int j=0; j < gridSize; j++) {
            grid[i][j] = '-';
        }
    } 

}

//Method to fill grid with random chars.
public static void randChars (){
    Random rand = new Random();
    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < gridSize; j++) {
            if (grid[i][j] == '-') {  // If the cell is empty, fill it with a random char
                grid[i][j] = (char) (rand.nextInt(26) + 'a');  // Random lowercase alphabet
            }
        }
    }
}

//Method to load puzzle from a file for BONUS POINTS
public static void puzzleFile (String fileName) {
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
}

// Method to print Grid with words
public static void printSolution() {
    for (char[] row : grid) {
        for (char cell : row) {
            System.out.print(cell + " ");
        }
        System.out.println();
    }
}

/*public static void printSolution (char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
            System.out.print(grid[row][col] + " ");
        }
        System.out.println(); // Move to the next line after each row
    } // end of for loop
 } // end of method to print Grid with words placed */


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
    gridFill();
}

public static void gridFill(){   // fills grid with words.

    Random randPlacement = new Random(); // will pick a random int to use to place words

     //begin filling the grid with the users words in Random directions.
     // Horizontal & Vertical.  Couldn't do diagonal.
    for (String placeWord : words) {  // start of for loop to place words in grid
        
        //boolean placed = false; // validate word is not already placed
        //while (!placed) {  // ! = NOT operator https://www.shehackspurple.dev/what-does-mean-in-java-7

            boolean isHorz = randPlacement.nextBoolean(); // randomly decide direction
            int startRow = randPlacement.nextInt(isHorz ? gridSize : gridSize - placeWord.length());
            int startCol = randPlacement.nextInt(isHorz ? gridSize - placeWord.length() : gridSize);
            
            if (canPlaceWord(grid, placeWord, startRow, startCol, isHorz)) {
                placeWordInGrid(grid, placeWord, startRow, startCol, isHorz);
            }
        } //end of for loop 
        postChoiceMenu();
}   // end Method to ask for, accept and validate users words.
      
//post choice Menu
public static void postChoiceMenu() {
        boolean sameMenu = true;

        while (sameMenu) {
    System.out.println("Thank you for your choice!  Now do you want to see:");
    System.out.println("1. The puzzle without the answers.");
    System.out.println("2. The puzzle with solution.");  
    System.out.println("3. Go back to main menu");
    System.out.print("Your viewing choice: ");
    Scanner wordSc = new Scanner(System.in);
    int puzzle = wordSc.nextInt();
    wordSc.nextLine(); // Clear the buffer

    switch (puzzle) {
        case 1: 
            randChars ();  // fill grid around words with random letters.
            printSolution();
            break;
        case 2:
            printSolution();
            break;
        case 3: 
            sameMenu = false;
            firstMenu();
            break;
        default:
            System.out.println("Please choose either 1 or 2 or 3.");
    } // end switch
    } // end while 
} // end postChoiceMenu Method
 

public static void firstMenu() {
    intro();
    
    boolean menuLoop = true;

    do  {
        try {
        System.out.print("Your choice: "); 
        int choiceMenu = wordSc.nextInt(); 
        wordSc.nextLine(); // added to clear a leftover new line

            switch (choiceMenu) {
                case 1:
                    clearGrid();
                    enterWords(); // starts the user-created wordsearch
                    break;
                case 2:
                    System.out.println("Flowers");
                    puzzleFile ("flowers.txt");
                    break;
                case 3:
                    System.out.println("Vegetables");
                    puzzleFile ("vegetables.txt");
                    break;
                case 4:
                    System.out.println("Animals");
                    puzzleFile ("animals.txt");
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
}

public static void intro() {// Introductory Text
    System.out.println("\u001B[1m \tWelcome to Java Wordsearch! \033[0m");
    System.out.println("You can choose to enter your own word list or choose from a few pre-populated vocab lists - Have Fun!");
    System.out.println("1: Your own words");
    System.out.println("2: Flowers");
    System.out.println("3. Vegetables");
    System.out.println("4: Animals");
    System.out.println("5: Quit");
} // end of intro text

} // end of class