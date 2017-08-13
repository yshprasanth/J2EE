package callable;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class InitHashMap {
    public static void main(String[] args) throws Exception {

        HashMap<Integer, Callable<String>> m = new HashMap<Integer, Callable<String>>() {
            {
                put(0, () -> {
                    System.out.println("setting 0");
                    return "n";
                });
                put(1, () -> {
                    System.out.println("setting 1");
                    return "m";
                });
            }
        };
        System.out.println(m.get(0));
    }

}
