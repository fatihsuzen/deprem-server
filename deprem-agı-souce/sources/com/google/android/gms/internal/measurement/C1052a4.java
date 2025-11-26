package com.google.android.gms.internal.measurement;

import l0.g;

/* renamed from: com.google.android.gms.internal.measurement.a4  reason: case insensitive filesystem */
public abstract class C1052a4 {

    /* renamed from: a  reason: collision with root package name */
    static volatile g f5298a = g.a();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5299b = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        if ("com.google.android.gms".equals(r0.packageName) != false) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r0 = "com.google.android.gms.phenotype"
            java.lang.String r6 = r6.getAuthority()
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L_0x001d
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            java.lang.String r0 = "PhenotypeClientHelper"
            java.lang.String r5 = r5.concat(r6)
            android.util.Log.e(r0, r5)
            return r1
        L_0x001d:
            l0.g r6 = f5298a
            boolean r6 = r6.c()
            if (r6 == 0) goto L_0x0032
            l0.g r5 = f5298a
            java.lang.Object r5 = r5.b()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L_0x0032:
            java.lang.Object r6 = f5299b
            monitor-enter(r6)
            l0.g r0 = f5298a     // Catch:{ all -> 0x004b }
            boolean r0 = r0.c()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x004d
            l0.g r5 = f5298a     // Catch:{ all -> 0x004b }
            java.lang.Object r5 = r5.b()     // Catch:{ all -> 0x004b }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x004b }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x004b }
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            return r5
        L_0x004b:
            r5 = move-exception
            goto L_0x00a2
        L_0x004d:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x004b }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0079
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ all -> 0x004b }
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x004b }
            r4 = 29
            if (r3 >= r4) goto L_0x0067
            r3 = r1
            goto L_0x0069
        L_0x0067:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0069:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x008a
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch:{ all -> 0x004b }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x008a
        L_0x0079:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x004b }
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x008a }
            int r5 = r5.flags     // Catch:{ all -> 0x004b }
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L_0x008a
            r1 = 1
        L_0x008a:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x004b }
            l0.g r5 = l0.g.d(r5)     // Catch:{ all -> 0x004b }
            f5298a = r5     // Catch:{ all -> 0x004b }
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            l0.g r5 = f5298a
            java.lang.Object r5 = r5.b()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L_0x00a2:
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1052a4.a(android.content.Context, android.net.Uri):boolean");
    }
}
