import java.util.Scanner;
// Would rather not use collections!  From Darrell.
//Extra credit: Case-switch, Package, private.
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

        while (true) {
            System.out.println ("\nPhonebook Menu, please select from one of the following options:");
            System.out.println ("1: Add and entry.");
            System.out.println ("2: Sort the Entries Alphabetically.");  // EXTRA CREDIT
            System.out.println ("3: Modify an Entry.");
            System.out.println ("4: Delete the first entry.");
            System.out.println ("5: Print the whole phonebook.");
            System.out.println ("6: Quit.");
            System.out.print ("Please choose between 1 and 6: ");
    
            int menu = sc.nextInt();
            sc.nextLine();
    
            switch (menu) {
                case 1: 
                addEntry();
                break;
    
                case 2: //Sorting; 
                break;
    
               case 3: //Modify;
                break;
    
                case 4: //Delete;
                delEntry();
                break;
    
                case 5: //Print;
                printPhonebook();
                break;
    
                case 6: //Quit;
                System.out.println("Thank you Goodbye!");
                System.exit(0);
                break;
    
                default: 
                    System.out.println("Oops, entry error.  Please try again to enter a number between 1 and 6.");
    
    
            } // end of Switch/Case
        } // end of While
    }  // end of showMenu class


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
        System.out.println("\n*********Entry added successfully.*********");
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

} //end of PhonebookManager CLASS!!



// MAIN MAIN

public class MainClass {
    public static void main(String[]args) {
       PhonebookManager manager = new PhonebookManager();
       manager.showMenu();
    } // end of MAIN class
} // end of MAIN class
