package com.google.android.gms.measurement.internal;

import N.C0722p;
import j$.util.Objects;
import java.net.URL;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.u2  reason: case insensitive filesystem */
final class C1429u2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f6764a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6765b;

    /* renamed from: c  reason: collision with root package name */
    private final C1415s2 f6766c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6767d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f6768e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1436v2 f6769f;

    public C1429u2(C1436v2 v2Var, String str, URL url, byte[] bArr, Map map, C1415s2 s2Var) {
        Objects.requireNonNull(v2Var);
        this.f6769f = v2Var;
        C0722p.e(str);
        C0722p.k(url);
        C0722p.k(s2Var);
        this.f6764a = url;
        this.f6765b = bArr;
        this.f6766c = s2Var;
        this.f6767d = str;
        this.f6768e = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f8 A[SYNTHETIC, Splitter:B:50:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0127 A[SYNTHETIC, Splitter:B:69:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0164 A[SYNTHETIC, Splitter:B:79:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0180  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r1 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.v2 r0 = r13.f6769f
            r0.g()
            r2 = 0
            r3 = 0
            java.net.URL r4 = r13.f6764a     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            int r5 = com.google.android.gms.internal.measurement.C1174o0.f5498a     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            if (r5 == 0) goto L_0x0119
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r4.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.X2 r5 = r0.f5730a     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r5.w()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r6 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r5.w()     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r6 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r6)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r4.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            r6 = 1
            r4.setDoInput(r6)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            java.util.Map r7 = r13.f6768e     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            if (r7 == 0) goto L_0x0063
            java.util.Set r7 = r7.entrySet()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
        L_0x0041:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            if (r8 == 0) goto L_0x0063
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.Object r9 = r8.getKey()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.addRequestProperty(r9, r8)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            goto L_0x0041
        L_0x005d:
            r0 = move-exception
            goto L_0x010e
        L_0x0060:
            r0 = move-exception
            goto L_0x0111
        L_0x0063:
            byte[] r7 = r13.f6765b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            if (r7 == 0) goto L_0x00ae
            com.google.android.gms.measurement.internal.q6 r0 = r0.f6129b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.u6 r0 = r0.K0()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            byte[] r0 = r0.V(r7)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.o2 r5 = r5.w()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r0.length     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r5.b(r7, r9)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.setDoOutput(r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.setFixedLengthStreamingMode(r8)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.connect()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r5.write(r0)     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
            r5.close()     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
            goto L_0x00ae
        L_0x009e:
            r0 = move-exception
            goto L_0x00a2
        L_0x00a0:
            r0 = move-exception
            goto L_0x00a8
        L_0x00a2:
            r6 = r2
            r9 = r3
            r3 = r5
        L_0x00a5:
            r2 = r0
            goto L_0x0125
        L_0x00a8:
            r8 = r0
            r7 = r2
            r10 = r3
            r3 = r5
            goto L_0x0162
        L_0x00ae:
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.Map r11 = r4.getHeaderFields()     // Catch:{ IOException -> 0x010a, all -> 0x0105 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x00f4 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00cd }
        L_0x00c3:
            int r7 = r5.read(r6)     // Catch:{ all -> 0x00cd }
            if (r7 <= 0) goto L_0x00cf
            r0.write(r6, r2, r7)     // Catch:{ all -> 0x00cd }
            goto L_0x00c3
        L_0x00cd:
            r0 = move-exception
            goto L_0x00f6
        L_0x00cf:
            byte[] r10 = r0.toByteArray()     // Catch:{ all -> 0x00cd }
            r5.close()     // Catch:{ IOException -> 0x00f2, all -> 0x00f0 }
            r4.disconnect()
            com.google.android.gms.measurement.internal.v2 r0 = r13.f6769f
            java.lang.String r6 = r13.f6767d
            com.google.android.gms.measurement.internal.s2 r7 = r13.f6766c
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.T2 r0 = r0.b()
            com.google.android.gms.measurement.internal.t2 r5 = new com.google.android.gms.measurement.internal.t2
            r9 = 0
            r12 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r0.t(r5)
            return
        L_0x00f0:
            r0 = move-exception
            goto L_0x00fc
        L_0x00f2:
            r0 = move-exception
            goto L_0x0100
        L_0x00f4:
            r0 = move-exception
            r5 = r3
        L_0x00f6:
            if (r5 == 0) goto L_0x00fb
            r5.close()     // Catch:{ IOException -> 0x00f2, all -> 0x00f0 }
        L_0x00fb:
            throw r0     // Catch:{ IOException -> 0x00f2, all -> 0x00f0 }
        L_0x00fc:
            r2 = r0
            r6 = r8
            r9 = r11
            goto L_0x0125
        L_0x0100:
            r7 = r8
            r10 = r11
        L_0x0102:
            r8 = r0
            goto L_0x0162
        L_0x0105:
            r0 = move-exception
            r2 = r0
            r9 = r3
            r6 = r8
            goto L_0x0125
        L_0x010a:
            r0 = move-exception
            r10 = r3
            r7 = r8
            goto L_0x0102
        L_0x010e:
            r6 = r2
            r9 = r3
            goto L_0x00a5
        L_0x0111:
            r8 = r0
            r7 = r2
            r10 = r3
            goto L_0x0162
        L_0x0115:
            r0 = move-exception
            goto L_0x0121
        L_0x0117:
            r0 = move-exception
            goto L_0x015e
        L_0x0119:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r0.<init>(r4)     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
            throw r0     // Catch:{ IOException -> 0x0117, all -> 0x0115 }
        L_0x0121:
            r6 = r2
            r4 = r3
            r9 = r4
            goto L_0x00a5
        L_0x0125:
            if (r3 == 0) goto L_0x0141
            r3.close()     // Catch:{ IOException -> 0x012b }
            goto L_0x0141
        L_0x012b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.v2 r3 = r13.f6769f
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()
            java.lang.String r5 = r13.f6767d
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r5)
            r3.c(r1, r5, r0)
        L_0x0141:
            if (r4 == 0) goto L_0x0146
            r4.disconnect()
        L_0x0146:
            com.google.android.gms.measurement.internal.v2 r0 = r13.f6769f
            java.lang.String r4 = r13.f6767d
            com.google.android.gms.measurement.internal.s2 r5 = r13.f6766c
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.T2 r0 = r0.b()
            com.google.android.gms.measurement.internal.t2 r3 = new com.google.android.gms.measurement.internal.t2
            r8 = 0
            r10 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.t(r3)
            throw r2
        L_0x015e:
            r8 = r0
            r7 = r2
            r4 = r3
            r10 = r4
        L_0x0162:
            if (r3 == 0) goto L_0x017e
            r3.close()     // Catch:{ IOException -> 0x0168 }
            goto L_0x017e
        L_0x0168:
            r0 = move-exception
            com.google.android.gms.measurement.internal.v2 r2 = r13.f6769f
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()
            java.lang.String r3 = r13.f6767d
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r3)
            r2.c(r1, r3, r0)
        L_0x017e:
            if (r4 == 0) goto L_0x0183
            r4.disconnect()
        L_0x0183:
            com.google.android.gms.measurement.internal.v2 r0 = r13.f6769f
            java.lang.String r5 = r13.f6767d
            com.google.android.gms.measurement.internal.s2 r6 = r13.f6766c
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.T2 r0 = r0.b()
            com.google.android.gms.measurement.internal.t2 r4 = new com.google.android.gms.measurement.internal.t2
            r9 = 0
            r11 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.t(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1429u2.run():void");
    }
}
