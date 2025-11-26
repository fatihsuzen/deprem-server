package v3;

import kotlin.jvm.internal.t;

/* renamed from: v3.b  reason: case insensitive filesystem */
abstract class C2804b {
    public static final void a(long j5, byte[] bArr, int i5, int i6, int i7) {
        t.e(bArr, "dst");
        C2805c.f(j5, bArr, i5, i6, i7);
    }

    public static final C2803a b(String str) {
        t.e(str, "hexString");
        return C2805c.h(str);
    }

    public static final C2803a c(String str) {
        t.e(str, "hexDashString");
        return C2805c.i(str);
    }
}
