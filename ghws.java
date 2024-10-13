import java.util.Random;

public class ghws {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final char EMPTY_CELL = '-';
    private static final char[][] grid = new char[ROWS][COLS];
    private static final Random random = new Random();

    public static void main(String[] args) {
        initializeGrid();
        printGrid();

        String[] words = { "JAVA", "PYTHON", "C#", "HTML", "CSS", "RUBY" };
        for (String word : words) {
            if (placeWord(word)) {
                System.out.println("Word \"" + word + "\" placed successfully!");
            } else {
                System.out.println("Cannot place word \"" + word + "\" in the grid!");
            }
        }

        printGrid();
    }

    private static void initializeGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean placeWord(String word) {
        int length = word.length();

        // Generate random start position
        int startRow = random.nextInt(ROWS);
        int startCol = random.nextInt(COLS);

        // Generate random direction
        int direction = random.nextInt(8); // 0 to 7 (8 directions)

        // Check if the word can be placed in the grid
        int endRow = startRow;
        int endCol = startCol;
        for (int i = 0; i < length; i++) {
            if (endRow < 0 || endRow >= ROWS || endCol < 0 || endCol >= COLS || grid[endRow][endCol] != EMPTY_CELL) {
                return false; // Cannot place word
            }

            switch (direction) {
                case 0: // Up
                    endRow--;
                    break;
                case 1: // Up-right
                    endRow--;
                    endCol++;
                    break;
                case 2: // Right
                    endCol++;
                    break;
                case 3: // Down-right
                    endRow++;
                    endCol++;
                    break;
                case 4: // Down
                    endRow++;
                    break;
                case 5: // Down-left
                    endRow++;
                    endCol--;
                    break;
                case 6: // Left
                    endCol--;
                    break;
                case 7: // Up-left
                    endRow--;
                    endCol--;
                    break;
            }
        }

        // Place the word in the grid
        endRow = startRow;
        endCol = startCol;
        for (int i = 0; i < length; i++) {
            grid[endRow][endCol] = word.charAt(i);

            switch (direction) {
                case 0: // Up
                    endRow--;
                    break;
                case 1: // Up-right
                    endRow--;
                    endCol++;
                    break;
                case 2: // Right
                    endCol++;
                    break;
                case 3: // Down-right
                    endRow++;
                    endCol++;
                    break;
                case 4: // Down
                    endRow++;
                    break;
                case 5: // Down-left
                    endRow++;
                    endCol--;
                    break;
                case 6: // Left
                    endCol--;
                    break;
                case 7: // Up-left
                    endRow--;
                    endCol--;
                    break;
            }
        }

        return true; // Word placed successfully
    }
}
