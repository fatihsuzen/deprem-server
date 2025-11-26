package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class o0 extends C0469e implements Z {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.b(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.g(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return false;
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
    }
}
