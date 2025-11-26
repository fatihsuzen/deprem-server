package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.m4  reason: case insensitive filesystem */
final /* synthetic */ class C1376m4 implements C1459y4 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1452x4 f6551a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6552b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ X5 f6553c;

    /* synthetic */ C1376m4(C1452x4 x4Var, AtomicReference atomicReference, X5 x5) {
        this.f6551a = x4Var;
        this.f6552b = atomicReference;
        this.f6553c = x5;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final /* synthetic */ void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.x4 r7 = r6.f6551a
            r7.h()
            com.google.android.gms.measurement.internal.X5 r10 = r6.f6553c
            r11 = 200(0xc8, float:2.8E-43)
            if (r8 == r11) goto L_0x0014
            r11 = 204(0xcc, float:2.86E-43)
            if (r8 == r11) goto L_0x0014
            r11 = 304(0x130, float:4.26E-43)
            if (r8 != r11) goto L_0x002e
            r8 = r11
        L_0x0014:
            if (r9 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.X2 r8 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r8 = r8.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.w()
            long r0 = r10.f6168a
            java.lang.Long r9 = java.lang.Long.valueOf(r0)
            java.lang.String r11 = "[sgtm] Upload succeeded for row_id"
            r8.b(r11, r9)
            f0.J r8 = f0.C1642J.f15301c
            goto L_0x0069
        L_0x002e:
            com.google.android.gms.measurement.internal.X2 r11 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r11 = r11.a()
            com.google.android.gms.measurement.internal.o2 r11 = r11.r()
            long r0 = r10.f6168a
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            java.lang.String r2 = "[sgtm] Upload failed for row_id. response, exception"
            r11.d(r2, r0, r1, r9)
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6364u
            r11 = 0
            java.lang.Object r9 = r9.b(r11)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r11 = ","
            java.lang.String[] r9 = r9.split(r11)
            java.util.List r9 = java.util.Arrays.asList(r9)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            boolean r8 = r9.contains(r8)
            if (r8 == 0) goto L_0x0067
            f0.J r8 = f0.C1642J.f15303e
            goto L_0x0069
        L_0x0067:
            f0.J r8 = f0.C1642J.f15302d
        L_0x0069:
            java.util.concurrent.atomic.AtomicReference r9 = r6.f6552b
            com.google.android.gms.measurement.internal.X2 r11 = r7.f5730a
            com.google.android.gms.measurement.internal.w5 r11 = r11.J()
            com.google.android.gms.measurement.internal.g r0 = new com.google.android.gms.measurement.internal.g
            long r1 = r10.f6168a
            int r3 = r8.A()
            long r4 = r10.f6173f
            r0.<init>(r1, r3, r4)
            r11.k0(r0)
            com.google.android.gms.measurement.internal.X2 r7 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()
            com.google.android.gms.measurement.internal.o2 r7 = r7.w()
            java.lang.Long r10 = java.lang.Long.valueOf(r1)
            java.lang.String r11 = "[sgtm] Updated status for row_id"
            r7.c(r11, r10, r8)
            monitor-enter(r9)
            r9.set(r8)     // Catch:{ all -> 0x009d }
            r9.notifyAll()     // Catch:{ all -> 0x009d }
            monitor-exit(r9)     // Catch:{ all -> 0x009d }
            return
        L_0x009d:
            r0 = move-exception
            r7 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x009d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1376m4.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }
}
