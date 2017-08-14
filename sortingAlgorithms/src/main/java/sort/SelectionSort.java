package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = new int[]{2, 6, 3, 8, 4, 9, 1};

        for (int i : intArray) {
            System.out.print(i);
        }
        System.out.println();
        selectionSort(intArray);

        for (int i : intArray) {
            System.out.print(i);
        }

    }

    public static void selectionSort(int[] intArray) {
        for (int out = 0; out < intArray.length - 1; out++) {
            int min = out;
            for (int in = out + 1; in < intArray.length; in++)
                if (intArray[in] < intArray[min])
                    min = in;
            swap(intArray, out, min);
        }
    }

    private static void swap(int[] intArray, int one, int two) {
        int temp = intArray[one];
        intArray[one] = intArray[two];
        intArray[two] = temp;
    }
}
