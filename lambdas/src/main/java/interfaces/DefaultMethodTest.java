package interfaces;

interface Interface1 {

    void method1(String str);

    default void log(String str){
        if(!isNull(str))
            System.out.println("I1 logging::"+str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }
}

interface Interface2 {

    void method2();

    default void log(String str){
        System.out.println("I2 logging::"+str);
    }

}

public class DefaultMethodTest implements Interface1, Interface2 {

    @Override
    public void method2() {
    }

    @Override
    public void method1(String str) {
    }

    public boolean isNull(String str) {
        System.out.println("DefaultMethodTest Null Check");

        return str == null ? true : false;
    }

    @Override
    public void log(String str){
        System.out.println("DefaultMethodTest logging::"+str);
        Interface1.super.log("abc");
    }

    public static void main(String[] args){
        DefaultMethodTest df = new DefaultMethodTest();
        df.log("hello");
        df.isNull("hhh");
    }

}
