package r;

import p.C1745c;
import p.C1746d;
import p.h;
import p.i;
import p.k;

final class s implements i {

    /* renamed from: a  reason: collision with root package name */
    private final p f16295a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16296b;

    /* renamed from: c  reason: collision with root package name */
    private final C1745c f16297c;

    /* renamed from: d  reason: collision with root package name */
    private final h f16298d;

    /* renamed from: e  reason: collision with root package name */
    private final t f16299e;

    s(p pVar, String str, C1745c cVar, h hVar, t tVar) {
        this.f16295a = pVar;
        this.f16296b = str;
        this.f16297c = cVar;
        this.f16298d = hVar;
        this.f16299e = tVar;
    }

    public static /* synthetic */ void c(Exception exc) {
    }

    public void a(C1746d dVar, k kVar) {
        this.f16299e.a(o.a().e(this.f16295a).c(dVar).f(this.f16296b).d(this.f16298d).b(this.f16297c).a(), kVar);
    }

    public void b(C1746d dVar) {
        a(dVar, new r());
    }

    /* access modifiers changed from: package-private */
    public p d() {
        return this.f16295a;
    }
}
