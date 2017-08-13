package search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListSearch {

    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("c");

        Collections.sort(list);
        System.out.println(list);
        int index = Collections.binarySearch(list, "c");
        if (index > 0) {
            System.out.println("Found at index = " + index);
            String month = (String) list.get(index);
            System.out.println(month);
        }
    }
}
