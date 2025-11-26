package com.google.android.gms.dynamite;

import K.C0661h;
import N.C0720n;
import N.C0722p;
import V.e;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.k;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {

    /* renamed from: b  reason: collision with root package name */
    public static final b f4897b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final b f4898c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final b f4899d = new f();

    /* renamed from: e  reason: collision with root package name */
    public static final b f4900e = new g();

    /* renamed from: f  reason: collision with root package name */
    public static final b f4901f = new h();

    /* renamed from: g  reason: collision with root package name */
    public static final b f4902g = new i();

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f4903h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f4904i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f4905j = false;

    /* renamed from: k  reason: collision with root package name */
    private static int f4906k = -1;

    /* renamed from: l  reason: collision with root package name */
    private static Boolean f4907l;

    /* renamed from: m  reason: collision with root package name */
    private static final ThreadLocal f4908m = new ThreadLocal();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadLocal f4909n = new b();

    /* renamed from: o  reason: collision with root package name */
    private static final b.a f4910o = new c();

    /* renamed from: p  reason: collision with root package name */
    public static final b f4911p = new j();

    /* renamed from: q  reason: collision with root package name */
    private static m f4912q;

    /* renamed from: r  reason: collision with root package name */
    private static n f4913r;

    /* renamed from: a  reason: collision with root package name */
    private final Context f4914a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @NonNull
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        /* synthetic */ a(String str, e eVar) {
            super(str);
        }

        /* synthetic */ a(String str, Throwable th, e eVar) {
            super(str, th);
        }
    }

    public interface b {

        public interface a {
            int a(Context context, String str, boolean z4);

            int b(Context context, String str);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        public static class C0069b {

            /* renamed from: a  reason: collision with root package name */
            public int f4915a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f4916b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f4917c = 0;
        }

        C0069b a(Context context, String str, a aVar);
    }

    private DynamiteModule(Context context) {
        C0722p.k(context);
        this.f4914a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (C0720n.a(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e5) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e5.getMessage())));
            return 0;
        }
    }

    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule e(android.content.Context r21, com.google.android.gms.dynamite.DynamiteModule.b r22, java.lang.String r23) {
        /*
            r1 = r21
            r2 = r22
            r3 = r23
            android.content.Context r4 = r1.getApplicationContext()
            r5 = 0
            if (r4 == 0) goto L_0x02cd
            java.lang.ThreadLocal r0 = f4908m
            java.lang.Object r6 = r0.get()
            com.google.android.gms.dynamite.k r6 = (com.google.android.gms.dynamite.k) r6
            com.google.android.gms.dynamite.k r7 = new com.google.android.gms.dynamite.k
            r7.<init>(r5)
            r0.set(r7)
            java.lang.ThreadLocal r8 = f4909n
            java.lang.Object r9 = r8.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r10 = r9.longValue()
            long r14 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x02ae }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x02ae }
            r8.set(r14)     // Catch:{ all -> 0x02ae }
            com.google.android.gms.dynamite.DynamiteModule$b$a r8 = f4910o     // Catch:{ all -> 0x02ae }
            com.google.android.gms.dynamite.DynamiteModule$b$b r8 = r2.a(r1, r3, r8)     // Catch:{ all -> 0x02ae }
            java.lang.String r14 = "DynamiteModule"
            int r15 = r8.f4915a     // Catch:{ all -> 0x02ae }
            r16 = 0
            int r12 = r8.f4916b     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r13.<init>()     // Catch:{ all -> 0x007d }
            r18 = r5
            java.lang.String r5 = "Considering local module "
            r13.append(r5)     // Catch:{ all -> 0x007d }
            r13.append(r3)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = ":"
            r13.append(r5)     // Catch:{ all -> 0x007d }
            r13.append(r15)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = " and remote module "
            r13.append(r5)     // Catch:{ all -> 0x007d }
            r13.append(r3)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = ":"
            r13.append(r5)     // Catch:{ all -> 0x007d }
            r13.append(r12)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x007d }
            android.util.Log.i(r14, r5)     // Catch:{ all -> 0x007d }
            int r5 = r8.f4917c     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x027d
            r12 = -1
            if (r5 != r12) goto L_0x0080
            int r5 = r8.f4915a     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x027d
            r5 = r12
            goto L_0x0080
        L_0x007d:
            r0 = move-exception
            goto L_0x02b1
        L_0x0080:
            r13 = 1
            if (r5 != r13) goto L_0x0087
            int r14 = r8.f4916b     // Catch:{ all -> 0x007d }
            if (r14 == 0) goto L_0x027d
        L_0x0087:
            if (r5 != r12) goto L_0x008f
            com.google.android.gms.dynamite.DynamiteModule r0 = h(r4, r3)     // Catch:{ all -> 0x007d }
            goto L_0x0240
        L_0x008f:
            if (r5 != r13) goto L_0x0265
            int r14 = r8.f4916b     // Catch:{ a -> 0x0203 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r15 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r15)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            boolean r19 = k(r1)     // Catch:{ all -> 0x01ea }
            if (r19 == 0) goto L_0x01ec
            java.lang.Boolean r19 = f4903h     // Catch:{ all -> 0x01ea }
            monitor-exit(r15)     // Catch:{ all -> 0x01ea }
            if (r19 == 0) goto L_0x01e1
            boolean r15 = r19.booleanValue()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r13 = 2
            if (r15 == 0) goto L_0x0154
            java.lang.String r15 = "DynamiteModule"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r12.<init>()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "Selected remote version of "
            r12.append(r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r12.append(r3)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = ", version >= "
            r12.append(r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r12.append(r14)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = r12.toString()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            android.util.Log.i(r15, r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r5 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            com.google.android.gms.dynamite.n r12 = f4913r     // Catch:{ all -> 0x0151 }
            monitor-exit(r5)     // Catch:{ all -> 0x0151 }
            if (r12 == 0) goto L_0x0148
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            com.google.android.gms.dynamite.k r0 = (com.google.android.gms.dynamite.k) r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            if (r0 == 0) goto L_0x013f
            android.database.Cursor r5 = r0.f4918a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            if (r5 == 0) goto L_0x013f
            android.content.Context r5 = r1.getApplicationContext()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            android.database.Cursor r0 = r0.f4918a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.b.q0(r18)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r15 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r15)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r20 = r0
            int r0 = f4906k     // Catch:{ all -> 0x013c }
            if (r0 < r13) goto L_0x00ee
            r13 = 1
            goto L_0x00ef
        L_0x00ee:
            r13 = 0
        L_0x00ef:
            monitor-exit(r15)     // Catch:{ all -> 0x013c }
            if (r13 == 0) goto L_0x010f
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r13 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            android.util.Log.v(r0, r13)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = U.b.q0(r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r5 = U.b.q0(r20)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = r12.q0(r0, r3, r14, r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            goto L_0x0122
        L_0x0106:
            r0 = move-exception
            goto L_0x01f7
        L_0x0109:
            r0 = move-exception
            goto L_0x0205
        L_0x010c:
            r0 = move-exception
            goto L_0x0206
        L_0x010f:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r13 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r0, r13)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = U.b.q0(r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r5 = U.b.q0(r20)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = r12.k(r0, r3, r14, r5)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x0122:
            java.lang.Object r0 = U.b.k(r0)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            if (r0 == 0) goto L_0x0132
            com.google.android.gms.dynamite.DynamiteModule r5 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r5.<init>(r0)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x012f:
            r0 = r5
            goto L_0x0240
        L_0x0132:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "Failed to get module context"
            r12 = r18
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x013c:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x013f:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "No result cursor"
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x0148:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "DynamiteLoaderV2 was not cached."
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x0151:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0151 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x0154:
            java.lang.String r5 = "DynamiteModule"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r12.<init>()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r15 = "Selected remote version of "
            r12.append(r15)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r12.append(r3)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r15 = ", version >= "
            r12.append(r15)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r12.append(r14)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r12 = r12.toString()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            android.util.Log.i(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            com.google.android.gms.dynamite.m r5 = l(r1)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            if (r5 == 0) goto L_0x01d8
            int r12 = r5.k()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r15 = 3
            if (r12 < r15) goto L_0x019f
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            com.google.android.gms.dynamite.k r0 = (com.google.android.gms.dynamite.k) r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            if (r0 == 0) goto L_0x0196
            U.a r12 = U.b.q0(r1)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            android.database.Cursor r0 = r0.f4918a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = U.b.q0(r0)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = r5.t0(r12, r3, r14, r0)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            goto L_0x01c0
        L_0x0196:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "No cached result cursor holder"
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x019f:
            if (r12 != r13) goto L_0x01b1
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r12 = "IDynamite loader version = 2"
            android.util.Log.w(r0, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = U.b.q0(r1)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = r5.u0(r0, r3, r14)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            goto L_0x01c0
        L_0x01b1:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r12 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r0, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = U.b.q0(r1)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            U.a r0 = r5.s0(r0, r3, r14)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x01c0:
            java.lang.Object r0 = U.b.k(r0)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            if (r0 == 0) goto L_0x01cf
            com.google.android.gms.dynamite.DynamiteModule r5 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            r5.<init>(r0)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            goto L_0x012f
        L_0x01cf:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "Failed to load remote module."
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x01d8:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "Failed to create IDynamiteLoader."
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x01e1:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            java.lang.String r5 = "Failed to determine which loading route to use."
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x01ea:
            r0 = move-exception
            goto L_0x01f5
        L_0x01ec:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x01ea }
            java.lang.String r5 = "Remote loading disabled"
            r12 = 0
            r0.<init>(r5, r12)     // Catch:{ all -> 0x01ea }
            throw r0     // Catch:{ all -> 0x01ea }
        L_0x01f5:
            monitor-exit(r15)     // Catch:{ all -> 0x01ea }
            throw r0     // Catch:{ RemoteException -> 0x010c, a -> 0x0109, all -> 0x0106 }
        L_0x01f7:
            com.google.android.gms.common.util.f.a(r1, r0)     // Catch:{ a -> 0x0203 }
            com.google.android.gms.dynamite.DynamiteModule$a r5 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ a -> 0x0203 }
            java.lang.String r12 = "Failed to load remote module."
            r13 = 0
            r5.<init>(r12, r0, r13)     // Catch:{ a -> 0x0203 }
            throw r5     // Catch:{ a -> 0x0203 }
        L_0x0203:
            r0 = move-exception
            goto L_0x020f
        L_0x0205:
            throw r0     // Catch:{ a -> 0x0203 }
        L_0x0206:
            com.google.android.gms.dynamite.DynamiteModule$a r5 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ a -> 0x0203 }
            java.lang.String r12 = "Failed to load remote module."
            r13 = 0
            r5.<init>(r12, r0, r13)     // Catch:{ a -> 0x0203 }
            throw r5     // Catch:{ a -> 0x0203 }
        L_0x020f:
            java.lang.String r5 = "DynamiteModule"
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r13.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r14 = "Failed to load remote module: "
            r13.append(r14)     // Catch:{ all -> 0x007d }
            r13.append(r12)     // Catch:{ all -> 0x007d }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x007d }
            android.util.Log.w(r5, r12)     // Catch:{ all -> 0x007d }
            int r5 = r8.f4915a     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x025c
            com.google.android.gms.dynamite.l r8 = new com.google.android.gms.dynamite.l     // Catch:{ all -> 0x007d }
            r12 = 0
            r8.<init>(r5, r12)     // Catch:{ all -> 0x007d }
            com.google.android.gms.dynamite.DynamiteModule$b$b r1 = r2.a(r1, r3, r8)     // Catch:{ all -> 0x007d }
            int r1 = r1.f4917c     // Catch:{ all -> 0x007d }
            r2 = -1
            if (r1 != r2) goto L_0x025c
            com.google.android.gms.dynamite.DynamiteModule r0 = h(r4, r3)     // Catch:{ all -> 0x007d }
        L_0x0240:
            int r1 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x024a
            java.lang.ThreadLocal r1 = f4909n
            r1.remove()
            goto L_0x024f
        L_0x024a:
            java.lang.ThreadLocal r1 = f4909n
            r1.set(r9)
        L_0x024f:
            android.database.Cursor r1 = r7.f4918a
            if (r1 == 0) goto L_0x0256
            r1.close()
        L_0x0256:
            java.lang.ThreadLocal r1 = f4908m
            r1.set(r6)
            return r0
        L_0x025c:
            com.google.android.gms.dynamite.DynamiteModule$a r1 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r12 = 0
            r1.<init>(r2, r0, r12)     // Catch:{ all -> 0x007d }
            throw r1     // Catch:{ all -> 0x007d }
        L_0x0265:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "VersionPolicy returned invalid code:"
            r1.append(r2)     // Catch:{ all -> 0x007d }
            r1.append(r5)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007d }
            r12 = 0
            r0.<init>(r1, r12)     // Catch:{ all -> 0x007d }
            throw r0     // Catch:{ all -> 0x007d }
        L_0x027d:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x007d }
            int r1 = r8.f4915a     // Catch:{ all -> 0x007d }
            int r2 = r8.f4916b     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r4.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r5 = "No acceptable module "
            r4.append(r5)     // Catch:{ all -> 0x007d }
            r4.append(r3)     // Catch:{ all -> 0x007d }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x007d }
            r4.append(r1)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x007d }
            r4.append(r2)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x007d }
            r12 = 0
            r0.<init>(r1, r12)     // Catch:{ all -> 0x007d }
            throw r0     // Catch:{ all -> 0x007d }
        L_0x02ae:
            r0 = move-exception
            r16 = 0
        L_0x02b1:
            int r1 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x02bb
            java.lang.ThreadLocal r1 = f4909n
            r1.remove()
            goto L_0x02c0
        L_0x02bb:
            java.lang.ThreadLocal r1 = f4909n
            r1.set(r9)
        L_0x02c0:
            android.database.Cursor r1 = r7.f4918a
            if (r1 == 0) goto L_0x02c7
            r1.close()
        L_0x02c7:
            java.lang.ThreadLocal r1 = f4908m
            r1.set(r6)
            throw r0
        L_0x02cd:
            com.google.android.gms.dynamite.DynamiteModule$a r0 = new com.google.android.gms.dynamite.DynamiteModule$a
            java.lang.String r1 = "null application Context"
            r12 = 0
            r0.<init>(r1, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$b, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
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
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:53:0x00a3=Splitter:B:53:0x00a3, B:34:0x005d=Splitter:B:34:0x005d, B:18:0x003e=Splitter:B:18:0x003e} */
    public static int f(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ all -> 0x00ec }
            java.lang.Boolean r0 = f4903h     // Catch:{ all -> 0x004b }
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x00e0
            android.content.Context r0 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            java.lang.Class r0 = r0.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            java.lang.Class r4 = r0.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
            java.lang.Object r5 = r0.get(r2)     // Catch:{ all -> 0x0036 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x0036 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0036 }
            if (r5 != r6) goto L_0x0039
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0036 }
            goto L_0x00b9
        L_0x0036:
            r0 = move-exception
            goto L_0x00bb
        L_0x0039:
            if (r5 == 0) goto L_0x0042
            i(r5)     // Catch:{ a -> 0x003e }
        L_0x003e:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0036 }
            goto L_0x00b9
        L_0x0042:
            boolean r5 = k(r10)     // Catch:{ all -> 0x0036 }
            if (r5 != 0) goto L_0x004f
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r3
        L_0x004b:
            r0 = move-exception
            r11 = r0
            goto L_0x01d6
        L_0x004f:
            boolean r5 = f4905j     // Catch:{ all -> 0x0036 }
            if (r5 != 0) goto L_0x00b0
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0036 }
            boolean r6 = r5.equals(r2)     // Catch:{ all -> 0x0036 }
            if (r6 == 0) goto L_0x005c
            goto L_0x00b0
        L_0x005c:
            r6 = 1
            int r6 = g(r10, r11, r12, r6)     // Catch:{ a -> 0x00a6 }
            java.lang.String r7 = f4904i     // Catch:{ a -> 0x00a6 }
            if (r7 == 0) goto L_0x00a3
            boolean r7 = r7.isEmpty()     // Catch:{ a -> 0x00a6 }
            if (r7 == 0) goto L_0x006c
            goto L_0x00a3
        L_0x006c:
            java.lang.ClassLoader r7 = V.d.a()     // Catch:{ a -> 0x00a6 }
            if (r7 == 0) goto L_0x0073
            goto L_0x0098
        L_0x0073:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ a -> 0x00a6 }
            r8 = 29
            if (r7 < r8) goto L_0x008a
            V.b.a()     // Catch:{ a -> 0x00a6 }
            java.lang.String r7 = f4904i     // Catch:{ a -> 0x00a6 }
            N.C0722p.k(r7)     // Catch:{ a -> 0x00a6 }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x00a6 }
            dalvik.system.DelegateLastClassLoader r7 = V.a.a(r7, r8)     // Catch:{ a -> 0x00a6 }
            goto L_0x0098
        L_0x008a:
            com.google.android.gms.dynamite.a r7 = new com.google.android.gms.dynamite.a     // Catch:{ a -> 0x00a6 }
            java.lang.String r8 = f4904i     // Catch:{ a -> 0x00a6 }
            N.C0722p.k(r8)     // Catch:{ a -> 0x00a6 }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x00a6 }
            r7.<init>(r8, r9)     // Catch:{ a -> 0x00a6 }
        L_0x0098:
            i(r7)     // Catch:{ a -> 0x00a6 }
            r0.set(r2, r7)     // Catch:{ a -> 0x00a6 }
            f4903h = r5     // Catch:{ a -> 0x00a6 }
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r6
        L_0x00a3:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r6
        L_0x00a6:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0036 }
            r0.set(r2, r5)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0036 }
            goto L_0x00b9
        L_0x00b0:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0036 }
            r0.set(r2, r5)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0036 }
        L_0x00b9:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            goto L_0x00de
        L_0x00bb:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x00c1, IllegalAccessException -> 0x00bf, NoSuchFieldException -> 0x00bd }
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c2
        L_0x00bf:
            r0 = move-exception
            goto L_0x00c2
        L_0x00c1:
            r0 = move-exception
        L_0x00c2:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r5.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x004b }
            r5.append(r0)     // Catch:{ all -> 0x004b }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x004b }
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x004b }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x004b }
        L_0x00de:
            f4903h = r0     // Catch:{ all -> 0x004b }
        L_0x00e0:
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x010d
            int r10 = g(r10, r11, r12, r3)     // Catch:{ a -> 0x00f0 }
            return r10
        L_0x00ec:
            r0 = move-exception
            r11 = r0
            goto L_0x01d8
        L_0x00f0:
            r0 = move-exception
            r11 = r0
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00ec }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r0.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x00ec }
            r0.append(r11)     // Catch:{ all -> 0x00ec }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x00ec }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x00ec }
            return r3
        L_0x010d:
            com.google.android.gms.dynamite.m r4 = l(r10)     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x0115
            goto L_0x01cc
        L_0x0115:
            int r0 = r4.k()     // Catch:{ RemoteException -> 0x0130 }
            r1 = 3
            if (r0 < r1) goto L_0x0185
            java.lang.ThreadLocal r0 = f4908m     // Catch:{ RemoteException -> 0x0130 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0130 }
            com.google.android.gms.dynamite.k r0 = (com.google.android.gms.dynamite.k) r0     // Catch:{ RemoteException -> 0x0130 }
            if (r0 == 0) goto L_0x0134
            android.database.Cursor r0 = r0.f4918a     // Catch:{ RemoteException -> 0x0130 }
            if (r0 == 0) goto L_0x0134
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0130 }
            goto L_0x01cc
        L_0x0130:
            r0 = move-exception
            r11 = r0
            goto L_0x01ac
        L_0x0134:
            U.a r5 = U.b.q0(r10)     // Catch:{ RemoteException -> 0x0130 }
            java.lang.ThreadLocal r0 = f4909n     // Catch:{ RemoteException -> 0x0130 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0130 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0130 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0130 }
            r6 = r11
            r7 = r12
            U.a r11 = r4.v0(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0130 }
            java.lang.Object r11 = U.b.k(r11)     // Catch:{ RemoteException -> 0x0130 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0130 }
            if (r11 == 0) goto L_0x0174
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x0169, all -> 0x0166 }
            if (r12 != 0) goto L_0x0159
            goto L_0x0174
        L_0x0159:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x0169, all -> 0x0166 }
            if (r12 <= 0) goto L_0x016c
            boolean r0 = j(r11)     // Catch:{ RemoteException -> 0x0169, all -> 0x0166 }
            if (r0 == 0) goto L_0x016c
            goto L_0x016d
        L_0x0166:
            r0 = move-exception
            r12 = r0
            goto L_0x0181
        L_0x0169:
            r0 = move-exception
            r12 = r0
            goto L_0x0183
        L_0x016c:
            r2 = r11
        L_0x016d:
            if (r2 == 0) goto L_0x0172
            r2.close()     // Catch:{ all -> 0x00ec }
        L_0x0172:
            r3 = r12
            goto L_0x01cc
        L_0x0174:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x0169, all -> 0x0166 }
            if (r11 == 0) goto L_0x01cc
            r11.close()     // Catch:{ all -> 0x00ec }
            goto L_0x01cc
        L_0x0181:
            r2 = r11
            goto L_0x01d0
        L_0x0183:
            r2 = r11
            goto L_0x01ad
        L_0x0185:
            r6 = r11
            r7 = r12
            r11 = 2
            if (r0 != r11) goto L_0x019a
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r11, r12)     // Catch:{ RemoteException -> 0x0130 }
            U.a r11 = U.b.q0(r10)     // Catch:{ RemoteException -> 0x0130 }
            int r3 = r4.r0(r11, r6, r7)     // Catch:{ RemoteException -> 0x0130 }
            goto L_0x01cc
        L_0x019a:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r11, r12)     // Catch:{ RemoteException -> 0x0130 }
            U.a r11 = U.b.q0(r10)     // Catch:{ RemoteException -> 0x0130 }
            int r3 = r4.q0(r11, r6, r7)     // Catch:{ RemoteException -> 0x0130 }
            goto L_0x01cc
        L_0x01aa:
            r12 = r11
            goto L_0x01d0
        L_0x01ac:
            r12 = r11
        L_0x01ad:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01cd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cd }
            r0.<init>()     // Catch:{ all -> 0x01cd }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01cd }
            r0.append(r12)     // Catch:{ all -> 0x01cd }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01cd }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01cd }
            if (r2 == 0) goto L_0x01cc
            r2.close()     // Catch:{ all -> 0x00ec }
        L_0x01cc:
            return r3
        L_0x01cd:
            r0 = move-exception
            r11 = r0
            goto L_0x01aa
        L_0x01d0:
            if (r2 == 0) goto L_0x01d5
            r2.close()     // Catch:{ all -> 0x00ec }
        L_0x01d5:
            throw r12     // Catch:{ all -> 0x00ec }
        L_0x01d6:
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r11     // Catch:{ all -> 0x00ec }
        L_0x01d8:
            com.google.android.gms.common.util.f.a(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0055 */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ec A[SYNTHETIC, Splitter:B:64:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int g(android.content.Context r12, java.lang.String r13, boolean r14, boolean r15) {
        /*
            r1 = 0
            java.lang.ThreadLocal r0 = f4909n     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            long r2 = r0.longValue()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            java.lang.String r0 = "api_force_staging"
            java.lang.String r4 = "api"
            r5 = 1
            if (r5 == r14) goto L_0x0015
            r0 = r4
        L_0x0015:
            android.net.Uri$Builder r14 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            r14.<init>()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r14 = r14.scheme(r4)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r14 = r14.authority(r4)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            android.net.Uri$Builder r14 = r14.path(r0)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            android.net.Uri$Builder r13 = r14.appendPath(r13)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            java.lang.String r14 = "requestStartUptime"
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            android.net.Uri$Builder r13 = r13.appendQueryParameter(r14, r0)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            android.net.Uri r7 = r13.build()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            android.content.ContentResolver r12 = r12.getContentResolver()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            android.content.ContentProviderClient r6 = r12.acquireUnstableContentProviderClient(r7)     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            r12 = 2
            r13 = 0
            if (r6 != 0) goto L_0x004b
        L_0x0048:
            r3 = r1
            goto L_0x00ea
        L_0x004b:
            r10 = 0
            r11 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r14 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ RemoteException -> 0x0055, all -> 0x00d9 }
            if (r14 != 0) goto L_0x0061
        L_0x0055:
            r6.release()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            goto L_0x0048
        L_0x0059:
            r0 = move-exception
            r12 = r0
            goto L_0x017c
        L_0x005d:
            r0 = move-exception
            r12 = r0
            goto L_0x015b
        L_0x0061:
            int r0 = r14.getCount()     // Catch:{ all -> 0x0097 }
            int r2 = r14.getColumnCount()     // Catch:{ all -> 0x0097 }
            android.database.MatrixCursor r3 = new android.database.MatrixCursor     // Catch:{ all -> 0x0097 }
            java.lang.String[] r4 = r14.getColumnNames()     // Catch:{ all -> 0x0097 }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0097 }
            r4 = r13
        L_0x0073:
            if (r4 >= r0) goto L_0x00d2
            boolean r7 = r14.moveToPosition(r4)     // Catch:{ all -> 0x0097 }
            if (r7 == 0) goto L_0x00ca
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0097 }
            r8 = r13
        L_0x007e:
            if (r8 >= r2) goto L_0x00c4
            int r9 = r14.getType(r8)     // Catch:{ all -> 0x0097 }
            if (r9 == 0) goto L_0x00bf
            if (r9 == r5) goto L_0x00b4
            if (r9 == r12) goto L_0x00a9
            r10 = 3
            if (r9 == r10) goto L_0x00a2
            r10 = 4
            if (r9 != r10) goto L_0x009a
            byte[] r9 = r14.getBlob(r8)     // Catch:{ all -> 0x0097 }
            r7[r8] = r9     // Catch:{ all -> 0x0097 }
            goto L_0x00c1
        L_0x0097:
            r0 = move-exception
            r2 = r0
            goto L_0x00dc
        L_0x009a:
            android.os.RemoteException r0 = new android.os.RemoteException     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "Unknown column type"
            r0.<init>(r2)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x00a2:
            java.lang.String r9 = r14.getString(r8)     // Catch:{ all -> 0x0097 }
            r7[r8] = r9     // Catch:{ all -> 0x0097 }
            goto L_0x00c1
        L_0x00a9:
            double r9 = r14.getDouble(r8)     // Catch:{ all -> 0x0097 }
            java.lang.Double r9 = java.lang.Double.valueOf(r9)     // Catch:{ all -> 0x0097 }
            r7[r8] = r9     // Catch:{ all -> 0x0097 }
            goto L_0x00c1
        L_0x00b4:
            long r9 = r14.getLong(r8)     // Catch:{ all -> 0x0097 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0097 }
            r7[r8] = r9     // Catch:{ all -> 0x0097 }
            goto L_0x00c1
        L_0x00bf:
            r7[r8] = r1     // Catch:{ all -> 0x0097 }
        L_0x00c1:
            int r8 = r8 + 1
            goto L_0x007e
        L_0x00c4:
            r3.addRow(r7)     // Catch:{ all -> 0x0097 }
            int r4 = r4 + 1
            goto L_0x0073
        L_0x00ca:
            android.os.RemoteException r0 = new android.os.RemoteException     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "Cursor read incomplete (ContentProvider dead?)"
            r0.<init>(r2)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x00d2:
            r14.close()     // Catch:{ RemoteException -> 0x0055, all -> 0x00d9 }
            r6.release()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            goto L_0x00ea
        L_0x00d9:
            r0 = move-exception
            r12 = r0
            goto L_0x00e6
        L_0x00dc:
            r14.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00e5
        L_0x00e0:
            r0 = move-exception
            r14 = r0
            r2.addSuppressed(r14)     // Catch:{ RemoteException -> 0x0055, all -> 0x00d9 }
        L_0x00e5:
            throw r2     // Catch:{ RemoteException -> 0x0055, all -> 0x00d9 }
        L_0x00e6:
            r6.release()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            throw r12     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
        L_0x00ea:
            if (r3 == 0) goto L_0x014c
            boolean r14 = r3.moveToFirst()     // Catch:{ Exception -> 0x0141 }
            if (r14 == 0) goto L_0x014c
            int r14 = r3.getInt(r13)     // Catch:{ Exception -> 0x0141 }
            if (r14 <= 0) goto L_0x0131
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r2 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r12 = r3.getString(r12)     // Catch:{ all -> 0x0110 }
            f4904i = r12     // Catch:{ all -> 0x0110 }
            java.lang.String r12 = "loaderVersion"
            int r12 = r3.getColumnIndex(r12)     // Catch:{ all -> 0x0110 }
            if (r12 < 0) goto L_0x0113
            int r12 = r3.getInt(r12)     // Catch:{ all -> 0x0110 }
            f4906k = r12     // Catch:{ all -> 0x0110 }
            goto L_0x0113
        L_0x0110:
            r0 = move-exception
            r12 = r0
            goto L_0x012f
        L_0x0113:
            java.lang.String r12 = "disableStandaloneDynamiteLoader2"
            int r12 = r3.getColumnIndex(r12)     // Catch:{ all -> 0x0110 }
            if (r12 < 0) goto L_0x0126
            int r12 = r3.getInt(r12)     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x0122
            goto L_0x0123
        L_0x0122:
            r5 = r13
        L_0x0123:
            f4905j = r5     // Catch:{ all -> 0x0110 }
            r13 = r5
        L_0x0126:
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            boolean r12 = j(r3)     // Catch:{ Exception -> 0x0141 }
            if (r12 == 0) goto L_0x0131
            r3 = r1
            goto L_0x0131
        L_0x012f:
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ Exception -> 0x0141 }
        L_0x0131:
            if (r15 == 0) goto L_0x0146
            if (r13 != 0) goto L_0x0136
            goto L_0x0146
        L_0x0136:
            com.google.android.gms.dynamite.DynamiteModule$a r12 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x0141 }
            java.lang.String r13 = "forcing fallback to container DynamiteLoader impl"
            r12.<init>(r13, r1)     // Catch:{ Exception -> 0x0141 }
            throw r12     // Catch:{ Exception -> 0x0141 }
        L_0x013e:
            r0 = move-exception
            r12 = r0
            goto L_0x0144
        L_0x0141:
            r0 = move-exception
            r12 = r0
            goto L_0x015c
        L_0x0144:
            r1 = r3
            goto L_0x017c
        L_0x0146:
            if (r3 == 0) goto L_0x014b
            r3.close()
        L_0x014b:
            return r14
        L_0x014c:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r13 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r13)     // Catch:{ Exception -> 0x0141 }
            com.google.android.gms.dynamite.DynamiteModule$a r12 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x0141 }
            java.lang.String r13 = "Failed to connect to dynamite module ContentResolver."
            r12.<init>(r13, r1)     // Catch:{ Exception -> 0x0141 }
            throw r12     // Catch:{ Exception -> 0x0141 }
        L_0x015b:
            r3 = r1
        L_0x015c:
            boolean r13 = r12 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch:{ all -> 0x013e }
            if (r13 == 0) goto L_0x0161
            throw r12     // Catch:{ all -> 0x013e }
        L_0x0161:
            com.google.android.gms.dynamite.DynamiteModule$a r13 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x013e }
            java.lang.String r14 = r12.getMessage()     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            r15.<init>()     // Catch:{ all -> 0x013e }
            java.lang.String r0 = "V2 version check failed: "
            r15.append(r0)     // Catch:{ all -> 0x013e }
            r15.append(r14)     // Catch:{ all -> 0x013e }
            java.lang.String r14 = r15.toString()     // Catch:{ all -> 0x013e }
            r13.<init>(r14, r12, r1)     // Catch:{ all -> 0x013e }
            throw r13     // Catch:{ all -> 0x013e }
        L_0x017c:
            if (r1 == 0) goto L_0x0181
            r1.close()
        L_0x0181:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.g(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule h(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void i(ClassLoader classLoader) {
        n nVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor((Class[]) null).newInstance((Object[]) null);
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof n) {
                    nVar = (n) queryLocalInterface;
                } else {
                    nVar = new n(iBinder);
                }
            }
            f4913r = nVar;
        } catch (ClassNotFoundException e5) {
            e = e5;
            throw new a("Failed to instantiate dynamite loader", e, (e) null);
        } catch (IllegalAccessException e6) {
            e = e6;
            throw new a("Failed to instantiate dynamite loader", e, (e) null);
        } catch (InstantiationException e7) {
            e = e7;
            throw new a("Failed to instantiate dynamite loader", e, (e) null);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new a("Failed to instantiate dynamite loader", e, (e) null);
        } catch (NoSuchMethodException e9) {
            e = e9;
            throw new a("Failed to instantiate dynamite loader", e, (e) null);
        }
    }

    private static boolean j(Cursor cursor) {
        k kVar = (k) f4908m.get();
        if (kVar == null || kVar.f4918a != null) {
            return false;
        }
        kVar.f4918a = cursor;
        return true;
    }

    private static boolean k(Context context) {
        int i5;
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(f4907l)) {
            return true;
        }
        boolean z4 = false;
        if (f4907l == null) {
            PackageManager packageManager = context.getPackageManager();
            if (true != k.g()) {
                i5 = 0;
            } else {
                i5 = 268435456;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.chimera", i5);
            if (C0661h.f().h(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z4 = true;
            }
            f4907l = Boolean.valueOf(z4);
            if (z4 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f4905j = true;
            }
        }
        if (!z4) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z4;
    }

    private static m l(Context context) {
        m mVar;
        synchronized (DynamiteModule.class) {
            m mVar2 = f4912q;
            if (mVar2 != null) {
                return mVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof m) {
                        mVar = (m) queryLocalInterface;
                    } else {
                        mVar = new m(iBinder);
                    }
                }
                if (mVar != null) {
                    f4912q = mVar;
                    return mVar;
                }
            } catch (Exception e5) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e5.getMessage());
            }
        }
        return null;
    }

    public Context b() {
        return this.f4914a;
    }

    public IBinder d(String str) {
        try {
            return (IBinder) this.f4914a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e5) {
            throw new a("Failed to instantiate module class: ".concat(String.valueOf(str)), e5, (e) null);
        }
    }
}
