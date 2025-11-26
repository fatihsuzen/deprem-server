package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.x  reason: case insensitive filesystem */
public final class C0597x extends A {
    public final D sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final D parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final void forEach(DoubleConsumer doubleConsumer) {
        if (!this.f1648h.f1658r) {
            A.U0(S0()).forEachRemaining(doubleConsumer);
        } else {
            super.forEach(doubleConsumer);
        }
    }

    public final void forEachOrdered(DoubleConsumer doubleConsumer) {
        if (!this.f1648h.f1658r) {
            A.U0(S0()).forEachRemaining(doubleConsumer);
        } else {
            super.forEachOrdered(doubleConsumer);
        }
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0572s(this, Z2.f1636r, 1);
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
