package e3;

/* renamed from: e3.c  reason: case insensitive filesystem */
public abstract class C2351c {
    private static final int a(int i5, int i6, int i7) {
        return c(c(i5, i7) - c(i6, i7), i7);
    }

    public static final int b(int i5, int i6, int i7) {
        if (i7 > 0) {
            if (i5 < i6) {
                return i6 - a(i6, i5, i7);
            }
        } else if (i7 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (i5 > i6) {
            return i6 + a(i5, i6, -i7);
        }
        return i6;
    }

    private static final int c(int i5, int i6) {
        int i7 = i5 % i6;
        if (i7 >= 0) {
            return i7;
        }
        return i7 + i6;
    }
}
