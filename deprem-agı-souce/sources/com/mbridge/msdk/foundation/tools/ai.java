package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.b;
import com.mbridge.msdk.foundation.same.b.d;
import com.mbridge.msdk.foundation.same.b.e;
import java.io.File;
import java.util.UUID;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f9631a = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* renamed from: b  reason: collision with root package name */
    static String f9632b = "";

    /* renamed from: c  reason: collision with root package name */
    static boolean f9633c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f9634d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static int f9635e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f9636f = false;

    /* renamed from: g  reason: collision with root package name */
    private static int f9637g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static int f9638h = -1;

    public static int a() {
        try {
            Context c5 = c.m().c();
            long longValue = ((Long) an.a(c5, "freeExternalSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f9635e == -1) {
                f9635e = Long.valueOf((c() / 1000) / 1000).intValue();
                an.b(c5, "freeExternalSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            af.b("SameSDCardTool", th.getMessage(), th);
        }
        return f9635e;
    }

    public static int b() {
        if (f9638h == -1) {
            try {
                f9638h = new Long((e() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                af.b("SameSDCardTool", th.getMessage(), th);
            }
        }
        return f9638h;
    }

    private static long c() {
        if (d()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return 0;
    }

    private static boolean d() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            af.b("", "hasSDCard is failed");
            return false;
        }
    }

    private static long e() {
        if (d()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return 0;
    }

    private static void b(Context context) {
        e.a((b) new d(c(context)));
        e.a().b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (c() > 31457280) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r6) {
        /*
            r0 = 0
            java.io.File r1 = r6.getExternalFilesDir(r0)     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0014
            java.io.File r1 = a((java.io.File) r1)     // Catch:{ all -> 0x000c }
            goto L_0x0015
        L_0x000c:
            r1 = move-exception
            java.lang.String r2 = "common-exception"
            java.lang.String r3 = "hasSDCard is failed"
            com.mbridge.msdk.foundation.tools.af.b(r2, r3, r1)
        L_0x0014:
            r1 = r0
        L_0x0015:
            boolean r2 = f9633c
            if (r2 == 0) goto L_0x005f
            if (r1 != 0) goto L_0x0054
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r3 = "Android"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r3 = "data"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = r6.getPackageName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            java.io.File r1 = a((java.io.File) r2)
        L_0x0054:
            long r2 = c()
            r4 = 31457280(0x1e00000, double:1.55419614E-316)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0060
        L_0x005f:
            r0 = r1
        L_0x0060:
            if (r0 == 0) goto L_0x0068
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0070
        L_0x0068:
            java.io.File r6 = r6.getFilesDir()
            java.io.File r0 = r6.getAbsoluteFile()
        L_0x0070:
            java.lang.String r6 = r0.getAbsolutePath()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ai.c(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2) {
        /*
            if (r2 != 0) goto L_0x0003
            goto L_0x004a
        L_0x0003:
            boolean r0 = f9636f
            if (r0 != 0) goto L_0x004a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0029 }
            r0.<init>()     // Catch:{ Exception -> 0x0029 }
            java.io.File r1 = r2.getFilesDir()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0029 }
            r0.append(r1)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0029 }
            r0.append(r1)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0029 }
            f9632b = r0     // Catch:{ Exception -> 0x0029 }
            r0 = 0
            f9633c = r0     // Catch:{ Exception -> 0x0029 }
            b(r2)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0047
        L_0x0029:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0047 }
            r0.<init>()     // Catch:{ Exception -> 0x0047 }
            java.io.File r1 = r2.getFilesDir()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0047 }
            r0.append(r1)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0047 }
            r0.append(r1)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0047 }
            f9632b = r0     // Catch:{ Exception -> 0x0047 }
            b(r2)     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            r2 = 1
            f9636f = r2
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ai.a(android.content.Context):void");
    }

    private static File a(File file) {
        File file2 = new File(file, UUID.randomUUID() + "");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }
}
