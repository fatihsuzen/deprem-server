package com.uptodown.workers;

import S1.k;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C2286f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.T;
import l2.r;
import t3.s;
import z2.C2940B;
import z2.F;
import z2.G;
import z2.M;
import z2.P;

public class DownloadWorker extends Worker {

    /* renamed from: d  reason: collision with root package name */
    public static final a f21359d = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static C2668q f21360e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f21361f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static boolean f21362g;

    /* renamed from: a  reason: collision with root package name */
    private Context f21363a;

    /* renamed from: b  reason: collision with root package name */
    private F f21364b;

    /* renamed from: c  reason: collision with root package name */
    private String f21365c;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(C2668q qVar) {
            t.e(qVar, "download");
            if (qVar.h() > 0) {
                d(qVar.h());
            } else if (qVar.w() != null) {
                String w4 = qVar.w();
                t.b(w4);
                c(w4);
            }
        }

        public final void b() {
            r(false);
            p(true);
        }

        public final void c(String str) {
            String str2;
            t.e(str, "packagename");
            C2668q f5 = f();
            if (f5 != null) {
                str2 = f5.w();
            } else {
                str2 = null;
            }
            if (t.a(str2, str)) {
                b();
            }
        }

        public final void d(long j5) {
            if (j(j5)) {
                b();
            }
        }

        public final boolean e() {
            return DownloadWorker.f21361f;
        }

        public final C2668q f() {
            return DownloadWorker.f21360e;
        }

        public final C2668q g() {
            return f();
        }

        public final boolean h() {
            return DownloadWorker.f21362g;
        }

        public final boolean i() {
            return e();
        }

        public final boolean j(long j5) {
            if (f() == null) {
                return false;
            }
            C2668q f5 = f();
            t.b(f5);
            if (f5.h() == j5) {
                return true;
            }
            return false;
        }

        public final boolean k(long j5, long j6) {
            if (f() == null) {
                return false;
            }
            C2668q f5 = f();
            t.b(f5);
            if (f5.h() != j5) {
                return false;
            }
            C2668q f6 = f();
            t.b(f6);
            if (f6.E() == j6) {
                return true;
            }
            return false;
        }

        public final boolean l(String str) {
            t.e(str, "packagename");
            if (f() == null) {
                return false;
            }
            C2668q f5 = f();
            t.b(f5);
            if (t.a(f5.w(), str)) {
                return true;
            }
            return false;
        }

        public final boolean m(C2668q qVar) {
            t.e(qVar, "d");
            if (f() == null) {
                return false;
            }
            C2668q f5 = f();
            t.b(f5);
            if (f5.h() != qVar.h()) {
                return false;
            }
            C2668q f6 = f();
            t.b(f6);
            if (f6.E() == qVar.E()) {
                return true;
            }
            return false;
        }

        public final void n() {
            r(true);
        }

        public final void o() {
            r(false);
            p(false);
        }

        public final void p(boolean z4) {
            DownloadWorker.f21361f = z4;
        }

        public final void q(C2668q qVar) {
            DownloadWorker.f21360e = qVar;
        }

        public final void r(boolean z4) {
            DownloadWorker.f21362g = z4;
        }

        private a() {
        }
    }

    public interface b {
        void a(long j5);

        void b();

        void c(long j5);

        void d();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21363a = context;
    }

    public static /* synthetic */ void B(DownloadWorker downloadWorker, long j5, long j6, long j7, long j8, r rVar, int i5, Object obj) {
        r rVar2;
        if (obj == null) {
            if ((i5 & 16) != 0) {
                rVar2 = null;
            } else {
                rVar2 = rVar;
            }
            downloadWorker.A(j5, j6, j7, j8, rVar2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logEventDownloadCompleted");
    }

    private final void D(int i5) {
        if (f21360e != null) {
            Data.Builder builder = new Data.Builder();
            builder.putInt("downloadProgress", i5);
            setProgressAsync(builder.build());
            if (x() == null) {
                M.f26506a.j(this.f21363a);
            }
            C2668q qVar = f21360e;
            t.b(qVar);
            M(qVar, 201);
        }
    }

    private final HttpsURLConnection F(URL url) {
        URLConnection openConnection = url.openConnection();
        t.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        N(httpsURLConnection);
        return httpsURLConnection;
    }

    private final void G(C2668q qVar, String str) {
        if (qVar != null) {
            qVar.J(this.f21363a);
            L(qVar);
            if (qVar.P()) {
                M.f26506a.z(this.f21363a, qVar, str);
            }
        }
    }

    private final void H(String str, long j5, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("exception", str);
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
        bundle.putString("url", str2);
        o(" (109)", bundle, j5);
    }

    private final void I(C2668q qVar, r rVar, String str, String str2, long j5, String str3) {
        T x4 = x();
        if (x4 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("packagename", x4.h());
            P.f26510a.f().send(102, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("exception", str);
            bundle2.putString("url", str3);
            C(x4, qVar, rVar, bundle2, str2, j5);
            return;
        }
        H(str, j5, str3);
    }

    private final void J(String str, Bundle bundle, long j5, C2668q qVar) {
        G(qVar, str);
        if (j5 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j5) / ((long) 1000));
        }
        Bundle k5 = k(this, bundle, (r) null, 2, (Object) null);
        F f5 = this.f21364b;
        if (f5 != null) {
            f5.d("download", k5);
        }
    }

    private final void N(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "694");
        httpsURLConnection.setRequestProperty("APIKEY", P.f26510a.d());
        httpsURLConnection.setConnectTimeout(MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        httpsURLConnection.setReadTimeout(90000);
    }

    public static /* synthetic */ Bundle k(DownloadWorker downloadWorker, Bundle bundle, r rVar, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                rVar = null;
            }
            return downloadWorker.j(bundle, rVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFirebaseParams");
    }

    private final void m(InputStream inputStream, OutputStream outputStream, HttpsURLConnection httpsURLConnection) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        httpsURLConnection.disconnect();
    }

    private final void q(r rVar) {
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "first_data");
        z(bundle, this.f21365c, rVar);
    }

    public final void A(long j5, long j6, long j7, long j8, r rVar) {
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "completed");
        if (j5 == 0) {
            long currentTimeMillis = (System.currentTimeMillis() - j7) / ((long) 1000);
            if (currentTimeMillis > 0) {
                j5 = j8 / currentTimeMillis;
            }
        }
        bundle.putLong("speed", j5);
        bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j6) / ((long) 1000));
        z(bundle, this.f21365c, rVar);
    }

    public void C(T t5, C2668q qVar, r rVar, Bundle bundle, String str, long j5) {
        t.e(t5, "update");
        t.e(qVar, "download");
        t.e(rVar, "df");
        t.e(bundle, "bundleParamsFail");
    }

    public final boolean E(HttpsURLConnection httpsURLConnection, long j5) {
        t.e(httpsURLConnection, "urlConnection");
        httpsURLConnection.connect();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
        bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, NotificationCompat.CATEGORY_STATUS);
        bundle.putString("responseCode", String.valueOf(responseCode));
        bundle.putString("url", httpsURLConnection.getURL().toString());
        if (x() != null) {
            bundle.putInt("update", 1);
        } else {
            bundle.putInt("update", 0);
        }
        o(" (105)", bundle, j5);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v109, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v110, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v111, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v112, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v113, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v114, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v115, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v116, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x021a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.net.ssl.HttpsURLConnection K(java.lang.String r19, long r20, l2.r r22) {
        /*
            r18 = this;
            r1 = r18
            r7 = r19
            r4 = r20
            java.lang.String r8 = "redirect"
            java.lang.String r9 = "url"
            java.lang.String r10 = "error"
            java.lang.String r11 = "fail"
            java.lang.String r12 = "type"
            java.lang.String r0 = "urlApk"
            kotlin.jvm.internal.t.e(r7, r0)
            r13 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x01e5, IllegalStateException -> 0x01e1, IllegalArgumentException -> 0x01dd, SecurityException -> 0x01d9, MalformedURLException -> 0x01d5, ProtocolException -> 0x01d1, SSLHandshakeException -> 0x01cd, IOException -> 0x01c9 }
            r0.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x01e5, IllegalStateException -> 0x01e1, IllegalArgumentException -> 0x01dd, SecurityException -> 0x01d9, MalformedURLException -> 0x01d5, ProtocolException -> 0x01d1, SSLHandshakeException -> 0x01cd, IOException -> 0x01c9 }
            java.lang.String r2 = r0.getHost()     // Catch:{ SocketTimeoutException -> 0x01e5, IllegalStateException -> 0x01e1, IllegalArgumentException -> 0x01dd, SecurityException -> 0x01d9, MalformedURLException -> 0x01d5, ProtocolException -> 0x01d1, SSLHandshakeException -> 0x01cd, IOException -> 0x01c9 }
            r1.f21365c = r2     // Catch:{ SocketTimeoutException -> 0x01e5, IllegalStateException -> 0x01e1, IllegalArgumentException -> 0x01dd, SecurityException -> 0x01d9, MalformedURLException -> 0x01d5, ProtocolException -> 0x01d1, SSLHandshakeException -> 0x01cd, IOException -> 0x01c9 }
            javax.net.ssl.HttpsURLConnection r2 = r1.F(r0)     // Catch:{ SocketTimeoutException -> 0x01e5, IllegalStateException -> 0x01e1, IllegalArgumentException -> 0x01dd, SecurityException -> 0x01d9, MalformedURLException -> 0x01d5, ProtocolException -> 0x01d1, SSLHandshakeException -> 0x01cd, IOException -> 0x01c9 }
            r0 = 0
            r2.setInstanceFollowRedirects(r0)     // Catch:{ SocketTimeoutException -> 0x0066, IllegalStateException -> 0x0062, IllegalArgumentException -> 0x005e, SecurityException -> 0x005a, MalformedURLException -> 0x0056, ProtocolException -> 0x0052, SSLHandshakeException -> 0x004e, IOException -> 0x004a }
            int r3 = r2.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0066, IllegalStateException -> 0x0062, IllegalArgumentException -> 0x005e, SecurityException -> 0x005a, MalformedURLException -> 0x0056, ProtocolException -> 0x0052, SSLHandshakeException -> 0x004e, IOException -> 0x004a }
            r14 = 300(0x12c, float:4.2E-43)
            r15 = 200(0xc8, float:2.8E-43)
            if (r3 < r15) goto L_0x0038
            if (r3 >= r14) goto L_0x0038
            r16 = 1
            goto L_0x003a
        L_0x0038:
            r16 = r0
        L_0x003a:
            if (r16 != 0) goto L_0x01c2
            com.uptodown.workers.DownloadWorker$a r16 = f21359d     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01be, IllegalArgumentException -> 0x01bc, SecurityException -> 0x01ba, MalformedURLException -> 0x01b8, ProtocolException -> 0x01b6, SSLHandshakeException -> 0x01b4, IOException -> 0x01b2 }
            boolean r16 = r16.i()     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01be, IllegalArgumentException -> 0x01bc, SecurityException -> 0x01ba, MalformedURLException -> 0x01b8, ProtocolException -> 0x01b6, SSLHandshakeException -> 0x01b4, IOException -> 0x01b2 }
            if (r16 == 0) goto L_0x006a
            r0 = r22
            r1.n(r4, r0)     // Catch:{ SocketTimeoutException -> 0x0066, IllegalStateException -> 0x0062, IllegalArgumentException -> 0x005e, SecurityException -> 0x005a, MalformedURLException -> 0x0056, ProtocolException -> 0x0052, SSLHandshakeException -> 0x004e, IOException -> 0x004a }
            return r13
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            r13 = r2
            goto L_0x01e9
        L_0x004e:
            r0 = move-exception
        L_0x004f:
            r13 = r2
            goto L_0x01ef
        L_0x0052:
            r0 = move-exception
        L_0x0053:
            r13 = r2
            goto L_0x01f5
        L_0x0056:
            r0 = move-exception
        L_0x0057:
            r13 = r2
            goto L_0x01fb
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            r13 = r2
            goto L_0x0201
        L_0x005e:
            r0 = move-exception
        L_0x005f:
            r13 = r2
            goto L_0x0207
        L_0x0062:
            r0 = move-exception
        L_0x0063:
            r13 = r2
            goto L_0x020d
        L_0x0066:
            r0 = move-exception
        L_0x0067:
            r13 = r2
            goto L_0x0213
        L_0x006a:
            r0 = r22
            java.lang.String r6 = "Location"
            java.lang.String r6 = r2.getHeaderField(r6)     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01be, IllegalArgumentException -> 0x01bc, SecurityException -> 0x01ba, MalformedURLException -> 0x01b8, ProtocolException -> 0x01b6, SSLHandshakeException -> 0x01b4, IOException -> 0x01b2 }
            r17 = r13
            java.lang.String r13 = "responseCode"
            if (r6 == 0) goto L_0x0137
            java.net.URL r3 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0130, IllegalStateException -> 0x0129, IllegalArgumentException -> 0x0122, SecurityException -> 0x011b, MalformedURLException -> 0x0114, ProtocolException -> 0x010d, SSLHandshakeException -> 0x0106, IOException -> 0x00ff }
            r3.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x0130, IllegalStateException -> 0x0129, IllegalArgumentException -> 0x0122, SecurityException -> 0x011b, MalformedURLException -> 0x0114, ProtocolException -> 0x010d, SSLHandshakeException -> 0x0106, IOException -> 0x00ff }
            java.lang.String r14 = r3.getHost()     // Catch:{ SocketTimeoutException -> 0x0130, IllegalStateException -> 0x0129, IllegalArgumentException -> 0x0122, SecurityException -> 0x011b, MalformedURLException -> 0x0114, ProtocolException -> 0x010d, SSLHandshakeException -> 0x0106, IOException -> 0x00ff }
            r1.f21365c = r14     // Catch:{ SocketTimeoutException -> 0x0130, IllegalStateException -> 0x0129, IllegalArgumentException -> 0x0122, SecurityException -> 0x011b, MalformedURLException -> 0x0114, ProtocolException -> 0x010d, SSLHandshakeException -> 0x0106, IOException -> 0x00ff }
            javax.net.ssl.HttpsURLConnection r14 = r1.F(r3)     // Catch:{ SocketTimeoutException -> 0x0130, IllegalStateException -> 0x0129, IllegalArgumentException -> 0x0122, SecurityException -> 0x011b, MalformedURLException -> 0x0114, ProtocolException -> 0x010d, SSLHandshakeException -> 0x0106, IOException -> 0x00ff }
            int r3 = r14.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            if (r3 < r15) goto L_0x00a1
            r2 = 400(0x190, float:5.6E-43)
            if (r3 >= r2) goto L_0x00a1
            r2 = 300(0x12c, float:4.2E-43)
            if (r3 >= r2) goto L_0x0097
            r6 = 1
            goto L_0x0098
        L_0x0097:
            r6 = 0
        L_0x0098:
            r0 = r14
            r14 = r2
            r2 = r0
            r16 = r6
            r13 = r17
            r0 = 0
            goto L_0x003a
        L_0x00a1:
            r0 = r3
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r3.putString(r12, r11)     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r3.putString(r13, r0)     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r3.putString(r10, r8)     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r3.putString(r9, r6)     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            java.lang.String r2 = " (107)"
            l2.q r6 = f21360e     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r1.J(r2, r3, r4, r6)     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            return r17
        L_0x00bf:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00c4:
            r13 = r14
            goto L_0x01e9
        L_0x00c7:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00cc:
            r13 = r14
            goto L_0x01ef
        L_0x00cf:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00d4:
            r13 = r14
            goto L_0x01f5
        L_0x00d7:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00dc:
            r13 = r14
            goto L_0x01fb
        L_0x00df:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00e4:
            r13 = r14
            goto L_0x0201
        L_0x00e7:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00ec:
            r13 = r14
            goto L_0x0207
        L_0x00ef:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00f4:
            r13 = r14
            goto L_0x020d
        L_0x00f7:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x00fc:
            r13 = r14
            goto L_0x0213
        L_0x00ff:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x004b
        L_0x0106:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x004f
        L_0x010d:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0053
        L_0x0114:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0057
        L_0x011b:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x005b
        L_0x0122:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x005f
        L_0x0129:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0063
        L_0x0130:
            r0 = move-exception
            r1 = r18
            r4 = r20
            goto L_0x0067
        L_0x0137:
            r0 = r3
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            r3.putString(r12, r11)     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            r3.putString(r13, r0)     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            java.lang.String r0 = "location_null"
            r3.putString(r10, r0)     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            r3.putString(r9, r7)     // Catch:{ SocketTimeoutException -> 0x01aa, IllegalStateException -> 0x01a2, IllegalArgumentException -> 0x019a, SecurityException -> 0x0192, MalformedURLException -> 0x018a, ProtocolException -> 0x0182, SSLHandshakeException -> 0x017a, IOException -> 0x0172 }
            r14 = r2
            java.lang.String r2 = " (104)"
            l2.q r6 = f21360e     // Catch:{ SocketTimeoutException -> 0x00f7, IllegalStateException -> 0x00ef, IllegalArgumentException -> 0x00e7, SecurityException -> 0x00df, MalformedURLException -> 0x00d7, ProtocolException -> 0x00cf, SSLHandshakeException -> 0x00c7, IOException -> 0x00bf }
            r1 = r18
            r4 = r20
            r1.J(r2, r3, r4, r6)     // Catch:{ SocketTimeoutException -> 0x0170, IllegalStateException -> 0x016e, IllegalArgumentException -> 0x016b, SecurityException -> 0x0168, MalformedURLException -> 0x0165, ProtocolException -> 0x0162, SSLHandshakeException -> 0x015f, IOException -> 0x015c }
            return r17
        L_0x015c:
            r0 = move-exception
            goto L_0x00c4
        L_0x015f:
            r0 = move-exception
            goto L_0x00cc
        L_0x0162:
            r0 = move-exception
            goto L_0x00d4
        L_0x0165:
            r0 = move-exception
            goto L_0x00dc
        L_0x0168:
            r0 = move-exception
            goto L_0x00e4
        L_0x016b:
            r0 = move-exception
            goto L_0x00ec
        L_0x016e:
            r0 = move-exception
            goto L_0x00f4
        L_0x0170:
            r0 = move-exception
            goto L_0x00fc
        L_0x0172:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x0177:
            r14 = r2
            goto L_0x00c4
        L_0x017a:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x017f:
            r14 = r2
            goto L_0x00cc
        L_0x0182:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x0187:
            r14 = r2
            goto L_0x00d4
        L_0x018a:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x018f:
            r14 = r2
            goto L_0x00dc
        L_0x0192:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x0197:
            r14 = r2
            goto L_0x00e4
        L_0x019a:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x019f:
            r14 = r2
            goto L_0x00ec
        L_0x01a2:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x01a7:
            r14 = r2
            goto L_0x00f4
        L_0x01aa:
            r0 = move-exception
            r1 = r18
            r4 = r20
        L_0x01af:
            r14 = r2
            goto L_0x00fc
        L_0x01b2:
            r0 = move-exception
            goto L_0x0177
        L_0x01b4:
            r0 = move-exception
            goto L_0x017f
        L_0x01b6:
            r0 = move-exception
            goto L_0x0187
        L_0x01b8:
            r0 = move-exception
            goto L_0x018f
        L_0x01ba:
            r0 = move-exception
            goto L_0x0197
        L_0x01bc:
            r0 = move-exception
            goto L_0x019f
        L_0x01be:
            r0 = move-exception
            goto L_0x01a7
        L_0x01c0:
            r0 = move-exception
            goto L_0x01af
        L_0x01c2:
            r14 = r2
            r17 = r13
            r13 = r14
            r0 = r17
            goto L_0x0218
        L_0x01c9:
            r0 = move-exception
            r17 = r13
            goto L_0x01e9
        L_0x01cd:
            r0 = move-exception
            r17 = r13
            goto L_0x01ef
        L_0x01d1:
            r0 = move-exception
            r17 = r13
            goto L_0x01f5
        L_0x01d5:
            r0 = move-exception
            r17 = r13
            goto L_0x01fb
        L_0x01d9:
            r0 = move-exception
            r17 = r13
            goto L_0x0201
        L_0x01dd:
            r0 = move-exception
            r17 = r13
            goto L_0x0207
        L_0x01e1:
            r0 = move-exception
            r17 = r13
            goto L_0x020d
        L_0x01e5:
            r0 = move-exception
            r17 = r13
            goto L_0x0213
        L_0x01e9:
            r0.printStackTrace()
            java.lang.String r0 = "IOException"
            goto L_0x0218
        L_0x01ef:
            r0.printStackTrace()
            java.lang.String r0 = "SSLHandshakeException"
            goto L_0x0218
        L_0x01f5:
            r0.printStackTrace()
            java.lang.String r0 = "ProtocolException"
            goto L_0x0218
        L_0x01fb:
            r0.printStackTrace()
            java.lang.String r0 = "MalformedURLException"
            goto L_0x0218
        L_0x0201:
            r0.printStackTrace()
            java.lang.String r0 = "SecurityException"
            goto L_0x0218
        L_0x0207:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalArgumentException"
            goto L_0x0218
        L_0x020d:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalStateException"
            goto L_0x0218
        L_0x0213:
            r0.printStackTrace()
            java.lang.String r0 = "SocketTimeoutException"
        L_0x0218:
            if (r0 == 0) goto L_0x0237
            r1.H(r0, r4, r7)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r3.putString(r12, r11)
            r3.putString(r10, r8)
            java.lang.String r2 = "exception"
            r3.putString(r2, r0)
            r3.putString(r9, r7)
            java.lang.String r2 = " (110)"
            l2.q r6 = f21360e
            r1.J(r2, r3, r4, r6)
        L_0x0237:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.K(java.lang.String, long, l2.r):javax.net.ssl.HttpsURLConnection");
    }

    public void L(C2668q qVar) {
        t.e(qVar, "download");
    }

    public void M(C2668q qVar, int i5) {
        t.e(qVar, "download");
    }

    public final void O(String str) {
        this.f21365c = str;
    }

    public ListenableWorker.Result doWork() {
        ListenableWorker.Result failure = ListenableWorker.Result.failure();
        t.d(failure, "failure(...)");
        return failure;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle j(android.os.Bundle r8, l2.r r9) {
        /*
            r7 = this;
            java.lang.String r0 = "bundleParams"
            kotlin.jvm.internal.t.e(r8, r0)
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f13477F
            l2.j r1 = r0.m()
            java.lang.String r2 = "deeplink"
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x002f
            l2.q r1 = f21360e
            if (r1 == 0) goto L_0x002f
            l2.j r0 = r0.m()
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.b()
            l2.q r1 = f21360e
            kotlin.jvm.internal.t.b(r1)
            int r1 = r1.q()
            if (r0 != r1) goto L_0x002f
            r8.putInt(r2, r4)
            goto L_0x0032
        L_0x002f:
            r8.putInt(r2, r3)
        L_0x0032:
            l2.A$a r0 = l2.C2641A.f24721f
            android.content.Context r1 = r7.f21363a
            l2.A r0 = r0.b(r1)
            if (r0 == 0) goto L_0x0058
            l2.q r1 = f21360e
            java.lang.String r2 = "notification_fcm"
            if (r1 == 0) goto L_0x0055
            int r0 = r0.c()
            l2.q r1 = f21360e
            kotlin.jvm.internal.t.b(r1)
            int r1 = r1.q()
            if (r0 != r1) goto L_0x0055
            r8.putInt(r2, r4)
            goto L_0x0058
        L_0x0055:
            r8.putInt(r2, r3)
        L_0x0058:
            java.lang.String r0 = r7.f21365c
            if (r0 == 0) goto L_0x0061
            java.lang.String r1 = "host"
            r8.putString(r1, r0)
        L_0x0061:
            if (r9 == 0) goto L_0x0091
            long r0 = r9.d()
            r5 = 0
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x007a
            long r0 = r9.d()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "fileId"
            r8.putString(r1, r0)
        L_0x007a:
            long r0 = r9.i()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0091
            z2.G r0 = z2.G.f26487a
            long r1 = r9.i()
            java.lang.String r9 = r0.e(r1)
            java.lang.String r0 = "size"
            r8.putString(r0, r9)
        L_0x0091:
            l2.T r9 = r7.x()
            java.lang.String r0 = "update"
            if (r9 == 0) goto L_0x009d
            r8.putInt(r0, r4)
            goto L_0x00a0
        L_0x009d:
            r8.putInt(r0, r3)
        L_0x00a0:
            z2.G r9 = z2.G.f26487a
            android.os.Bundle r8 = r9.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.j(android.os.Bundle, l2.r):android.os.Bundle");
    }

    public final Bundle l(long j5, long j6, File file, r rVar) {
        Bundle bundle;
        File file2 = file;
        t.e(file2, "file");
        r rVar2 = rVar;
        t.e(rVar2, "downloadFile");
        long i5 = rVar2.i();
        String e5 = rVar2.e();
        C2668q qVar = f21360e;
        t.b(qVar);
        M(qVar, 205);
        if (file2.length() > 0) {
            long j7 = j5 + j6;
            if (i5 == 0 || (j7 == i5 && file2.length() == j7)) {
                Bundle bundle2 = null;
                boolean z4 = false;
                String str = null;
                int i6 = 0;
                while (!z4 && i6 < 3) {
                    i6++;
                    if (file2.length() == j7 && (str = C2286f.f20690a.e(file2.getAbsolutePath())) != null && s.E(str, e5, true)) {
                        z4 = true;
                    }
                }
                if (str == null) {
                    bundle2 = new Bundle();
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                    bundle2.putString("filehash", e5);
                    bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "filehash_calculated_null");
                } else if (!z4) {
                    bundle2 = new Bundle();
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                    bundle2.putString("filehash", e5);
                    bundle2.putString("filehashCalculated", str);
                    bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "filehash_not_match");
                }
                bundle = bundle2;
            } else {
                bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size_not_match");
            }
        } else {
            bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size_zero");
        }
        C2668q qVar2 = f21360e;
        t.b(qVar2);
        M(qVar2, 206);
        if (bundle != null) {
            bundle.putString("fileId", String.valueOf(rVar2.d()));
        }
        if (rVar2.d() > 0 && bundle != null) {
            bundle.putString("fileId", String.valueOf(rVar2.d()));
        }
        if (rVar2.i() > 0 && bundle != null) {
            bundle.putString("size", G.f26487a.e(rVar2.i()));
        }
        return bundle;
    }

    public final void n(long j5, r rVar) {
        C2668q qVar = f21360e;
        if (qVar != null) {
            t.b(qVar);
            qVar.U(this.f21363a);
            C2940B a5 = C2940B.f26458v.a(this.f21363a);
            a5.a();
            C2668q qVar2 = f21360e;
            t.b(qVar2);
            if (qVar2.P()) {
                a5.A(f21360e);
            } else {
                C2668q qVar3 = f21360e;
                t.b(qVar3);
                Iterator it = qVar3.o().iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    r rVar2 = (r) next;
                    rVar2.p(0);
                    rVar2.l(0);
                    a5.E1(rVar2);
                }
            }
            a5.m();
            if (f21362g) {
                f21359d.o();
            }
            M.f26506a.e(this.f21363a);
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "cancelled");
            if (j5 > 0) {
                bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j5) / ((long) 1000));
            }
            z(bundle, (String) null, rVar);
            C2668q qVar4 = f21360e;
            t.b(qVar4);
            M(qVar4, 207);
        }
    }

    public void o(String str, Bundle bundle, long j5) {
        t.e(str, "errorCode");
        t.e(bundle, "bundle");
    }

    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r27v11 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r27v12 */
    /* JADX WARNING: type inference failed for: r27v21 */
    /* JADX WARNING: type inference failed for: r27v22 */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0392, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0393, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0399, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x039a, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x03a0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x03a1, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x03b9, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x03c8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x03dc, code lost:
        java.lang.Thread.sleep(20000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x03e7, code lost:
        if (f21359d.i() != false) goto L_0x03e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03ea, code lost:
        r7 = z2.H.f26488a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x03f0, code lost:
        if (r7.d() != false) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x03fa, code lost:
        if (com.uptodown.activities.preferences.a.f15150a.b0(r1.f21363a) == false) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0407, code lost:
        if (r43.l() == 1) goto L_0x0409;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x040a, code lost:
        m(r10, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0412, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0436, code lost:
        r7 = r13.getURL();
        kotlin.jvm.internal.t.d(r7, r2);
        r7 = F(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0441, code lost:
        r8 = r41 + r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0445, code lost:
        if (r8 > 0) goto L_0x0447;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:?, code lost:
        r13 = r25;
        r7.setRequestProperty(r13, r11 + r8 + '-');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0461, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0464, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0467, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x046a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x046d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0471, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0475, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0479, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x047c, code lost:
        r13 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0480, code lost:
        r7.connect();
        r9 = r7.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0489, code lost:
        if (r9 < 200) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x048f, code lost:
        r10 = r7.getInputStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0493, code lost:
        if (r10 != null) goto L_0x0495;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0495, code lost:
        r4.d();
        r8 = 0;
        r0 = r10.read(r5, 0, 8192);
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x049f, code lost:
        if (r0 <= 0) goto L_0x04a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x04a1, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:?, code lost:
        m((java.io.InputStream) null, r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x05b3, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x05b4, code lost:
        m(r10, r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x05bc, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:?, code lost:
        m(r10, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x05c5, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x05c6, code lost:
        m(r10, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x05ce, code lost:
        throw new java.io.IOException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x05cf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x05d0, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x05d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x05d5, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x05d9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x05da, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x05de, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x05df, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x05e3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x05e4, code lost:
        r37 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0212 A[Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0229 A[SYNTHETIC, Splitter:B:117:0x0229] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0392 A[Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }, ExcHandler: SecurityException (e java.lang.SecurityException), Splitter:B:221:0x03c9] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0399 A[Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }, ExcHandler: IllegalArgumentException (e java.lang.IllegalArgumentException), Splitter:B:187:0x035f] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03a0 A[Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }, ExcHandler: IllegalStateException (e java.lang.IllegalStateException), Splitter:B:187:0x035f] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03dc A[Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x04ad A[Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x05f4 A[Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }] */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0606 A[Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }] */
    /* JADX WARNING: Removed duplicated region for block: B:466:0x07a8  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x07c4  */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x04ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x05c6 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long p(javax.net.ssl.HttpsURLConnection r41, java.io.File r42, l2.C2668q r43, l2.r r44, java.lang.String r45, long r46, com.uptodown.workers.DownloadWorker.b r48) {
        /*
            r40 = this;
            r1 = r40
            r0 = r42
            r2 = r43
            r3 = r44
            r5 = r45
            r6 = r46
            r4 = r48
            java.lang.String r8 = "toString(...)"
            java.lang.String r9 = "type"
            java.lang.String r10 = "urlConnectionParam"
            r11 = r41
            kotlin.jvm.internal.t.e(r11, r10)
            java.lang.String r10 = "file"
            kotlin.jvm.internal.t.e(r0, r10)
            java.lang.String r10 = "download"
            kotlin.jvm.internal.t.e(r2, r10)
            java.lang.String r10 = "downloadFile"
            kotlin.jvm.internal.t.e(r3, r10)
            java.lang.String r10 = "host"
            kotlin.jvm.internal.t.e(r5, r10)
            java.lang.String r10 = "downloadListener"
            kotlin.jvm.internal.t.e(r4, r10)
            long r12 = r3.i()
            java.lang.String r10 = r0.getAbsolutePath()
            r3.k(r10)
            r16 = -1
            r14 = 0
            boolean r18 = r0.exists()     // Catch:{ SocketTimeoutException -> 0x0767, IllegalStateException -> 0x075c, IllegalArgumentException -> 0x0751, SecurityException -> 0x0746, MalformedURLException -> 0x073b, ProtocolException -> 0x072f, SSLHandshakeException -> 0x0723, IOException -> 0x0717 }
            if (r18 != 0) goto L_0x0093
            java.io.File r18 = r0.getParentFile()     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
            if (r18 == 0) goto L_0x0050
            r18.mkdirs()     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
        L_0x0050:
            r18 = r14
            goto L_0x00a6
        L_0x0053:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x0057:
            r10 = 0
            r12 = 0
            goto L_0x0772
        L_0x005b:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x005f:
            r10 = 0
            r12 = 0
            goto L_0x077c
        L_0x0063:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x0067:
            r10 = 0
            r12 = 0
            goto L_0x0782
        L_0x006b:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x006f:
            r10 = 0
            r12 = 0
            goto L_0x0788
        L_0x0073:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x0077:
            r10 = 0
            r12 = 0
            goto L_0x078e
        L_0x007b:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x007f:
            r10 = 0
            r12 = 0
            goto L_0x0794
        L_0x0083:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x0087:
            r10 = 0
            r12 = 0
            goto L_0x079a
        L_0x008b:
            r0 = move-exception
            r37 = r8
            r13 = r11
        L_0x008f:
            r10 = 0
            r12 = 0
            goto L_0x07a0
        L_0x0093:
            long r18 = r0.length()     // Catch:{ SocketTimeoutException -> 0x0767, IllegalStateException -> 0x075c, IllegalArgumentException -> 0x0751, SecurityException -> 0x0746, MalformedURLException -> 0x073b, ProtocolException -> 0x072f, SSLHandshakeException -> 0x0723, IOException -> 0x0717 }
            long r20 = r3.h()     // Catch:{ SocketTimeoutException -> 0x0767, IllegalStateException -> 0x075c, IllegalArgumentException -> 0x0751, SecurityException -> 0x0746, MalformedURLException -> 0x073b, ProtocolException -> 0x072f, SSLHandshakeException -> 0x0723, IOException -> 0x0717 }
            int r18 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r18 == 0) goto L_0x0050
            r0.delete()     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
            r3.p(r14)     // Catch:{ SocketTimeoutException -> 0x008b, IllegalStateException -> 0x0083, IllegalArgumentException -> 0x007b, SecurityException -> 0x0073, MalformedURLException -> 0x006b, ProtocolException -> 0x0063, SSLHandshakeException -> 0x005b, IOException -> 0x0053 }
            goto L_0x0050
        L_0x00a6:
            long r14 = r0.length()     // Catch:{ SocketTimeoutException -> 0x070d, IllegalStateException -> 0x0703, IllegalArgumentException -> 0x06f9, SecurityException -> 0x06ef, MalformedURLException -> 0x06e5, ProtocolException -> 0x06db, SSLHandshakeException -> 0x06d1, IOException -> 0x06c7 }
            int r20 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r20 > 0) goto L_0x0129
            long r12 = r40.r(r41)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            z2.B$a r10 = z2.C2940B.f26458v     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            android.content.Context r11 = r1.f21363a     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            z2.B r10 = r10.a(r11)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            r10.a()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.util.ArrayList r11 = r2.o()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            r2 = 0
            java.lang.Object r11 = r11.get(r2)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            l2.r r11 = (l2.r) r11     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            r11.q(r12)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.util.ArrayList r11 = r43.o()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.lang.Object r11 = r11.get(r2)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.lang.String r2 = "get(...)"
            kotlin.jvm.internal.t.d(r11, r2)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            l2.r r11 = (l2.r) r11     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            r10.E1(r11)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            r10.m()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            goto L_0x0129
        L_0x00e1:
            r0 = move-exception
            r13 = r41
        L_0x00e4:
            r37 = r8
            r14 = r18
            goto L_0x0057
        L_0x00ea:
            r0 = move-exception
            r13 = r41
        L_0x00ed:
            r37 = r8
            r14 = r18
            goto L_0x005f
        L_0x00f3:
            r0 = move-exception
            r13 = r41
        L_0x00f6:
            r37 = r8
            r14 = r18
            goto L_0x0067
        L_0x00fc:
            r0 = move-exception
            r13 = r41
        L_0x00ff:
            r37 = r8
            r14 = r18
            goto L_0x006f
        L_0x0105:
            r0 = move-exception
            r13 = r41
        L_0x0108:
            r37 = r8
            r14 = r18
            goto L_0x0077
        L_0x010e:
            r0 = move-exception
            r13 = r41
        L_0x0111:
            r37 = r8
            r14 = r18
            goto L_0x007f
        L_0x0117:
            r0 = move-exception
            r13 = r41
        L_0x011a:
            r37 = r8
            r14 = r18
            goto L_0x0087
        L_0x0120:
            r0 = move-exception
            r13 = r41
        L_0x0123:
            r37 = r8
            r14 = r18
            goto L_0x008f
        L_0x0129:
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            java.lang.String r11 = "bytes="
            java.lang.String r10 = "Range"
            r22 = r2
            java.lang.String r2 = "getURL(...)"
            r23 = r12
            if (r22 <= 0) goto L_0x01f2
            int r13 = (r14 > r23 ? 1 : (r14 == r23 ? 0 : -1))
            if (r13 >= 0) goto L_0x01c3
            java.net.URL r13 = r41.getURL()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            kotlin.jvm.internal.t.d(r13, r2)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            javax.net.ssl.HttpsURLConnection r13 = r1.F(r13)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            r12.<init>()     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            r12.append(r11)     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            r12.append(r14)     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            r25 = r14
            r14 = 45
            r12.append(r14)     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            java.lang.String r12 = r12.toString()     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            r13.setRequestProperty(r10, r12)     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            r14 = 1
            r12.<init>(r0, r14)     // Catch:{ SocketTimeoutException -> 0x01c0, IllegalStateException -> 0x01bd, IllegalArgumentException -> 0x01ba, SecurityException -> 0x01b7, MalformedURLException -> 0x01b4, ProtocolException -> 0x01b1, SSLHandshakeException -> 0x01ae, IOException -> 0x01ab }
            java.lang.String r0 = "resume"
        L_0x0167:
            r41 = r25
            goto L_0x01ff
        L_0x016b:
            r0 = move-exception
        L_0x016c:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x0772
        L_0x0173:
            r0 = move-exception
        L_0x0174:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x077c
        L_0x017b:
            r0 = move-exception
        L_0x017c:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x0782
        L_0x0183:
            r0 = move-exception
        L_0x0184:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x0788
        L_0x018b:
            r0 = move-exception
        L_0x018c:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x078e
        L_0x0193:
            r0 = move-exception
        L_0x0194:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x0794
        L_0x019b:
            r0 = move-exception
        L_0x019c:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x079a
        L_0x01a3:
            r0 = move-exception
        L_0x01a4:
            r37 = r8
            r14 = r18
            r10 = 0
            goto L_0x07a0
        L_0x01ab:
            r0 = move-exception
            goto L_0x00e4
        L_0x01ae:
            r0 = move-exception
            goto L_0x00ed
        L_0x01b1:
            r0 = move-exception
            goto L_0x00f6
        L_0x01b4:
            r0 = move-exception
            goto L_0x00ff
        L_0x01b7:
            r0 = move-exception
            goto L_0x0108
        L_0x01ba:
            r0 = move-exception
            goto L_0x0111
        L_0x01bd:
            r0 = move-exception
            goto L_0x011a
        L_0x01c0:
            r0 = move-exception
            goto L_0x0123
        L_0x01c3:
            r0.delete()     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            r12.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0120, IllegalStateException -> 0x0117, IllegalArgumentException -> 0x010e, SecurityException -> 0x0105, MalformedURLException -> 0x00fc, ProtocolException -> 0x00f3, SSLHandshakeException -> 0x00ea, IOException -> 0x00e1 }
            java.lang.String r0 = "reset"
            r13 = r41
            r41 = r18
            goto L_0x01ff
        L_0x01d2:
            r0 = move-exception
            r13 = r41
            goto L_0x016c
        L_0x01d6:
            r0 = move-exception
            r13 = r41
            goto L_0x0174
        L_0x01da:
            r0 = move-exception
            r13 = r41
            goto L_0x017c
        L_0x01de:
            r0 = move-exception
            r13 = r41
            goto L_0x0184
        L_0x01e2:
            r0 = move-exception
            r13 = r41
            goto L_0x018c
        L_0x01e6:
            r0 = move-exception
            r13 = r41
            goto L_0x0194
        L_0x01ea:
            r0 = move-exception
            r13 = r41
            goto L_0x019c
        L_0x01ee:
            r0 = move-exception
            r13 = r41
            goto L_0x01a4
        L_0x01f2:
            r25 = r14
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x070d, IllegalStateException -> 0x0703, IllegalArgumentException -> 0x06f9, SecurityException -> 0x06ef, MalformedURLException -> 0x06e5, ProtocolException -> 0x06db, SSLHandshakeException -> 0x06d1, IOException -> 0x06c7 }
            r12.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x070d, IllegalStateException -> 0x0703, IllegalArgumentException -> 0x06f9, SecurityException -> 0x06ef, MalformedURLException -> 0x06e5, ProtocolException -> 0x06db, SSLHandshakeException -> 0x06d1, IOException -> 0x06c7 }
            java.lang.String r0 = "new"
            r13 = r41
            goto L_0x0167
        L_0x01ff:
            android.os.Bundle r14 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            r14.<init>()     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            r14.putString(r9, r0)     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            r1.z(r14, r5, r3)     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            long r14 = r1.r(r13)     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            int r0 = (r23 > r18 ? 1 : (r23 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x0214
            long r23 = r41 + r14
        L_0x0214:
            r25 = r14
            r14 = r23
            java.net.URL r0 = r13.getURL()     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            java.lang.String r0 = r0.toString()     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            kotlin.jvm.internal.t.d(r0, r8)     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            long r23 = r41 + r25
            int r23 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r23 == 0) goto L_0x0249
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            java.lang.String r4 = "fail"
            r2.putString(r9, r4)     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            java.lang.String r4 = "error"
            java.lang.String r9 = "content_length_not_match"
            r2.putString(r4, r9)     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            java.lang.String r4 = "url"
            r2.putString(r4, r0)     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            java.lang.String r0 = " (105)"
            r1.o(r0, r2, r6)     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            r2 = 0
            r1.m(r2, r2, r13)     // Catch:{ SocketTimeoutException -> 0x01a3, IllegalStateException -> 0x019b, IllegalArgumentException -> 0x0193, SecurityException -> 0x018b, MalformedURLException -> 0x0183, ProtocolException -> 0x017b, SSLHandshakeException -> 0x0173, IOException -> 0x016b }
            return r16
        L_0x0249:
            r9 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r9]     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            long r23 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            java.io.InputStream r6 = r13.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0686, IllegalStateException -> 0x067d, IllegalArgumentException -> 0x0674, SecurityException -> 0x066b, MalformedURLException -> 0x0662, ProtocolException -> 0x0659, SSLHandshakeException -> 0x0650, IOException -> 0x0647 }
            r7 = 0
            int r0 = r6.read(r5, r7, r9)     // Catch:{ SocketTimeoutException -> 0x0332, IllegalStateException -> 0x0327, IllegalArgumentException -> 0x031c, SecurityException -> 0x0311, MalformedURLException -> 0x0306, ProtocolException -> 0x02fb, SSLHandshakeException -> 0x02f0, IOException -> 0x02e5 }
            if (r0 <= 0) goto L_0x033d
            r25 = r10
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x0332, IllegalStateException -> 0x0327, IllegalArgumentException -> 0x031c, SecurityException -> 0x0311, MalformedURLException -> 0x0306, ProtocolException -> 0x02fb, SSLHandshakeException -> 0x02f0, IOException -> 0x02e5 }
            r4.c(r9)     // Catch:{ SocketTimeoutException -> 0x0332, IllegalStateException -> 0x0327, IllegalArgumentException -> 0x031c, SecurityException -> 0x0311, MalformedURLException -> 0x0306, ProtocolException -> 0x02fb, SSLHandshakeException -> 0x02f0, IOException -> 0x02e5 }
            r1.q(r3)     // Catch:{ SocketTimeoutException -> 0x0332, IllegalStateException -> 0x0327, IllegalArgumentException -> 0x031c, SecurityException -> 0x0311, MalformedURLException -> 0x0306, ProtocolException -> 0x02fb, SSLHandshakeException -> 0x02f0, IOException -> 0x02e5 }
            r12.write(r5, r7, r0)     // Catch:{ SocketTimeoutException -> 0x0332, IllegalStateException -> 0x0327, IllegalArgumentException -> 0x031c, SecurityException -> 0x0311, MalformedURLException -> 0x0306, ProtocolException -> 0x02fb, SSLHandshakeException -> 0x02f0, IOException -> 0x02e5 }
            r27 = r6
            long r6 = (long) r0
            long r28 = r3.h()     // Catch:{ SocketTimeoutException -> 0x02e1, IllegalStateException -> 0x02dd, IllegalArgumentException -> 0x02d9, SecurityException -> 0x02d5, MalformedURLException -> 0x02d1, ProtocolException -> 0x02cd, SSLHandshakeException -> 0x02c9, IOException -> 0x02c5 }
            r30 = r6
            long r6 = r28 + r30
            r3.p(r6)     // Catch:{ SocketTimeoutException -> 0x02bc, IllegalStateException -> 0x02b3, IllegalArgumentException -> 0x02aa, SecurityException -> 0x02a1, MalformedURLException -> 0x0298, ProtocolException -> 0x028f, SSLHandshakeException -> 0x0286, IOException -> 0x027d }
            r28 = r30
            goto L_0x0345
        L_0x027d:
            r0 = move-exception
        L_0x027e:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x0772
        L_0x0286:
            r0 = move-exception
        L_0x0287:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x077c
        L_0x028f:
            r0 = move-exception
        L_0x0290:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x0782
        L_0x0298:
            r0 = move-exception
        L_0x0299:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x0788
        L_0x02a1:
            r0 = move-exception
        L_0x02a2:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x078e
        L_0x02aa:
            r0 = move-exception
        L_0x02ab:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x0794
        L_0x02b3:
            r0 = move-exception
        L_0x02b4:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x079a
        L_0x02bc:
            r0 = move-exception
        L_0x02bd:
            r37 = r8
            r10 = r27
            r14 = r30
            goto L_0x07a0
        L_0x02c5:
            r0 = move-exception
            r30 = r6
            goto L_0x027e
        L_0x02c9:
            r0 = move-exception
            r30 = r6
            goto L_0x0287
        L_0x02cd:
            r0 = move-exception
            r30 = r6
            goto L_0x0290
        L_0x02d1:
            r0 = move-exception
            r30 = r6
            goto L_0x0299
        L_0x02d5:
            r0 = move-exception
            r30 = r6
            goto L_0x02a2
        L_0x02d9:
            r0 = move-exception
            r30 = r6
            goto L_0x02ab
        L_0x02dd:
            r0 = move-exception
            r30 = r6
            goto L_0x02b4
        L_0x02e1:
            r0 = move-exception
            r30 = r6
            goto L_0x02bd
        L_0x02e5:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x0772
        L_0x02f0:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x077c
        L_0x02fb:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x0782
        L_0x0306:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x0788
        L_0x0311:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x078e
        L_0x031c:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x0794
        L_0x0327:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x079a
        L_0x0332:
            r0 = move-exception
            r27 = r6
            r37 = r8
            r14 = r18
            r10 = r27
            goto L_0x07a0
        L_0x033d:
            r27 = r6
            r25 = r10
            r9 = r18
            r28 = r9
        L_0x0345:
            z2.B$a r6 = z2.C2940B.f26458v     // Catch:{ SocketTimeoutException -> 0x0640, IllegalStateException -> 0x0639, IllegalArgumentException -> 0x0632, SecurityException -> 0x062b, MalformedURLException -> 0x0624, ProtocolException -> 0x061d, SSLHandshakeException -> 0x0616, IOException -> 0x060f }
            android.content.Context r7 = r1.getApplicationContext()     // Catch:{ SocketTimeoutException -> 0x0640, IllegalStateException -> 0x0639, IllegalArgumentException -> 0x0632, SecurityException -> 0x062b, MalformedURLException -> 0x0624, ProtocolException -> 0x061d, SSLHandshakeException -> 0x0616, IOException -> 0x060f }
            r30 = r9
            java.lang.String r9 = "getApplicationContext(...)"
            kotlin.jvm.internal.t.d(r7, r9)     // Catch:{ SocketTimeoutException -> 0x0640, IllegalStateException -> 0x0639, IllegalArgumentException -> 0x0632, SecurityException -> 0x062b, MalformedURLException -> 0x0624, ProtocolException -> 0x061d, SSLHandshakeException -> 0x0616, IOException -> 0x060f }
            z2.B r6 = r6.a(r7)     // Catch:{ SocketTimeoutException -> 0x0640, IllegalStateException -> 0x0639, IllegalArgumentException -> 0x0632, SecurityException -> 0x062b, MalformedURLException -> 0x0624, ProtocolException -> 0x061d, SSLHandshakeException -> 0x0616, IOException -> 0x060f }
            r6.a()     // Catch:{ SocketTimeoutException -> 0x0640, IllegalStateException -> 0x0639, IllegalArgumentException -> 0x0632, SecurityException -> 0x062b, MalformedURLException -> 0x0624, ProtocolException -> 0x061d, SSLHandshakeException -> 0x0616, IOException -> 0x060f }
            r32 = r18
            r10 = r27
            r7 = 0
            r9 = 0
        L_0x035f:
            com.uptodown.workers.DownloadWorker$a r27 = f21359d     // Catch:{ SocketTimeoutException -> 0x05e3, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392, MalformedURLException -> 0x05de, ProtocolException -> 0x05d9, SSLHandshakeException -> 0x05d4, IOException -> 0x05cf }
            boolean r27 = r27.i()     // Catch:{ SocketTimeoutException -> 0x05e3, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392, MalformedURLException -> 0x05de, ProtocolException -> 0x05d9, SSLHandshakeException -> 0x05d4, IOException -> 0x05cf }
            if (r27 != 0) goto L_0x03b9
            if (r0 <= 0) goto L_0x03b9
            r27 = r7
        L_0x036b:
            boolean r0 = f21362g     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            if (r0 == 0) goto L_0x03ab
            r0 = 211(0xd3, float:2.96E-43)
            r7 = r43
            r1.M(r7, r0)     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            r34 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r34)     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            com.uptodown.workers.DownloadWorker$a r0 = f21359d     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            boolean r0 = r0.i()     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            if (r0 == 0) goto L_0x0384
            goto L_0x03ab
        L_0x0384:
            l2.T r0 = r1.x()     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            if (r0 != 0) goto L_0x036b
            z2.M r0 = z2.M.f26506a     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            android.content.Context r7 = r1.f21363a     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            r0.j(r7)     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            goto L_0x036b
        L_0x0392:
            r0 = move-exception
            r37 = r8
        L_0x0395:
            r14 = r28
            goto L_0x078e
        L_0x0399:
            r0 = move-exception
            r37 = r8
        L_0x039c:
            r14 = r28
            goto L_0x0794
        L_0x03a0:
            r0 = move-exception
            r37 = r8
        L_0x03a3:
            r14 = r28
            goto L_0x079a
        L_0x03a7:
            r0 = move-exception
            r34 = r9
            goto L_0x03c9
        L_0x03ab:
            kotlin.jvm.internal.t.b(r10)     // Catch:{ IOException -> 0x03a7, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            r34 = r9
            r7 = 0
            r9 = 8192(0x2000, float:1.14794E-41)
            int r0 = r10.read(r5, r7, r9)     // Catch:{ IOException -> 0x03c8, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392 }
            if (r0 > 0) goto L_0x03be
        L_0x03b9:
            r37 = r8
        L_0x03bb:
            r2 = 0
            goto L_0x05e8
        L_0x03be:
            r37 = r8
            r7 = r13
            r13 = r25
            r8 = 0
            r9 = 8192(0x2000, float:1.14794E-41)
            goto L_0x04a4
        L_0x03c8:
            r0 = move-exception
        L_0x03c9:
            long r35 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x05e3, IllegalStateException -> 0x03a0, IllegalArgumentException -> 0x0399, SecurityException -> 0x0392, MalformedURLException -> 0x05de, ProtocolException -> 0x05d9, SSLHandshakeException -> 0x05d4, IOException -> 0x05cf }
            long r35 = r35 - r46
            r37 = r8
            r7 = 1000(0x3e8, float:1.401E-42)
            long r8 = (long) r7
            long r35 = r35 / r8
            r7 = 3600(0xe10, double:1.7786E-320)
            int r7 = (r35 > r7 ? 1 : (r35 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x05c6
            r7 = 20000(0x4e20, double:9.8813E-320)
            java.lang.Thread.sleep(r7)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            com.uptodown.workers.DownloadWorker$a r7 = f21359d     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            boolean r7 = r7.i()     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            if (r7 == 0) goto L_0x03ea
            goto L_0x03bb
        L_0x03ea:
            z2.H r7 = z2.H.f26488a     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            boolean r8 = r7.d()     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            if (r8 == 0) goto L_0x05bd
            com.uptodown.activities.preferences.a$a r8 = com.uptodown.activities.preferences.a.f15150a     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            android.content.Context r9 = r1.f21363a     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            boolean r8 = r8.b0(r9)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            if (r8 == 0) goto L_0x0435
            boolean r7 = r7.f()     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            if (r7 != 0) goto L_0x0435
            int r7 = r43.l()     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            r8 = 1
            if (r7 != r8) goto L_0x040a
            goto L_0x0436
        L_0x040a:
            r1.m(r10, r12, r13)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            r2.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
        L_0x0413:
            r0 = move-exception
        L_0x0414:
            r14 = r28
            goto L_0x0772
        L_0x0418:
            r0 = move-exception
        L_0x0419:
            r14 = r28
            goto L_0x077c
        L_0x041d:
            r0 = move-exception
        L_0x041e:
            r14 = r28
            goto L_0x0782
        L_0x0422:
            r0 = move-exception
        L_0x0423:
            r14 = r28
            goto L_0x0788
        L_0x0427:
            r0 = move-exception
            goto L_0x0395
        L_0x042a:
            r0 = move-exception
            goto L_0x039c
        L_0x042d:
            r0 = move-exception
            goto L_0x03a3
        L_0x0430:
            r0 = move-exception
        L_0x0431:
            r14 = r28
            goto L_0x07a0
        L_0x0435:
            r8 = 1
        L_0x0436:
            java.net.URL r7 = r13.getURL()     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            kotlin.jvm.internal.t.d(r7, r2)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            javax.net.ssl.HttpsURLConnection r7 = r1.F(r7)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            long r8 = r41 + r28
            int r13 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r13 <= 0) goto L_0x047c
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r13.<init>()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r13.append(r11)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r13.append(r8)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r8 = 45
            r13.append(r8)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            java.lang.String r9 = r13.toString()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r13 = r25
            r7.setRequestProperty(r13, r9)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            goto L_0x0480
        L_0x0461:
            r0 = move-exception
        L_0x0462:
            r13 = r7
            goto L_0x0414
        L_0x0464:
            r0 = move-exception
        L_0x0465:
            r13 = r7
            goto L_0x0419
        L_0x0467:
            r0 = move-exception
        L_0x0468:
            r13 = r7
            goto L_0x041e
        L_0x046a:
            r0 = move-exception
        L_0x046b:
            r13 = r7
            goto L_0x0423
        L_0x046d:
            r0 = move-exception
        L_0x046e:
            r13 = r7
            goto L_0x0395
        L_0x0471:
            r0 = move-exception
        L_0x0472:
            r13 = r7
            goto L_0x039c
        L_0x0475:
            r0 = move-exception
        L_0x0476:
            r13 = r7
            goto L_0x03a3
        L_0x0479:
            r0 = move-exception
        L_0x047a:
            r13 = r7
            goto L_0x0431
        L_0x047c:
            r13 = r25
            r8 = 45
        L_0x0480:
            r7.connect()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            int r9 = r7.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r9 < r8) goto L_0x05b4
            r8 = 300(0x12c, float:4.2E-43)
            if (r9 >= r8) goto L_0x05b4
            java.io.InputStream r10 = r7.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            if (r10 == 0) goto L_0x05aa
            r4.d()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r8 = 0
            r9 = 8192(0x2000, float:1.14794E-41)
            int r0 = r10.read(r5, r8, r9)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            if (r0 > 0) goto L_0x04a4
        L_0x04a1:
            r2 = 0
            goto L_0x05e9
        L_0x04a4:
            com.uptodown.workers.DownloadWorker$a r20 = f21359d     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            boolean r20 = r20.i()     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            if (r20 == 0) goto L_0x04ad
            goto L_0x04a1
        L_0x04ad:
            r12.write(r5, r8, r0)     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            long r8 = (long) r0     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            long r28 = r28 + r8
            long r35 = r3.h()     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            long r8 = r35 + r8
            r3.p(r8)     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            long r8 = r28 + r41
            if (r27 != 0) goto L_0x0551
            long r35 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x054c, IllegalStateException -> 0x0547, IllegalArgumentException -> 0x0542, SecurityException -> 0x053d, MalformedURLException -> 0x0538, ProtocolException -> 0x0533, SSLHandshakeException -> 0x052e, IOException -> 0x0529 }
            r25 = r2
            r2 = 30000(0x7530, float:4.2039E-41)
            r39 = r10
            r38 = r11
            long r10 = (long) r2
            long r10 = r30 + r10
            int r2 = (r35 > r10 ? 1 : (r35 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0557
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            long r10 = r10 - r30
            r35 = r10
            r2 = 1000(0x3e8, float:1.401E-42)
            long r10 = (long) r2     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            long r10 = r35 / r10
            long r10 = r8 / r10
            r4.a(r10)     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r27 = 1
            goto L_0x0557
        L_0x04e9:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x0772
        L_0x04f1:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x077c
        L_0x04f9:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x0782
        L_0x0501:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x0788
        L_0x0509:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x078e
        L_0x0511:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x0794
        L_0x0519:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x079a
        L_0x0521:
            r0 = move-exception
            r13 = r7
            r14 = r28
            r10 = r39
            goto L_0x07a0
        L_0x0529:
            r0 = move-exception
            r39 = r10
            goto L_0x0462
        L_0x052e:
            r0 = move-exception
            r39 = r10
            goto L_0x0465
        L_0x0533:
            r0 = move-exception
            r39 = r10
            goto L_0x0468
        L_0x0538:
            r0 = move-exception
            r39 = r10
            goto L_0x046b
        L_0x053d:
            r0 = move-exception
            r39 = r10
            goto L_0x046e
        L_0x0542:
            r0 = move-exception
            r39 = r10
            goto L_0x0472
        L_0x0547:
            r0 = move-exception
            r39 = r10
            goto L_0x0476
        L_0x054c:
            r0 = move-exception
            r39 = r10
            goto L_0x047a
        L_0x0551:
            r25 = r2
            r39 = r10
            r38 = r11
        L_0x0557:
            double r10 = (double) r8     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r35 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r10 = r10 * r35
            r2 = r5
            double r4 = (double) r14     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            double r10 = r10 / r4
            int r4 = (int) r10     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            int r5 = r34 + 10
            if (r4 > r5) goto L_0x058c
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r35 = r10
            r5 = 1000(0x3e8, float:1.401E-42)
            long r10 = (long) r5     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            long r10 = r23 + r10
            int r5 = (r35 > r10 ? 1 : (r35 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0578
            int r5 = (r8 > r32 ? 1 : (r8 == r32 ? 0 : -1))
            if (r5 <= 0) goto L_0x0578
            goto L_0x058c
        L_0x0578:
            r4 = r48
            r5 = r2
            r2 = r25
            r9 = r34
            r8 = r37
            r11 = r38
            r10 = r39
            r25 = r13
        L_0x0587:
            r13 = r7
            r7 = r27
            goto L_0x035f
        L_0x058c:
            long r23 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r3.p(r8)     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r6.E1(r3)     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r1.D(r4)     // Catch:{ SocketTimeoutException -> 0x0521, IllegalStateException -> 0x0519, IllegalArgumentException -> 0x0511, SecurityException -> 0x0509, MalformedURLException -> 0x0501, ProtocolException -> 0x04f9, SSLHandshakeException -> 0x04f1, IOException -> 0x04e9 }
            r5 = r2
            r32 = r8
            r2 = r25
            r8 = r37
            r11 = r38
            r10 = r39
            r9 = r4
            r25 = r13
            r4 = r48
            goto L_0x0587
        L_0x05aa:
            r2 = 0
            r1.m(r2, r12, r7)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r2.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
        L_0x05b4:
            r1.m(r10, r12, r7)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r2.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
        L_0x05bd:
            r1.m(r10, r12, r13)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            r2.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
        L_0x05c6:
            r1.m(r10, r12, r13)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            r2.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0430, IllegalStateException -> 0x042d, IllegalArgumentException -> 0x042a, SecurityException -> 0x0427, MalformedURLException -> 0x0422, ProtocolException -> 0x041d, SSLHandshakeException -> 0x0418, IOException -> 0x0413 }
        L_0x05cf:
            r0 = move-exception
            r37 = r8
            goto L_0x0414
        L_0x05d4:
            r0 = move-exception
            r37 = r8
            goto L_0x0419
        L_0x05d9:
            r0 = move-exception
            r37 = r8
            goto L_0x041e
        L_0x05de:
            r0 = move-exception
            r37 = r8
            goto L_0x0423
        L_0x05e3:
            r0 = move-exception
            r37 = r8
            goto L_0x0431
        L_0x05e8:
            r7 = r13
        L_0x05e9:
            r1.m(r10, r12, r7)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            com.uptodown.workers.DownloadWorker$a r0 = f21359d     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            boolean r0 = r0.i()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            if (r0 != 0) goto L_0x0606
            long r4 = r41 + r28
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0600
            r3.p(r14)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r6.E1(r3)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
        L_0x0600:
            r0 = 100
            r1.D(r0)     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            goto L_0x0609
        L_0x0606:
            r48.b()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
        L_0x0609:
            r6.m()     // Catch:{ SocketTimeoutException -> 0x0479, IllegalStateException -> 0x0475, IllegalArgumentException -> 0x0471, SecurityException -> 0x046d, MalformedURLException -> 0x046a, ProtocolException -> 0x0467, SSLHandshakeException -> 0x0464, IOException -> 0x0461 }
            r4 = r2
            goto L_0x07a6
        L_0x060f:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x0414
        L_0x0616:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x0419
        L_0x061d:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x041e
        L_0x0624:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x0423
        L_0x062b:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x0395
        L_0x0632:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x039c
        L_0x0639:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x03a3
        L_0x0640:
            r0 = move-exception
            r37 = r8
            r10 = r27
            goto L_0x0431
        L_0x0647:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x064b:
            r10 = r2
        L_0x064c:
            r14 = r18
            goto L_0x0772
        L_0x0650:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x0654:
            r10 = r2
        L_0x0655:
            r14 = r18
            goto L_0x077c
        L_0x0659:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x065d:
            r10 = r2
        L_0x065e:
            r14 = r18
            goto L_0x0782
        L_0x0662:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x0666:
            r10 = r2
        L_0x0667:
            r14 = r18
            goto L_0x0788
        L_0x066b:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x066f:
            r10 = r2
        L_0x0670:
            r14 = r18
            goto L_0x078e
        L_0x0674:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x0678:
            r10 = r2
        L_0x0679:
            r14 = r18
            goto L_0x0794
        L_0x067d:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x0681:
            r10 = r2
        L_0x0682:
            r14 = r18
            goto L_0x079a
        L_0x0686:
            r0 = move-exception
            r37 = r8
            r2 = 0
        L_0x068a:
            r10 = r2
        L_0x068b:
            r14 = r18
            goto L_0x07a0
        L_0x068f:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x064b
        L_0x0696:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x0654
        L_0x069d:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x065d
        L_0x06a4:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x0666
        L_0x06ab:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x066f
        L_0x06b2:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x0678
        L_0x06b9:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x0681
        L_0x06c0:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            goto L_0x068a
        L_0x06c7:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x064c
        L_0x06d1:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0655
        L_0x06db:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x065e
        L_0x06e5:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0667
        L_0x06ef:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0670
        L_0x06f9:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0679
        L_0x0703:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0682
        L_0x070d:
            r0 = move-exception
            r37 = r8
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x068b
        L_0x0717:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0772
        L_0x0723:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x077c
        L_0x072f:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0782
        L_0x073b:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0788
        L_0x0746:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x078e
        L_0x0751:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x0794
        L_0x075c:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x079a
        L_0x0767:
            r0 = move-exception
            r37 = r8
            r18 = r14
            r2 = 0
            r13 = r41
            r10 = r2
            r12 = r10
            goto L_0x07a0
        L_0x0772:
            r0.printStackTrace()
            java.lang.String r0 = "IOException"
        L_0x0777:
            r4 = r0
            r7 = r13
            r28 = r14
            goto L_0x07a6
        L_0x077c:
            r0.printStackTrace()
            java.lang.String r0 = "SSLHandshakeException"
            goto L_0x0777
        L_0x0782:
            r0.printStackTrace()
            java.lang.String r0 = "ProtocolException"
            goto L_0x0777
        L_0x0788:
            r0.printStackTrace()
            java.lang.String r0 = "MalformedURLException"
            goto L_0x0777
        L_0x078e:
            r0.printStackTrace()
            java.lang.String r0 = "SecurityException"
            goto L_0x0777
        L_0x0794:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalArgumentException"
            goto L_0x0777
        L_0x079a:
            r0.printStackTrace()
            java.lang.String r0 = "IllegalStateException"
            goto L_0x0777
        L_0x07a0:
            r0.printStackTrace()
            java.lang.String r0 = "SocketTimeoutException"
            goto L_0x0777
        L_0x07a6:
            if (r4 == 0) goto L_0x07c4
            r1.m(r10, r12, r7)
            java.net.URL r0 = r7.getURL()
            java.lang.String r8 = r0.toString()
            r2 = r37
            kotlin.jvm.internal.t.d(r8, r2)
            r2 = r43
            r5 = r45
            r6 = r46
            r1.I(r2, r3, r4, r5, r6, r8)
            r14 = r16
            goto L_0x07c6
        L_0x07c4:
            r14 = r28
        L_0x07c6:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.p(javax.net.ssl.HttpsURLConnection, java.io.File, l2.q, l2.r, java.lang.String, long, com.uptodown.workers.DownloadWorker$b):long");
    }

    public final long r(HttpsURLConnection httpsURLConnection) {
        t.e(httpsURLConnection, "urlConnection");
        if (Build.VERSION.SDK_INT >= 24) {
            return httpsURLConnection.getContentLengthLong();
        }
        return (long) httpsURLConnection.getContentLength();
    }

    public final Context s() {
        return this.f21363a;
    }

    public final String t(String str) {
        t.e(str, "url");
        String str2 = str;
        String str3 = str2;
        if (s.l0(str2, ".", 0, false, 6, (Object) null) == -1) {
            return "apk";
        }
        String substring = str3.substring(s.l0(str3, ".", 0, false, 6, (Object) null) + 1);
        t.d(substring, "substring(...)");
        if (substring.length() == 0) {
            return "apk";
        }
        return substring;
    }

    public final String u(String str) {
        t.e(str, "url");
        String str2 = str;
        String substring = str2.substring(s.l0(str2, "/", 0, false, 6, (Object) null) + 1);
        t.d(substring, "substring(...)");
        return substring;
    }

    public final F v() {
        return this.f21364b;
    }

    public final String w() {
        return this.f21365c;
    }

    public T x() {
        return null;
    }

    public final void y() {
        f21361f = false;
        f21362g = false;
        Context a5 = k.f32g.a(this.f21363a);
        this.f21363a = a5;
        this.f21364b = new F(a5);
    }

    public final void z(Bundle bundle, String str, r rVar) {
        t.e(bundle, "bundle");
        this.f21365c = str;
        Bundle j5 = j(bundle, rVar);
        F f5 = this.f21364b;
        if (f5 != null) {
            f5.d("download", j5);
        }
    }
}
