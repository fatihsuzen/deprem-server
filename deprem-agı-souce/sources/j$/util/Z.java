package j$.util;

import java.util.function.IntConsumer;

public interface Z extends f0 {
    void forEachRemaining(IntConsumer intConsumer);

    boolean tryAdvance(IntConsumer intConsumer);

    Z trySplit();
}
