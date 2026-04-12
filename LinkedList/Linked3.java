// 3. Write a Java program to insert the specified element at the end of a linked list.( using l_listobj.offerLast("Pink"))
package basic;
import java.util.*;
import java.util.*;
public class Linked3 {
    public static void main(String[] args) {
        LinkedList<String> ls = new LinkedList<>();
        ls.add("Orange");
        ls.add("green");
        ls.add("pink");
        ls.add("red");
        ls.add("Blue");
        System.out.println("Before insertion: " + ls);
        // Insert element at end using offerLast()
        ls.offerLast("Pink");
        System.out.println("After insertion: " + ls);
    }
}
