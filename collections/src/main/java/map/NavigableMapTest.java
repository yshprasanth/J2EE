package map;

import java.util.*;

public class NavigableMapTest {

    public static void main(String args[]) {
        Calendar now = Calendar.getInstance();
        Locale locale = Locale.getDefault();

        Map<String, Integer> names = now.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
        NavigableMap<String, Integer> nav = new TreeMap<String, Integer>(names);
        System.out.printf("Whole list:%n%s%n", nav);
        System.out.printf("Key lower before Sunday: %s%n", nav.lowerKey("Sunday"));
        System.out.printf("Key lower before Saturday: %s%n", nav.lowerKey("Saturday"));
        System.out.printf("Key lower before Friday: %s%n", nav.lowerKey("Friday"));

        System.out.printf("Whole list:%n%s%n", nav);
    }
}
