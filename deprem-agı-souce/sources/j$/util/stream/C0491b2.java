package j$.util.stream;

import java.util.function.Consumer;

/* renamed from: j$.util.stream.b2  reason: case insensitive filesystem */
public final class C0491b2 extends C0506e2 {
    public final void forEach(Consumer consumer) {
        if (!this.f1648h.f1658r) {
            S0().forEachRemaining(consumer);
        } else {
            super.forEach(consumer);
        }
    }

    public final void forEachOrdered(Consumer consumer) {
        if (!this.f1648h.f1658r) {
            S0().forEachRemaining(consumer);
        } else {
            super.forEachOrdered(consumer);
        }
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0483a(this, Z2.f1636r);
    }

    public final boolean P0() {
        throw new UnsupportedOperationException();
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        throw new UnsupportedOperationException();
    }
}
