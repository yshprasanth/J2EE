package map;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Size, String> sizeMap = new EnumMap<Size, String>(Size.class);
        sizeMap.put(Size.S, "S");
        sizeMap.put(Size.M, "M");
        sizeMap.put(Size.L, "L");
        sizeMap.put(Size.XL, "XL");
        sizeMap.put(Size.XXL, "XXL");
        sizeMap.put(Size.XXXL, "XXXL");

        for (Size size : Size.values()) {
            System.out.println(size + ":" + sizeMap.get(size));
        }

        EnumSet largeSize = EnumSet.of(Size.XL,Size.XL,Size.XXL,Size.XXXL);

        for(Iterator it = largeSize.iterator(); it.hasNext();){
            Size size = (Size)it.next();
            System.out.println(size);
        }

        EnumSet set = EnumSet.allOf(Size.class);
        set.add(Size.S);

    }
}

enum Size{
    XS, S, M, L, XL, XXL, XXXL;
}