package core;

public class StringIntern {
    public static void main(String[] args){

        //var s1 = "hello";
        String s2 = "hello";
        String s3 = "he"+"llo";
        String s4 = new String("hello");
        String s5 = s4.intern();

//        System.out.println("s1==s2: "+ (s1==s2));
//        System.out.println("s2==s3: "+ (s2==s3));
//        System.out.println("s3==s4: "+ (s3==s4));
//        System.out.println("s1==s4: "+ (s1==s4));
//        System.out.println("s4==s5: "+ (s4==s5));
//        System.out.println("s1==s5: "+ (s1==s5));
//
//        System.out.println("s1.codePointAt(1):" + s1.codePointAt(1));
//        s1.chars().sorted().skip(1)
//                //.takeWhile( a -> {System.out.println("takeW, " + a); return a>105;})
//                .dropWhile( a -> {System.out.println("dropW, " + a); return a<110;})
//                .forEach(System.out::println);

    }
}
