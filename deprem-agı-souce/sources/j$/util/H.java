package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class H implements PrimitiveIterator.OfDouble {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f1267a;

    public /* synthetic */ H(I i5) {
        this.f1267a = i5;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        I i5 = this.f1267a;
        if (obj instanceof H) {
            obj = ((H) obj).f1267a;
        }
        return i5.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1267a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1267a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f1267a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f1267a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1267a.hashCode();
    }

    public final /* synthetic */ double nextDouble() {
        return this.f1267a.nextDouble();
    }

    public final /* synthetic */ void remove() {
        this.f1267a.remove();
    }
}
