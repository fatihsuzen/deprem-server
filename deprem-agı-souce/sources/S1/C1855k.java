package s1;

import java.util.ArrayList;
import java.util.List;
import l1.C1708c;
import l1.C1710e;
import m1.C1718a;
import n1.i;
import n1.n;
import p1.C1752a;
import q1.C1757a;
import q1.C1762f;

/* renamed from: s1.k  reason: case insensitive filesystem */
public class C1855k extends C1835a {

    /* renamed from: e  reason: collision with root package name */
    private C1708c f16554e = C1710e.f();

    /* renamed from: f  reason: collision with root package name */
    private C1718a f16555f = C1718a.c();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void f(String str, C1757a aVar) {
        if (str == null || str.isEmpty()) {
            ((C1757a) this.f16524a).d(aVar);
        }
        try {
            this.f16555f.a(this.f16554e.c(str), l(), aVar);
        } catch (Exception e5) {
            throw new C1752a("Unable to decode TcfEuV2VendorsDisclosedSegment '" + str + "'", e5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String g(C1757a aVar) {
        return this.f16554e.d(this.f16555f.b(aVar, l()));
    }

    public List l() {
        return C1762f.f15920G;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C1757a h() {
        C1757a aVar = new C1757a();
        aVar.c(C1762f.f15915B, new i(3, 1));
        aVar.c(C1762f.f15916C, new n(new ArrayList()));
        return aVar;
    }
}
