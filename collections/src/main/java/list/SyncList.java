package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SyncList {

    public static void main(String[] args) throws InterruptedException {
        runTest();
    }
    private static void runTest() throws InterruptedException {
        List<String> syncList = Collections.synchronizedList(new ArrayList<String>(1));
        List<String> list = Arrays.asList("A", "B", "C", "D");
        List<Thread> threads = new ArrayList<Thread>();

        for (final String s : list) {
            Thread thread = new Thread(() -> {System.out.println("Thread: " + Thread.currentThread());syncList.add(s);});
            thread.setName(s);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println(syncList);
    }
}
