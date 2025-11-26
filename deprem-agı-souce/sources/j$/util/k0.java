package j$.util;

import j$.com.android.tools.r8.a;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class k0 implements I, DoubleConsumer, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1402a = false;

    /* renamed from: b  reason: collision with root package name */
    public double f1403b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ W f1404c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        while (hasNext()) {
            doubleConsumer.accept(nextDouble());
        }
    }

    public final Double next() {
        if (!x0.f1861a) {
            return Double.valueOf(nextDouble());
        }
        x0.a(k0.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
        throw null;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            forEachRemaining((DoubleConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((DoubleConsumer) new F(consumer, 0));
            return;
        }
        x0.a(k0.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
        throw null;
    }

    public k0(W w4) {
        this.f1404c = w4;
    }

    public final void accept(double d5) {
        this.f1402a = true;
        this.f1403b = d5;
    }

    public final boolean hasNext() {
        if (!this.f1402a) {
            this.f1404c.tryAdvance(this);
        }
        return this.f1402a;
    }

    public final double nextDouble() {
        if (this.f1402a || hasNext()) {
            this.f1402a = false;
            return this.f1403b;
        }
        throw new NoSuchElementException();
    }
}
