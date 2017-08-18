package arrays;

public class RotateArray {

    public static void main(String1[] args) {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        rotate.leftRotate(arr, 4, 12);
        rotate.printArray(arr);
    }

    private void leftRotate(int[] arr, int numToRotate, int size) { // 3, 12
        int i, j, k, temp;
        int gcd = gcd(size, numToRotate);
        for(i=0; i<gcd; i++) {
            temp = arr[i]; //0, 1
            j = i; // 0, 1
            while (true) {
                k = j + numToRotate; // 3, 6, 9, 12; 4
                if(k>=size)  // false, false, false, true
                    k = k - size; // 0
                if(k == i)  // false, false, false, true
                    break;

                arr[j] = arr[k]; // 0 will be replaced with 3, 3 with 6, 6 with 9;
                j = k; // 3, 6, 9
            }
            arr[j] = temp; // 9 will be replaced with 0
        }
    }

    private int gcd(int maxNum, int minNum) {
        if(minNum==0)
            return maxNum;
        else
            return gcd(minNum, maxNum % minNum);
    }

    private void printArray(int[] arr){
        int size = arr.length;
        System.out.print("arr[" + size + "]: " );
        for(int i=0; i<size; i++)
            System.out.print(arr[i] + " ");
    }
}
