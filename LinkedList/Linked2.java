// 2. Write a Java program to iterate a linked list in reverse order (using objlist.descendingIterator())

package basic;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
public class Linked2 {
	    public static void main(String[] args) {
	        LinkedList<String> objlist = new LinkedList<>();
	        // Adding elements
	        objlist.add("Orange");
	        objlist.add("Green");
	        objlist.add("Pink");
	        objlist.add("Red");
	        objlist.add("Blue");
	        // Using descendingIterator()
	        Iterator<String> iterator = objlist.descendingIterator();
	        // Printing in reverse order
	        System.out.println("LinkedList in reverse order:");
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	    }
	}
