package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.work.WorkRequest;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import e0.C1626a;
import f0.C1644L;
import f0.C1661p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.measurement.v1  reason: case insensitive filesystem */
public final class C1237v1 {

    /* renamed from: j  reason: collision with root package name */
    private static volatile C1237v1 f5598j;

    /* renamed from: a  reason: collision with root package name */
    private final String f5599a = "FA";

    /* renamed from: b  reason: collision with root package name */
    protected final d f5600b = g.b();

    /* renamed from: c  reason: collision with root package name */
    protected final ExecutorService f5601c;

    /* renamed from: d  reason: collision with root package name */
    private final C1626a f5602d;

    /* renamed from: e  reason: collision with root package name */
    private final List f5603e;

    /* renamed from: f  reason: collision with root package name */
    private int f5604f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5605g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5606h;

    /* renamed from: i  reason: collision with root package name */
    private volatile C1245w0 f5607i;

    protected C1237v1(Context context, Bundle bundle) {
        C1200r0.a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1103g1(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f5601c = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f5602d = new C1626a(this);
        this.f5603e = new ArrayList();
        try {
            if (C1644L.a(context, "google_app_id", C1661p.a(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, C1237v1.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.f5606h = null;
                    this.f5605g = true;
                    Log.w(this.f5599a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        this.f5606h = "fa";
        f(new T0(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f5599a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new C1228u1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void f(C1139k1 k1Var) {
        this.f5601c.execute(k1Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void g(Exception exc, boolean z4, boolean z5) {
        Exception exc2;
        C1237v1 v1Var;
        this.f5605g |= z4;
        if (z4) {
            Log.w(this.f5599a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z5) {
            v1Var = this;
            exc2 = exc;
            v1Var.d(5, "Error with data collection. Data lost.", exc2, (Object) null, (Object) null);
        } else {
            v1Var = this;
            exc2 = exc;
        }
        Log.w(v1Var.f5599a, "Error with data collection. Data lost.", exc2);
    }

    private final void n(String str, String str2, Bundle bundle, boolean z4, boolean z5, Long l5) {
        f(new C1130j1(this, l5, str, str2, bundle, z4, z5));
    }

    public static C1237v1 o(Context context, Bundle bundle) {
        C0722p.k(context);
        if (f5598j == null) {
            synchronized (C1237v1.class) {
                try {
                    if (f5598j == null) {
                        f5598j = new C1237v1(context, bundle);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5598j;
    }

    public final void A(String str) {
        f(new U0(this, str));
    }

    public final void B(String str) {
        f(new V0(this, str));
    }

    public final void C(Runnable runnable) {
        f(new X0(this, runnable));
    }

    public final String D() {
        C1218t0 t0Var = new C1218t0();
        f(new Y0(this, t0Var));
        return t0Var.j(500);
    }

    public final String E() {
        C1218t0 t0Var = new C1218t0();
        f(new Z0(this, t0Var));
        return t0Var.j(50);
    }

    public final long F() {
        C1218t0 t0Var = new C1218t0();
        f(new C1049a1(this, t0Var));
        Long k5 = t0Var.k(500);
        if (k5 != null) {
            return k5.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f5600b.currentTimeMillis()).nextLong();
        int i5 = this.f5604f + 1;
        this.f5604f = i5;
        return nextLong + ((long) i5);
    }

    public final String a() {
        C1218t0 t0Var = new C1218t0();
        f(new C1058b1(this, t0Var));
        return t0Var.j(500);
    }

    public final String b() {
        C1218t0 t0Var = new C1218t0();
        f(new C1076d1(this, t0Var));
        return t0Var.j(500);
    }

    public final Map c(String str, String str2, boolean z4) {
        C1218t0 t0Var = new C1218t0();
        f(new C1085e1(this, str, str2, z4, t0Var));
        Bundle q02 = t0Var.q0(5000);
        if (q02 == null || q02.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(q02.size());
        for (String next : q02.keySet()) {
            Object obj = q02.get(next);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void d(int i5, String str, Object obj, Object obj2, Object obj3) {
        f(new C1094f1(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final int e(String str) {
        C1218t0 t0Var = new C1218t0();
        f(new C1112h1(this, str, t0Var));
        Integer num = (Integer) C1218t0.r0(t0Var.q0(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String h() {
        return this.f5599a;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean i() {
        return this.f5605g;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1245w0 j() {
        return this.f5607i;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void k(C1245w0 w0Var) {
        this.f5607i = w0Var;
    }

    public final C1626a p() {
        return this.f5602d;
    }

    /* access modifiers changed from: protected */
    public final C1245w0 q(Context context, boolean z4) {
        DynamiteModule.b bVar;
        if (z4) {
            try {
                bVar = DynamiteModule.f4900e;
            } catch (DynamiteModule.a e5) {
                g(e5, true, false);
                return null;
            }
        } else {
            bVar = DynamiteModule.f4898c;
        }
        return C1236v0.asInterface(DynamiteModule.e(context, bVar, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r3.f5607i == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.f5607i.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        android.util.Log.w(r3.f5599a, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        l(new com.google.android.gms.internal.measurement.C1121i1(r3, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(f0.C1634B r4) {
        /*
            r3 = this;
            N.C0722p.k(r4)
            java.util.List r0 = r3.f5603e
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            int r2 = r0.size()     // Catch:{ all -> 0x0024 }
            if (r1 >= r2) goto L_0x0029
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x0024 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0024 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0024 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r4 = r3.f5599a     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r4 = move-exception
            goto L_0x0051
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0029:
            com.google.android.gms.internal.measurement.l1 r1 = new com.google.android.gms.internal.measurement.l1     // Catch:{ all -> 0x0024 }
            r1.<init>(r4)     // Catch:{ all -> 0x0024 }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x0024 }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            com.google.android.gms.internal.measurement.w0 r4 = r3.f5607i
            if (r4 == 0) goto L_0x0048
            com.google.android.gms.internal.measurement.w0 r4 = r3.f5607i     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0041 }
            r4.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0041 }
            return
        L_0x0041:
            java.lang.String r4 = r3.f5599a
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r4, r0)
        L_0x0048:
            com.google.android.gms.internal.measurement.i1 r4 = new com.google.android.gms.internal.measurement.i1
            r4.<init>(r3, r1)
            r3.f(r4)
            return
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1237v1.r(f0.B):void");
    }

    public final void s(String str, Bundle bundle) {
        n((String) null, str, bundle, false, true, (Long) null);
    }

    public final void t(String str, String str2, Bundle bundle) {
        n(str, str2, bundle, true, true, (Long) null);
    }

    public final void u(String str, String str2, Object obj, boolean z4) {
        f(new N0(this, str, str2, obj, z4));
    }

    public final void v(Bundle bundle) {
        f(new O0(this, bundle));
    }

    public final void w(String str, String str2, Bundle bundle) {
        f(new P0(this, str, str2, bundle));
    }

    public final List x(String str, String str2) {
        C1218t0 t0Var = new C1218t0();
        f(new Q0(this, str, str2, t0Var));
        List list = (List) C1218t0.r0(t0Var.q0(5000), List.class);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

    public final void y(L0 l02, String str, String str2) {
        f(new R0(this, l02, str, str2));
    }

    public final void z(Boolean bool) {
        f(new S0(this, bool));
    }
}
