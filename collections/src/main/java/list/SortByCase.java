package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByCase {

    public static void main(String[] argv) throws Exception {
        String[] strArray = new String[] { "z", "a", "Java2s.com" };
        List list = Arrays.asList(strArray);

        System.out.println("original list: " + list);

        Collections.sort(list);
        System.out.println("default sort, list: " + list);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("case insensitive sort, list: " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("reverse sort, list: " + list);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("case insensitive sort, list: " + list);

        Collections.reverse(list);
        System.out.println("reverse of list: " + list);
    }
}
