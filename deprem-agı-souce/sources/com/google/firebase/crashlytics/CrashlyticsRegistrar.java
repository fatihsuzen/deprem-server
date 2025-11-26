package com.google.firebase.crashlytics;

import S0.e;
import Z0.h;
import a1.C1001a;
import c1.C1045b;
import c1.C1046c;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import o0.f;
import p0.C1748a;
import q0.C1756a;
import q0.b;
import q0.c;
import r0.C1786c;
import r0.C1788e;
import r0.F;
import r0.r;
import u0.C1886a;
import u0.g;
import y0.i;

public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    private final F f7223a;

    /* renamed from: b  reason: collision with root package name */
    private final F f7224b;

    /* renamed from: c  reason: collision with root package name */
    private final F f7225c;

    static {
        C1045b.a(C1046c.a.CRASHLYTICS);
    }

    public CrashlyticsRegistrar() {
        Class<ExecutorService> cls = ExecutorService.class;
        this.f7223a = F.a(C1756a.class, cls);
        this.f7224b = F.a(b.class, cls);
        this.f7225c = F.a(c.class, cls);
    }

    /* access modifiers changed from: private */
    public a b(C1788e eVar) {
        i.f(false);
        long currentTimeMillis = System.currentTimeMillis();
        a c5 = a.c((f) eVar.a(f.class), (e) eVar.a(e.class), eVar.i(C1886a.class), eVar.i(C1748a.class), eVar.i(C1001a.class), (ExecutorService) eVar.e(this.f7223a), (ExecutorService) eVar.e(this.f7224b), (ExecutorService) eVar.e(this.f7225c));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 16) {
            g f5 = g.f();
            f5.b("Initializing Crashlytics blocked main for " + currentTimeMillis2 + " ms");
        }
        return c5;
    }

    public List getComponents() {
        return Arrays.asList(new C1786c[]{C1786c.c(a.class).h("fire-cls").b(r.k(f.class)).b(r.k(e.class)).b(r.l(this.f7223a)).b(r.l(this.f7224b)).b(r.l(this.f7225c)).b(r.a(C1886a.class)).b(r.a(C1748a.class)).b(r.a(C1001a.class)).f(new t0.f(this)).e().d(), h.b("fire-cls", "20.0.3")});
    }
}
