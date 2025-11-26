package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class K implements M, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfInt f1270a;

    public /* synthetic */ K(PrimitiveIterator.OfInt ofInt) {
        this.f1270a = ofInt;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfInt ofInt = this.f1270a;
        if (obj instanceof K) {
            obj = ((K) obj).f1270a;
        }
        return ofInt.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1270a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1270a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f1270a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f1270a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1270a.hashCode();
    }

    public final /* synthetic */ int nextInt() {
        return this.f1270a.nextInt();
    }

    public final /* synthetic */ void remove() {
        this.f1270a.remove();
    }
}
