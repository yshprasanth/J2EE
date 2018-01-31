package bits;

public class BinaryGap {

    public static void main(String[] args) {
        getBinaryGap(9);
        getBinaryGap(529);
        getBinaryGap(20);
        getBinaryGap(15);
        getBinaryGap(1041);
    }

    private static void getBinaryGap(int N) {
        String nBits = Integer.toBinaryString(N);
        int bitCount = Integer.bitCount(N);
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(N);
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(N);
        int highestOneBit = Integer.highestOneBit(N);
        int lowestOneBit = Integer.lowestOneBit(N);
        System.out.println(N + " - bits: " + nBits);
        System.out.println(N + " - bitCount: " + bitCount);
        System.out.println(N + " - numberOfLeadingZeros: " + numberOfLeadingZeros);
        System.out.println(N + " - numberOfTrailingZeros: " + numberOfTrailingZeros);
        System.out.println(N + " - highestOneBit: " + highestOneBit);
        System.out.println(N + " - lowestOneBit: " + lowestOneBit);
    }
}
