package set;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<MyRange> set = new TreeSet<>();
        set.add(new MyRange(1, 0));
        set.add(new MyRange(2, 100));
        set.add(new MyRange(3, 500));
        set.add(new MyRange(4, 250));
        System.out.println(set.floor(new MyRange(50)));
        System.out.println(set.floor(new MyRange(300)));
        System.out.println(set.floor(new MyRange(600)));
        System.out.println(set.ceiling(new MyRange(500)));

        MyRange[] myRanges = (MyRange[]) set.toArray();
        myRanges = set.toArray(new MyRange[set.size()]);

    }
}

class MyRange implements Comparable<MyRange> {
    long limit;
    int id;

    public MyRange(int id, long credits) {
        this.id = id;
        this.limit = credits;
    }

    public MyRange(long credits) {
        this.id = -1;
        this.limit = credits;
    }

    @Override
    public int compareTo(MyRange o) {
        return limit < o.limit ? -1 : limit > o.limit ? 1 : 0;
    }

    @Override
    public String toString() {
        return "id:" + id + ", limit:" + limit;
    }
}