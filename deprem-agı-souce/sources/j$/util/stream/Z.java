package j$.util.stream;

import j$.util.Spliterator;

public abstract class Z extends C0489b0 {
    public final boolean P0() {
        return true;
    }

    public final IntStream sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final IntStream parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0577t(this, Z2.f1636r, 2);
    }

    static {
        Class<C0489b0> cls = C0489b0.class;
    }

    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
