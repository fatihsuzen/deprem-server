package j$.util;

import java.util.Set;

/* renamed from: j$.util.l  reason: case insensitive filesystem */
public final class C0476l extends C0472h implements Set {
    private static final long serialVersionUID = 487447009682186044L;

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f1386b) {
            equals = this.f1385a.equals(obj);
        }
        return equals;
    }

    public final int hashCode() {
        int hashCode;
        synchronized (this.f1386b) {
            hashCode = this.f1385a.hashCode();
        }
        return hashCode;
    }
}
