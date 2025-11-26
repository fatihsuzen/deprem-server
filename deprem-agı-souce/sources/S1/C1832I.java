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
import q1.C1767k;
import r1.C1802l;

/* renamed from: s1.I  reason: case insensitive filesystem */
public class C1832I extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16508e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16509f = C1718a.c();

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
        throw new UnsupportedOperationException("Method not decompiled: s1.C1832I.l(java.util.List):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16509f.a(this.f16508e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsFlCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16508e.d(this.f16509f.b(aVar, o()));
    }

    public List o() {
        return C1767k.f16025m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        C1829F f5 = new C1829F();
        C1830G g5 = new C1830G();
        C1831H h5 = new C1831H();
        C1757a aVar = new C1757a();
        aVar.c(C1767k.f16013a, new i(6, Integer.valueOf(C1802l.f16414f)));
        aVar.c(C1767k.f16014b, new i(2, 0).f(f5));
        aVar.c(C1767k.f16015c, new i(2, 0).f(f5));
        aVar.c(C1767k.f16016d, new i(2, 0).f(f5));
        aVar.c(C1767k.f16017e, new i(2, 0).f(f5));
        aVar.c(C1767k.f16018f, new i(2, 0).f(f5));
        aVar.c(C1767k.f16019g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(h5));
        aVar.c(C1767k.f16020h, new j(2, Arrays.asList(new Integer[]{0, 0, 0})).f(h5));
        aVar.c(C1767k.f16021i, new i(2, 0).f(f5));
        aVar.c(C1767k.f16022j, new i(2, 1).f(g5));
        aVar.c(C1767k.f16023k, new i(2, 0).f(f5));
        aVar.c(C1767k.f16024l, new i(2, 0).f(f5));
        return aVar;
    }
}
