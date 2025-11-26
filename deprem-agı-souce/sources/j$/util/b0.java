package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class b0 implements Spliterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c0 f1286a;

    public /* synthetic */ b0(c0 c0Var) {
        this.f1286a = c0Var;
    }

    public static /* synthetic */ Spliterator.OfLong a(c0 c0Var) {
        if (c0Var == null) {
            return null;
        }
        return c0Var instanceof a0 ? ((a0) c0Var).f1285a : new b0(c0Var);
    }

    public final /* synthetic */ int characteristics() {
        return this.f1286a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        c0 c0Var = this.f1286a;
        if (obj instanceof b0) {
            obj = ((b0) obj).f1286a;
        }
        return c0Var.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f1286a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1286a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1286a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f1286a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f1286a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f1286a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return this.f1286a.hasCharacteristics(i5);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1286a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f1286a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f1286a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f1286a.tryAdvance(longConsumer);
    }
}
