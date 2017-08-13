package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListTest {
    public static void main(String[] a) {

        ArrayList list = new ArrayList();

        list.add("A");
        list.add("B");
        list.add("C");

        list.ensureCapacity(2);
        list.trimToSize();
        System.out.println("List: " + list.toString());

        List<Integer> values = Arrays.asList( 5, 0, 0, 2 );
        int occurrences = Collections.frequency(values, 0);
        System.out.println("occurrences of zero is " + occurrences);

        occurrences = Collections.frequency(values, 5);
        System.out.println("occurrences of 5 is " + occurrences);


    }
}
