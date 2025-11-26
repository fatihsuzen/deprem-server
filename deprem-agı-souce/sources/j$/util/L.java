package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class L implements PrimitiveIterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f1271a;

    public /* synthetic */ L(M m5) {
        this.f1271a = m5;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        M m5 = this.f1271a;
        if (obj instanceof L) {
            obj = ((L) obj).f1271a;
        }
        return m5.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f1271a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f1271a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f1271a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f1271a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f1271a.hashCode();
    }

    public final /* synthetic */ int nextInt() {
        return this.f1271a.nextInt();
    }

    public final /* synthetic */ void remove() {
        this.f1271a.remove();
    }
}
