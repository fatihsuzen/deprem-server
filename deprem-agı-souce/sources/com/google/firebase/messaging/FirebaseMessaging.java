package com.google.firebase.messaging;

import J.C0645a;
import N.C0722p;
import O0.d;
import R0.b;
import S0.e;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.a0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;
import o0.C1729b;
import o0.f;
import p.j;
import p0.C1748a;

public class FirebaseMessaging {

    /* renamed from: l  reason: collision with root package name */
    private static final long f7278l = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: m  reason: collision with root package name */
    private static a0 f7279m;

    /* renamed from: n  reason: collision with root package name */
    static b f7280n = new r();

    /* renamed from: o  reason: collision with root package name */
    static ScheduledExecutorService f7281o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f7282a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7283b;

    /* renamed from: c  reason: collision with root package name */
    private final D f7284c;

    /* renamed from: d  reason: collision with root package name */
    private final V f7285d;

    /* renamed from: e  reason: collision with root package name */
    private final a f7286e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f7287f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f7288g;

    /* renamed from: h  reason: collision with root package name */
    private final C1698l f7289h;

    /* renamed from: i  reason: collision with root package name */
    private final I f7290i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7291j;

    /* renamed from: k  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f7292k;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private final d f7293a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7294b;

        /* renamed from: c  reason: collision with root package name */
        private O0.b f7295c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f7296d;

        a(d dVar) {
            this.f7293a = dVar;
        }

        public static /* synthetic */ void a(a aVar, O0.a aVar2) {
            if (aVar.c()) {
                FirebaseMessaging.this.B();
            }
        }

        private Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context k5 = FirebaseMessaging.this.f7282a.k();
            SharedPreferences sharedPreferences = k5.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = k5.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(k5.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void b() {
            try {
                if (!this.f7294b) {
                    Boolean d5 = d();
                    this.f7296d = d5;
                    if (d5 == null) {
                        A a5 = new A(this);
                        this.f7295c = a5;
                        this.f7293a.b(C1729b.class, a5);
                    }
                    this.f7294b = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            boolean z4;
            try {
                b();
                Boolean bool = this.f7296d;
                if (bool != null) {
                    z4 = bool.booleanValue();
                } else {
                    z4 = FirebaseMessaging.this.f7282a.t();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return z4;
        }
    }

    FirebaseMessaging(f fVar, Q0.a aVar, b bVar, b bVar2, e eVar, b bVar3, d dVar) {
        this(fVar, aVar, bVar, bVar2, eVar, bVar3, dVar, new I(fVar.k()));
    }

    private synchronized void A() {
        if (!this.f7291j) {
            C(0);
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        if (D(r())) {
            A();
        }
    }

    public static /* synthetic */ C1698l a(FirebaseMessaging firebaseMessaging, String str, a0.a aVar, String str2) {
        o(firebaseMessaging.f7283b).f(firebaseMessaging.p(), str, str2, firebaseMessaging.f7290i.a());
        if (aVar == null || !str2.equals(aVar.f7381a)) {
            firebaseMessaging.v(str2);
        }
        return C1701o.e(str2);
    }

    public static /* synthetic */ void b(FirebaseMessaging firebaseMessaging) {
        if (firebaseMessaging.w()) {
            firebaseMessaging.B();
        }
    }

    public static /* synthetic */ void c(FirebaseMessaging firebaseMessaging, C1699m mVar) {
        firebaseMessaging.getClass();
        try {
            mVar.c(firebaseMessaging.k());
        } catch (Exception e5) {
            mVar.b(e5);
        }
    }

    public static /* synthetic */ j d() {
        return null;
    }

    public static /* synthetic */ void f(FirebaseMessaging firebaseMessaging, C0645a aVar) {
        firebaseMessaging.getClass();
        if (aVar != null) {
            H.y(aVar.c());
            firebaseMessaging.t();
        }
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) fVar.j(FirebaseMessaging.class);
            C0722p.l(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public static /* synthetic */ void h(FirebaseMessaging firebaseMessaging, f0 f0Var) {
        if (firebaseMessaging.w()) {
            f0Var.n();
        }
    }

    public static synchronized FirebaseMessaging n() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(f.l());
        }
        return instance;
    }

    private static synchronized a0 o(Context context) {
        a0 a0Var;
        synchronized (FirebaseMessaging.class) {
            try {
                if (f7279m == null) {
                    f7279m = new a0(context);
                }
                a0Var = f7279m;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return a0Var;
    }

    private String p() {
        if ("[DEFAULT]".equals(this.f7282a.m())) {
            return "";
        }
        return this.f7282a.o();
    }

    public static j s() {
        return (j) f7280n.get();
    }

    private void t() {
        this.f7284c.e().f(this.f7287f, new C1574x(this));
    }

    /* access modifiers changed from: private */
    public void u() {
        O.c(this.f7283b);
        Q.f(this.f7283b, this.f7284c, z());
        if (z()) {
            t();
        }
    }

    private void v(String str) {
        if ("[DEFAULT]".equals(this.f7282a.m())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f7282a.m());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C1565n(this.f7283b).g(intent);
        }
    }

    private boolean z() {
        O.c(this.f7283b);
        if (!O.d(this.f7283b)) {
            return false;
        }
        if (this.f7282a.j(C1748a.class) != null) {
            return true;
        }
        if (!H.a() || f7280n == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void C(long j5) {
        l(new b0(this, Math.min(Math.max(30, 2 * j5), f7278l)), j5);
        this.f7291j = true;
    }

    /* access modifiers changed from: package-private */
    public boolean D(a0.a aVar) {
        if (aVar == null || aVar.b(this.f7290i.a())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String k() {
        a0.a r5 = r();
        if (!D(r5)) {
            return r5.f7381a;
        }
        String c5 = I.c(this.f7282a);
        try {
            return (String) C1701o.a(this.f7285d.b(c5, new C1575y(this, c5, r5)));
        } catch (InterruptedException | ExecutionException e5) {
            throw new IOException(e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Runnable runnable, long j5) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f7281o == null) {
                    f7281o = new ScheduledThreadPoolExecutor(1, new S.a("TAG"));
                }
                f7281o.schedule(runnable, j5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Context m() {
        return this.f7283b;
    }

    public C1698l q() {
        C1699m mVar = new C1699m();
        this.f7287f.execute(new C1573w(this, mVar));
        return mVar.a();
    }

    /* access modifiers changed from: package-private */
    public a0.a r() {
        return o(this.f7283b).d(p(), I.c(this.f7282a));
    }

    public boolean w() {
        return this.f7286e.c();
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f7290i.g();
    }

    /* access modifiers changed from: package-private */
    public synchronized void y(boolean z4) {
        this.f7291j = z4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FirebaseMessaging(o0.f r11, Q0.a r12, R0.b r13, R0.b r14, S0.e r15, R0.b r16, O0.d r17, com.google.firebase.messaging.I r18) {
        /*
            r10 = this;
            com.google.firebase.messaging.D r0 = new com.google.firebase.messaging.D
            r1 = r11
            r3 = r13
            r4 = r14
            r5 = r15
            r2 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.concurrent.ExecutorService r7 = com.google.firebase.messaging.C1566o.f()
            java.util.concurrent.ScheduledExecutorService r8 = com.google.firebase.messaging.C1566o.c()
            java.util.concurrent.Executor r9 = com.google.firebase.messaging.C1566o.b()
            r2 = r12
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r0
            r0 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging.<init>(o0.f, Q0.a, R0.b, R0.b, S0.e, R0.b, O0.d, com.google.firebase.messaging.I):void");
    }

    FirebaseMessaging(f fVar, Q0.a aVar, b bVar, d dVar, I i5, D d5, Executor executor, Executor executor2, Executor executor3) {
        this.f7291j = false;
        f7280n = bVar;
        this.f7282a = fVar;
        this.f7286e = new a(dVar);
        Context k5 = fVar.k();
        this.f7283b = k5;
        C1568q qVar = new C1568q();
        this.f7292k = qVar;
        this.f7290i = i5;
        this.f7284c = d5;
        this.f7285d = new V(executor);
        this.f7287f = executor2;
        this.f7288g = executor3;
        Context k6 = fVar.k();
        if (k6 instanceof Application) {
            ((Application) k6).registerActivityLifecycleCallbacks(qVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + k6 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new C1569s(this));
        }
        executor2.execute(new C1570t(this));
        C1698l e5 = f0.e(this, i5, d5, k5, C1566o.g());
        this.f7289h = e5;
        e5.f(executor2, new C1571u(this));
        executor2.execute(new C1572v(this));
    }
}
