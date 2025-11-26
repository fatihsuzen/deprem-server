package L3;

import H3.b;
import j3.C2582a;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;
import r3.C2733c;

/* renamed from: L3.t  reason: case insensitive filesystem */
final class C2113t implements S0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f18585a;

    /* renamed from: b  reason: collision with root package name */
    private final C2117v f18586b = new C2117v();

    /* renamed from: L3.t$a */
    public static final class a implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2113t f18587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2733c f18588b;

        public a(C2113t tVar, C2733c cVar) {
            this.f18587a = tVar;
            this.f18588b = cVar;
        }

        public final Object invoke() {
            return new C2100m((b) this.f18587a.b().invoke(this.f18588b));
        }
    }

    public C2113t(l lVar) {
        t.e(lVar, "compute");
        this.f18585a = lVar;
    }

    public b a(C2733c cVar) {
        t.e(cVar, "key");
        Object a5 = this.f18586b.get(C2582a.a(cVar));
        t.d(a5, "get(...)");
        C2101m0 m0Var = (C2101m0) a5;
        Object obj = m0Var.f18560a.get();
        if (obj == null) {
            obj = m0Var.a(new a(this, cVar));
        }
        return ((C2100m) obj).f18559a;
    }

    public final l b() {
        return this.f18585a;
    }
}
