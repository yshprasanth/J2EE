package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetTest {

    public static void main(String[] args) {
        List<String> arrayList1 = new ArrayList<String>();

        arrayList1.add("A");
        arrayList1.add("A");
        arrayList1.add("B");
        arrayList1.add("B");
        arrayList1.add("B");
        arrayList1.add("C");

        HashSet<String> hashSet = new HashSet<String>(arrayList1);

        for (Object item : hashSet)
            System.out.println(item);

        List<String> arrayList2 = new ArrayList<String>(hashSet);

        for (Object item : arrayList2)
            System.out.println(item);

    }
}
