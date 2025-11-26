package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class X implements Z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfInt f1280a;

    public /* synthetic */ X(Spliterator.OfInt ofInt) {
        this.f1280a = ofInt;
    }

    public static /* synthetic */ Z a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof Y ? ((Y) ofInt).f1281a : new X(ofInt);
    }

    public final /* synthetic */ int characteristics() {
        return this.f1280a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.f1280a;
        if (obj instanceof X) {
            obj = ((X) obj).f1280a;
        }
        return ofInt.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f1280a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1280a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1280a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f1280a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f1280a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f1280a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return this.f1280a.hasCharacteristics(i5);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1280a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f1280a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f1280a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f1280a.tryAdvance(intConsumer);
    }
}
