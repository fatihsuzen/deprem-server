package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.i6  reason: case insensitive filesystem */
abstract class C1126i6 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f5379a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class f5380b = Memory.class;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f5381c;

    /* renamed from: d  reason: collision with root package name */
    private static final C1117h6 f5382d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f5383e;

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f5384f;

    /* renamed from: g  reason: collision with root package name */
    static final long f5385g = ((long) E(byte[].class));

    /* renamed from: h  reason: collision with root package name */
    static final boolean f5386h;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012c  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = v()
            f5379a = r1
            int r2 = com.google.android.gms.internal.measurement.C1231u4.f5596a
            java.lang.Class<libcore.io.Memory> r2 = libcore.io.Memory.class
            f5380b = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = w(r2)
            f5381c = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r5 = w(r4)
            r6 = 0
            if (r1 != 0) goto L_0x0020
            goto L_0x002f
        L_0x0020:
            if (r3 == 0) goto L_0x0028
            com.google.android.gms.internal.measurement.g6 r6 = new com.google.android.gms.internal.measurement.g6
            r6.<init>(r1)
            goto L_0x002f
        L_0x0028:
            if (r5 == 0) goto L_0x002f
            com.google.android.gms.internal.measurement.f6 r6 = new com.google.android.gms.internal.measurement.f6
            r6.<init>(r1)
        L_0x002f:
            f5382d = r6
            r1 = 2
            java.lang.String r3 = "getLong"
            java.lang.Class<java.lang.reflect.Field> r5 = java.lang.reflect.Field.class
            java.lang.String r7 = "objectFieldOffset"
            r8 = 1
            r9 = 0
            java.lang.Class<java.lang.Object> r10 = java.lang.Object.class
            if (r6 != 0) goto L_0x0040
        L_0x003e:
            r6 = r9
            goto L_0x0064
        L_0x0040:
            sun.misc.Unsafe r6 = r6.f5369a
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x005f }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x005f }
            r11[r9] = r5     // Catch:{ all -> 0x005f }
            r6.getMethod(r7, r11)     // Catch:{ all -> 0x005f }
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ all -> 0x005f }
            r11[r9] = r10     // Catch:{ all -> 0x005f }
            r11[r8] = r2     // Catch:{ all -> 0x005f }
            r6.getMethod(r3, r11)     // Catch:{ all -> 0x005f }
            java.lang.reflect.Field r6 = b()     // Catch:{ all -> 0x005f }
            if (r6 != 0) goto L_0x005d
            goto L_0x003e
        L_0x005d:
            r6 = r8
            goto L_0x0064
        L_0x005f:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.C1126i6.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x003e
        L_0x0064:
            f5383e = r6
            com.google.android.gms.internal.measurement.h6 r6 = f5382d
            if (r6 != 0) goto L_0x006c
        L_0x006a:
            r0 = r9
            goto L_0x00d9
        L_0x006c:
            sun.misc.Unsafe r6 = r6.f5369a
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x00d4 }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d4 }
            r11[r9] = r5     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r7, r11)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "arrayBaseOffset"
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d4 }
            r7[r9] = r0     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r5, r7)     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "arrayIndexScale"
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x00d4 }
            r7[r9] = r0     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r5, r7)     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "getInt"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d4 }
            r5[r9] = r10     // Catch:{ all -> 0x00d4 }
            r5[r8] = r2     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r0, r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "putInt"
            r5 = 3
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x00d4 }
            r7[r9] = r10     // Catch:{ all -> 0x00d4 }
            r7[r8] = r2     // Catch:{ all -> 0x00d4 }
            r7[r1] = r4     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r0, r7)     // Catch:{ all -> 0x00d4 }
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d4 }
            r0[r9] = r10     // Catch:{ all -> 0x00d4 }
            r0[r8] = r2     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r3, r0)     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "putLong"
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x00d4 }
            r3[r9] = r10     // Catch:{ all -> 0x00d4 }
            r3[r8] = r2     // Catch:{ all -> 0x00d4 }
            r3[r1] = r2     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r0, r3)     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "getObject"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x00d4 }
            r3[r9] = r10     // Catch:{ all -> 0x00d4 }
            r3[r8] = r2     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r0, r3)     // Catch:{ all -> 0x00d4 }
            java.lang.String r0 = "putObject"
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x00d4 }
            r3[r9] = r10     // Catch:{ all -> 0x00d4 }
            r3[r8] = r2     // Catch:{ all -> 0x00d4 }
            r3[r1] = r10     // Catch:{ all -> 0x00d4 }
            r6.getMethod(r0, r3)     // Catch:{ all -> 0x00d4 }
            r0 = r8
            goto L_0x00d9
        L_0x00d4:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.C1126i6.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006a
        L_0x00d9:
            f5384f = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = E(r0)
            long r0 = (long) r0
            f5385g = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            E(r0)
            a(r0)
            java.lang.Class<int[]> r0 = int[].class
            E(r0)
            a(r0)
            java.lang.Class<long[]> r0 = long[].class
            E(r0)
            a(r0)
            java.lang.Class<float[]> r0 = float[].class
            E(r0)
            a(r0)
            java.lang.Class<double[]> r0 = double[].class
            E(r0)
            a(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            E(r0)
            a(r0)
            java.lang.reflect.Field r0 = b()
            if (r0 == 0) goto L_0x0123
            com.google.android.gms.internal.measurement.h6 r1 = f5382d
            if (r1 == 0) goto L_0x0123
            sun.misc.Unsafe r1 = r1.f5369a
            r1.objectFieldOffset(r0)
        L_0x0123:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r8 = r9
        L_0x012d:
            f5386h = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1126i6.<clinit>():void");
    }

    static /* synthetic */ boolean A(Object obj, long j5) {
        if (((byte) ((f5382d.f5369a.getInt(obj, -4 & j5) >>> ((int) ((j5 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    private static int E(Class cls) {
        if (f5384f) {
            return f5382d.f5369a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int a(Class cls) {
        if (f5384f) {
            return f5382d.f5369a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field b() {
        int i5 = C1231u4.f5596a;
        Class<Buffer> cls = Buffer.class;
        Field c5 = c(cls, "effectiveDirectAddress");
        if (c5 != null) {
            return c5;
        }
        Field c6 = c(cls, "address");
        if (c6 == null || c6.getType() != Long.TYPE) {
            return null;
        }
        return c6;
    }

    private static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j5, byte b5) {
        Unsafe unsafe = f5382d.f5369a;
        long j6 = -4 & j5;
        int i5 = unsafe.getInt(obj, j6);
        int i6 = ((~((int) j5)) & 3) << 3;
        unsafe.putInt(obj, j6, ((255 & b5) << i6) | (i5 & (~(255 << i6))));
    }

    /* access modifiers changed from: private */
    public static void e(Object obj, long j5, byte b5) {
        Unsafe unsafe = f5382d.f5369a;
        long j6 = -4 & j5;
        int i5 = (((int) j5) & 3) << 3;
        unsafe.putInt(obj, j6, ((255 & b5) << i5) | (unsafe.getInt(obj, j6) & (~(255 << i5))));
    }

    static boolean f() {
        return f5384f;
    }

    static boolean g() {
        return f5383e;
    }

    static Object h(Class cls) {
        try {
            return f5379a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    static int i(Object obj, long j5) {
        return f5382d.f5369a.getInt(obj, j5);
    }

    static void j(Object obj, long j5, int i5) {
        f5382d.f5369a.putInt(obj, j5, i5);
    }

    static long k(Object obj, long j5) {
        return f5382d.f5369a.getLong(obj, j5);
    }

    static void l(Object obj, long j5, long j6) {
        f5382d.f5369a.putLong(obj, j5, j6);
    }

    static boolean m(Object obj, long j5) {
        return f5382d.b(obj, j5);
    }

    static void n(Object obj, long j5, boolean z4) {
        f5382d.c(obj, j5, z4);
    }

    static float o(Object obj, long j5) {
        return f5382d.d(obj, j5);
    }

    static void p(Object obj, long j5, float f5) {
        f5382d.e(obj, j5, f5);
    }

    static double q(Object obj, long j5) {
        return f5382d.f(obj, j5);
    }

    static void r(Object obj, long j5, double d5) {
        f5382d.g(obj, j5, d5);
    }

    static Object s(Object obj, long j5) {
        return f5382d.f5369a.getObject(obj, j5);
    }

    static void t(Object obj, long j5, Object obj2) {
        f5382d.f5369a.putObject(obj, j5, obj2);
    }

    static void u(byte[] bArr, long j5, byte b5) {
        f5382d.a(bArr, f5385g + j5, b5);
    }

    static Unsafe v() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C1090e6());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean w(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i5 = C1231u4.f5596a;
        try {
            Class cls3 = f5380b;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ boolean z(Object obj, long j5) {
        if (((byte) ((f5382d.f5369a.getInt(obj, -4 & j5) >>> ((int) (((~j5) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }
}
