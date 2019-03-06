package core;

import java.util.function.Consumer;
import java.util.function.Function;

public class VarDeclaration {

    public static void main(String[] args){
        Consumer vd = (x) -> System.out.println("wow" + x);
        vd.accept("hello");
    }

    protected void sayHello() {
//        var text = "";
//        var text2 = text;

    }
}
