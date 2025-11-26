package j$.util;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

public interface Q extends S {
    void forEachRemaining(Consumer consumer);

    void forEachRemaining(LongConsumer longConsumer);

    Long next();

    long nextLong();
}
