// 4.Write a Java program to display elements and their positions in a linked list ( using l_listobj.get(p) )

package basic;
import java.util.*;
public class Linked4 {
    public static void main(String[] args) {
        LinkedList<String> l_listobj = new LinkedList<>();
        // Adding elements
        l_listobj.add("Orange");
        l_listobj.add("Green");
        l_listobj.add("Pink");
        l_listobj.add("Red");
        l_listobj.add("Blue");
        System.out.println("Elements with their positions are ");
        // Display elements with index
        for (int p = 0; p < l_listobj.size(); p++) {
            System.out.println("Index " + p + " : " + l_listobj.get(p));
        }
    }
}
