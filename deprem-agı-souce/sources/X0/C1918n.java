package x0;

import D0.g;
import c1.C1046c;

/* renamed from: x0.n  reason: case insensitive filesystem */
public class C1918n implements C1046c {

    /* renamed from: a  reason: collision with root package name */
    private final D f16886a;

    /* renamed from: b  reason: collision with root package name */
    private final C1917m f16887b;

    public C1918n(D d5, g gVar) {
        this.f16886a = d5;
        this.f16887b = new C1917m(gVar);
    }

    public boolean a() {
        return this.f16886a.d();
    }

    public C1046c.a b() {
        return C1046c.a.CRASHLYTICS;
    }

    public void c(C1046c.b bVar) {
        u0.g f5 = u0.g.f();
        f5.b("App Quality Sessions session changed: " + bVar);
        this.f16887b.f(bVar.a());
    }

    public String d(String str) {
        return this.f16887b.c(str);
    }

    public void e(String str) {
        this.f16887b.g(str);
    }
}
