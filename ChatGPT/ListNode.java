public class ListNode {
    String name;
    String address;
    String city;
    String phoneNumber;
    ListNode next;

    public ListNode(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    public String toString() {
        return String.format("Name: %s, Address: %s, City: %s, Phone Number: %s", name, address, city, phoneNumber);
    }
    
}
