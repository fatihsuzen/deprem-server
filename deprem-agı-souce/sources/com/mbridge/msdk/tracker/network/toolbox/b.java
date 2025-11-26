package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.tracker.network.n;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.u;

public final class b implements n {

    /* renamed from: a  reason: collision with root package name */
    protected final c f11661a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11662b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private static q b(u<?> uVar) {
        String str;
        if (uVar == null) {
            return null;
        }
        try {
            if (!uVar.d() || TextUtils.isEmpty(uVar.k())) {
                return null;
            }
            if (uVar.i() == 0) {
                str = ShareTarget.METHOD_GET;
            } else {
                str = ShareTarget.METHOD_POST;
            }
            q qVar = new q(uVar.f(), str);
            qVar.d("queue");
            qVar.c(uVar.d("local_id"));
            qVar.b(uVar.d("ad_type"));
            qVar.a(uVar.v());
            uVar.a(qVar);
            return qVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:1|2|3|(2:5|6)(8:10|11|(3:13|14|15)|16|17|18|(3:20|21|22)|23)|24|25|26|27|(2:29|30)|31|32|33|(3:35|36|(2:38|141)(3:41|42|140))(10:43|44|45|(2:47|48)(2:50|51)|49|52|53|(7:55|56|(2:58|59)(1:62)|63|64|65|66)(2:135|71)|72|(2:78|79)(2:76|77))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0059 A[SYNTHETIC, Splitter:B:35:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.tracker.network.r a(com.mbridge.msdk.tracker.network.u<?> r27) throws com.mbridge.msdk.tracker.network.ad {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            long r3 = android.os.SystemClock.elapsedRealtime()
            com.mbridge.msdk.tracker.network.q r5 = b(r2)
        L_0x000c:
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            com.mbridge.msdk.tracker.network.b$a r0 = r2.m()     // Catch:{ IOException -> 0x0121 }
            if (r0 != 0) goto L_0x0022
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ IOException -> 0x0019 }
            goto L_0x0042
        L_0x0019:
            r0 = move-exception
            r20 = r9
            r11 = r10
            r14 = r11
        L_0x001e:
            r19 = 3
            goto L_0x0128
        L_0x0022:
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ IOException -> 0x0121 }
            r11.<init>()     // Catch:{ IOException -> 0x0121 }
            java.lang.String r12 = r0.f11574b     // Catch:{ IOException -> 0x0121 }
            if (r12 == 0) goto L_0x0030
            java.lang.String r13 = "If-None-Match"
            r11.put(r13, r12)     // Catch:{ IOException -> 0x0019 }
        L_0x0030:
            long r12 = r0.f11576d     // Catch:{ IOException -> 0x0121 }
            r14 = 0
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x0041
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r12 = com.mbridge.msdk.tracker.network.toolbox.f.a((long) r12)     // Catch:{ IOException -> 0x0019 }
            r11.put(r0, r12)     // Catch:{ IOException -> 0x0019 }
        L_0x0041:
            r0 = r11
        L_0x0042:
            com.mbridge.msdk.tracker.network.toolbox.a r11 = r1.f11662b     // Catch:{ IOException -> 0x0121 }
            com.mbridge.msdk.tracker.network.toolbox.g r11 = r11.a(r2, r0)     // Catch:{ IOException -> 0x0121 }
            int r13 = r11.a()     // Catch:{ IOException -> 0x011a }
            if (r5 == 0) goto L_0x0051
            r5.a((int) r13)     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            java.util.List r18 = r11.b()     // Catch:{ IOException -> 0x011a }
            r0 = 304(0x130, float:4.26E-43)
            if (r13 != r0) goto L_0x0092
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0075 }
            long r23 = r12 - r3
            com.mbridge.msdk.tracker.network.b$a r0 = r2.m()     // Catch:{ IOException -> 0x0075 }
            if (r0 != 0) goto L_0x007a
            com.mbridge.msdk.tracker.network.r r14 = new com.mbridge.msdk.tracker.network.r     // Catch:{ IOException -> 0x0075 }
            r16 = 0
            r17 = 1
            r15 = 304(0x130, float:4.26E-43)
            r20 = r18
            r18 = r23
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ IOException -> 0x0075 }
            goto L_0x0091
        L_0x0075:
            r0 = move-exception
            r20 = r9
            r14 = r10
            goto L_0x001e
        L_0x007a:
            r12 = r18
            r18 = r23
            java.util.List r25 = com.mbridge.msdk.tracker.network.toolbox.f.a(r12, r0)     // Catch:{ IOException -> 0x0075 }
            com.mbridge.msdk.tracker.network.r r19 = new com.mbridge.msdk.tracker.network.r     // Catch:{ IOException -> 0x0075 }
            byte[] r0 = r0.f11573a     // Catch:{ IOException -> 0x0075 }
            r22 = 1
            r20 = 304(0x130, float:4.26E-43)
            r21 = r0
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ IOException -> 0x0075 }
            r14 = r19
        L_0x0091:
            return r14
        L_0x0092:
            r12 = r18
            java.io.InputStream r0 = r11.d()     // Catch:{ IOException -> 0x011a }
            if (r0 == 0) goto L_0x00a6
            int r14 = r11.c()     // Catch:{ IOException -> 0x0075 }
            com.mbridge.msdk.tracker.network.toolbox.c r15 = r1.f11661a     // Catch:{ IOException -> 0x0075 }
            byte[] r0 = com.mbridge.msdk.tracker.network.toolbox.i.a(r0, r14, r15, r5)     // Catch:{ IOException -> 0x0075 }
        L_0x00a4:
            r14 = r0
            goto L_0x00a9
        L_0x00a6:
            byte[] r0 = new byte[r9]     // Catch:{ IOException -> 0x011a }
            goto L_0x00a4
        L_0x00a9:
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00f0 }
            long r15 = r15 - r3
            r17 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f5
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ IOException -> 0x00f0 }
            r19 = 3
            if (r14 == 0) goto L_0x00c8
            int r6 = r14.length     // Catch:{ IOException -> 0x00c4 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00ca
        L_0x00c4:
            r0 = move-exception
            r20 = r9
            goto L_0x0128
        L_0x00c8:
            java.lang.String r6 = "null"
        L_0x00ca:
            java.lang.Integer r16 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x00c4 }
            com.mbridge.msdk.tracker.network.z r17 = r2.b()     // Catch:{ IOException -> 0x00c4 }
            int r17 = r17.c()     // Catch:{ IOException -> 0x00c4 }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ IOException -> 0x00c4 }
            r20 = r9
            r9 = 5
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x00ee }
            r9[r20] = r2     // Catch:{ IOException -> 0x00ee }
            r9[r8] = r15     // Catch:{ IOException -> 0x00ee }
            r9[r7] = r6     // Catch:{ IOException -> 0x00ee }
            r9[r19] = r16     // Catch:{ IOException -> 0x00ee }
            r6 = 4
            r9[r6] = r17     // Catch:{ IOException -> 0x00ee }
            com.mbridge.msdk.tracker.network.ae.b(r0, r9)     // Catch:{ IOException -> 0x00ee }
            goto L_0x00f9
        L_0x00ee:
            r0 = move-exception
            goto L_0x0128
        L_0x00f0:
            r0 = move-exception
            r20 = r9
            goto L_0x001e
        L_0x00f5:
            r20 = r9
            r19 = 3
        L_0x00f9:
            r0 = 200(0xc8, float:2.8E-43)
            if (r13 < r0) goto L_0x0114
            r0 = 299(0x12b, float:4.19E-43)
            if (r13 > r0) goto L_0x0114
            a(r5, r8, r10)     // Catch:{ IOException -> 0x00ee }
            r18 = r12
            com.mbridge.msdk.tracker.network.r r12 = new com.mbridge.msdk.tracker.network.r     // Catch:{ IOException -> 0x00ee }
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00ee }
            long r15 = r15 - r3
            r16 = r15
            r15 = 0
            r12.<init>(r13, r14, r15, r16, r18)     // Catch:{ IOException -> 0x00ee }
            return r12
        L_0x0114:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00ee }
            r0.<init>()     // Catch:{ IOException -> 0x00ee }
            throw r0     // Catch:{ IOException -> 0x00ee }
        L_0x011a:
            r0 = move-exception
            r20 = r9
            r19 = 3
            r14 = r10
            goto L_0x0128
        L_0x0121:
            r0 = move-exception
            r20 = r9
            r19 = 3
            r11 = r10
            r14 = r11
        L_0x0128:
            java.lang.String r6 = r0.getMessage()
            java.lang.String r9 = "timeout"
            boolean r6 = android.text.TextUtils.equals(r6, r9)
            if (r6 == 0) goto L_0x0137
            r6 = r19
            goto L_0x0138
        L_0x0137:
            r6 = r7
        L_0x0138:
            a(r5, r6, r0)
            boolean r6 = r0 instanceof java.net.SocketTimeoutException
            if (r6 == 0) goto L_0x014d
            com.mbridge.msdk.tracker.network.toolbox.i$a r0 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            com.mbridge.msdk.tracker.network.ab r6 = new com.mbridge.msdk.tracker.network.ab
            r6.<init>()
            java.lang.String r7 = "socket"
            r0.<init>(r7, r6)
            goto L_0x01d0
        L_0x014d:
            boolean r6 = r0 instanceof java.net.MalformedURLException
            if (r6 != 0) goto L_0x01f6
            if (r11 == 0) goto L_0x01be
            int r13 = r11.a()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.lang.String r6 = r2.k()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r20] = r0
            r7[r8] = r6
            java.lang.String r0 = "Unexpected response code %d for %s"
            com.mbridge.msdk.tracker.network.ae.c(r0, r7)
            if (r14 == 0) goto L_0x01ae
            java.util.List r18 = r11.b()
            com.mbridge.msdk.tracker.network.r r12 = new com.mbridge.msdk.tracker.network.r
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r16 = r6 - r3
            r15 = 0
            r12.<init>(r13, r14, r15, r16, r18)
            r0 = 400(0x190, float:5.6E-43)
            if (r13 < r0) goto L_0x018e
            r0 = 499(0x1f3, float:6.99E-43)
            if (r13 <= r0) goto L_0x0185
            goto L_0x018e
        L_0x0185:
            com.mbridge.msdk.tracker.network.d r0 = new com.mbridge.msdk.tracker.network.d
            r0.<init>(r12)
            r0.a((int) r13)
            throw r0
        L_0x018e:
            com.mbridge.msdk.tracker.network.aa r0 = new com.mbridge.msdk.tracker.network.aa
            r0.<init>(r12)
            r0.a((int) r13)
            r6 = 500(0x1f4, float:7.0E-43)
            if (r13 < r6) goto L_0x01ad
            r6 = 599(0x257, float:8.4E-43)
            if (r13 > r6) goto L_0x01ad
            boolean r6 = r2.s()
            if (r6 == 0) goto L_0x01ad
            com.mbridge.msdk.tracker.network.toolbox.i$a r6 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            java.lang.String r7 = "server"
            r6.<init>(r7, r0)
        L_0x01ab:
            r0 = r6
            goto L_0x01d0
        L_0x01ad:
            throw r0
        L_0x01ae:
            com.mbridge.msdk.tracker.network.p r0 = new com.mbridge.msdk.tracker.network.p
            r0.<init>()
            r0.a((int) r13)
            com.mbridge.msdk.tracker.network.toolbox.i$a r6 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            java.lang.String r7 = "network"
            r6.<init>(r7, r0)
            goto L_0x01ab
        L_0x01be:
            boolean r6 = r2.t()
            if (r6 == 0) goto L_0x01f0
            com.mbridge.msdk.tracker.network.toolbox.i$a r0 = new com.mbridge.msdk.tracker.network.toolbox.i$a
            com.mbridge.msdk.tracker.network.s r6 = new com.mbridge.msdk.tracker.network.s
            r6.<init>()
            java.lang.String r7 = "connection"
            r0.<init>(r7, r6)
        L_0x01d0:
            if (r2 == 0) goto L_0x01e8
            com.mbridge.msdk.tracker.network.z r6 = r2.b()
            if (r6 == 0) goto L_0x01e5
            com.mbridge.msdk.tracker.network.ad r7 = r0.f11677b
            boolean r6 = r6.a(r7)
            if (r6 == 0) goto L_0x01e2
            goto L_0x000c
        L_0x01e2:
            com.mbridge.msdk.tracker.network.ad r0 = r0.f11677b
            throw r0
        L_0x01e5:
            com.mbridge.msdk.tracker.network.ad r0 = r0.f11677b
            throw r0
        L_0x01e8:
            com.mbridge.msdk.tracker.network.ac r0 = new com.mbridge.msdk.tracker.network.ac
            java.lang.String r2 = "request is null when retrying"
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x01f0:
            com.mbridge.msdk.tracker.network.s r2 = new com.mbridge.msdk.tracker.network.s
            r2.<init>(r0)
            throw r2
        L_0x01f6:
            com.mbridge.msdk.tracker.network.a r0 = new com.mbridge.msdk.tracker.network.a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Bad URL "
            r3.append(r4)
            java.lang.String r2 = r2.k()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.toolbox.b.a(com.mbridge.msdk.tracker.network.u):com.mbridge.msdk.tracker.network.r");
    }

    private b(a aVar, c cVar) {
        this.f11662b = aVar;
        this.f11661a = cVar;
    }

    private static void a(q qVar, int i5, Exception exc) {
        if (qVar != null) {
            try {
                qVar.a(exc);
                qVar.b(i5);
            } catch (Exception unused) {
            }
        }
    }
}
