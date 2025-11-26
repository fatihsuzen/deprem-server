package com.uptodown.activities;

import B2.v;
import O1.C0786g;
import O1.C0794h;
import O1.C0818k;
import O1.C0826l;
import O1.T2;
import O1.r;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import Y1.C2257a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C2291k;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2388j;
import h2.C2411f;
import h2.C2445w0;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2610u;
import k3.p;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2645E;
import l2.C2655d;
import l2.C2657f;
import l2.C2660i;
import l2.C2668q;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.C2966z;

public final class AppInstalledDetailsActivity extends T2 {

    /* renamed from: m0  reason: collision with root package name */
    public static final a f13599m0 = new a((C2633k) null);

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f13600W = m.b(new C0818k(this));
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public C2655d f13601X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public C2657f f13602Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public ArrayList f13603Z;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13604a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13605b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f13606a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppInstalledDetailsActivity f13607b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ T f13608c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C2668q f13609d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(AppInstalledDetailsActivity appInstalledDetailsActivity, T t5, C2668q qVar, C2308e eVar) {
                super(2, eVar);
                this.f13607b = appInstalledDetailsActivity;
                this.f13608c = t5;
                this.f13609d = qVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f13607b, this.f13608c, this.f13609d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f13606a == 0) {
                    u.b(obj);
                    this.f13607b.s5().f23040q0.setTypeface(S1.k.f32g.w());
                    this.f13607b.G5(this.f13608c.h());
                    C2668q qVar = this.f13609d;
                    if (qVar == null || !qVar.f()) {
                        this.f13607b.s5().f23040q0.setText(this.f13607b.getString(R.string.updates_button_download_app));
                        TextView textView = this.f13607b.s5().f23040q0;
                        t.d(textView, "tvUpdateAida");
                        v.a(textView);
                    } else {
                        this.f13607b.s5().f23040q0.setText(this.f13607b.getString(R.string.action_update));
                        TextView textView2 = this.f13607b.s5().f23040q0;
                        t.d(textView2, "tvUpdateAida");
                        v.c(textView2);
                    }
                    if (UptodownApp.f13477F.O(this.f13608c.h())) {
                        this.f13607b.J5();
                        this.f13607b.s5().f23008a0.setText(this.f13607b.getString(R.string.status_download_update_pending));
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
        b(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13605b = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13605b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2668q qVar;
            Object f5 = C2316b.f();
            int i5 = this.f13604a;
            if (i5 == 0) {
                u.b(obj);
                C2940B.a aVar = C2940B.f26458v;
                Context applicationContext = this.f13605b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                C2940B a5 = aVar.a(applicationContext);
                a5.a();
                C2655d e5 = this.f13605b.f13601X;
                t.b(e5);
                String o5 = e5.o();
                t.b(o5);
                T G02 = a5.G0(o5);
                if (G02 != null) {
                    Context applicationContext2 = this.f13605b.getApplicationContext();
                    t.d(applicationContext2, "getApplicationContext(...)");
                    qVar = G02.b(applicationContext2);
                } else {
                    qVar = null;
                }
                a5.m();
                if (G02 != null && !G02.m()) {
                    I0 c5 = C2865c0.c();
                    a aVar2 = new a(this.f13605b, G02, qVar, (C2308e) null);
                    this.f13604a = 1;
                    if (C2872g.g(c5, aVar2, this) == f5) {
                        return f5;
                    }
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13610a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13611b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13612c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13611b = str;
            this.f13612c = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13611b, this.f13612c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13610a == 0) {
                u.b(obj);
                if (t.a(this.f13611b, "app_updated")) {
                    this.f13612c.u5();
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class d implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13613a;

        d(AppInstalledDetailsActivity appInstalledDetailsActivity) {
            this.f13613a = appInstalledDetailsActivity;
        }

        public void c(C2657f fVar) {
            C2660i h5;
            t.e(fVar, "appInfo");
            this.f13613a.f13602Y = fVar;
            if (!this.f13613a.isFinishing() && (h5 = fVar.h()) != null && h5.j() == 1) {
                this.f13613a.s5().f23002V.setText(this.f13613a.getString(R.string.app_detail_play_button));
            }
        }

        public void d(int i5) {
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f13614a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f13615b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13616c;

        /* renamed from: d  reason: collision with root package name */
        int f13617d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(eVar);
            this.f13616c = appInstalledDetailsActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f13615b = obj;
            this.f13617d |= Integer.MIN_VALUE;
            return this.f13616c.t5(this);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13618a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13619b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13619b = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13619b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            PackageInfo packageInfo;
            PermissionInfo[] permissionInfoArr;
            C2316b.f();
            if (this.f13618a == 0) {
                u.b(obj);
                try {
                    PackageManager packageManager = this.f13619b.getPackageManager();
                    t.d(packageManager, "getPackageManager(...)");
                    C2655d e5 = this.f13619b.f13601X;
                    t.b(e5);
                    String o5 = e5.o();
                    t.b(o5);
                    packageInfo = C2301u.d(packageManager, o5, 4096);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (!(packageInfo == null || (permissionInfoArr = packageInfo.permissions) == null)) {
                    this.f13619b.f13603Z = new ArrayList();
                    Iterator a5 = C2625c.a(permissionInfoArr);
                    while (a5.hasNext()) {
                        PermissionInfo permissionInfo = (PermissionInfo) a5.next();
                        C2645E e6 = new C2645E();
                        e6.c(String.valueOf(permissionInfo.loadDescription(this.f13619b.getPackageManager())));
                        e6.d(permissionInfo.name);
                        ArrayList g5 = this.f13619b.f13603Z;
                        t.b(g5);
                        g5.add(e6);
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13620a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13621b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13621b = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f13621b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i5;
            C2316b.f();
            if (this.f13620a == 0) {
                u.b(obj);
                if (this.f13621b.f13603Z != null) {
                    ArrayList g5 = this.f13621b.f13603Z;
                    t.b(g5);
                    if (g5.size() > 0) {
                        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f13621b;
                        ArrayList g52 = appInstalledDetailsActivity.f13603Z;
                        t.b(g52);
                        LinearLayout linearLayout = this.f13621b.s5().f23043s;
                        t.d(linearLayout, "llPermissionsAida");
                        appInstalledDetailsActivity.F5(g52, linearLayout);
                        ArrayList g53 = this.f13621b.f13603Z;
                        t.b(g53);
                        i5 = g53.size();
                        this.f13621b.s5().f23005Y.setText(String.valueOf(i5));
                        return J.f19942a;
                    }
                }
                this.f13621b.s5().f22981A.setVisibility(8);
                i5 = 0;
                this.f13621b.s5().f23005Y.setText(String.valueOf(i5));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13622a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13623b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13623b = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f13623b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13622a;
            if (i5 == 0) {
                u.b(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f13623b;
                this.f13622a = 1;
                if (appInstalledDetailsActivity.t5(this) == f5) {
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
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13625b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13625b = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f13625b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13624a;
            if (i5 == 0) {
                u.b(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f13625b;
                this.f13624a = 1;
                if (appInstalledDetailsActivity.p5(this) == f5) {
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
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13626a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13627b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppInstalledDetailsActivity appInstalledDetailsActivity, C2308e eVar) {
            super(2, eVar);
            this.f13627b = appInstalledDetailsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f13627b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13626a;
            if (i5 == 0) {
                u.b(obj);
                AppInstalledDetailsActivity appInstalledDetailsActivity = this.f13627b;
                this.f13626a = 1;
                if (appInstalledDetailsActivity.p5(this) == f5) {
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

    public static final class k implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f13628a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13629b;

        k(CharSequence charSequence, AppInstalledDetailsActivity appInstalledDetailsActivity) {
            this.f13628a = charSequence;
            this.f13629b = appInstalledDetailsActivity;
        }

        /* access modifiers changed from: private */
        public static final void b(AppInstalledDetailsActivity appInstalledDetailsActivity, C2657f fVar, View view) {
            if (UptodownApp.f13477F.Z()) {
                appInstalledDetailsActivity.H2(fVar.e());
            }
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            SpannableString a5 = C2966z.f26564d.a(String.valueOf(this.f13628a));
            if (this.f13628a != null) {
                float dimension = this.f13629b.getResources().getDimension(R.dimen.text_size_m);
                Typeface x4 = S1.k.f32g.x();
                t.b(x4);
                a5.setSpan(new C2966z(dimension, x4, ContextCompat.getColor(this.f13629b, R.color.blue_primary)), 0, this.f13628a.length(), 33);
            }
            this.f13629b.s5().f23042r0.setText(a5);
            this.f13629b.s5().f23042r0.setOnClickListener(new r(this.f13629b, fVar));
        }

        public void d(int i5) {
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13630a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppInstalledDetailsActivity f13631b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f13632c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13633d;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f13634a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f13635b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ AppInstalledDetailsActivity f13636c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f13637d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C2668q f13638e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int i5, AppInstalledDetailsActivity appInstalledDetailsActivity, String str, C2668q qVar, C2308e eVar) {
                super(2, eVar);
                this.f13635b = i5;
                this.f13636c = appInstalledDetailsActivity;
                this.f13637d = str;
                this.f13638e = qVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f13635b, this.f13636c, this.f13637d, this.f13638e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f13634a == 0) {
                    u.b(obj);
                    switch (this.f13635b) {
                        case 102:
                            AppInstalledDetailsActivity appInstalledDetailsActivity = this.f13636c;
                            String string = appInstalledDetailsActivity.getString(R.string.descarga_error);
                            t.d(string, "getString(...)");
                            appInstalledDetailsActivity.u0(string);
                            break;
                        case 103:
                        case 106:
                            AppInstalledDetailsActivity appInstalledDetailsActivity2 = this.f13636c;
                            String str = this.f13637d;
                            t.b(str);
                            appInstalledDetailsActivity2.G5(str);
                            TextView textView = this.f13636c.s5().f23008a0;
                            textView.setText(this.f13636c.getString(R.string.zero) + this.f13636c.getString(R.string.percent));
                            this.f13636c.s5().f23047u.setProgress(0);
                            break;
                        case 107:
                            this.f13636c.J5();
                            this.f13636c.s5().f23008a0.setText(this.f13636c.getString(R.string.status_download_update_pending));
                            break;
                        case 108:
                            AppInstalledDetailsActivity appInstalledDetailsActivity3 = this.f13636c;
                            String str2 = this.f13637d;
                            t.b(str2);
                            appInstalledDetailsActivity3.G5(str2);
                            C2668q qVar = this.f13638e;
                            if (qVar != null && qVar.f()) {
                                this.f13636c.s5().f23040q0.setText(this.f13636c.getString(R.string.action_update));
                                TextView textView2 = this.f13636c.s5().f23040q0;
                                t.d(textView2, "tvUpdateAida");
                                v.c(textView2);
                                break;
                            }
                        default:
                            this.f13636c.s5().f23047u.setIndeterminate(false);
                            if (this.f13638e == null) {
                                this.f13636c.u5();
                                break;
                            } else {
                                this.f13636c.J5();
                                this.f13636c.s5().f23047u.setProgress(this.f13638e.x());
                                this.f13636c.s5().f23008a0.setText(this.f13636c.getString(R.string.percent_of_total_size, new Object[]{kotlin.coroutines.jvm.internal.b.b(this.f13638e.x()), new C2291k().d(this.f13638e.z(), this.f13636c)}));
                                break;
                            }
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
        l(AppInstalledDetailsActivity appInstalledDetailsActivity, int i5, String str, C2308e eVar) {
            super(2, eVar);
            this.f13631b = appInstalledDetailsActivity;
            this.f13632c = i5;
            this.f13633d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new l(this.f13631b, this.f13632c, this.f13633d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2668q qVar;
            Object f5 = C2316b.f();
            int i5 = this.f13630a;
            if (i5 == 0) {
                u.b(obj);
                C2940B.a aVar = C2940B.f26458v;
                Context applicationContext = this.f13631b.getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                C2940B a5 = aVar.a(applicationContext);
                a5.a();
                C2655d e5 = this.f13631b.f13601X;
                t.b(e5);
                String o5 = e5.o();
                t.b(o5);
                T G02 = a5.G0(o5);
                if (G02 != null) {
                    Context applicationContext2 = this.f13631b.getApplicationContext();
                    t.d(applicationContext2, "getApplicationContext(...)");
                    qVar = G02.b(applicationContext2);
                } else {
                    qVar = null;
                }
                C2668q qVar2 = qVar;
                a5.m();
                I0 c5 = C2865c0.c();
                a aVar2 = new a(this.f13632c, this.f13631b, this.f13633d, qVar2, (C2308e) null);
                this.f13630a = 1;
                if (C2872g.g(c5, aVar2, this) == f5) {
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
            return ((l) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final void A5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        S1.j jVar = new S1.j(appInstalledDetailsActivity);
        C2655d dVar = appInstalledDetailsActivity.f13601X;
        t.b(dVar);
        String o5 = dVar.o();
        t.b(o5);
        jVar.h(o5);
        appInstalledDetailsActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void B5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        Intent intent = new Intent(appInstalledDetailsActivity, AppFilesActivity.class);
        intent.putExtra("appInstalled", appInstalledDetailsActivity.f13601X);
        appInstalledDetailsActivity.startActivity(intent, UptodownApp.f13477F.a(appInstalledDetailsActivity));
    }

    /* access modifiers changed from: private */
    public static final void C5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        if (appInstalledDetailsActivity.s5().f23043s.getVisibility() == 0) {
            appInstalledDetailsActivity.s5().f23043s.setVisibility(8);
            appInstalledDetailsActivity.s5().f23023i.setImageResource(R.drawable.vector_add);
            return;
        }
        appInstalledDetailsActivity.s5().f23043s.setVisibility(0);
        appInstalledDetailsActivity.s5().f23023i.setImageResource(R.drawable.vector_remove);
        appInstalledDetailsActivity.s5().f22989I.post(new C0794h(appInstalledDetailsActivity));
    }

    /* access modifiers changed from: private */
    public static final void D5(AppInstalledDetailsActivity appInstalledDetailsActivity) {
        appInstalledDetailsActivity.s5().f22989I.smoothScrollTo(0, appInstalledDetailsActivity.s5().f22981A.getTop());
    }

    /* access modifiers changed from: private */
    public static final void E5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        if (appInstalledDetailsActivity.f13602Y != null) {
            Intent intent = new Intent(appInstalledDetailsActivity, AppDetailActivity.class);
            intent.putExtra("appInfo", appInstalledDetailsActivity.f13602Y);
            appInstalledDetailsActivity.startActivity(intent, UptodownApp.f13477F.a(appInstalledDetailsActivity));
            return;
        }
        appInstalledDetailsActivity.r5();
    }

    /* access modifiers changed from: private */
    public final void F5(ArrayList arrayList, LinearLayout linearLayout) {
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C2445w0 c5 = C2445w0.c(LayoutInflater.from(getApplicationContext()));
            t.d(c5, "inflate(...)");
            c5.f23654b.setTypeface(S1.k.f32g.x());
            c5.f23654b.setText(((C2645E) arrayList.get(i5)).b());
            linearLayout.addView(c5.getRoot());
        }
    }

    /* access modifiers changed from: private */
    public final void G5(String str) {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = s5().f23047u;
        t.d(progressBar, "pbProgressAida");
        ImageView imageView = s5().f23015e;
        t.d(imageView, "ivLogoAida");
        cVar.c(progressBar, imageView);
        s5().f23008a0.setVisibility(0);
        s5().f23048u0.setVisibility(0);
        s5().f23039q.setVisibility(8);
        s5().f23040q0.setText(getString(R.string.updates_button_download_app));
        TextView textView = s5().f23040q0;
        t.d(textView, "tvUpdateAida");
        v.a(textView);
        s5().f23040q0.setOnClickListener(new C0786g(this, str));
        s5().f23040q0.setVisibility(0);
        s5().f22996P.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void H5(AppInstalledDetailsActivity appInstalledDetailsActivity, String str, View view) {
        appInstalledDetailsActivity.H4(appInstalledDetailsActivity.f13601X);
        if (UptodownApp.f13477F.O(str)) {
            appInstalledDetailsActivity.J5();
            appInstalledDetailsActivity.s5().f23008a0.setText(appInstalledDetailsActivity.getString(R.string.status_download_update_pending));
            return;
        }
        appInstalledDetailsActivity.I5();
    }

    private final void I5() {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = s5().f23047u;
        t.d(progressBar, "pbProgressAida");
        ImageView imageView = s5().f23015e;
        t.d(imageView, "ivLogoAida");
        cVar.e(progressBar, imageView);
        s5().f23047u.setIndeterminate(true);
        s5().f23039q.setVisibility(0);
        s5().f23048u0.setVisibility(0);
        s5().f23008a0.setVisibility(8);
        s5().f23040q0.setVisibility(8);
        s5().f22996P.setVisibility(8);
        s5().f22986F.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void J5() {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = s5().f23047u;
        t.d(progressBar, "pbProgressAida");
        ImageView imageView = s5().f23015e;
        t.d(imageView, "ivLogoAida");
        cVar.e(progressBar, imageView);
        s5().f23039q.setVisibility(0);
        s5().f23048u0.setVisibility(8);
        s5().f22996P.setOnClickListener(new C0826l(this));
        s5().f23040q0.setVisibility(8);
        s5().f22996P.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void K5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        C2655d dVar = appInstalledDetailsActivity.f13601X;
        t.b(dVar);
        String o5 = dVar.o();
        t.b(o5);
        aVar.d0(o5);
    }

    /* access modifiers changed from: private */
    public static final C2411f o5(AppInstalledDetailsActivity appInstalledDetailsActivity) {
        return C2411f.c(appInstalledDetailsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final Object p5(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void r5() {
        if (this.f13602Y == null) {
            C2655d dVar = this.f13601X;
            t.b(dVar);
            if (dVar.b() > 0) {
                C2655d dVar2 = this.f13601X;
                t.b(dVar2);
                new C2388j(this, dVar2.b(), new d(this), LifecycleOwnerKt.getLifecycleScope(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public final C2411f s5() {
        return (C2411f) this.f13600W.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (w3.C2872g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t5(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.activities.AppInstalledDetailsActivity.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.activities.AppInstalledDetailsActivity$e r0 = (com.uptodown.activities.AppInstalledDetailsActivity.e) r0
            int r1 = r0.f13617d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f13617d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.AppInstalledDetailsActivity$e r0 = new com.uptodown.activities.AppInstalledDetailsActivity$e
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f13615b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f13617d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f13614a
            com.uptodown.activities.AppInstalledDetailsActivity r2 = (com.uptodown.activities.AppInstalledDetailsActivity) r2
            W2.u.b(r7)
            goto L_0x0055
        L_0x003d:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()
            com.uptodown.activities.AppInstalledDetailsActivity$f r2 = new com.uptodown.activities.AppInstalledDetailsActivity$f
            r2.<init>(r6, r5)
            r0.f13614a = r6
            r0.f13617d = r4
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            com.uptodown.activities.AppInstalledDetailsActivity$g r4 = new com.uptodown.activities.AppInstalledDetailsActivity$g
            r4.<init>(r2, r5)
            r0.f13614a = r5
            r0.f13617d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.t5(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void u5() {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = s5().f23047u;
        t.d(progressBar, "pbProgressAida");
        ImageView imageView = s5().f23015e;
        t.d(imageView, "ivLogoAida");
        cVar.c(progressBar, imageView);
        s5().f23039q.setVisibility(8);
        s5().f23040q0.setVisibility(8);
        s5().f22986F.setVisibility(8);
        s5().f23048u0.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void v5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        appInstalledDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void w5(View view) {
    }

    private final void x5() {
        s5().f22989I.setVisibility(8);
        s5().f23001U.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02b1 A[SYNTHETIC, Splitter:B:41:0x02b1] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0474  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x04d1  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x05a5  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x05d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y5() {
        /*
            r13 = this;
            z2.P r0 = z2.P.f26510a
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.o()
            android.graphics.drawable.Drawable r0 = r0.j(r13, r1)
            h2.f r1 = r13.s5()
            android.widget.ImageView r1 = r1.f23015e
            r1.setImageDrawable(r0)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22992L
            l2.d r2 = r13.f13601X
            kotlin.jvm.internal.t.b(r2)
            java.lang.String r2 = r2.m()
            r1.setText(r2)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22992L
            S1.k$a r2 = S1.k.f32g
            android.graphics.Typeface r3 = r2.w()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23048u0
            l2.d r3 = r13.f13601X
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.B()
            r1.setText(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23048u0
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23032m0
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23036o0
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23008a0
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23046t0
            android.graphics.Typeface r3 = r2.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22996P
            android.graphics.Typeface r3 = r2.w()
            r1.setTypeface(r3)
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.o()
            java.lang.String r3 = r13.getPackageName()
            boolean r1 = kotlin.jvm.internal.t.a(r1, r3)
            r3 = 1
            r4 = 8
            if (r1 != 0) goto L_0x00d3
            l2.f r1 = r13.f13602Y
            if (r1 == 0) goto L_0x00dc
            kotlin.jvm.internal.t.b(r1)
            l2.i r1 = r1.h()
            if (r1 == 0) goto L_0x00dc
            int r1 = r1.j()
            if (r1 != r3) goto L_0x00dc
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23002V
            r5 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r5 = r13.getString(r5)
            r1.setText(r5)
            goto L_0x00dc
        L_0x00d3:
            h2.f r1 = r13.s5()
            android.widget.LinearLayout r1 = r1.f23037p
            r1.setVisibility(r4)
        L_0x00dc:
            b2.j r1 = new b2.j
            r1.<init>()
            l2.d r5 = r13.f13601X
            kotlin.jvm.internal.t.b(r5)
            java.lang.String r5 = r5.o()
            kotlin.jvm.internal.t.b(r5)
            boolean r1 = r1.p(r13, r5)
            r5 = 0
            if (r1 == 0) goto L_0x00fd
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23032m0
            r1.setVisibility(r5)
        L_0x00fd:
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23002V
            android.graphics.Typeface r6 = r2.w()
            r1.setTypeface(r6)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23002V
            O1.m r6 = new O1.m
            r6.<init>(r13)
            r1.setOnClickListener(r6)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23038p0
            android.graphics.Typeface r6 = r2.w()
            r1.setTypeface(r6)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23038p0
            O1.n r6 = new O1.n
            r6.<init>(r13)
            r1.setOnClickListener(r6)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22991K
            android.graphics.Typeface r6 = r2.w()
            r1.setTypeface(r6)
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.o()
            java.lang.String r6 = ""
            if (r1 == 0) goto L_0x0189
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.o()
            boolean r1 = t3.s.E(r1, r6, r3)
            if (r1 != 0) goto L_0x0189
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23004X
            android.graphics.Typeface r7 = r2.w()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23003W
            android.graphics.Typeface r7 = r2.x()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23003W
            l2.d r7 = r13.f13601X
            kotlin.jvm.internal.t.b(r7)
            java.lang.String r7 = r7.o()
            r1.setText(r7)
            goto L_0x0192
        L_0x0189:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f23057z
            r1.setVisibility(r4)
        L_0x0192:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            long r7 = r1.A()
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x01d2
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23052w0
            android.graphics.Typeface r7 = r2.w()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23050v0
            android.graphics.Typeface r7 = r2.x()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23050v0
            l2.d r7 = r13.f13601X
            kotlin.jvm.internal.t.b(r7)
            long r7 = r7.A()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r1.setText(r7)
            goto L_0x01db
        L_0x01d2:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22988H
            r1.setVisibility(r4)
        L_0x01db:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f23049v
            r1.setVisibility(r4)
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            long r7 = r1.g()
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x0227
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22998R
            android.graphics.Typeface r7 = r2.w()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22997Q
            android.graphics.Typeface r7 = r2.x()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22997Q
            z2.v r7 = new z2.v
            r7.<init>()
            l2.d r8 = r13.f13601X
            kotlin.jvm.internal.t.b(r8)
            long r11 = r8.g()
            java.lang.String r7 = r7.o(r11)
            r1.setText(r7)
            goto L_0x0230
        L_0x0227:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f23051w
            r1.setVisibility(r4)
        L_0x0230:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            long r7 = r1.j()
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x0273
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23000T
            android.graphics.Typeface r7 = r2.w()
            r1.setTypeface(r7)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22999S
            android.graphics.Typeface r2 = r2.x()
            r1.setTypeface(r2)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f22999S
            z2.v r2 = new z2.v
            r2.<init>()
            l2.d r7 = r13.f13601X
            kotlin.jvm.internal.t.b(r7)
            long r7 = r7.j()
            java.lang.String r2 = r2.o(r7)
            r1.setText(r2)
            goto L_0x027c
        L_0x0273:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f23053x
            r1.setVisibility(r4)
        L_0x027c:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.o()
            r2 = 0
            if (r1 == 0) goto L_0x02a5
            int r1 = r1.length()
            if (r1 != 0) goto L_0x028f
            goto L_0x02a5
        L_0x028f:
            z2.m r1 = new z2.m
            r1.<init>()
            l2.d r7 = r13.f13601X
            kotlin.jvm.internal.t.b(r7)
            java.lang.String r7 = r7.o()
            kotlin.jvm.internal.t.b(r7)
            java.lang.String r1 = r1.h(r13, r7)
            goto L_0x02a6
        L_0x02a5:
            r1 = r2
        L_0x02a6:
            java.lang.String r7 = "getPackageManager(...)"
            if (r1 == 0) goto L_0x0306
            int r8 = r1.length()
            if (r8 != 0) goto L_0x02b1
            goto L_0x0306
        L_0x02b1:
            android.content.pm.PackageManager r8 = r13.getPackageManager()     // Catch:{ Exception -> 0x02bd }
            kotlin.jvm.internal.t.d(r8, r7)     // Catch:{ Exception -> 0x02bd }
            android.content.pm.PackageInfo r8 = b2.C2301u.d(r8, r1, r5)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02c2
        L_0x02bd:
            r8 = move-exception
            r8.printStackTrace()
            r8 = r2
        L_0x02c2:
            if (r8 == 0) goto L_0x02e9
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo
            if (r8 == 0) goto L_0x02d1
            android.content.pm.PackageManager r11 = r13.getPackageManager()
            java.lang.CharSequence r8 = r8.loadLabel(r11)
            goto L_0x02d2
        L_0x02d1:
            r8 = r2
        L_0x02d2:
            h2.f r11 = r13.s5()
            android.widget.TextView r11 = r11.f23042r0
            r11.setText(r8)
            g2.k r11 = new g2.k
            com.uptodown.activities.AppInstalledDetailsActivity$k r12 = new com.uptodown.activities.AppInstalledDetailsActivity$k
            r12.<init>(r8, r13)
            androidx.lifecycle.LifecycleCoroutineScope r8 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r13)
            r11.<init>(r13, r1, r12, r8)
        L_0x02e9:
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23044s0
            S1.k$a r8 = S1.k.f32g
            android.graphics.Typeface r11 = r8.w()
            r1.setTypeface(r11)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23042r0
            android.graphics.Typeface r8 = r8.x()
            r1.setTypeface(r8)
            goto L_0x030f
        L_0x0306:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22987G
            r1.setVisibility(r4)
        L_0x030f:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            int r1 = r1.l()
            if (r1 == 0) goto L_0x034d
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23012c0
            S1.k$a r8 = S1.k.f32g
            android.graphics.Typeface r11 = r8.w()
            r1.setTypeface(r11)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23010b0
            android.graphics.Typeface r8 = r8.x()
            r1.setTypeface(r8)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23010b0
            l2.d r8 = r13.f13601X
            kotlin.jvm.internal.t.b(r8)
            int r8 = r8.l()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r1.setText(r8)
            goto L_0x0356
        L_0x034d:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22982B
            r1.setVisibility(r4)
        L_0x0356:
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23020g0
            S1.k$a r8 = S1.k.f32g
            android.graphics.Typeface r11 = r8.w()
            r1.setTypeface(r11)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23018f0
            android.graphics.Typeface r11 = r8.x()
            r1.setTypeface(r11)
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.util.ArrayList r1 = r1.v()
            if (r1 == 0) goto L_0x038f
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.util.ArrayList r1 = r1.v()
            kotlin.jvm.internal.t.b(r1)
            int r1 = r1.size()
            int r1 = r1 + r3
            goto L_0x0390
        L_0x038f:
            r1 = r3
        L_0x0390:
            l2.d r11 = r13.f13601X
            kotlin.jvm.internal.t.b(r11)
            java.util.ArrayList r11 = r11.n()
            if (r11 == 0) goto L_0x03ac
            l2.d r11 = r13.f13601X
            kotlin.jvm.internal.t.b(r11)
            java.util.ArrayList r11 = r11.n()
            kotlin.jvm.internal.t.b(r11)
            int r11 = r11.size()
            int r1 = r1 + r11
        L_0x03ac:
            if (r1 <= r3) goto L_0x03f2
            h2.f r6 = r13.s5()
            android.widget.TextView r6 = r6.f23020g0
            r11 = 2131951713(0x7f130061, float:1.9539848E38)
            java.lang.String r11 = r13.getString(r11)
            r6.setText(r11)
            h2.f r6 = r13.s5()
            android.widget.TextView r6 = r6.f23018f0
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r1
            r1 = 2131951716(0x7f130064, float:1.9539854E38)
            java.lang.String r1 = r13.getString(r1, r3)
            r6.setText(r1)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23054x0
            android.graphics.Typeface r3 = r8.w()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23054x0
            O1.o r3 = new O1.o
            r3.<init>(r13)
            r1.setOnClickListener(r3)
            goto L_0x0431
        L_0x03f2:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.r()
            if (r1 == 0) goto L_0x0428
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.r()
            boolean r1 = t3.s.E(r1, r6, r3)
            if (r1 != 0) goto L_0x0428
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23018f0
            l2.d r3 = r13.f13601X
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.r()
            r1.setText(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23054x0
            r1.setVisibility(r4)
            goto L_0x0431
        L_0x0428:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22983C
            r1.setVisibility(r4)
        L_0x0431:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            long r11 = r1.t()
            int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x0474
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23030l0
            android.graphics.Typeface r3 = r8.w()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23028k0
            android.graphics.Typeface r3 = r8.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23028k0
            b2.k r3 = new b2.k
            r3.<init>()
            l2.d r6 = r13.f13601X
            kotlin.jvm.internal.t.b(r6)
            long r11 = r6.t()
            java.lang.String r3 = r3.d(r11, r13)
            r1.setText(r3)
            goto L_0x047d
        L_0x0474:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22985E
            r1.setVisibility(r4)
        L_0x047d:
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.o()
            if (r1 == 0) goto L_0x04ab
            int r1 = r1.length()
            if (r1 != 0) goto L_0x048f
            goto L_0x04ab
        L_0x048f:
            z2.m r1 = new z2.m
            r1.<init>()
            android.content.pm.PackageManager r2 = r13.getPackageManager()
            kotlin.jvm.internal.t.d(r2, r7)
            l2.d r3 = r13.f13601X
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r3 = r3.o()
            kotlin.jvm.internal.t.b(r3)
            java.lang.String r2 = r1.i(r2, r3)
        L_0x04ab:
            if (r2 == 0) goto L_0x04d1
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23026j0
            android.graphics.Typeface r3 = r8.w()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23024i0
            android.graphics.Typeface r3 = r8.x()
            r1.setTypeface(r3)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23024i0
            r1.setText(r2)
            goto L_0x04da
        L_0x04d1:
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22984D
            r1.setVisibility(r4)
        L_0x04da:
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23006Z
            android.graphics.Typeface r2 = r8.w()
            r1.setTypeface(r2)
            h2.f r1 = r13.s5()
            android.widget.TextView r1 = r1.f23005Y
            android.graphics.Typeface r2 = r8.x()
            r1.setTypeface(r2)
            h2.f r1 = r13.s5()
            android.widget.RelativeLayout r1 = r1.f22981A
            O1.p r2 = new O1.p
            r2.<init>(r13)
            r1.setOnClickListener(r2)
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            long r1 = r1.b()
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x056d
            h2.f r1 = r13.s5()
            android.widget.ImageView r1 = r1.f23017f
            r1.setImageDrawable(r0)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f22993M
            l2.d r1 = r13.f13601X
            kotlin.jvm.internal.t.b(r1)
            java.lang.String r1 = r1.m()
            r0.setText(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f22993M
            android.graphics.Typeface r1 = r8.w()
            r0.setTypeface(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23014d0
            android.graphics.Typeface r1 = r8.w()
            r0.setTypeface(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23016e0
            android.graphics.Typeface r1 = r8.w()
            r0.setTypeface(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23022h0
            android.graphics.Typeface r1 = r8.x()
            r0.setTypeface(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23014d0
            O1.q r1 = new O1.q
            r1.<init>(r13)
            r0.setOnClickListener(r1)
            goto L_0x059a
        L_0x056d:
            h2.f r0 = r13.s5()
            android.widget.ImageView r0 = r0.f23017f
            r0.setVisibility(r4)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f22993M
            r0.setVisibility(r4)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23014d0
            r0.setVisibility(r4)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23022h0
            r0.setVisibility(r4)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23016e0
            r0.setVisibility(r4)
        L_0x059a:
            l2.d r0 = r13.f13601X
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.H()
            if (r0 == 0) goto L_0x05d1
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23036o0
            r1 = 2131952726(0x7f130456, float:1.9541903E38)
            java.lang.String r1 = r13.getString(r1)
            r0.setText(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23036o0
            r0.setVisibility(r5)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23002V
            r0.setVisibility(r4)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23038p0
            r0.setVisibility(r4)
            goto L_0x05fe
        L_0x05d1:
            l2.d r0 = r13.f13601X
            kotlin.jvm.internal.t.b(r0)
            boolean r0 = r0.F()
            if (r0 == 0) goto L_0x05fe
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23036o0
            r1 = 2131952724(0x7f130454, float:1.9541899E38)
            java.lang.String r1 = r13.getString(r1)
            r0.setText(r1)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23036o0
            r0.setVisibility(r5)
            h2.f r0 = r13.s5()
            android.widget.TextView r0 = r0.f23038p0
            r0.setVisibility(r4)
        L_0x05fe:
            h2.f r0 = r13.s5()
            android.view.View r0 = r0.f23045t
            r0.setVisibility(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.y5():void");
    }

    /* access modifiers changed from: private */
    public static final void z5(AppInstalledDetailsActivity appInstalledDetailsActivity, View view) {
        PackageManager packageManager = appInstalledDetailsActivity.getPackageManager();
        C2655d dVar = appInstalledDetailsActivity.f13601X;
        t.b(dVar);
        String o5 = dVar.o();
        t.b(o5);
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(o5);
        if (launchIntentForPackage != null) {
            appInstalledDetailsActivity.startActivity(launchIntentForPackage);
        }
    }

    public final Object L5(int i5, String str, C2308e eVar) {
        C2655d dVar = this.f13601X;
        t.b(dVar);
        if (!t.a(str, dVar.o())) {
            return J.f19942a;
        }
        Object g5 = C2872g.g(C2865c0.b(), new l(this, i5, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public void M4() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            super.onCreate(r15)
            h2.f r15 = r14.s5()
            android.widget.RelativeLayout r15 = r15.getRoot()
            r14.setContentView((android.view.View) r15)
            android.content.Intent r15 = r14.getIntent()
            if (r15 == 0) goto L_0x0059
            android.os.Bundle r15 = r15.getExtras()
            r0 = 33
            if (r15 == 0) goto L_0x0039
            java.lang.String r1 = "appInstalled"
            boolean r2 = r15.containsKey(r1)
            if (r2 == 0) goto L_0x0039
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r0) goto L_0x0031
            java.lang.Class<l2.d> r2 = l2.C2655d.class
            java.lang.Object r1 = r15.getParcelable(r1, r2)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            goto L_0x0035
        L_0x0031:
            android.os.Parcelable r1 = r15.getParcelable(r1)
        L_0x0035:
            l2.d r1 = (l2.C2655d) r1
            r14.f13601X = r1
        L_0x0039:
            kotlin.jvm.internal.t.b(r15)
            java.lang.String r1 = "appInfo"
            boolean r2 = r15.containsKey(r1)
            if (r2 == 0) goto L_0x0059
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r0) goto L_0x0051
            java.lang.Class<l2.f> r0 = l2.C2657f.class
            java.lang.Object r15 = r15.getParcelable(r1, r0)
            android.os.Parcelable r15 = (android.os.Parcelable) r15
            goto L_0x0055
        L_0x0051:
            android.os.Parcelable r15 = r15.getParcelable(r1)
        L_0x0055:
            l2.f r15 = (l2.C2657f) r15
            r14.f13602Y = r15
        L_0x0059:
            r14.r5()
            h2.f r15 = r14.s5()
            android.widget.TextView r0 = r15.f23034n0
            S1.k$a r1 = S1.k.f32g
            android.graphics.Typeface r2 = r1.w()
            r0.setTypeface(r2)
            r0 = 2131230921(0x7f0800c9, float:1.8077908E38)
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r14, r0)
            if (r0 == 0) goto L_0x0085
            androidx.appcompat.widget.Toolbar r2 = r15.f22990J
            r2.setNavigationIcon((android.graphics.drawable.Drawable) r0)
            androidx.appcompat.widget.Toolbar r0 = r15.f22990J
            r2 = 2131951735(0x7f130077, float:1.9539893E38)
            java.lang.String r2 = r14.getString(r2)
            r0.setNavigationContentDescription((java.lang.CharSequence) r2)
        L_0x0085:
            androidx.appcompat.widget.Toolbar r0 = r15.f22990J
            O1.i r2 = new O1.i
            r2.<init>(r14)
            r0.setNavigationOnClickListener(r2)
            android.widget.TextView r0 = r15.f23001U
            android.graphics.Typeface r1 = r1.x()
            r0.setTypeface(r1)
            android.view.View r0 = r15.f23045t
            O1.j r1 = new O1.j
            r1.<init>()
            r0.setOnClickListener(r1)
            android.view.View r15 = r15.f23045t
            r0 = 0
            r15.setVisibility(r0)
            r15 = 0
            l2.d r0 = r14.f13601X     // Catch:{ NameNotFoundException -> 0x00d9 }
            if (r0 == 0) goto L_0x00dd
            kotlin.jvm.internal.t.b(r0)     // Catch:{ NameNotFoundException -> 0x00d9 }
            java.lang.String r0 = r0.o()     // Catch:{ NameNotFoundException -> 0x00d9 }
            if (r0 == 0) goto L_0x00dd
            int r0 = r0.length()     // Catch:{ NameNotFoundException -> 0x00d9 }
            if (r0 != 0) goto L_0x00bd
            goto L_0x00dd
        L_0x00bd:
            android.content.pm.PackageManager r0 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00d9 }
            java.lang.String r1 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r0, r1)     // Catch:{ NameNotFoundException -> 0x00d9 }
            l2.d r1 = r14.f13601X     // Catch:{ NameNotFoundException -> 0x00d9 }
            kotlin.jvm.internal.t.b(r1)     // Catch:{ NameNotFoundException -> 0x00d9 }
            java.lang.String r1 = r1.o()     // Catch:{ NameNotFoundException -> 0x00d9 }
            kotlin.jvm.internal.t.b(r1)     // Catch:{ NameNotFoundException -> 0x00d9 }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = b2.C2301u.a(r0, r1, r2)     // Catch:{ NameNotFoundException -> 0x00d9 }
            goto L_0x00de
        L_0x00d9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00dd:
            r0 = r15
        L_0x00de:
            if (r0 == 0) goto L_0x0120
            z2.B$a r1 = z2.C2940B.f26458v
            z2.B r1 = r1.a(r14)
            r1.a()
            l2.d r2 = r14.f13601X
            kotlin.jvm.internal.t.b(r2)
            r2.J(r0, r1)
            l2.d r0 = r14.f13601X
            kotlin.jvm.internal.t.b(r0)
            r0.I(r1)
            r1.m()
            r14.y5()
            androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r14)
            com.uptodown.activities.AppInstalledDetailsActivity$h r5 = new com.uptodown.activities.AppInstalledDetailsActivity$h
            r5.<init>(r14, r15)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            w3.C2908y0 unused = w3.C2876i.d(r2, r3, r4, r5, r6, r7)
            androidx.lifecycle.LifecycleCoroutineScope r8 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r14)
            com.uptodown.activities.AppInstalledDetailsActivity$i r11 = new com.uptodown.activities.AppInstalledDetailsActivity$i
            r11.<init>(r14, r15)
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            w3.C2908y0 unused = w3.C2876i.d(r8, r9, r10, r11, r12, r13)
            goto L_0x0123
        L_0x0120:
            r14.x5()
        L_0x0123:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        if (this.f13601X != null) {
            C2257a i5 = S1.k.f32g.i();
            if (i5 != null) {
                str = i5.b();
            } else {
                str = null;
            }
            C2655d dVar = this.f13601X;
            t.b(dVar);
            if (s.E(str, dVar.o(), true)) {
                s5().f23047u.setIndeterminate(true);
                B2.c cVar = B2.c.f17333a;
                ProgressBar progressBar = s5().f23047u;
                t.d(progressBar, "pbProgressAida");
                ImageView imageView = s5().f23015e;
                t.d(imageView, "ivLogoAida");
                cVar.e(progressBar, imageView);
                return;
            }
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new j(this, (C2308e) null), 3, (Object) null);
        }
    }

    public final Object q5(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new c(str, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
