package com.mbridge.msdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.a;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static volatile AtomicInteger f8159a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private g f8160b;

    /* renamed from: c  reason: collision with root package name */
    private String f8161c;

    /* renamed from: d  reason: collision with root package name */
    private int f8162d = 9377;

    public l() {
        g b5 = h.a().b(c.m().k());
        this.f8160b = b5;
        if (b5 == null) {
            h.a();
            this.f8160b = i.a();
        }
    }

    private JSONObject b(String str, CampaignEx campaignEx, boolean z4, boolean z5) {
        JSONObject jSONObject = new JSONObject();
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                String encodedQuery = parse.getEncodedQuery();
                this.f8161c = host;
                jSONObject.put("uri", "https://" + host + path);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, encodedQuery);
            }
        } catch (Throwable th) {
            af.b("SocketSpider", th.getMessage());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!z4 && !z5) {
                jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            if (campaignEx != null) {
                if (z4 && campaignEx.getcUA() == 1) {
                    jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
                }
                if (z5 && campaignEx.getImpUA() == 1) {
                    jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
                }
            } else {
                jSONObject2.put(Command.HTTP_HEADER_USER_AGENT, ab.g());
            }
            jSONObject2.put("Accept-Encoding", "gzip");
            if (this.f8160b.aJ() && !TextUtils.isEmpty(str)) {
                jSONObject2.put("referer", str);
            }
            jSONObject.put("header", jSONObject2);
        } catch (Throwable th2) {
            af.b("SocketSpider", th2.getMessage());
        }
        return jSONObject;
    }

    public final a a(String str, CampaignEx campaignEx, boolean z4, boolean z5) {
        a aVar = new a();
        aVar.f8122g = str;
        if (TextUtils.isEmpty(str)) {
            aVar.f8123h = "request url can not null.";
            return aVar;
        }
        String replace = str.replace(" ", "%20");
        JSONObject b5 = b(replace, campaignEx, z4, z5);
        if (b5.length() == 0) {
            aVar.f8123h = "request content generation failed.";
            return aVar;
        } else if (TextUtils.isEmpty(b5.optString("uri"))) {
            aVar.f8123h = "request url parse error.";
            return aVar;
        } else {
            if (campaignEx != null) {
                int trackingTcpPort = campaignEx.getTrackingTcpPort();
                if (trackingTcpPort == 0) {
                    trackingTcpPort = 9377;
                }
                this.f8162d = trackingTcpPort;
            }
            if (!TextUtils.isEmpty(this.f8161c)) {
                return a(replace, b5.toString());
            }
            aVar.f8123h = "request url parse error.";
            return aVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.net.Socket] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d3 A[SYNTHETIC, Splitter:B:83:0x01d3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.click.entity.a a(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = " length : "
            java.lang.String r3 = "SocketSpider"
            com.mbridge.msdk.click.entity.a r4 = new com.mbridge.msdk.click.entity.a
            r4.<init>()
            r5 = 0
            java.net.Socket r6 = new java.net.Socket     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = r1.f8161c     // Catch:{ all -> 0x01b1 }
            int r8 = r1.f8162d     // Catch:{ all -> 0x01b1 }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x01b1 }
            r7 = 15000(0x3a98, float:2.102E-41)
            r6.setSoTimeout(r7)     // Catch:{ all -> 0x01ad }
            java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ all -> 0x01ad }
            r8 = 8
            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x0052 }
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.wrap(r9)     // Catch:{ all -> 0x0052 }
            java.nio.ByteOrder r10 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x0052 }
            r9.order(r10)     // Catch:{ all -> 0x0052 }
            r11 = 2
            r9.put(r11)     // Catch:{ all -> 0x0052 }
            r12 = 3
            r9.put(r12)     // Catch:{ all -> 0x0052 }
            java.util.concurrent.atomic.AtomicInteger r13 = f8159a     // Catch:{ all -> 0x0052 }
            int r13 = r13.getAndIncrement()     // Catch:{ all -> 0x0052 }
            short r13 = (short) r13     // Catch:{ all -> 0x0052 }
            r9.putShort(r13)     // Catch:{ all -> 0x0052 }
            boolean r13 = android.text.TextUtils.isEmpty(r19)     // Catch:{ all -> 0x0052 }
            r14 = 0
            if (r13 == 0) goto L_0x0056
            r9.putInt(r14)     // Catch:{ all -> 0x0052 }
            byte[] r5 = r9.array()     // Catch:{ all -> 0x0052 }
            r7.write(r5)     // Catch:{ all -> 0x0052 }
            r13 = r14
            goto L_0x0083
        L_0x0052:
            r0 = move-exception
        L_0x0053:
            r5 = r6
            goto L_0x01b3
        L_0x0056:
            boolean r13 = android.text.TextUtils.isEmpty(r19)     // Catch:{ all -> 0x0052 }
            if (r13 == 0) goto L_0x005d
            goto L_0x0075
        L_0x005d:
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0052 }
            r5.<init>()     // Catch:{ all -> 0x0052 }
            java.util.zip.GZIPOutputStream r13 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0052 }
            r13.<init>(r5)     // Catch:{ all -> 0x0052 }
            byte[] r15 = r19.getBytes()     // Catch:{ all -> 0x0052 }
            r13.write(r15)     // Catch:{ all -> 0x0052 }
            r13.close()     // Catch:{ all -> 0x0052 }
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x0052 }
        L_0x0075:
            int r13 = r5.length     // Catch:{ all -> 0x0052 }
            r9.putInt(r13)     // Catch:{ all -> 0x0052 }
            byte[] r15 = r9.array()     // Catch:{ all -> 0x0052 }
            r7.write(r15)     // Catch:{ all -> 0x0052 }
            r7.write(r5)     // Catch:{ all -> 0x0052 }
        L_0x0083:
            r7.flush()     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r5.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r15 = "Socket Request : header : "
            r5.append(r15)     // Catch:{ all -> 0x0052 }
            byte[] r9 = r9.array()     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = java.util.Arrays.toString(r9)     // Catch:{ all -> 0x0052 }
            r5.append(r9)     // Catch:{ all -> 0x0052 }
            r5.append(r2)     // Catch:{ all -> 0x0052 }
            r5.append(r13)     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0052 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0052 }
            java.io.InputStream r5 = r6.getInputStream()     // Catch:{ all -> 0x0052 }
            byte[] r9 = new byte[r8]     // Catch:{ all -> 0x0052 }
            r5.read(r9, r14, r8)     // Catch:{ all -> 0x0052 }
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.wrap(r9)     // Catch:{ all -> 0x0052 }
            r13.order(r10)     // Catch:{ all -> 0x0052 }
            r10 = 4
            int r10 = r13.getInt(r10)     // Catch:{ all -> 0x0052 }
            r13 = 1
            byte r15 = r9[r13]     // Catch:{ all -> 0x0052 }
            if (r15 != r12) goto L_0x00c4
            r12 = r13
            goto L_0x00c5
        L_0x00c4:
            r12 = r14
        L_0x00c5:
            if (r15 != r11) goto L_0x00cb
            r15 = r13
        L_0x00c8:
            r16 = r8
            goto L_0x00cd
        L_0x00cb:
            r15 = r14
            goto L_0x00c8
        L_0x00cd:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r8.<init>()     // Catch:{ all -> 0x0052 }
            r19 = r13
            java.lang.String r13 = "Socket Response : header : "
            r8.append(r13)     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = java.util.Arrays.toString(r9)     // Catch:{ all -> 0x0052 }
            r8.append(r9)     // Catch:{ all -> 0x0052 }
            r8.append(r2)     // Catch:{ all -> 0x0052 }
            r8.append(r10)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = " isGzip : "
            r8.append(r2)     // Catch:{ all -> 0x0052 }
            r8.append(r12)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x0052 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x0052 }
            byte[] r2 = new byte[r10]     // Catch:{ all -> 0x0052 }
            java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ all -> 0x0052 }
            java.io.InputStream r9 = r6.getInputStream()     // Catch:{ all -> 0x0052 }
            r8.<init>(r9)     // Catch:{ all -> 0x0052 }
            r8.readFully(r2)     // Catch:{ all -> 0x0052 }
            if (r12 != 0) goto L_0x0116
            if (r10 <= r11) goto L_0x0116
            byte r8 = r2[r14]     // Catch:{ all -> 0x0052 }
            int r8 = r8 << 8
            byte r9 = r2[r19]     // Catch:{ all -> 0x0052 }
            r9 = r9 & 255(0xff, float:3.57E-43)
            r8 = r8 | r9
            r9 = 8075(0x1f8b, float:1.1315E-41)
            if (r8 != r9) goto L_0x0116
            r12 = r19
        L_0x0116:
            r8 = 200(0xc8, float:2.8E-43)
            if (r15 == 0) goto L_0x0132
            if (r10 != 0) goto L_0x0132
            r4.f8121f = r8     // Catch:{ all -> 0x0052 }
            r4.f8122g = r0     // Catch:{ all -> 0x0052 }
            r4.f8120e = r14     // Catch:{ all -> 0x0052 }
            r6.close()     // Catch:{ Exception -> 0x0129 }
            r7.close()     // Catch:{ Exception -> 0x0129 }
            return r4
        L_0x0129:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)
            return r4
        L_0x0132:
            r9 = r19
            if (r10 >= r9) goto L_0x0143
            r4.f8121f = r8     // Catch:{ all -> 0x0052 }
            r4.f8122g = r0     // Catch:{ all -> 0x0052 }
            r4.f8120e = r14     // Catch:{ all -> 0x0052 }
            r6.close()     // Catch:{ Exception -> 0x0129 }
            r7.close()     // Catch:{ Exception -> 0x0129 }
            return r4
        L_0x0143:
            if (r12 == 0) goto L_0x014c
            java.lang.String r2 = r1.a(r2)     // Catch:{ all -> 0x014a }
            goto L_0x0152
        L_0x014a:
            r0 = move-exception
            goto L_0x0196
        L_0x014c:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x014a }
            r9.<init>(r2)     // Catch:{ all -> 0x014a }
            r2 = r9
        L_0x0152:
            boolean r9 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x014a }
            if (r9 != 0) goto L_0x01a3
            r4.f8121f = r8     // Catch:{ all -> 0x014a }
            r4.f8122g = r0     // Catch:{ all -> 0x014a }
            r4.f8120e = r14     // Catch:{ all -> 0x014a }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x017e }
            r0.<init>(r2)     // Catch:{ all -> 0x017e }
            java.lang.String r2 = "data"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch:{ all -> 0x017e }
            if (r0 == 0) goto L_0x0186
            java.lang.String r2 = "location"
            java.lang.String r0 = r0.optString(r2)     // Catch:{ all -> 0x017e }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x017e }
            if (r2 != 0) goto L_0x0186
            r2 = 302(0x12e, float:4.23E-43)
            r4.f8121f = r2     // Catch:{ all -> 0x017e }
            r4.f8116a = r0     // Catch:{ all -> 0x017e }
            goto L_0x0186
        L_0x017e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x014a }
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)     // Catch:{ all -> 0x014a }
        L_0x0186:
            r6.close()     // Catch:{ Exception -> 0x018d }
            r7.close()     // Catch:{ Exception -> 0x018d }
            goto L_0x01db
        L_0x018d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)
            goto L_0x01db
        L_0x0196:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0052 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r2)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0052 }
            r4.f8123h = r0     // Catch:{ all -> 0x0052 }
        L_0x01a3:
            r5.close()     // Catch:{ all -> 0x0052 }
            r6.close()     // Catch:{ Exception -> 0x018d }
            r7.close()     // Catch:{ Exception -> 0x018d }
            goto L_0x01db
        L_0x01ad:
            r0 = move-exception
            r7 = r5
            goto L_0x0053
        L_0x01b1:
            r0 = move-exception
            r7 = r5
        L_0x01b3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            r2.<init>()     // Catch:{ all -> 0x01dc }
            java.lang.String r6 = "Socket exception: "
            r2.append(r6)     // Catch:{ all -> 0x01dc }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x01dc }
            r2.append(r6)     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01dc }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x01dc }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01dc }
            r4.f8123h = r0     // Catch:{ all -> 0x01dc }
            if (r5 == 0) goto L_0x01db
            r5.close()     // Catch:{ Exception -> 0x018d }
            if (r7 == 0) goto L_0x01db
            r7.close()     // Catch:{ Exception -> 0x018d }
        L_0x01db:
            return r4
        L_0x01dc:
            r0 = move-exception
            r2 = r0
            if (r5 == 0) goto L_0x01f1
            r5.close()     // Catch:{ Exception -> 0x01e9 }
            if (r7 == 0) goto L_0x01f1
            r7.close()     // Catch:{ Exception -> 0x01e9 }
            goto L_0x01f1
        L_0x01e9:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)
        L_0x01f1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.l.a(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.a");
    }

    private String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }
}
