# Bonus Point
* Validation on user input.  Small main method. 
* Bolded text in title.
* Read from file a list of words then create a wordsearch without duplicating methods.

## The following websites were useful for conceptualization
* https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
* https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
* https://gist.github.com/R3DHULK/b21adcd7bd8904507023880f80934ca0
* https://www.baeldung.com/java-character-ascii-value
* https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

### Chat GPT HELP Documented.
* Overlapping on vowels: https://chatgpt.com/share/6715670a-7e34-8001-8dc5-3e2fc1c42fe5

#### Narrative
I had to ask chatgpt for some help on a chunk of code.  I had this piece which was duplicating functionality (canPlace was being defined more than once).  I knew this was not efficient and following the first rule of programming (be lazy!) I decided to ask the Hallucinator in Chief to see if it could help.

I prompted it by asking "Can this piece of java code be made more efficient?"
And it turned it into this:

``` 
// Begin filling the grid with the user's words.

for (String placeWord : words) {
    boolean placed = false; // Validate word is not already placed

    while (!placed) { // Loop until the word is placed
        boolean isHorz = randPlacement.nextBoolean(); // Randomly decide direction
        int startRow, startCol;

        if (isHorz) {
            startRow = randPlacement.nextInt(gridSize);
            startCol = randPlacement.nextInt(gridSize - placeWord.length());
        } else {
            startRow = randPlacement.nextInt(gridSize - placeWord.length());
            startCol = randPlacement.nextInt(gridSize);
        }

        // Check if the word can be placed
        if (canPlaceWord(grid, placeWord, startRow, startCol, isHorz)) {
            placeWordInGrid(grid, placeWord, startRow, startCol, isHorz);
            placed = true; // Mark the word as placed
        }
    } // End of while loop
} // End of for loop

// Method to check if the word can be placed in the grid
private boolean canPlaceWord(char[][] grid, String word, int startRow, int startCol, boolean isHorz) {
    for (int i = 0; i < word.length(); i++) {
        char gridChar = isHorz ? grid[startRow][startCol + i] : grid[startRow + i][startCol];
        if (gridChar != '-' && gridChar != word.charAt(i)) {
            return false; // Cannot place the word
        }
    }
    return true; // Can place the word
}

// Method to place the word in the grid
private void placeWordInGrid(char[][] grid, String word, int startRow, int startCol, boolean isHorz) {
    for (int i = 0; i < word.length(); i++) {
        if (isHorz) {
            grid[startRow][startCol + i] = word.charAt(i);
        } else {
            grid[startRow + i][startCol] = word.charAt(i);
        }
    }
}
```