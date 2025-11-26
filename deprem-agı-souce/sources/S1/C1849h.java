package s1;

import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l1.C1708c;
import l1.C1710e;
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
import q1.C1762f;
import r1.C1797g;

/* renamed from: s1.h  reason: case insensitive filesystem */
public class C1849h extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16542e = C1710e.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16543f = C1718a.c();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16543f.a(this.f16542e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode TcfEuV2CoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16542e.d(this.f16543f.b(aVar, l()));
    }

    public List l() {
        return C1762f.f15917D;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        ZonedDateTime now = ZonedDateTime.now();
        C1757a aVar = new C1757a();
        aVar.c(C1762f.f15921a, new i(6, Integer.valueOf(C1797g.f16399f)));
        aVar.c(C1762f.f15922b, new f(now));
        aVar.c(C1762f.f15923c, new f(now));
        aVar.c(C1762f.f15924d, new i(12, 0));
        aVar.c(C1762f.f15925e, new i(12, 0));
        aVar.c(C1762f.f15926f, new i(6, 0));
        aVar.c(C1762f.f15927g, new l(2, "EN"));
        aVar.c(C1762f.f15928h, new i(12, 0));
        aVar.c(C1762f.f15929i, new i(6, 2));
        String str = C1762f.f15930j;
        Boolean bool = Boolean.FALSE;
        aVar.c(str, new e(bool));
        aVar.c(C1762f.f15931k, new e(bool));
        aVar.c(C1762f.f15932l, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1762f.f15933m, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1762f.f15934n, new h(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        aVar.c(C1762f.f15935o, new e(bool));
        aVar.c(C1762f.f15936p, new l(2, "AA"));
        aVar.c(C1762f.f15937q, new n(new ArrayList()));
        aVar.c(C1762f.f15938r, new n(new ArrayList()));
        aVar.c(C1762f.f15939s, new C1727d(6, 2, new ArrayList(), false));
        return aVar;
    }
}
