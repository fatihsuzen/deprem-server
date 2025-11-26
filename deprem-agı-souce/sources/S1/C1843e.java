package s1;

import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l1.C1708c;
import l1.C1709d;
import m1.C1718a;
import n1.C1727d;
import n1.e;
import n1.f;
import n1.h;
import n1.i;
import n1.l;
import n1.n;
import p1.C1752a;
import q1.C1757a;
import q1.C1761e;
import r1.C1796f;

/* renamed from: s1.e  reason: case insensitive filesystem */
public class C1843e extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16534e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16535f = C1718a.c();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16535f.a(this.f16534e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode TcfCaV1CoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16534e.d(this.f16535f.b(aVar, l()));
    }

    public List l() {
        return C1761e.f15912y;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        ZonedDateTime now = ZonedDateTime.now();
        C1757a aVar = new C1757a();
        aVar.c(C1761e.f15888a, new i(6, Integer.valueOf(C1796f.f16396f)));
        aVar.c(C1761e.f15889b, new f(now));
        aVar.c(C1761e.f15890c, new f(now));
        aVar.c(C1761e.f15891d, new i(12, 0));
        aVar.c(C1761e.f15892e, new i(12, 0));
        aVar.c(C1761e.f15893f, new i(6, 0));
        aVar.c(C1761e.f15894g, new l(2, "EN"));
        aVar.c(C1761e.f15895h, new i(12, 0));
        aVar.c(C1761e.f15896i, new i(6, 2));
        String str = C1761e.f15897j;
        Boolean bool = Boolean.FALSE;
        aVar.c(str, new e(bool));
        aVar.c(C1761e.f15898k, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1761e.f15899l, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1761e.f15900m, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1761e.f15901n, new n(new ArrayList()));
        aVar.c(C1761e.f15902o, new n(new ArrayList()));
        aVar.c(C1761e.f15903p, new C1727d(6, 2, new ArrayList(), false));
        return aVar;
    }
}
