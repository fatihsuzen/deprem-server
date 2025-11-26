package f4;

import e4.C2356e;
import e4.c0;
import kotlin.jvm.internal.t;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f21626a = c0.a("0123456789abcdef");

    public static final byte[] a() {
        return f21626a;
    }

    public static final String b(C2356e eVar, long j5) {
        t.e(eVar, "<this>");
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (eVar.q(j6) == 13) {
                String readUtf8 = eVar.readUtf8(j6);
                eVar.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = eVar.readUtf8(j5);
        eVar.skip(1);
        return readUtf82;
    }
}
