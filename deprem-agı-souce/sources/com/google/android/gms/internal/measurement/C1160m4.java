package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l0.h;

/* renamed from: com.google.android.gms.internal.measurement.m4  reason: case insensitive filesystem */
public abstract class C1160m4 {

    /* renamed from: g  reason: collision with root package name */
    private static final Object f5440g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static volatile C1115h4 f5441h;

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicInteger f5442i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f5443j = 0;

    /* renamed from: a  reason: collision with root package name */
    final C1106g4 f5444a;

    /* renamed from: b  reason: collision with root package name */
    final String f5445b;

    /* renamed from: c  reason: collision with root package name */
    private Object f5446c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f5447d = -1;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f5448e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f5449f;

    static {
        new AtomicReference();
        h.i(C1142k4.f5425a, "BuildInfo must be non-null");
    }

    /* synthetic */ C1160m4(C1106g4 g4Var, String str, Object obj, boolean z4, byte[] bArr) {
        if (g4Var.f5357a != null) {
            this.f5444a = g4Var;
            this.f5445b = str;
            this.f5446c = obj;
            this.f5449f = false;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void b(android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.h4 r0 = f5441h
            if (r0 != 0) goto L_0x004d
            if (r3 != 0) goto L_0x0007
            goto L_0x004d
        L_0x0007:
            java.lang.Object r0 = f5440g
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.h4 r1 = f5441h     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0049
            monitor-enter(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.h4 r1 = f5441h     // Catch:{ all -> 0x0021 }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0018
            r3 = r2
        L_0x0018:
            if (r1 == 0) goto L_0x0023
            android.content.Context r2 = r1.a()     // Catch:{ all -> 0x0021 }
            if (r2 == r3) goto L_0x0043
            goto L_0x0023
        L_0x0021:
            r3 = move-exception
            goto L_0x0045
        L_0x0023:
            if (r1 == 0) goto L_0x002e
            com.google.android.gms.internal.measurement.Q3.e()     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.measurement.C1178o4.c()     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.measurement.X3.d()     // Catch:{ all -> 0x0021 }
        L_0x002e:
            com.google.android.gms.internal.measurement.l4 r1 = new com.google.android.gms.internal.measurement.l4     // Catch:{ all -> 0x0021 }
            r1.<init>(r3)     // Catch:{ all -> 0x0021 }
            l0.k r1 = l0.l.a(r1)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.measurement.M3 r2 = new com.google.android.gms.internal.measurement.M3     // Catch:{ all -> 0x0021 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0021 }
            f5441h = r2     // Catch:{ all -> 0x0021 }
            java.util.concurrent.atomic.AtomicInteger r3 = f5442i     // Catch:{ all -> 0x0021 }
            r3.incrementAndGet()     // Catch:{ all -> 0x0021 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            goto L_0x0049
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r3 = move-exception
            goto L_0x004b
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r3
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1160m4.b(android.content.Context):void");
    }

    public static void c() {
        f5442i.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public abstract Object a(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd A[Catch:{ all -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = f5442i
            int r0 = r0.get()
            int r1 = r9.f5447d
            if (r1 >= r0) goto L_0x00ce
            monitor-enter(r9)
            int r1 = r9.f5447d     // Catch:{ all -> 0x0047 }
            if (r1 >= r0) goto L_0x00ca
            com.google.android.gms.internal.measurement.h4 r1 = f5441h     // Catch:{ all -> 0x0047 }
            l0.g r2 = l0.g.a()     // Catch:{ all -> 0x0047 }
            r3 = 0
            if (r1 == 0) goto L_0x004a
            l0.k r4 = r1.b()     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x004a
            l0.k r2 = r1.b()     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = l0.h.h(r2)     // Catch:{ all -> 0x0047 }
            l0.k r2 = (l0.k) r2     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0047 }
            l0.g r2 = (l0.g) r2     // Catch:{ all -> 0x0047 }
            boolean r4 = r2.c()     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r2.b()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.R3 r4 = (com.google.android.gms.internal.measurement.R3) r4     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.g4 r5 = r9.f5444a     // Catch:{ all -> 0x0047 }
            android.net.Uri r6 = r5.f5357a     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r5.f5359c     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = r9.f5445b     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = r4.a(r6, r3, r5, r7)     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r0 = move-exception
            goto L_0x00cc
        L_0x004a:
            r4 = r3
        L_0x004b:
            if (r1 == 0) goto L_0x004f
            r5 = 1
            goto L_0x0050
        L_0x004f:
            r5 = 0
        L_0x0050:
            java.lang.String r6 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            l0.h.n(r5, r6)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.g4 r5 = r9.f5444a     // Catch:{ all -> 0x0047 }
            android.net.Uri r6 = r5.f5357a     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x0076
            android.content.Context r7 = r1.a()     // Catch:{ all -> 0x0047 }
            boolean r7 = com.google.android.gms.internal.measurement.C1052a4.a(r7, r6)     // Catch:{ all -> 0x0047 }
            if (r7 == 0) goto L_0x0074
            android.content.Context r7 = r1.a()     // Catch:{ all -> 0x0047 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.j4 r8 = com.google.android.gms.internal.measurement.C1133j4.f5398a     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.Q3 r6 = com.google.android.gms.internal.measurement.Q3.b(r7, r6, r8)     // Catch:{ all -> 0x0047 }
            goto L_0x0086
        L_0x0074:
            r6 = r3
            goto L_0x0086
        L_0x0076:
            android.content.Context r6 = r1.a()     // Catch:{ all -> 0x0047 }
            java.lang.Object r7 = l0.h.h(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.i4 r8 = com.google.android.gms.internal.measurement.C1124i4.f5378a     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.o4 r6 = com.google.android.gms.internal.measurement.C1178o4.b(r6, r7, r8)     // Catch:{ all -> 0x0047 }
        L_0x0086:
            if (r6 == 0) goto L_0x0095
            java.lang.String r7 = r9.f5445b     // Catch:{ all -> 0x0047 }
            java.lang.Object r6 = r6.a(r7)     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x0095
            java.lang.Object r6 = r9.a(r6)     // Catch:{ all -> 0x0047 }
            goto L_0x0096
        L_0x0095:
            r6 = r3
        L_0x0096:
            if (r6 == 0) goto L_0x0099
            goto L_0x00b7
        L_0x0099:
            boolean r5 = r5.f5360d     // Catch:{ all -> 0x0047 }
            if (r5 != 0) goto L_0x00b1
            android.content.Context r1 = r1.a()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.X3 r1 = com.google.android.gms.internal.measurement.X3.b(r1)     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r9.f5445b     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r1.a(r5)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x00b1
            java.lang.Object r3 = r9.a(r1)     // Catch:{ all -> 0x0047 }
        L_0x00b1:
            if (r3 != 0) goto L_0x00b6
            java.lang.Object r6 = r9.f5446c     // Catch:{ all -> 0x0047 }
            goto L_0x00b7
        L_0x00b6:
            r6 = r3
        L_0x00b7:
            boolean r1 = r2.c()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x00c6
            if (r4 != 0) goto L_0x00c2
            java.lang.Object r6 = r9.f5446c     // Catch:{ all -> 0x0047 }
            goto L_0x00c6
        L_0x00c2:
            java.lang.Object r6 = r9.a(r4)     // Catch:{ all -> 0x0047 }
        L_0x00c6:
            r9.f5448e = r6     // Catch:{ all -> 0x0047 }
            r9.f5447d = r0     // Catch:{ all -> 0x0047 }
        L_0x00ca:
            monitor-exit(r9)     // Catch:{ all -> 0x0047 }
            goto L_0x00ce
        L_0x00cc:
            monitor-exit(r9)     // Catch:{ all -> 0x0047 }
            throw r0
        L_0x00ce:
            java.lang.Object r0 = r9.f5448e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1160m4.d():java.lang.Object");
    }
}
