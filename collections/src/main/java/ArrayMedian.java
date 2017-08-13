import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class ArrayMedian {

    public static void main(String[] args) {
        int[][] array2d = { { 21, 14, 13, 12, 15 }, { 4, 25, 23, 22, 9 },
                { 4, 7, 8, 98, 24 } };
        int[] list = new int[array2d.length * array2d[0].length];

        int[] result = Stream.of(array2d)
                        .flatMapToInt(IntStream::of)
                        .toArray();

        System.out.println("result: " + Arrays.toString(result));

        int listPos = 0;
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d.length; j++) {
                list[listPos++] = array2d[i][j];
            }
        }
        sort(list);
        System.out.println(median(list));
    }

    public static double median(int[] m) {
        int middle = m.length / 2;
        if (m.length % 2 == 1) {
            return m[middle];
        } else {
            return (m[middle - 1] + m[middle]) / 2.0;
        }
    }
}
