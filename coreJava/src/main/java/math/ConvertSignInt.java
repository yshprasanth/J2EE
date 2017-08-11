package math;

public class ConvertSignInt {
    public static void main(String[] args) {
        int iPositive = 15;

        int iNegative = ~iPositive;
        System.out.println(iNegative);

        iPositive = ~(iNegative - 1);
        System.out.println(iPositive);

        iNegative = 0;
        iPositive = ~(iNegative );
        System.out.println(iPositive);
    }
}
