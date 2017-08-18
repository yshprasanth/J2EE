package sorting;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Floor {

    public static void main(String[] args) {
        Floor floor = new Floor();
        int[] arr1 = {60, 80, 40};
        int[] arr2 = {2, 3, 5};
        floor.solution(arr1, arr2, 5, 2, 200 ); // [60, 80, 40], [2, 3, 5], 5, 2, 200
    }

        public int solution(int[] A, int[] B, int M, int X, int Y) {
            // write your code in Java SE 8
            // counter will be used to count the number of time the lift stops
            int counter = 0;

            // local variable to hold the array size. used in for loop
            long arraySize = A.length;

            // Local variables to hold allowedWeight and Limit per term.
            // These variables are decremented in every term.
            // Initialized with Y and X respectively.
            long allowedWeightLimitPerTerm = Y;
            int allowedLimitPerTerm = X;

            // local Set variable to hold the no. of unique floors in each term
            Set<Integer> floors = new HashSet<>();

            // loop through the array once
            for(int i=0; i<arraySize; i++){
                // Get current value from array
                int currentValue = A[i];

                // Check if current value is above original weight limit (Y)
                // should be a break & return. There should not be such scenario.
                if(currentValue>Y)
                    throw new RuntimeException("Invalid Value: " + currentValue + ",  Exceeds given weight limit");

                // Check if current value is above the allowedWeightLimit or
                // if we exceed the allowed Limit per term
                if(currentValue>allowedWeightLimitPerTerm || allowedLimitPerTerm==0) {

                    // If yes, it means the Lift is full to capacity and ready to leave

                    // Increment the counter with the unique floor values
                    // +1 as it comes back and stops at ground floor.
                    counter += (floors.size() + 1);

                    // Reset the variables to hold the actual allowed capacity for the
                    // next run
                    allowedWeightLimitPerTerm = Y;
                    allowedLimitPerTerm = X;
                    floors.clear();
                }

                // Decrease the allowedLimitPerTerm variable by one
                allowedLimitPerTerm--;

                // Decrease the allowedWeightLimitPerTerm with the weight of the person
                allowedWeightLimitPerTerm -= A[i];

                // Add floors to the Set
                floors.add(B[i]);
            }

            // After the for loop, if the floors set is not empty
            // then it is the last term for Lift and add these floors to the counter
            if(floors.size()>0)
                counter += (floors.size()+1);

            System.out.println("counter:" + counter);

            return counter;
        }
}
