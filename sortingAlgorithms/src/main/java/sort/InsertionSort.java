package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = new int[] { 2, 6, 3, 8, 4, 9, 1 };
        for (int i : intArray) {
            System.out.print(i);
        }
        System.out.println();
        insertionSort(intArray);

        for (int i : intArray) {
            System.out.print(i);
        }

    }

    public static void insertionSort(int[] intArray) {
        int in, out;

        for (out = 1; out < intArray.length; out++) {
            int temp = intArray[out];
            in = out;
            while (in > 0 && intArray[in - 1] >= temp) {
                intArray[in] = intArray[in - 1];
                --in;
            }
            intArray[in] = temp;
        }
    }
}
