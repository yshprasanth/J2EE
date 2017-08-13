package printBoxText;// you can also use imports, for example:
import java.util.*;
import java.util.stream.*;
// you can write to stderr for debugging purposes, e.g.
// System.err.println("this is a debug message");

public class Solution {

    final static String CELL_BOUNDARY_SPLITTER="+";
    final static String CELL_BOUNDARY_VERTICAL="-";
    final static String CELL_BOUNDARY_HORIZONTAL="|";


    public void solution(int[] A, int K) {
        // write your code in Java SE 8
        //List<? extends Integer> list = IntStream.of(A).boxed().distinct().sorted().collect(Collectors.toList());
        //int maxNumber = list.get(list.size()-1);

        int maxNumber = IntStream.of(A).max().getAsInt();
        int maxSize = String.valueOf(maxNumber).length();

        System.out.println("maxNumber:" + maxNumber + "; maxSize: " + maxSize);

        String cellBoundary = getBoundaryStr(CELL_BOUNDARY_VERTICAL, maxSize);
        int arrLength = A.length;

        StringBuilder boundary = new StringBuilder(CELL_BOUNDARY_SPLITTER);
        StringBuilder contents = new StringBuilder(CELL_BOUNDARY_HORIZONTAL);

        for (int i = 0, cellCounter = 0; i<arrLength; i++) {
            //System.err.println(cellCounter + "," + i + "," + boundary + "," + contents);
            if (cellCounter<K) {
                boundary.append(cellBoundary)
                        .append(CELL_BOUNDARY_SPLITTER);

                contents.append(padLeft(A[i], maxSize))
                        .append(CELL_BOUNDARY_HORIZONTAL);
                cellCounter++;

            }
            //System.err.println("again[" + cellCounter + "," + i + "," + boundary + "," + contents);

            if(cellCounter==K) {
                printContents(boundary.toString(), contents.toString());

                cellCounter = 0;
                boundary = new StringBuilder(CELL_BOUNDARY_SPLITTER);
                contents = new StringBuilder(CELL_BOUNDARY_HORIZONTAL);
            }

        }

        //System.err.println("last:" + boundary.length());
        if(boundary.length()>1) {
            printContents(boundary.toString(), contents.toString());
        }

    }

    private String getBoundaryStr(String str, int length){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private String padLeft(int value, int length) {
        return String.format("%" + length + "s", value);
    }

    private void printContents(String boundary, String contents) {
        System.out.println(boundary);
        System.out.println(contents);
        System.out.println(boundary);
    }


}

class output {

    public static void main(String[] args) {
        int[] input = {4, 35, 80, 123, 12345, 44, 8, 5, 24, 3};
        Solution sol = new Solution();
        sol.solution(input, 4);

        int[] input1 = {4, 35, 80, 123, 12345, 5, 24, 3};
        sol.solution(input1, 4);
        int[] input2 = {4, 35, 80};
        sol.solution(input2, 4);

    }
}