package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* renamed from: com.google.android.gms.internal.measurement.n0  reason: case insensitive filesystem */
public abstract class C1165n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f5479a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f5480b;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 0
            r4 = 24
            if (r0 < r4) goto L_0x0033
            java.lang.Class<android.app.job.JobScheduler> r0 = android.app.job.JobScheduler.class
            java.lang.String r5 = "scheduleAsPackage"
            r6 = 4
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobInfo> r7 = android.app.job.JobInfo.class
            r8 = 0
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r8 = 1
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r9 = 2
            r6[r9] = r8     // Catch:{ NoSuchMethodException -> 0x0028 }
            r8 = 3
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x0034
        L_0x0028:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r2, r0)
        L_0x0033:
            r0 = r3
        L_0x0034:
            f5479a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x004e
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r4 = "myUserId"
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0043 }
            goto L_0x004e
        L_0x0043:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r2, r0)
        L_0x004e:
            f5480b = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1165n0.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b A[SYNTHETIC, Splitter:B:18:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            java.lang.Object r7 = l0.h.h(r7)
            android.app.job.JobScheduler r7 = (android.app.job.JobScheduler) r7
            java.lang.reflect.Method r8 = f5479a
            if (r8 == 0) goto L_0x0079
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 == 0) goto L_0x001b
            goto L_0x0079
        L_0x001b:
            java.lang.reflect.Method r5 = f5480b
            r8 = 0
            if (r5 == 0) goto L_0x0034
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            if (r5 == 0) goto L_0x0034
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            goto L_0x0045
        L_0x0030:
            r5 = move-exception
            goto L_0x0036
        L_0x0032:
            r5 = move-exception
            goto L_0x0036
        L_0x0034:
            r5 = r8
            goto L_0x0045
        L_0x0036:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
            goto L_0x0034
        L_0x0045:
            java.lang.String r0 = "UploadAlarm"
            java.lang.reflect.Method r1 = f5479a
            if (r1 == 0) goto L_0x0074
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            r2[r8] = r6     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            java.lang.String r3 = "com.google.android.gms"
            r4 = 1
            r2[r4] = r3     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            r3 = 2
            r2[r3] = r5     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            r5 = 3
            r2[r5] = r0     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            java.lang.Object r5 = r1.invoke(r7, r2)     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            if (r5 == 0) goto L_0x0078
            int r8 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x006e, InvocationTargetException -> 0x006c }
            goto L_0x0078
        L_0x006c:
            r5 = move-exception
            goto L_0x006f
        L_0x006e:
            r5 = move-exception
        L_0x006f:
            java.lang.String r8 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r8, r5)
        L_0x0074:
            int r8 = r7.schedule(r6)
        L_0x0078:
            return r8
        L_0x0079:
            int r5 = r7.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1165n0.a(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
