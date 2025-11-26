package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class U implements W {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfDouble f1278a;

    public /* synthetic */ U(Spliterator.OfDouble ofDouble) {
        this.f1278a = ofDouble;
    }

    public static /* synthetic */ W a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof V ? ((V) ofDouble).f1279a : new U(ofDouble);
    }

    public final /* synthetic */ int characteristics() {
        return this.f1278a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfDouble ofDouble = this.f1278a;
        if (obj instanceof U) {
            obj = ((U) obj).f1278a;
        }
        return ofDouble.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f1278a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1278a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1278a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f1278a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f1278a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f1278a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return this.f1278a.hasCharacteristics(i5);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1278a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f1278a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f1278a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f1278a.tryAdvance(doubleConsumer);
    }
}
