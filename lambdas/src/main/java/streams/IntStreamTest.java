package streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamTest {

    private static Object IntSupplier1;

    public static void main(String[] args){
        int[] arr =  {1, 2, 3, 4, 5};
        int sum1 = IntStream.of(arr).limit(3).sum();
        int sum2 = Arrays.stream(arr).limit(3).sum();
        int sum3 = Stream.of(arr).flatMapToInt(IntStream::of).limit(3).sum();

        System.out.println("Sums: " + sum1 + ", " + sum2 + ", " + sum3);

        IntStream.range(1, 10).average().ifPresent(System.out::println);

        IntStream.generate(() -> 2).limit(5).forEach(System.out::println);

        IntStream.iterate(1, n -> n * 2)
                .limit(11)
                .forEach(System.out::println);
    }
}
