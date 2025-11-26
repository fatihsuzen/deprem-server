package j$.util;

import j$.com.android.tools.r8.a;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class i0 implements M, IntConsumer, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1391a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f1392b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Z f1393c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        while (hasNext()) {
            intConsumer.accept(nextInt());
        }
    }

    public final Integer next() {
        if (!x0.f1861a) {
            return Integer.valueOf(nextInt());
        }
        x0.a(i0.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
        throw null;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            forEachRemaining((IntConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((IntConsumer) new J(consumer, 0));
            return;
        }
        x0.a(i0.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
        throw null;
    }

    public i0(Z z4) {
        this.f1393c = z4;
    }

    public final void accept(int i5) {
        this.f1391a = true;
        this.f1392b = i5;
    }

    public final boolean hasNext() {
        if (!this.f1391a) {
            this.f1393c.tryAdvance(this);
        }
        return this.f1391a;
    }

    public final int nextInt() {
        if (this.f1391a || hasNext()) {
            this.f1391a = false;
            return this.f1392b;
        }
        throw new NoSuchElementException();
    }
}
