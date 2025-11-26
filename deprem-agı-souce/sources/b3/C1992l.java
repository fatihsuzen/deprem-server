package B3;

import w3.I;

/* renamed from: B3.l  reason: case insensitive filesystem */
public abstract class C1992l {
    public static final void a(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i5).toString());
        }
    }

    public static final I b(I i5, String str) {
        if (str != null) {
            return new v(i5, str);
        }
        return i5;
    }
}
