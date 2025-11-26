package j$.util;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class g0 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator f1384a;

    public /* synthetic */ g0(Spliterator spliterator) {
        this.f1384a = spliterator;
    }

    public static /* synthetic */ Spliterator a(Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof Spliterator.Wrapper ? Spliterator.this : spliterator instanceof Spliterator.OfPrimitive ? d0.a((Spliterator.OfPrimitive) spliterator) : new g0(spliterator);
    }

    public final /* synthetic */ int characteristics() {
        return this.f1384a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.Spliterator spliterator = this.f1384a;
        if (obj instanceof g0) {
            obj = ((g0) obj).f1384a;
        }
        return spliterator.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f1384a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1384a.forEachRemaining(consumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f1384a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f1384a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return this.f1384a.hasCharacteristics(i5);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1384a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f1384a.tryAdvance(consumer);
    }

    public final /* synthetic */ Spliterator trySplit() {
        return a(this.f1384a.trySplit());
    }
}
