package com.mbridge.msdk.click;

import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.a;
import com.mbridge.msdk.foundation.controller.c;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8137a = "h";

    /* renamed from: b  reason: collision with root package name */
    private g f8138b;

    /* renamed from: c  reason: collision with root package name */
    private String f8139c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8140d = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f8141e = 3145728;

    /* renamed from: f  reason: collision with root package name */
    private a f8142f;

    public h() {
        g b5 = com.mbridge.msdk.c.h.a().b(c.m().k());
        this.f8138b = b5;
        if (b5 == null) {
            com.mbridge.msdk.c.h.a();
            this.f8138b = i.a();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.mbridge.msdk.click.entity.a] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0122 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.click.entity.a a(java.lang.String r5, boolean r6, boolean r7, com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            r4 = this;
            java.lang.String r0 = "gzip"
            boolean r1 = android.webkit.URLUtil.isNetworkUrl(r5)
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = " "
            java.lang.String r3 = "%20"
            java.lang.String r5 = r5.replace(r1, r3)
            com.mbridge.msdk.click.entity.a r1 = new com.mbridge.msdk.click.entity.a
            r1.<init>()
            r4.f8142f = r1
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x0115 }
            r1.<init>(r5)     // Catch:{ all -> 0x0115 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x0115 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x0115 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = "User-Agent"
            if (r6 != 0) goto L_0x002f
            if (r7 == 0) goto L_0x0031
        L_0x002f:
            if (r8 != 0) goto L_0x003d
        L_0x0031:
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.ab.g()     // Catch:{ all -> 0x0039 }
            r1.setRequestProperty(r2, r3)     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r5 = move-exception
            r2 = r1
            goto L_0x0116
        L_0x003d:
            r3 = 1
            if (r6 == 0) goto L_0x004f
            if (r8 == 0) goto L_0x004f
            int r6 = r8.getcUA()     // Catch:{ all -> 0x0039 }
            if (r6 != r3) goto L_0x004f
            java.lang.String r6 = com.mbridge.msdk.foundation.tools.ab.g()     // Catch:{ all -> 0x0039 }
            r1.setRequestProperty(r2, r6)     // Catch:{ all -> 0x0039 }
        L_0x004f:
            if (r7 == 0) goto L_0x0060
            if (r8 == 0) goto L_0x0060
            int r6 = r8.getImpUA()     // Catch:{ all -> 0x0039 }
            if (r6 != r3) goto L_0x0060
            java.lang.String r6 = com.mbridge.msdk.foundation.tools.ab.g()     // Catch:{ all -> 0x0039 }
            r1.setRequestProperty(r2, r6)     // Catch:{ all -> 0x0039 }
        L_0x0060:
            java.lang.String r6 = "Accept-Encoding"
            r1.setRequestProperty(r6, r0)     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.c.g r6 = r4.f8138b     // Catch:{ all -> 0x0039 }
            boolean r6 = r6.aJ()     // Catch:{ all -> 0x0039 }
            if (r6 == 0) goto L_0x007c
            java.lang.String r6 = r4.f8139c     // Catch:{ all -> 0x0039 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0039 }
            if (r6 != 0) goto L_0x007c
            java.lang.String r6 = "referer"
            java.lang.String r7 = r4.f8139c     // Catch:{ all -> 0x0039 }
            r1.setRequestProperty(r6, r7)     // Catch:{ all -> 0x0039 }
        L_0x007c:
            r6 = 60000(0xea60, float:8.4078E-41)
            r1.setConnectTimeout(r6)     // Catch:{ all -> 0x0039 }
            r1.setReadTimeout(r6)     // Catch:{ all -> 0x0039 }
            r6 = 0
            r1.setInstanceFollowRedirects(r6)     // Catch:{ all -> 0x0039 }
            r1.connect()     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = "Location"
            java.lang.String r7 = r1.getHeaderField(r7)     // Catch:{ all -> 0x0039 }
            r6.f8116a = r7     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = "Referer"
            java.lang.String r7 = r1.getHeaderField(r7)     // Catch:{ all -> 0x0039 }
            r6.f8119d = r7     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            int r7 = r1.getResponseCode()     // Catch:{ all -> 0x0039 }
            r6.f8121f = r7     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = r1.getContentType()     // Catch:{ all -> 0x0039 }
            r6.f8117b = r7     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            int r7 = r1.getContentLength()     // Catch:{ all -> 0x0039 }
            r6.f8120e = r7     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = r1.getContentEncoding()     // Catch:{ all -> 0x0039 }
            r6.f8118c = r7     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = r6.f8118c     // Catch:{ all -> 0x0039 }
            boolean r6 = r0.equalsIgnoreCase(r6)     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.click.entity.a r7 = r4.f8142f     // Catch:{ all -> 0x0039 }
            int r8 = r7.f8121f     // Catch:{ all -> 0x0039 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 != r0) goto L_0x010d
            boolean r8 = r4.f8140d     // Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x010d
            int r7 = r7.f8120e     // Catch:{ all -> 0x0039 }
            if (r7 <= 0) goto L_0x010d
            r8 = 3145728(0x300000, float:4.408104E-39)
            if (r7 >= r8) goto L_0x010d
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0039 }
            if (r7 != 0) goto L_0x010d
            java.io.InputStream r7 = r1.getInputStream()     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = r4.a(r7, r6)     // Catch:{ all -> 0x0103 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0103 }
            if (r7 != 0) goto L_0x010d
            byte[] r7 = r6.getBytes()     // Catch:{ all -> 0x0103 }
            int r0 = r7.length     // Catch:{ all -> 0x0103 }
            if (r0 <= 0) goto L_0x010d
            int r7 = r7.length     // Catch:{ all -> 0x0103 }
            if (r7 >= r8) goto L_0x010d
            com.mbridge.msdk.click.entity.a r7 = r4.f8142f     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0103 }
            r7.f8122g = r6     // Catch:{ all -> 0x0103 }
            goto L_0x010d
        L_0x0103:
            r6 = move-exception
            java.lang.String r7 = f8137a     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0039 }
            com.mbridge.msdk.foundation.tools.af.b(r7, r6)     // Catch:{ all -> 0x0039 }
        L_0x010d:
            r4.f8139c = r5     // Catch:{ all -> 0x0039 }
            r1.disconnect()
            com.mbridge.msdk.click.entity.a r5 = r4.f8142f
            return r5
        L_0x0115:
            r5 = move-exception
        L_0x0116:
            com.mbridge.msdk.click.entity.a r6 = r4.f8142f     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0126 }
            r6.f8123h = r5     // Catch:{ all -> 0x0126 }
            com.mbridge.msdk.click.entity.a r5 = r4.f8142f     // Catch:{ all -> 0x0126 }
            if (r2 == 0) goto L_0x0125
            r2.disconnect()
        L_0x0125:
            return r5
        L_0x0126:
            r5 = move-exception
            if (r2 == 0) goto L_0x012c
            r2.disconnect()
        L_0x012c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.h.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.click.entity.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A[Catch:{ all -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062 A[SYNTHETIC, Splitter:B:32:0x0062] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.io.InputStream r4, boolean r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto L_0x0013
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0011 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0011 }
            r4 = r5
            goto L_0x0013
        L_0x000f:
            r4 = move-exception
            goto L_0x0060
        L_0x0011:
            r4 = move-exception
            goto L_0x003c
        L_0x0013:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0011 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0011 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0011 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0011 }
        L_0x001d:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r4 == 0) goto L_0x002d
            r0.append(r4)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x001d
        L_0x0027:
            r4 = move-exception
            r1 = r5
            goto L_0x0060
        L_0x002a:
            r4 = move-exception
            r1 = r5
            goto L_0x003c
        L_0x002d:
            r5.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x005b
        L_0x0031:
            r4 = move-exception
            java.lang.String r5 = f8137a
            java.lang.String r4 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)
            goto L_0x005b
        L_0x003c:
            com.mbridge.msdk.click.entity.a r5 = r3.f8142f     // Catch:{ all -> 0x000f }
            if (r5 != 0) goto L_0x004d
            com.mbridge.msdk.click.entity.a r5 = new com.mbridge.msdk.click.entity.a     // Catch:{ all -> 0x000f }
            r5.<init>()     // Catch:{ all -> 0x000f }
            r3.f8142f = r5     // Catch:{ all -> 0x000f }
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x000f }
            r5.f8123h = r2     // Catch:{ all -> 0x000f }
        L_0x004d:
            java.lang.String r5 = f8137a     // Catch:{ all -> 0x000f }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x000f }
            com.mbridge.msdk.foundation.tools.af.b(r5, r4)     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ Exception -> 0x0031 }
        L_0x005b:
            java.lang.String r4 = r0.toString()
            return r4
        L_0x0060:
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0070
        L_0x0066:
            r5 = move-exception
            java.lang.String r0 = f8137a
            java.lang.String r5 = r5.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r5)
        L_0x0070:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.h.a(java.io.InputStream, boolean):java.lang.String");
    }
}
