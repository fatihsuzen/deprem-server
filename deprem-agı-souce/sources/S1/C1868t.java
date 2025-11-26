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
import q1.C1764h;
import r1.C1799i;

/* renamed from: s1.t  reason: case insensitive filesystem */
public class C1868t extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16568e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16569f = C1718a.c();

    public static /* synthetic */ boolean j(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 2) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean k(Integer num) {
        if (num.intValue() < 1 || num.intValue() > 2) {
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
        throw new UnsupportedOperationException("Method not decompiled: s1.C1868t.l(java.util.List):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16569f.a(this.f16568e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsCoCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16568e.d(this.f16569f.b(aVar, o()));
    }

    public List o() {
        return C1764h.f15978o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        C1866q qVar = new C1866q();
        r rVar = new r();
        C1867s sVar = new C1867s();
        C1757a aVar = new C1757a();
        aVar.c(C1764h.f15964a, new i(6, Integer.valueOf(C1799i.f16405f)));
        aVar.c(C1764h.f15965b, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15966c, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15967d, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15968e, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15969f, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15970g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0})).f(sVar));
        aVar.c(C1764h.f15971h, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15972i, new i(2, 1).f(rVar));
        aVar.c(C1764h.f15973j, new i(2, 0).f(qVar));
        aVar.c(C1764h.f15974k, new i(2, 0).f(qVar));
        return aVar;
    }
}
