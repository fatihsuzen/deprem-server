package com.uptodown.workers;

import U1.C2201a;
import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import b2.C2286f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.t;
import l2.C2650J;
import l2.C2668q;
import l2.C2669s;
import l2.r;
import t3.s;
import z2.C2940B;
import z2.C2942a;
import z2.C2962v;
import z2.E;
import z2.F;
import z2.H;
import z2.M;
import z2.P;
import z2.X;

public final class DownloadApkWorker extends DownloadWorker {

    /* renamed from: i  reason: collision with root package name */
    public static final a f21342i = new a((C2633k) null);

    /* renamed from: h  reason: collision with root package name */
    private String f21343h;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(Context context, String str, int i5) {
            t.e(context, "context");
            t.e(str, "url");
            if (!UptodownApp.f13477F.T("downloadApkWorker", context)) {
                Data.Builder putInt = new Data.Builder().putString("url", str).putInt("downloadId", i5);
                WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DownloadApkWorker.class).addTag("downloadApkWorker")).setInputData(putInt.build())).build());
            }
        }

        public final boolean b(Context context, int i5) {
            t.e(context, "context");
            if (UptodownApp.f13477F.T("downloadApkWorker", context)) {
                return false;
            }
            Data.Builder putInt = new Data.Builder().putInt("downloadId", i5);
            WorkManager.Companion.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DownloadApkWorker.class).addTag("downloadApkWorker")).setInputData(putInt.build())).build());
            return true;
        }

        private a() {
        }
    }

    public static final class b implements DownloadWorker.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ K f21344a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ K f21345b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DownloadApkWorker f21346c;

        b(K k5, K k6, DownloadApkWorker downloadApkWorker) {
            this.f21344a = k5;
            this.f21345b = k6;
            this.f21346c = downloadApkWorker;
        }

        public void a(long j5) {
            this.f21344a.f24689a = j5;
        }

        public void b() {
        }

        public void c(long j5) {
            this.f21345b.f24689a = j5;
        }

        public void d() {
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
            DownloadApkWorker downloadApkWorker = this.f21346c;
            String w4 = downloadApkWorker.w();
            C2668q f5 = DownloadWorker.f21359d.f();
            t.b(f5);
            downloadApkWorker.z(bundle, w4, (r) f5.o().get(0));
        }
    }

    public static final class c implements DownloadWorker.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ K f21347a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ K f21348b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DownloadApkWorker f21349c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2668q f21350d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f21351e;

        c(K k5, K k6, DownloadApkWorker downloadApkWorker, C2668q qVar, int i5) {
            this.f21347a = k5;
            this.f21348b = k6;
            this.f21349c = downloadApkWorker;
            this.f21350d = qVar;
            this.f21351e = i5;
        }

        public void a(long j5) {
            this.f21347a.f24689a = j5;
        }

        public void b() {
        }

        public void c(long j5) {
            this.f21348b.f24689a = j5;
        }

        public void d() {
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
            DownloadApkWorker downloadApkWorker = this.f21349c;
            downloadApkWorker.z(bundle, downloadApkWorker.w(), (r) this.f21350d.o().get(this.f21351e));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadApkWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "c");
        t.e(workerParameters, "params");
        y();
        int i5 = workerParameters.getInputData().getInt("downloadId", -1);
        if (i5 >= 0) {
            C2940B a5 = C2940B.f26458v.a(s());
            a5.a();
            DownloadWorker.f21359d.q(a5.s1(i5));
            a5.m();
        }
        this.f21343h = workerParameters.getInputData().getString("url");
    }

    private final void G(C2668q qVar, String str) {
        if (qVar != null) {
            qVar.J(s());
            L(qVar);
        }
        M.f26506a.z(s(), qVar, str);
    }

    private final void P() {
        C2668q qVar;
        if (!H.f26488a.d()) {
            P.f26510a.e().send(209, (Bundle) null);
            return;
        }
        ArrayList l5 = new C2962v().l(s());
        boolean b02 = com.uptodown.activities.preferences.a.f15150a.b0(s());
        Iterator it = l5.iterator();
        t.d(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                qVar = null;
                break;
            }
            Object next = it.next();
            t.d(next, "next(...)");
            qVar = (C2668q) next;
            if (b02) {
                if (!H.f26488a.f()) {
                    if (qVar.l() == 1) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        aVar.q((C2668q) null);
        if (qVar != null) {
            aVar.p(false);
            aVar.r(false);
            aVar.o();
            aVar.q(qVar);
            C2668q f5 = aVar.f();
            t.b(f5);
            R(f5);
        }
    }

    private final void Q(String str) {
        String str2 = str;
        O((String) null);
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        aVar.o();
        if (!H.f26488a.d()) {
            P.f26510a.e().send(209, (Bundle) null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        z(bundle, new URL(str2).getHost(), (r) null);
        HttpsURLConnection K4 = K(str2, currentTimeMillis, (r) null);
        if (K4 != null) {
            O(K4.getURL().getHost());
            String url = K4.getURL().toString();
            t.d(url, "toString(...)");
            String u5 = u(url);
            if (s.f0(u5, ".", 0, false, 6, (Object) null) < 0) {
                String url2 = K4.getURL().toString();
                t.d(url2, "toString(...)");
                u5 = u5 + t(url2);
            }
            if (u5.length() > 0 && aVar.f() != null) {
                C2668q f5 = aVar.f();
                t.b(f5);
                if (f5.o().isEmpty()) {
                    File file = new File(new E().h(s()), u5);
                    r rVar = new r();
                    rVar.k(file.getAbsolutePath());
                    rVar.q(r(K4));
                    C2940B a5 = C2940B.f26458v.a(s());
                    a5.a();
                    C2668q f6 = aVar.f();
                    t.b(f6);
                    a5.R0(rVar, (long) f6.q());
                    a5.m();
                    C2668q f7 = aVar.f();
                    t.b(f7);
                    f7.o().add(rVar);
                } else {
                    C2668q f8 = aVar.f();
                    t.b(f8);
                    if (((r) f8.o().get(0)).a() == null) {
                        File file2 = new File(new E().h(s()), u5);
                        C2668q f9 = aVar.f();
                        t.b(f9);
                        ((r) f9.o().get(0)).k(file2.getAbsolutePath());
                        C2940B a6 = C2940B.f26458v.a(s());
                        a6.a();
                        C2668q f10 = aVar.f();
                        t.b(f10);
                        Object obj = f10.o().get(0);
                        t.d(obj, "get(...)");
                        a6.E1((r) obj);
                        a6.m();
                    }
                }
            }
            File h5 = new E().h(s());
            if (h5.exists() || h5.mkdirs()) {
                C2668q f11 = aVar.f();
                t.b(f11);
                String a7 = ((r) f11.o().get(0)).a();
                t.b(a7);
                File file3 = new File(a7);
                if (aVar.i()) {
                    C2668q f12 = aVar.f();
                    t.b(f12);
                    n(currentTimeMillis, (r) f12.o().get(0));
                } else if (E(K4, currentTimeMillis)) {
                    C2668q f13 = aVar.f();
                    t.b(f13);
                    long i5 = ((r) f13.o().get(0)).i() - file3.length();
                    if (i5 >= 0) {
                        HttpsURLConnection httpsURLConnection = K4;
                        if (new C2942a().a(new E().m(s(), h5), i5)) {
                            C2668q f14 = aVar.f();
                            t.b(f14);
                            M(f14, 200);
                            C2668q f15 = aVar.f();
                            t.b(f15);
                            if (f15.h() > 0) {
                                C2940B a8 = C2940B.f26458v.a(s());
                                a8.a();
                                C2668q f16 = aVar.f();
                                t.b(f16);
                                C2669s o02 = a8.o0(f16.h());
                                if (o02 != null) {
                                    o02.d(s(), "downloadStarted");
                                }
                                a8.m();
                            }
                            K k5 = new K();
                            K k6 = new K();
                            b bVar = new b(k5, k6, this);
                            File file4 = file3;
                            long j5 = currentTimeMillis;
                            C2668q f17 = aVar.f();
                            t.b(f17);
                            C2668q f18 = aVar.f();
                            t.b(f18);
                            Object obj2 = f18.o().get(0);
                            t.d(obj2, "get(...)");
                            String w4 = w();
                            t.b(w4);
                            long p5 = p(httpsURLConnection, file4, f17, (r) obj2, w4, j5, bVar);
                            File file5 = file4;
                            if (p5 >= 0) {
                                if (aVar.i()) {
                                    C2668q f19 = aVar.f();
                                    t.b(f19);
                                    n(j5, (r) f19.o().get(0));
                                    return;
                                }
                                if (aVar.f() != null) {
                                    C2668q f20 = aVar.f();
                                    t.b(f20);
                                    f20.X();
                                    C2940B a9 = C2940B.f26458v.a(s());
                                    a9.a();
                                    C2668q f21 = aVar.f();
                                    t.b(f21);
                                    a9.D1(f21);
                                    a9.m();
                                }
                                if (aVar.f() != null) {
                                    C2668q f22 = aVar.f();
                                    t.b(f22);
                                    if (f22.h() > 0) {
                                        C2940B a10 = C2940B.f26458v.a(s());
                                        a10.a();
                                        C2668q f23 = aVar.f();
                                        t.b(f23);
                                        C2669s o03 = a10.o0(f23.h());
                                        if (o03 != null) {
                                            o03.d(s(), "downloadFinished");
                                        }
                                        a10.m();
                                    }
                                }
                                DownloadWorker.B(this, k5.f24689a, j5, k6.f24689a, p5, (r) null, 16, (Object) null);
                                if (new C2201a(s()).n()) {
                                    UptodownApp.a.X(UptodownApp.f13477F, file5, s(), (String) null, 4, (Object) null);
                                }
                                C2668q f24 = aVar.f();
                                t.b(f24);
                                M(f24, 202);
                                M.f26506a.e(s());
                                return;
                            }
                            return;
                        }
                        httpsURLConnection.disconnect();
                        C2668q f25 = aVar.f();
                        if (f25 != null) {
                            f25.U(s());
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                        bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "no_enough_space");
                        o(" (112)", bundle2, currentTimeMillis);
                    }
                }
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "cant_mkdir");
                o(" (106)", bundle3, currentTimeMillis);
            }
        }
    }

    private final void R(C2668q qVar) {
        String T4;
        int size = qVar.o().size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!DownloadWorker.f21359d.i() && (T4 = T(qVar, i5)) != null) {
                S(qVar, i5, T4);
            }
        }
        P();
    }

    private final void S(C2668q qVar, int i5, String str) {
        long j5;
        C2668q qVar2 = qVar;
        int i6 = i5;
        String str2 = str;
        O((String) null);
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        aVar.o();
        Object obj = qVar2.o().get(i6);
        t.d(obj, "get(...)");
        r rVar = (r) obj;
        if (rVar.h() == rVar.i() && rVar.a() != null) {
            if (!s.F(C2286f.f20690a.e(rVar.a()), rVar.e(), false, 2, (Object) null)) {
                String a5 = rVar.a();
                t.b(a5);
                new File(a5).delete();
                rVar.p(0);
                C2940B a6 = C2940B.f26458v.a(s());
                a6.a();
                a6.E1(rVar);
                a6.m();
            } else {
                return;
            }
        }
        if (!H.f26488a.d()) {
            P.f26510a.e().send(209, (Bundle) null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        z(bundle, new URL(str2).getHost(), (r) qVar2.o().get(i6));
        HttpsURLConnection K4 = K(str2, currentTimeMillis, (r) qVar2.o().get(i6));
        if (K4 != null) {
            O(K4.getURL().getHost());
            String url = K4.getURL().toString();
            t.d(url, "toString(...)");
            String u5 = u(url);
            if (s.f0(u5, ".", 0, false, 6, (Object) null) < 0) {
                String url2 = K4.getURL().toString();
                t.d(url2, "toString(...)");
                u5 = u5 + t(url2);
            }
            File h5 = new E().h(s());
            File file = new File(h5, qVar2.w() + qVar2.E());
            if (file.exists() || file.mkdirs()) {
                if (u5.length() > 0 && ((r) qVar2.o().get(i6)).a() == null) {
                    ((r) qVar2.o().get(i6)).k(new File(file, u5).getAbsolutePath());
                    if (i6 == 0) {
                        qVar2.S(s());
                    }
                    C2940B a7 = C2940B.f26458v.a(s());
                    a7.a();
                    Object obj2 = qVar2.o().get(i6);
                    t.d(obj2, "get(...)");
                    a7.E1((r) obj2);
                    a7.m();
                }
                String a8 = ((r) qVar2.o().get(i6)).a();
                t.b(a8);
                File file2 = new File(a8);
                if (file2.exists()) {
                    j5 = file2.length();
                } else {
                    j5 = 0;
                }
                if (aVar.i()) {
                    n(currentTimeMillis, (r) qVar2.o().get(i6));
                } else if (E(K4, currentTimeMillis)) {
                    long j6 = currentTimeMillis;
                    long i7 = ((r) qVar2.o().get(i6)).i() - file2.length();
                    if (i7 >= 0) {
                        HttpsURLConnection httpsURLConnection = K4;
                        if (new C2942a().a(new E().m(s(), h5), i7)) {
                            if (i5 == 0) {
                                M(qVar2, 200);
                            }
                            if (qVar2.h() > 0) {
                                C2940B a9 = C2940B.f26458v.a(s());
                                a9.a();
                                C2669s o02 = a9.o0(qVar2.h());
                                if (o02 != null) {
                                    o02.d(s(), "downloadStarted");
                                }
                                a9.m();
                            }
                            K k5 = new K();
                            K k6 = new K();
                            int i8 = i5;
                            c cVar = new c(k5, k6, this, qVar2, i8);
                            K k7 = k5;
                            K k8 = k6;
                            int i9 = i8;
                            Object obj3 = qVar.o().get(i9);
                            t.d(obj3, "get(...)");
                            String w4 = w();
                            t.b(w4);
                            C2668q qVar3 = qVar;
                            File file3 = file2;
                            long j7 = j6;
                            long p5 = p(httpsURLConnection, file3, qVar3, (r) obj3, w4, j7, cVar);
                            C2668q qVar4 = qVar3;
                            long j8 = j7;
                            if (p5 >= 0) {
                                if (aVar.i()) {
                                    n(j8, (r) qVar4.o().get(i9));
                                    return;
                                }
                                Object obj4 = qVar4.o().get(i9);
                                t.d(obj4, "get(...)");
                                long j9 = p5;
                                File file4 = file3;
                                Bundle l5 = l(j5, j9, file4, (r) obj4);
                                File file5 = file4;
                                if (l5 != null) {
                                    qVar4.U(s());
                                    l5.putString("url", str2);
                                    o(" (111)", l5, j8);
                                    return;
                                }
                                if (qVar4.h() > 0) {
                                    C2940B a10 = C2940B.f26458v.a(s());
                                    a10.a();
                                    C2669s o03 = a10.o0(qVar4.h());
                                    if (o03 != null) {
                                        o03.d(s(), "downloadFinished");
                                    }
                                    a10.m();
                                }
                                A(k7.f24689a, j8, k8.f24689a, j9, (r) qVar4.o().get(i9));
                                if (i9 == qVar4.o().size() - 1) {
                                    if (new C2201a(s()).n()) {
                                        UptodownApp.a.X(UptodownApp.f13477F, file5, s(), (String) null, 4, (Object) null);
                                    } else {
                                        C2940B a11 = C2940B.f26458v.a(s());
                                        a11.a();
                                        Iterator it = a11.D0().iterator();
                                        t.d(it, "iterator(...)");
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            t.d(next, "next(...)");
                                            C2650J j10 = (C2650J) next;
                                            if (j10.b() == qVar4.q()) {
                                                M.f26506a.r(s(), qVar4, j10.c());
                                                a11.N(qVar4.q());
                                                break;
                                            }
                                        }
                                        a11.m();
                                    }
                                    if (qVar4.y() == qVar4.z()) {
                                        qVar4.X();
                                        C2940B a12 = C2940B.f26458v.a(s());
                                        a12.a();
                                        a12.D1(qVar4);
                                        a12.m();
                                        new X().f(s());
                                    }
                                    M(qVar4, 202);
                                    M.f26506a.e(s());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        httpsURLConnection.disconnect();
                        qVar2.U(s());
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                        bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "no_enough_space");
                        o(" (112)", bundle2, j6);
                    }
                }
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "cant_mkdir");
                o(" (106)", bundle3, currentTimeMillis);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String T(l2.C2668q r9, int r10) {
        /*
            r8 = this;
            z2.H r0 = z2.H.f26488a
            boolean r0 = r0.d()
            r1 = 0
            if (r0 != 0) goto L_0x0015
            z2.P r9 = z2.P.f26510a
            m2.e r9 = r9.e()
            r10 = 209(0xd1, float:2.93E-43)
            r9.send(r10, r1)
            return r1
        L_0x0015:
            if (r10 != 0) goto L_0x001c
            r0 = 199(0xc7, float:2.79E-43)
            r8.M(r9, r0)
        L_0x001c:
            z2.Z r0 = new z2.Z
            android.content.Context r2 = r8.s()
            r0.<init>(r2)
            java.util.ArrayList r2 = r9.o()
            java.lang.Object r2 = r2.get(r10)
            l2.r r2 = (l2.r) r2
            java.lang.String r2 = r2.a()
            r3 = 0
            if (r2 == 0) goto L_0x0058
            java.io.File r2 = new java.io.File
            java.util.ArrayList r5 = r9.o()
            java.lang.Object r5 = r5.get(r10)
            l2.r r5 = (l2.r) r5
            java.lang.String r5 = r5.a()
            kotlin.jvm.internal.t.b(r5)
            r2.<init>(r5)
            boolean r5 = r2.exists()
            if (r5 == 0) goto L_0x0058
            long r5 = r2.length()
            goto L_0x0059
        L_0x0058:
            r5 = r3
        L_0x0059:
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r5 = 0
            if (r2 <= 0) goto L_0x007d
            java.util.ArrayList r2 = r9.o()
            java.lang.Object r2 = r2.get(r10)
            l2.r r2 = (l2.r) r2
            long r6 = r2.d()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            long r6 = r9.h()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            l2.M r0 = r0.s0(r2, r5, r6)
            goto L_0x009b
        L_0x007d:
            java.util.ArrayList r2 = r9.o()
            java.lang.Object r2 = r2.get(r10)
            l2.r r2 = (l2.r) r2
            long r6 = r2.d()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            long r6 = r9.h()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            l2.M r0 = r0.r0(r2, r5, r6)
        L_0x009b:
            boolean r2 = r0.b()
            if (r2 != 0) goto L_0x00ec
            java.lang.String r2 = r0.d()
            if (r2 == 0) goto L_0x00ec
            org.json.JSONObject r2 = new org.json.JSONObject
            java.lang.String r0 = r0.d()
            kotlin.jvm.internal.t.b(r0)
            r2.<init>(r0)
            java.lang.String r0 = "success"
            boolean r6 = r2.isNull(r0)
            if (r6 != 0) goto L_0x00bf
            int r5 = r2.optInt(r0)
        L_0x00bf:
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r2.optJSONObject(r0)
            if (r0 == 0) goto L_0x00ec
            java.lang.String r2 = "sha256"
            boolean r6 = r0.isNull(r2)
            if (r6 != 0) goto L_0x00e0
            java.lang.String r2 = r0.optString(r2)
            java.util.ArrayList r6 = r9.o()
            java.lang.Object r6 = r6.get(r10)
            l2.r r6 = (l2.r) r6
            r6.n(r2)
        L_0x00e0:
            java.lang.String r2 = "downloadURL"
            boolean r6 = r0.isNull(r2)
            if (r6 != 0) goto L_0x00ec
            java.lang.String r1 = r0.optString(r2)
        L_0x00ec:
            r0 = 1
            if (r5 == r0) goto L_0x00f5
            java.lang.String r10 = " (105)"
            r8.G(r9, r10)
            return r1
        L_0x00f5:
            com.uptodown.workers.DownloadWorker$a r0 = com.uptodown.workers.DownloadWorker.f21359d
            boolean r0 = r0.i()
            if (r0 == 0) goto L_0x010a
            java.util.ArrayList r9 = r9.o()
            java.lang.Object r9 = r9.get(r10)
            l2.r r9 = (l2.r) r9
            r8.n(r3, r9)
        L_0x010a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadApkWorker.T(l2.q, int):java.lang.String");
    }

    public void L(C2668q qVar) {
        t.e(qVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("download", qVar);
        P.f26510a.e().send(203, bundle);
    }

    public void M(C2668q qVar, int i5) {
        t.e(qVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("download", qVar);
        bundle.putString("packagename", qVar.w());
        P.f26510a.e().send(i5, bundle);
    }

    public ListenableWorker.Result doWork() {
        String str = this.f21343h;
        if (str != null) {
            t.b(str);
            Q(str);
        } else {
            DownloadWorker.a aVar = DownloadWorker.f21359d;
            if (aVar.f() == null) {
                G((C2668q) null, " (100)");
            } else {
                C2668q f5 = aVar.f();
                t.b(f5);
                if (f5.o().isEmpty()) {
                    G(aVar.f(), " (114)");
                } else {
                    C2668q f6 = aVar.f();
                    t.b(f6);
                    if (((r) f6.o().get(0)).d() < 0) {
                        G(aVar.f(), " (103)");
                    } else {
                        C2668q f7 = aVar.f();
                        t.b(f7);
                        if (f7.h() == -1) {
                            G(aVar.f(), " (113)");
                        } else {
                            C2668q f8 = aVar.f();
                            t.b(f8);
                            R(f8);
                        }
                    }
                }
            }
        }
        P.f26510a.e().send(210, (Bundle) null);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }

    public void o(String str, Bundle bundle, long j5) {
        t.e(str, "errorCode");
        t.e(bundle, "bundle");
        G(DownloadWorker.f21359d.f(), str);
        if (j5 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j5) / ((long) 1000));
        }
        Bundle k5 = DownloadWorker.k(this, bundle, (r) null, 2, (Object) null);
        F v5 = v();
        if (v5 != null) {
            v5.d("download", k5);
        }
    }
}
