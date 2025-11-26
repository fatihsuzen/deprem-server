package j$.util.stream;

import j$.util.Spliterator;

/* renamed from: j$.util.stream.y  reason: case insensitive filesystem */
public abstract class C0602y extends A {
    public final boolean P0() {
        return true;
    }

    public final D sequential() {
        this.f1648h.f1658r = false;
        return this;
    }

    public final D parallel() {
        this.f1648h.f1658r = true;
        return this;
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0572s(this, Z2.f1636r, 1);
    }

    static {
        Class<A> cls = A.class;
    }

    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
