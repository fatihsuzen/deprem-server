package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.h0  reason: case insensitive filesystem */
public final class C0519h0 extends C0534k0 {
    public final C0549n0 sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final C0549n0 parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final void forEach(LongConsumer longConsumer) {
        if (!this.f1648h.f1658r) {
            C0534k0.U0(S0()).forEachRemaining(longConsumer);
        } else {
            super.forEach(longConsumer);
        }
    }

    public final void forEachOrdered(LongConsumer longConsumer) {
        if (!this.f1648h.f1658r) {
            C0534k0.U0(S0()).forEachRemaining(longConsumer);
        } else {
            super.forEachOrdered(longConsumer);
        }
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0582u(this, Z2.f1636r, 4);
    }

    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    public final boolean P0() {
        throw new UnsupportedOperationException();
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        throw new UnsupportedOperationException();
    }
}
