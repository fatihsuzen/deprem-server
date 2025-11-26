package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public final class q0 extends C0469e implements Spliterator {
    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
    }
}
