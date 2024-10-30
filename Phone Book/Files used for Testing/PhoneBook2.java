import java.util.*;

public class PhoneBook2 {
    public static void main(String[] args) {

    List<String> entryString = new ArrayList<>();
    entryString.add("red");
    entryString.add("blue");
    entryString.add("orange");
    entryString.add("purple");
    entryString.add("green");
    
    System.out.println("A list of colors:");
    System.out.println(entryString);

    LinkedList<String> phoneB = new LinkedList<String>();
    phoneB.add ("orange");
    phoneB.add ("blue");
    phoneB.add ("green");

    System.out.println("A list of linked colors:");
    System.out.println(phoneB);

    // phoneB.remove(); // removes from front

    System.out.println("A middle color");
    System.out.println(phoneB.get(2));

   // Iterator it = phoneB.iterator(); // https://www.youtube.com/watch?v=YQQio9BGWgs
    //while (it.hasNext() ) {
     //   if(it.next() == "blue")
      //  System.out.println("We found blue");
    //}

    LinkedList<String> addy = new LinkedList<String>();
    addy.add("123 Fake St.");
    addy.add("125 Fake St.");
    addy.push("A"); //pushes to front
    addy.push("B");
    addy.push("C");
    addy.push("D");
    addy.push("F");
    //addy.pop(); //deletes head
    //queues
    addy.offer("A"); //pushes to front
    addy.offer("B");
    addy.offer("C");
    addy.offer("D");
    addy.offer("F");
    //addy.poll(); // deletes head of queue

    addy.add(4, "E");  //pick an index spot
    addy.remove("C");  // just removes the first one it runs accross

    System.out.println(addy);
    System.out.println(addy.indexOf("D"));  //finds first instance of
    

    }
}
