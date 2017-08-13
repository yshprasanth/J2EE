package queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String args[]) {
        PriorityQueue<Integer> p = new NoDuplicates<Integer>();
        p.add(1);
        p.add(2);
        p.add(1);
        System.out.println(p);

        for (int i = 0; i <= 2; i++) {
            System.out.println(p.peek() + ";" + p.add(i) + ";" + p.size());
            p.add(i);
        }

        System.out.println(p);

        int size = p.size();
        for (int i = 0; i <= size; i++) {
            System.out.println(p.poll() + ";" + p.peek());
        }
        System.out.println(p);

        p = new PriorityQueue<>();
        p.add(1);
        p.add(2);
        p.add(1);
        System.out.println(p);

        for (int i = 0; i <= 2; i++) {
            System.out.println(p.peek() + ";" + p.add(i) + ";" + p.size());
            p.add(i);
        }
        System.out.println(p);
    }

    private static class NoDuplicates<T> extends PriorityQueue<T> {
        @Override
        public boolean add(T t) {
            boolean isAdded = false;
            if (!super.contains(t)) {
                isAdded = super.add(t);
            }
            return isAdded;
        }
    }
}
