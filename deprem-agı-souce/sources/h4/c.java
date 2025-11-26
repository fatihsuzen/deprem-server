package h4;

import g4.b;

public class c implements l {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23753c = b.i(c.class);

    /* renamed from: a  reason: collision with root package name */
    private long f23754a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23755b = false;

    private static boolean d(int i5) {
        if (i5 == 204 || i5 == 200) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.io.BufferedWriter} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1 A[SYNTHETIC, Splitter:B:30:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f6 A[SYNTHETIC, Splitter:B:56:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0191 A[SYNTHETIC, Splitter:B:93:0x0191] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(h4.j r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Failed to close output stream after writing POST data."
            java.lang.String r1 = "Failed to close output stream after writing gzipped POST data."
            r2 = 0
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r5 = r12.c()     // Catch:{ Exception -> 0x01a4 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x01a4 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ Exception -> 0x01a4 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r5 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r6 = p4.a.b(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r7 = "Connection is open to %s"
            java.net.URL r8 = r4.getURL()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r8 = r8.toExternalForm()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r10[r2] = r8     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6.g(r7, r10)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r5 = p4.a.b(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r6 = "Sending: %s"
            java.lang.Object[] r7 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r7[r2] = r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r5.g(r6, r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            long r5 = r11.f23754a     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            long r5 = r11.f23754a     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            org.json.JSONObject r5 = r12.b()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            if (r5 == 0) goto L_0x0107
            r4.setDoOutput(r9)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/json"
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r5 = "charset"
            java.lang.String r6 = "utf-8"
            r4.setRequestProperty(r5, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            org.json.JSONObject r12 = r12.b()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            boolean r5 = r11.f23755b     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            if (r5 == 0) goto L_0x00cc
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r5 = "gzip"
            r4.addRequestProperty(r0, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r0.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x00c2 }
            byte[] r12 = r12.getBytes(r6)     // Catch:{ all -> 0x00c2 }
            r5.write(r12)     // Catch:{ all -> 0x00c2 }
            r5.close()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.io.OutputStream r12 = r4.getOutputStream()     // Catch:{ all -> 0x00ae }
            byte[] r0 = r0.toByteArray()     // Catch:{ all -> 0x00ab }
            r12.write(r0)     // Catch:{ all -> 0x00ab }
            r12.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x010a
        L_0x0096:
            r12 = move-exception
            r3 = r4
            goto L_0x01b8
        L_0x009a:
            r12 = move-exception
            r3 = r4
            goto L_0x01a5
        L_0x009e:
            r12 = move-exception
            java.lang.String r0 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r0 = p4.a.b(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r0.b(r12, r1, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            goto L_0x010a
        L_0x00ab:
            r0 = move-exception
            r3 = r12
            goto L_0x00af
        L_0x00ae:
            r0 = move-exception
        L_0x00af:
            if (r3 == 0) goto L_0x00c1
            r3.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00c1
        L_0x00b5:
            r12 = move-exception
            java.lang.String r3 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r3 = p4.a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.b(r12, r1, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00c1:
            throw r0     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00c2:
            r12 = move-exception
            r5.close()     // Catch:{ all -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r0 = move-exception
            r12.addSuppressed(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00cb:
            throw r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x00cc:
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x00f3 }
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00f3 }
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ all -> 0x00f3 }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x00f3 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00f3 }
            r1.<init>(r5)     // Catch:{ all -> 0x00f3 }
            r1.write(r12)     // Catch:{ all -> 0x00f0 }
            r1.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x010a
        L_0x00e3:
            r12 = move-exception
            java.lang.String r1 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r1 = p4.a.b(r1)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r1.b(r12, r0, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            goto L_0x010a
        L_0x00f0:
            r12 = move-exception
            r3 = r1
            goto L_0x00f4
        L_0x00f3:
            r12 = move-exception
        L_0x00f4:
            if (r3 == 0) goto L_0x0106
            r3.close()     // Catch:{ IOException -> 0x00fa }
            goto L_0x0106
        L_0x00fa:
            r1 = move-exception
            java.lang.String r3 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r3 = p4.a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.b(r1, r0, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x0106:
            throw r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x0107:
            r4.setDoOutput(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x010a:
            int r12 = r4.getResponseCode()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r0 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r0 = p4.a.b(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r1 = "Transmission finished (code=%d)."
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6[r2] = r5     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r0.g(r1, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            boolean r0 = d(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r1 = "Failed to close the error stream."
            if (r0 == 0) goto L_0x0140
            java.io.InputStream r12 = r4.getInputStream()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            if (r12 == 0) goto L_0x018a
            r12.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x018a
        L_0x0133:
            r12 = move-exception
            java.lang.String r3 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r3 = p4.a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.b(r12, r1, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            goto L_0x018a
        L_0x0140:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r5.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x018e }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x018e }
            java.io.InputStream r8 = r4.getErrorStream()     // Catch:{ all -> 0x018e }
            r7.<init>(r8)     // Catch:{ all -> 0x018e }
            r6.<init>(r7)     // Catch:{ all -> 0x018e }
        L_0x0153:
            java.lang.String r3 = r6.readLine()     // Catch:{ all -> 0x015d }
            if (r3 == 0) goto L_0x0160
            r5.append(r3)     // Catch:{ all -> 0x015d }
            goto L_0x0153
        L_0x015d:
            r12 = move-exception
            r3 = r6
            goto L_0x018f
        L_0x0160:
            r6.close()     // Catch:{ IOException -> 0x0164 }
            goto L_0x0170
        L_0x0164:
            r3 = move-exception
            java.lang.String r6 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r6 = p4.a.b(r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6.b(r3, r1, r7)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x0170:
            java.lang.String r1 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r1 = p4.a.b(r1)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r3 = "Transmission failed (code=%d, reason=%s)"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6[r2] = r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r6[r9] = r5     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r1.h(r3, r6)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x018a:
            r4.disconnect()
            return r0
        L_0x018e:
            r12 = move-exception
        L_0x018f:
            if (r3 == 0) goto L_0x01a1
            r3.close()     // Catch:{ IOException -> 0x0195 }
            goto L_0x01a1
        L_0x0195:
            r0 = move-exception
            java.lang.String r3 = f23753c     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            p4.a$b r3 = p4.a.b(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
            r3.b(r0, r1, r5)     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x01a1:
            throw r12     // Catch:{ Exception -> 0x009a, all -> 0x0096 }
        L_0x01a2:
            r12 = move-exception
            goto L_0x01b8
        L_0x01a4:
            r12 = move-exception
        L_0x01a5:
            java.lang.String r0 = f23753c     // Catch:{ all -> 0x01a2 }
            p4.a$b r0 = p4.a.b(r0)     // Catch:{ all -> 0x01a2 }
            java.lang.String r1 = "Transmission failed unexpectedly."
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x01a2 }
            r0.e(r12, r1, r4)     // Catch:{ all -> 0x01a2 }
            if (r3 == 0) goto L_0x01b7
            r3.disconnect()
        L_0x01b7:
            return r2
        L_0x01b8:
            if (r3 == 0) goto L_0x01bd
            r3.disconnect()
        L_0x01bd:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.c.a(h4.j):boolean");
    }

    public void b(long j5) {
        this.f23754a = j5;
    }

    public void c(boolean z4) {
        this.f23755b = z4;
    }
}
