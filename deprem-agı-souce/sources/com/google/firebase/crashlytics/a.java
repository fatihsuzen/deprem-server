package com.google.firebase.crashlytics;

import C0.b;
import S0.e;
import android.content.Context;
import android.content.pm.PackageManager;
import c1.C1045b;
import java.util.List;
import java.util.concurrent.ExecutorService;
import o0.f;
import t0.C1882d;
import u0.C1889d;
import u0.C1891f;
import u0.g;
import u0.l;
import x0.C1906b;
import x0.C1911g;
import x0.C1914j;
import x0.C1918n;
import x0.C1927x;
import x0.D;
import x0.I;
import y0.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final C1927x f7226a;

    private a(C1927x xVar) {
        this.f7226a = xVar;
    }

    public static a b() {
        a aVar = (a) f.l().j(a.class);
        if (aVar != null) {
            return aVar;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    static a c(f fVar, e eVar, R0.a aVar, R0.a aVar2, R0.a aVar3, ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3) {
        Context k5 = fVar.k();
        String packageName = k5.getPackageName();
        g f5 = g.f();
        f5.g("Initializing Firebase Crashlytics " + C1927x.k() + " for " + packageName);
        i iVar = new i(executorService, executorService2);
        D0.g gVar = new D0.g(k5);
        f fVar2 = fVar;
        D d5 = new D(fVar2);
        I i5 = new I(k5, packageName, eVar, d5);
        C1889d dVar = new C1889d(aVar);
        C1882d dVar2 = new C1882d(aVar2);
        C1918n nVar = new C1918n(d5, gVar);
        C1045b.e(nVar);
        I i6 = i5;
        C1927x xVar = new C1927x(fVar2, i6, dVar, d5, dVar2.e(), dVar2.d(), gVar, nVar, new l(aVar3), iVar);
        String c5 = fVar.n().c();
        String m5 = C1914j.m(k5);
        List<C1911g> j5 = C1914j.j(k5);
        g f6 = g.f();
        f6.b("Mapping file ID is: " + m5);
        for (C1911g gVar2 : j5) {
            g.f().b(String.format("Build id for %s on %s: %s", new Object[]{gVar2.c(), gVar2.a(), gVar2.b()}));
        }
        Context context = k5;
        String str = c5;
        I i7 = i5;
        try {
            C1906b a5 = C1906b.a(context, i7, str, m5, j5, new C1891f(k5));
            g f7 = g.f();
            f7.i("Installer package name is: " + a5.f16844d);
            F0.g l5 = F0.g.l(context, str, i7, new b(), a5.f16846f, a5.f16847g, gVar, d5);
            l5.p(iVar).d(executorService3, new t0.g());
            if (xVar.p(a5, l5)) {
                xVar.i(l5);
            }
            return new a(xVar);
        } catch (PackageManager.NameNotFoundException e5) {
            g.f().e("Error retrieving app package info.", e5);
            return null;
        }
    }

    public void d(boolean z4) {
        this.f7226a.q(Boolean.valueOf(z4));
    }
}
