package sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };

        for (int i : intArray) {
            System.out.println(i);
        }

        shellSort(intArray);
        System.out.println("after: ");
        for (int i : intArray) {
            System.out.println(i);
        }
    }

    public static void shellSort(int[] intArray) {
        int inner, outer;
        int temp;

        int h = 1;
        while (h <= intArray.length / 3){
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < intArray.length; outer++) {
                temp = intArray[outer];
                inner = outer;

                while (inner > h - 1 && intArray[inner - h] >= temp) {
                    intArray[inner] = intArray[inner - h];
                    inner -= h;
                }
                intArray[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}