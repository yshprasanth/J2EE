package exceptions;

import java.io.IOException;
import java.io.StringWriter;

public class TryWithResourcesTest {
    public static void main(String[] args) throws IOException {
        StringWriter sw = new StringWriter(1);
        try{//(sw){
            System.out.println("hello");
            sw.append('2');
        } finally {
            System.out.println("finally - " + sw);
        }

        System.out.println("outside - " + sw);

    }
}
