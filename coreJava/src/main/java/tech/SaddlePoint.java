package tech;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//SaddlePoint is A[P][Q] if
// local max in row and local min in col
// (OR) local min ni row and local max in col
// local means comparing to adjacent elements


public class SaddlePoint {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][] {{1,2,3},{1,2,3}});

    }

    static class Solution {
        public int solution(int[][] A) {
            // write your code in Java SE 8
            if(A==null || A.length<=2 || A[0].length<=2) return 0;

            int rowCount = A.length;
            int colCount = A[0].length;
            //System.out.println("rowCount:" + rowCount + ", colCount: " + colCount);

            int saddleCount = 0;
            for(int rowIndex=1; rowIndex<rowCount-1; rowIndex++) {
                for(int colIndex=1; colIndex<colCount-1; colIndex++) {
                    try {
                        int currentElem = A[rowIndex][colIndex];
                        int rowPrevElem = A[rowIndex][colIndex-1];
                        int rowNextElem = A[rowIndex][colIndex+1];
                        int colPrevElem = A[rowIndex-1][colIndex];
                        int colNextElem = A[rowIndex+1][colIndex];

                        //System.out.println(rowIndex + "," + colIndex + ":" + currentElem + "," + rowPrevElem + "," + rowNextElem + "," + colPrevElem + "," + colNextElem);
                        if(((rowPrevElem>currentElem && currentElem<rowNextElem)
                                && (colPrevElem<currentElem && currentElem>colNextElem))
                                || ((rowPrevElem<currentElem && currentElem>rowNextElem)
                                && (colPrevElem>currentElem && currentElem<colNextElem))){

                            //System.out.println("incrementing saddleCount: " + saddleCount);
                            saddleCount++;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        e.printStackTrace();
                    }
                }
            }
            //System.out.println("returning saddleCount: " + saddleCount);
            return saddleCount;
        }
    }
}