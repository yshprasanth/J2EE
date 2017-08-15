package functions;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class IntSupplierTest {
    IntSupplier supp = () -> 2;
}

class IntSupplier1 implements IntSupplier {
    @Override
    public int getAsInt() {
        return 2;
    }
}