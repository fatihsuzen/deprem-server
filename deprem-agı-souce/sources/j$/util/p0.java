package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class p0 extends C0469e implements c0 {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return false;
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
    }
}
