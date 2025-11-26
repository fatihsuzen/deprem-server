package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.L0;
import f0.C1635C;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.l4  reason: case insensitive filesystem */
final class C1369l4 implements Application.ActivityLifecycleCallbacks, C1635C {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6534a;

    C1369l4(C1452x4 x4Var) {
        Objects.requireNonNull(x4Var);
        this.f6534a = x4Var;
    }

    public final void a(L0 l02) {
        X2 x22 = this.f6534a.f5730a;
        x22.I().x(l02);
        N5 z4 = x22.z();
        X2 x23 = z4.f5730a;
        x23.b().t(new F5(z4, x23.f().elapsedRealtime()));
    }

    public final void b(L0 l02) {
        this.f6534a.f5730a.I().z(l02);
    }

    public final void c(L0 l02, Bundle bundle) {
        this.f6534a.f5730a.I().y(l02, bundle);
    }

    public final void d(L0 l02) {
        X2 x22 = this.f6534a.f5730a;
        N5 z4 = x22.z();
        X2 x23 = z4.f5730a;
        x23.b().t(new E5(z4, x23.f().elapsedRealtime()));
        x22.I().w(l02);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f A[Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0082 A[Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(com.google.android.gms.internal.measurement.L0 r8, android.os.Bundle r9) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.x4 r0 = r7.f6534a     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            com.google.android.gms.measurement.internal.X2 r1 = r0.f5730a     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            java.lang.String r3 = "onActivityCreated"
            r2.a(r3)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            android.content.Intent r2 = r8.f5013c     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r2 == 0) goto L_0x004c
            android.net.Uri r3 = r2.getData()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r3 == 0) goto L_0x002c
            boolean r4 = r3.isHierarchical()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r4 != 0) goto L_0x0022
            goto L_0x002c
        L_0x0022:
            r4 = r3
            goto L_0x0044
        L_0x0024:
            r0 = move-exception
            r2 = r7
            goto L_0x00b6
        L_0x0028:
            r0 = move-exception
            r2 = r7
            goto L_0x00a0
        L_0x002c:
            android.os.Bundle r3 = r2.getExtras()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            r4 = 0
            if (r3 == 0) goto L_0x0044
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r5 != 0) goto L_0x0044
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            goto L_0x0022
        L_0x0044:
            if (r4 == 0) goto L_0x004c
            boolean r3 = r4.isHierarchical()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r3 != 0) goto L_0x004e
        L_0x004c:
            r2 = r7
            goto L_0x0096
        L_0x004e:
            r1.C()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            java.lang.String r0 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r2.getStringExtra(r0)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            java.lang.String r2 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r2 = r2.equals(r0)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r2 != 0) goto L_0x0074
            java.lang.String r2 = "https://www.google.com"
            boolean r2 = r2.equals(r0)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r2 != 0) goto L_0x0074
            java.lang.String r2 = "android-app://com.google.appcrawler"
            boolean r0 = r2.equals(r0)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r0 == 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            java.lang.String r0 = "auto"
        L_0x0072:
            r5 = r0
            goto L_0x0077
        L_0x0074:
            java.lang.String r0 = "gs"
            goto L_0x0072
        L_0x0077:
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            if (r9 != 0) goto L_0x0082
            r0 = 1
        L_0x0080:
            r3 = r0
            goto L_0x0084
        L_0x0082:
            r0 = 0
            goto L_0x0080
        L_0x0084:
            com.google.android.gms.measurement.internal.T2 r0 = r1.b()     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            com.google.android.gms.measurement.internal.k4 r1 = new com.google.android.gms.measurement.internal.k4     // Catch:{ RuntimeException -> 0x0028, all -> 0x0024 }
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ RuntimeException -> 0x0094 }
            r0.t(r1)     // Catch:{ RuntimeException -> 0x0094 }
            goto L_0x00b1
        L_0x0092:
            r0 = move-exception
            goto L_0x00b6
        L_0x0094:
            r0 = move-exception
            goto L_0x00a0
        L_0x0096:
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
        L_0x0098:
            com.google.android.gms.measurement.internal.M4 r0 = r0.I()
            r0.v(r8, r9)
            return
        L_0x00a0:
            com.google.android.gms.measurement.internal.x4 r1 = r2.f6534a     // Catch:{ all -> 0x0092 }
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a     // Catch:{ all -> 0x0092 }
            com.google.android.gms.measurement.internal.q2 r1 = r1.a()     // Catch:{ all -> 0x0092 }
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r1.b(r3, r0)     // Catch:{ all -> 0x0092 }
        L_0x00b1:
            com.google.android.gms.measurement.internal.x4 r0 = r2.f6534a
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            goto L_0x0098
        L_0x00b6:
            com.google.android.gms.measurement.internal.x4 r1 = r2.f6534a
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a
            com.google.android.gms.measurement.internal.M4 r1 = r1.I()
            r1.v(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1369l4.e(com.google.android.gms.internal.measurement.L0, android.os.Bundle):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        e(L0.c(activity), bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        b(L0.c(activity));
    }

    public final void onActivityPaused(Activity activity) {
        a(L0.c(activity));
    }

    public final void onActivityResumed(Activity activity) {
        d(L0.c(activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        c(L0.c(activity), bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
