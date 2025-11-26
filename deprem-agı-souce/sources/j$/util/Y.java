package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class Y implements Spliterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Z f1281a;

    public /* synthetic */ Y(Z z4) {
        this.f1281a = z4;
    }

    public static /* synthetic */ Spliterator.OfInt a(Z z4) {
        if (z4 == null) {
            return null;
        }
        return z4 instanceof X ? ((X) z4).f1280a : new Y(z4);
    }

    public final /* synthetic */ int characteristics() {
        return this.f1281a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Z z4 = this.f1281a;
        if (obj instanceof Y) {
            obj = ((Y) obj).f1281a;
        }
        return z4.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f1281a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1281a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1281a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f1281a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f1281a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f1281a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return this.f1281a.hasCharacteristics(i5);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1281a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f1281a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f1281a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f1281a.tryAdvance(intConsumer);
    }
}
