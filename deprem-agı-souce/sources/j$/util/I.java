package j$.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public interface I extends S {
    void forEachRemaining(Consumer consumer);

    void forEachRemaining(DoubleConsumer doubleConsumer);

    Double next();

    double nextDouble();
}
