package sort;

public class BubbleSort {

    public static void main(String[] args) {
        String arr[] = { "ABCD", "XYZ", "DEF", "PQR" };
        BubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void BubbleSort(String[] array) {
        String t;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }
}
