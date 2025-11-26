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
import q1.C1776t;
import q1.C1778v;
import r1.C1811u;

public class B0 extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16498e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16499f = C1718a.c();

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
        throw new UnsupportedOperationException("Method not decompiled: s1.B0.j(java.util.List):boolean");
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
            this.f16499f.a(this.f16498e.c(str), o(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsTxCoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public String g(C1757a aVar) {
        return this.f16498e.d(this.f16499f.b(aVar, o()));
    }

    public List o() {
        return C1776t.f16181p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C1757a h() {
        y0 y0Var = new y0();
        z0 z0Var = new z0();
        A0 a02 = new A0();
        C1757a aVar = new C1757a();
        aVar.c(C1776t.f16166a, new i(6, Integer.valueOf(C1811u.f16441f)));
        aVar.c(C1776t.f16167b, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16168c, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16169d, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16170e, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16171f, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16172g, new j(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})).f(a02));
        aVar.c(C1778v.f16203h, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16174i, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16175j, new i(2, 1).f(z0Var));
        aVar.c(C1776t.f16176k, new i(2, 0).f(y0Var));
        aVar.c(C1776t.f16177l, new i(2, 0).f(y0Var));
        return aVar;
    }
}
