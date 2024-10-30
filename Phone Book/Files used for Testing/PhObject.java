public class PhObject {
    String name;
    String addy;
    String city;
    String phNum; 
    PhObject next; //used to stop entries


    public PhObject (String name, String addy, String city, String phNum) {
        this.name = name;
        this.addy = addy;
        this.city = city;
        this.phNum = phNum;
        this.next = null; //initializes a null
    } //end of PhBook

}  // end of class PhObject

// This was copied from slide displayed in class on 10/25/24