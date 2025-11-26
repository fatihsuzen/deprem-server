package s1;

import java.util.List;
import l1.C1708c;
import l1.C1709d;
import m1.C1718a;
import n1.e;
import n1.i;
import p1.C1752a;
import q1.C1757a;
import q1.C1763g;

/* renamed from: s1.p  reason: case insensitive filesystem */
public class C1865p extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16562e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16563f = C1718a.c();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16563f.a(this.f16562e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode UsCaGpcSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16562e.d(this.f16563f.b(aVar, l()));
    }

    public List l() {
        return C1763g.f15963q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        C1757a aVar = new C1757a();
        aVar.c(C1763g.f15959m, new i(2, 1));
        aVar.c(C1763g.f15960n, new e(Boolean.TRUE));
        aVar.c(C1763g.f15961o, new e(Boolean.FALSE));
        return aVar;
    }
}
