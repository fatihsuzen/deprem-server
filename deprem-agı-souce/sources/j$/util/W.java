package j$.util;

import java.util.function.DoubleConsumer;

public interface W extends f0 {
    void forEachRemaining(DoubleConsumer doubleConsumer);

    boolean tryAdvance(DoubleConsumer doubleConsumer);

    W trySplit();
}
