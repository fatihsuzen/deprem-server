package com.google.android.gms.common.util;

import T.e;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.lang.reflect.Method;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4887a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f4888b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f4889c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f4890d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f4891e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f4892f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f4893g;

    /* renamed from: h  reason: collision with root package name */
    private static final Method f4894h;

    /* renamed from: i  reason: collision with root package name */
    private static final Method f4895i;

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f4896j = null;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            java.lang.Class r2 = java.lang.Integer.TYPE
            java.lang.Class<android.os.WorkSource> r3 = android.os.WorkSource.class
            int r4 = android.os.Process.myUid()
            f4887a = r4
            r4 = 0
            r5 = 1
            r6 = 0
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x001a }
            r7[r4] = r2     // Catch:{ Exception -> 0x001a }
            java.lang.reflect.Method r7 = r3.getMethod(r1, r7)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r7 = r6
        L_0x001b:
            f4888b = r7
            r7 = 2
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0029 }
            r8[r4] = r2     // Catch:{ Exception -> 0x0029 }
            r8[r5] = r0     // Catch:{ Exception -> 0x0029 }
            java.lang.reflect.Method r1 = r3.getMethod(r1, r8)     // Catch:{ Exception -> 0x0029 }
            goto L_0x002a
        L_0x0029:
            r1 = r6
        L_0x002a:
            f4889c = r1
            java.lang.String r1 = "size"
            java.lang.reflect.Method r1 = r3.getMethod(r1, r6)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r1 = r6
        L_0x0034:
            f4890d = r1
            java.lang.String r1 = "get"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0041 }
            r8[r4] = r2     // Catch:{ Exception -> 0x0041 }
            java.lang.reflect.Method r1 = r3.getMethod(r1, r8)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r1 = r6
        L_0x0042:
            f4891e = r1
            java.lang.String r1 = "getName"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x004f }
            r8[r4] = r2     // Catch:{ Exception -> 0x004f }
            java.lang.reflect.Method r1 = r3.getMethod(r1, r8)     // Catch:{ Exception -> 0x004f }
            goto L_0x0050
        L_0x004f:
            r1 = r6
        L_0x0050:
            f4892f = r1
            boolean r1 = com.google.android.gms.common.util.k.f()
            java.lang.String r8 = "WorkSourceUtil"
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = "createWorkChain"
            java.lang.reflect.Method r1 = r3.getMethod(r1, r6)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0068
        L_0x0061:
            r1 = move-exception
            java.lang.String r9 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r8, r9, r1)
        L_0x0067:
            r1 = r6
        L_0x0068:
            f4893g = r1
            boolean r1 = com.google.android.gms.common.util.k.f()
            if (r1 == 0) goto L_0x0089
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r9 = "addNode"
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0083 }
            r7[r4] = r2     // Catch:{ Exception -> 0x0083 }
            r7[r5] = r0     // Catch:{ Exception -> 0x0083 }
            java.lang.reflect.Method r0 = r1.getMethod(r9, r7)     // Catch:{ Exception -> 0x0083 }
            goto L_0x008a
        L_0x0083:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r8, r1, r0)
        L_0x0089:
            r0 = r6
        L_0x008a:
            f4894h = r0
            boolean r0 = com.google.android.gms.common.util.k.f()
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r3.getMethod(r0, r6)     // Catch:{ Exception -> 0x009c }
            r0.setAccessible(r5)     // Catch:{ Exception -> 0x009d }
            goto L_0x009d
        L_0x009c:
            r0 = r6
        L_0x009d:
            f4895i = r0
            f4896j = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.q.<clinit>():void");
    }

    public static void a(WorkSource workSource, int i5, String str) {
        Method method = f4889c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i5), str});
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            }
        } else {
            Method method2 = f4888b;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i5)});
                } catch (Exception e6) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
                }
            }
        }
    }

    public static WorkSource b(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo c5 = e.a(context).c(str, 0);
                if (c5 == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i5 = c5.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i5, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static synchronized boolean c(Context context) {
        synchronized (q.class) {
            Boolean bool = f4896j;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z4 = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z4 = true;
            }
            f4896j = Boolean.valueOf(z4);
            return z4;
        }
    }
}
