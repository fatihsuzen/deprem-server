package j$.util;

import j$.com.android.tools.r8.a;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class j0 implements Q, LongConsumer, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1399a = false;

    /* renamed from: b  reason: collision with root package name */
    public long f1400b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f1401c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (hasNext()) {
            longConsumer.accept(nextLong());
        }
    }

    public final Long next() {
        if (!x0.f1861a) {
            return Long.valueOf(nextLong());
        }
        x0.a(j0.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
        throw null;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            forEachRemaining((LongConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!x0.f1861a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((LongConsumer) new N(consumer, 0));
            return;
        }
        x0.a(j0.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
        throw null;
    }

    public j0(c0 c0Var) {
        this.f1401c = c0Var;
    }

    public final void accept(long j5) {
        this.f1399a = true;
        this.f1400b = j5;
    }

    public final boolean hasNext() {
        if (!this.f1399a) {
            this.f1401c.tryAdvance(this);
        }
        return this.f1399a;
    }

    public final long nextLong() {
        if (this.f1399a || hasNext()) {
            this.f1399a = false;
            return this.f1400b;
        }
        throw new NoSuchElementException();
    }
}
