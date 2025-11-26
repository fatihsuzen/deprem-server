package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntConsumer;

public final class Y extends C0489b0 {
    public final IntStream sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final IntStream parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final void forEach(IntConsumer intConsumer) {
        if (!this.f1648h.f1658r) {
            C0489b0.U0(S0()).forEachRemaining(intConsumer);
        } else {
            super.forEach(intConsumer);
        }
    }

    public final void forEachOrdered(IntConsumer intConsumer) {
        if (!this.f1648h.f1658r) {
            C0489b0.U0(S0()).forEachRemaining(intConsumer);
        } else {
            super.forEachOrdered(intConsumer);
        }
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0577t(this, Z2.f1636r, 2);
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
