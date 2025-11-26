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
import q1.C1765i;
import r1.C1800j;

/* renamed from: s1.y  reason: case insensitive filesystem */
public class C1873y extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16576e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16577f = C1718a.c();

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
        throw new UnsupportedOperationException("Method not decompiled: s1.C1873y.k(java.util.List):boolean");
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
            this.f16577f.a(this.f16576e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsCtCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16576e.d(this.f16577f.b(aVar, o()));
    }

    public List o() {
        return C1765i.f15994o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        C1870v vVar = new C1870v();
        C1871w wVar = new C1871w();
        C1872x xVar = new C1872x();
        C1757a aVar = new C1757a();
        aVar.c(C1765i.f15980a, new i(6, Integer.valueOf(C1800j.f16408f)));
        aVar.c(C1765i.f15981b, new i(2, 0).f(vVar));
        aVar.c(C1765i.f15982c, new i(2, 0).f(vVar));
        aVar.c(C1765i.f15983d, new i(2, 0).f(vVar));
        aVar.c(C1765i.f15984e, new i(2, 0).f(vVar));
        aVar.c(C1765i.f15985f, new i(2, 0).f(vVar));
        aVar.c(C1765i.f15986g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(xVar));
        aVar.c(C1765i.f15987h, new j(2, Arrays.asList(new Integer[]{0, 0, 0})).f(xVar));
        aVar.c(C1765i.f15988i, new i(2, 1).f(wVar));
        aVar.c(C1765i.f15989j, new i(2, 0).f(vVar));
        aVar.c(C1765i.f15990k, new i(2, 0).f(vVar));
        return aVar;
    }
}
