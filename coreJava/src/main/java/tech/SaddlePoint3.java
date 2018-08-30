package tech;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//SaddlePoint is A[P][Q] if
// local max in row and local min in col
// (OR) local min ni row and local max in col
// local means comparing to adjacent elements


import java.util.Arrays;
import java.util.stream.IntStream;

public class SaddlePoint3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][] {{1,2,3},{1,2,3}});
        solution.solution(new int[][] {{1,1,3},{1,2,3},{1,1,3}});
        solution.solution(new int[][] {{1,2,3,2,1},{3,2,6,2,3},{1,2,5,4,3},{1,2,8,7,4},{1,2,3,5,6}});

    }

    static class Solution {
        public int solution(int[][] A) {
            // write your code in Java SE 8
            if(A==null || A.length<=2 || A[0].length<=2) return 0;

            System.out.println("foreach:");
            Arrays.stream(A).forEach(System.out::print);
            System.out.println("\r\nflatmap, foreach:");
            Arrays.stream(A).flatMapToInt(a -> {System.out.println(a); System.out.println(IntStream.of(a)); return IntStream.of(a);}).forEach(System.out::println);

            int saddleCount = 0;

            System.out.println("returning saddleCount: " + saddleCount);
            return saddleCount;
        }
    }
}