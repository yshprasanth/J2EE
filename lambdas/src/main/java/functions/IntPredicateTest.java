package functions;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntPredicateTest {

    public static void main(String[] args) {
        System.out.println("201 IsPrime: " + isPrime(3));
        IntStream.range(1,20).forEach(IntPredicateTest::isPrime);
    }

    private static boolean isPrime(int number) {
        IntPredicate isDivisible = index -> number % index == 0;

        boolean returnVal = number==1 || (number>1 && IntStream.rangeClosed(2, number/2).noneMatch(isDivisible));

        System.out.println(number + " is prime? " + returnVal);
        return  returnVal;
    }
}
