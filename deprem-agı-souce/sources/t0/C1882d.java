package t0;

import R0.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p0.C1748a;
import u0.g;
import v0.C1893a;
import v0.d;
import v0.e;
import v0.f;
import w0.C1898a;
import w0.b;
import w0.c;

/* renamed from: t0.d  reason: case insensitive filesystem */
public class C1882d {

    /* renamed from: a  reason: collision with root package name */
    private final a f16588a;

    /* renamed from: b  reason: collision with root package name */
    private volatile C1893a f16589b;

    /* renamed from: c  reason: collision with root package name */
    private volatile b f16590c;

    /* renamed from: d  reason: collision with root package name */
    private final List f16591d;

    public C1882d(a aVar) {
        this(aVar, new c(), new f());
    }

    public static /* synthetic */ void a(C1882d dVar, R0.b bVar) {
        dVar.getClass();
        g.f().b("AnalyticsConnector now available.");
        C1748a aVar = (C1748a) bVar.get();
        e eVar = new e(aVar);
        e eVar2 = new e();
        if (g(aVar, eVar2) != null) {
            g.f().b("Registered Firebase Analytics listener.");
            d dVar2 = new d();
            v0.c cVar = new v0.c(eVar, 500, TimeUnit.MILLISECONDS);
            synchronized (dVar) {
                try {
                    for (C1898a a5 : dVar.f16591d) {
                        dVar2.a(a5);
                    }
                    eVar2.d(dVar2);
                    eVar2.e(cVar);
                    dVar.f16590c = dVar2;
                    dVar.f16589b = cVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        g.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
    }

    public static /* synthetic */ void c(C1882d dVar, C1898a aVar) {
        synchronized (dVar) {
            try {
                if (dVar.f16590c instanceof c) {
                    dVar.f16591d.add(aVar);
                }
                dVar.f16590c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        this.f16588a.a(new C1881c(this));
    }

    private static C1748a.C0158a g(C1748a aVar, e eVar) {
        C1748a.C0158a a5 = aVar.a("clx", eVar);
        if (a5 != null) {
            return a5;
        }
        g.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        C1748a.C0158a a6 = aVar.a("crash", eVar);
        if (a6 != null) {
            g.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return a6;
    }

    public C1893a d() {
        return new C1880b(this);
    }

    public b e() {
        return new C1879a(this);
    }

    public C1882d(a aVar, b bVar, C1893a aVar2) {
        this.f16588a = aVar;
        this.f16590c = bVar;
        this.f16591d = new ArrayList();
        this.f16589b = aVar2;
        f();
    }
}
