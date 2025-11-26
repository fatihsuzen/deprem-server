package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class J3 implements F3 {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f4991a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f4992b = null;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f4993c = new HashMap(16, 1.0f);

    /* renamed from: d  reason: collision with root package name */
    private final HashMap f4994d = new HashMap(16, 1.0f);

    /* renamed from: e  reason: collision with root package name */
    private final HashMap f4995e = new HashMap(16, 1.0f);

    /* renamed from: f  reason: collision with root package name */
    private final HashMap f4996f = new HashMap(16, 1.0f);

    /* renamed from: g  reason: collision with root package name */
    private Object f4997g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4998h = false;

    /* renamed from: i  reason: collision with root package name */
    private final String[] f4999i = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4 = com.google.android.gms.internal.measurement.E3.f4940a;
        r3 = r10.acquireUnstableContentProviderClient(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r3 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r10 = r3.query(r4, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r11}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        if (r10 == null) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (r10.moveToFirst() == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        r0 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
        if (r0 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00af, code lost:
        if (r0.equals((java.lang.Object) null) == false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b1, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b5, code lost:
        if (r12 != r9.f4997g) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b7, code lost:
        r9.f4992b.put(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c0, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c1, code lost:
        if (r0 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c3, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c6, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ce, code lost:
        throw new com.google.android.gms.internal.measurement.I3("ContentProvider query returned null cursor");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cf, code lost:
        if (r10 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r11.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00e2, code lost:
        throw new com.google.android.gms.internal.measurement.I3("ContentProvider query failed", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00e6, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00ee, code lost:
        throw new com.google.android.gms.internal.measurement.I3("Unable to acquire ContentProviderClient");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00ef, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(android.content.ContentResolver r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x00f2
            monitor-enter(r9)
            java.util.HashMap r12 = r9.f4992b     // Catch:{ all -> 0x002c }
            r0 = 1
            r1 = 0
            r2 = 0
            if (r12 != 0) goto L_0x0030
            java.util.concurrent.atomic.AtomicBoolean r12 = r9.f4991a     // Catch:{ all -> 0x002c }
            r12.set(r1)     // Catch:{ all -> 0x002c }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ all -> 0x002c }
            r1 = 16
            r3 = 1065353216(0x3f800000, float:1.0)
            r12.<init>(r1, r3)     // Catch:{ all -> 0x002c }
            r9.f4992b = r12     // Catch:{ all -> 0x002c }
            java.lang.Object r12 = new java.lang.Object     // Catch:{ all -> 0x002c }
            r12.<init>()     // Catch:{ all -> 0x002c }
            r9.f4997g = r12     // Catch:{ all -> 0x002c }
            android.net.Uri r12 = com.google.android.gms.internal.measurement.E3.f4940a     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.measurement.H3 r1 = new com.google.android.gms.internal.measurement.H3     // Catch:{ all -> 0x002c }
            r1.<init>(r9, r2)     // Catch:{ all -> 0x002c }
            r10.registerContentObserver(r12, r0, r1)     // Catch:{ all -> 0x002c }
            goto L_0x005a
        L_0x002c:
            r0 = move-exception
            r10 = r0
            goto L_0x00f0
        L_0x0030:
            java.util.concurrent.atomic.AtomicBoolean r12 = r9.f4991a     // Catch:{ all -> 0x002c }
            boolean r12 = r12.getAndSet(r1)     // Catch:{ all -> 0x002c }
            if (r12 == 0) goto L_0x005a
            java.util.HashMap r12 = r9.f4992b     // Catch:{ all -> 0x002c }
            r12.clear()     // Catch:{ all -> 0x002c }
            java.util.HashMap r12 = r9.f4993c     // Catch:{ all -> 0x002c }
            r12.clear()     // Catch:{ all -> 0x002c }
            java.util.HashMap r12 = r9.f4994d     // Catch:{ all -> 0x002c }
            r12.clear()     // Catch:{ all -> 0x002c }
            java.util.HashMap r12 = r9.f4995e     // Catch:{ all -> 0x002c }
            r12.clear()     // Catch:{ all -> 0x002c }
            java.util.HashMap r12 = r9.f4996f     // Catch:{ all -> 0x002c }
            r12.clear()     // Catch:{ all -> 0x002c }
            java.lang.Object r12 = new java.lang.Object     // Catch:{ all -> 0x002c }
            r12.<init>()     // Catch:{ all -> 0x002c }
            r9.f4997g = r12     // Catch:{ all -> 0x002c }
            r9.f4998h = r1     // Catch:{ all -> 0x002c }
        L_0x005a:
            java.lang.Object r12 = r9.f4997g     // Catch:{ all -> 0x002c }
            java.util.HashMap r1 = r9.f4992b     // Catch:{ all -> 0x002c }
            boolean r1 = r1.containsKey(r11)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0072
            java.util.HashMap r10 = r9.f4992b     // Catch:{ all -> 0x002c }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x002c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x002c }
            if (r10 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r10
        L_0x0070:
            monitor-exit(r9)     // Catch:{ all -> 0x002c }
            return r2
        L_0x0072:
            monitor-exit(r9)     // Catch:{ all -> 0x002c }
            android.net.Uri r4 = com.google.android.gms.internal.measurement.E3.f4940a     // Catch:{ I3 -> 0x00ef }
            android.content.ContentProviderClient r3 = r10.acquireUnstableContentProviderClient(r4)     // Catch:{ I3 -> 0x00ef }
            if (r3 == 0) goto L_0x00e7
            java.lang.String[] r7 = new java.lang.String[]{r11}     // Catch:{ RemoteException -> 0x009c }
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x009c }
            if (r10 == 0) goto L_0x00c7
            boolean r1 = r10.moveToFirst()     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x00a2
            java.lang.String r0 = r10.getString(r0)     // Catch:{ all -> 0x009f }
            r10.close()     // Catch:{ RemoteException -> 0x009c }
            r3.release()     // Catch:{ I3 -> 0x00ef }
            goto L_0x00a9
        L_0x0099:
            r0 = move-exception
            r10 = r0
            goto L_0x00e3
        L_0x009c:
            r0 = move-exception
            r10 = r0
            goto L_0x00db
        L_0x009f:
            r0 = move-exception
            r11 = r0
            goto L_0x00cf
        L_0x00a2:
            r10.close()     // Catch:{ RemoteException -> 0x009c }
            r3.release()     // Catch:{ I3 -> 0x00ef }
            r0 = r2
        L_0x00a9:
            if (r0 == 0) goto L_0x00b2
            boolean r10 = r0.equals(r2)
            if (r10 == 0) goto L_0x00b2
            r0 = r2
        L_0x00b2:
            monitor-enter(r9)
            java.lang.Object r10 = r9.f4997g     // Catch:{ all -> 0x00bd }
            if (r12 != r10) goto L_0x00c0
            java.util.HashMap r10 = r9.f4992b     // Catch:{ all -> 0x00bd }
            r10.put(r11, r0)     // Catch:{ all -> 0x00bd }
            goto L_0x00c0
        L_0x00bd:
            r0 = move-exception
            r10 = r0
            goto L_0x00c5
        L_0x00c0:
            monitor-exit(r9)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x00c4
            return r0
        L_0x00c4:
            return r2
        L_0x00c5:
            monitor-exit(r9)     // Catch:{ all -> 0x00bd }
            throw r10
        L_0x00c7:
            com.google.android.gms.internal.measurement.I3 r11 = new com.google.android.gms.internal.measurement.I3     // Catch:{ all -> 0x009f }
            java.lang.String r12 = "ContentProvider query returned null cursor"
            r11.<init>(r12)     // Catch:{ all -> 0x009f }
            throw r11     // Catch:{ all -> 0x009f }
        L_0x00cf:
            if (r10 == 0) goto L_0x00da
            r10.close()     // Catch:{ all -> 0x00d5 }
            goto L_0x00da
        L_0x00d5:
            r0 = move-exception
            r10 = r0
            r11.addSuppressed(r10)     // Catch:{ RemoteException -> 0x009c }
        L_0x00da:
            throw r11     // Catch:{ RemoteException -> 0x009c }
        L_0x00db:
            com.google.android.gms.internal.measurement.I3 r11 = new com.google.android.gms.internal.measurement.I3     // Catch:{ all -> 0x0099 }
            java.lang.String r12 = "ContentProvider query failed"
            r11.<init>(r12, r10)     // Catch:{ all -> 0x0099 }
            throw r11     // Catch:{ all -> 0x0099 }
        L_0x00e3:
            r3.release()     // Catch:{ I3 -> 0x00ef }
            throw r10     // Catch:{ I3 -> 0x00ef }
        L_0x00e7:
            com.google.android.gms.internal.measurement.I3 r10 = new com.google.android.gms.internal.measurement.I3     // Catch:{ I3 -> 0x00ef }
            java.lang.String r11 = "Unable to acquire ContentProviderClient"
            r10.<init>(r11)     // Catch:{ I3 -> 0x00ef }
            throw r10     // Catch:{ I3 -> 0x00ef }
        L_0x00ef:
            return r2
        L_0x00f0:
            monitor-exit(r9)     // Catch:{ all -> 0x002c }
            throw r10
        L_0x00f2:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "ContentResolver needed with GservicesDelegateSupplier.init()"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.J3.a(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ AtomicBoolean b() {
        return this.f4991a;
    }
}
