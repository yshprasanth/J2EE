package core;

public class OverrideTest {

    public static void main(String[] args) {
        foo("hello");

        long longWithL = 1000*60*60*24*365L;
        long longWithoutL = 1000*60*60*24*365;
        System.out.println(longWithL);
        System.out.println(longWithoutL);
    }
    public static void foo(Object o) {
        System.out.println("Object impl");
    }
    public static void foo(String s) {
        System.out.println("String impl");
    }
    public static void foo(StringBuffer sb) {
        System.out.println("String impl");
    }
}
