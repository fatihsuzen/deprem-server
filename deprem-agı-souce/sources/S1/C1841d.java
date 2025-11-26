package s1;

import java.util.ArrayList;
import java.util.List;
import l1.C1708c;
import l1.C1709d;
import m1.C1718a;
import n1.g;
import n1.i;
import p1.C1752a;
import q1.C1757a;
import q1.C1760d;
import r1.C1793c;

/* renamed from: s1.d  reason: case insensitive filesystem */
public class C1841d extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16530e = C1709d.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16531f = C1718a.c();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16531f.a(this.f16530e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode HeaderV1CoreSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16530e.d(this.f16531f.b(aVar, l()));
    }

    public List l() {
        return C1760d.f15886d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        C1757a aVar = new C1757a();
        aVar.c(C1760d.f15883a, new i(6, Integer.valueOf(C1793c.f16390e)));
        aVar.c(C1760d.f15884b, new i(6, Integer.valueOf(C1793c.f16391f)));
        aVar.c(C1760d.f15885c, new g(new ArrayList()));
        return aVar;
    }
}
