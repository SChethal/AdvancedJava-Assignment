//1. Write a Java program to iterate through all elements in a linked list starting at the specified position (2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))

package basic;
import java.util.*;
public class Linked1 {
    public static void main(String[] args) {
        LinkedList<String> listobj = new LinkedList<>();
        // Adding elements
        listobj.add("Orange");
        listobj.add("Green");
        listobj.add("Pink");
        listobj.add("Red");
        listobj.add("Blue");
        // Start iterator from 2nd position (index 1)
        Iterator<String> iteratorobj = listobj.listIterator(1);
        // Traverse from that position
        System.out.println("Elements from 2nd position:");
        while (iteratorobj.hasNext()) {
            System.out.println(iteratorobj.next());
        }
    }
}
