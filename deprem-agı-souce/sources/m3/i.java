package M3;

import I3.a;
import J3.f;
import L3.T;
import N3.C2151v;
import N3.O;
import N3.S;
import W2.C2219h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final f f18691a = T.a("kotlinx.serialization.json.JsonUnquotedLiteral", a.H(Q.f24695a));

    public static final B a(String str) {
        if (str == null) {
            return w.INSTANCE;
        }
        return new s(str, true, (f) null, 4, (C2633k) null);
    }

    private static final Void b(h hVar, String str) {
        throw new IllegalArgumentException("Element " + M.b(hVar.getClass()) + " is not a " + str);
    }

    public static final Boolean c(B b5) {
        t.e(b5, "<this>");
        return S.d(b5.c());
    }

    public static final String d(B b5) {
        t.e(b5, "<this>");
        if (b5 instanceof w) {
            return null;
        }
        return b5.c();
    }

    public static final double e(B b5) {
        t.e(b5, "<this>");
        return Double.parseDouble(b5.c());
    }

    public static final float f(B b5) {
        t.e(b5, "<this>");
        return Float.parseFloat(b5.c());
    }

    public static final int g(B b5) {
        t.e(b5, "<this>");
        try {
            long m5 = new O(b5.c()).m();
            if (-2147483648L <= m5 && m5 <= 2147483647L) {
                return (int) m5;
            }
            throw new NumberFormatException(b5.c() + " is not an Int");
        } catch (C2151v e5) {
            throw new NumberFormatException(e5.getMessage());
        }
    }

    public static final B h(h hVar) {
        B b5;
        t.e(hVar, "<this>");
        if (hVar instanceof B) {
            b5 = (B) hVar;
        } else {
            b5 = null;
        }
        if (b5 != null) {
            return b5;
        }
        b(hVar, "JsonPrimitive");
        throw new C2219h();
    }

    public static final f i() {
        return f18691a;
    }

    public static final long j(B b5) {
        t.e(b5, "<this>");
        try {
            return new O(b5.c()).m();
        } catch (C2151v e5) {
            throw new NumberFormatException(e5.getMessage());
        }
    }
}
