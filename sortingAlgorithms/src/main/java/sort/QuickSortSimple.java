package sort;

import java.util.Arrays;

public class QuickSortSimple {

    public static void main(String[] args) {
        int[] intArray = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
        for (int i : intArray) {
            System.out.print(" " + i);
        }
        System.out.println("\nAfter Quick Sort:");
        quickSort(intArray);
        for (int i : intArray) {
            System.out.print(" " + i);
        }
    }

    public static void quickSort(int[] intArray) {
        recQuickSort(intArray, 0, intArray.length - 1);
    }

    private static void recQuickSort(int[] intArray, int left, int right) {
        System.out.println("recQuickSort start: " + Arrays.toString(intArray) + ", " + left + ", " + right);
        if (right - left <= 0)
            return;
        else {
            int pivot = intArray[right];
            System.out.println("pivot: " + pivot);
            int partition = partitionIt(intArray, left, right, pivot);
            System.out.println("partition: " + partition);
            recQuickSort(intArray, left, partition - 1);
            recQuickSort(intArray, partition + 1, right);
        }
    }

    private static int partitionIt(int[] intArray, int left, int right, int pivot) {
        System.out.println("partitionIt start: " + Arrays.toString(intArray) + ", " + left + ", " + right);
        int leftPtr = left - 1;
        int rightPtr = right;
        System.out.println("before while: " + leftPtr + ", " + rightPtr);
        while (true) {
            while (intArray[++leftPtr] < pivot)
                ;
            System.out.println("after first inner while: " + leftPtr + ", " + rightPtr);

            while (rightPtr > 0 && intArray[--rightPtr] > pivot)
                ;
            System.out.println("after second inner while: " + leftPtr + ", " + rightPtr);

            if (leftPtr >= rightPtr)
                break;
            else
                swap(intArray, leftPtr, rightPtr);
        }
        System.out.println("after while: " + leftPtr + ", " + rightPtr + ", " + right);
        swap(intArray, leftPtr, right);

        return leftPtr;
    }

    private static void swap(int[] intArray, int dex1, int dex2) {
        System.out.println("before swapping: " + Arrays.toString(intArray) + ", " + dex1 + ", " + dex2);
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
        System.out.println("after swapping: " + Arrays.toString(intArray) + ", " + dex1 + ", " + dex2);
    }
}
