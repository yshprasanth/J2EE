package listIterator;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("1");
        aList.add("2");
        aList.add("3");
        aList.add("4");
        aList.add("java2s.com");

        ListIterator<String> listIterator = aList.listIterator();
        listIterator.next();
        listIterator.add("Added Element");
        listIterator.previous();
        listIterator.add("Added previous");
        listIterator.previous();
        listIterator.set("wow");
        for (String str: aList){
            System.out.println(str);
        }
    }
}
