package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListPerf {

    public static void main(String... args) {
        final int MAX_VAL = 999;
        List<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < MAX_VAL; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
        long time = System.nanoTime();

        for (int i = 0; i < MAX_VAL; i++) {
            linkedList.add(MAX_VAL / 2, i);
        }
        System.out.println("LinkedList add:" + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < MAX_VAL; i++) {
            arrayList.add(MAX_VAL / 2, i);
        }
        System.out.println("ArrayList add:" + (System.nanoTime() - time));

        // Reset the lists
        linkedList = new LinkedList<Integer>();
        arrayList = new ArrayList<Integer>();
        for (int i = 0; i < MAX_VAL; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        time = System.nanoTime();
        ListIterator<Integer> li = linkedList.listIterator(MAX_VAL / 2);
        for (int i = 0; i < MAX_VAL; i++) {
            li.add(i);
        }
        System.out.println("LinkedList iterator add:" + (System.nanoTime() - time));

        time = System.nanoTime();
        ListIterator<Integer> ali = arrayList.listIterator(MAX_VAL / 2);
        for (int i = 0; i < MAX_VAL; i++) {
            ali.add(i);
        }
        System.out.println("ArrayList iterator add:" + (System.nanoTime() - time));
    }
}
