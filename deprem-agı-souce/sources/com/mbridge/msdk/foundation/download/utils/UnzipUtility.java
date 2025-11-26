package com.mbridge.msdk.foundation.download.utils;

public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void extractFile(java.util.zip.ZipInputStream r4, java.lang.String r5) throws java.io.IOException {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            java.io.File r5 = r0.getParentFile()
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0016
            java.io.File r5 = r0.getParentFile()
            r5.mkdirs()
        L_0x0016:
            r5 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x003d }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x003d }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003d }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
        L_0x0025:
            int r0 = r4.read(r5)     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
            r2 = -1
            if (r0 == r2) goto L_0x0037
            r2 = 0
            r1.write(r5, r2, r0)     // Catch:{ IOException -> 0x0034, all -> 0x0031 }
            goto L_0x0025
        L_0x0031:
            r4 = move-exception
            r5 = r1
            goto L_0x0044
        L_0x0034:
            r4 = move-exception
            r5 = r1
            goto L_0x003e
        L_0x0037:
            r1.close()
            return
        L_0x003b:
            r4 = move-exception
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
        L_0x003e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003b }
            r0.<init>(r4)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x0044:
            if (r5 == 0) goto L_0x0049
            r5.close()
        L_0x0049:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.utils.UnzipUtility.extractFile(java.util.zip.ZipInputStream, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0164 A[SYNTHETIC, Splitter:B:115:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0172 A[SYNTHETIC, Splitter:B:120:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0182 A[SYNTHETIC, Splitter:B:125:0x0182] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0190 A[SYNTHETIC, Splitter:B:130:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int unzip(java.lang.String r14, java.lang.String r15) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "../"
            java.lang.String r1 = ".."
            java.lang.String r2 = "UnzipUtility"
            r3 = -1
            if (r14 == 0) goto L_0x019d
            if (r15 != 0) goto L_0x000d
            goto L_0x019d
        L_0x000d:
            java.lang.String r4 = "/"
            boolean r5 = r15.endsWith(r4)
            if (r5 != 0) goto L_0x0024
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r15)
            r5.append(r4)
            java.lang.String r15 = r5.toString()
        L_0x0024:
            java.io.File r4 = new java.io.File
            r4.<init>(r14)
            boolean r14 = r4.exists()
            if (r14 != 0) goto L_0x0031
            r14 = 1
            return r14
        L_0x0031:
            r14 = 0
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0159, all -> 0x0156 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0159, all -> 0x0156 }
            java.util.Enumeration r4 = r5.entries()     // Catch:{ IOException -> 0x0159, all -> 0x0156 }
            r6 = r14
        L_0x003c:
            boolean r7 = r4.hasMoreElements()     // Catch:{ IOException -> 0x00c3 }
            r8 = 0
            if (r7 == 0) goto L_0x0136
            java.lang.Object r7 = r4.nextElement()     // Catch:{ IOException -> 0x00c3 }
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch:{ IOException -> 0x00c3 }
            r9 = 2
            if (r7 != 0) goto L_0x0069
            if (r14 == 0) goto L_0x005a
            r14.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x005a
        L_0x0052:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x005a:
            if (r6 == 0) goto L_0x0068
            r6.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0068:
            return r9
        L_0x0069:
            java.lang.String r10 = r7.getName()     // Catch:{ IOException -> 0x00c3 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x00c3 }
            if (r11 != 0) goto L_0x0119
            boolean r11 = r10.startsWith(r1)     // Catch:{ IOException -> 0x00c3 }
            if (r11 != 0) goto L_0x0119
            boolean r11 = r10.startsWith(r0)     // Catch:{ IOException -> 0x00c3 }
            if (r11 == 0) goto L_0x0081
            goto L_0x0119
        L_0x0081:
            java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x00c3 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c3 }
            r12.<init>()     // Catch:{ IOException -> 0x00c3 }
            r12.append(r15)     // Catch:{ IOException -> 0x00c3 }
            r12.append(r10)     // Catch:{ IOException -> 0x00c3 }
            java.lang.String r10 = r12.toString()     // Catch:{ IOException -> 0x00c3 }
            r11.<init>(r10)     // Catch:{ IOException -> 0x00c3 }
            java.lang.String r10 = r11.getCanonicalPath()     // Catch:{ IOException -> 0x009d }
            goto L_0x009f
        L_0x009a:
            r15 = move-exception
            goto L_0x0180
        L_0x009d:
            java.lang.String r10 = ""
        L_0x009f:
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x00c3 }
            if (r12 != 0) goto L_0x00fc
            boolean r12 = r10.startsWith(r15)     // Catch:{ IOException -> 0x00c3 }
            if (r12 == 0) goto L_0x00fc
            boolean r12 = r10.startsWith(r1)     // Catch:{ IOException -> 0x00c3 }
            if (r12 != 0) goto L_0x00fc
            boolean r10 = r10.startsWith(r0)     // Catch:{ IOException -> 0x00c3 }
            if (r10 == 0) goto L_0x00b8
            goto L_0x00fc
        L_0x00b8:
            boolean r9 = r7.isDirectory()     // Catch:{ IOException -> 0x00c3 }
            if (r9 == 0) goto L_0x00c6
            r11.mkdirs()     // Catch:{ IOException -> 0x00c3 }
            goto L_0x003c
        L_0x00c3:
            r15 = move-exception
            goto L_0x015b
        L_0x00c6:
            java.io.File r9 = r11.getParentFile()     // Catch:{ IOException -> 0x00c3 }
            boolean r9 = r9.exists()     // Catch:{ IOException -> 0x00c3 }
            if (r9 != 0) goto L_0x00d7
            java.io.File r9 = r11.getParentFile()     // Catch:{ IOException -> 0x00c3 }
            r9.mkdirs()     // Catch:{ IOException -> 0x00c3 }
        L_0x00d7:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c3 }
            r9.<init>(r11)     // Catch:{ IOException -> 0x00c3 }
            java.io.InputStream r14 = r5.getInputStream(r7)     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r6]     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
        L_0x00e4:
            int r10 = r14.read(r7, r8, r6)     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            if (r10 == r3) goto L_0x00f9
            r9.write(r7, r8, r10)     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            r9.flush()     // Catch:{ IOException -> 0x00f5, all -> 0x00f1 }
            goto L_0x00e4
        L_0x00f1:
            r15 = move-exception
            r6 = r9
            goto L_0x0180
        L_0x00f5:
            r15 = move-exception
            r6 = r9
            goto L_0x015b
        L_0x00f9:
            r6 = r9
            goto L_0x003c
        L_0x00fc:
            if (r14 == 0) goto L_0x010a
            r14.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x010a
        L_0x0102:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x010a:
            if (r6 == 0) goto L_0x0118
            r6.close()     // Catch:{ IOException -> 0x0110 }
            goto L_0x0118
        L_0x0110:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0118:
            return r9
        L_0x0119:
            if (r14 == 0) goto L_0x0127
            r14.close()     // Catch:{ IOException -> 0x011f }
            goto L_0x0127
        L_0x011f:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0127:
            if (r6 == 0) goto L_0x0135
            r6.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0135
        L_0x012d:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0135:
            return r9
        L_0x0136:
            r5.close()     // Catch:{ IOException -> 0x00c3 }
            if (r14 == 0) goto L_0x0147
            r14.close()     // Catch:{ IOException -> 0x013f }
            goto L_0x0147
        L_0x013f:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0147:
            if (r6 == 0) goto L_0x0155
            r6.close()     // Catch:{ IOException -> 0x014d }
            goto L_0x0155
        L_0x014d:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0155:
            return r8
        L_0x0156:
            r15 = move-exception
            r6 = r14
            goto L_0x0180
        L_0x0159:
            r15 = move-exception
            r6 = r14
        L_0x015b:
            java.lang.String r15 = r15.getMessage()     // Catch:{ all -> 0x009a }
            com.mbridge.msdk.foundation.tools.af.b(r2, r15)     // Catch:{ all -> 0x009a }
            if (r14 == 0) goto L_0x0170
            r14.close()     // Catch:{ IOException -> 0x0168 }
            goto L_0x0170
        L_0x0168:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x0170:
            if (r6 == 0) goto L_0x017e
            r6.close()     // Catch:{ IOException -> 0x0176 }
            goto L_0x017e
        L_0x0176:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x017e:
            r14 = 3
            return r14
        L_0x0180:
            if (r14 == 0) goto L_0x018e
            r14.close()     // Catch:{ IOException -> 0x0186 }
            goto L_0x018e
        L_0x0186:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x018e:
            if (r6 == 0) goto L_0x019c
            r6.close()     // Catch:{ IOException -> 0x0194 }
            goto L_0x019c
        L_0x0194:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r14)
        L_0x019c:
            throw r15
        L_0x019d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.utils.UnzipUtility.unzip(java.lang.String, java.lang.String):int");
    }
}
