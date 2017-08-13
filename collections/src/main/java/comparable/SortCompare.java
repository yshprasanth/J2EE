package comparable;

import java.util.Arrays;

public class SortCompare {
    public static void main(String[] args) {
        Car car1 = new Car("A",  5000);
        Car car2 = new Car("B", 5000);
        Car car3 = new Car("C", 4000);

        System.out.println("Car 1 equals Car 2: " + car1.compareTo(car2));
        System.out.println("Car 1 equals Car 3: " + car1.compareTo(car3));
        System.out.println("Car 2 equals Car 3: " + car2.compareTo(car3));

        Car[] carArray = new Car[] { car1, car2, car3 };
        Arrays.sort(carArray);

        for (Car car : carArray)
            System.out.println(car.toString());
    }

    private static class Car implements Comparable<Car>{
        private String make;
        private int milage;

        @Override
        public String toString() {
            return "Car{" +
                    "make='" + make + '\'' +
                    ", milage=" + milage +
                    '}';
        }

        public Car(String make, int milage) {
            this.make = make;
            this.milage = milage;
        }

        @Override
        public int compareTo(Car o) {
            int returnVal = 0;
            if(this.milage>o.milage)
                returnVal = 1;
            else if(this.milage<o.milage)
                returnVal = -1;

            System.out.println(this + " is comparedTo " + o + " = " + returnVal);

            return returnVal;
        }
    }
}
