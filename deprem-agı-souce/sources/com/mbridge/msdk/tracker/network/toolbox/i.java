package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.ad;

final class i {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f11676a;

        /* renamed from: b  reason: collision with root package name */
        final ad f11677b;

        private a(String str, ad adVar) {
            this.f11676a = str;
            this.f11677b = adVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045 A[SYNTHETIC, Splitter:B:24:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(java.io.InputStream r8, int r9, com.mbridge.msdk.tracker.network.toolbox.c r10, com.mbridge.msdk.tracker.network.q r11) throws java.io.IOException {
        /*
            java.lang.String r0 = "Error occurred when closing InputStream"
            com.mbridge.msdk.tracker.network.toolbox.l r1 = new com.mbridge.msdk.tracker.network.toolbox.l
            r1.<init>(r10, r9)
            if (r11 == 0) goto L_0x000e
            r2 = 0
            r11.f(r2)
        L_0x000e:
            r9 = 1024(0x400, float:1.435E-42)
            r2 = 0
            byte[] r9 = r10.a((int) r9)     // Catch:{ all -> 0x0041 }
        L_0x0015:
            int r3 = r8.read(r9)     // Catch:{ all -> 0x002b }
            r4 = -1
            if (r3 == r4) goto L_0x002d
            r1.write(r9, r2, r3)     // Catch:{ all -> 0x002b }
            if (r11 == 0) goto L_0x0015
            long r4 = r11.f()     // Catch:{ all -> 0x002b }
            long r6 = (long) r3     // Catch:{ all -> 0x002b }
            long r4 = r4 + r6
            r11.f(r4)     // Catch:{ all -> 0x002b }
            goto L_0x0015
        L_0x002b:
            r11 = move-exception
            goto L_0x0043
        L_0x002d:
            byte[] r11 = r1.toByteArray()     // Catch:{ all -> 0x002b }
            r8.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x003a
        L_0x0035:
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.mbridge.msdk.tracker.network.ae.a(r0, r8)
        L_0x003a:
            r10.a((byte[]) r9)
            r1.close()
            return r11
        L_0x0041:
            r11 = move-exception
            r9 = 0
        L_0x0043:
            if (r8 == 0) goto L_0x004e
            r8.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004e
        L_0x0049:
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.mbridge.msdk.tracker.network.ae.a(r0, r8)
        L_0x004e:
            r10.a((byte[]) r9)
            r1.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.tracker.network.toolbox.i.a(java.io.InputStream, int, com.mbridge.msdk.tracker.network.toolbox.c, com.mbridge.msdk.tracker.network.q):byte[]");
    }
}
