package map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        Map<String, String> oldMap = new HashMap<String, String>();
        oldMap.put("a", "1");
        oldMap.put("A", "2");

        Map<String, String> newMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        newMap.putAll(oldMap);
        String value = newMap.get("a");
        System.out.println("size: " + newMap.size() + ", a=" + value);

    }
}
