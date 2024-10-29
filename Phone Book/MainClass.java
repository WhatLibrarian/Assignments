import java.util.Scanner;
import java.util.LinkedList;
// Would rather not use collections!  From Darrell.
//Extra credit: Case-switch, Try/Catch, private.
//Future extra Credit: enums, packages
// OBJECT FILE: TestClass

class PhonebookManager {  // METHODS CLASS
    private TestClass head = null; // create a NULL head to start a new phonebook
    Scanner sc = new Scanner(System.in);  // keeping data private.
   

    private TestClass addNode (TestClass head, String name, String addy, String city, String phNum){
        TestClass newNode = new TestClass(name, addy, city, phNum);
        if (head == null) {  //return this new node as head if empty.
            return newNode;
        } else {
            TestClass current = head;
            while (current.next !=null) {
                current = current.next;
            }
            current.next = newNode; // links the new node to end of list
            return head; 
        }
    }

    public void showMenu() {
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println ("\nPhonebook Menu, please select from one of the following options:");
            System.out.println ("1: Add and entry.");
            System.out.println ("2: Sort the Entries Alphabetically.");  // EXTRA CREDIT
            System.out.println ("3: Modify an Entry.");
            System.out.println ("4: Delete the first entry.");
            System.out.println ("5: Print the whole phonebook.");
            System.out.println ("6: Quit.");
            System.out.print ("Please choose between 1 and 6: ");
    
            //int menu = sc.nextInt();
            //sc.nextLine();

            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 6) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }
    
            switch (choice) {
                case 1: 
                addEntry();
                showMenu();
                break;
    
                case 2: //Sorting;   // Bonus points!
                break;
    
               case 3: //Modify;
                 //System.out.println(phNode);
                showMenu();
                break;
    
                case 4: //Delete;
                delEntry();
                showMenu();
                break;
    
                case 5: //Print;
                printPhonebook();
                showMenu();
                break;
    
                case 6: //Quit;
                System.out.println("Thank you Goodbye!");
                System.exit(0);
                break;
    
                default: 
                    System.out.println("\nOops, entry error.  Please try again to enter a number between 1 and 6.");
    
    
            } // end of Switch/Case
        } // end of While
      // end of showMenu class


    public void addEntry() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String addy = sc.nextLine();
        System.out.print("Enter city: ");
        String city = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phNum = sc.nextLine();
        head = addNode(head, name, addy, city, phNum);
        System.out.println("\n*********Entry added successfully.*********\n");
    }  //end of AddEntry 
    

    public void printPhonebook() {
        if (head == null) {
            System.out.println("The phonebook is empty.");
            return;
        }
        TestClass current = head;
        while (current != null) {
            System.out.println(current.fullListing());
            current = current.next;
        }
    }


        public void delEntry() {
            if (head == null) {
                System.out.println("The phonebook is already empty.");
                return;
            }
            head = head.next;  // Set head to the next node, effectively deleting the first node
            System.out.println("*********Successfully deleted the first entry!*********");
        }

    //public void modifyEntry(){
       // LinkedList<Object> phNode = new LinkedList<Object>();
      //  phNode.add(TestClass);
   // }

} //end of PhonebookManager CLASS!!


/*public void modifyEntry() {
    if (head == null) {
        System.out.println("The phonebook is empty. No entry to modify.");
        return;
    }

    System.out.print("Enter the name of the entry to modify: ");
    String searchName = sc.nextLine();
    TestClass current = head;
    boolean found = false;

    while (current != null) {
        if (current.name.equalsIgnoreCase(searchName)) {
            found = true;
            System.out.println("Entry found. Enter new details.");
            System.out.print("Enter new address: ");
            current.addy = sc.nextLine();
            System.out.print("Enter new city: ");
            current.city = sc.nextLine();
            System.out.print("Enter new phone number: ");
            current.phNum = sc.nextLine();
            System.out.println("Entry updated successfully.");
            break;
        }
        current = current.next;
    }

    if (!found) {
        System.out.println("No entry with that name found.");
    }
} */


// MAIN MAIN

public class MainClass {
    public static void main(String[]args) {
       PhonebookManager manager = new PhonebookManager();
       manager.showMenu();
    } // end of MAIN class
} // end of MAIN class