package r;

import L0.a;
import u.C1883a;
import u.C1884b;
import u.C1885c;

/* renamed from: r.a  reason: case insensitive filesystem */
public final class C1780a implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16213a = new C1780a();

    /* renamed from: r.a$a  reason: collision with other inner class name */
    private static final class C0161a implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final C0161a f16214a = new C0161a();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16215b = K0.c.a("window").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f16216c = K0.c.a("logSourceMetrics").b(N0.a.b().c(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f16217d = K0.c.a("globalMetrics").b(N0.a.b().c(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f16218e = K0.c.a("appNamespace").b(N0.a.b().c(4).a()).a();

        private C0161a() {
        }

        /* renamed from: b */
        public void a(C1883a aVar, K0.e eVar) {
            eVar.a(f16215b, aVar.d());
            eVar.a(f16216c, aVar.c());
            eVar.a(f16217d, aVar.b());
            eVar.a(f16218e, aVar.a());
        }
    }

    /* renamed from: r.a$b */
    private static final class b implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final b f16219a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16220b = K0.c.a("storageMetrics").b(N0.a.b().c(1).a()).a();

        private b() {
        }

        /* renamed from: b */
        public void a(C1884b bVar, K0.e eVar) {
            eVar.a(f16220b, bVar.a());
        }
    }

    /* renamed from: r.a$c */
    private static final class c implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final c f16221a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16222b = K0.c.a("eventsDroppedCount").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f16223c = K0.c.a("reason").b(N0.a.b().c(3).a()).a();

        private c() {
        }

        /* renamed from: b */
        public void a(C1885c cVar, K0.e eVar) {
            eVar.c(f16222b, cVar.a());
            eVar.a(f16223c, cVar.b());
        }
    }

    /* renamed from: r.a$d */
    private static final class d implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final d f16224a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16225b = K0.c.a("logSource").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f16226c = K0.c.a("logEventDropped").b(N0.a.b().c(2).a()).a();

        private d() {
        }

        /* renamed from: b */
        public void a(u.d dVar, K0.e eVar) {
            eVar.a(f16225b, dVar.b());
            eVar.a(f16226c, dVar.a());
        }
    }

    /* renamed from: r.a$e */
    private static final class e implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final e f16227a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16228b = K0.c.d("clientMetrics");

        private e() {
        }

        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.a.a(obj);
            b((m) null, (K0.e) obj2);
        }

        public void b(m mVar, K0.e eVar) {
            throw null;
        }
    }

    /* renamed from: r.a$f */
    private static final class f implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final f f16229a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16230b = K0.c.a("currentCacheSizeBytes").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f16231c = K0.c.a("maxCacheSizeBytes").b(N0.a.b().c(2).a()).a();

        private f() {
        }

        /* renamed from: b */
        public void a(u.e eVar, K0.e eVar2) {
            eVar2.c(f16230b, eVar.a());
            eVar2.c(f16231c, eVar.b());
        }
    }

    /* renamed from: r.a$g */
    private static final class g implements K0.d {

        /* renamed from: a  reason: collision with root package name */
        static final g f16232a = new g();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f16233b = K0.c.a("startMs").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f16234c = K0.c.a("endMs").b(N0.a.b().c(2).a()).a();

        private g() {
        }

        /* renamed from: b */
        public void a(u.f fVar, K0.e eVar) {
            eVar.c(f16233b, fVar.b());
            eVar.c(f16234c, fVar.a());
        }
    }

    private C1780a() {
    }

    public void a(L0.b bVar) {
        bVar.a(m.class, e.f16227a);
        bVar.a(C1883a.class, C0161a.f16214a);
        bVar.a(u.f.class, g.f16232a);
        bVar.a(u.d.class, d.f16224a);
        bVar.a(C1885c.class, c.f16221a);
        bVar.a(C1884b.class, b.f16219a);
        bVar.a(u.e.class, f.f16229a);
    }
}
