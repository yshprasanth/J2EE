package arrays;

public class RotateAndMax {

    public static void main(String1[] args) {
        RotateAndMax rotate = new RotateAndMax();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        rotate.leftRotate(arr, 4, 12);
        rotate.printArray(arr);

        int rotateArr[] = {0, 1, 4, 20};
        rotate.printArray(rotateArr);
        int[] indicesArr = rotate.findMaxIndices(arr, rotateArr);
        rotate.printArray(indicesArr);
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;

        for(int i=1; i<arr.length; i++) {
            if(arr[i]>max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }



    public int[] findMaxIndices(int[] arr, int[] rotation) {
        int rotationSize = rotation.length;
        int arraySize = arr.length;
        int[] indicesArr = new int[rotationSize];

        int maxIndex = findMax(arr);
        for(int i=0; i<rotationSize; i++) {
            int currentRotation = rotation[i] % arraySize;
            if(maxIndex-currentRotation<0)
                indicesArr[i] = maxIndex-currentRotation+arraySize;
            else
                indicesArr[i] = maxIndex-currentRotation;
        }
        return indicesArr;
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
