package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.tracker.network.toolbox.a;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f9543a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private final byte f9544b;

    public l(byte b5) {
        this.f9544b = b5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d A[Catch:{ all -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d4 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e7 A[ADDED_TO_REGION, Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010c A[SYNTHETIC, Splitter:B:53:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0123 A[SYNTHETIC, Splitter:B:57:0x0123] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.tracker.network.toolbox.g a(com.mbridge.msdk.tracker.network.u<?> r12, java.util.Map<java.lang.String, java.lang.String> r13) throws java.io.IOException {
        /*
            r11 = this;
            boolean r13 = com.mbridge.msdk.tracker.a.f11490a
            if (r13 == 0) goto L_0x002a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "SocketStack executeRequest "
            r13.append(r0)
            java.lang.String r0 = r12.k()
            r13.append(r0)
            java.lang.String r0 = ":"
            r13.append(r0)
            int r0 = r12.h()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "TrackManager_Volley"
            android.util.Log.d(r0, r13)
        L_0x002a:
            r13 = 0
            java.net.Socket r0 = new java.net.Socket     // Catch:{ all -> 0x0150 }
            java.lang.String r1 = r12.k()     // Catch:{ all -> 0x0150 }
            int r2 = r12.h()     // Catch:{ all -> 0x0150 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0150 }
            int r1 = r12.u()     // Catch:{ all -> 0x014c }
            r0.setSoTimeout(r1)     // Catch:{ all -> 0x014c }
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x0144
            r2 = 8
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x013f }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ all -> 0x013f }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x0067 }
            r3.order(r4)     // Catch:{ all -> 0x0067 }
            byte r5 = r11.f9544b     // Catch:{ all -> 0x0067 }
            r3.put(r5)     // Catch:{ all -> 0x0067 }
            byte[] r12 = r12.p()     // Catch:{ all -> 0x0067 }
            r5 = 1
            if (r12 == 0) goto L_0x006d
            int r6 = r12.length     // Catch:{ all -> 0x0067 }
            if (r6 != 0) goto L_0x0062
            goto L_0x006d
        L_0x0062:
            r6 = 3
            r3.put(r6)     // Catch:{ all -> 0x0067 }
            goto L_0x0070
        L_0x0067:
            r12 = move-exception
            r10 = r0
            r0 = r13
        L_0x006a:
            r13 = r10
            goto L_0x0154
        L_0x006d:
            r3.put(r5)     // Catch:{ all -> 0x0067 }
        L_0x0070:
            java.util.concurrent.atomic.AtomicInteger r6 = f9543a     // Catch:{ all -> 0x0067 }
            int r6 = r6.getAndIncrement()     // Catch:{ all -> 0x0067 }
            short r6 = (short) r6     // Catch:{ all -> 0x0067 }
            r3.putShort(r6)     // Catch:{ all -> 0x0067 }
            r6 = 0
            if (r12 == 0) goto L_0x00ad
            int r7 = r12.length     // Catch:{ all -> 0x0067 }
            if (r7 != 0) goto L_0x0081
            goto L_0x00ad
        L_0x0081:
            int r7 = r12.length     // Catch:{ all -> 0x0067 }
            if (r7 != 0) goto L_0x0086
            r12 = r13
            goto L_0x009a
        L_0x0086:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0067 }
            r7.<init>()     // Catch:{ all -> 0x0067 }
            java.util.zip.GZIPOutputStream r8 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0067 }
            r8.<init>(r7)     // Catch:{ all -> 0x0067 }
            r8.write(r12)     // Catch:{ all -> 0x0067 }
            r8.close()     // Catch:{ all -> 0x0067 }
            byte[] r12 = r7.toByteArray()     // Catch:{ all -> 0x0067 }
        L_0x009a:
            if (r12 != 0) goto L_0x009e
            r7 = r6
            goto L_0x009f
        L_0x009e:
            int r7 = r12.length     // Catch:{ all -> 0x0067 }
        L_0x009f:
            r3.putInt(r7)     // Catch:{ all -> 0x0067 }
            byte[] r7 = r3.array()     // Catch:{ all -> 0x0067 }
            r1.write(r7)     // Catch:{ all -> 0x0067 }
            r1.write(r12)     // Catch:{ all -> 0x0067 }
            goto L_0x00b7
        L_0x00ad:
            r3.putInt(r6)     // Catch:{ all -> 0x0067 }
            byte[] r12 = r3.array()     // Catch:{ all -> 0x0067 }
            r1.write(r12)     // Catch:{ all -> 0x0067 }
        L_0x00b7:
            r1.flush()     // Catch:{ all -> 0x0067 }
            java.io.InputStream r12 = r0.getInputStream()     // Catch:{ all -> 0x0067 }
            byte[] r7 = new byte[r2]     // Catch:{ all -> 0x0067 }
            r12.read(r7, r6, r2)     // Catch:{ all -> 0x0067 }
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r7)     // Catch:{ all -> 0x0067 }
            r12.order(r4)     // Catch:{ all -> 0x0102 }
            r2 = 4
            int r2 = r12.getInt(r2)     // Catch:{ all -> 0x0102 }
            byte r4 = r7[r5]     // Catch:{ all -> 0x0102 }
            r7 = 2
            if (r4 != r7) goto L_0x00d6
            r4 = r5
            goto L_0x00d7
        L_0x00d6:
            r4 = r6
        L_0x00d7:
            byte[] r7 = new byte[r2]     // Catch:{ all -> 0x0102 }
            java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ all -> 0x0102 }
            java.io.InputStream r9 = r0.getInputStream()     // Catch:{ all -> 0x0102 }
            r8.<init>(r9)     // Catch:{ all -> 0x0102 }
            r8.readFully(r7)     // Catch:{ all -> 0x0102 }
            if (r4 == 0) goto L_0x0108
            if (r2 != 0) goto L_0x0108
            com.mbridge.msdk.tracker.network.toolbox.g r4 = new com.mbridge.msdk.tracker.network.toolbox.g     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r5.<init>()     // Catch:{ all -> 0x0102 }
            r6 = 204(0xcc, float:2.86E-43)
            r4.<init>(r6, r5, r2, r13)     // Catch:{ all -> 0x0102 }
        L_0x00f5:
            a((java.io.OutputStream) r1)
            a((java.net.Socket) r0)
            r11.a((java.nio.ByteBuffer) r3)
            r11.a((java.nio.ByteBuffer) r12)
            return r4
        L_0x0102:
            r13 = move-exception
            r10 = r0
            r0 = r12
            r12 = r13
            goto L_0x006a
        L_0x0108:
            r4 = 500(0x1f4, float:7.0E-43)
            if (r2 >= r5) goto L_0x0123
            com.mbridge.msdk.tracker.network.toolbox.g r2 = new com.mbridge.msdk.tracker.network.toolbox.g     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r5.<init>()     // Catch:{ all -> 0x0102 }
            r2.<init>(r4, r5, r6, r13)     // Catch:{ all -> 0x0102 }
        L_0x0116:
            a((java.io.OutputStream) r1)
            a((java.net.Socket) r0)
            r11.a((java.nio.ByteBuffer) r3)
            r11.a((java.nio.ByteBuffer) r12)
            return r2
        L_0x0123:
            byte r7 = r7[r6]     // Catch:{ all -> 0x0102 }
            if (r7 != r5) goto L_0x0134
            com.mbridge.msdk.tracker.network.toolbox.g r4 = new com.mbridge.msdk.tracker.network.toolbox.g     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r5.<init>()     // Catch:{ all -> 0x0102 }
            r6 = 200(0xc8, float:2.8E-43)
            r4.<init>(r6, r5, r2, r13)     // Catch:{ all -> 0x0102 }
            goto L_0x00f5
        L_0x0134:
            com.mbridge.msdk.tracker.network.toolbox.g r2 = new com.mbridge.msdk.tracker.network.toolbox.g     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r5.<init>()     // Catch:{ all -> 0x0102 }
            r2.<init>(r4, r5, r6, r13)     // Catch:{ all -> 0x0102 }
            goto L_0x0116
        L_0x013f:
            r12 = move-exception
            r3 = r13
        L_0x0141:
            r13 = r0
            r0 = r3
            goto L_0x0154
        L_0x0144:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.String r2 = "create outputStream exception"
            r12.<init>(r2)     // Catch:{ all -> 0x013f }
            throw r12     // Catch:{ all -> 0x013f }
        L_0x014c:
            r12 = move-exception
            r1 = r13
            r3 = r1
            goto L_0x0141
        L_0x0150:
            r12 = move-exception
            r0 = r13
            r1 = r0
            r3 = r1
        L_0x0154:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x015a }
            r2.<init>(r12)     // Catch:{ all -> 0x015a }
            throw r2     // Catch:{ all -> 0x015a }
        L_0x015a:
            r12 = move-exception
            a((java.io.OutputStream) r1)
            a((java.net.Socket) r13)
            r11.a((java.nio.ByteBuffer) r3)
            r11.a((java.nio.ByteBuffer) r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.l.a(com.mbridge.msdk.tracker.network.u, java.util.Map):com.mbridge.msdk.tracker.network.toolbox.g");
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }
}
