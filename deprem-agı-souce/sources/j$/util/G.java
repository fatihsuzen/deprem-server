package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class G implements I, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfDouble f1266a;

    public /* synthetic */ G(PrimitiveIterator.OfDouble ofDouble) {
        this.f1266a = ofDouble;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfDouble ofDouble = this.f1266a;
        if (obj instanceof G) {
            obj = ((G) obj).f1266a;
        }
        return ofDouble.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1266a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1266a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f1266a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f1266a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1266a.hashCode();
    }

    public final /* synthetic */ double nextDouble() {
        return this.f1266a.nextDouble();
    }

    public final /* synthetic */ void remove() {
        this.f1266a.remove();
    }
}
