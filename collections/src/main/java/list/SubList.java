package list;

import java.util.ArrayList;
import java.util.List;

public class SubList {

    public static void main(String[] args) {
            ArrayList<String> arrayList = new ArrayList<String>();

            arrayList.add("1");
            arrayList.add("2");
            arrayList.add("3");
            arrayList.add("4");
            arrayList.add("5");

            List lst = arrayList.subList(1, 3);
            for (int i = 0; i < lst.size(); i++)
                System.out.println(lst.get(i));
            System.out.println("Size: " + lst.size() + ", " + arrayList.size());

            // remove one element from sub list
            Object obj = lst.remove(0);
            System.out.println(obj + " is removed, " + lst.size() + ", " + arrayList.size());

            for (String str: arrayList)
                System.out.println(str);
    }
}
