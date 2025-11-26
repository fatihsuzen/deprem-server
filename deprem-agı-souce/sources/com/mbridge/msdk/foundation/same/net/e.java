package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.tracker.network.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static volatile AtomicInteger f9316a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f9317b;

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static e f9330a = new e();
    }

    public static e a() {
        return b.f9330a;
    }

    private e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("SocketThreadPool");
                return newThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        this.f9317b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public final String a(byte[] bArr) throws IOException {
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

    public final void a(String str, int i5, String str2, boolean z4, b bVar) {
        final a aVar = new a(str, i5, str2, z4, bVar);
        this.f9317b.execute(new Runnable() {
            public final void run() {
                aVar.a();
            }
        });
    }

    public class a {

        /* renamed from: b  reason: collision with root package name */
        private ByteBuffer f9322b;

        /* renamed from: c  reason: collision with root package name */
        private String f9323c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9324d;

        /* renamed from: e  reason: collision with root package name */
        private b f9325e;

        /* renamed from: f  reason: collision with root package name */
        private OutputStream f9326f;

        /* renamed from: g  reason: collision with root package name */
        private int f9327g;

        /* renamed from: h  reason: collision with root package name */
        private Socket f9328h;

        /* renamed from: i  reason: collision with root package name */
        private String f9329i;

        a(String str, int i5, String str2, boolean z4, b bVar) {
            this.f9323c = str;
            this.f9327g = i5;
            this.f9329i = str2;
            this.f9324d = z4;
            this.f9325e = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0088 A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x008e A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b0 A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00c2 A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x014d A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x014f A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0152 A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0154 A[Catch:{ all -> 0x0036, all -> 0x02c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01a1  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x01b9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r15 = this;
                java.lang.String r0 = " length : "
                java.lang.String r1 = "SocketManager"
                r2 = 0
                java.net.Socket r3 = new java.net.Socket     // Catch:{ all -> 0x0036 }
                java.lang.String r4 = r15.f9323c     // Catch:{ all -> 0x0036 }
                int r5 = r15.f9327g     // Catch:{ all -> 0x0036 }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x0036 }
                r15.f9328h = r3     // Catch:{ all -> 0x0036 }
                r4 = 15000(0x3a98, float:2.102E-41)
                r3.setSoTimeout(r4)     // Catch:{ all -> 0x0036 }
                java.lang.String r3 = r15.f9323c     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.same.net.e.d r4 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ all -> 0x0036 }
                java.lang.String r4 = r4.f9374i     // Catch:{ all -> 0x0036 }
                boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0036 }
                r4 = 0
                r5 = 1
                if (r3 != 0) goto L_0x0039
                java.lang.String r3 = r15.f9323c     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.same.net.e.d r6 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ all -> 0x0036 }
                java.lang.String r6 = r6.f9376k     // Catch:{ all -> 0x0036 }
                boolean r3 = r3.contains(r6)     // Catch:{ all -> 0x0036 }
                if (r3 == 0) goto L_0x0034
                goto L_0x0039
            L_0x0034:
                r3 = r4
                goto L_0x003a
            L_0x0036:
                r0 = move-exception
                goto L_0x0297
            L_0x0039:
                r3 = r5
            L_0x003a:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
                r6.<init>()     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = "Socket connect : "
                r6.append(r7)     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = r15.f9323c     // Catch:{ all -> 0x0036 }
                r6.append(r7)     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = " : "
                r6.append(r7)     // Catch:{ all -> 0x0036 }
                int r7 = r15.f9327g     // Catch:{ all -> 0x0036 }
                r6.append(r7)     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = " isAnalytics : "
                r6.append(r7)     // Catch:{ all -> 0x0036 }
                r6.append(r3)     // Catch:{ all -> 0x0036 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.tools.af.b(r1, r6)     // Catch:{ all -> 0x0036 }
                java.net.Socket r6 = r15.f9328h     // Catch:{ all -> 0x0036 }
                java.io.OutputStream r6 = r6.getOutputStream()     // Catch:{ all -> 0x0036 }
                r15.f9326f = r6     // Catch:{ all -> 0x0036 }
                r6 = 8
                byte[] r7 = new byte[r6]     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r7)     // Catch:{ all -> 0x0036 }
                r15.f9322b = r7     // Catch:{ all -> 0x0036 }
                java.nio.ByteOrder r8 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x0036 }
                r7.order(r8)     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r7 = r15.f9322b     // Catch:{ all -> 0x0036 }
                r9 = 2
                r7.put(r9)     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = r15.f9329i     // Catch:{ all -> 0x0036 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0036 }
                r10 = 3
                if (r7 == 0) goto L_0x008e
                java.nio.ByteBuffer r7 = r15.f9322b     // Catch:{ all -> 0x0036 }
                r7.put(r5)     // Catch:{ all -> 0x0036 }
                goto L_0x009a
            L_0x008e:
                java.nio.ByteBuffer r7 = r15.f9322b     // Catch:{ all -> 0x0036 }
                boolean r11 = r15.f9324d     // Catch:{ all -> 0x0036 }
                if (r11 == 0) goto L_0x0096
                r11 = r10
                goto L_0x0097
            L_0x0096:
                r11 = r9
            L_0x0097:
                r7.put(r11)     // Catch:{ all -> 0x0036 }
            L_0x009a:
                java.nio.ByteBuffer r7 = r15.f9322b     // Catch:{ all -> 0x0036 }
                java.util.concurrent.atomic.AtomicInteger r11 = com.mbridge.msdk.foundation.same.net.e.f9316a     // Catch:{ all -> 0x0036 }
                int r11 = r11.getAndIncrement()     // Catch:{ all -> 0x0036 }
                short r11 = (short) r11     // Catch:{ all -> 0x0036 }
                r7.putShort(r11)     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = r15.f9329i     // Catch:{ all -> 0x0036 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0036 }
                if (r7 == 0) goto L_0x00c2
                java.nio.ByteBuffer r7 = r15.f9322b     // Catch:{ all -> 0x0036 }
                r7.putInt(r4)     // Catch:{ all -> 0x0036 }
                java.io.OutputStream r7 = r15.f9326f     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r11 = r15.f9322b     // Catch:{ all -> 0x0036 }
                byte[] r11 = r11.array()     // Catch:{ all -> 0x0036 }
                r7.write(r11)     // Catch:{ all -> 0x0036 }
                r11 = r4
                goto L_0x0105
            L_0x00c2:
                boolean r7 = r15.f9324d     // Catch:{ all -> 0x0036 }
                if (r7 == 0) goto L_0x00e9
                java.lang.String r7 = r15.f9329i     // Catch:{ all -> 0x0036 }
                boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0036 }
                if (r11 == 0) goto L_0x00d0
                r7 = r2
                goto L_0x00ef
            L_0x00d0:
                java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0036 }
                r11.<init>()     // Catch:{ all -> 0x0036 }
                java.util.zip.GZIPOutputStream r12 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0036 }
                r12.<init>(r11)     // Catch:{ all -> 0x0036 }
                byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x0036 }
                r12.write(r7)     // Catch:{ all -> 0x0036 }
                r12.close()     // Catch:{ all -> 0x0036 }
                byte[] r7 = r11.toByteArray()     // Catch:{ all -> 0x0036 }
                goto L_0x00ef
            L_0x00e9:
                java.lang.String r7 = r15.f9329i     // Catch:{ all -> 0x0036 }
                byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x0036 }
            L_0x00ef:
                int r11 = r7.length     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r12 = r15.f9322b     // Catch:{ all -> 0x0036 }
                r12.putInt(r11)     // Catch:{ all -> 0x0036 }
                java.io.OutputStream r12 = r15.f9326f     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r13 = r15.f9322b     // Catch:{ all -> 0x0036 }
                byte[] r13 = r13.array()     // Catch:{ all -> 0x0036 }
                r12.write(r13)     // Catch:{ all -> 0x0036 }
                java.io.OutputStream r12 = r15.f9326f     // Catch:{ all -> 0x0036 }
                r12.write(r7)     // Catch:{ all -> 0x0036 }
            L_0x0105:
                java.io.OutputStream r7 = r15.f9326f     // Catch:{ all -> 0x0036 }
                r7.flush()     // Catch:{ all -> 0x0036 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
                r7.<init>()     // Catch:{ all -> 0x0036 }
                java.lang.String r12 = "Socket Request : header : "
                r7.append(r12)     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r12 = r15.f9322b     // Catch:{ all -> 0x0036 }
                byte[] r12 = r12.array()     // Catch:{ all -> 0x0036 }
                java.lang.String r12 = java.util.Arrays.toString(r12)     // Catch:{ all -> 0x0036 }
                r7.append(r12)     // Catch:{ all -> 0x0036 }
                r7.append(r0)     // Catch:{ all -> 0x0036 }
                r7.append(r11)     // Catch:{ all -> 0x0036 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r7)     // Catch:{ all -> 0x0036 }
                java.net.Socket r7 = r15.f9328h     // Catch:{ all -> 0x0036 }
                java.io.InputStream r7 = r7.getInputStream()     // Catch:{ all -> 0x0036 }
                byte[] r11 = new byte[r6]     // Catch:{ all -> 0x0036 }
                r7.read(r11, r4, r6)     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r11)     // Catch:{ all -> 0x0036 }
                r15.f9322b = r12     // Catch:{ all -> 0x0036 }
                r12.order(r8)     // Catch:{ all -> 0x0036 }
                java.nio.ByteBuffer r8 = r15.f9322b     // Catch:{ all -> 0x0036 }
                r12 = 4
                int r8 = r8.getInt(r12)     // Catch:{ all -> 0x0036 }
                byte r12 = r11[r5]     // Catch:{ all -> 0x0036 }
                if (r12 != r10) goto L_0x014f
                r10 = r5
                goto L_0x0150
            L_0x014f:
                r10 = r4
            L_0x0150:
                if (r12 != r9) goto L_0x0154
                r12 = r5
                goto L_0x0155
            L_0x0154:
                r12 = r4
            L_0x0155:
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
                r13.<init>()     // Catch:{ all -> 0x0036 }
                java.lang.String r14 = "Socket Response : header : "
                r13.append(r14)     // Catch:{ all -> 0x0036 }
                java.lang.String r11 = java.util.Arrays.toString(r11)     // Catch:{ all -> 0x0036 }
                r13.append(r11)     // Catch:{ all -> 0x0036 }
                r13.append(r0)     // Catch:{ all -> 0x0036 }
                r13.append(r8)     // Catch:{ all -> 0x0036 }
                java.lang.String r0 = " isGzip : "
                r13.append(r0)     // Catch:{ all -> 0x0036 }
                r13.append(r10)     // Catch:{ all -> 0x0036 }
                java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)     // Catch:{ all -> 0x0036 }
                byte[] r0 = new byte[r8]     // Catch:{ all -> 0x0036 }
                java.io.DataInputStream r11 = new java.io.DataInputStream     // Catch:{ all -> 0x0036 }
                java.net.Socket r13 = r15.f9328h     // Catch:{ all -> 0x0036 }
                java.io.InputStream r13 = r13.getInputStream()     // Catch:{ all -> 0x0036 }
                r11.<init>(r13)     // Catch:{ all -> 0x0036 }
                r11.readFully(r0)     // Catch:{ all -> 0x0036 }
                if (r10 != 0) goto L_0x019d
                if (r8 <= r9) goto L_0x019d
                byte r9 = r0[r4]     // Catch:{ all -> 0x0036 }
                int r6 = r9 << 8
                byte r9 = r0[r5]     // Catch:{ all -> 0x0036 }
                r9 = r9 & 255(0xff, float:3.57E-43)
                r6 = r6 | r9
                r9 = 8075(0x1f8b, float:1.1315E-41)
                if (r6 != r9) goto L_0x019d
                r10 = r5
            L_0x019d:
                com.mbridge.msdk.foundation.same.net.b r6 = r15.f9325e     // Catch:{ all -> 0x0036 }
                if (r6 != 0) goto L_0x01b9
                java.net.Socket r0 = r15.f9328h
                if (r0 == 0) goto L_0x02c0
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                r15.f9322b = r2     // Catch:{ IOException -> 0x01b0 }
                java.io.OutputStream r0 = r15.f9326f     // Catch:{ IOException -> 0x01b0 }
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                return
            L_0x01b0:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                return
            L_0x01b9:
                if (r12 == 0) goto L_0x01da
                if (r8 != 0) goto L_0x01da
                com.mbridge.msdk.foundation.same.net.d.a r0 = new com.mbridge.msdk.foundation.same.net.d.a     // Catch:{ all -> 0x0036 }
                r3 = 204(0xcc, float:2.86E-43)
                r0.<init>(r3, r2, r2)     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.same.net.d r0 = com.mbridge.msdk.foundation.same.net.d.a(r2, r0)     // Catch:{ all -> 0x0036 }
                r6.onSuccess(r0)     // Catch:{ all -> 0x0036 }
                java.net.Socket r0 = r15.f9328h
                if (r0 == 0) goto L_0x02c0
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                r15.f9322b = r2     // Catch:{ IOException -> 0x01b0 }
                java.io.OutputStream r0 = r15.f9326f     // Catch:{ IOException -> 0x01b0 }
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                return
            L_0x01da:
                if (r8 >= r5) goto L_0x01f0
                java.lang.String r0 = "The response data less than 1"
                r15.a(r0)     // Catch:{ all -> 0x0036 }
                java.net.Socket r0 = r15.f9328h
                if (r0 == 0) goto L_0x02c0
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                r15.f9322b = r2     // Catch:{ IOException -> 0x01b0 }
                java.io.OutputStream r0 = r15.f9326f     // Catch:{ IOException -> 0x01b0 }
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                return
            L_0x01f0:
                r9 = 200(0xc8, float:2.8E-43)
                if (r3 == 0) goto L_0x0219
                byte r0 = r0[r4]     // Catch:{ all -> 0x0036 }
                if (r0 != r5) goto L_0x0205
                com.mbridge.msdk.foundation.same.net.d.a r0 = new com.mbridge.msdk.foundation.same.net.d.a     // Catch:{ all -> 0x0036 }
                r0.<init>(r9, r2, r2)     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.same.net.d r0 = com.mbridge.msdk.foundation.same.net.d.a(r2, r0)     // Catch:{ all -> 0x0036 }
                r6.onSuccess(r0)     // Catch:{ all -> 0x0036 }
                goto L_0x020a
            L_0x0205:
                java.lang.String r0 = "The server returns fail"
                r15.a(r0)     // Catch:{ all -> 0x0036 }
            L_0x020a:
                java.net.Socket r0 = r15.f9328h
                if (r0 == 0) goto L_0x02c0
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                r15.f9322b = r2     // Catch:{ IOException -> 0x01b0 }
                java.io.OutputStream r0 = r15.f9326f     // Catch:{ IOException -> 0x01b0 }
                r0.close()     // Catch:{ IOException -> 0x01b0 }
                return
            L_0x0219:
                if (r10 == 0) goto L_0x0224
                com.mbridge.msdk.foundation.same.net.e r3 = com.mbridge.msdk.foundation.same.net.e.this     // Catch:{ all -> 0x0222 }
                java.lang.String r0 = r3.a(r0)     // Catch:{ all -> 0x0222 }
                goto L_0x022a
            L_0x0222:
                r0 = move-exception
                goto L_0x0266
            L_0x0224:
                java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0222 }
                r3.<init>(r0)     // Catch:{ all -> 0x0222 }
                r0 = r3
            L_0x022a:
                boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0222 }
                if (r3 != 0) goto L_0x0236
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0222 }
                r3.<init>(r0)     // Catch:{ all -> 0x0222 }
                goto L_0x0237
            L_0x0236:
                r3 = r2
            L_0x0237:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0222 }
                r4.<init>()     // Catch:{ all -> 0x0222 }
                java.lang.String r5 = "Socket Response length : "
                r4.append(r5)     // Catch:{ all -> 0x0222 }
                r4.append(r8)     // Catch:{ all -> 0x0222 }
                java.lang.String r5 = " "
                r4.append(r5)     // Catch:{ all -> 0x0222 }
                int r0 = r0.length()     // Catch:{ all -> 0x0222 }
                r4.append(r0)     // Catch:{ all -> 0x0222 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0222 }
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)     // Catch:{ all -> 0x0222 }
                com.mbridge.msdk.foundation.same.net.b r0 = r15.f9325e     // Catch:{ all -> 0x0222 }
                com.mbridge.msdk.foundation.same.net.d.a r4 = new com.mbridge.msdk.foundation.same.net.d.a     // Catch:{ all -> 0x0222 }
                r4.<init>(r9, r2, r2)     // Catch:{ all -> 0x0222 }
                com.mbridge.msdk.foundation.same.net.d r3 = com.mbridge.msdk.foundation.same.net.d.a(r3, r4)     // Catch:{ all -> 0x0222 }
                r0.onSuccess(r3)     // Catch:{ all -> 0x0222 }
                goto L_0x027c
            L_0x0266:
                java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0036 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0036 }
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)     // Catch:{ all -> 0x0036 }
                boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0036 }
                if (r0 == 0) goto L_0x0279
                java.lang.String r3 = "The JSON data is illegal"
            L_0x0279:
                r15.a(r3)     // Catch:{ all -> 0x0036 }
            L_0x027c:
                r7.close()     // Catch:{ all -> 0x0036 }
                java.net.Socket r0 = r15.f9328h
                if (r0 == 0) goto L_0x02c0
                r0.close()     // Catch:{ IOException -> 0x028e }
                r15.f9322b = r2     // Catch:{ IOException -> 0x028e }
                java.io.OutputStream r0 = r15.f9326f     // Catch:{ IOException -> 0x028e }
                r0.close()     // Catch:{ IOException -> 0x028e }
                goto L_0x02c0
            L_0x028e:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                goto L_0x02c0
            L_0x0297:
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02c1 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c1 }
                r3.<init>()     // Catch:{ all -> 0x02c1 }
                java.lang.String r4 = "Socket exception: "
                r3.append(r4)     // Catch:{ all -> 0x02c1 }
                r3.append(r0)     // Catch:{ all -> 0x02c1 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02c1 }
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x02c1 }
                r15.a(r0)     // Catch:{ all -> 0x02c1 }
                java.net.Socket r0 = r15.f9328h
                if (r0 == 0) goto L_0x02c0
                r0.close()     // Catch:{ IOException -> 0x028e }
                r15.f9322b = r2     // Catch:{ IOException -> 0x028e }
                java.io.OutputStream r0 = r15.f9326f     // Catch:{ IOException -> 0x028e }
                r0.close()     // Catch:{ IOException -> 0x028e }
            L_0x02c0:
                return
            L_0x02c1:
                r0 = move-exception
                java.net.Socket r3 = r15.f9328h
                if (r3 == 0) goto L_0x02d9
                r3.close()     // Catch:{ IOException -> 0x02d1 }
                r15.f9322b = r2     // Catch:{ IOException -> 0x02d1 }
                java.io.OutputStream r2 = r15.f9326f     // Catch:{ IOException -> 0x02d1 }
                r2.close()     // Catch:{ IOException -> 0x02d1 }
                goto L_0x02d9
            L_0x02d1:
                r2 = move-exception
                java.lang.String r2 = r2.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r2)
            L_0x02d9:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.e.a.a():void");
        }

        private void a(String str) {
            if (this.f9325e != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.f9325e.onError(new com.mbridge.msdk.foundation.same.net.a.a(13, new com.mbridge.msdk.foundation.same.net.d.a(MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR, str.getBytes(), (List<h>) null)));
            }
        }
    }
}
