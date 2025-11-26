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
import q1.C1771o;
import q1.C1778v;
import r1.C1806p;

/* renamed from: s1.c0  reason: case insensitive filesystem */
public class C1840c0 extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16528e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16529f = C1718a.c();

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
        throw new UnsupportedOperationException("Method not decompiled: s1.C1840c0.j(java.util.List):boolean");
    }

    public static /* synthetic */ boolean k(Integer num) {
        if (num.intValue() < 1 || num.intValue() > 2) {
            return false;
        }
        return true;
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
            this.f16529f.a(this.f16528e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsNeCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16528e.d(this.f16529f.b(aVar, o()));
    }

    public List o() {
        return C1771o.f16096p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        Z z4 = new Z();
        C1836a0 a0Var = new C1836a0();
        C1838b0 b0Var = new C1838b0();
        C1757a aVar = new C1757a();
        aVar.c(C1771o.f16081a, new i(6, Integer.valueOf(C1806p.f16426f)));
        aVar.c(C1771o.f16082b, new i(2, 0).f(z4));
        aVar.c(C1771o.f16083c, new i(2, 0).f(z4));
        aVar.c(C1771o.f16084d, new i(2, 0).f(z4));
        aVar.c(C1771o.f16085e, new i(2, 0).f(z4));
        aVar.c(C1771o.f16086f, new i(2, 0).f(z4));
        aVar.c(C1771o.f16087g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(b0Var));
        aVar.c(C1778v.f16203h, new i(2, 0).f(z4));
        aVar.c(C1771o.f16089i, new i(2, 0).f(z4));
        aVar.c(C1771o.f16090j, new i(2, 1).f(a0Var));
        aVar.c(C1771o.f16091k, new i(2, 0).f(z4));
        aVar.c(C1771o.f16092l, new i(2, 0).f(z4));
        return aVar;
    }
}
