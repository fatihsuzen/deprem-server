package com.mbridge.msdk.foundation.same.c;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0031 A[Catch:{ all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[SYNTHETIC, Splitter:B:23:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0045 A[SYNTHETIC, Splitter:B:30:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.InputStream a(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r1.<init>()     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0027 }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ Exception -> 0x0027 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0027 }
            byte[] r2 = r1.toByteArray()     // Catch:{ Exception -> 0x0027 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0027 }
            r1.close()     // Catch:{ Exception -> 0x001a }
            goto L_0x0022
        L_0x001a:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0022
            r0.printStackTrace()
        L_0x0022:
            r0 = r4
            goto L_0x0042
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x0043
        L_0x0027:
            r4 = move-exception
            goto L_0x002d
        L_0x0029:
            r4 = move-exception
            goto L_0x0043
        L_0x002b:
            r4 = move-exception
            r1 = r0
        L_0x002d:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x0034
            r4.printStackTrace()     // Catch:{ all -> 0x0024 }
        L_0x0034:
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x0042
        L_0x003a:
            r4 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0042
            r4.printStackTrace()
        L_0x0042:
            return r0
        L_0x0043:
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ Exception -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0051
            r0.printStackTrace()
        L_0x0051:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.c.a.a(android.graphics.Bitmap):java.io.InputStream");
    }
}
