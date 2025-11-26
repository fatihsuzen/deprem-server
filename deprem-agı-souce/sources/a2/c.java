package A2;

import android.content.Context;
import java.io.File;

public final class c {
    public static /* synthetic */ boolean b(c cVar, Context context, File file, String str, boolean z4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z4 = false;
        }
        return cVar.a(context, file, str, z4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00eb, code lost:
        r6 = r16;
        r11 = r19;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f1, code lost:
        r12 = r28;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0156, code lost:
        r0 = e;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0157, code lost:
        r6 = r16;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x015a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x015b, code lost:
        r11 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01db, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01de, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01df, code lost:
        r6 = r16;
        r11 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ee, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ef, code lost:
        r12 = r6;
        r6 = r16;
        r11 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f5, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00e7 A[Catch:{ Exception -> 0x00ea, all -> 0x00e7 }, ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ Exception -> 0x00ea, all -> 0x00e7 }]), Splitter:B:1:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0180 A[Catch:{ Exception -> 0x01b3, all -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b5 A[Catch:{ Exception -> 0x01b3, all -> 0x00e7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r30, java.io.File r31, java.lang.String r32, boolean r33) {
        /*
            r29 = this;
            r0 = r30
            r1 = r32
            java.lang.String r2 = "exception"
            java.lang.String r3 = "apk_file"
            java.lang.String r4 = "getAbsolutePath(...)"
            java.lang.String r5 = "fail"
            java.lang.String r6 = "duration"
            java.lang.String r7 = "upload"
            java.lang.String r8 = "filehash"
            java.lang.String r9 = "type"
            java.lang.String r10 = "size"
            java.lang.String r11 = "context"
            kotlin.jvm.internal.t.e(r0, r11)
            java.lang.String r11 = "file"
            r12 = r31
            kotlin.jvm.internal.t.e(r12, r11)
            java.lang.String r11 = "sha256"
            kotlin.jvm.internal.t.e(r1, r11)
            m2.d$a r13 = m2.C2684d.f25289a
            r13.a()
            long r13 = java.lang.System.currentTimeMillis()
            r15 = r13
            long r12 = r31.length()
            z2.G r14 = z2.G.f26487a
            r17 = r15
            java.lang.String r15 = r14.e(r12)
            r16 = r6
            z2.F r6 = new z2.F
            r6.<init>(r0)
            r19 = r2
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x01ee, all -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x01ee, all -> 0x00e7 }
            r21 = r5
            java.lang.String r5 = "start"
            r2.putString(r9, r5)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            android.os.Bundle r2 = r14.a(r2)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            r2.putString(r10, r15)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            r2.putString(r8, r1)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            r6.d(r7, r2)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            z2.w r5 = z2.C2963w.f26560a     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            r2.append(r5)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            java.lang.String r5 = "/eapi/v2/tracker/upload-file"
            r2.append(r5)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            java.lang.String r5 = r31.getAbsolutePath()     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            kotlin.jvm.internal.t.d(r5, r4)     // Catch:{ Exception -> 0x01e5, all -> 0x00e7 }
            r28 = r6
            java.lang.String r6 = r31.getAbsolutePath()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            kotlin.jvm.internal.t.d(r6, r4)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r23 = "/"
            r26 = 6
            r27 = 0
            r24 = 0
            r25 = 0
            r22 = r6
            int r4 = t3.s.l0(r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r6 = 1
            int r4 = r4 + r6
            java.lang.String r4 = r5.substring(r4)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r5 = "substring(...)"
            kotlin.jvm.internal.t.d(r4, r5)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            A2.a r5 = new A2.a     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r22 = r6
            r6 = 0
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.k(r11, r1)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r6 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.k(r10, r6)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.i(r3, r4, r12)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.j()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.d(r6, r4)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.c(r11, r1)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r2 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5.c(r10, r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r2 = r31.getAbsolutePath()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            long r2 = r5.b(r3, r4, r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            if (r33 == 0) goto L_0x00f5
            l2.U$a r4 = l2.U.f24867c     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            l2.U r4 = r4.a(r0)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            long r11 = r4.b()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            long r11 = r11 + r2
            r4.e(r11)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r4.d(r0)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            goto L_0x00f5
        L_0x00e7:
            r0 = move-exception
            goto L_0x01f5
        L_0x00ea:
            r0 = move-exception
            r6 = r16
            r11 = r19
            r5 = r21
        L_0x00f1:
            r12 = r28
            goto L_0x01f6
        L_0x00f5:
            r5.e()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r2 = 0
            l2.M r0 = r5.f(r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            boolean r2 = r0.b()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r3 = "responseCode"
            java.lang.String r4 = "success"
            if (r2 != 0) goto L_0x012d
            java.lang.String r2 = r0.d()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            if (r2 == 0) goto L_0x012d
            int r2 = r2.length()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            if (r2 != 0) goto L_0x0114
            goto L_0x012d
        L_0x0114:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            java.lang.String r5 = r0.d()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            kotlin.jvm.internal.t.b(r5)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            int r2 = r2.optInt(r4)     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r6 = r16
            r11 = r19
            r5 = r21
            r12 = r28
            goto L_0x017e
        L_0x012d:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x00ea, all -> 0x00e7 }
            r5 = r21
            r2.putString(r9, r5)     // Catch:{ Exception -> 0x01de, all -> 0x00e7 }
            android.os.Bundle r2 = r14.a(r2)     // Catch:{ Exception -> 0x01de, all -> 0x00e7 }
            int r6 = r0.f()     // Catch:{ Exception -> 0x01de, all -> 0x00e7 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x01de, all -> 0x00e7 }
            r2.putString(r3, r6)     // Catch:{ Exception -> 0x01de, all -> 0x00e7 }
            java.lang.String r6 = r0.c()     // Catch:{ Exception -> 0x01de, all -> 0x00e7 }
            if (r6 == 0) goto L_0x015e
            java.lang.String r6 = r0.c()     // Catch:{ Exception -> 0x015a, all -> 0x00e7 }
            r11 = r19
            r2.putString(r11, r6)     // Catch:{ Exception -> 0x0156, all -> 0x00e7 }
            goto L_0x0160
        L_0x0156:
            r0 = move-exception
        L_0x0157:
            r6 = r16
            goto L_0x00f1
        L_0x015a:
            r0 = move-exception
            r11 = r19
            goto L_0x0157
        L_0x015e:
            r11 = r19
        L_0x0160:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0156, all -> 0x00e7 }
            long r12 = r12 - r17
            r30 = r12
            r6 = 1000(0x3e8, float:1.401E-42)
            long r12 = (long) r6     // Catch:{ Exception -> 0x0156, all -> 0x00e7 }
            long r12 = r30 / r12
            r6 = r16
            r2.putLong(r6, r12)     // Catch:{ Exception -> 0x01db, all -> 0x00e7 }
            r2.putString(r8, r1)     // Catch:{ Exception -> 0x01db, all -> 0x00e7 }
            r2.putString(r10, r15)     // Catch:{ Exception -> 0x01db, all -> 0x00e7 }
            r12 = r28
            r12.d(r7, r2)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r2 = 0
        L_0x017e:
            if (r2 != 0) goto L_0x01b5
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r2.<init>()     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r2.putString(r9, r5)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            android.os.Bundle r2 = r14.a(r2)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r2.putString(r8, r1)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r2.putString(r10, r15)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            int r0 = r0.f()     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r2.putString(r3, r0)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            long r3 = r3 - r17
            r30 = r3
            r13 = 1000(0x3e8, float:1.401E-42)
            long r3 = (long) r13     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            long r3 = r30 / r3
            r2.putLong(r6, r3)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r12.d(r7, r2)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r20 = 0
            return r20
        L_0x01b3:
            r0 = move-exception
            goto L_0x01f6
        L_0x01b5:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r0.<init>()     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r0.putString(r9, r4)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            android.os.Bundle r0 = r14.a(r0)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r0.putString(r8, r1)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r0.putString(r10, r15)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            long r2 = r2 - r17
            r30 = r2
            r13 = 1000(0x3e8, float:1.401E-42)
            long r2 = (long) r13     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            long r2 = r30 / r2
            r0.putLong(r6, r2)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            r12.d(r7, r0)     // Catch:{ Exception -> 0x01b3, all -> 0x00e7 }
            return r22
        L_0x01db:
            r0 = move-exception
            goto L_0x00f1
        L_0x01de:
            r0 = move-exception
            r6 = r16
            r11 = r19
            goto L_0x00f1
        L_0x01e5:
            r0 = move-exception
            r12 = r6
            r6 = r16
            r11 = r19
            r5 = r21
            goto L_0x01f6
        L_0x01ee:
            r0 = move-exception
            r12 = r6
            r6 = r16
            r11 = r19
            goto L_0x01f6
        L_0x01f5:
            throw r0
        L_0x01f6:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r2.putString(r9, r5)
            java.lang.Class r0 = r0.getClass()
            r3.c r0 = kotlin.jvm.internal.M.b(r0)
            java.lang.String r0 = r0.c()
            r2.putString(r11, r0)
            z2.G r0 = z2.G.f26487a
            android.os.Bundle r0 = r0.a(r2)
            r0.putString(r8, r1)
            r0.putString(r10, r15)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r17
            r13 = 1000(0x3e8, float:1.401E-42)
            long r3 = (long) r13
            long r1 = r1 / r3
            r0.putLong(r6, r1)
            r12.d(r7, r0)
            r20 = 0
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.c.a(android.content.Context, java.io.File, java.lang.String, boolean):boolean");
    }
}
