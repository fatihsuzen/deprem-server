package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

/* renamed from: j$.util.s  reason: case insensitive filesystem */
public final class C0482s implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final Spliterator f1425a;

    public C0482s(Spliterator spliterator) {
        this.f1425a = spliterator;
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.f1425a.tryAdvance(new C0481q(0, consumer));
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.f1425a.forEachRemaining(new C0481q(0, consumer));
    }

    public final Spliterator trySplit() {
        Spliterator trySplit = this.f1425a.trySplit();
        if (trySplit == null) {
            return null;
        }
        return new C0482s(trySplit);
    }

    public final long estimateSize() {
        return this.f1425a.estimateSize();
    }

    public final long getExactSizeIfKnown() {
        return this.f1425a.getExactSizeIfKnown();
    }

    public final int characteristics() {
        return this.f1425a.characteristics();
    }

    public final boolean hasCharacteristics(int i5) {
        return this.f1425a.hasCharacteristics(i5);
    }

    public final Comparator getComparator() {
        return this.f1425a.getComparator();
    }
}
