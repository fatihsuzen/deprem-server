package j$.util;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: j$.util.k  reason: case insensitive filesystem */
public final class C0475k extends C0473i implements RandomAccess {
    private static final long serialVersionUID = 1530674583602358482L;

    public final List subList(int i5, int i6) {
        C0473i iVar;
        synchronized (this.f1386b) {
            iVar = new C0473i(this.f1390c.subList(i5, i6), this.f1386b);
        }
        return iVar;
    }

    private Object writeReplace() {
        return new C0473i(this.f1390c);
    }
}
