package j$.util;

import java.util.function.LongConsumer;

public interface c0 extends f0 {
    void forEachRemaining(LongConsumer longConsumer);

    boolean tryAdvance(LongConsumer longConsumer);

    c0 trySplit();
}
