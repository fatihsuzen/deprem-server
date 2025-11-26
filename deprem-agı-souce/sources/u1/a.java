package u1;

import A1.g;
import v1.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final n f16666a;

    private a(n nVar) {
        this.f16666a = nVar;
    }

    public static a a(b bVar) {
        n nVar = (n) bVar;
        g.b(bVar, "AdSession is null");
        g.l(nVar);
        g.g(nVar);
        a aVar = new a(nVar);
        nVar.t().i(aVar);
        return aVar;
    }

    public void b() {
        g.g(this.f16666a);
        g.j(this.f16666a);
        if (!this.f16666a.q()) {
            try {
                this.f16666a.g();
            } catch (Exception unused) {
            }
        }
        if (this.f16666a.q()) {
            this.f16666a.x();
        }
    }

    public void c() {
        g.f(this.f16666a);
        g.j(this.f16666a);
        this.f16666a.y();
    }

    public void d(d dVar) {
        g.b(dVar, "VastProperties is null");
        g.f(this.f16666a);
        g.j(this.f16666a);
        this.f16666a.k(dVar.a());
    }
}
