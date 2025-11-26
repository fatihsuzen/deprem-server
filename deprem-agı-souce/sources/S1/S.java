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
import q1.C1769m;
import r1.C1804n;

public class S extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16516e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16517f = C1718a.c();

    public static /* synthetic */ boolean j(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 2) {
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
        throw new UnsupportedOperationException("Method not decompiled: s1.S.k(java.util.List):boolean");
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
            this.f16517f.a(this.f16516e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsMtCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16516e.d(this.f16517f.b(aVar, o()));
    }

    public List o() {
        return C1769m.f16058p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        O o5 = new O();
        P p5 = new P();
        Q q5 = new Q();
        C1757a aVar = new C1757a();
        aVar.c(C1769m.f16043a, new i(6, Integer.valueOf(C1804n.f16420f)));
        aVar.c(C1769m.f16044b, new i(2, 0).f(o5));
        aVar.c(C1769m.f16045c, new i(2, 0).f(o5));
        aVar.c(C1769m.f16046d, new i(2, 0).f(o5));
        aVar.c(C1769m.f16047e, new i(2, 0).f(o5));
        aVar.c(C1769m.f16048f, new i(2, 0).f(o5));
        aVar.c(C1769m.f16049g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(q5));
        aVar.c(C1769m.f16050h, new j(2, Arrays.asList(new Integer[]{0, 0, 0})).f(q5));
        aVar.c(C1769m.f16051i, new i(2, 0).f(o5));
        aVar.c(C1769m.f16052j, new i(2, 1).f(p5));
        aVar.c(C1769m.f16053k, new i(2, 0).f(o5));
        aVar.c(C1769m.f16054l, new i(2, 0).f(o5));
        return aVar;
    }
}
