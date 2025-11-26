package com.google.android.gms.measurement.internal;

import N.C0722p;
import j$.util.Objects;
import java.net.URL;
import java.util.Map;

final class A4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f5731a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f5732b;

    /* renamed from: c  reason: collision with root package name */
    private final C1459y4 f5733c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5734d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f5735e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ B4 f5736f;

    public A4(B4 b42, String str, URL url, byte[] bArr, Map map, C1459y4 y4Var) {
        Objects.requireNonNull(b42);
        this.f5736f = b42;
        C0722p.e(str);
        C0722p.k(url);
        C0722p.k(y4Var);
        this.f5731a = url;
        this.f5732b = bArr;
        this.f5733c = y4Var;
        this.f5734d = str;
        this.f5735e = map;
    }

    private final void b(int i5, Exception exc, byte[] bArr, Map map) {
        this.f5736f.f5730a.b().t(new C1466z4(this, i5, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i5, Exception exc, byte[] bArr, Map map) {
        this.f5733c.a(this.f5734d, i5, exc, bArr, map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0139, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013a, code lost:
        r10.f5736f.f5730a.a().o().c("Error closing HTTP compressed POST connection output stream. appId", com.google.android.gms.measurement.internal.C1402q2.x(r10.f5734d), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0151, code lost:
        r4.disconnect();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005d A[Catch:{ IOException -> 0x00bc, all -> 0x005d, IOException -> 0x0060, all -> 0x005d }, ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0106 A[SYNTHETIC, Splitter:B:55:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0135 A[SYNTHETIC, Splitter:B:75:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x015d A[SYNTHETIC, Splitter:B:85:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0179  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.B4 r1 = r10.f5736f
            r1.g()
            r2 = 0
            r3 = 0
            java.net.URL r4 = r10.f5731a     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            int r5 = com.google.android.gms.internal.measurement.C1174o0.f5498a     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            if (r5 == 0) goto L_0x0128
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r4.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r1.w()     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r5 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r1.w()     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r5 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r5)     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r4.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            r5 = 1
            r4.setDoInput(r5)     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            java.util.Map r6 = r10.f5735e     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            if (r6 == 0) goto L_0x0063
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
        L_0x0041:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            if (r7 == 0) goto L_0x0063
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.Object r8 = r7.getKey()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.addRequestProperty(r8, r7)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            goto L_0x0041
        L_0x005d:
            r1 = move-exception
            goto L_0x011a
        L_0x0060:
            r1 = move-exception
            goto L_0x0121
        L_0x0063:
            byte[] r6 = r10.f5732b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            if (r6 == 0) goto L_0x00cf
            r1.c()     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            r1.<init>()     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            java.util.zip.GZIPOutputStream r7 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            r7.<init>(r1)     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            r7.write(r6)     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            r7.close()     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            r1.close()     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            byte[] r1 = r1.toByteArray()     // Catch:{ IOException -> 0x00bc, all -> 0x005d }
            com.google.android.gms.measurement.internal.B4 r6 = r10.f5736f     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.X2 r6 = r6.f5730a     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.o2 r6 = r6.w()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r1.length     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r6.b(r7, r9)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.setDoOutput(r5)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.setFixedLengthStreamingMode(r8)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.connect()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r5.write(r1)     // Catch:{ IOException -> 0x00b4, all -> 0x00b2 }
            r5.close()     // Catch:{ IOException -> 0x00b4, all -> 0x00b2 }
            goto L_0x00cf
        L_0x00b2:
            r1 = move-exception
            goto L_0x00b6
        L_0x00b4:
            r1 = move-exception
            goto L_0x00b9
        L_0x00b6:
            r6 = r3
            goto L_0x0133
        L_0x00b9:
            r6 = r3
            goto L_0x015b
        L_0x00bc:
            r1 = move-exception
            com.google.android.gms.measurement.internal.B4 r5 = r10.f5736f     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.X2 r5 = r5.f5730a     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.lang.String r6 = "Failed to gzip post request content"
            r5.b(r6, r1)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            throw r1     // Catch:{ IOException -> 0x0060, all -> 0x005d }
        L_0x00cf:
            int r1 = r4.getResponseCode()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.Map r5 = r4.getHeaderFields()     // Catch:{ IOException -> 0x011d, all -> 0x0116 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0102 }
            r6.<init>()     // Catch:{ all -> 0x0102 }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ all -> 0x0102 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x00ee }
        L_0x00e4:
            int r9 = r7.read(r8)     // Catch:{ all -> 0x00ee }
            if (r9 <= 0) goto L_0x00f0
            r6.write(r8, r2, r9)     // Catch:{ all -> 0x00ee }
            goto L_0x00e4
        L_0x00ee:
            r2 = move-exception
            goto L_0x0104
        L_0x00f0:
            byte[] r2 = r6.toByteArray()     // Catch:{ all -> 0x00ee }
            r7.close()     // Catch:{ IOException -> 0x0100, all -> 0x00fe }
            r4.disconnect()
            r10.b(r1, r3, r2, r5)
            return
        L_0x00fe:
            r2 = move-exception
            goto L_0x010a
        L_0x0100:
            r2 = move-exception
            goto L_0x0110
        L_0x0102:
            r2 = move-exception
            r7 = r3
        L_0x0104:
            if (r7 == 0) goto L_0x0109
            r7.close()     // Catch:{ IOException -> 0x0100, all -> 0x00fe }
        L_0x0109:
            throw r2     // Catch:{ IOException -> 0x0100, all -> 0x00fe }
        L_0x010a:
            r6 = r2
            r2 = r1
            r1 = r6
            r6 = r5
            r5 = r3
            goto L_0x0133
        L_0x0110:
            r6 = r2
            r2 = r1
            r1 = r6
            r6 = r5
            r5 = r3
            goto L_0x015b
        L_0x0116:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x011a:
            r5 = r3
        L_0x011b:
            r6 = r5
            goto L_0x0133
        L_0x011d:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x0121:
            r5 = r3
        L_0x0122:
            r6 = r5
            goto L_0x015b
        L_0x0124:
            r1 = move-exception
            goto L_0x0130
        L_0x0126:
            r1 = move-exception
            goto L_0x0158
        L_0x0128:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r1.<init>(r4)     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
            throw r1     // Catch:{ IOException -> 0x0126, all -> 0x0124 }
        L_0x0130:
            r4 = r3
            r5 = r4
            goto L_0x011b
        L_0x0133:
            if (r5 == 0) goto L_0x014f
            r5.close()     // Catch:{ IOException -> 0x0139 }
            goto L_0x014f
        L_0x0139:
            r5 = move-exception
            com.google.android.gms.measurement.internal.B4 r7 = r10.f5736f
            com.google.android.gms.measurement.internal.X2 r7 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()
            java.lang.String r8 = r10.f5734d
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r8)
            r7.c(r0, r8, r5)
        L_0x014f:
            if (r4 == 0) goto L_0x0154
            r4.disconnect()
        L_0x0154:
            r10.b(r2, r3, r3, r6)
            throw r1
        L_0x0158:
            r4 = r3
            r5 = r4
            goto L_0x0122
        L_0x015b:
            if (r5 == 0) goto L_0x0177
            r5.close()     // Catch:{ IOException -> 0x0161 }
            goto L_0x0177
        L_0x0161:
            r5 = move-exception
            com.google.android.gms.measurement.internal.B4 r7 = r10.f5736f
            com.google.android.gms.measurement.internal.X2 r7 = r7.f5730a
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()
            java.lang.String r8 = r10.f5734d
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r8)
            r7.c(r0, r8, r5)
        L_0x0177:
            if (r4 == 0) goto L_0x017c
            r4.disconnect()
        L_0x017c:
            r10.b(r2, r1, r3, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.A4.run():void");
    }
}
