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
import q1.C1770n;
import r1.C1805o;

public class X extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16520e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16521f = C1718a.c();

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
        throw new UnsupportedOperationException("Method not decompiled: s1.X.l(java.util.List):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            String c5 = this.f16520e.c(str);
            if (c5.length() == 66) {
                c5 = c5.substring(0, 48) + "00000000" + c5.substring(48, 52) + "00" + c5.substring(52, 62);
            }
            this.f16521f.a(c5, o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsNatCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16520e.d(this.f16521f.b(aVar, o()));
    }

    public List o() {
        return C1770n.f16079t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        U u5 = new U();
        V v5 = new V();
        W w4 = new W();
        C1757a aVar = new C1757a();
        aVar.c(C1770n.f16060a, new i(6, Integer.valueOf(C1805o.f16423f)));
        aVar.c(C1770n.f16061b, new i(2, 0).f(u5));
        aVar.c(C1770n.f16062c, new i(2, 0).f(u5));
        aVar.c(C1770n.f16063d, new i(2, 0).f(u5));
        aVar.c(C1770n.f16064e, new i(2, 0).f(u5));
        aVar.c(C1770n.f16065f, new i(2, 0).f(u5));
        aVar.c(C1770n.f16066g, new i(2, 0).f(u5));
        aVar.c(C1770n.f16067h, new i(2, 0).f(u5));
        aVar.c(C1770n.f16068i, new i(2, 0).f(u5));
        aVar.c(C1770n.f16069j, new i(2, 0).f(u5));
        aVar.c(C1770n.f16070k, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})).f(w4));
        aVar.c(C1770n.f16071l, new j(2, Arrays.asList(new Integer[]{0, 0, 0})).f(w4));
        aVar.c(C1770n.f16072m, new i(2, 0).f(u5));
        aVar.c(C1770n.f16073n, new i(2, 1).f(v5));
        aVar.c(C1770n.f16074o, new i(2, 0).f(u5));
        aVar.c(C1770n.f16075p, new i(2, 0).f(u5));
        return aVar;
    }
}
