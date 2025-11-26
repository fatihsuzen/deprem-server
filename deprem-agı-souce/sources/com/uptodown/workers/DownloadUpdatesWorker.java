package com.uptodown.workers;

import S1.k;
import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b2.C2286f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.t;
import l2.C2653b;
import l2.C2655d;
import l2.C2668q;
import l2.T;
import l2.r;
import t3.s;
import z2.C2940B;
import z2.C2942a;
import z2.E;
import z2.H;
import z2.M;
import z2.P;

public final class DownloadUpdatesWorker extends DownloadWorker {

    /* renamed from: i  reason: collision with root package name */
    public static final a f21352i = new a((C2633k) null);

    /* renamed from: j  reason: collision with root package name */
    private static T f21353j;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f21354h;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements DownloadWorker.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ K f21355a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ K f21356b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DownloadUpdatesWorker f21357c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ r f21358d;

        b(K k5, K k6, DownloadUpdatesWorker downloadUpdatesWorker, r rVar) {
            this.f21355a = k5;
            this.f21356b = k6;
            this.f21357c = downloadUpdatesWorker;
            this.f21358d = rVar;
        }

        public void a(long j5) {
            this.f21355a.f24689a = j5;
        }

        public void b() {
        }

        public void c(long j5) {
            this.f21356b.f24689a = j5;
        }

        public void d() {
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
            DownloadUpdatesWorker downloadUpdatesWorker = this.f21357c;
            downloadUpdatesWorker.z(bundle, downloadUpdatesWorker.w(), this.f21358d);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "c");
        t.e(workerParameters, "params");
        this.f21354h = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        y();
    }

    private final void P(String str, T t5, r rVar) {
        long j5;
        r rVar2;
        File file;
        long j6;
        String str2 = str;
        r rVar3 = rVar;
        O((String) null);
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        aVar.o();
        if (rVar3.h() == rVar3.i() && rVar3.a() != null) {
            if (!s.F(C2286f.f20690a.e(rVar3.a()), rVar3.e(), false, 2, (Object) null)) {
                String a5 = rVar3.a();
                t.b(a5);
                new File(a5).delete();
                rVar3.p(0);
                C2940B a6 = C2940B.f26458v.a(s());
                a6.a();
                a6.E1(rVar3);
                a6.m();
            } else {
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        z(bundle, new URL(str2).getHost(), rVar3);
        HttpsURLConnection K4 = K(str2, currentTimeMillis, rVar3);
        if (K4 != null) {
            O(K4.getURL().getHost());
            E e5 = new E();
            Context applicationContext = getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            File i5 = e5.i(applicationContext);
            if (i5.exists() || i5.mkdirs()) {
                String a7 = rVar.a();
                if (a7 == null || a7.length() == 0) {
                    String url = K4.getURL().toString();
                    t.d(url, "toString(...)");
                    String str3 = t5.h() + '_' + rVar.d() + '.' + t(url);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i5.getAbsolutePath());
                    sb.append('/');
                    j5 = 0;
                    sb.append(t5.h());
                    sb.append(t5.j());
                    File file2 = new File(sb.toString());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(file2.getAbsolutePath() + '/' + str3);
                    rVar2 = rVar;
                    rVar2.k(file.getAbsolutePath());
                    C2940B a8 = C2940B.f26458v.a(s());
                    a8.a();
                    a8.E1(rVar2);
                    a8.m();
                } else {
                    String a9 = rVar.a();
                    t.b(a9);
                    file = new File(a9);
                    j5 = 0;
                    rVar2 = rVar;
                }
                if (file.exists()) {
                    j6 = file.length();
                } else {
                    j6 = j5;
                }
                if (E(K4, currentTimeMillis)) {
                    C2668q f5 = aVar.f();
                    t.b(f5);
                    long z4 = f5.z();
                    HttpsURLConnection httpsURLConnection = K4;
                    File file3 = file;
                    long j7 = z4 - j6;
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    long j8 = currentTimeMillis;
                    if (new C2942a().a(new E().m(s(), i5), j7)) {
                        K k5 = new K();
                        K k6 = new K();
                        b bVar = new b(k5, k6, this, rVar2);
                        C2668q f6 = aVar.f();
                        t.b(f6);
                        String w4 = w();
                        t.b(w4);
                        r rVar4 = rVar;
                        File file4 = file3;
                        long j9 = j8;
                        K k7 = k6;
                        long p5 = p(httpsURLConnection2, file4, f6, rVar4, w4, j9, bVar);
                        r rVar5 = rVar4;
                        long j10 = j9;
                        if (p5 >= j5) {
                            if (aVar.i()) {
                                n(j10, rVar5);
                                return;
                            }
                            r rVar6 = rVar5;
                            long j11 = p5;
                            Bundle l5 = l(j6, j11, file4, rVar6);
                            if (l5 != null) {
                                C2668q f7 = aVar.f();
                                if (f7 != null) {
                                    f7.U(s());
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("packagename", t5.h());
                                P.f26510a.f().send(102, bundle2);
                                l5.putString("url", str2);
                                C2668q f8 = aVar.f();
                                t.b(f8);
                                Bundle bundle3 = l5;
                                C(t5, f8, rVar, bundle3, w(), j10);
                                return;
                            }
                            A(k5.f24689a, j10, k7.f24689a, j11, rVar);
                            if (k.f32g.g() == null) {
                                C2653b bVar2 = new C2653b();
                                C2940B.a aVar2 = C2940B.f26458v;
                                Context applicationContext2 = getApplicationContext();
                                t.d(applicationContext2, "getApplicationContext(...)");
                                C2940B a10 = aVar2.a(applicationContext2);
                                a10.a();
                                C2655d Y4 = a10.Y(t5.h());
                                if (Y4 != null) {
                                    bVar2.j(Y4, t5, a10);
                                }
                                a10.m();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    T t6 = t5;
                    long j12 = j8;
                    httpsURLConnection2.disconnect();
                    C2668q f9 = aVar.f();
                    if (f9 != null) {
                        f9.U(s());
                    }
                    E e6 = new E();
                    Context applicationContext3 = getApplicationContext();
                    t.d(applicationContext3, "getApplicationContext(...)");
                    e6.c(applicationContext3);
                    P.f26510a.f().send(104, (Bundle) null);
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "no_enough_space");
                    C2668q f10 = aVar.f();
                    t.b(f10);
                    C(t6, f10, rVar, bundle4, w(), j12);
                    return;
                }
                return;
            }
            Bundle bundle5 = new Bundle();
            bundle5.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "cant_mkdir");
            C2668q f11 = aVar.f();
            t.b(f11);
            C(t5, f11, rVar3, bundle5, w(), currentTimeMillis);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void Q() {
        /*
            r18 = this;
            r1 = r18
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f13477F
            l2.d r0 = r0.s()
            z2.E r2 = new z2.E
            r2.<init>()
            android.content.Context r3 = r1.s()
            java.io.File r2 = r2.i(r3)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x001e
            r2.mkdirs()
        L_0x001e:
            if (r0 == 0) goto L_0x0336
            z2.H r3 = z2.H.f26488a
            boolean r3 = r3.d()
            if (r3 == 0) goto L_0x0336
            com.uptodown.UptodownApp$a r3 = com.uptodown.UptodownApp.f13477F
            java.lang.String r4 = "downloadApkWorker"
            android.content.Context r5 = r1.s()
            boolean r3 = r3.T(r4, r5)
            if (r3 == 0) goto L_0x0038
            goto L_0x0336
        L_0x0038:
            z2.B$a r3 = z2.C2940B.f26458v
            android.content.Context r4 = r1.s()
            z2.B r3 = r3.a(r4)
            r3.a()
            java.lang.String r4 = r0.o()
            kotlin.jvm.internal.t.b(r4)
            l2.T r4 = r3.G0(r4)
            f21353j = r4
            r3.m()
            com.uptodown.workers.DownloadWorker$a r3 = com.uptodown.workers.DownloadWorker.f21359d
            l2.T r4 = f21353j
            r5 = 0
            if (r4 == 0) goto L_0x0061
            l2.q r4 = r4.a()
            goto L_0x0062
        L_0x0061:
            r4 = r5
        L_0x0062:
            r3.q(r4)
            l2.q r4 = r3.f()
            if (r4 == 0) goto L_0x032e
            l2.q r4 = r3.f()
            kotlin.jvm.internal.t.b(r4)
            java.util.ArrayList r4 = r4.o()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x032e
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            l2.q r6 = r3.f()
            kotlin.jvm.internal.t.b(r6)
            java.lang.String r6 = r6.w()
            java.lang.String r7 = "packagename"
            r4.putString(r7, r6)
            z2.P r6 = z2.P.f26510a
            m2.f r6 = r6.f()
            r8 = 109(0x6d, float:1.53E-43)
            r6.send(r8, r4)
            l2.q r3 = r3.f()
            kotlin.jvm.internal.t.b(r3)
            java.util.ArrayList r3 = r3.o()
            java.util.Iterator r3 = r3.iterator()
            java.lang.String r4 = "iterator(...)"
            kotlin.jvm.internal.t.d(r3, r4)
        L_0x00b0:
            boolean r4 = r3.hasNext()
            r6 = 0
            r8 = 1
            if (r4 == 0) goto L_0x024a
            java.lang.Object r4 = r3.next()
            java.lang.String r9 = "next(...)"
            kotlin.jvm.internal.t.d(r4, r9)
            l2.r r4 = (l2.r) r4
            com.uptodown.workers.DownloadWorker$a r9 = com.uptodown.workers.DownloadWorker.f21359d
            boolean r10 = r9.i()
            if (r10 != 0) goto L_0x00b0
            z2.a r10 = new z2.a
            r10.<init>()
            z2.E r11 = new z2.E
            r11.<init>()
            android.content.Context r12 = r1.s()
            long r11 = r11.m(r12, r2)
            l2.q r13 = r9.f()
            kotlin.jvm.internal.t.b(r13)
            long r13 = r13.z()
            boolean r10 = r10.a(r11, r13)
            if (r10 != 0) goto L_0x00fb
            z2.P r0 = z2.P.f26510a
            m2.f r0 = r0.f()
            r3 = 104(0x68, float:1.46E-43)
            r0.send(r3, r5)
            goto L_0x024a
        L_0x00fb:
            z2.Z r10 = new z2.Z
            android.content.Context r11 = r1.s()
            r10.<init>(r11)
            l2.p r11 = new l2.p
            r11.<init>()
            android.content.Context r12 = r1.s()
            r11.j(r12)
            long r11 = r4.d()
            r13 = 0
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            r12 = 102(0x66, float:1.43E-43)
            if (r11 < 0) goto L_0x0233
            com.uptodown.UptodownApp$a r11 = com.uptodown.UptodownApp.f13477F
            l2.T r15 = f21353j
            kotlin.jvm.internal.t.b(r15)
            r11.v0(r15)
            java.lang.String r15 = r4.a()
            if (r15 == 0) goto L_0x0145
            java.io.File r15 = new java.io.File
            r16 = r13
            java.lang.String r13 = r4.a()
            kotlin.jvm.internal.t.b(r13)
            r15.<init>(r13)
            boolean r13 = r15.exists()
            if (r13 == 0) goto L_0x0147
            long r13 = r15.length()
            goto L_0x0149
        L_0x0145:
            r16 = r13
        L_0x0147:
            r13 = r16
        L_0x0149:
            int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r13 <= 0) goto L_0x0162
            long r13 = r4.d()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            long r14 = r0.b()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            l2.M r10 = r10.s0(r13, r8, r14)
            goto L_0x0176
        L_0x0162:
            long r13 = r4.d()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            long r14 = r0.b()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            l2.M r10 = r10.r0(r13, r8, r14)
        L_0x0176:
            boolean r13 = r10.b()
            if (r13 != 0) goto L_0x0214
            java.lang.String r13 = r10.d()
            if (r13 == 0) goto L_0x0214
            int r13 = r13.length()
            if (r13 != 0) goto L_0x018a
            goto L_0x0214
        L_0x018a:
            org.json.JSONObject r13 = new org.json.JSONObject
            java.lang.String r10 = r10.d()
            kotlin.jvm.internal.t.b(r10)
            r13.<init>(r10)
            java.lang.String r10 = "success"
            boolean r14 = r13.isNull(r10)
            if (r14 != 0) goto L_0x01a2
            int r6 = r13.optInt(r10)
        L_0x01a2:
            if (r6 == r8) goto L_0x01bf
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            l2.T r6 = f21353j
            kotlin.jvm.internal.t.b(r6)
            java.lang.String r6 = r6.h()
            r4.putString(r7, r6)
            z2.P r6 = z2.P.f26510a
            m2.f r6 = r6.f()
            r6.send(r12, r4)
            goto L_0x0229
        L_0x01bf:
            java.lang.String r6 = "data"
            org.json.JSONObject r6 = r13.optJSONObject(r6)
            if (r6 == 0) goto L_0x0229
            java.lang.String r10 = "sha256"
            boolean r12 = r6.isNull(r10)
            if (r12 != 0) goto L_0x01d6
            java.lang.String r10 = r6.optString(r10)
            r4.n(r10)
        L_0x01d6:
            java.lang.String r10 = "downloadURL"
            boolean r12 = r6.isNull(r10)
            if (r12 != 0) goto L_0x0229
            java.lang.String r6 = r6.optString(r10)
            com.uptodown.activities.preferences.a$a r10 = com.uptodown.activities.preferences.a.f15150a
            android.content.Context r12 = r1.s()
            boolean r10 = r10.b0(r12)
            if (r10 == 0) goto L_0x01fa
            boolean r10 = r1.f21354h
            if (r10 != 0) goto L_0x01fa
            z2.H r10 = z2.H.f26488a
            boolean r10 = r10.f()
            if (r10 == 0) goto L_0x0229
        L_0x01fa:
            boolean r10 = r1.f21354h
            if (r10 == 0) goto L_0x0208
            l2.q r9 = r9.f()
            kotlin.jvm.internal.t.b(r9)
            r9.Z(r8)
        L_0x0208:
            kotlin.jvm.internal.t.b(r6)
            l2.T r8 = f21353j
            kotlin.jvm.internal.t.b(r8)
            r1.P(r6, r8, r4)
            goto L_0x0229
        L_0x0214:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r6 = r0.o()
            r4.putString(r7, r6)
            z2.P r6 = z2.P.f26510a
            m2.f r6 = r6.f()
            r6.send(r12, r4)
        L_0x0229:
            l2.T r4 = f21353j
            kotlin.jvm.internal.t.b(r4)
            r11.c0(r4)
            goto L_0x00b0
        L_0x0233:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r6 = r0.o()
            r4.putString(r7, r6)
            z2.P r6 = z2.P.f26510a
            m2.f r6 = r6.f()
            r6.send(r12, r4)
            goto L_0x00b0
        L_0x024a:
            com.uptodown.workers.DownloadWorker$a r0 = com.uptodown.workers.DownloadWorker.f21359d
            r0.p(r6)
            l2.q r3 = r0.f()
            kotlin.jvm.internal.t.b(r3)
            long r3 = r3.y()
            l2.q r6 = r0.f()
            kotlin.jvm.internal.t.b(r6)
            long r9 = r6.z()
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x028d
            l2.q r3 = r0.f()
            kotlin.jvm.internal.t.b(r3)
            r3.X()
            z2.B$a r3 = z2.C2940B.f26458v
            android.content.Context r4 = r1.s()
            z2.B r3 = r3.a(r4)
            r3.a()
            l2.q r4 = r0.f()
            kotlin.jvm.internal.t.b(r4)
            r3.D1(r4)
            r3.m()
        L_0x028d:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            l2.q r4 = r0.f()
            kotlin.jvm.internal.t.b(r4)
            java.lang.String r4 = r4.w()
            r3.putString(r7, r4)
            z2.P r4 = z2.P.f26510a
            m2.f r4 = r4.f()
            r6 = 108(0x6c, float:1.51E-43)
            r4.send(r6, r3)
            l2.q r3 = r0.f()
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.w()
            android.content.Context r4 = r1.s()
            java.lang.String r4 = r4.getPackageName()
            boolean r3 = t3.s.E(r3, r4, r8)
            if (r3 == 0) goto L_0x0325
            S1.k$a r3 = S1.k.f32g
            android.app.Activity r3 = r3.g()
            l2.q r4 = r0.f()
            kotlin.jvm.internal.t.b(r4)
            java.io.File r4 = r4.n()
            if (r4 == 0) goto L_0x032e
            boolean r6 = r4.exists()
            if (r6 == 0) goto L_0x032e
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 31
            if (r6 < r7) goto L_0x0309
            if (r3 != 0) goto L_0x0309
            com.uptodown.UptodownApp$a r3 = com.uptodown.UptodownApp.f13477F
            android.content.Context r6 = r1.s()
            r3.U(r4, r6, r5)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = "type"
            java.lang.String r5 = "start"
            r3.putString(r4, r5)
            z2.F r4 = r1.v()
            if (r4 == 0) goto L_0x0305
            java.lang.String r5 = "install"
            r4.d(r5, r3)
        L_0x0305:
            r0.b()
            goto L_0x032e
        L_0x0309:
            z2.M r0 = z2.M.f26506a     // Catch:{ Exception -> 0x0320 }
            android.content.Context r3 = r1.s()     // Catch:{ Exception -> 0x0320 }
            z2.v r5 = new z2.v     // Catch:{ Exception -> 0x0320 }
            r5.<init>()     // Catch:{ Exception -> 0x0320 }
            android.content.Context r6 = r1.s()     // Catch:{ Exception -> 0x0320 }
            android.net.Uri r4 = r5.w(r4, r6)     // Catch:{ Exception -> 0x0320 }
            r0.C(r3, r4)     // Catch:{ Exception -> 0x0320 }
            goto L_0x032e
        L_0x0320:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x032e
        L_0x0325:
            com.uptodown.workers.InstallUpdatesWorker$a r0 = com.uptodown.workers.InstallUpdatesWorker.f21380b
            android.content.Context r3 = r1.s()
            r0.a(r3)
        L_0x032e:
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f13477F
            l2.d r0 = r0.s()
            goto L_0x001e
        L_0x0336:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadUpdatesWorker.Q():void");
    }

    public void C(T t5, C2668q qVar, r rVar, Bundle bundle, String str, long j5) {
        t.e(t5, "update");
        t.e(qVar, "download");
        t.e(rVar, "df");
        t.e(bundle, "bundleParamsFail");
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
        if (j5 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j5) / ((long) 1000));
        }
        z(bundle, str, rVar);
    }

    public void L(C2668q qVar) {
        t.e(qVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("update", f21353j);
        bundle.putParcelable("download", qVar);
        P.f26510a.f().send(102, bundle);
    }

    public void M(C2668q qVar, int i5) {
        t.e(qVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("update", f21353j);
        bundle.putParcelable("download", qVar);
        bundle.putString("packagename", qVar.w());
        P.f26510a.f().send(i5, bundle);
    }

    public ListenableWorker.Result doWork() {
        P p5 = P.f26510a;
        p5.f().send(107, (Bundle) null);
        H h5 = H.f26488a;
        if (h5.d()) {
            E e5 = new E();
            Context applicationContext = getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            e5.c(applicationContext);
            ArrayList E4 = UptodownApp.f13477F.E();
            if (E4 != null && E4.size() > 0) {
                if (!com.uptodown.activities.preferences.a.f15150a.b0(s())) {
                    Q();
                } else if (h5.f() || this.f21354h) {
                    Q();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("apps_parcelable", E4);
                    p5.f().send(105, bundle);
                }
            }
        } else {
            p5.f().send(110, (Bundle) null);
        }
        InstallUpdatesWorker.f21380b.a(s());
        p5.f().send(103, (Bundle) null);
        M.f26506a.G(s());
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }

    public T x() {
        return f21353j;
    }
}
