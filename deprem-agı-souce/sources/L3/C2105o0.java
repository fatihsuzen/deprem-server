package L3;

import J3.f;
import X2.C2250q;
import k3.l;
import kotlin.jvm.internal.t;

/* renamed from: L3.o0  reason: case insensitive filesystem */
public abstract class C2105o0 extends Z0 {
    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final String t(f fVar, int i5) {
        t.e(fVar, "<this>");
        return B(z(fVar, i5));
    }

    /* access modifiers changed from: protected */
    public final String B(String str) {
        t.e(str, "nestedName");
        String str2 = (String) s();
        if (str2 == null) {
            str2 = "";
        }
        return y(str2, str);
    }

    /* access modifiers changed from: protected */
    public final String C() {
        if (u().isEmpty()) {
            return "$";
        }
        return C2250q.V(u(), ".", "$.", (CharSequence) null, 0, (CharSequence) null, (l) null, 60, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract String y(String str, String str2);

    /* access modifiers changed from: protected */
    public String z(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return fVar.f(i5);
    }
}
