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
import q1.C1775s;
import r1.C1810t;

public class w0 extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16572e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16573f = C1718a.c();

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean j(java.util.List r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: s1.w0.j(java.util.List):boolean");
    }

    public static /* synthetic */ boolean k(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 2) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean l(Integer num) {
        if (num.intValue() < 1 || num.intValue() > 2) {
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
            this.f16573f.a(this.f16572e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsTnCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16572e.d(this.f16573f.b(aVar, o()));
    }

    public List o() {
        return C1775s.f16164p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        t0 t0Var = new t0();
        u0 u0Var = new u0();
        v0 v0Var = new v0();
        C1757a aVar = new C1757a();
        aVar.c(C1775s.f16149a, new i(6, Integer.valueOf(C1810t.f16438f)));
        aVar.c(C1775s.f16150b, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16151c, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16152d, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16153e, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16154f, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16155g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(v0Var));
        aVar.c(C1775s.f16156h, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16157i, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16158j, new i(2, 1).f(u0Var));
        aVar.c(C1775s.f16159k, new i(2, 0).f(t0Var));
        aVar.c(C1775s.f16160l, new i(2, 0).f(t0Var));
        return aVar;
    }
}
