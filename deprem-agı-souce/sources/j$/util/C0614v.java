package j$.util;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: j$.util.v  reason: case insensitive filesystem */
public final class C0614v extends C0480p implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    public final List subList(int i5, int i6) {
        return new C0480p(this.f1417b.subList(i5, i6));
    }

    private Object writeReplace() {
        return new C0480p(this.f1417b);
    }
}
