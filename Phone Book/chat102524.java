/*
  
import java.util.Scanner;

public class TestClass {  //MAIN

    String name; 
    String addy;
    String city;
    String phNum;
    TestClass next; // Creates reference to next node in linkedList 

    public TestClass(String name, String addy, String city, String phNum) {  //constructor
        this.name = name;
        this.addy = addy;
        this.city = city;
        this.phNum = phNum;
        this.next = null;  // initializes it as null. 
    }

    public String fullListing() {
        return String.format("Name: %s, Address: %s, City: %s, Phone Number: %s", name, addy, city, phNum);
    }

    // Method to add a new entry to the linked list
    public static TestClass addEntry(TestClass head, String name, String addy, String city, String phNum) {
        TestClass newNode = new TestClass(name, addy, city, phNum);
        if (head == null) {
            return newNode; // If the list is empty, return the new node as the head
        } else {
            TestClass current = head;
            while (current.next != null) { // Traverse to the end of the list
                current = current.next;
            }
            current.next = newNode; // Link the new node to the end of the list
            return head;
        }
    }

    // Method to print the entire phonebook
    public static void printPhonebook(TestClass head) {
        TestClass current = head;
        while (current != null) {
            System.out.println(current.fullListing());
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TestClass head = null; // Start with an empty list

        while (true) {
            System.out.println("Phonebook Menu, please select from one of the following options:");
            System.out.println("1: Add an entry.");
            System.out.println("2: Sort the Entries Alphabetically."); // Not implemented yet
            System.out.println("3: Modify an Entry."); // Not implemented yet
            System.out.println("4: Delete an Entry."); // Not implemented yet
            System.out.println("5: Print the whole phonebook.");
            System.out.println("6: Quit.");

            System.out.print("Please choose between 1 and 6: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1: // Add an entry
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter address: ");
                    String addy = sc.nextLine();
                    System.out.print("Enter city: ");
                    String city = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phNum = sc.nextLine();
                    head = addEntry(head, name, addy, city, phNum);
                    System.out.println("Entry added successfully.");
                    break;

                case 5: // Print the phonebook
                    printPhonebook(head);
                    break;

                case 6: // Quit
                    System.out.println("Thank you! Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Oops, entry error. Please try again.");
            }
        }
    }
}

 */