package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class P implements PrimitiveIterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Q f1275a;

    public /* synthetic */ P(Q q5) {
        this.f1275a = q5;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Q q5 = this.f1275a;
        if (obj instanceof P) {
            obj = ((P) obj).f1275a;
        }
        return q5.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1275a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1275a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f1275a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f1275a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1275a.hashCode();
    }

    public final /* synthetic */ long nextLong() {
        return this.f1275a.nextLong();
    }

    public final /* synthetic */ void remove() {
        this.f1275a.remove();
    }
}
