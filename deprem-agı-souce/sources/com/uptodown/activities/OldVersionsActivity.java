package com.uptodown.activities;

import O1.B3;
import O1.C3;
import O1.D3;
import O1.E3;
import O1.F3;
import O1.G3;
import O1.H3;
import R1.C0987s;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import X2.C2250q;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2290j;
import b2.C2301u;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.A;
import com.uptodown.workers.DownloadWorker;
import g2.C2392n;
import h2.C2430o0;
import h2.C2436s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import k2.C2615z;
import k2.Z;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2643C;
import l2.C2655d;
import l2.C2657f;
import l2.C2667p;
import l2.C2668q;
import l2.L;
import l2.r;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import z2.C2940B;
import z2.F;
import z2.O;
import z3.C2973f;
import z3.D;
import z3.w;

public final class OldVersionsActivity extends C1598a {

    /* renamed from: O  reason: collision with root package name */
    public static final a f14262O = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14263K = m.b(new B3(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14264L = new ViewModelLazy(M.b(A.class), new i(this), new h(this), new j((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0987s f14265M;

    /* renamed from: N  reason: collision with root package name */
    private e f14266N = new e(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2668q f14267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f14268b;

        public b(OldVersionsActivity oldVersionsActivity, C2668q qVar) {
            t.e(qVar, "download");
            this.f14268b = oldVersionsActivity;
            this.f14267a = qVar;
        }

        public void run() {
            if (this.f14268b.G3().d().getValue() != null) {
                Object value = this.f14268b.G3().d().getValue();
                t.b(value);
                if (((C2657f) value).S() != null) {
                    Object value2 = this.f14268b.G3().d().getValue();
                    t.b(value2);
                    if (s.E(((C2657f) value2).S(), this.f14267a.w(), true)) {
                        this.f14268b.Q3(this.f14267a);
                    }
                }
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f14269a;

        /* renamed from: b  reason: collision with root package name */
        private final C2668q f14270b;

        public c(int i5, C2668q qVar) {
            this.f14269a = i5;
            this.f14270b = qVar;
        }

        public void run() {
            String str;
            Long l5;
            Object value = OldVersionsActivity.this.G3().d().getValue();
            t.b(value);
            String S4 = ((C2657f) value).S();
            C2668q qVar = this.f14270b;
            Long l6 = null;
            if (qVar != null) {
                str = qVar.w();
            } else {
                str = null;
            }
            if (s.F(S4, str, false, 2, (Object) null)) {
                int i5 = this.f14269a;
                if (i5 == 203) {
                    OldVersionsActivity.this.V3(this.f14270b);
                } else if (i5 == 208) {
                    OldVersionsActivity oldVersionsActivity = OldVersionsActivity.this;
                    String string = oldVersionsActivity.getString(R.string.no_free_space);
                    t.d(string, "getString(...)");
                    oldVersionsActivity.u0(string);
                } else if (OldVersionsActivity.this.f14265M != null && !OldVersionsActivity.this.G3().g()) {
                    C2668q qVar2 = this.f14270b;
                    if (qVar2 != null) {
                        l5 = Long.valueOf(qVar2.h());
                    } else {
                        l5 = null;
                    }
                    C2657f fVar = (C2657f) OldVersionsActivity.this.G3().d().getValue();
                    if (fVar != null) {
                        l6 = Long.valueOf(fVar.e());
                    }
                    if (t.a(l5, l6)) {
                        OldVersionsActivity.this.V3(this.f14270b);
                    }
                }
            }
        }
    }

    public final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f14272a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14273b;

        public d(String str, int i5) {
            this.f14272a = str;
            this.f14273b = i5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
            if (t3.s.E(((l2.C2655d) r0).o(), r4.f14272a, true) == false) goto L_0x00a9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                java.lang.String r0 = r4.f14272a
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r1 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r1 = r1.G3()
                z3.w r1 = r1.d()
                java.lang.Object r1 = r1.getValue()
                kotlin.jvm.internal.t.b(r1)
                l2.f r1 = (l2.C2657f) r1
                java.lang.String r1 = r1.S()
                r2 = 1
                boolean r0 = t3.s.E(r0, r1, r2)
                if (r0 == 0) goto L_0x0110
                int r0 = r4.f14273b
                r1 = 306(0x132, float:4.29E-43)
                r3 = 8
                if (r0 != r1) goto L_0x0036
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                h2.o0 r0 = r0.E3()
                android.view.View r0 = r0.f23415b
                r0.setVisibility(r3)
                goto L_0x0045
            L_0x0036:
                r1 = 307(0x133, float:4.3E-43)
                if (r0 != r1) goto L_0x0045
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                h2.o0 r0 = r0.E3()
                android.view.View r0 = r0.f23415b
                r0.setVisibility(r3)
            L_0x0045:
                int r0 = r4.f14273b
                r1 = 301(0x12d, float:4.22E-43)
                if (r0 == r1) goto L_0x00f7
                r1 = 351(0x15f, float:4.92E-43)
                if (r0 != r1) goto L_0x0051
                goto L_0x00f7
            L_0x0051:
                r1 = 352(0x160, float:4.93E-43)
                if (r0 != r1) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                boolean r0 = r0.g()
                if (r0 != 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                z3.w r0 = r0.c()
                java.lang.Object r0 = r0.getValue()
                if (r0 == 0) goto L_0x00a9
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                z3.w r0 = r0.c()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.t.b(r0)
                l2.d r0 = (l2.C2655d) r0
                java.lang.String r0 = r0.o()
                if (r0 == 0) goto L_0x00a9
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                z3.w r0 = r0.c()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.t.b(r0)
                l2.d r0 = (l2.C2655d) r0
                java.lang.String r0 = r0.o()
                java.lang.String r1 = r4.f14272a
                boolean r0 = t3.s.E(r0, r1, r2)
                if (r0 != 0) goto L_0x00f1
            L_0x00a9:
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                z3.w r0 = r0.d()
                java.lang.Object r0 = r0.getValue()
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                z3.w r0 = r0.d()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.t.b(r0)
                l2.f r0 = (l2.C2657f) r0
                java.lang.String r0 = r0.S()
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                z3.w r0 = r0.d()
                java.lang.Object r0 = r0.getValue()
                kotlin.jvm.internal.t.b(r0)
                l2.f r0 = (l2.C2657f) r0
                java.lang.String r0 = r0.S()
                java.lang.String r1 = r4.f14272a
                boolean r0 = t3.s.E(r0, r1, r2)
                if (r0 == 0) goto L_0x0110
            L_0x00f1:
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                r0.F3()
                return
            L_0x00f7:
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                R1.s r0 = r0.f14265M
                if (r0 == 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                com.uptodown.activities.A r0 = r0.G3()
                boolean r0 = r0.g()
                if (r0 != 0) goto L_0x0110
                com.uptodown.activities.OldVersionsActivity r0 = com.uptodown.activities.OldVersionsActivity.this
                r0.U3()
            L_0x0110:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OldVersionsActivity.d.run():void");
        }
    }

    public static final class e implements C2615z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f14275a;

        e(OldVersionsActivity oldVersionsActivity) {
            this.f14275a = oldVersionsActivity;
        }

        public void a() {
            if (UptodownApp.f13477F.Z()) {
                this.f14275a.G3().l(true);
                A q32 = this.f14275a.G3();
                q32.n(q32.i() - 1);
                this.f14275a.G3().m(this.f14275a.G3().i() * 20);
                this.f14275a.F3();
            }
        }

        public void b(int i5) {
            if (UptodownApp.f13477F.Z()) {
                this.f14275a.N3(i5);
            }
        }

        public void c(int i5) {
            this.f14275a.M3(i5);
        }

        public void d() {
            if (UptodownApp.f13477F.Z()) {
                this.f14275a.G3().l(true);
                A q32 = this.f14275a.G3();
                q32.n(q32.i() + 1);
                this.f14275a.G3().m(this.f14275a.G3().i() * 20);
                this.f14275a.F3();
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f14277b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OldVersionsActivity f14278a;

            a(OldVersionsActivity oldVersionsActivity) {
                this.f14278a = oldVersionsActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (t.a(o5, O.a.f26507a)) {
                    if (this.f14278a.G3().f()) {
                        this.f14278a.E3().f23415b.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((A.a) cVar.a()).c()) {
                        this.f14278a.G3().c().setValue(((A.a) cVar.a()).a());
                        this.f14278a.G3().d().setValue(((A.a) cVar.a()).b());
                        if (((A.a) cVar.a()).b().Q() == null) {
                            this.f14278a.E3().f23418e.setVisibility(0);
                        } else if (this.f14278a.f14265M == null) {
                            this.f14278a.x3();
                            this.f14278a.E3().f23416c.setAdapter(this.f14278a.f14265M);
                        } else {
                            C0987s n32 = this.f14278a.f14265M;
                            t.b(n32);
                            n32.g(this.f14278a.G3().i());
                            C0987s n33 = this.f14278a.f14265M;
                            t.b(n33);
                            n33.f(((A.a) cVar.a()).b().Q());
                            C0987s n34 = this.f14278a.f14265M;
                            t.b(n34);
                            n34.e((C2655d) this.f14278a.G3().c().getValue());
                            this.f14278a.E3().f23416c.scrollToPosition(0);
                            this.f14278a.U3();
                        }
                        this.f14278a.S3();
                    } else {
                        C2657f fVar = (C2657f) this.f14278a.G3().d().getValue();
                        if (fVar != null) {
                            fVar.U0((ArrayList) null);
                        }
                        this.f14278a.E3().f23418e.setVisibility(0);
                        this.f14278a.S3();
                    }
                } else if (!t.a(o5, O.b.f26508a)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(OldVersionsActivity oldVersionsActivity, C2308e eVar) {
            super(2, eVar);
            this.f14277b = oldVersionsActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f14277b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14276a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14277b.G3().e();
                a aVar = new a(this.f14277b);
                this.f14276a = 1;
                if (e5.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class g implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f14279a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2643C f14280b;

        g(OldVersionsActivity oldVersionsActivity, C2643C c5) {
            this.f14279a = oldVersionsActivity;
            this.f14280b = c5;
        }

        public void a(L l5) {
            t.e(l5, "reportVT");
            Intent intent = new Intent(this.f14279a, VirusTotalReport.class);
            intent.putExtra("appInfo", (Parcelable) this.f14279a.G3().d().getValue());
            intent.putExtra("appReportVT", l5);
            intent.putExtra("old_version_name", this.f14280b.i());
            OldVersionsActivity oldVersionsActivity = this.f14279a;
            oldVersionsActivity.startActivity(intent, UptodownApp.f13477F.a(oldVersionsActivity));
        }

        public void b() {
            if (this.f14279a.G3().d().getValue() != null) {
                Object value = this.f14279a.G3().d().getValue();
                t.b(value);
                String q02 = ((C2657f) value).q0();
                if (!(q02 == null || q02.length() == 0)) {
                    Object value2 = this.f14279a.G3().d().getValue();
                    t.b(value2);
                    String q03 = ((C2657f) value2).q0();
                    t.b(q03);
                    if (Long.parseLong(q03) > 650000000) {
                        Intent intent = new Intent(this.f14279a, VirusTotalReport.class);
                        intent.putExtra("appInfo", (Parcelable) this.f14279a.G3().d().getValue());
                        intent.putExtra("isVirusTotalReportAvaialable", false);
                        OldVersionsActivity oldVersionsActivity = this.f14279a;
                        oldVersionsActivity.startActivity(intent, UptodownApp.f13477F.a(oldVersionsActivity));
                        return;
                    }
                }
            }
            OldVersionsActivity oldVersionsActivity2 = this.f14279a;
            Object value3 = oldVersionsActivity2.G3().d().getValue();
            t.b(value3);
            oldVersionsActivity2.L2(((C2657f) value3).n0());
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14281a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f14281a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14281a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14282a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f14282a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14282a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14283a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14284b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14283a = aVar;
            this.f14284b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14283a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14284b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OldVersionsActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14285a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OldVersionsActivity f14286b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14287c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(OldVersionsActivity oldVersionsActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14286b = oldVersionsActivity;
            this.f14287c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f14286b, this.f14287c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a5, code lost:
            if (t3.s.E(((l2.C2657f) r3).S(), r2.f14287c, true) != false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a7, code lost:
            com.uptodown.activities.OldVersionsActivity.p3(r2.f14286b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x005d, code lost:
            if (t3.s.E(((l2.C2655d) r3).o(), r2.f14287c, true) == false) goto L_0x005f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
            /*
                r2 = this;
                c3.C2316b.f()
                int r0 = r2.f14285a
                if (r0 != 0) goto L_0x00af
                W2.u.b(r3)
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                boolean r3 = r3.g()
                if (r3 != 0) goto L_0x00ac
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                z3.w r3 = r3.c()
                java.lang.Object r3 = r3.getValue()
                r0 = 1
                if (r3 == 0) goto L_0x005f
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                z3.w r3 = r3.c()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.t.b(r3)
                l2.d r3 = (l2.C2655d) r3
                java.lang.String r3 = r3.o()
                if (r3 == 0) goto L_0x005f
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                z3.w r3 = r3.c()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.t.b(r3)
                l2.d r3 = (l2.C2655d) r3
                java.lang.String r3 = r3.o()
                java.lang.String r1 = r2.f14287c
                boolean r3 = t3.s.E(r3, r1, r0)
                if (r3 != 0) goto L_0x00a7
            L_0x005f:
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                z3.w r3 = r3.d()
                java.lang.Object r3 = r3.getValue()
                if (r3 == 0) goto L_0x00ac
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                z3.w r3 = r3.d()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.t.b(r3)
                l2.f r3 = (l2.C2657f) r3
                java.lang.String r3 = r3.S()
                if (r3 == 0) goto L_0x00ac
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                com.uptodown.activities.A r3 = r3.G3()
                z3.w r3 = r3.d()
                java.lang.Object r3 = r3.getValue()
                kotlin.jvm.internal.t.b(r3)
                l2.f r3 = (l2.C2657f) r3
                java.lang.String r3 = r3.S()
                java.lang.String r1 = r2.f14287c
                boolean r3 = t3.s.E(r3, r1, r0)
                if (r3 == 0) goto L_0x00ac
            L_0x00a7:
                com.uptodown.activities.OldVersionsActivity r3 = r2.f14286b
                r3.F3()
            L_0x00ac:
                W2.J r3 = W2.J.f19942a
                return r3
            L_0x00af:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OldVersionsActivity.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    private final void A3(C2668q qVar, String str) {
        if (!isFinishing()) {
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(str);
            c5.f23526b.setVisibility(0);
            c5.f23526b.setTypeface(aVar.x());
            c5.f23526b.setOnCheckedChangeListener(new F3(this));
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setOnClickListener(new G3(this, qVar));
            c5.f23527c.setTypeface(aVar.w());
            c5.f23527c.setOnClickListener(new H3(c5, this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            if (p2() != null) {
                AlertDialog p22 = p2();
                t.b(p22);
                if (p22.isShowing()) {
                    return;
                }
            }
            P2(builder.create());
            if (!isFinishing()) {
                AlertDialog p23 = p2();
                t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p24 = p2();
                t.b(p24);
                p24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void B3(OldVersionsActivity oldVersionsActivity, CompoundButton compoundButton, boolean z4) {
        com.uptodown.activities.preferences.a.f15150a.k1(oldVersionsActivity, !z4);
    }

    /* access modifiers changed from: private */
    public static final void C3(OldVersionsActivity oldVersionsActivity, C2668q qVar, View view) {
        oldVersionsActivity.R3(qVar);
        AlertDialog p22 = oldVersionsActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void D3(C2436s sVar, OldVersionsActivity oldVersionsActivity, View view) {
        if (sVar.f23526b.isChecked()) {
            com.uptodown.activities.preferences.a.f15150a.k1(oldVersionsActivity, true);
        }
        AlertDialog p22 = oldVersionsActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final C2430o0 E3() {
        return (C2430o0) this.f14263K.getValue();
    }

    /* access modifiers changed from: private */
    public final void F3() {
        G3().l(true);
        if (G3().d().getValue() != null) {
            G3().b(this);
        }
    }

    /* access modifiers changed from: private */
    public final A G3() {
        return (A) this.f14264L.getValue();
    }

    private final void H3() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_old_versions);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            toolbar.setNavigationOnClickListener(new D3(this));
        }
        k.a aVar = S1.k.f32g;
        ((TextView) findViewById(R.id.tv_toolbar_old_versions)).setTypeface(aVar.w());
        E3().f23418e.setTypeface(aVar.x());
        E3().f23416c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        E3().f23416c.setItemAnimator((RecyclerView.ItemAnimator) null);
        E3().f23416c.addItemDecoration(new B2.l((int) getResources().getDimension(R.dimen.margin_m), (int) getResources().getDimension(R.dimen.margin_xl)));
        E3().f23415b.setOnClickListener(new E3());
    }

    /* access modifiers changed from: private */
    public static final void I3(OldVersionsActivity oldVersionsActivity, View view) {
        oldVersionsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void J3(View view) {
    }

    private final boolean L3(String str, long j5) {
        PackageManager packageManager = getPackageManager();
        try {
            t.b(packageManager);
            if (j5 < new C2290j().m(C2301u.d(packageManager, str, 128))) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void O3(C2643C c5) {
        if (!isFinishing() && G3().d().getValue() != null) {
            C2657f.b bVar = C2657f.f25002J0;
            Object value = G3().d().getValue();
            t.b(value);
            if (bVar.d(((C2657f) value).o())) {
                new C2392n(this, c5.b(), (String) null, new g(this, c5), LifecycleOwnerKt.getLifecycleScope(this));
            }
        }
    }

    private final void P3(C2643C c5, C2668q qVar) {
        if (c5.f() != null) {
            C2667p pVar = new C2667p();
            pVar.k(this);
            ArrayList f5 = c5.f();
            t.b(f5);
            boolean f6 = pVar.f(f5, this);
            if (!com.uptodown.activities.preferences.a.f15150a.x1(this)) {
                R3(qVar);
            } else if (f6) {
                R3(qVar);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "required_feature");
                bundle.putString("fileId", c5.b());
                if (qVar.h() >= 0) {
                    bundle.putString("appId", String.valueOf(qVar.h()));
                }
                bundle.putString("packagename", qVar.w());
                F s22 = s2();
                if (s22 != null) {
                    s22.d("warning", bundle);
                }
                String string = getString(R.string.msg_warning_incompatible_required_features);
                t.d(string, "getString(...)");
                A3(qVar, string);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Q3(C2668q qVar) {
        String w4 = qVar.w();
        t.b(w4);
        if (L3(w4, qVar.E())) {
            String w5 = qVar.w();
            t.b(w5);
            y3(w5, qVar);
            return;
        }
        File n5 = qVar.n();
        if (n5 != null && n5.exists()) {
            UptodownApp.a.X(UptodownApp.f13477F, n5, this, (String) null, 4, (Object) null);
        }
    }

    private final void R3(C2668q qVar) {
        int S4 = qVar.S(this);
        if (S4 >= 0) {
            Object value = G3().d().getValue();
            t.b(value);
            String N4 = ((C2657f) value).N();
            t.b(N4);
            O2(S4, N4);
            return;
        }
        u0(getString(R.string.error_cant_enqueue_download) + " (108)");
    }

    /* access modifiers changed from: private */
    public final void S3() {
        G3().k(false);
        E3().f23415b.setVisibility(8);
        G3().l(false);
    }

    private final void T3(String str) {
        new S1.j(this).h(str);
    }

    /* access modifiers changed from: private */
    public final void U3() {
        C0987s sVar = this.f14265M;
        if (sVar != null) {
            sVar.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void V3(C2668q qVar) {
        C2643C c5;
        Object obj;
        Object value = G3().d().getValue();
        t.b(value);
        ArrayList Q4 = ((C2657f) value).Q();
        Integer num = null;
        if (Q4 != null) {
            int size = Q4.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    obj = null;
                    break;
                }
                obj = Q4.get(i5);
                i5++;
                C2643C c6 = (C2643C) obj;
                if (qVar != null && c6.h() == qVar.E()) {
                    break;
                }
            }
            c5 = (C2643C) obj;
        } else {
            c5 = null;
        }
        Object value2 = G3().d().getValue();
        t.b(value2);
        ArrayList Q5 = ((C2657f) value2).Q();
        if (Q5 != null) {
            num = Integer.valueOf(C2250q.R(Q5, c5));
        }
        if (c5 == null || num == null) {
            U3();
            return;
        }
        C0987s sVar = this.f14265M;
        if (sVar != null) {
            sVar.notifyItemChanged(num.intValue());
        }
    }

    /* access modifiers changed from: private */
    public static final C2430o0 v3(OldVersionsActivity oldVersionsActivity) {
        return C2430o0.c(oldVersionsActivity.getLayoutInflater());
    }

    private final void w3(Context context, C2668q qVar) {
        Long l5;
        String str = null;
        if (qVar != null) {
            l5 = Long.valueOf(qVar.h());
        } else {
            l5 = null;
        }
        if (qVar != null) {
            str = qVar.w();
        }
        if (l5 != null) {
            DownloadWorker.a aVar = DownloadWorker.f21359d;
            if (aVar.j(l5.longValue())) {
                aVar.b();
                z2.M.f26506a.e(context);
                return;
            }
        }
        if (str != null) {
            DownloadWorker.a aVar2 = DownloadWorker.f21359d;
            if (aVar2.l(str)) {
                aVar2.c(str);
                return;
            }
        }
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        if (qVar != null) {
            if (qVar.P()) {
                a5.A(qVar);
            } else {
                Iterator it = qVar.o().iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    r rVar = (r) next;
                    rVar.p(0);
                    rVar.l(0);
                    a5.E1(rVar);
                }
            }
        }
        a5.m();
    }

    /* access modifiers changed from: private */
    public final void x3() {
        Object value = G3().d().getValue();
        t.b(value);
        e eVar = this.f14266N;
        Object value2 = G3().d().getValue();
        t.b(value2);
        int w02 = ((C2657f) value2).w0();
        this.f14265M = new C0987s((C2657f) value, (C2655d) G3().c().getValue(), this, eVar, w02);
    }

    private final void y3(String str, C2668q qVar) {
        String string = getString(R.string.msg_warning_old_versions);
        t.d(string, "getString(...)");
        U1(string, new C3(this, qVar, str));
    }

    /* access modifiers changed from: private */
    public static final J z3(OldVersionsActivity oldVersionsActivity, C2668q qVar, String str) {
        com.uptodown.activities.preferences.a.f15150a.B0(oldVersionsActivity, qVar.q());
        oldVersionsActivity.T3(str);
        return J.f19942a;
    }

    public final void K3(String str) {
        t.e(str, "packageName");
        G3().j(this, str);
    }

    public final void M3(int i5) {
        Object value = G3().d().getValue();
        t.b(value);
        if (((C2657f) value).Q() != null) {
            Object value2 = G3().d().getValue();
            t.b(value2);
            ArrayList Q4 = ((C2657f) value2).Q();
            t.b(Q4);
            if (i5 < Q4.size()) {
                Object value3 = G3().d().getValue();
                t.b(value3);
                ArrayList Q5 = ((C2657f) value3).Q();
                t.b(Q5);
                long h5 = ((C2643C) Q5.get(i5)).h();
                if (G3().c().getValue() != null) {
                    Object value4 = G3().c().getValue();
                    t.b(value4);
                    if (h5 == ((C2655d) value4).A()) {
                        Q q5 = Q.f24695a;
                        String string = getString(R.string.autoupdate_installed_version);
                        t.d(string, "getString(...)");
                        Object value5 = G3().d().getValue();
                        t.b(value5);
                        ArrayList Q6 = ((C2657f) value5).Q();
                        t.b(Q6);
                        String format = String.format(string, Arrays.copyOf(new Object[]{((C2643C) Q6.get(i5)).i()}, 1));
                        t.d(format, "format(...)");
                        u0(format);
                        return;
                    }
                }
                C2940B.a aVar = C2940B.f26458v;
                Context applicationContext = getApplicationContext();
                t.d(applicationContext, "getApplicationContext(...)");
                C2940B a5 = aVar.a(applicationContext);
                a5.a();
                Object value6 = G3().d().getValue();
                t.b(value6);
                String S4 = ((C2657f) value6).S();
                t.b(S4);
                C2668q k02 = a5.k0(S4, h5);
                if (k02 == null) {
                    C2668q qVar = new C2668q();
                    Object value7 = G3().d().getValue();
                    t.b(value7);
                    Object value8 = G3().d().getValue();
                    t.b(value8);
                    ArrayList Q7 = ((C2657f) value8).Q();
                    t.b(Q7);
                    Object obj = Q7.get(i5);
                    t.d(obj, "get(...)");
                    qVar.d((C2657f) value7, (C2643C) obj);
                    Object value9 = G3().d().getValue();
                    t.b(value9);
                    ArrayList Q8 = ((C2657f) value9).Q();
                    t.b(Q8);
                    Object obj2 = Q8.get(i5);
                    t.d(obj2, "get(...)");
                    P3((C2643C) obj2, qVar);
                    C0987s sVar = this.f14265M;
                    if (sVar != null) {
                        sVar.notifyItemChanged(i5);
                    }
                } else if (!DownloadWorker.f21359d.m(k02)) {
                    File n5 = k02.n();
                    if (!k02.f() || k02.o().isEmpty() || n5 == null || !n5.exists()) {
                        k02.T(this);
                        C0987s sVar2 = this.f14265M;
                        if (sVar2 != null) {
                            sVar2.notifyItemChanged(i5);
                        }
                    } else {
                        Q3(k02);
                    }
                } else {
                    w3(this, k02);
                }
                a5.m();
            }
        }
    }

    public final void N3(int i5) {
        C2643C c5;
        Object value = G3().d().getValue();
        t.b(value);
        if (((C2657f) value).Q() != null) {
            Object value2 = G3().d().getValue();
            t.b(value2);
            ArrayList Q4 = ((C2657f) value2).Q();
            t.b(Q4);
            if (i5 < Q4.size()) {
                Object value3 = G3().d().getValue();
                t.b(value3);
                ArrayList Q5 = ((C2657f) value3).Q();
                if (Q5 != null) {
                    c5 = (C2643C) Q5.get(i5);
                } else {
                    c5 = null;
                }
                t.b(c5);
                O3(c5);
            }
        }
    }

    public final Object W3(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new k(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        setContentView((View) E3().getRoot());
        G3().k(true);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                w c5 = G3().c();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP, C2655d.class);
                } else {
                    parcelable2 = extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                }
                c5.setValue(parcelable2);
            }
            if (extras.containsKey("appInfo")) {
                w d5 = G3().d();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
                } else {
                    parcelable = extras.getParcelable("appInfo");
                }
                d5.setValue(parcelable);
            }
        }
        H3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new f(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        F3();
    }
}
