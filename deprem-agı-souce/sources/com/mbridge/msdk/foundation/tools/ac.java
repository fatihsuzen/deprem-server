package com.mbridge.msdk.foundation.tools;

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    protected static char[] f9606a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    protected static MessageDigest f9607b;

    /* renamed from: c  reason: collision with root package name */
    private static String f9608c = "SameFileMD5";

    static {
        f9607b = null;
        try {
            f9607b = MessageDigest.getInstance(SameMD5.TAG);
        } catch (NoSuchAlgorithmException e5) {
            PrintStream printStream = System.err;
            printStream.println(ac.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[SYNTHETIC, Splitter:B:26:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r6) throws java.io.IOException {
        /*
            java.lang.String r0 = ""
            if (r6 == 0) goto L_0x0071
            boolean r1 = r6.exists()
            if (r1 != 0) goto L_0x000b
            goto L_0x0071
        L_0x000b:
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ all -> 0x0044 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "r"
            r3.<init>(r6, r4)     // Catch:{ all -> 0x0044 }
            r6 = 10485760(0xa00000, float:1.469368E-38)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0029 }
        L_0x001d:
            int r1 = r3.read(r6)     // Catch:{ all -> 0x0029 }
            r4 = -1
            r5 = 0
            if (r1 == r4) goto L_0x002c
            r2.update(r6, r5, r1)     // Catch:{ all -> 0x0029 }
            goto L_0x001d
        L_0x0029:
            r6 = move-exception
            r1 = r3
            goto L_0x0045
        L_0x002c:
            byte[] r6 = r2.digest()     // Catch:{ all -> 0x0029 }
            int r1 = r6.length     // Catch:{ all -> 0x0029 }
            java.lang.String r6 = a(r6, r5, r1)     // Catch:{ all -> 0x0029 }
            r3.close()     // Catch:{ IOException -> 0x0039 }
            return r6
        L_0x0039:
            r0 = move-exception
            java.lang.String r1 = f9608c
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
            return r6
        L_0x0044:
            r6 = move-exception
        L_0x0045:
            java.lang.String r2 = f9608c     // Catch:{ all -> 0x005f }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x005f }
            com.mbridge.msdk.foundation.tools.af.b(r2, r6)     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x005e
        L_0x0054:
            r6 = move-exception
            java.lang.String r1 = f9608c
            java.lang.String r6 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r6)
        L_0x005e:
            return r0
        L_0x005f:
            r6 = move-exception
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0070
        L_0x0066:
            r0 = move-exception
            java.lang.String r1 = f9608c
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x0070:
            throw r6
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.a(java.io.File):java.lang.String");
    }

    private static String a(byte[] bArr, int i5, int i6) {
        StringBuffer stringBuffer = new StringBuffer(i6 * 2);
        int i7 = i6 + i5;
        while (i5 < i7) {
            byte b5 = bArr[i5];
            char[] cArr = f9606a;
            char c5 = cArr[(b5 & 240) >> 4];
            char c6 = cArr[b5 & 15];
            stringBuffer.append(c5);
            stringBuffer.append(c6);
            i5++;
        }
        return stringBuffer.toString();
    }
}
