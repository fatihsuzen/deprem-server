package j$.util.stream;

import j$.util.Spliterator;

/* renamed from: j$.util.stream.i0  reason: case insensitive filesystem */
public abstract class C0524i0 extends C0534k0 {
    public final boolean P0() {
        return true;
    }

    public final C0549n0 sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final C0549n0 parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0582u(this, Z2.f1636r, 4);
    }

    static {
        Class<C0534k0> cls = C0534k0.class;
    }

    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
