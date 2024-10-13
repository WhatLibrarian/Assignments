public class wordsearch {

        public static void main(String[] args) {
              int gridSize = 8; // Set the grid size to 8x8
    
            // Loop to print the grid
            for (int row = 0; row < gridSize; row++) {
                for (int col = 0; col < gridSize; col++) {
                    System.out.print("- "); // Print a dash with a space for spacing
                }
                System.out.println(); // Move to the next line after each row
            }
        }  

}