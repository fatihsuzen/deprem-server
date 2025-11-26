package r0;

import R0.a;
import R0.b;

class D implements b, a {

    /* renamed from: c  reason: collision with root package name */
    private static final a.C0056a f16312c = new C1782A();

    /* renamed from: d  reason: collision with root package name */
    private static final b f16313d = new C1783B();

    /* renamed from: a  reason: collision with root package name */
    private a.C0056a f16314a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f16315b;

    private D(a.C0056a aVar, b bVar) {
        this.f16314a = aVar;
        this.f16315b = bVar;
    }

    public static /* synthetic */ Object b() {
        return null;
    }

    public static /* synthetic */ void c(a.C0056a aVar, a.C0056a aVar2, b bVar) {
        aVar.a(bVar);
        aVar2.a(bVar);
    }

    public static /* synthetic */ void d(b bVar) {
    }

    static D e() {
        return new D(f16312c, f16313d);
    }

    static D f(b bVar) {
        return new D((a.C0056a) null, bVar);
    }

    public void a(a.C0056a aVar) {
        b bVar;
        b bVar2;
        b bVar3 = this.f16315b;
        b bVar4 = f16313d;
        if (bVar3 != bVar4) {
            aVar.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f16315b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                this.f16314a = new C(this.f16314a, aVar);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            aVar.a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(b bVar) {
        a.C0056a aVar;
        if (this.f16315b == f16313d) {
            synchronized (this) {
                aVar = this.f16314a;
                this.f16314a = null;
                this.f16315b = bVar;
            }
            aVar.a(bVar);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    public Object get() {
        return this.f16315b.get();
    }
}
