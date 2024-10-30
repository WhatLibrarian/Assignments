public class ObjectClass { // OBJECT CLASS

    String name;
    String addy;
    String city;
    String phNum;
    ObjectClass next; /// Creates reference to next node in linkedList. From class 10/25

    public ObjectClass(String name, String addy, String city, String phNum) { // this is a contstructor
        this.name = name;
        this.addy = addy;
        this.city = city;
        this.phNum = phNum;
        this.next = null; // initializes it as null.
    }

    public String fullListing() { // from class on 10/25
        // return String.format("Name: %s, Adress: %s, City: %s, Phone Number: %s",
        // name, addy, city, phNum);
        return String.format("%s \t%s \t%s \t%s", name, addy, city, phNum);
    }
} // END OF OBJECT CLASS