package s1;

import java.util.List;
import l1.C1708c;
import l1.C1709d;
import m1.C1718a;
import n1.e;
import n1.i;
import p1.C1752a;
import q1.C1757a;
import q1.C1768l;

public class N extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16514e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16515f = C1718a.c();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16515f.a(this.f16514e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsIaGpcSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16514e.d(this.f16515f.b(aVar, l()));
    }

    public List l() {
        return C1768l.f16042q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        C1757a aVar = new C1757a();
        aVar.c(C1768l.f16038m, new i(2, 1));
        aVar.c(C1768l.f16039n, new e(Boolean.TRUE));
        aVar.c(C1768l.f16040o, new e(Boolean.FALSE));
        return aVar;
    }
}
