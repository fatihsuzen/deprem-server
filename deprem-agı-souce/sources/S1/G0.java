package s1;

import java.util.Arrays;
import java.util.List;
import l1.C1708c;
import l1.C1709d;
import m1.C1718a;
import n1.i;
import n1.j;
import p1.C1752a;
import q1.C1757a;
import q1.C1777u;
import r1.C1812v;

public class G0 extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16506e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16507f = C1718a.c();

    public static /* synthetic */ boolean j(Integer num) {
        if (num.intValue() < 1 || num.intValue() > 2) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean k(java.util.List r2) {
        /*
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001b
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 < 0) goto L_0x0019
            r1 = 2
            if (r0 <= r1) goto L_0x0004
        L_0x0019:
            r2 = 0
            return r2
        L_0x001b:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.G0.k(java.util.List):boolean");
    }

    public static /* synthetic */ boolean l(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16507f.a(this.f16506e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsUtCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16506e.d(this.f16507f.b(aVar, o()));
    }

    public List o() {
        return C1777u.f16195m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        D0 d02 = new D0();
        E0 e02 = new E0();
        F0 f02 = new F0();
        C1757a aVar = new C1757a();
        aVar.c(C1777u.f16183a, new i(6, Integer.valueOf(C1812v.f16444f)));
        aVar.c(C1777u.f16184b, new i(2, 0).f(d02));
        aVar.c(C1777u.f16185c, new i(2, 0).f(d02));
        aVar.c(C1777u.f16186d, new i(2, 0).f(d02));
        aVar.c(C1777u.f16187e, new i(2, 0).f(d02));
        aVar.c(C1777u.f16188f, new i(2, 0).f(d02));
        aVar.c(C1777u.f16189g, new i(2, 0).f(d02));
        aVar.c(C1777u.f16190h, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(f02));
        aVar.c(C1777u.f16191i, new i(2, 0).f(d02));
        aVar.c(C1777u.f16192j, new i(2, 1).f(e02));
        aVar.c(C1777u.f16193k, new i(2, 0).f(d02));
        aVar.c(C1777u.f16194l, new i(2, 0).f(d02));
        return aVar;
    }
}
