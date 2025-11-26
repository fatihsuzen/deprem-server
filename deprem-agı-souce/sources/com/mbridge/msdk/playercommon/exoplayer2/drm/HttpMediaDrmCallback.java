package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.annotation.TargetApi;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069 A[Catch:{ InvalidResponseCodeException -> 0x0050, all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[LOOP:1: B:7:0x002d->B:29:0x0071, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A[EDGE_INSN: B:30:0x0077->B:31:? ?: BREAK  , SYNTHETIC, Splitter:B:30:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] executePost(com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource.Factory r14, java.lang.String r15, byte[] r16, java.util.Map<java.lang.String, java.lang.String> r17) throws java.io.IOException {
        /*
            com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource r14 = r14.createDataSource()
            if (r17 == 0) goto L_0x002a
            java.util.Set r0 = r17.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r14.setRequestProperty(r2, r1)
            goto L_0x000e
        L_0x002a:
            r1 = 0
            r0 = r15
            r2 = r1
        L_0x002d:
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r3 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec
            android.net.Uri r4 = android.net.Uri.parse(r0)
            r12 = 0
            r13 = 1
            r6 = 0
            r8 = 0
            r10 = -1
            r5 = r16
            r3.<init>(r4, r5, r6, r8, r10, r12, r13)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSourceInputStream r4 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSourceInputStream
            r4.<init>(r14, r3)
            byte[] r14 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toByteArray(r4)     // Catch:{ InvalidResponseCodeException -> 0x0050 }
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
            return r14
        L_0x004d:
            r0 = move-exception
            r14 = r0
            goto L_0x0078
        L_0x0050:
            r0 = move-exception
            int r3 = r0.responseCode     // Catch:{ all -> 0x004d }
            r5 = 307(0x133, float:4.3E-43)
            if (r3 == r5) goto L_0x005d
            int r3 = r0.responseCode     // Catch:{ all -> 0x004d }
            r5 = 308(0x134, float:4.32E-43)
            if (r3 != r5) goto L_0x0065
        L_0x005d:
            int r3 = r2 + 1
            r5 = 5
            if (r2 >= r5) goto L_0x0064
            r2 = 1
            goto L_0x0067
        L_0x0064:
            r2 = r3
        L_0x0065:
            r3 = r2
            r2 = r1
        L_0x0067:
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = getRedirectUrl(r0)     // Catch:{ all -> 0x004d }
            goto L_0x006f
        L_0x006e:
            r2 = 0
        L_0x006f:
            if (r2 == 0) goto L_0x0077
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
            r0 = r2
            r2 = r3
            goto L_0x002d
        L_0x0077:
            throw r0     // Catch:{ all -> 0x004d }
        L_0x0078:
            com.mbridge.msdk.playercommon.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.drm.HttpMediaDrmCallback.executePost(com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource$Factory, java.lang.String, byte[], java.util.Map):byte[]");
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException) {
        List list;
        Map<String, List<String>> map = invalidResponseCodeException.headerFields;
        if (map == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public final void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    public final void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    public final byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest, @Nullable String str) throws Exception {
        String str2;
        String defaultUrl = keyRequest.getDefaultUrl();
        if (!TextUtils.isEmpty(defaultUrl)) {
            str = defaultUrl;
        }
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(str)) {
            str = this.defaultLicenseUrl;
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = C.PLAYREADY_UUID;
        if (uuid2.equals(uuid)) {
            str2 = "text/xml";
        } else if (C.CLEARKEY_UUID.equals(uuid)) {
            str2 = "application/json";
        } else {
            str2 = "application/octet-stream";
        }
        hashMap.put("Content-Type", str2);
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            hashMap.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, str, keyRequest.getData(), hashMap);
    }

    public final byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        return executePost(this.dataSourceFactory, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), new byte[0], (Map<String, String>) null);
    }

    public final void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(String str, boolean z4, HttpDataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z4;
        this.keyRequestProperties = new HashMap();
    }
}
