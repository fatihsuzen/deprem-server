package x0;

import D0.g;
import F0.j;
import G0.a;
import G0.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C1698l;
import o0.f;
import u0.C1886a;
import u0.l;
import v0.C1893a;
import w0.b;
import y0.i;
import z0.C1977f;
import z0.n;

/* renamed from: x0.x  reason: case insensitive filesystem */
public class C1927x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16938a;

    /* renamed from: b  reason: collision with root package name */
    private final f f16939b;

    /* renamed from: c  reason: collision with root package name */
    private final D f16940c;

    /* renamed from: d  reason: collision with root package name */
    private final N f16941d = new N();

    /* renamed from: e  reason: collision with root package name */
    private final long f16942e = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    private C1928y f16943f;

    /* renamed from: g  reason: collision with root package name */
    private C1928y f16944g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16945h;

    /* renamed from: i  reason: collision with root package name */
    private C1921q f16946i;

    /* renamed from: j  reason: collision with root package name */
    private final I f16947j;

    /* renamed from: k  reason: collision with root package name */
    private final g f16948k;

    /* renamed from: l  reason: collision with root package name */
    public final b f16949l;

    /* renamed from: m  reason: collision with root package name */
    private final C1893a f16950m;

    /* renamed from: n  reason: collision with root package name */
    private final C1918n f16951n;

    /* renamed from: o  reason: collision with root package name */
    private final C1886a f16952o;

    /* renamed from: p  reason: collision with root package name */
    private final l f16953p;

    /* renamed from: q  reason: collision with root package name */
    private final i f16954q;

    public C1927x(f fVar, I i5, C1886a aVar, D d5, b bVar, C1893a aVar2, g gVar, C1918n nVar, l lVar, i iVar) {
        this.f16939b = fVar;
        this.f16940c = d5;
        this.f16938a = fVar.k();
        this.f16947j = i5;
        this.f16952o = aVar;
        this.f16949l = bVar;
        this.f16950m = aVar2;
        this.f16948k = gVar;
        this.f16951n = nVar;
        this.f16953p = lVar;
        this.f16954q = iVar;
    }

    private void f() {
        try {
            this.f16945h = Boolean.TRUE.equals((Boolean) this.f16954q.f17084a.c().submit(new C1922s(this)).get(3, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.f16945h = false;
        }
    }

    /* access modifiers changed from: private */
    public void h(j jVar) {
        i.c();
        o();
        try {
            this.f16949l.a(new C1924u(this));
            this.f16946i.Q();
            if (jVar.b().f2422b.f2429a) {
                if (!this.f16946i.y(jVar)) {
                    u0.g.f().k("Previous sessions could not be finalized.");
                }
                this.f16946i.S(jVar.a());
                n();
                return;
            }
            u0.g.f().b("Collection of crash reports disabled in Crashlytics settings.");
            throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
        } catch (Exception e5) {
            u0.g.f().e("Crashlytics encountered a problem during asynchronous initialization.", e5);
            n();
        } catch (Throwable th) {
            n();
            throw th;
        }
    }

    private void j(j jVar) {
        Future<?> submit = this.f16954q.f17084a.c().submit(new C1923t(this, jVar));
        u0.g.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e5) {
            u0.g.f().e("Crashlytics was interrupted during initialization.", e5);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e6) {
            u0.g.f().e("Crashlytics encountered a problem during initialization.", e6);
        } catch (TimeoutException e7) {
            u0.g.f().e("Crashlytics timed out during initialization.", e7);
        }
    }

    public static String k() {
        return "20.0.3";
    }

    static boolean l(String str, boolean z4) {
        if (!z4) {
            u0.g.f().i("Configured not to require a build ID.");
            return true;
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        } else {
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".     |  | ");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".   \\ |  | /");
            Log.e("FirebaseCrashlytics", ".    \\    /");
            Log.e("FirebaseCrashlytics", ".     \\  /");
            Log.e("FirebaseCrashlytics", ".      \\/");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".      /\\");
            Log.e("FirebaseCrashlytics", ".     /  \\");
            Log.e("FirebaseCrashlytics", ".    /    \\");
            Log.e("FirebaseCrashlytics", ".   / |  | \\");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f16943f.c();
    }

    public C1698l i(j jVar) {
        return this.f16954q.f17084a.d(new r(this, jVar));
    }

    public void m(String str) {
        this.f16954q.f17084a.d(new C1925v(this, System.currentTimeMillis() - this.f16942e, str));
    }

    /* access modifiers changed from: package-private */
    public void n() {
        i.c();
        try {
            if (!this.f16943f.d()) {
                u0.g.f().k("Initialization marker file was not properly removed.");
            }
        } catch (Exception e5) {
            u0.g.f().e("Problem encountered deleting Crashlytics initialization marker.", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void o() {
        i.c();
        this.f16943f.a();
        u0.g.f().i("Initialization marker file was created.");
    }

    public boolean p(C1906b bVar, j jVar) {
        C1906b bVar2 = bVar;
        if (l(bVar2.f16842b, C1914j.i(this.f16938a, "com.crashlytics.RequireBuildId", true))) {
            String c5 = new C1913i().c();
            try {
                this.f16944g = new C1928y("crash_marker", this.f16948k);
                this.f16943f = new C1928y("initialization_marker", this.f16948k);
                n nVar = new n(c5, this.f16948k, this.f16954q);
                C1977f fVar = new C1977f(this.f16948k);
                a aVar = new a(1024, new c(10));
                this.f16953p.b(nVar);
                j jVar2 = jVar;
                Z j5 = Z.j(this.f16938a, this.f16947j, this.f16948k, bVar2, fVar, nVar, aVar, jVar2, this.f16941d, this.f16951n, this.f16954q);
                Context context = this.f16938a;
                I i5 = this.f16947j;
                D d5 = this.f16940c;
                g gVar = this.f16948k;
                C1928y yVar = this.f16944g;
                I i6 = i5;
                D d6 = d5;
                g gVar2 = gVar;
                C1928y yVar2 = yVar;
                this.f16946i = new C1921q(context, i6, d6, gVar2, yVar2, bVar, nVar, fVar, j5, this.f16952o, this.f16950m, this.f16951n, this.f16954q);
                boolean g5 = g();
                f();
                this.f16946i.w(c5, Thread.getDefaultUncaughtExceptionHandler(), jVar2);
                if (!g5 || !C1914j.d(this.f16938a)) {
                    u0.g.f().b("Successfully configured exception handler.");
                    return true;
                }
                u0.g.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                j(jVar2);
                return false;
            } catch (Exception e5) {
                u0.g.f().e("Crashlytics was not started due to an exception during initialization", e5);
                this.f16946i = null;
                return false;
            }
        } else {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
    }

    public void q(Boolean bool) {
        this.f16940c.h(bool);
    }
}
