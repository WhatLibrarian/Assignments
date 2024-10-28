import java.util.Scanner;

public class TestClass {
  
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            PhonebookManager phonebook = new PhonebookManager();
    
            while (true) {
                System.out.println("\nPhonebook Menu:");
                System.out.println("1. Add Entry");
                System.out.println("2. Modify Entry");
                System.out.println("3. Delete Entry");
                System.out.println("4. Print Phonebook");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter City: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        phonebook.addEntry(name, address, city, phoneNumber);
                        break;
    
                    case 2:
                        System.out.print("Enter the Name of the entry to modify: ");
                        String oldName = scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Address: ");
                        String newAddress = scanner.nextLine();
                        System.out.print("Enter New City: ");
                        String newCity = scanner.nextLine();
                        System.out.print("Enter New Phone Number: ");
                        String newPhone = scanner.nextLine();
                        phonebook.modifyEntry(oldName, newName, newAddress, newCity, newPhone);
                        break;
    
                    case 3:
                        System.out.print("Enter the Name of the entry to delete: ");
                        String delName = scanner.nextLine();
                        phonebook.deleteEntry(delName);
                        break;
    
                    case 4:
                        phonebook.printList();
                        break;
    
                    case 5:
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    

}
