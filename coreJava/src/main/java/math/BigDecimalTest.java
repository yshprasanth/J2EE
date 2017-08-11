package math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest {

    public static void main(String[] args) {
        long base = 12345;
        int scale = 4;

        BigDecimal number = BigDecimal.valueOf(base, scale);
        System.out.println(number);
        BigDecimal pointRight = number.movePointRight(5);
        System.out.println(pointRight + "; my scale is " + pointRight.scale());
        BigDecimal scaleBy = number.scaleByPowerOfTen(5);
        System.out.println(scaleBy + "; my scale is " + scaleBy.scale());

        scaleBy = number.scaleByPowerOfTen(2);
        System.out.println(number + "; " + scaleBy + "; my scale is " + scaleBy.scale());

        BigDecimal pointLeft = number.movePointLeft(2);
        System.out.println(pointLeft + "; my scale is " + pointLeft.scale());

    }
}
