package j$.util;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public interface M extends S {
    void forEachRemaining(Consumer consumer);

    void forEachRemaining(IntConsumer intConsumer);

    Integer next();

    int nextInt();
}
