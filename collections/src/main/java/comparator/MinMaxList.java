package comparator;

import java.util.*;

public class MinMaxList {
    public static void main(String args[]) {
        String str[] = { "B", "H", "L", "M", "R", "1" };
        List list = Arrays.asList(str);
        System.out.println("Min:" + Collections.min(list));
        System.out.println("Max:" + Collections.max(list));
        Collections.sort(list);
        System.out.println("List:" + list );

        Comparator comp = Collections.reverseOrder();
        System.out.println("Reverse Min:" + Collections.min(list, comp));
        System.out.println("Reverse Max:" + Collections.max(list, comp));
        Collections.sort(list, comp);
        System.out.println("Reverse List:" + list );

        Collections.shuffle(list);
        System.out.println("Shuffle List:" + list );

        Collection collection = Collections.checkedCollection(list, Integer.class);
        System.out.println("Checked collection:" + collection );
    }
}
