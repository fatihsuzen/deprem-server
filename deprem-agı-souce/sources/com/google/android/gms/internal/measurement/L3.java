package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public abstract class L3 {

    /* renamed from: a  reason: collision with root package name */
    private static UserManager f5014a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f5015b = (!a());

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean b(Context context) {
        if (!a() || d(context)) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        if (!a() || d(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(android.content.Context r7) {
        /*
            boolean r0 = f5015b
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.measurement.L3> r0 = com.google.android.gms.internal.measurement.L3.class
            monitor-enter(r0)
            boolean r2 = f5015b     // Catch:{ all -> 0x000f }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r1
        L_0x000f:
            r7 = move-exception
            goto L_0x0054
        L_0x0011:
            r2 = r1
        L_0x0012:
            r3 = 2
            r4 = 0
            r5 = 0
            if (r2 > r3) goto L_0x004a
            android.os.UserManager r3 = f5014a     // Catch:{ all -> 0x000f }
            if (r3 != 0) goto L_0x0025
            java.lang.Class<android.os.UserManager> r3 = android.os.UserManager.class
            java.lang.Object r3 = r7.getSystemService(r3)     // Catch:{ all -> 0x000f }
            android.os.UserManager r3 = (android.os.UserManager) r3     // Catch:{ all -> 0x000f }
            f5014a = r3     // Catch:{ all -> 0x000f }
        L_0x0025:
            android.os.UserManager r3 = f5014a     // Catch:{ all -> 0x000f }
            if (r3 != 0) goto L_0x002b
            r5 = r1
            goto L_0x004e
        L_0x002b:
            boolean r6 = r3.isUserUnlocked()     // Catch:{ NullPointerException -> 0x003d }
            if (r6 != 0) goto L_0x003b
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch:{ NullPointerException -> 0x003d }
            boolean r7 = r3.isUserRunning(r6)     // Catch:{ NullPointerException -> 0x003d }
            if (r7 != 0) goto L_0x004a
        L_0x003b:
            r5 = r1
            goto L_0x004a
        L_0x003d:
            r3 = move-exception
            java.lang.String r5 = "DirectBootUtils"
            java.lang.String r6 = "Failed to check if user is unlocked."
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x000f }
            f5014a = r4     // Catch:{ all -> 0x000f }
            int r2 = r2 + 1
            goto L_0x0012
        L_0x004a:
            if (r5 == 0) goto L_0x004e
            f5014a = r4     // Catch:{ all -> 0x000f }
        L_0x004e:
            if (r5 == 0) goto L_0x0052
            f5015b = r1     // Catch:{ all -> 0x000f }
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r5
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.L3.d(android.content.Context):boolean");
    }
}
