package com.uptodown.core.activities;

import S1.k;
import T1.A0;
import T1.B0;
import T1.C2174i0;
import T1.C2176j0;
import T1.C2178k0;
import T1.C2180l0;
import T1.C2182m0;
import T1.C2184n0;
import T1.C2186o0;
import T1.C2188p0;
import T1.C2190q0;
import T1.C2191r0;
import T1.C2193s0;
import T1.C2194t;
import T1.t0;
import T1.u0;
import T1.v0;
import T1.w0;
import T1.x0;
import T1.y0;
import T1.z0;
import U1.C2201a;
import V1.C2207c;
import W1.C2210c;
import W2.J;
import W2.u;
import X1.C2224a;
import X1.C2231h;
import X2.C2250q;
import Y1.C2257a;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2275G;
import b2.C2278J;
import b2.C2279K;
import b2.C2289i;
import b2.C2290j;
import b2.C2291k;
import b2.C2292l;
import b2.C2301u;
import b2.C2302v;
import b2.C2303w;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.Q;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

public final class InstallerActivity extends C2194t {

    /* renamed from: q0  reason: collision with root package name */
    public static final b f21035q0 = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public TextView f21036A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public TextView f21037B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public TextView f21038C;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public TextView f21039D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public TextView f21040E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public TextView f21041F;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public ImageView f21042G;

    /* renamed from: H  reason: collision with root package name */
    private ImageView f21043H;

    /* renamed from: I  reason: collision with root package name */
    private String f21044I;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public ArrayList f21045J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public String f21046K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public Uri f21047L;

    /* renamed from: M  reason: collision with root package name */
    private C2279K f21048M;

    /* renamed from: N  reason: collision with root package name */
    private String f21049N;

    /* renamed from: O  reason: collision with root package name */
    private AlertDialog f21050O;

    /* renamed from: P  reason: collision with root package name */
    private AlertDialog f21051P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public ArrayList f21052Q;

    /* renamed from: R  reason: collision with root package name */
    private C2908y0 f21053R;

    /* renamed from: S  reason: collision with root package name */
    private C2231h f21054S;

    /* renamed from: T  reason: collision with root package name */
    private X1.m f21055T;

    /* renamed from: U  reason: collision with root package name */
    private boolean f21056U;

    /* renamed from: V  reason: collision with root package name */
    private LinearLayout f21057V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public boolean f21058W;

    /* renamed from: X  reason: collision with root package name */
    private String f21059X;

    /* renamed from: Y  reason: collision with root package name */
    private boolean f21060Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public boolean f21061Z;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public boolean f21062m0;

    /* renamed from: n0  reason: collision with root package name */
    private final m f21063n0 = new m(this);

    /* renamed from: o0  reason: collision with root package name */
    private final c f21064o0 = new c(this);
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ProgressBar f21065p;

    /* renamed from: p0  reason: collision with root package name */
    private final q f21066p0 = new q(this);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public TextView f21067q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public TextView f21068r;

    /* renamed from: s  reason: collision with root package name */
    private RelativeLayout f21069s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public ImageView f21070t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public TextView f21071u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public TextView f21072v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public TextView f21073w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public LinearLayout f21074x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public TextView f21075y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public TextView f21076z;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final File f21077a;

        /* renamed from: b  reason: collision with root package name */
        private int f21078b = -1;

        /* renamed from: c  reason: collision with root package name */
        private String f21079c;

        /* renamed from: d  reason: collision with root package name */
        private String f21080d;

        /* renamed from: e  reason: collision with root package name */
        private long f21081e;

        public a(File file) {
            kotlin.jvm.internal.t.e(file, "file");
            this.f21077a = file;
        }

        public final int a() {
            return this.f21078b;
        }

        public final File b() {
            return this.f21077a;
        }

        public final String c() {
            return this.f21079c;
        }

        public final long d() {
            return this.f21081e;
        }

        public final String e() {
            return this.f21080d;
        }

        public final void f(int i5) {
            this.f21078b = i5;
        }

        public final void g(String str) {
            this.f21079c = str;
        }

        public final void h(long j5) {
            this.f21081e = j5;
        }

        public final void i(String str) {
            this.f21080d = str;
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    public static final class c implements C2224a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21082a;

        c(InstallerActivity installerActivity) {
            this.f21082a = installerActivity;
        }

        public void a(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            this.f21082a.g2();
        }

        public void b(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            this.f21082a.finish();
        }

        public void c(String str, String str2) {
            kotlin.jvm.internal.t.e(str, "filename");
            if (str2 != null) {
                this.f21082a.e2(str2);
                return;
            }
            InstallerActivity installerActivity = this.f21082a;
            String string = installerActivity.getString(S1.i.error_unknown);
            kotlin.jvm.internal.t.d(string, "getString(...)");
            installerActivity.e2(string);
        }

        public void d(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            InstallerActivity installerActivity = this.f21082a;
            installerActivity.e2(str + " could not be parsed.");
        }

        public void e(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            this.f21082a.e2("invalid version code");
        }

        public void f(String str) {
            this.f21082a.e2("error: not system permissions");
        }
    }

    public static final class d implements X1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2275G f21083a;

        d(C2275G g5) {
            this.f21083a = g5;
        }

        public void a(View view, int i5) {
            ((Y1.f) this.f21083a.l().get(i5)).g(!((Y1.f) this.f21083a.l().get(i5)).a());
        }
    }

    public static final class e implements X1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2275G f21084a;

        e(C2275G g5) {
            this.f21084a = g5;
        }

        public void a(View view, int i5) {
            ((Y1.f) this.f21084a.n().get(i5)).g(!((Y1.f) this.f21084a.n().get(i5)).a());
        }
    }

    public static final class f implements X1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2275G f21085a;

        f(C2275G g5) {
            this.f21085a = g5;
        }

        public void a(View view, int i5) {
            ((Y1.f) this.f21085a.o().get(i5)).g(!((Y1.f) this.f21085a.o().get(i5)).a());
        }
    }

    public static final class g implements X1.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2275G f21086a;

        g(C2275G g5) {
            this.f21086a = g5;
        }

        public void a(View view, int i5) {
            ((Y1.f) this.f21086a.p().get(i5)).g(!((Y1.f) this.f21086a.p().get(i5)).a());
        }
    }

    public static final class h implements C2231h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21087a;

        h(InstallerActivity installerActivity) {
            this.f21087a = installerActivity;
        }

        public void a() {
            this.f21087a.g2();
        }

        public void b(String str) {
            this.f21087a.Q1(str);
        }
    }

    public static final class i implements X1.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21088a;

        i(InstallerActivity installerActivity) {
            this.f21088a = installerActivity;
        }

        /* access modifiers changed from: private */
        public static final void k(InstallerActivity installerActivity, View view) {
            installerActivity.finish();
        }

        public void a(File file, ArrayList arrayList) {
            kotlin.jvm.internal.t.e(file, "fileZipped");
            kotlin.jvm.internal.t.e(arrayList, "files");
            this.f21088a.a2(file, arrayList);
        }

        public void b(int i5) {
            this.f21088a.i2(i5);
        }

        public void c(File file) {
            ApplicationInfo applicationInfo;
            if (file != null) {
                this.f21088a.f21046K = file.getAbsolutePath();
                PackageManager packageManager = this.f21088a.getPackageManager();
                kotlin.jvm.internal.t.b(packageManager);
                String Z02 = this.f21088a.f21046K;
                kotlin.jvm.internal.t.b(Z02);
                PackageInfo c5 = C2301u.c(packageManager, Z02, 128);
                if (c5 != null) {
                    applicationInfo = c5.applicationInfo;
                } else {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    if (!this.f21088a.f21062m0) {
                        ImageView V02 = this.f21088a.f21042G;
                        if (V02 != null) {
                            C2290j jVar = new C2290j();
                            InstallerActivity installerActivity = this.f21088a;
                            String absolutePath = file.getAbsolutePath();
                            kotlin.jvm.internal.t.d(absolutePath, "getAbsolutePath(...)");
                            V02.setImageDrawable(jVar.h(installerActivity, absolutePath));
                        }
                        this.f21088a.f21062m0 = true;
                    }
                    LinearLayout W02 = this.f21088a.f21074x;
                    if (W02 != null) {
                        W02.setVisibility(0);
                    }
                    C2290j jVar2 = new C2290j();
                    ApplicationInfo applicationInfo2 = c5.applicationInfo;
                    kotlin.jvm.internal.t.b(applicationInfo2);
                    String Z03 = this.f21088a.f21046K;
                    kotlin.jvm.internal.t.b(Z03);
                    String b5 = jVar2.b(applicationInfo2, Z03, packageManager);
                    long m5 = new C2290j().m(c5);
                    C2289i iVar = new C2289i();
                    String Z04 = this.f21088a.f21046K;
                    kotlin.jvm.internal.t.b(Z04);
                    long j5 = iVar.j(Z04);
                    k.a aVar = S1.k.f32g;
                    String str = c5.packageName;
                    kotlin.jvm.internal.t.d(str, "packageName");
                    aVar.B(str, m5, b5, j5);
                    if (!this.f21088a.f21061Z) {
                        TextView a12 = this.f21088a.f21073w;
                        if (a12 != null) {
                            a12.setText(b5);
                        }
                        TextView a13 = this.f21088a.f21073w;
                        if (a13 != null) {
                            a13.setVisibility(0);
                        }
                        TextView f12 = this.f21088a.f21075y;
                        if (f12 != null) {
                            f12.setText(file.getName());
                        }
                        TextView f13 = this.f21088a.f21075y;
                        if (f13 != null) {
                            f13.setVisibility(0);
                        }
                        TextView l12 = this.f21088a.f21076z;
                        if (l12 != null) {
                            l12.setText(new C2291k().c(j5));
                        }
                        TextView l13 = this.f21088a.f21076z;
                        if (l13 != null) {
                            l13.setVisibility(0);
                        }
                        TextView m12 = this.f21088a.f21036A;
                        if (m12 != null) {
                            m12.setText(c5.versionName);
                        }
                        TextView m13 = this.f21088a.f21036A;
                        if (m13 != null) {
                            m13.setVisibility(0);
                        }
                    }
                }
            }
        }

        public void d(File file) {
            if (this.f21088a.f21045J == null) {
                this.f21088a.f21045J = new ArrayList();
            }
            ArrayList T02 = this.f21088a.f21045J;
            kotlin.jvm.internal.t.b(T02);
            T02.add(file);
        }

        public void e() {
            this.f21088a.getWindow().clearFlags(128);
            TextView k12 = this.f21088a.f21039D;
            if (k12 != null) {
                k12.setText(S1.i.error_not_enough_space);
            }
        }

        public void f() {
            S1.k.f32g.e();
            this.f21088a.getWindow().clearFlags(128);
            TextView j12 = this.f21088a.f21067q;
            if (j12 != null) {
                InstallerActivity installerActivity = this.f21088a;
                j12.setText(installerActivity.getString(S1.i.core_kill_this_app, new Object[]{installerActivity.getString(S1.i.app_name)}));
            }
            TextView j13 = this.f21088a.f21067q;
            if (j13 != null) {
                j13.setVisibility(0);
            }
            TextView e12 = this.f21088a.f21041F;
            if (e12 != null) {
                e12.setOnClickListener(new B0(this.f21088a));
            }
        }

        public void g() {
            this.f21088a.i2(0);
        }

        public void h() {
            TextView k12 = this.f21088a.f21039D;
            if (k12 != null) {
                k12.setText(S1.i.error_unzipping);
            }
        }

        public void i() {
            S1.k.f32g.e();
            this.f21088a.getWindow().clearFlags(128);
            TextView j12 = this.f21088a.f21067q;
            if (j12 != null) {
                InstallerActivity installerActivity = this.f21088a;
                j12.setText(installerActivity.getString(S1.i.msg_install_from_unknown_source, new Object[]{installerActivity.getString(S1.i.app_name)}));
            }
            this.f21088a.M();
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21089a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21090b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(InstallerActivity installerActivity, C2308e eVar) {
            super(2, eVar);
            this.f21090b = installerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f21090b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21089a;
            if (i5 == 0) {
                u.b(obj);
                InstallerActivity installerActivity = this.f21090b;
                this.f21089a = 1;
                if (installerActivity.X1(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21091a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21092b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Uri f21093c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21094d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(InstallerActivity installerActivity, Uri uri, String str, C2308e eVar) {
            super(2, eVar);
            this.f21092b = installerActivity;
            this.f21093c = uri;
            this.f21094d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f21092b, this.f21093c, this.f21094d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21091a;
            if (i5 == 0) {
                u.b(obj);
                InstallerActivity installerActivity = this.f21092b;
                Uri uri = this.f21093c;
                String str = this.f21094d;
                this.f21091a = 1;
                if (installerActivity.c2(uri, str, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21095a;

        /* renamed from: b  reason: collision with root package name */
        int f21096b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21097c;

        static final class a extends kotlin.coroutines.jvm.internal.l implements k3.p {

            /* renamed from: a  reason: collision with root package name */
            int f21098a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InstallerActivity f21099b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f21100c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(InstallerActivity installerActivity, kotlin.jvm.internal.J j5, C2308e eVar) {
                super(2, eVar);
                this.f21099b = installerActivity;
                this.f21100c = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21099b, this.f21100c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21098a == 0) {
                    u.b(obj);
                    TextView j12 = this.f21099b.f21067q;
                    if (j12 != null) {
                        ArrayList X02 = this.f21099b.f21052Q;
                        kotlin.jvm.internal.t.b(X02);
                        j12.setText((CharSequence) X02.get(this.f21100c.f24688a));
                    }
                    TextView j13 = this.f21099b.f21067q;
                    if (j13 != null) {
                        j13.setVisibility(0);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(InstallerActivity installerActivity, C2308e eVar) {
            super(2, eVar);
            this.f21097c = installerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new l(this.f21097c, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A[Catch:{ Exception -> 0x0012 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[EDGE_INSN: B:27:0x0063->B:19:0x0063 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.f21096b
                r2 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                int r1 = r7.f21095a
                W2.u.b(r8)     // Catch:{ Exception -> 0x0012 }
                r8 = r1
                goto L_0x007b
            L_0x0012:
                r8 = move-exception
                goto L_0x0081
            L_0x0014:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001c:
                W2.u.b(r8)
                com.uptodown.core.activities.InstallerActivity r8 = r7.f21097c     // Catch:{ Exception -> 0x0012 }
                java.util.ArrayList r8 = r8.f21052Q     // Catch:{ Exception -> 0x0012 }
                kotlin.jvm.internal.t.b(r8)     // Catch:{ Exception -> 0x0012 }
                int r8 = r8.size()     // Catch:{ Exception -> 0x0012 }
                if (r8 <= 0) goto L_0x0084
                r8 = -1
            L_0x002f:
                kotlin.jvm.internal.J r1 = new kotlin.jvm.internal.J     // Catch:{ Exception -> 0x0012 }
                r1.<init>()     // Catch:{ Exception -> 0x0012 }
                o3.c$a r3 = o3.C2705c.f25533a     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity r4 = r7.f21097c     // Catch:{ Exception -> 0x0012 }
                java.util.ArrayList r4 = r4.f21052Q     // Catch:{ Exception -> 0x0012 }
                kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x0012 }
                int r4 = r4.size()     // Catch:{ Exception -> 0x0012 }
                int r3 = r3.b(r4)     // Catch:{ Exception -> 0x0012 }
                r1.f24688a = r3     // Catch:{ Exception -> 0x0012 }
            L_0x0049:
                int r3 = r1.f24688a     // Catch:{ Exception -> 0x0012 }
                if (r3 != r8) goto L_0x0063
                o3.c$a r3 = o3.C2705c.f25533a     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity r4 = r7.f21097c     // Catch:{ Exception -> 0x0012 }
                java.util.ArrayList r4 = r4.f21052Q     // Catch:{ Exception -> 0x0012 }
                kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x0012 }
                int r4 = r4.size()     // Catch:{ Exception -> 0x0012 }
                int r3 = r3.b(r4)     // Catch:{ Exception -> 0x0012 }
                r1.f24688a = r3     // Catch:{ Exception -> 0x0012 }
                goto L_0x0049
            L_0x0063:
                w3.I0 r8 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity$l$a r4 = new com.uptodown.core.activities.InstallerActivity$l$a     // Catch:{ Exception -> 0x0012 }
                com.uptodown.core.activities.InstallerActivity r5 = r7.f21097c     // Catch:{ Exception -> 0x0012 }
                r6 = 0
                r4.<init>(r5, r1, r6)     // Catch:{ Exception -> 0x0012 }
                r7.f21095a = r3     // Catch:{ Exception -> 0x0012 }
                r7.f21096b = r2     // Catch:{ Exception -> 0x0012 }
                java.lang.Object r8 = w3.C2872g.g(r8, r4, r7)     // Catch:{ Exception -> 0x0012 }
                if (r8 != r0) goto L_0x007a
                return r0
            L_0x007a:
                r8 = r3
            L_0x007b:
                r3 = 7000(0x1b58, double:3.4585E-320)
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x0012 }
                goto L_0x002f
            L_0x0081:
                r8.printStackTrace()
            L_0x0084:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((l) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class m extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21101a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(InstallerActivity installerActivity) {
            super(true);
            this.f21101a = installerActivity;
        }

        public void handleOnBackPressed() {
            this.f21101a.v1();
        }
    }

    static final class n extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f21102a;

        /* renamed from: b  reason: collision with root package name */
        Object f21103b;

        /* renamed from: c  reason: collision with root package name */
        Object f21104c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f21105d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21106e;

        /* renamed from: f  reason: collision with root package name */
        int f21107f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(InstallerActivity installerActivity, C2308e eVar) {
            super(eVar);
            this.f21106e = installerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f21105d = obj;
            this.f21107f |= Integer.MIN_VALUE;
            return this.f21106e.c2((Uri) null, (String) null, this);
        }
    }

    static final class o extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21108a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21109b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(InstallerActivity installerActivity, C2308e eVar) {
            super(2, eVar);
            this.f21109b = installerActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new o(this.f21109b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21108a == 0) {
                u.b(obj);
                TextView k12 = this.f21109b.f21039D;
                if (k12 != null) {
                    k12.setText(S1.i.xapk_receiving_data);
                }
                ProgressBar Y02 = this.f21109b.f21065p;
                if (Y02 != null) {
                    Y02.setIndeterminate(true);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((o) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class p extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21111b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21112c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Uri f21113d;

        static final class a extends kotlin.coroutines.jvm.internal.l implements k3.p {

            /* renamed from: a  reason: collision with root package name */
            int f21114a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InstallerActivity f21115b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21116c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(InstallerActivity installerActivity, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21115b = installerActivity;
                this.f21116c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21115b, this.f21116c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21114a == 0) {
                    u.b(obj);
                    ProgressBar Y02 = this.f21115b.f21065p;
                    if (Y02 != null) {
                        Y02.setIndeterminate(false);
                    }
                    TextView k12 = this.f21115b.f21039D;
                    if (k12 != null) {
                        k12.setText("");
                    }
                    TextView e12 = this.f21115b.f21041F;
                    if (e12 != null) {
                        e12.setVisibility(8);
                    }
                    TextView h12 = this.f21115b.f21040E;
                    if (h12 != null) {
                        h12.setVisibility(8);
                    }
                    if (this.f21116c.f24690a != null) {
                        TextView k13 = this.f21115b.f21039D;
                        if (k13 != null) {
                            k13.setText((CharSequence) this.f21116c.f24690a);
                        }
                    } else {
                        InstallerActivity installerActivity = this.f21115b;
                        Intent intent = new Intent();
                        intent.putExtra("realPath", this.f21115b.f21046K);
                        J j5 = J.f19942a;
                        installerActivity.setResult(10, intent);
                        this.f21115b.finish();
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str, InstallerActivity installerActivity, Uri uri, C2308e eVar) {
            super(2, eVar);
            this.f21111b = str;
            this.f21112c = installerActivity;
            this.f21113d = uri;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new p(this.f21111b, this.f21112c, this.f21113d, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r14.f21110a
                r2 = 1
                if (r1 == 0) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                W2.u.b(r15)
                goto L_0x00dd
            L_0x0010:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0018:
                W2.u.b(r15)
                kotlin.jvm.internal.L r15 = new kotlin.jvm.internal.L
                r15.<init>()
                b2.j r1 = new b2.j
                r1.<init>()
                java.lang.String r3 = r14.f21111b
                boolean r1 = r1.o(r3)
                r3 = 0
                if (r1 == 0) goto L_0x00c9
                com.uptodown.core.activities.InstallerActivity r1 = r14.f21112c     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                android.net.Uri r4 = r14.f21113d     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x003d, SecurityException -> 0x003b }
                goto L_0x005b
            L_0x003b:
                r1 = move-exception
                goto L_0x003f
            L_0x003d:
                r1 = move-exception
                goto L_0x004d
            L_0x003f:
                r1.printStackTrace()
                com.uptodown.core.activities.InstallerActivity r1 = r14.f21112c
                int r4 = S1.i.no_permissions_directory
                java.lang.String r1 = r1.getString(r4)
                r15.f24690a = r1
                goto L_0x005a
            L_0x004d:
                r1.printStackTrace()
                com.uptodown.core.activities.InstallerActivity r1 = r14.f21112c
                int r4 = S1.i.installable_files_not_found
                java.lang.String r1 = r1.getString(r4)
                r15.f24690a = r1
            L_0x005a:
                r1 = r3
            L_0x005b:
                if (r1 == 0) goto L_0x00c9
                r4 = 8192(0x2000, float:1.14794E-41)
                byte[] r5 = new byte[r4]
                kotlin.jvm.internal.J r6 = new kotlin.jvm.internal.J
                r6.<init>()
                b2.j r7 = new b2.j
                r7.<init>()
                com.uptodown.core.activities.InstallerActivity r8 = r14.f21112c
                java.io.File r7 = r7.g(r8)
                long r8 = r7.getUsableSpace()
                int r10 = r1.available()
                double r10 = (double) r10
                r12 = 4608308318706860032(0x3ff4000000000000, double:1.25)
                double r10 = r10 * r12
                double r8 = (double) r8
                int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r8 <= 0) goto L_0x00bc
                java.io.File r8 = new java.io.File
                java.lang.String r9 = r14.f21111b
                r8.<init>(r7, r9)
                java.io.FileOutputStream r7 = new java.io.FileOutputStream
                r7.<init>(r8)
            L_0x008e:
                r9 = 0
                int r10 = r1.read(r5, r9, r4)
                r6.f24688a = r10
                if (r10 <= 0) goto L_0x00a3
                r7.write(r5, r9, r10)     // Catch:{ IOException -> 0x009b }
                goto L_0x008e
            L_0x009b:
                r9 = move-exception
                java.lang.String r9 = r9.getLocalizedMessage()
                r15.f24690a = r9
                goto L_0x008e
            L_0x00a3:
                r7.close()     // Catch:{ IOException -> 0x00a7 }
                goto L_0x00b2
            L_0x00a7:
                r4 = move-exception
                java.lang.Object r5 = r15.f24690a
                if (r5 != 0) goto L_0x00b2
                java.lang.String r4 = r4.getLocalizedMessage()
                r15.f24690a = r4
            L_0x00b2:
                com.uptodown.core.activities.InstallerActivity r4 = r14.f21112c
                java.lang.String r5 = r8.getAbsolutePath()
                r4.f21046K = r5
                goto L_0x00c6
            L_0x00bc:
                com.uptodown.core.activities.InstallerActivity r4 = r14.f21112c
                int r5 = S1.i.error_not_enough_space
                java.lang.String r4 = r4.getString(r5)
                r15.f24690a = r4
            L_0x00c6:
                r1.close()
            L_0x00c9:
                w3.I0 r1 = w3.C2865c0.c()
                com.uptodown.core.activities.InstallerActivity$p$a r4 = new com.uptodown.core.activities.InstallerActivity$p$a
                com.uptodown.core.activities.InstallerActivity r5 = r14.f21112c
                r4.<init>(r5, r15, r3)
                r14.f21110a = r2
                java.lang.Object r15 = w3.C2872g.g(r1, r4, r14)
                if (r15 != r0) goto L_0x00dd
                return r0
            L_0x00dd:
                W2.J r15 = W2.J.f19942a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((p) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class q implements X1.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21117a;

        q(InstallerActivity installerActivity) {
            this.f21117a = installerActivity;
        }

        public void a(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            this.f21117a.g2();
        }

        public void b(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            this.f21117a.finish();
        }

        public void c(String str, String str2) {
            kotlin.jvm.internal.t.e(str, "filename");
            InstallerActivity installerActivity = this.f21117a;
            String string = installerActivity.getString(S1.i.xapk_installation_failed);
            kotlin.jvm.internal.t.d(string, "getString(...)");
            installerActivity.e2(string);
        }

        public void d(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            InstallerActivity installerActivity = this.f21117a;
            installerActivity.e2(str + " could not be parsed.");
        }

        public void e(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            this.f21117a.e2("invalid version code");
        }

        public void f(String str) {
            kotlin.jvm.internal.t.e(str, "filename");
            InstallerActivity installerActivity = this.f21117a;
            installerActivity.e2(str + " not found.");
        }
    }

    static final class r extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f21118a;

        /* renamed from: b  reason: collision with root package name */
        Object f21119b;

        /* renamed from: c  reason: collision with root package name */
        int f21120c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f21121d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21122e;

        /* renamed from: f  reason: collision with root package name */
        int f21123f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(InstallerActivity installerActivity, C2308e eVar) {
            super(eVar);
            this.f21122e = installerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f21121d = obj;
            this.f21123f |= Integer.MIN_VALUE;
            return this.f21122e.p2(0, this);
        }
    }

    static final class s extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21125b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f21126c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(InstallerActivity installerActivity, L l5, C2308e eVar) {
            super(2, eVar);
            this.f21125b = installerActivity;
            this.f21126c = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new s(this.f21125b, this.f21126c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21124a == 0) {
                u.b(obj);
                Intent intent = this.f21125b.getIntent();
                if (intent != null) {
                    this.f21125b.f21047L = intent.getData();
                    Bundle extras = intent.getExtras();
                    if (extras != null && extras.containsKey("realPath")) {
                        this.f21125b.f21046K = extras.getString("realPath");
                        L l5 = this.f21126c;
                        String Z02 = this.f21125b.f21046K;
                        kotlin.jvm.internal.t.b(Z02);
                        String Z03 = this.f21125b.f21046K;
                        kotlin.jvm.internal.t.b(Z03);
                        String substring = Z02.substring(t3.s.l0(Z03, "/", 0, false, 6, (Object) null) + 1);
                        kotlin.jvm.internal.t.d(substring, "substring(...)");
                        l5.f24690a = substring;
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((s) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class t extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f21127a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InstallerActivity f21128b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f21129c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f21130d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(InstallerActivity installerActivity, int i5, L l5, C2308e eVar) {
            super(2, eVar);
            this.f21128b = installerActivity;
            this.f21129c = i5;
            this.f21130d = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new t(this.f21128b, this.f21129c, this.f21130d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ApplicationInfo applicationInfo;
            String Z02;
            C2316b.f();
            if (this.f21127a == 0) {
                u.b(obj);
                if (!this.f21128b.f21058W) {
                    this.f21128b.finish();
                } else if (this.f21129c == 1) {
                    TextView h12 = this.f21128b.f21040E;
                    if (h12 != null) {
                        h12.setVisibility(0);
                    }
                    ProgressBar Y02 = this.f21128b.f21065p;
                    if (Y02 != null) {
                        Y02.setVisibility(8);
                    }
                    TextView g12 = this.f21128b.f21038C;
                    if (g12 != null) {
                        g12.setVisibility(8);
                    }
                    TextView c12 = this.f21128b.f21068r;
                    if (c12 != null) {
                        c12.setVisibility(0);
                    }
                    TextView i12 = this.f21128b.f21037B;
                    if (i12 != null) {
                        i12.setText(this.f21128b.getString(S1.i.core_install_next_app));
                    }
                    if (this.f21130d.f24690a != null) {
                        TextView b12 = this.f21128b.f21072v;
                        if (b12 != null) {
                            b12.setText((CharSequence) this.f21130d.f24690a);
                        }
                        TextView b13 = this.f21128b.f21072v;
                        if (b13 != null) {
                            b13.setVisibility(0);
                        }
                    } else {
                        TextView b14 = this.f21128b.f21072v;
                        if (b14 != null) {
                            b14.setText("");
                        }
                    }
                    String Z03 = this.f21128b.f21046K;
                    if (!(Z03 == null || Z03.length() == 0)) {
                        PackageManager packageManager = this.f21128b.getPackageManager();
                        kotlin.jvm.internal.t.d(packageManager, "getPackageManager(...)");
                        String Z04 = this.f21128b.f21046K;
                        kotlin.jvm.internal.t.b(Z04);
                        PackageInfo c5 = C2301u.c(packageManager, Z04, 128);
                        if (c5 != null) {
                            applicationInfo = c5.applicationInfo;
                        } else {
                            applicationInfo = null;
                        }
                        if (!(applicationInfo == null || (Z02 = this.f21128b.f21046K) == null || Z02.length() == 0)) {
                            C2290j jVar = new C2290j();
                            ApplicationInfo applicationInfo2 = c5.applicationInfo;
                            kotlin.jvm.internal.t.b(applicationInfo2);
                            String Z05 = this.f21128b.f21046K;
                            kotlin.jvm.internal.t.b(Z05);
                            PackageManager packageManager2 = this.f21128b.getPackageManager();
                            kotlin.jvm.internal.t.d(packageManager2, "getPackageManager(...)");
                            String b5 = jVar.b(applicationInfo2, Z05, packageManager2);
                            TextView d12 = this.f21128b.f21071u;
                            if (d12 != null) {
                                d12.setText(b5);
                            }
                            TextView d13 = this.f21128b.f21071u;
                            if (d13 != null) {
                                d13.setVisibility(0);
                            }
                        }
                        ImageView U02 = this.f21128b.f21070t;
                        if (U02 != null) {
                            U02.setVisibility(0);
                        }
                        String Z06 = this.f21128b.f21046K;
                        kotlin.jvm.internal.t.b(Z06);
                        if (t3.s.D(Z06, ".xapk", false, 2, (Object) null)) {
                            ImageView U03 = this.f21128b.f21070t;
                            if (U03 != null) {
                                U03.setImageResource(S1.e.core_vector_xapk);
                            }
                        } else {
                            ImageView U04 = this.f21128b.f21070t;
                            if (U04 != null) {
                                C2290j jVar2 = new C2290j();
                                InstallerActivity installerActivity = this.f21128b;
                                String Z07 = installerActivity.f21046K;
                                kotlin.jvm.internal.t.b(Z07);
                                U04.setImageDrawable(jVar2.h(installerActivity, Z07));
                            }
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((t) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final void A1(InstallerActivity installerActivity, File file, DialogInterface dialogInterface, int i5) {
        C2201a aVar = new C2201a(installerActivity);
        aVar.O(true);
        aVar.D(false);
        installerActivity.O1(installerActivity, file);
    }

    /* access modifiers changed from: private */
    public static final void B1(InstallerActivity installerActivity, ArrayList arrayList, DialogInterface dialogInterface, int i5) {
        C2201a aVar = new C2201a(installerActivity);
        aVar.O(true);
        aVar.D(true);
        installerActivity.P1(installerActivity, arrayList);
    }

    /* access modifiers changed from: private */
    public static final void C1(InstallerActivity installerActivity, ArrayList arrayList, DialogInterface dialogInterface, int i5) {
        C2201a aVar = new C2201a(installerActivity);
        aVar.O(true);
        aVar.D(false);
        installerActivity.P1(installerActivity, arrayList);
    }

    private final void D1(String str, ArrayList arrayList) {
        Window window;
        AlertDialog alertDialog = this.f21050O;
        if (alertDialog != null) {
            kotlin.jvm.internal.t.b(alertDialog);
            if (alertDialog.isShowing()) {
                AlertDialog alertDialog2 = this.f21050O;
                kotlin.jvm.internal.t.b(alertDialog2);
                alertDialog2.dismiss();
            }
        }
        C2275G g5 = new C2275G(this);
        g5.B(arrayList);
        String str2 = null;
        View inflate = getLayoutInflater().inflate(S1.g.dialog_splits_selector, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(S1.f.tv_app_name_dialog_splits);
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        textView.setText(str);
        ((TextView) inflate.findViewById(S1.f.tv_label_packagename_dialog_splits)).setTypeface(aVar.w());
        TextView textView2 = (TextView) inflate.findViewById(S1.f.tv_packagename_dialog_splits);
        textView2.setTypeface(aVar.x());
        a m5 = g5.m();
        if (m5 != null) {
            str2 = m5.c();
        }
        textView2.setText(str2);
        ((TextView) inflate.findViewById(S1.f.tv_label_version_dialog_splits)).setTypeface(aVar.w());
        TextView textView3 = (TextView) inflate.findViewById(S1.f.tv_version_dialog_splits);
        textView3.setTypeface(aVar.x());
        ((TextView) inflate.findViewById(S1.f.tv_label_apps_to_install_dialog_splits)).setTypeface(aVar.w());
        CheckBox checkBox = (CheckBox) inflate.findViewById(S1.f.cb_base_apk_dialog_splits);
        checkBox.setTypeface(aVar.x());
        if (g5.m() != null) {
            StringBuilder sb = new StringBuilder();
            a m6 = g5.m();
            kotlin.jvm.internal.t.b(m6);
            sb.append(m6.e());
            sb.append(" (");
            a m7 = g5.m();
            kotlin.jvm.internal.t.b(m7);
            sb.append(m7.d());
            sb.append(')');
            textView3.setText(sb.toString());
            a m8 = g5.m();
            kotlin.jvm.internal.t.b(m8);
            checkBox.setText(m8.b().getName());
        }
        TextView textView4 = (TextView) inflate.findViewById(S1.f.tv_label_arquitecture_dialog_splits);
        textView4.setTypeface(aVar.w());
        TextView textView5 = (TextView) inflate.findViewById(S1.f.tv_device_supported_abis_dialog_splits);
        textView5.setTypeface(aVar.x());
        View findViewById = inflate.findViewById(S1.f.rv_arquitecture_dialog_splits);
        kotlin.jvm.internal.t.d(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        if (g5.l().size() > 0) {
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView.addItemDecoration(new C2303w((int) getResources().getDimension(S1.d.margin_generic_item_recyclerview)));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new C2207c(g5.l(), new d(g5)));
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    StringBuilder sb2 = new StringBuilder();
                    int length = strArr.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        if (i5 == 0) {
                            sb2 = new StringBuilder('(' + strArr[i5]);
                        } else {
                            sb2.append(",");
                            sb2.append(strArr[i5]);
                        }
                    }
                    sb2.append(")");
                    Q q5 = Q.f24695a;
                    String string = getString(S1.i.device_supported_abis_split_selector);
                    kotlin.jvm.internal.t.d(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{sb2.toString()}, 1));
                    kotlin.jvm.internal.t.d(format, "format(...)");
                    textView5.setText(format);
                }
            }
            textView5.setVisibility(8);
        } else {
            recyclerView.setVisibility(8);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
            inflate.findViewById(S1.f.separator_abis_split_selector).setVisibility(8);
        }
        TextView textView6 = (TextView) inflate.findViewById(S1.f.tv_label_dpi_dialog_splits);
        k.a aVar2 = S1.k.f32g;
        textView6.setTypeface(aVar2.w());
        TextView textView7 = (TextView) inflate.findViewById(S1.f.tv_device_supported_pdis_dialog_splits);
        textView7.setTypeface(aVar2.x());
        View findViewById2 = inflate.findViewById(S1.f.rv_dpi_dialog_splits);
        kotlin.jvm.internal.t.d(findViewById2, "findViewById(...)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        if (g5.n().size() > 0) {
            recyclerView2.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView2.addItemDecoration(new C2303w((int) getResources().getDimension(S1.d.margin_generic_item_recyclerview)));
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
            recyclerView2.setAdapter(new C2207c(g5.n(), new e(g5)));
            Q q6 = Q.f24695a;
            String string2 = getString(S1.i.device_supported_dpis_split_selector);
            kotlin.jvm.internal.t.d(string2, "getString(...)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{getString(S1.i.dpi_device)}, 1));
            kotlin.jvm.internal.t.d(format2, "format(...)");
            textView7.setText(format2);
        } else {
            recyclerView2.setVisibility(8);
            textView6.setVisibility(8);
            textView7.setVisibility(8);
            inflate.findViewById(S1.f.separator_dpis_split_selector).setVisibility(8);
        }
        TextView textView8 = (TextView) inflate.findViewById(S1.f.tv_label_lang_dialog_splits);
        textView8.setTypeface(aVar2.w());
        TextView textView9 = (TextView) inflate.findViewById(S1.f.tv_device_lang_dialog_splits);
        textView9.setTypeface(aVar2.x());
        View findViewById3 = inflate.findViewById(S1.f.rv_lang_dialog_splits);
        kotlin.jvm.internal.t.d(findViewById3, "findViewById(...)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById3;
        if (g5.p().size() > 0) {
            recyclerView3.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView3.addItemDecoration(new C2303w((int) getResources().getDimension(S1.d.margin_generic_item_recyclerview)));
            recyclerView3.setItemAnimator(new DefaultItemAnimator());
            recyclerView3.setAdapter(new C2207c(g5.p(), new g(g5)));
            textView9.setText(getString(S1.i.device_lang_split_selector));
        } else {
            recyclerView3.setVisibility(8);
            textView8.setVisibility(8);
            textView9.setVisibility(8);
            inflate.findViewById(S1.f.separator_lang_split_selector).setVisibility(8);
        }
        TextView textView10 = (TextView) inflate.findViewById(S1.f.tv_label_features_dialog_splits);
        textView10.setTypeface(aVar2.w());
        TextView textView11 = (TextView) inflate.findViewById(S1.f.tv_device_features_dialog_splits);
        textView11.setTypeface(aVar2.x());
        View findViewById4 = inflate.findViewById(S1.f.rv_features_dialog_splits);
        kotlin.jvm.internal.t.d(findViewById4, "findViewById(...)");
        RecyclerView recyclerView4 = (RecyclerView) findViewById4;
        if (g5.o().size() > 0) {
            recyclerView4.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            recyclerView4.addItemDecoration(new C2303w((int) getResources().getDimension(S1.d.margin_generic_item_recyclerview)));
            recyclerView4.setItemAnimator(new DefaultItemAnimator());
            recyclerView4.setAdapter(new C2207c(g5.o(), new f(g5)));
        } else {
            recyclerView4.setVisibility(8);
            textView10.setVisibility(8);
            textView11.setVisibility(8);
            inflate.findViewById(S1.f.separator_features_split_selector).setVisibility(8);
        }
        TextView textView12 = (TextView) inflate.findViewById(S1.f.tv_install_dialog_splits);
        textView12.setTypeface(aVar2.w());
        textView12.setOnClickListener(new C2180l0(this, g5));
        TextView textView13 = (TextView) inflate.findViewById(S1.f.tv_cancel_dialog_splits);
        textView13.setTypeface(aVar2.w());
        textView13.setOnClickListener(new C2182m0(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(true);
        this.f21050O = builder.create();
        if (!isFinishing()) {
            AlertDialog alertDialog3 = this.f21050O;
            if (!(alertDialog3 == null || (window = alertDialog3.getWindow()) == null)) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog alertDialog4 = this.f21050O;
            if (alertDialog4 != null) {
                alertDialog4.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void E1(InstallerActivity installerActivity, C2275G g5, View view) {
        AlertDialog alertDialog = installerActivity.f21050O;
        kotlin.jvm.internal.t.b(alertDialog);
        alertDialog.dismiss();
        installerActivity.P1(installerActivity, g5.C());
    }

    /* access modifiers changed from: private */
    public static final void F1(InstallerActivity installerActivity, View view) {
        AlertDialog alertDialog = installerActivity.f21050O;
        kotlin.jvm.internal.t.b(alertDialog);
        alertDialog.dismiss();
        installerActivity.v1();
    }

    private final void G1() {
        InstallerActivity installerActivity;
        TextView textView;
        ImageView imageView;
        setContentView(S1.g.installer_activity);
        try {
            this.f21056U = false;
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                this.f21047L = data;
                if (data != null) {
                    C2290j jVar = new C2290j();
                    Uri uri = this.f21047L;
                    kotlin.jvm.internal.t.b(uri);
                    this.f21044I = jVar.j(uri, this);
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (extras.containsKey("realPath")) {
                        this.f21046K = extras.getString("realPath");
                    }
                    if (extras.containsKey("newFeatures")) {
                        this.f21059X = extras.getString("newFeatures");
                    }
                    if (extras.containsKey("requireUserAction")) {
                        this.f21060Y = extras.getBoolean("requireUserAction");
                    }
                    if (extras.containsKey("action")) {
                        this.f21049N = extras.getString("action");
                    }
                    if (extras.containsKey("notificationId")) {
                        w1(this, extras.getInt("notificationId"));
                    }
                    if (extras.containsKey("backgroundInstallation")) {
                        this.f21061Z = extras.getBoolean("backgroundInstallation");
                    }
                }
            }
            this.f21069s = (RelativeLayout) findViewById(S1.f.rl_logo_app_detail);
            this.f21057V = (LinearLayout) findViewById(S1.f.ll_installer_activity);
            ImageView imageView2 = (ImageView) findViewById(S1.f.iv_hide_installer_activity);
            this.f21043H = imageView2;
            kotlin.jvm.internal.t.b(imageView2);
            imageView2.setOnClickListener(new w0(this));
            this.f21042G = (ImageView) findViewById(S1.f.iv_logo_apk_installer_activity);
            TextView textView2 = (TextView) findViewById(S1.f.tv_app_name_installer_activity);
            this.f21073w = textView2;
            if (textView2 != null) {
                textView2.setTypeface(S1.k.f32g.w());
            }
            String str = this.f21044I;
            if (str != null) {
                TextView textView3 = this.f21075y;
                if (textView3 != null) {
                    textView3.setText(str);
                }
                String str2 = this.f21044I;
                kotlin.jvm.internal.t.b(str2);
                if (t3.s.D(str2, ".apk", false, 2, (Object) null)) {
                    ImageView imageView3 = this.f21042G;
                    if (imageView3 != null) {
                        imageView3.setImageResource(S1.e.core_vector_apk);
                    }
                } else {
                    String str3 = this.f21044I;
                    kotlin.jvm.internal.t.b(str3);
                    if (t3.s.D(str3, ".xapk", false, 2, (Object) null) && (imageView = this.f21042G) != null) {
                        imageView.setImageResource(S1.e.core_vector_xapk);
                    }
                }
            } else {
                String str4 = this.f21046K;
                if (!(str4 == null || (textView = this.f21075y) == null)) {
                    kotlin.jvm.internal.t.b(str4);
                    String str5 = this.f21046K;
                    kotlin.jvm.internal.t.b(str5);
                    String substring = str4.substring(t3.s.l0(str5, "/", 0, false, 6, (Object) null) + 1);
                    kotlin.jvm.internal.t.d(substring, "substring(...)");
                    textView.setText(substring);
                }
            }
            this.f21074x = (LinearLayout) findViewById(S1.f.ll_info_installer_activity);
            TextView textView4 = (TextView) findViewById(S1.f.tv_file_name_label_installer_activity);
            if (textView4 != null) {
                textView4.setTypeface(S1.k.f32g.x());
            }
            TextView textView5 = (TextView) findViewById(S1.f.tv_file_name_installer_activity);
            this.f21075y = textView5;
            if (textView5 != null) {
                textView5.setTypeface(S1.k.f32g.w());
            }
            TextView textView6 = (TextView) findViewById(S1.f.tv_size_label_installer_activity);
            if (textView6 != null) {
                textView6.setTypeface(S1.k.f32g.x());
            }
            TextView textView7 = (TextView) findViewById(S1.f.tv_size_installer_activity);
            this.f21076z = textView7;
            if (textView7 != null) {
                textView7.setTypeface(S1.k.f32g.w());
            }
            TextView textView8 = (TextView) findViewById(S1.f.tv_version_label_installer_activity);
            if (textView8 != null) {
                textView8.setTypeface(S1.k.f32g.x());
            }
            TextView textView9 = (TextView) findViewById(S1.f.tv_version_installer_activity);
            this.f21036A = textView9;
            if (textView9 != null) {
                textView9.setTypeface(S1.k.f32g.w());
            }
            ProgressBar progressBar = (ProgressBar) findViewById(S1.f.pb_installer_activity);
            this.f21065p = progressBar;
            kotlin.jvm.internal.t.b(progressBar);
            progressBar.setInterpolator(new AccelerateDecelerateInterpolator());
            TextView textView10 = (TextView) findViewById(S1.f.tv_msg_info_installer_activity);
            this.f21067q = textView10;
            if (textView10 != null) {
                textView10.setTypeface(S1.k.f32g.x());
            }
            TextView textView11 = (TextView) findViewById(S1.f.tv_msg_installer_activity);
            this.f21039D = textView11;
            if (textView11 != null) {
                textView11.setTypeface(S1.k.f32g.x());
            }
            TextView textView12 = (TextView) findViewById(S1.f.tv_install_installer_activity);
            this.f21040E = textView12;
            if (textView12 != null) {
                textView12.setTypeface(S1.k.f32g.w());
            }
            TextView textView13 = this.f21040E;
            if (textView13 != null) {
                textView13.setVisibility(8);
            }
            TextView textView14 = this.f21040E;
            if (textView14 != null) {
                textView14.setOnClickListener(new x0(this));
            }
            TextView textView15 = (TextView) findViewById(S1.f.tv_cancel_installer_activity);
            this.f21041F = textView15;
            if (textView15 != null) {
                textView15.setTypeface(S1.k.f32g.w());
            }
            TextView textView16 = this.f21041F;
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
            TextView textView17 = this.f21041F;
            if (textView17 != null) {
                textView17.setOnClickListener(new y0(this));
            }
            String str6 = this.f21059X;
            if (str6 == null || str6.length() == 0) {
                installerActivity = this;
            } else {
                TextView textView18 = this.f21067q;
                kotlin.jvm.internal.t.b(textView18);
                textView18.setVisibility(8);
                I i5 = new I();
                LinearLayout linearLayout = (LinearLayout) findViewById(S1.f.ll_show_version_new_features);
                TextView textView19 = (TextView) findViewById(S1.f.tv_version_new_features);
                ImageView imageView4 = (ImageView) findViewById(S1.f.iv_version_new_features);
                k.a aVar = S1.k.f32g;
                textView19.setTypeface(aVar.w());
                TextView textView20 = (TextView) findViewById(S1.f.tv_version_new_features_content);
                textView20.setTypeface(aVar.x());
                textView20.setText(this.f21059X);
                textView20.setVisibility(8);
                ((LinearLayout) findViewById(S1.f.ll_version_new_features)).setVisibility(0);
                installerActivity = this;
                try {
                    linearLayout.setOnClickListener(new z0(i5, textView19, installerActivity, imageView4, textView20));
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                }
            }
            M1();
            String str7 = installerActivity.f21049N;
            if (str7 == null || !t3.s.E(str7, "delete", true)) {
                installerActivity.f21052Q = W1();
                if (!(installerActivity.f21047L == null || installerActivity.f21044I == null)) {
                    C2290j jVar2 = new C2290j();
                    String str8 = installerActivity.f21044I;
                    kotlin.jvm.internal.t.b(str8);
                    if (jVar2.o(str8)) {
                        Uri uri2 = installerActivity.f21047L;
                        kotlin.jvm.internal.t.b(uri2);
                        String str9 = installerActivity.f21044I;
                        kotlin.jvm.internal.t.b(str9);
                        U1(uri2, str9);
                        return;
                    }
                }
                b2(installerActivity.f21046K);
                return;
            }
            LinearLayout linearLayout2 = installerActivity.f21057V;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            RelativeLayout relativeLayout = installerActivity.f21069s;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            TextView textView21 = installerActivity.f21039D;
            if (textView21 != null) {
                textView21.setVisibility(8);
            }
            ImageView imageView5 = installerActivity.f21043H;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            TextView textView22 = installerActivity.f21075y;
            if (textView22 != null) {
                textView22.setText(getString(S1.i.dialog_delete_download_msg, new Object[]{installerActivity.f21046K}));
            }
            TextView textView23 = installerActivity.f21041F;
            if (textView23 != null) {
                textView23.setAllCaps(true);
            }
            TextView textView24 = installerActivity.f21040E;
            if (textView24 != null) {
                textView24.setAllCaps(true);
            }
            TextView textView25 = installerActivity.f21040E;
            if (textView25 != null) {
                textView25.setVisibility(0);
            }
            TextView textView26 = installerActivity.f21040E;
            if (textView26 != null) {
                textView26.setText(S1.i.option_button_delete);
            }
            TextView textView27 = installerActivity.f21040E;
            if (textView27 != null) {
                textView27.setTag(installerActivity.f21046K);
            }
            TextView textView28 = installerActivity.f21040E;
            if (textView28 != null) {
                textView28.setOnClickListener(new A0(this));
            }
            TextView textView29 = installerActivity.f21041F;
            if (textView29 != null) {
                textView29.setVisibility(0);
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static final void H1(InstallerActivity installerActivity, View view) {
        CharSequence charSequence;
        TextView textView = installerActivity.f21073w;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        String valueOf = String.valueOf(charSequence);
        Bundle bundle = new Bundle();
        bundle.putString("appNameAndVersion", valueOf);
        Application application = installerActivity.getApplication();
        kotlin.jvm.internal.t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((S1.k) application).R().send(222, bundle);
        installerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void I1(InstallerActivity installerActivity, View view) {
        TextView textView = installerActivity.f21040E;
        if (textView != null) {
            textView.setVisibility(8);
        }
        installerActivity.b2(installerActivity.f21046K);
    }

    /* access modifiers changed from: private */
    public static final void J1(InstallerActivity installerActivity, View view) {
        installerActivity.v1();
    }

    /* access modifiers changed from: private */
    public static final void K1(I i5, TextView textView, InstallerActivity installerActivity, ImageView imageView, TextView textView2, View view) {
        if (!i5.f24687a) {
            textView.setText(installerActivity.getString(S1.i.core_installer_new_features_title_hide));
            imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, S1.e.vector_arrow_angle_up_small_off));
            textView2.setVisibility(0);
            i5.f24687a = true;
            return;
        }
        textView.setText(installerActivity.getString(S1.i.core_installer_new_features_title));
        imageView.setImageDrawable(ContextCompat.getDrawable(installerActivity, S1.e.vector_arrow_angle_down_small_off));
        textView2.setVisibility(8);
        i5.f24687a = false;
    }

    /* access modifiers changed from: private */
    public static final void L1(InstallerActivity installerActivity, View view) {
        kotlin.jvm.internal.t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Object tag = view.getTag();
        kotlin.jvm.internal.t.c(tag, "null cannot be cast to non-null type kotlin.String");
        String str = (String) tag;
        TextView textView = installerActivity.f21040E;
        if (textView != null) {
            textView.setVisibility(8);
        }
        new File(str).delete();
        installerActivity.finish();
    }

    private final void M1() {
        this.f21054S = new h(this);
        this.f21055T = new i(this);
    }

    private final void N1(File file) {
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
        new C2292l(applicationContext, this.f21054S).z(file, this.f21060Y);
    }

    private final boolean R1(File file) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        return S1(arrayList);
    }

    private final boolean S1(ArrayList arrayList) {
        try {
            if (new C2201a(this).P() && arrayList.size() == 1) {
                String name = ((File) arrayList.get(0)).getName();
                kotlin.jvm.internal.t.d(name, "getName(...)");
                if (t3.s.D(name, ".apk", false, 2, (Object) null)) {
                    PackageManager packageManager = getPackageManager();
                    kotlin.jvm.internal.t.d(packageManager, "getPackageManager(...)");
                    String absolutePath = ((File) arrayList.get(0)).getAbsolutePath();
                    kotlin.jvm.internal.t.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = C2301u.c(packageManager, absolutePath, 0);
                    if (c5 != null) {
                        PackageManager packageManager2 = getPackageManager();
                        kotlin.jvm.internal.t.d(packageManager2, "getPackageManager(...)");
                        String str = c5.packageName;
                        kotlin.jvm.internal.t.d(str, "packageName");
                        if (new C2290j().m(C2301u.d(packageManager2, str, 0)) == new C2290j().m(c5)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private final void T1() {
        if (this.f21053R == null) {
            this.f21053R = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new j(this, (C2308e) null), 3, (Object) null);
        }
    }

    private final void U1(Uri uri, String str) {
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new k(this, uri, str, (C2308e) null), 3, (Object) null);
    }

    private final void V1(String str) {
        X1.m mVar = this.f21055T;
        kotlin.jvm.internal.t.b(mVar);
        new C2210c(this, str, mVar, X());
    }

    private final ArrayList W1() {
        String string = getString(S1.i.app_name);
        kotlin.jvm.internal.t.d(string, "getString(...)");
        ArrayList arrayList = new ArrayList();
        try {
            String[] stringArray = getResources().getStringArray(S1.b.messages_info);
            kotlin.jvm.internal.t.d(stringArray, "getStringArray(...)");
            for (String str : stringArray) {
                kotlin.jvm.internal.t.b(str);
                if (str.length() > 0) {
                    if (t3.s.V(str, "%s", false, 2, (Object) null)) {
                        arrayList.add(t3.s.L(str, "%s", string, false, 4, (Object) null));
                    } else {
                        arrayList.add(str);
                    }
                }
            }
            for (String str2 : getResources().getStringArray(S1.b.messages_info_core)) {
                kotlin.jvm.internal.t.b(str2);
                if (str2.length() > 0) {
                    if (t3.s.V(str2, "%s", false, 2, (Object) null)) {
                        arrayList.add(t3.s.L(str2, "%s", string, false, 4, (Object) null));
                    } else {
                        arrayList.add(str2);
                    }
                }
            }
            return arrayList;
        } catch (Resources.NotFoundException e5) {
            e5.printStackTrace();
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    public final Object X1(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new l(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void Y1(InstallerActivity installerActivity, View view) {
        Application application = installerActivity.getApplication();
        kotlin.jvm.internal.t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((S1.k) application).R().send(225, (Bundle) null);
        installerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void Z1(InstallerActivity installerActivity, View view) {
        Application application = installerActivity.getApplication();
        kotlin.jvm.internal.t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((S1.k) application).R().send(226, (Bundle) null);
        installerActivity.G1();
    }

    private final void b2(String str) {
        if (str == null || !new File(str).exists()) {
            String string = getString(S1.i.installable_files_not_found);
            kotlin.jvm.internal.t.d(string, "getString(...)");
            u0(string);
            finish();
        } else if (new File(str).isDirectory()) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                C2250q.v(arrayList, listFiles);
                a2((File) null, arrayList);
            }
        } else if (C2279K.f20490b.a(str)) {
            V1(str);
        } else if (t3.s.D(str, ".apk", false, 2, (Object) null)) {
            O1(this, new File(str));
        } else {
            String string2 = getString(S1.i.installable_files_not_found);
            kotlin.jvm.internal.t.d(string2, "getString(...)");
            u0(string2);
            finish();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (w3.C2872g.g(r9, r4, r0) != r1) goto L_0x007a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c2(android.net.Uri r7, java.lang.String r8, b3.C2308e r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.uptodown.core.activities.InstallerActivity.n
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.core.activities.InstallerActivity$n r0 = (com.uptodown.core.activities.InstallerActivity.n) r0
            int r1 = r0.f21107f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f21107f = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.InstallerActivity$n r0 = new com.uptodown.core.activities.InstallerActivity$n
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f21105d
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f21107f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r9)
            goto L_0x007a
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.f21104c
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.f21103b
            android.net.Uri r7 = (android.net.Uri) r7
            java.lang.Object r2 = r0.f21102a
            com.uptodown.core.activities.InstallerActivity r2 = (com.uptodown.core.activities.InstallerActivity) r2
            W2.u.b(r9)
            goto L_0x0062
        L_0x0046:
            W2.u.b(r9)
            w3.I0 r9 = w3.C2865c0.c()
            com.uptodown.core.activities.InstallerActivity$o r2 = new com.uptodown.core.activities.InstallerActivity$o
            r2.<init>(r6, r5)
            r0.f21102a = r6
            r0.f21103b = r7
            r0.f21104c = r8
            r0.f21107f = r4
            java.lang.Object r9 = w3.C2872g.g(r9, r2, r0)
            if (r9 != r1) goto L_0x0061
            goto L_0x0079
        L_0x0061:
            r2 = r6
        L_0x0062:
            w3.I r9 = w3.C2865c0.b()
            com.uptodown.core.activities.InstallerActivity$p r4 = new com.uptodown.core.activities.InstallerActivity$p
            r4.<init>(r8, r2, r7, r5)
            r0.f21102a = r5
            r0.f21103b = r5
            r0.f21104c = r5
            r0.f21107f = r3
            java.lang.Object r7 = w3.C2872g.g(r9, r4, r0)
            if (r7 != r1) goto L_0x007a
        L_0x0079:
            return r1
        L_0x007a:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.c2(android.net.Uri, java.lang.String, b3.e):java.lang.Object");
    }

    private final void d2() {
        String str = this.f21046K;
        if (str != null) {
            ApplicationInfo applicationInfo = null;
            if (t3.s.D(str, ".apk", false, 2, (Object) null)) {
                PackageManager packageManager = getPackageManager();
                kotlin.jvm.internal.t.b(packageManager);
                String str2 = this.f21046K;
                kotlin.jvm.internal.t.b(str2);
                PackageInfo c5 = C2301u.c(packageManager, str2, 128);
                if (c5 != null) {
                    applicationInfo = c5.applicationInfo;
                }
                if (applicationInfo != null) {
                    LinearLayout linearLayout = this.f21074x;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    C2290j jVar = new C2290j();
                    ApplicationInfo applicationInfo2 = c5.applicationInfo;
                    kotlin.jvm.internal.t.b(applicationInfo2);
                    String str3 = this.f21046K;
                    kotlin.jvm.internal.t.b(str3);
                    String b5 = jVar.b(applicationInfo2, str3, packageManager);
                    long m5 = new C2290j().m(c5);
                    C2289i iVar = new C2289i();
                    String str4 = this.f21046K;
                    kotlin.jvm.internal.t.b(str4);
                    long j5 = iVar.j(str4);
                    k.a aVar = S1.k.f32g;
                    String str5 = c5.packageName;
                    kotlin.jvm.internal.t.d(str5, "packageName");
                    aVar.B(str5, m5, b5, j5);
                    if (!this.f21061Z) {
                        String str6 = this.f21046K;
                        kotlin.jvm.internal.t.b(str6);
                        File file = new File(str6);
                        ImageView imageView = this.f21042G;
                        if (imageView != null) {
                            C2290j jVar2 = new C2290j();
                            String str7 = this.f21046K;
                            kotlin.jvm.internal.t.b(str7);
                            imageView.setImageDrawable(jVar2.h(this, str7));
                        }
                        TextView textView = this.f21073w;
                        if (textView != null) {
                            textView.setText(b5);
                        }
                        TextView textView2 = this.f21073w;
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                        }
                        TextView textView3 = this.f21075y;
                        if (textView3 != null) {
                            textView3.setText(file.getName());
                        }
                        TextView textView4 = this.f21075y;
                        if (textView4 != null) {
                            textView4.setVisibility(0);
                        }
                        TextView textView5 = this.f21076z;
                        if (textView5 != null) {
                            textView5.setText(new C2291k().c(j5));
                        }
                        TextView textView6 = this.f21076z;
                        if (textView6 != null) {
                            textView6.setVisibility(0);
                        }
                        TextView textView7 = this.f21036A;
                        if (textView7 != null) {
                            textView7.setText(c5.versionName);
                        }
                        TextView textView8 = this.f21036A;
                        if (textView8 != null) {
                            textView8.setVisibility(0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void f2(InstallerActivity installerActivity, View view) {
        installerActivity.v1();
    }

    /* access modifiers changed from: private */
    public static final void h2(InstallerActivity installerActivity) {
        installerActivity.d2();
        if (!installerActivity.f21061Z) {
            installerActivity.k2();
        } else {
            installerActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void j2(InstallerActivity installerActivity, int i5) {
        installerActivity.T1();
        TextView textView = installerActivity.f21041F;
        if (textView != null) {
            textView.setVisibility(0);
        }
        LinearLayout linearLayout = installerActivity.f21057V;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView2 = installerActivity.f21039D;
        if (textView2 != null) {
            textView2.setText(installerActivity.getString(S1.i.unzipping_status, new Object[]{Integer.valueOf(i5)}));
        }
        ProgressBar progressBar = installerActivity.f21065p;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        ProgressBar progressBar2 = installerActivity.f21065p;
        if (progressBar2 != null) {
            progressBar2.setProgress(i5);
        }
        installerActivity.getWindow().addFlags(128);
        ImageView imageView = installerActivity.f21043H;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private final void k2() {
        runOnUiThread(new v0(this));
    }

    /* access modifiers changed from: private */
    public static final void l2(InstallerActivity installerActivity) {
        installerActivity.T1();
        LinearLayout linearLayout = installerActivity.f21057V;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = installerActivity.f21039D;
        if (textView != null) {
            textView.setText(S1.i.installing);
        }
        ProgressBar progressBar = installerActivity.f21065p;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
        installerActivity.getWindow().addFlags(128);
        ImageView imageView = installerActivity.f21043H;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView2 = installerActivity.f21041F;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private final void m2(ArrayList arrayList) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f21051P;
        if (alertDialog2 != null) {
            kotlin.jvm.internal.t.b(alertDialog2);
            if (alertDialog2.isShowing()) {
                AlertDialog alertDialog3 = this.f21051P;
                kotlin.jvm.internal.t.b(alertDialog3);
                alertDialog3.dismiss();
            }
        }
        Window window = null;
        View inflate = getLayoutInflater().inflate(S1.g.dialog_installed_version, (ViewGroup) null, false);
        k.a aVar = S1.k.f32g;
        ((TextView) inflate.findViewById(S1.f.tv_msg_installed_version)).setTypeface(aVar.x());
        CheckBox checkBox = (CheckBox) inflate.findViewById(S1.f.cb_not_again_installed_version);
        checkBox.setTypeface(aVar.x());
        TextView textView = (TextView) inflate.findViewById(S1.f.tv_install);
        textView.setTypeface(aVar.w());
        textView.setOnClickListener(new C2176j0(this, checkBox, arrayList));
        TextView textView2 = (TextView) inflate.findViewById(S1.f.tv_cancel);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C2178k0(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        this.f21051P = create;
        if (create != null) {
            window = create.getWindow();
        }
        kotlin.jvm.internal.t.b(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (!isFinishing() && (alertDialog = this.f21051P) != null) {
            alertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void n2(InstallerActivity installerActivity, CheckBox checkBox, ArrayList arrayList, View view) {
        installerActivity.f21056U = true;
        AlertDialog alertDialog = installerActivity.f21051P;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (checkBox.isChecked()) {
            new C2201a(installerActivity).L(false);
        }
        installerActivity.P1(installerActivity, arrayList);
    }

    /* access modifiers changed from: private */
    public static final void o2(InstallerActivity installerActivity, View view) {
        AlertDialog alertDialog = installerActivity.f21051P;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        installerActivity.v1();
    }

    /* access modifiers changed from: private */
    public final void v1() {
        C2279K k5 = this.f21048M;
        if (k5 != null) {
            k5.b();
        }
        S1.k.f32g.b();
        ArrayList arrayList = this.f21045J;
        if (arrayList != null) {
            kotlin.jvm.internal.t.b(arrayList);
            Iterator it = arrayList.iterator();
            kotlin.jvm.internal.t.d(it, "iterator(...)");
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null && file.exists()) {
                    file.delete();
                }
            }
        }
        finish();
    }

    private final void w1(Context context, int i5) {
        Object systemService = context.getSystemService("notification");
        kotlin.jvm.internal.t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i5);
    }

    private final void x1(File file) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(S1.i.warning_title));
        builder.setMessage(S1.i.msg_dialog_install_auto);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) new C2188p0(this, file));
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) new C2190q0(this, file));
        builder.create().show();
    }

    private final void y1(ArrayList arrayList) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(S1.i.warning_title));
        builder.setMessage(S1.i.msg_dialog_install_auto);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) new C2184n0(this, arrayList));
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) new C2186o0(this, arrayList));
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public static final void z1(InstallerActivity installerActivity, File file, DialogInterface dialogInterface, int i5) {
        C2201a aVar = new C2201a(installerActivity);
        aVar.O(true);
        aVar.D(true);
        installerActivity.O1(installerActivity, file);
    }

    public final void O1(Activity activity, File file) {
        kotlin.jvm.internal.t.e(activity, "activity");
        kotlin.jvm.internal.t.e(file, "file");
        C2201a aVar = new C2201a(activity);
        boolean m5 = aVar.m();
        boolean t5 = aVar.t();
        if (!this.f21056U && R1(file)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            m2(arrayList);
        } else if (!m5 && !t5) {
            N1(file);
        } else if (!aVar.u()) {
            x1(file);
        } else if (!aVar.n()) {
            N1(file);
        } else if (aVar.m()) {
            C2302v.a aVar2 = C2302v.f20755a;
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.t.d(absolutePath, "getAbsolutePath(...)");
            aVar2.b(absolutePath, activity, this.f21066p0);
        } else if (aVar.t()) {
            new C2278J(activity, this.f21064o0).f(file);
        }
    }

    public final void P1(Activity activity, ArrayList arrayList) {
        kotlin.jvm.internal.t.e(activity, "activity");
        kotlin.jvm.internal.t.e(arrayList, "files");
        C2201a aVar = new C2201a(activity);
        boolean m5 = aVar.m();
        boolean t5 = aVar.t();
        if (!this.f21056U && S1(arrayList)) {
            m2(arrayList);
        } else if ((m5 || t5) && !aVar.u()) {
            y1(arrayList);
        } else {
            k2();
            new C2292l(activity, this.f21054S).A(arrayList, this.f21060Y);
        }
    }

    public final void Q1(String str) {
        if (!(str == null || str.length() == 0)) {
            u0(str);
        }
        v1();
    }

    public final void a2(File file, ArrayList arrayList) {
        String str;
        kotlin.jvm.internal.t.e(arrayList, "files");
        if (new C2201a(this).s()) {
            if (file != null) {
                str = file.getName();
            } else {
                str = null;
            }
            D1(str, arrayList);
            return;
        }
        C2275G g5 = new C2275G(this);
        g5.B(arrayList);
        P1(this, g5.C());
    }

    public void c0() {
    }

    public void d0() {
    }

    public void e0() {
    }

    public final void e2(String str) {
        kotlin.jvm.internal.t.e(str, NotificationCompat.CATEGORY_MESSAGE);
        TextView textView = this.f21039D;
        if (textView != null) {
            textView.setText(str);
        }
        ProgressBar progressBar = this.f21065p;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        getWindow().clearFlags(128);
        C2908y0 y0Var = this.f21053R;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        TextView textView2 = this.f21067q;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.f21041F;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.f21041F;
        if (textView4 != null) {
            textView4.setOnClickListener(new u0(this));
        }
        u0(str);
    }

    public void f0() {
    }

    public final void g2() {
        runOnUiThread(new t0(this));
    }

    public void h0() {
    }

    public final void i2(int i5) {
        runOnUiThread(new C2191r0(this, i5));
    }

    public void l0() {
        X1.m mVar;
        if (X() && !new File("/Android/obb").canRead() && (mVar = this.f21055T) != null) {
            mVar.f();
        }
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        k.a aVar = S1.k.f32g;
        if (aVar.i() == null && aVar.j() == null) {
            G1();
        } else {
            setContentView(S1.g.installer_activity_dialog);
            this.f21058W = true;
            Application application = getApplication();
            kotlin.jvm.internal.t.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
            String str = null;
            ((S1.k) application).R().send(224, (Bundle) null);
            TextView textView2 = (TextView) findViewById(S1.f.tv_header_ready_to_install);
            this.f21068r = textView2;
            kotlin.jvm.internal.t.b(textView2);
            textView2.setTypeface(aVar.w());
            this.f21070t = (ImageView) findViewById(S1.f.iv_app_to_install);
            TextView textView3 = (TextView) findViewById(S1.f.tv_app_to_install_name);
            this.f21071u = textView3;
            kotlin.jvm.internal.t.b(textView3);
            textView3.setTypeface(aVar.w());
            TextView textView4 = (TextView) findViewById(S1.f.tv_app_to_install_filename);
            this.f21072v = textView4;
            kotlin.jvm.internal.t.b(textView4);
            textView4.setTypeface(aVar.x());
            TextView textView5 = (TextView) findViewById(S1.f.tv_installation_in_progress_title);
            this.f21037B = textView5;
            kotlin.jvm.internal.t.b(textView5);
            textView5.setTypeface(aVar.x());
            TextView textView6 = (TextView) findViewById(S1.f.tv_cancel_installer_activity);
            this.f21041F = textView6;
            kotlin.jvm.internal.t.b(textView6);
            textView6.setTypeface(aVar.w());
            TextView textView7 = this.f21041F;
            kotlin.jvm.internal.t.b(textView7);
            textView7.setOnClickListener(new C2174i0(this));
            TextView textView8 = (TextView) findViewById(S1.f.tv_install_installer_activity);
            this.f21040E = textView8;
            kotlin.jvm.internal.t.b(textView8);
            textView8.setTypeface(aVar.w());
            TextView textView9 = this.f21040E;
            kotlin.jvm.internal.t.b(textView9);
            textView9.setOnClickListener(new C2193s0(this));
            this.f21065p = (ProgressBar) findViewById(S1.f.pb_installer_activity);
            TextView textView10 = (TextView) findViewById(S1.f.tv_installation_in_progress_filename);
            this.f21038C = textView10;
            kotlin.jvm.internal.t.b(textView10);
            textView10.setTypeface(aVar.x());
            C2257a i5 = aVar.i();
            if (i5 != null) {
                str = i5.a();
            }
            if (!(str == null || (textView = this.f21038C) == null)) {
                textView.setText(str);
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f21063n0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C2908y0 y0Var = this.f21053R;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        getWindow().clearFlags(128);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LinearLayout linearLayout;
        super.onResume();
        if (S1.k.f32g.i() == null && (linearLayout = this.f21057V) != null && linearLayout.getVisibility() == 0 && this.f21049N == null) {
            finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (w3.C2872g.g(r9, r6, r0) != r1) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p2(int r8, b3.C2308e r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.uptodown.core.activities.InstallerActivity.r
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.core.activities.InstallerActivity$r r0 = (com.uptodown.core.activities.InstallerActivity.r) r0
            int r1 = r0.f21123f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f21123f = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.InstallerActivity$r r0 = new com.uptodown.core.activities.InstallerActivity$r
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f21121d
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f21123f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r9)
            goto L_0x007a
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            int r8 = r0.f21120c
            java.lang.Object r2 = r0.f21119b
            kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
            java.lang.Object r4 = r0.f21118a
            com.uptodown.core.activities.InstallerActivity r4 = (com.uptodown.core.activities.InstallerActivity) r4
            W2.u.b(r9)
            goto L_0x0064
        L_0x0043:
            W2.u.b(r9)
            kotlin.jvm.internal.L r2 = new kotlin.jvm.internal.L
            r2.<init>()
            w3.I r9 = w3.C2865c0.b()
            com.uptodown.core.activities.InstallerActivity$s r6 = new com.uptodown.core.activities.InstallerActivity$s
            r6.<init>(r7, r2, r5)
            r0.f21118a = r7
            r0.f21119b = r2
            r0.f21120c = r8
            r0.f21123f = r4
            java.lang.Object r9 = w3.C2872g.g(r9, r6, r0)
            if (r9 != r1) goto L_0x0063
            goto L_0x0079
        L_0x0063:
            r4 = r7
        L_0x0064:
            w3.I0 r9 = w3.C2865c0.c()
            com.uptodown.core.activities.InstallerActivity$t r6 = new com.uptodown.core.activities.InstallerActivity$t
            r6.<init>(r4, r8, r2, r5)
            r0.f21118a = r5
            r0.f21119b = r5
            r0.f21123f = r3
            java.lang.Object r8 = w3.C2872g.g(r9, r6, r0)
            if (r8 != r1) goto L_0x007a
        L_0x0079:
            return r1
        L_0x007a:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.p2(int, b3.e):java.lang.Object");
    }
}
