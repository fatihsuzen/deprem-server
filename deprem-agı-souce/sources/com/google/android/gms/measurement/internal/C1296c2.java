package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.c2  reason: case insensitive filesystem */
public final class C1296c2 {

    /* renamed from: g  reason: collision with root package name */
    private static final Object f6238g = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final String f6239a;

    /* renamed from: b  reason: collision with root package name */
    private final N f6240b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f6241c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6242d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f6243e = null;

    /* renamed from: f  reason: collision with root package name */
    private volatile Object f6244f = null;

    /* synthetic */ C1296c2(String str, Object obj, Object obj2, N n5, byte[] bArr) {
        this.f6239a = str;
        this.f6241c = obj;
        this.f6240b = n5;
    }

    public final String a() {
        return this.f6239a;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0048 */
    public final java.lang.Object b(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f6242d
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.f r4 = com.google.android.gms.measurement.internal.W1.f6124a
            if (r4 != 0) goto L_0x000e
            java.lang.Object r4 = r3.f6241c
            return r4
        L_0x000e:
            java.lang.Object r4 = f6238g
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.C1317f.a()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r3.f6244f     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0020
            java.lang.Object r0 = r3.f6241c     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            goto L_0x0066
        L_0x0020:
            java.lang.Object r0 = r3.f6244f     // Catch:{ all -> 0x001e }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            return r0
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            java.util.List r4 = com.google.android.gms.measurement.internal.C1304d2.f6312a     // Catch:{ SecurityException -> 0x005a }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x005a }
        L_0x002d:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x005a }
            if (r0 == 0) goto L_0x005a
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x005a }
            com.google.android.gms.measurement.internal.c2 r0 = (com.google.android.gms.measurement.internal.C1296c2) r0     // Catch:{ SecurityException -> 0x005a }
            boolean r1 = com.google.android.gms.measurement.internal.C1317f.a()     // Catch:{ SecurityException -> 0x005a }
            if (r1 != 0) goto L_0x0052
            r1 = 0
            com.google.android.gms.measurement.internal.N r2 = r0.f6240b     // Catch:{ IllegalStateException -> 0x0048 }
            if (r2 == 0) goto L_0x0048
            java.lang.Object r1 = r2.A()     // Catch:{ IllegalStateException -> 0x0048 }
        L_0x0048:
            java.lang.Object r2 = f6238g     // Catch:{ SecurityException -> 0x005a }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x005a }
            r0.f6244f = r1     // Catch:{ all -> 0x004f }
            monitor-exit(r2)     // Catch:{ all -> 0x004f }
            goto L_0x002d
        L_0x004f:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004f }
            throw r4     // Catch:{ SecurityException -> 0x005a }
        L_0x0052:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x005a }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x005a }
            throw r4     // Catch:{ SecurityException -> 0x005a }
        L_0x005a:
            com.google.android.gms.measurement.internal.N r4 = r3.f6240b
            if (r4 != 0) goto L_0x0061
        L_0x005e:
            java.lang.Object r4 = r3.f6241c
            goto L_0x0065
        L_0x0061:
            java.lang.Object r4 = r4.A()     // Catch:{ IllegalStateException | SecurityException -> 0x005e }
        L_0x0065:
            return r4
        L_0x0066:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            throw r0
        L_0x0068:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1296c2.b(java.lang.Object):java.lang.Object");
    }
}
