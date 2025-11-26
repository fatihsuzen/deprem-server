package j$.util.concurrent;

import j$.sun.misc.a;
import java.util.concurrent.locks.LockSupport;

public final class q extends l {

    /* renamed from: h  reason: collision with root package name */
    public static final a f1339h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f1340i;

    /* renamed from: e  reason: collision with root package name */
    public r f1341e;

    /* renamed from: f  reason: collision with root package name */
    public volatile r f1342f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f1343g;
    volatile int lockState;

    static {
        Class<ConcurrentHashMap> cls = ConcurrentHashMap.class;
        a aVar = a.f1001b;
        f1339h = aVar;
        f1340i = aVar.h(q.class, "lockState");
    }

    public static int i(Object obj, Object obj2) {
        int compareTo;
        if (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) {
            return System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1;
        }
        return compareTo;
    }

    public q(r rVar) {
        super(-2, (Object) null, (Object) null);
        int i5;
        this.f1342f = rVar;
        r rVar2 = null;
        while (rVar != null) {
            r rVar3 = (r) rVar.f1326d;
            rVar.f1346g = null;
            rVar.f1345f = null;
            if (rVar2 == null) {
                rVar.f1344e = null;
                rVar.f1348i = false;
            } else {
                Object obj = rVar.f1324b;
                int i6 = rVar.f1323a;
                r rVar4 = rVar2;
                Class<?> cls = null;
                while (true) {
                    Object obj2 = rVar4.f1324b;
                    int i7 = rVar4.f1323a;
                    if (i7 > i6) {
                        i5 = -1;
                    } else if (i7 < i6) {
                        i5 = 1;
                    } else {
                        if (!(cls == null && (cls = ConcurrentHashMap.c(obj)) == null)) {
                            int i8 = ConcurrentHashMap.f1289g;
                            int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                            if (compareTo != 0) {
                                i5 = compareTo;
                            }
                        }
                        i5 = i(obj, obj2);
                    }
                    r rVar5 = i5 <= 0 ? rVar4.f1345f : rVar4.f1346g;
                    if (rVar5 == null) {
                        break;
                    }
                    rVar4 = rVar5;
                }
                rVar.f1344e = rVar4;
                if (i5 <= 0) {
                    rVar4.f1345f = rVar;
                } else {
                    rVar4.f1346g = rVar;
                }
                rVar = c(rVar2, rVar);
            }
            rVar2 = rVar;
            rVar = rVar3;
        }
        this.f1341e = rVar2;
    }

    public final void d() {
        if (!f1339h.c(this, f1340i, 0, 1)) {
            boolean z4 = false;
            while (true) {
                int i5 = this.lockState;
                if ((i5 & -3) == 0) {
                    if (f1339h.c(this, f1340i, i5, 1)) {
                        break;
                    }
                } else if ((i5 & 2) == 0) {
                    if (f1339h.c(this, f1340i, i5, i5 | 2)) {
                        this.f1343g = Thread.currentThread();
                        z4 = true;
                    }
                } else if (z4) {
                    LockSupport.park(this);
                }
            }
            if (z4) {
                this.f1343g = null;
            }
        }
    }

    public final l a(int i5, Object obj) {
        Thread thread;
        Thread thread2;
        Object obj2;
        l lVar = this.f1342f;
        while (true) {
            r rVar = null;
            if (lVar != null) {
                int i6 = this.lockState;
                if ((i6 & 3) == 0) {
                    a aVar = f1339h;
                    long j5 = f1340i;
                    if (aVar.c(this, j5, i6, i6 + 4)) {
                        try {
                            r rVar2 = this.f1341e;
                            if (rVar2 != null) {
                                rVar = rVar2.b(i5, obj, (Class) null);
                            }
                            if (aVar.e(this, j5) == 6 && (thread2 = this.f1343g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return rVar;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (f1339h.e(this, f1340i) == 6 && (thread = this.f1343g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th2;
                        }
                    }
                } else if (lVar.f1323a != i5 || ((obj2 = lVar.f1324b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    lVar = lVar.f1326d;
                }
            } else {
                return null;
            }
        }
        return lVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a9 A[LOOP:0: B:1:0x0007->B:61:0x00a9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0079 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.util.concurrent.r e(int r12, java.lang.Object r13, java.lang.Object r14) {
        /*
            r11 = this;
            j$.util.concurrent.r r0 = r11.f1341e
            r7 = 0
            r8 = 0
            r6 = r0
            r0 = r7
            r1 = r8
        L_0x0007:
            if (r6 != 0) goto L_0x0018
            j$.util.concurrent.r r1 = new j$.util.concurrent.r
            r5 = 0
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            r11.f1341e = r1
            r11.f1342f = r1
            return r7
        L_0x0018:
            int r4 = r6.f1323a
            r9 = 1
            if (r4 <= r12) goto L_0x0020
            r4 = -1
        L_0x001e:
            r10 = r4
            goto L_0x0070
        L_0x0020:
            if (r4 >= r12) goto L_0x0024
            r10 = r9
            goto L_0x0070
        L_0x0024:
            java.lang.Object r4 = r6.f1324b
            if (r4 == r13) goto L_0x00ac
            if (r4 == 0) goto L_0x0032
            boolean r5 = r13.equals(r4)
            if (r5 == 0) goto L_0x0032
            goto L_0x00ac
        L_0x0032:
            if (r0 != 0) goto L_0x003a
            java.lang.Class r0 = j$.util.concurrent.ConcurrentHashMap.c(r13)
            if (r0 == 0) goto L_0x0050
        L_0x003a:
            int r5 = j$.util.concurrent.ConcurrentHashMap.f1289g
            if (r4 == 0) goto L_0x004d
            java.lang.Class r5 = r4.getClass()
            if (r5 == r0) goto L_0x0045
            goto L_0x004d
        L_0x0045:
            r5 = r13
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            int r5 = r5.compareTo(r4)
            goto L_0x004e
        L_0x004d:
            r5 = r8
        L_0x004e:
            if (r5 != 0) goto L_0x006f
        L_0x0050:
            if (r1 != 0) goto L_0x006a
            j$.util.concurrent.r r1 = r6.f1345f
            if (r1 == 0) goto L_0x005e
            j$.util.concurrent.r r1 = r1.b(r12, r13, r0)
            if (r1 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            return r1
        L_0x005e:
            j$.util.concurrent.r r1 = r6.f1346g
            if (r1 == 0) goto L_0x0069
            j$.util.concurrent.r r1 = r1.b(r12, r13, r0)
            if (r1 == 0) goto L_0x0069
            return r1
        L_0x0069:
            r1 = r9
        L_0x006a:
            int r4 = i(r13, r4)
            goto L_0x001e
        L_0x006f:
            r10 = r5
        L_0x0070:
            if (r10 > 0) goto L_0x0075
            j$.util.concurrent.r r4 = r6.f1345f
            goto L_0x0077
        L_0x0075:
            j$.util.concurrent.r r4 = r6.f1346g
        L_0x0077:
            if (r4 != 0) goto L_0x00a9
            j$.util.concurrent.r r5 = r11.f1342f
            j$.util.concurrent.r r1 = new j$.util.concurrent.r
            r2 = r12
            r3 = r13
            r4 = r14
            r1.<init>(r2, r3, r4, r5, r6)
            r11.f1342f = r1
            if (r5 == 0) goto L_0x0089
            r5.f1347h = r1
        L_0x0089:
            if (r10 > 0) goto L_0x008e
            r6.f1345f = r1
            goto L_0x0090
        L_0x008e:
            r6.f1346g = r1
        L_0x0090:
            boolean r0 = r6.f1348i
            if (r0 != 0) goto L_0x0097
            r1.f1348i = r9
            return r7
        L_0x0097:
            r11.d()
            j$.util.concurrent.r r0 = r11.f1341e     // Catch:{ all -> 0x00a5 }
            j$.util.concurrent.r r0 = c(r0, r1)     // Catch:{ all -> 0x00a5 }
            r11.f1341e = r0     // Catch:{ all -> 0x00a5 }
            r11.lockState = r8
            return r7
        L_0x00a5:
            r0 = move-exception
            r11.lockState = r8
            throw r0
        L_0x00a9:
            r6 = r4
            goto L_0x0007
        L_0x00ac:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.q.e(int, java.lang.Object, java.lang.Object):j$.util.concurrent.r");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0091 A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ac A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ad A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00bd A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c0 A[Catch:{ all -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(j$.util.concurrent.r r11) {
        /*
            r10 = this;
            j$.util.concurrent.l r0 = r11.f1326d
            j$.util.concurrent.r r0 = (j$.util.concurrent.r) r0
            j$.util.concurrent.r r1 = r11.f1347h
            if (r1 != 0) goto L_0x000b
            r10.f1342f = r0
            goto L_0x000d
        L_0x000b:
            r1.f1326d = r0
        L_0x000d:
            if (r0 == 0) goto L_0x0011
            r0.f1347h = r1
        L_0x0011:
            j$.util.concurrent.r r0 = r10.f1342f
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001a
            r10.f1341e = r2
            return r1
        L_0x001a:
            j$.util.concurrent.r r0 = r10.f1341e
            if (r0 == 0) goto L_0x00ce
            j$.util.concurrent.r r3 = r0.f1346g
            if (r3 == 0) goto L_0x00ce
            j$.util.concurrent.r r3 = r0.f1345f
            if (r3 == 0) goto L_0x00ce
            j$.util.concurrent.r r3 = r3.f1345f
            if (r3 != 0) goto L_0x002c
            goto L_0x00ce
        L_0x002c:
            r10.d()
            r1 = 0
            j$.util.concurrent.r r3 = r11.f1345f     // Catch:{ all -> 0x0052 }
            j$.util.concurrent.r r4 = r11.f1346g     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x0087
            if (r4 == 0) goto L_0x0087
            r5 = r4
        L_0x0039:
            j$.util.concurrent.r r6 = r5.f1345f     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x003f
            r5 = r6
            goto L_0x0039
        L_0x003f:
            boolean r6 = r5.f1348i     // Catch:{ all -> 0x0052 }
            boolean r7 = r11.f1348i     // Catch:{ all -> 0x0052 }
            r5.f1348i = r7     // Catch:{ all -> 0x0052 }
            r11.f1348i = r6     // Catch:{ all -> 0x0052 }
            j$.util.concurrent.r r6 = r5.f1346g     // Catch:{ all -> 0x0052 }
            j$.util.concurrent.r r7 = r11.f1344e     // Catch:{ all -> 0x0052 }
            if (r5 != r4) goto L_0x0055
            r11.f1344e = r5     // Catch:{ all -> 0x0052 }
            r5.f1346g = r11     // Catch:{ all -> 0x0052 }
            goto L_0x0068
        L_0x0052:
            r11 = move-exception
            goto L_0x00cb
        L_0x0055:
            j$.util.concurrent.r r8 = r5.f1344e     // Catch:{ all -> 0x0052 }
            r11.f1344e = r8     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x0064
            j$.util.concurrent.r r9 = r8.f1345f     // Catch:{ all -> 0x0052 }
            if (r5 != r9) goto L_0x0062
            r8.f1345f = r11     // Catch:{ all -> 0x0052 }
            goto L_0x0064
        L_0x0062:
            r8.f1346g = r11     // Catch:{ all -> 0x0052 }
        L_0x0064:
            r5.f1346g = r4     // Catch:{ all -> 0x0052 }
            r4.f1344e = r5     // Catch:{ all -> 0x0052 }
        L_0x0068:
            r11.f1345f = r2     // Catch:{ all -> 0x0052 }
            r11.f1346g = r6     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0070
            r6.f1344e = r11     // Catch:{ all -> 0x0052 }
        L_0x0070:
            r5.f1345f = r3     // Catch:{ all -> 0x0052 }
            r3.f1344e = r5     // Catch:{ all -> 0x0052 }
            r5.f1344e = r7     // Catch:{ all -> 0x0052 }
            if (r7 != 0) goto L_0x007a
            r0 = r5
            goto L_0x0083
        L_0x007a:
            j$.util.concurrent.r r3 = r7.f1345f     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x0081
            r7.f1345f = r5     // Catch:{ all -> 0x0052 }
            goto L_0x0083
        L_0x0081:
            r7.f1346g = r5     // Catch:{ all -> 0x0052 }
        L_0x0083:
            if (r6 == 0) goto L_0x008e
            r3 = r6
            goto L_0x008f
        L_0x0087:
            if (r3 == 0) goto L_0x008a
            goto L_0x008f
        L_0x008a:
            if (r4 == 0) goto L_0x008e
            r3 = r4
            goto L_0x008f
        L_0x008e:
            r3 = r11
        L_0x008f:
            if (r3 == r11) goto L_0x00a8
            j$.util.concurrent.r r4 = r11.f1344e     // Catch:{ all -> 0x0052 }
            r3.f1344e = r4     // Catch:{ all -> 0x0052 }
            if (r4 != 0) goto L_0x0099
            r0 = r3
            goto L_0x00a2
        L_0x0099:
            j$.util.concurrent.r r5 = r4.f1345f     // Catch:{ all -> 0x0052 }
            if (r11 != r5) goto L_0x00a0
            r4.f1345f = r3     // Catch:{ all -> 0x0052 }
            goto L_0x00a2
        L_0x00a0:
            r4.f1346g = r3     // Catch:{ all -> 0x0052 }
        L_0x00a2:
            r11.f1344e = r2     // Catch:{ all -> 0x0052 }
            r11.f1346g = r2     // Catch:{ all -> 0x0052 }
            r11.f1345f = r2     // Catch:{ all -> 0x0052 }
        L_0x00a8:
            boolean r4 = r11.f1348i     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x00ad
            goto L_0x00b1
        L_0x00ad:
            j$.util.concurrent.r r0 = b(r0, r3)     // Catch:{ all -> 0x0052 }
        L_0x00b1:
            r10.f1341e = r0     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x00c8
            j$.util.concurrent.r r0 = r11.f1344e     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x00c8
            j$.util.concurrent.r r3 = r0.f1345f     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x00c0
            r0.f1345f = r2     // Catch:{ all -> 0x0052 }
            goto L_0x00c6
        L_0x00c0:
            j$.util.concurrent.r r3 = r0.f1346g     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x00c6
            r0.f1346g = r2     // Catch:{ all -> 0x0052 }
        L_0x00c6:
            r11.f1344e = r2     // Catch:{ all -> 0x0052 }
        L_0x00c8:
            r10.lockState = r1
            return r1
        L_0x00cb:
            r10.lockState = r1
            throw r11
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.q.f(j$.util.concurrent.r):boolean");
    }

    public static r g(r rVar, r rVar2) {
        r rVar3;
        if (!(rVar2 == null || (rVar3 = rVar2.f1346g) == null)) {
            r rVar4 = rVar3.f1345f;
            rVar2.f1346g = rVar4;
            if (rVar4 != null) {
                rVar4.f1344e = rVar2;
            }
            r rVar5 = rVar2.f1344e;
            rVar3.f1344e = rVar5;
            if (rVar5 == null) {
                rVar3.f1348i = false;
                rVar = rVar3;
            } else if (rVar5.f1345f == rVar2) {
                rVar5.f1345f = rVar3;
            } else {
                rVar5.f1346g = rVar3;
            }
            rVar3.f1345f = rVar2;
            rVar2.f1344e = rVar3;
        }
        return rVar;
    }

    public static r h(r rVar, r rVar2) {
        r rVar3;
        if (!(rVar2 == null || (rVar3 = rVar2.f1345f) == null)) {
            r rVar4 = rVar3.f1346g;
            rVar2.f1345f = rVar4;
            if (rVar4 != null) {
                rVar4.f1344e = rVar2;
            }
            r rVar5 = rVar2.f1344e;
            rVar3.f1344e = rVar5;
            if (rVar5 == null) {
                rVar3.f1348i = false;
                rVar = rVar3;
            } else if (rVar5.f1346g == rVar2) {
                rVar5.f1346g = rVar3;
            } else {
                rVar5.f1345f = rVar3;
            }
            rVar3.f1346g = rVar2;
            rVar2.f1344e = rVar3;
        }
        return rVar;
    }

    public static r c(r rVar, r rVar2) {
        r rVar3;
        rVar2.f1348i = true;
        while (true) {
            r rVar4 = rVar2.f1344e;
            if (rVar4 == null) {
                rVar2.f1348i = false;
                return rVar2;
            } else if (!rVar4.f1348i || (rVar3 = rVar4.f1344e) == null) {
                return rVar;
            } else {
                r rVar5 = rVar3.f1345f;
                if (rVar4 == rVar5) {
                    r rVar6 = rVar3.f1346g;
                    if (rVar6 == null || !rVar6.f1348i) {
                        if (rVar2 == rVar4.f1346g) {
                            rVar = g(rVar, rVar4);
                            r rVar7 = rVar4.f1344e;
                            rVar3 = rVar7 == null ? null : rVar7.f1344e;
                            r rVar8 = rVar4;
                            rVar4 = rVar7;
                            rVar2 = rVar8;
                        }
                        if (rVar4 != null) {
                            rVar4.f1348i = false;
                            if (rVar3 != null) {
                                rVar3.f1348i = true;
                                rVar = h(rVar, rVar3);
                            }
                        }
                    } else {
                        rVar6.f1348i = false;
                        rVar4.f1348i = false;
                        rVar3.f1348i = true;
                    }
                } else if (rVar5 == null || !rVar5.f1348i) {
                    if (rVar2 == rVar4.f1345f) {
                        rVar = h(rVar, rVar4);
                        r rVar9 = rVar4.f1344e;
                        rVar3 = rVar9 == null ? null : rVar9.f1344e;
                        r rVar10 = rVar4;
                        rVar4 = rVar9;
                        rVar2 = rVar10;
                    }
                    if (rVar4 != null) {
                        rVar4.f1348i = false;
                        if (rVar3 != null) {
                            rVar3.f1348i = true;
                            rVar = g(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.f1348i = false;
                    rVar4.f1348i = false;
                    rVar3.f1348i = true;
                }
                rVar2 = rVar3;
            }
        }
        return rVar;
    }

    public static r b(r rVar, r rVar2) {
        boolean z4;
        boolean z5;
        while (rVar2 != null && rVar2 != rVar) {
            r rVar3 = rVar2.f1344e;
            if (rVar3 == null) {
                rVar2.f1348i = false;
                return rVar2;
            } else if (rVar2.f1348i) {
                rVar2.f1348i = false;
                return rVar;
            } else {
                r rVar4 = rVar3.f1345f;
                r rVar5 = null;
                if (rVar4 == rVar2) {
                    r rVar6 = rVar3.f1346g;
                    if (rVar6 != null && rVar6.f1348i) {
                        rVar6.f1348i = false;
                        rVar3.f1348i = true;
                        rVar = g(rVar, rVar3);
                        rVar3 = rVar2.f1344e;
                        rVar6 = rVar3 == null ? null : rVar3.f1346g;
                    }
                    if (rVar6 != null) {
                        r rVar7 = rVar6.f1345f;
                        r rVar8 = rVar6.f1346g;
                        if ((rVar8 == null || !rVar8.f1348i) && (rVar7 == null || !rVar7.f1348i)) {
                            rVar6.f1348i = true;
                        } else {
                            if (rVar8 == null || !rVar8.f1348i) {
                                if (rVar7 != null) {
                                    rVar7.f1348i = false;
                                }
                                rVar6.f1348i = true;
                                rVar = h(rVar, rVar6);
                                rVar3 = rVar2.f1344e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f1346g;
                                }
                                rVar6 = rVar5;
                            }
                            if (rVar6 != null) {
                                if (rVar3 == null) {
                                    z5 = false;
                                } else {
                                    z5 = rVar3.f1348i;
                                }
                                rVar6.f1348i = z5;
                                r rVar9 = rVar6.f1346g;
                                if (rVar9 != null) {
                                    rVar9.f1348i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f1348i = false;
                                rVar = g(rVar, rVar3);
                            }
                            rVar2 = rVar;
                        }
                    }
                } else {
                    if (rVar4 != null && rVar4.f1348i) {
                        rVar4.f1348i = false;
                        rVar3.f1348i = true;
                        rVar = h(rVar, rVar3);
                        rVar3 = rVar2.f1344e;
                        rVar4 = rVar3 == null ? null : rVar3.f1345f;
                    }
                    if (rVar4 != null) {
                        r rVar10 = rVar4.f1345f;
                        r rVar11 = rVar4.f1346g;
                        if ((rVar10 == null || !rVar10.f1348i) && (rVar11 == null || !rVar11.f1348i)) {
                            rVar4.f1348i = true;
                        } else {
                            if (rVar10 == null || !rVar10.f1348i) {
                                if (rVar11 != null) {
                                    rVar11.f1348i = false;
                                }
                                rVar4.f1348i = true;
                                rVar = g(rVar, rVar4);
                                rVar3 = rVar2.f1344e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f1345f;
                                }
                                rVar4 = rVar5;
                            }
                            if (rVar4 != null) {
                                if (rVar3 == null) {
                                    z4 = false;
                                } else {
                                    z4 = rVar3.f1348i;
                                }
                                rVar4.f1348i = z4;
                                r rVar12 = rVar4.f1345f;
                                if (rVar12 != null) {
                                    rVar12.f1348i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f1348i = false;
                                rVar = h(rVar, rVar3);
                            }
                            rVar2 = rVar;
                        }
                    }
                }
                rVar2 = rVar3;
            }
        }
        return rVar;
    }
}
