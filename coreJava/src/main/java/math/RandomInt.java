package math;

import java.util.Random;

public class RandomInt {

    public static void main(String[] args) {
        Random num = new Random();
        int num0, num1, num2, num3, num4, num5, num6, num7;

        num0 = num.nextInt(7) + 1;
        num1 = num.nextInt(8);
        num2 = num.nextInt(8);
        num3 = num.nextInt(643) + 101;
        num4 = num.nextInt(10);
        num5 = num.nextInt(10);
        num6 = num.nextInt(10);
        num7 = num.nextInt(10);

        String randnum = "A random phone number: ";
        System.out.print(randnum);
        System.out.print(num0);
        System.out.print(num1);
        System.out.print(num2);
        System.out.print("-" + num3 + "-");
        System.out.print(num4);
        System.out.print(num5);
        System.out.print(num6);
        System.out.println(num7);

        System.out.println(randnum);
        Random random = new Random();
        random.ints(10).forEach(System.out::println);
        double random1 =  Math.random()*10;
        System.out.println("Math.random: " + random1 + ", floor:" + Math.floor(random1) + ", ciel:" + Math.ceil(random1) + ", round:" + Math.round(random1));

    }
}
