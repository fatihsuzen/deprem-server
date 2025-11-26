package com.uptodown.activities;

import O1.C0762d;
import O1.C0770e;
import O1.C0778f;
import R1.C0970a;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b2.C2286f;
import b2.C2301u;
import b2.C2303w;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2392n;
import h2.C2409e;
import java.io.File;
import java.util.ArrayList;
import k2.C2593c;
import k2.Z;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2673w;
import l2.L;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.P;

public final class AppFilesActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final LifecycleCoroutineScope f13577K = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f13578L = m.b(new C0762d(this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C2655d f13579M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public a f13580N = new a(this);

    public static final class a implements C2593c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13581a;

        a(AppFilesActivity appFilesActivity) {
            this.f13581a = appFilesActivity;
        }

        public void a(C2673w wVar) {
            t.e(wVar, "fileInfo");
            if (UptodownApp.f13477F.Z() && wVar.c() != null && !this.f13581a.isFinishing()) {
                this.f13581a.s3(wVar);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f13582a;

        /* renamed from: b  reason: collision with root package name */
        Object f13583b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f13584c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13585d;

        /* renamed from: e  reason: collision with root package name */
        int f13586e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppFilesActivity appFilesActivity, C2308e eVar) {
            super(eVar);
            this.f13585d = appFilesActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f13584c = obj;
            this.f13586e |= Integer.MIN_VALUE;
            return this.f13585d.p3(this);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13588b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AppFilesActivity appFilesActivity, C2308e eVar) {
            super(2, eVar);
            this.f13588b = appFilesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13588b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13587a == 0) {
                u.b(obj);
                this.f13588b.o3().f22953c.setVisibility(0);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13589a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13590b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f13591c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppFilesActivity appFilesActivity, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f13590b = appFilesActivity;
            this.f13591c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f13590b, this.f13591c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ApplicationInfo applicationInfo;
            C2316b.f();
            if (this.f13589a == 0) {
                u.b(obj);
                try {
                    PackageManager packageManager = this.f13590b.getPackageManager();
                    t.d(packageManager, "getPackageManager(...)");
                    C2655d i32 = this.f13590b.f13579M;
                    t.b(i32);
                    String o5 = i32.o();
                    t.b(o5);
                    applicationInfo = C2301u.a(packageManager, o5, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    File file = new File(applicationInfo.sourceDir);
                    C2673w wVar = new C2673w();
                    wVar.e(applicationInfo.sourceDir);
                    wVar.f(C2286f.f20690a.e(applicationInfo.sourceDir));
                    wVar.g(file.length());
                    this.f13591c.add(wVar);
                    C2940B a5 = C2940B.f26458v.a(this.f13590b);
                    a5.a();
                    C2655d i33 = this.f13590b.f13579M;
                    t.b(i33);
                    i33.J(applicationInfo, a5);
                    C2655d i34 = this.f13590b.f13579M;
                    t.b(i34);
                    if (i34.v() != null) {
                        ArrayList arrayList = this.f13591c;
                        C2655d i35 = this.f13590b.f13579M;
                        t.b(i35);
                        ArrayList v5 = i35.v();
                        t.b(v5);
                        arrayList.addAll(v5);
                    }
                    C2655d i36 = this.f13590b.f13579M;
                    t.b(i36);
                    i36.I(a5);
                    C2655d i37 = this.f13590b.f13579M;
                    t.b(i37);
                    if (i37.n() != null) {
                        ArrayList arrayList2 = this.f13591c;
                        C2655d i38 = this.f13590b.f13579M;
                        t.b(i38);
                        ArrayList n5 = i38.n();
                        t.b(n5);
                        arrayList2.addAll(n5);
                    }
                    a5.m();
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13592a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13593b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f13594c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppFilesActivity appFilesActivity, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f13593b = appFilesActivity;
            this.f13594c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f13593b, this.f13594c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13592a == 0) {
                u.b(obj);
                this.f13593b.o3().f22955e.setAdapter(new C0970a(this.f13594c, this.f13593b.f13580N));
                this.f13593b.o3().f22953c.setVisibility(8);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13595a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13596b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppFilesActivity appFilesActivity, C2308e eVar) {
            super(2, eVar);
            this.f13596b = appFilesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f13596b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f13595a;
            if (i5 == 0) {
                u.b(obj);
                AppFilesActivity appFilesActivity = this.f13596b;
                this.f13595a = 1;
                if (appFilesActivity.p3(this) == f5) {
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
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class g implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppFilesActivity f13597a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2673w f13598b;

        g(AppFilesActivity appFilesActivity, C2673w wVar) {
            this.f13597a = appFilesActivity;
            this.f13598b = wVar;
        }

        public void a(L l5) {
            t.e(l5, "reportVT");
            Intent intent = new Intent(this.f13597a, VirusTotalReport.class);
            intent.putExtra("app_selected", this.f13597a.f13579M);
            intent.putExtra("appReportVT", l5);
            AppFilesActivity appFilesActivity = this.f13597a;
            appFilesActivity.startActivity(intent, UptodownApp.f13477F.a(appFilesActivity));
        }

        public void b() {
            if (this.f13598b.c() != null && !this.f13597a.isFinishing()) {
                C2962v vVar = new C2962v();
                AppFilesActivity appFilesActivity = this.f13597a;
                C2954m mVar = new C2954m();
                String c5 = this.f13598b.c();
                t.b(c5);
                vVar.t(appFilesActivity, mVar.u(c5), this.f13597a.getString(R.string.virustotal_safety_report_title));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final C2409e n3(AppFilesActivity appFilesActivity) {
        return C2409e.c(appFilesActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C2409e o3() {
        return (C2409e) this.f13578L.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (w3.C2872g.g(r9, r5, r0) != r1) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p3(b3.C2308e r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.uptodown.activities.AppFilesActivity.b
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.activities.AppFilesActivity$b r0 = (com.uptodown.activities.AppFilesActivity.b) r0
            int r1 = r0.f13586e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f13586e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.AppFilesActivity$b r0 = new com.uptodown.activities.AppFilesActivity$b
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f13584c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f13586e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            W2.u.b(r9)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.f13583b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r4 = r0.f13582a
            com.uptodown.activities.AppFilesActivity r4 = (com.uptodown.activities.AppFilesActivity) r4
            W2.u.b(r9)
            goto L_0x0088
        L_0x0045:
            java.lang.Object r2 = r0.f13583b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r5 = r0.f13582a
            com.uptodown.activities.AppFilesActivity r5 = (com.uptodown.activities.AppFilesActivity) r5
            W2.u.b(r9)
            goto L_0x0071
        L_0x0051:
            W2.u.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            w3.I0 r2 = w3.C2865c0.c()
            com.uptodown.activities.AppFilesActivity$c r7 = new com.uptodown.activities.AppFilesActivity$c
            r7.<init>(r8, r6)
            r0.f13582a = r8
            r0.f13583b = r9
            r0.f13586e = r5
            java.lang.Object r2 = w3.C2872g.g(r2, r7, r0)
            if (r2 != r1) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r5 = r8
            r2 = r9
        L_0x0071:
            w3.I r9 = w3.C2865c0.b()
            com.uptodown.activities.AppFilesActivity$d r7 = new com.uptodown.activities.AppFilesActivity$d
            r7.<init>(r5, r2, r6)
            r0.f13582a = r5
            r0.f13583b = r2
            r0.f13586e = r4
            java.lang.Object r9 = w3.C2872g.g(r9, r7, r0)
            if (r9 != r1) goto L_0x0087
            goto L_0x009d
        L_0x0087:
            r4 = r5
        L_0x0088:
            w3.I0 r9 = w3.C2865c0.c()
            com.uptodown.activities.AppFilesActivity$e r5 = new com.uptodown.activities.AppFilesActivity$e
            r5.<init>(r4, r2, r6)
            r0.f13582a = r6
            r0.f13583b = r6
            r0.f13586e = r3
            java.lang.Object r9 = w3.C2872g.g(r9, r5, r0)
            if (r9 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            W2.J r9 = W2.J.f19942a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppFilesActivity.p3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void q3(AppFilesActivity appFilesActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            appFilesActivity.getOnBackPressedDispatcher().onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static final void r3(View view) {
    }

    /* access modifiers changed from: private */
    public final void s3(C2673w wVar) {
        new C2392n(this, (String) null, wVar.c(), new g(this, wVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    private final void t3() {
        P p5 = P.f26510a;
        C2655d dVar = this.f13579M;
        t.b(dVar);
        o3().f22952b.setImageDrawable(p5.j(this, dVar.o()));
        TextView textView = o3().f22957g;
        C2655d dVar2 = this.f13579M;
        t.b(dVar2);
        textView.setText(dVar2.m());
        TextView textView2 = o3().f22957g;
        k.a aVar = k.f32g;
        textView2.setTypeface(aVar.w());
        TextView textView3 = o3().f22958h;
        C2655d dVar3 = this.f13579M;
        t.b(dVar3);
        textView3.setText(dVar3.B());
        o3().f22958h.setTypeface(aVar.x());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        try {
            setContentView((View) o3().getRoot());
            Intent intent = getIntent();
            if (!(intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("appInstalled"))) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInstalled", C2655d.class);
                } else {
                    parcelable = extras.getParcelable("appInstalled");
                }
                this.f13579M = (C2655d) parcelable;
            }
            C2409e o32 = o3();
            TextView textView = o32.f22960j;
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                o32.f22956f.setNavigationIcon(drawable);
                o32.f22956f.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            o32.f22956f.setNavigationOnClickListener(new C0770e(this));
            o32.f22959i.setTypeface(aVar.x());
            o32.f22953c.setOnClickListener(new C0778f());
            o32.f22955e.setLayoutManager(new LinearLayoutManager(this, 1, false));
            o32.f22955e.setItemAnimator(new DefaultItemAnimator());
            o32.f22955e.addItemDecoration(new C2303w((int) getResources().getDimension(R.dimen.margin_m)));
            if (this.f13579M != null) {
                t3();
                C2908y0 unused = C2876i.d(this.f13577K, (C2312i) null, (O) null, new f(this, (C2308e) null), 3, (Object) null);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
