package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class O implements Q, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfLong f1274a;

    public /* synthetic */ O(PrimitiveIterator.OfLong ofLong) {
        this.f1274a = ofLong;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfLong ofLong = this.f1274a;
        if (obj instanceof O) {
            obj = ((O) obj).f1274a;
        }
        return ofLong.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1274a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1274a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f1274a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f1274a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1274a.hashCode();
    }

    public final /* synthetic */ long nextLong() {
        return this.f1274a.nextLong();
    }

    public final /* synthetic */ void remove() {
        this.f1274a.remove();
    }
}
