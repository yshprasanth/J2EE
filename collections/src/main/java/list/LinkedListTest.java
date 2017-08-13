package list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String args[]) {

        List<Character> ll = new LinkedList<Character>();

        for (char n = 'A'; n <= 'F'; n++)
            ll.add(n);

        System.out.println("Original:" + ll);

        Collections.reverse(ll);
        System.out.println("Reverse:" + ll);

        Collections.rotate(ll, 2);
        System.out.println("Rotate by 2:" + ll);

        Collections.shuffle(ll);
        System.out.println("Shuffle:" + ll);
    }
}
