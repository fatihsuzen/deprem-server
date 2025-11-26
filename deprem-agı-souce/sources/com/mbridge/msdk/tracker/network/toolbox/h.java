package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.u;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private final b f11673a;

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f11674b;

    static class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final HttpURLConnection f11675a;

        a(HttpURLConnection httpURLConnection) {
            super(h.b(httpURLConnection));
            this.f11675a = httpURLConnection;
        }

        public final void close() throws IOException {
            super.close();
            this.f11675a.disconnect();
        }
    }

    public interface b extends m {
    }

    public h() {
        this((b) null);
    }

    /* access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private h(b bVar) {
        this(bVar, (SSLSocketFactory) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.tracker.network.toolbox.g a(com.mbridge.msdk.tracker.network.u<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r7.i()
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = r7.k()
            java.lang.String r0 = com.mbridge.msdk.tracker.network.toolbox.d.a(r0, r7)
            goto L_0x0013
        L_0x000f:
            java.lang.String r0 = r7.k()
        L_0x0013:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.putAll(r8)
            java.util.Map r8 = r7.c()
            r1.putAll(r8)
            com.mbridge.msdk.tracker.network.toolbox.h$b r8 = r6.f11673a
            if (r8 == 0) goto L_0x0045
            java.lang.String r8 = r8.a(r0)
            if (r8 == 0) goto L_0x002e
            r0 = r8
            goto L_0x0045
        L_0x002e:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "URL blocked by rewriter: "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0045:
            java.net.URL r8 = new java.net.URL
            r8.<init>(r0)
            java.net.URLConnection r0 = r8.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            boolean r2 = java.net.HttpURLConnection.getFollowRedirects()
            r0.setInstanceFollowRedirects(r2)
            int r2 = r7.u()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r3 = 1
            r0.setDoInput(r3)
            java.lang.String r4 = "https"
            java.lang.String r8 = r8.getProtocol()
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto L_0x007f
            javax.net.ssl.SSLSocketFactory r8 = r6.f11674b
            if (r8 == 0) goto L_0x007f
            r4 = r0
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4
            r4.setSSLSocketFactory(r8)
        L_0x007f:
            java.util.Set r8 = r1.keySet()     // Catch:{ all -> 0x009d }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x009d }
        L_0x0087:
            boolean r4 = r8.hasNext()     // Catch:{ all -> 0x009d }
            if (r4 == 0) goto L_0x00a0
            java.lang.Object r4 = r8.next()     // Catch:{ all -> 0x009d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x009d }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x009d }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x009d }
            r0.setRequestProperty(r4, r5)     // Catch:{ all -> 0x009d }
            goto L_0x0087
        L_0x009d:
            r7 = move-exception
            goto L_0x0138
        L_0x00a0:
            int r8 = r7.i()     // Catch:{ all -> 0x009d }
            switch(r8) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00d9;
                case 2: goto L_0x00d0;
                case 3: goto L_0x00ca;
                case 4: goto L_0x00c4;
                case 5: goto L_0x00be;
                case 6: goto L_0x00b8;
                case 7: goto L_0x00af;
                default: goto L_0x00a7;
            }     // Catch:{ all -> 0x009d }
        L_0x00a7:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x009d }
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)     // Catch:{ all -> 0x009d }
            throw r7     // Catch:{ all -> 0x009d }
        L_0x00af:
            java.lang.String r8 = "PATCH"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            r6.a((java.net.HttpURLConnection) r0, (com.mbridge.msdk.tracker.network.u<?>) r7)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00b8:
            java.lang.String r8 = "TRACE"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00be:
            java.lang.String r8 = "OPTIONS"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00c4:
            java.lang.String r8 = "HEAD"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00ca:
            java.lang.String r8 = "DELETE"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00d0:
            java.lang.String r8 = "PUT"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            r6.a((java.net.HttpURLConnection) r0, (com.mbridge.msdk.tracker.network.u<?>) r7)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00d9:
            java.lang.String r8 = "POST"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
            r6.a((java.net.HttpURLConnection) r0, (com.mbridge.msdk.tracker.network.u<?>) r7)     // Catch:{ all -> 0x009d }
            goto L_0x00e7
        L_0x00e2:
            java.lang.String r8 = "GET"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x009d }
        L_0x00e7:
            int r8 = r0.getResponseCode()     // Catch:{ all -> 0x009d }
            r1 = -1
            if (r8 == r1) goto L_0x0130
            int r7 = r7.i()     // Catch:{ all -> 0x009d }
            r1 = 4
            if (r7 == r1) goto L_0x011f
            r7 = 100
            if (r7 > r8) goto L_0x00fd
            r7 = 200(0xc8, float:2.8E-43)
            if (r8 < r7) goto L_0x011f
        L_0x00fd:
            r7 = 204(0xcc, float:2.86E-43)
            if (r8 == r7) goto L_0x011f
            r7 = 304(0x130, float:4.26E-43)
            if (r8 == r7) goto L_0x011f
            com.mbridge.msdk.tracker.network.toolbox.g r7 = new com.mbridge.msdk.tracker.network.toolbox.g     // Catch:{ all -> 0x011c }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x011c }
            java.util.List r1 = a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x011c }
            int r2 = r0.getContentLength()     // Catch:{ all -> 0x011c }
            com.mbridge.msdk.tracker.network.toolbox.h$a r4 = new com.mbridge.msdk.tracker.network.toolbox.h$a     // Catch:{ all -> 0x011c }
            r4.<init>(r0)     // Catch:{ all -> 0x011c }
            r7.<init>(r8, r1, r2, r4)     // Catch:{ all -> 0x011c }
            return r7
        L_0x011c:
            r7 = move-exception
            r2 = r3
            goto L_0x0138
        L_0x011f:
            com.mbridge.msdk.tracker.network.toolbox.g r7 = new com.mbridge.msdk.tracker.network.toolbox.g     // Catch:{ all -> 0x009d }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x009d }
            java.util.List r1 = a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x009d }
            r7.<init>(r8, r1)     // Catch:{ all -> 0x009d }
            r0.disconnect()
            return r7
        L_0x0130:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x009d }
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)     // Catch:{ all -> 0x009d }
            throw r7     // Catch:{ all -> 0x009d }
        L_0x0138:
            if (r2 != 0) goto L_0x013d
            r0.disconnect()
        L_0x013d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.toolbox.h.a(com.mbridge.msdk.tracker.network.u, java.util.Map):com.mbridge.msdk.tracker.network.toolbox.g");
    }

    private h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f11673a = bVar;
        this.f11674b = sSLSocketFactory;
    }

    private static List<com.mbridge.msdk.tracker.network.h> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String hVar : (List) next.getValue()) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.h((String) next.getKey(), hVar));
                }
            }
        }
        return arrayList;
    }

    private void a(HttpURLConnection httpURLConnection, u<?> uVar) throws IOException {
        byte[] p5 = uVar.p();
        if (p5 != null) {
            a(httpURLConnection, uVar, p5);
        }
    }

    private void a(HttpURLConnection httpURLConnection, u<?> uVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", uVar.o());
        }
        int length = bArr.length;
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
