public class PhonebookManager {
    private ListNode head;

    // Add an entry to the end of the list
    public void addEntry(String name, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(name, address, city, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        sortList(); // Sort list alphabetically by last name after adding
    }

    // Sort the list alphabetically by last name
    private void sortList() {
        if (head == null || head.next == null) return;

        ListNode current, index;
        String tempName, tempAddress, tempCity, tempPhone;

        for (current = head; current.next != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                String currentLastName = current.name.split(" ")[1]; // Assuming "First Last"
                String indexLastName = index.name.split(" ")[1];

                if (currentLastName.compareTo(indexLastName) > 0) {
                    // Swap details
                    tempName = current.name;
                    tempAddress = current.address;
                    tempCity = current.city;
                    tempPhone = current.phoneNumber;

                    current.name = index.name;
                    current.address = index.address;
                    current.city = index.city;
                    current.phoneNumber = index.phoneNumber;

                    index.name = tempName;
                    index.address = tempAddress;
                    index.city = tempCity;
                    index.phoneNumber = tempPhone;
                }
            }
        }
    }

    // Modify an entry (based on name)
    public void modifyEntry(String oldName, String newName, String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = head;
        while (current != null) {
            if (current.name.equals(oldName)) {
                current.name = newName;
                current.address = newAddress;
                current.city = newCity;
                current.phoneNumber = newPhoneNumber;
                return;
            }
            current = current.next;
        }
        System.out.println("Entry not found!");
    }

    // Delete an entry (based on name)
    public void deleteEntry(String name) {
        if (head == null) return;

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Entry not found!");
    }

    // Print the phonebook list
    public void printList() {
        ListNode current = head;
        if (current == null) {
            System.out.println("Phonebook is empty.");
            return;
        }
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}
