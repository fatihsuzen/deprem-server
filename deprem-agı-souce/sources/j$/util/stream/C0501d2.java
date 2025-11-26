package j$.util.stream;

/* renamed from: j$.util.stream.d2  reason: case insensitive filesystem */
public abstract class C0501d2 extends C0506e2 {
    public final boolean P0() {
        return false;
    }

    public final C0513g unordered() {
        if (!Z2.ORDERED.h(this.f1653m)) {
            return this;
        }
        return new C0483a(this, Z2.f1636r);
    }

    static {
        Class<C0506e2> cls = C0506e2.class;
    }
}
