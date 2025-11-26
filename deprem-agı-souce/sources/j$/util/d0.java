package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class d0 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfPrimitive f1367a;

    public /* synthetic */ d0(Spliterator.OfPrimitive ofPrimitive) {
        this.f1367a = ofPrimitive;
    }

    public static /* synthetic */ f0 a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof e0 ? ((e0) ofPrimitive).f1368a : ofPrimitive instanceof Spliterator.OfDouble ? U.a((Spliterator.OfDouble) ofPrimitive) : ofPrimitive instanceof Spliterator.OfInt ? X.a((Spliterator.OfInt) ofPrimitive) : ofPrimitive instanceof Spliterator.OfLong ? a0.a((Spliterator.OfLong) ofPrimitive) : new d0(ofPrimitive);
    }

    public final /* synthetic */ int characteristics() {
        return this.f1367a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfPrimitive ofPrimitive = this.f1367a;
        if (obj instanceof d0) {
            obj = ((d0) obj).f1367a;
        }
        return ofPrimitive.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f1367a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1367a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1367a.forEachRemaining(consumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f1367a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f1367a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return this.f1367a.hasCharacteristics(i5);
    }

    public final /* synthetic */ int hashCode() {
        return this.f1367a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f1367a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f1367a.tryAdvance(consumer);
    }
}
