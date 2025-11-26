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
import q1.C1773q;
import r1.C1808r;

/* renamed from: s1.m0  reason: case insensitive filesystem */
public class C1860m0 extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16556e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16557f = C1718a.c();

    public static /* synthetic */ boolean j(Integer num) {
        if (num.intValue() < 1 || num.intValue() > 2) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean k(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 2) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean l(java.util.List r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: s1.C1860m0.l(java.util.List):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16557f.a(this.f16556e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsNjCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16556e.d(this.f16557f.b(aVar, o()));
    }

    public List o() {
        return C1773q.f16130p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        C1854j0 j0Var = new C1854j0();
        C1856k0 k0Var = new C1856k0();
        C1858l0 l0Var = new C1858l0();
        C1757a aVar = new C1757a();
        aVar.c(C1773q.f16115a, new i(6, Integer.valueOf(C1808r.f16432f)));
        aVar.c(C1773q.f16116b, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16117c, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16118d, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16119e, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16120f, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16121g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).f(l0Var));
        aVar.c(C1773q.f16122h, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0})).f(l0Var));
        aVar.c(C1773q.f16123i, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16124j, new i(2, 1).f(k0Var));
        aVar.c(C1773q.f16125k, new i(2, 0).f(j0Var));
        aVar.c(C1773q.f16126l, new i(2, 0).f(j0Var));
        return aVar;
    }
}
