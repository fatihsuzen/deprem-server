package com.uptodown.activities;

import O1.L5;
import O1.M5;
import O1.N5;
import O1.O5;
import O1.P5;
import O1.Q5;
import O1.R5;
import O1.S5;
import O1.T2;
import O1.T5;
import R1.L;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.u;
import X2.C2250q;
import a3.C2265a;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.a0;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.DownloadUpdatesWorker;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import g2.C2379a;
import h2.C2397A;
import h2.C2438t;
import h2.Z0;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import k2.C2592b;
import k2.C2597g;
import k2.C2612w;
import k2.K;
import k3.C2616a;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.M;
import l2.C2655d;
import l2.C2668q;
import l2.T;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.F;
import z2.H;
import z2.O;
import z3.C2973f;
import z3.D;

public final class Updates extends T2 {

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14574W = W2.m.b(new L5(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14575X = new ViewModelLazy(M.b(a0.class), new l(this), new k(this), new m((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public ArrayList f14576Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public L f14577Z;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f14578m0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public ArrayList f14579n0 = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public boolean f14580o0;

    /* renamed from: p0  reason: collision with root package name */
    private q f14581p0 = new q(this);

    /* renamed from: q0  reason: collision with root package name */
    private a f14582q0 = new a(this);

    /* renamed from: r0  reason: collision with root package name */
    private t f14583r0 = new t(this);

    /* renamed from: s0  reason: collision with root package name */
    private f f14584s0 = new f(this);

    /* renamed from: t0  reason: collision with root package name */
    private final ActivityResultLauncher f14585t0;

    /* renamed from: u0  reason: collision with root package name */
    private final g f14586u0;

    public static final class a implements C2592b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14587a;

        a(Updates updates) {
            this.f14587a = updates;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: l2.d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r3) {
            /*
                r2 = this;
                com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f13477F
                boolean r0 = r0.Z()
                if (r0 == 0) goto L_0x0076
                com.uptodown.activities.Updates r0 = r2.f14587a
                R1.L r0 = r0.f14577Z
                r1 = 0
                if (r0 == 0) goto L_0x001c
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x001c
                java.lang.Object r0 = r0.get(r3)
                goto L_0x001d
            L_0x001c:
                r0 = r1
            L_0x001d:
                boolean r0 = r0 instanceof R1.L.a
                if (r0 == 0) goto L_0x003e
                com.uptodown.activities.Updates r0 = r2.f14587a
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.t.c(r0, r1)
                R1.L$a r0 = (R1.L.a) r0
                l2.d r1 = r0.a()
                goto L_0x006f
            L_0x003e:
                com.uptodown.activities.Updates r0 = r2.f14587a
                R1.L r0 = r0.f14577Z
                if (r0 == 0) goto L_0x0051
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x0051
                java.lang.Object r0 = r0.get(r3)
                goto L_0x0052
            L_0x0051:
                r0 = r1
            L_0x0052:
                boolean r0 = r0 instanceof l2.C2655d
                if (r0 == 0) goto L_0x006f
                com.uptodown.activities.Updates r0 = r2.f14587a
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.models.App"
                kotlin.jvm.internal.t.c(r0, r1)
                r1 = r0
                l2.d r1 = (l2.C2655d) r1
            L_0x006f:
                if (r1 == 0) goto L_0x0076
                com.uptodown.activities.Updates r0 = r2.f14587a
                r0.c4(r1, r3)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.a.a(int):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: l2.d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(int r7) {
            /*
                r6 = this;
                com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f13477F
                boolean r0 = r0.Z()
                if (r0 == 0) goto L_0x0084
                com.uptodown.activities.Updates r0 = r6.f14587a
                R1.L r0 = r0.f14577Z
                r1 = 0
                if (r0 == 0) goto L_0x001c
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x001c
                java.lang.Object r0 = r0.get(r7)
                goto L_0x001d
            L_0x001c:
                r0 = r1
            L_0x001d:
                boolean r0 = r0 instanceof R1.L.a
                if (r0 == 0) goto L_0x003e
                com.uptodown.activities.Updates r0 = r6.f14587a
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.t.c(r7, r0)
                R1.L$a r7 = (R1.L.a) r7
                l2.d r1 = r7.a()
                goto L_0x006f
            L_0x003e:
                com.uptodown.activities.Updates r0 = r6.f14587a
                R1.L r0 = r0.f14577Z
                if (r0 == 0) goto L_0x0051
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x0051
                java.lang.Object r0 = r0.get(r7)
                goto L_0x0052
            L_0x0051:
                r0 = r1
            L_0x0052:
                boolean r0 = r0 instanceof l2.C2655d
                if (r0 == 0) goto L_0x006f
                com.uptodown.activities.Updates r0 = r6.f14587a
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.models.App"
                kotlin.jvm.internal.t.c(r7, r0)
                r1 = r7
                l2.d r1 = (l2.C2655d) r1
            L_0x006f:
                if (r1 == 0) goto L_0x0084
                long r2 = r1.b()
                r4 = 0
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 <= 0) goto L_0x0084
                com.uptodown.activities.Updates r7 = r6.f14587a
                long r0 = r1.b()
                r7.H2(r0)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.a.b(int):void");
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14588a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14589b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Updates updates, C2308e eVar) {
            super(2, eVar);
            this.f14589b = updates;
        }

        /* access modifiers changed from: private */
        public static final void j(I i5, Updates updates, View view) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                i5.f24687a = true;
                updates.z5();
                updates.j6();
                updates.startActivity(new Intent(updates.getApplicationContext(), PreferencesActivity.class), aVar.a(updates));
                AlertDialog p22 = updates.p2();
                if (p22 != null) {
                    p22.dismiss();
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void l(I i5, Updates updates, View view) {
            i5.f24687a = true;
            AlertDialog p22 = updates.p2();
            if (p22 != null) {
                p22.dismiss();
            }
            updates.z5();
            updates.j6();
        }

        /* access modifiers changed from: private */
        public static final void m(I i5, Updates updates, View view) {
            i5.f24687a = true;
            AlertDialog p22 = updates.p2();
            if (p22 != null) {
                p22.dismiss();
            }
            updates.f14580o0 = true;
            updates.b6();
        }

        /* access modifiers changed from: private */
        public static final void n(I i5, Updates updates, DialogInterface dialogInterface) {
            if (!i5.f24687a) {
                updates.z5();
                updates.j6();
            }
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14589b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14588a == 0) {
                u.b(obj);
                I i5 = new I();
                AlertDialog p22 = this.f14589b.p2();
                if (p22 != null) {
                    p22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f14589b);
                C2438t c5 = C2438t.c(this.f14589b.getLayoutInflater());
                kotlin.jvm.internal.t.d(c5, "inflate(...)");
                Updates updates = this.f14589b;
                TextView textView = c5.f23552f;
                k.a aVar = S1.k.f32g;
                textView.setTypeface(aVar.w());
                c5.f23549c.setTypeface(aVar.x());
                c5.f23551e.setTypeface(aVar.w());
                c5.f23548b.setTypeface(aVar.w());
                c5.f23550d.setTypeface(aVar.w());
                c5.f23551e.setOnClickListener(new P(i5, updates));
                c5.f23548b.setOnClickListener(new Q(i5, updates));
                c5.f23550d.setOnClickListener(new S(i5, updates));
                builder.setView(c5.getRoot());
                this.f14589b.P2(builder.create());
                AlertDialog p23 = this.f14589b.p2();
                kotlin.jvm.internal.t.b(p23);
                p23.setOnDismissListener(new T(i5, this.f14589b));
                if (!this.f14589b.isFinishing() && this.f14589b.p2() != null) {
                    this.f14589b.b3();
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14590a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14591b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14592c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f14593d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f14594e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f14595f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Updates updates, String str, String str2, ArrayList arrayList, boolean z4, C2308e eVar) {
            super(2, eVar);
            this.f14591b = updates;
            this.f14592c = str;
            this.f14593d = str2;
            this.f14594e = arrayList;
            this.f14595f = z4;
        }

        /* access modifiers changed from: private */
        public static final void e(Updates updates, boolean z4, String str, View view) {
            updates.o2();
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.T("GenerateQueueWorker", updates) || aVar.T("downloadApkWorker", updates)) {
                String string = updates.getString(R.string.error_download_in_progress_wait);
                kotlin.jvm.internal.t.d(string, "getString(...)");
                updates.a2(string);
                return;
            }
            updates.P4(true);
            GenerateQueueWorker.f21366e.a(updates, z4, str);
        }

        /* access modifiers changed from: private */
        public static final void f(Updates updates, String str, View view) {
            updates.o2();
            UptodownApp.f13477F.J0((C2655d) null);
            if (!updates.f14579n0.isEmpty()) {
                updates.B5(str);
                updates.C5();
            }
            updates.C5();
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14591b, this.f14592c, this.f14593d, this.f14594e, this.f14595f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            C2316b.f();
            if (this.f14590a == 0) {
                u.b(obj);
                if (!this.f14591b.isFinishing()) {
                    this.f14591b.o2();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f14591b);
                    C2397A c5 = C2397A.c(this.f14591b.getLayoutInflater());
                    kotlin.jvm.internal.t.d(c5, "inflate(...)");
                    C2940B.a aVar = C2940B.f26458v;
                    Context applicationContext = this.f14591b.getApplicationContext();
                    kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
                    C2940B a5 = aVar.a(applicationContext);
                    a5.a();
                    C2655d Y4 = a5.Y(this.f14592c);
                    a5.m();
                    String str2 = this.f14593d;
                    ArrayList arrayList = this.f14594e;
                    Updates updates = this.f14591b;
                    boolean z4 = this.f14595f;
                    String str3 = this.f14592c;
                    TextView textView = c5.f22256f;
                    k.a aVar2 = S1.k.f32g;
                    textView.setTypeface(aVar2.w());
                    TextView textView2 = c5.f22256f;
                    if (Y4 != null) {
                        str = Y4.m();
                    } else {
                        str = null;
                    }
                    textView2.setText(str);
                    c5.f22254d.setTypeface(aVar2.x());
                    c5.f22254d.setText(str2);
                    c5.f22253c.setTypeface(aVar2.x());
                    Iterator it = arrayList.iterator();
                    kotlin.jvm.internal.t.d(it, "iterator(...)");
                    String str4 = "";
                    while (it.hasNext()) {
                        Object next = it.next();
                        kotlin.jvm.internal.t.d(next, "next(...)");
                        str4 = str4 + "- " + ((String) next) + 10;
                    }
                    c5.f22253c.setText(str4);
                    TextView textView3 = c5.f22255e;
                    k.a aVar3 = S1.k.f32g;
                    textView3.setTypeface(aVar3.w());
                    c5.f22255e.setOnClickListener(new U(updates, z4, str3));
                    c5.f22252b.setTypeface(aVar3.w());
                    c5.f22252b.setOnClickListener(new V(updates, str3));
                    builder.setCancelable(false);
                    builder.setView(c5.getRoot());
                    this.f14591b.P2(builder.create());
                    if (!this.f14591b.isFinishing() && this.f14591b.p2() != null) {
                        this.f14591b.b3();
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14596a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f14597b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Updates f14598c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f14599d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Updates updates, String str2, C2308e eVar) {
            super(2, eVar);
            this.f14597b = str;
            this.f14598c = updates;
            this.f14599d = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14597b, this.f14598c, this.f14599d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14596a == 0) {
                u.b(obj);
                String str = this.f14597b;
                int hashCode = str.hashCode();
                if (hashCode != -1972881700) {
                    if (hashCode != -1487908707) {
                        if (hashCode == 389690339 && str.equals("app_uninstalled")) {
                            this.f14598c.B5(this.f14599d);
                            this.f14598c.X5(false);
                        }
                    } else if (str.equals("app_updated")) {
                        this.f14598c.B5(this.f14599d);
                        this.f14598c.X5(false);
                        UptodownApp.f13477F.J0((C2655d) null);
                        this.f14598c.C5();
                    }
                } else if (str.equals("app_installed")) {
                    this.f14598c.X5(false);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14600a;

        e(Updates updates) {
            this.f14600a = updates;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f14600a.G5().f22727g.setPadding(0, 0, 0, 0);
        }
    }

    public static final class f implements C2612w {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14601a;

        f(Updates updates) {
            this.f14601a = updates;
        }

        public void a() {
            if (UptodownApp.f13477F.Z()) {
                Updates updates = this.f14601a;
                String string = updates.getString(R.string.disabled_apps_explanation);
                kotlin.jvm.internal.t.d(string, "getString(...)");
                updates.a2(string);
            }
        }
    }

    public static final class g extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14602a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Updates updates) {
            super(true);
            this.f14602a = updates;
        }

        public void handleOnBackPressed() {
            if (!this.f14602a.f14579n0.isEmpty()) {
                this.f14602a.f14579n0 = new ArrayList();
                this.f14602a.j6();
                return;
            }
            this.f14602a.finish();
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14603a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14604b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Updates f14605a;

            /* renamed from: com.uptodown.activities.Updates$h$a$a  reason: collision with other inner class name */
            public static final class C0138a implements C2597g {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Updates f14606a;

                /* renamed from: com.uptodown.activities.Updates$h$a$a$a  reason: collision with other inner class name */
                static final class C0139a extends kotlin.coroutines.jvm.internal.l implements k3.p {

                    /* renamed from: a  reason: collision with root package name */
                    int f14607a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ Updates f14608b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ String f14609c;

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ long f14610d;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0139a(Updates updates, String str, long j5, C2308e eVar) {
                        super(2, eVar);
                        this.f14608b = updates;
                        this.f14609c = str;
                        this.f14610d = j5;
                    }

                    public final C2308e create(Object obj, C2308e eVar) {
                        return new C0139a(this.f14608b, this.f14609c, this.f14610d, eVar);
                    }

                    public final Object invokeSuspend(Object obj) {
                        ArrayList arrayList;
                        C2316b.f();
                        if (this.f14607a == 0) {
                            u.b(obj);
                            int k5 = this.f14608b.H5(this.f14609c);
                            if (k5 >= 0 && this.f14608b.f14577Z != null) {
                                L f5 = this.f14608b.f14577Z;
                                kotlin.jvm.internal.t.b(f5);
                                if (f5.b().get(k5) instanceof L.a) {
                                    L f52 = this.f14608b.f14577Z;
                                    if (f52 != null) {
                                        arrayList = f52.b();
                                    } else {
                                        arrayList = null;
                                    }
                                    kotlin.jvm.internal.t.b(arrayList);
                                    Object obj2 = arrayList.get(k5);
                                    kotlin.jvm.internal.t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                                    ((L.a) obj2).a().b0(this.f14610d);
                                    L f53 = this.f14608b.f14577Z;
                                    if (f53 != null) {
                                        f53.notifyItemChanged(k5);
                                    }
                                }
                            }
                            return J.f19942a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Object invoke(w3.M m5, C2308e eVar) {
                        return ((C0139a) create(m5, eVar)).invokeSuspend(J.f19942a);
                    }
                }

                C0138a(Updates updates) {
                    this.f14606a = updates;
                }

                public void a(String str, long j5) {
                    kotlin.jvm.internal.t.e(str, "packageName");
                    C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this.f14606a), C2865c0.c(), (O) null, new C0139a(this.f14606a, str, j5, (C2308e) null), 2, (Object) null);
                }
            }

            a(Updates updates) {
                this.f14605a = updates;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14605a.G5().f22722b.setVisibility(0);
                    if (this.f14605a.G5().f22728h.isRefreshing()) {
                        this.f14605a.G5().f22728h.setRefreshing(false);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    this.f14605a.f14576Y = ((a0.b) cVar.a()).d();
                    this.f14605a.Y5(((a0.b) cVar.a()).d(), ((a0.b) cVar.a()).c(), ((a0.b) cVar.a()).b(), ((a0.b) cVar.a()).a());
                    this.f14605a.j6();
                    this.f14605a.G5().f22722b.setVisibility(8);
                    if (!((Boolean) this.f14605a.I5().f().getValue()).booleanValue()) {
                        new C2379a(new C0138a(this.f14605a), LifecycleOwnerKt.getLifecycleScope(this.f14605a), this.f14605a);
                        this.f14605a.I5().f().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                    }
                } else if (!(o5 instanceof O.b)) {
                    throw new W2.q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Updates updates, C2308e eVar) {
            super(2, eVar);
            this.f14604b = updates;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f14604b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14603a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f14604b.I5().g();
                a aVar = new a(this.f14604b);
                this.f14603a = 1;
                if (g5.collect(aVar, this) == f5) {
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
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class i implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14611a;

        i(Updates updates) {
            this.f14611a = updates;
        }

        public void onAnimationEnd(Animation animation) {
            this.f14611a.G5().f22727g.setPadding(0, 0, 0, (int) this.f14611a.getResources().getDimension(R.dimen.bottom_button_updates_padding));
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14612a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14613b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f14614c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(Updates updates, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f14613b = updates;
            this.f14614c = arrayList;
        }

        /* access modifiers changed from: private */
        public static final void j(I i5, Updates updates, View view) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                i5.f24687a = true;
                updates.z5();
                updates.j6();
                updates.startActivity(new Intent(updates.getApplicationContext(), PreferencesActivity.class), aVar.a(updates));
                AlertDialog p22 = updates.p2();
                if (p22 != null) {
                    p22.dismiss();
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void l(I i5, Updates updates, View view) {
            i5.f24687a = true;
            AlertDialog p22 = updates.p2();
            if (p22 != null) {
                p22.dismiss();
            }
            updates.z5();
            updates.j6();
        }

        /* access modifiers changed from: private */
        public static final void m(I i5, ArrayList arrayList, Updates updates, View view) {
            C2655d dVar;
            i5.f24687a = true;
            String str = null;
            if (arrayList.size() == 1) {
                dVar = (C2655d) arrayList.get(0);
            } else {
                dVar = null;
            }
            if (!UptodownApp.f13477F.M(updates)) {
                if (dVar != null) {
                    str = dVar.o();
                }
                updates.Q4(str, true);
                updates.j6();
            } else if (dVar != null) {
                updates.y4(dVar);
            }
            AlertDialog p22 = updates.p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }

        /* access modifiers changed from: private */
        public static final void n(I i5, Updates updates, DialogInterface dialogInterface) {
            if (!i5.f24687a) {
                updates.z5();
                updates.j6();
            }
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f14613b, this.f14614c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14612a == 0) {
                u.b(obj);
                AlertDialog p22 = this.f14613b.p2();
                if (p22 != null) {
                    p22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f14613b);
                C2438t c5 = C2438t.c(this.f14613b.getLayoutInflater());
                kotlin.jvm.internal.t.d(c5, "inflate(...)");
                I i5 = new I();
                Updates updates = this.f14613b;
                ArrayList arrayList = this.f14614c;
                TextView textView = c5.f23552f;
                k.a aVar = S1.k.f32g;
                textView.setTypeface(aVar.w());
                c5.f23549c.setTypeface(aVar.x());
                c5.f23551e.setTypeface(aVar.w());
                c5.f23548b.setTypeface(aVar.w());
                c5.f23550d.setTypeface(aVar.w());
                c5.f23551e.setOnClickListener(new W(i5, updates));
                c5.f23548b.setOnClickListener(new X(i5, updates));
                c5.f23550d.setOnClickListener(new Y(i5, arrayList, updates));
                builder.setView(c5.getRoot());
                this.f14613b.P2(builder.create());
                AlertDialog p23 = this.f14613b.p2();
                kotlin.jvm.internal.t.b(p23);
                p23.setOnDismissListener(new Z(i5, this.f14613b));
                if (!this.f14613b.isFinishing() && this.f14613b.p2() != null) {
                    this.f14613b.b3();
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class k extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14615a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(ComponentActivity componentActivity) {
            super(0);
            this.f14615a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14615a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class l extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14616a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(ComponentActivity componentActivity) {
            super(0);
            this.f14616a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14616a.getViewModelStore();
        }
    }

    public static final class m extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14617a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14618b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14617a = aVar;
            this.f14618b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14617a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14618b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.m.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class n implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14619a;

        public n(Updates updates) {
            this.f14619a = updates;
        }

        public final int compare(Object obj, Object obj2) {
            C2954m mVar = new C2954m();
            Updates updates = this.f14619a;
            String o5 = ((C2655d) obj).o();
            kotlin.jvm.internal.t.b(o5);
            Boolean valueOf = Boolean.valueOf(!kotlin.jvm.internal.t.a(mVar.h(updates, o5), this.f14619a.getPackageName()));
            C2954m mVar2 = new C2954m();
            Updates updates2 = this.f14619a;
            String o6 = ((C2655d) obj2).o();
            kotlin.jvm.internal.t.b(o6);
            return C2265a.a(valueOf, Boolean.valueOf(!kotlin.jvm.internal.t.a(mVar2.h(updates2, o6), this.f14619a.getPackageName())));
        }
    }

    static final class o extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14620a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14621b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Boolean f14622c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Integer f14623d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(Updates updates, Boolean bool, Integer num, C2308e eVar) {
            super(2, eVar);
            this.f14621b = updates;
            this.f14622c = bool;
            this.f14623d = num;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new o(this.f14621b, this.f14622c, this.f14623d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Integer num;
            C2316b.f();
            if (this.f14620a == 0) {
                u.b(obj);
                if (this.f14621b.G5().f22728h.isRefreshing()) {
                    this.f14621b.G5().f22728h.setRefreshing(false);
                }
                this.f14621b.P4(false);
                this.f14621b.X5(false);
                if (((Boolean) this.f14621b.I5().h().getValue()).booleanValue()) {
                    if (kotlin.jvm.internal.t.a(this.f14622c, kotlin.coroutines.jvm.internal.b.a(true))) {
                        Integer num2 = this.f14623d;
                        if (num2 != null && num2.intValue() == 1) {
                            Updates updates = this.f14621b;
                            String string = updates.getString(R.string.new_updates_available);
                            kotlin.jvm.internal.t.d(string, "getString(...)");
                            updates.u0(string);
                        } else {
                            Updates updates2 = this.f14621b;
                            String string2 = updates2.getString(R.string.new_updates_available);
                            kotlin.jvm.internal.t.d(string2, "getString(...)");
                            updates2.u0(string2);
                        }
                    } else {
                        Updates updates3 = this.f14621b;
                        String string3 = updates3.getString(R.string.no_new_updates_available);
                        kotlin.jvm.internal.t.d(string3, "getString(...)");
                        updates3.u0(string3);
                    }
                    this.f14621b.I5().h().setValue(kotlin.coroutines.jvm.internal.b.a(false));
                }
                L f5 = this.f14621b.f14577Z;
                if (f5 != null) {
                    L f52 = this.f14621b.f14577Z;
                    if (f52 != null) {
                        num = kotlin.coroutines.jvm.internal.b.b(f52.c());
                    } else {
                        num = null;
                    }
                    kotlin.jvm.internal.t.b(num);
                    f5.notifyItemChanged(num.intValue());
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((o) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class p extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14625b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(Updates updates, C2308e eVar) {
            super(2, eVar);
            this.f14625b = updates;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new p(this.f14625b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Integer num;
            C2316b.f();
            if (this.f14624a == 0) {
                u.b(obj);
                L f5 = this.f14625b.f14577Z;
                if (f5 != null) {
                    L f52 = this.f14625b.f14577Z;
                    if (f52 != null) {
                        num = kotlin.coroutines.jvm.internal.b.b(f52.c());
                    } else {
                        num = null;
                    }
                    kotlin.jvm.internal.t.b(num);
                    f5.notifyItemChanged(num.intValue());
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((p) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class q implements k2.J {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14626a;

        q(Updates updates) {
            this.f14626a = updates;
        }

        public void a(int i5) {
            Object obj;
            ArrayList b5;
            if (UptodownApp.f13477F.Z()) {
                L f5 = this.f14626a.f14577Z;
                if (f5 == null || (b5 = f5.b()) == null) {
                    obj = null;
                } else {
                    obj = b5.get(i5);
                }
                if (obj instanceof L.a) {
                    L f52 = this.f14626a.f14577Z;
                    kotlin.jvm.internal.t.b(f52);
                    Object obj2 = f52.b().get(i5);
                    kotlin.jvm.internal.t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                    this.f14626a.c4(((L.a) obj2).a(), i5);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: l2.d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(int r7) {
            /*
                r6 = this;
                com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f13477F
                boolean r0 = r0.Z()
                if (r0 == 0) goto L_0x0084
                com.uptodown.activities.Updates r0 = r6.f14626a
                R1.L r0 = r0.f14577Z
                r1 = 0
                if (r0 == 0) goto L_0x001c
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x001c
                java.lang.Object r0 = r0.get(r7)
                goto L_0x001d
            L_0x001c:
                r0 = r1
            L_0x001d:
                boolean r0 = r0 instanceof R1.L.a
                if (r0 == 0) goto L_0x003e
                com.uptodown.activities.Updates r0 = r6.f14626a
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.t.c(r7, r0)
                R1.L$a r7 = (R1.L.a) r7
                l2.d r1 = r7.a()
                goto L_0x006f
            L_0x003e:
                com.uptodown.activities.Updates r0 = r6.f14626a
                R1.L r0 = r0.f14577Z
                if (r0 == 0) goto L_0x0051
                java.util.ArrayList r0 = r0.b()
                if (r0 == 0) goto L_0x0051
                java.lang.Object r0 = r0.get(r7)
                goto L_0x0052
            L_0x0051:
                r0 = r1
            L_0x0052:
                boolean r0 = r0 instanceof l2.C2655d
                if (r0 == 0) goto L_0x006f
                com.uptodown.activities.Updates r0 = r6.f14626a
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.models.App"
                kotlin.jvm.internal.t.c(r7, r0)
                r1 = r7
                l2.d r1 = (l2.C2655d) r1
            L_0x006f:
                if (r1 == 0) goto L_0x0084
                long r2 = r1.b()
                r4 = 0
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 <= 0) goto L_0x0084
                com.uptodown.activities.Updates r7 = r6.f14626a
                long r0 = r1.b()
                r7.H2(r0)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.q.b(int):void");
        }

        public void c(int i5) {
            if (this.f14626a.V5(i5)) {
                L f5 = this.f14626a.f14577Z;
                kotlin.jvm.internal.t.b(f5);
                Object obj = f5.b().get(i5);
                kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((L.a) obj).a().a0(true);
                L f52 = this.f14626a.f14577Z;
                kotlin.jvm.internal.t.b(f52);
                f52.notifyItemChanged(i5);
            }
        }

        public void d(int i5) {
            if (UptodownApp.f13477F.Z() && this.f14626a.V5(i5)) {
                L f5 = this.f14626a.f14577Z;
                kotlin.jvm.internal.t.b(f5);
                Object obj = f5.b().get(i5);
                kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f14626a.H4(((L.a) obj).a());
                this.f14626a.j6();
                L f52 = this.f14626a.f14577Z;
                kotlin.jvm.internal.t.b(f52);
                f52.notifyItemChanged(i5);
            }
        }

        public void e(int i5) {
            if (UptodownApp.f13477F.Z()) {
                this.f14626a.y5(i5);
                L f5 = this.f14626a.f14577Z;
                if (f5 != null) {
                    f5.l(false);
                }
            }
        }

        public void f(int i5) {
            if (this.f14626a.V5(i5)) {
                L f5 = this.f14626a.f14577Z;
                kotlin.jvm.internal.t.b(f5);
                Object obj = f5.b().get(i5);
                kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((L.a) obj).a().a0(false);
                L f52 = this.f14626a.f14577Z;
                kotlin.jvm.internal.t.b(f52);
                f52.notifyItemChanged(i5);
            }
        }
    }

    static final class r extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14627a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14628b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f14629c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Updates f14630d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f14631e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(int i5, Bundle bundle, Updates updates, String str, C2308e eVar) {
            super(2, eVar);
            this.f14628b = i5;
            this.f14629c = bundle;
            this.f14630d = updates;
            this.f14631e = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new r(this.f14628b, this.f14629c, this.f14630d, this.f14631e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int g5;
            L f5;
            ArrayList E4;
            ArrayList arrayList;
            ArrayList i5;
            C2655d dVar;
            C2316b.f();
            if (this.f14627a == 0) {
                u.b(obj);
                int i6 = this.f14628b;
                boolean z4 = true;
                if (i6 != 110) {
                    if (i6 != 201) {
                        if (i6 != 205 && i6 != 206) {
                            switch (i6) {
                                case 102:
                                    Bundle bundle = new Bundle();
                                    String str = this.f14631e;
                                    if (str != null) {
                                        bundle.putString("packagename", str);
                                    }
                                    F s22 = this.f14630d.s2();
                                    if (s22 != null) {
                                        s22.d("update_download_failed", bundle);
                                    }
                                    if (!this.f14630d.w2()) {
                                        Updates updates = this.f14630d;
                                        String string = updates.getString(R.string.download_error_message);
                                        kotlin.jvm.internal.t.d(string, "getString(...)");
                                        updates.a2(string);
                                    }
                                    if (!this.f14630d.f14579n0.isEmpty()) {
                                        String str2 = this.f14631e;
                                        if (str2 != null) {
                                            this.f14630d.B5(str2);
                                        } else {
                                            kotlin.jvm.internal.t.b(this.f14630d.f14579n0.remove(0));
                                        }
                                        this.f14630d.C5();
                                    }
                                    J j5 = J.f19942a;
                                    break;
                                case 103:
                                    UptodownApp.a aVar = UptodownApp.f13477F;
                                    if (aVar.D().isEmpty() && ((E4 = aVar.E()) == null || E4.isEmpty())) {
                                        this.f14630d.X5(false);
                                    }
                                    J j6 = J.f19942a;
                                    break;
                                case 104:
                                    Updates updates2 = this.f14630d;
                                    String string2 = updates2.getString(R.string.no_free_space);
                                    kotlin.jvm.internal.t.d(string2, "getString(...)");
                                    updates2.u0(string2);
                                    this.f14630d.j6();
                                    J j7 = J.f19942a;
                                    break;
                                case 105:
                                    Bundle bundle2 = this.f14629c;
                                    if (bundle2 != null) {
                                        if (Build.VERSION.SDK_INT >= 33) {
                                            arrayList = bundle2.getParcelableArrayList("apps_parcelable", C2655d.class);
                                        } else {
                                            arrayList = bundle2.getParcelableArrayList("apps_parcelable");
                                        }
                                        if (arrayList != null) {
                                            this.f14630d.a6(arrayList);
                                        }
                                    }
                                    J j8 = J.f19942a;
                                    break;
                                case 106:
                                    this.f14630d.C5();
                                    J j9 = J.f19942a;
                                    break;
                                case 107:
                                    this.f14630d.f6(this.f14631e);
                                    L f52 = this.f14630d.f14577Z;
                                    if (f52 != null) {
                                        f52.notifyDataSetChanged();
                                    }
                                    J j10 = J.f19942a;
                                    break;
                                case 108:
                                    if (this.f14630d.f14579n0.isEmpty() && (i5 = this.f14630d.f14576Y) != null && !i5.isEmpty()) {
                                        ArrayList i52 = this.f14630d.f14576Y;
                                        kotlin.jvm.internal.t.b(i52);
                                        Iterator it = i52.iterator();
                                        kotlin.jvm.internal.t.d(it, "iterator(...)");
                                        while (true) {
                                            dVar = null;
                                            if (it.hasNext()) {
                                                Object next = it.next();
                                                kotlin.jvm.internal.t.d(next, "next(...)");
                                                L.a aVar2 = (L.a) next;
                                                if (t3.s.F(aVar2.a().o(), this.f14631e, false, 2, (Object) null)) {
                                                    C2940B a5 = C2940B.f26458v.a(this.f14630d);
                                                    a5.a();
                                                    C2668q a6 = aVar2.b().a();
                                                    kotlin.jvm.internal.t.b(a6);
                                                    C2668q i02 = a5.i0(a6.q());
                                                    a5.m();
                                                    if (i02 != null && i02.f()) {
                                                        dVar = aVar2.a();
                                                    }
                                                }
                                            }
                                        }
                                        if (dVar != null) {
                                            this.f14630d.f14579n0.add(dVar);
                                        }
                                    }
                                    this.f14630d.C5();
                                    J j11 = J.f19942a;
                                    break;
                                default:
                                    J j12 = J.f19942a;
                                    break;
                            }
                        } else {
                            J j13 = J.f19942a;
                        }
                    } else {
                        this.f14630d.f6(this.f14631e);
                        L f53 = this.f14630d.f14577Z;
                        if (f53 != null) {
                            f53.d(this.f14631e);
                        }
                        J j14 = J.f19942a;
                    }
                    z4 = false;
                } else {
                    this.f14630d.j6();
                    new C1598a.b();
                }
                if (this.f14630d.E4()) {
                    this.f14630d.R4(this.f14628b);
                }
                if (z4 && (g5 = this.f14630d.F5(this.f14631e)) > -1 && (f5 = this.f14630d.f14577Z) != null) {
                    f5.notifyItemChanged(g5);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((r) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class s extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14632a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Updates f14633b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14634c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f14635d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(Updates updates, String str, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14633b = updates;
            this.f14634c = str;
            this.f14635d = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new s(this.f14633b, this.f14634c, this.f14635d, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                c3.C2316b.f()
                int r0 = r7.f14632a
                if (r0 != 0) goto L_0x0104
                W2.u.b(r8)
                com.uptodown.activities.Updates r8 = r7.f14633b
                R1.L r8 = r8.f14577Z
                if (r8 == 0) goto L_0x0101
                com.uptodown.activities.Updates r8 = r7.f14633b
                java.lang.String r0 = r7.f14634c
                int r8 = r8.F5(r0)
                r0 = -1
                r1 = 1
                r2 = 0
                if (r8 <= r0) goto L_0x0021
                r0 = r1
                goto L_0x0022
            L_0x0021:
                r0 = r2
            L_0x0022:
                int r3 = r7.f14635d
                r4 = 306(0x132, float:4.29E-43)
                if (r3 != r4) goto L_0x0048
                if (r0 == 0) goto L_0x0101
                com.uptodown.activities.Updates r0 = r7.f14633b
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                r0.remove(r8)
                com.uptodown.activities.Updates r0 = r7.f14633b
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemRemoved(r8)
                goto L_0x0101
            L_0x0048:
                r4 = 301(0x12d, float:4.22E-43)
                if (r3 != r4) goto L_0x005c
                if (r0 == 0) goto L_0x0101
                com.uptodown.activities.Updates r0 = r7.f14633b
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r8)
                goto L_0x0101
            L_0x005c:
                r4 = 305(0x131, float:4.27E-43)
                if (r3 == r4) goto L_0x0101
                r4 = 302(0x12e, float:4.23E-43)
                if (r3 != r4) goto L_0x007b
                if (r0 == 0) goto L_0x0074
                com.uptodown.activities.Updates r0 = r7.f14633b
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r8)
                goto L_0x0101
            L_0x0074:
                com.uptodown.activities.Updates r8 = r7.f14633b
                r8.X5(r2)
                goto L_0x0101
            L_0x007b:
                if (r0 == 0) goto L_0x00b3
                com.uptodown.activities.Updates r3 = r7.f14633b
                R1.L r3 = r3.f14577Z
                kotlin.jvm.internal.t.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r8)
                boolean r3 = r3 instanceof R1.L.a
                if (r3 == 0) goto L_0x00b3
                com.uptodown.activities.Updates r3 = r7.f14633b
                R1.L r3 = r3.f14577Z
                kotlin.jvm.internal.t.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r8)
                java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.t.c(r3, r4)
                R1.L$a r3 = (R1.L.a) r3
                l2.d r3 = r3.a()
                java.lang.String r3 = r3.m()
                goto L_0x00b4
            L_0x00b3:
                r3 = 0
            L_0x00b4:
                int r4 = r7.f14635d
                r5 = 303(0x12f, float:4.25E-43)
                r6 = 2131952111(0x7f1301ef, float:1.9540656E38)
                if (r4 == r5) goto L_0x00e4
                r5 = 304(0x130, float:4.26E-43)
                if (r4 == r5) goto L_0x00da
                r5 = 307(0x133, float:4.3E-43)
                if (r4 == r5) goto L_0x00d0
                com.uptodown.activities.Updates r4 = r7.f14633b
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r2] = r3
                java.lang.String r1 = r4.getString(r6, r1)
                goto L_0x00ee
            L_0x00d0:
                com.uptodown.activities.Updates r1 = r7.f14633b
                r2 = 2131952026(0x7f13019a, float:1.9540483E38)
                java.lang.String r1 = r1.getString(r2)
                goto L_0x00ee
            L_0x00da:
                com.uptodown.activities.Updates r1 = r7.f14633b
                r2 = 2131952349(0x7f1302dd, float:1.9541138E38)
                java.lang.String r1 = r1.getString(r2)
                goto L_0x00ee
            L_0x00e4:
                com.uptodown.activities.Updates r4 = r7.f14633b
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r2] = r3
                java.lang.String r1 = r4.getString(r6, r1)
            L_0x00ee:
                com.uptodown.activities.Updates r2 = r7.f14633b
                r2.a2(r1)
                if (r0 == 0) goto L_0x0101
                com.uptodown.activities.Updates r0 = r7.f14633b
                R1.L r0 = r0.f14577Z
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r8)
            L_0x0101:
                W2.J r8 = W2.J.f19942a
                return r8
            L_0x0104:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.s.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((s) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class t implements K {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Updates f14636a;

        t(Updates updates) {
            this.f14636a = updates;
        }

        public void a() {
            if (UptodownApp.f13477F.Z()) {
                this.f14636a.W5();
            }
        }

        public void b() {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z() && UptodownApp.a.O0(aVar, this.f14636a, false, 2, (Object) null)) {
                this.f14636a.I5().h().setValue(Boolean.TRUE);
            }
        }
    }

    public Updates() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new M5(this));
        kotlin.jvm.internal.t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14585t0 = registerForActivityResult;
        this.f14586u0 = new g(this);
    }

    private final void A5() {
        if (H.f26488a.f() || this.f14580o0) {
            b6();
        } else {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void B5(String str) {
        if (str != null) {
            Iterator it = this.f14579n0.iterator();
            int i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i5 = -1;
                    break;
                }
                int i6 = i5 + 1;
                if (t3.s.E(((C2655d) it.next()).o(), str, true)) {
                    break;
                }
                i5 = i6;
            }
            if (i5 >= 0) {
                this.f14579n0.remove(i5);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void C5() {
        C2668q qVar;
        if (!this.f14579n0.isEmpty() && S1.k.f32g.i() == null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.C() == null && !aVar.T("GenerateQueueWorker", this) && !aVar.T("downloadApkWorker", this)) {
                Object obj = this.f14579n0.get(0);
                kotlin.jvm.internal.t.d(obj, "get(...)");
                C2655d dVar = (C2655d) obj;
                C2940B a5 = C2940B.f26458v.a(this);
                a5.a();
                String o5 = dVar.o();
                kotlin.jvm.internal.t.b(o5);
                T G02 = a5.G0(o5);
                if (G02 != null) {
                    qVar = G02.b(this);
                } else {
                    qVar = null;
                }
                a5.m();
                h6(dVar.m());
                if (qVar != null && qVar.f()) {
                    String o6 = dVar.o();
                    kotlin.jvm.internal.t.b(o6);
                    aVar.d0(o6);
                    S5();
                    return;
                } else if (!aVar.M(this)) {
                    Data build = new Data.Builder().putBoolean("downloadAnyway", this.f14580o0).build();
                    WorkManager.Companion.getInstance(this).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DownloadUpdatesWorker.class).addTag("DownloadUpdatesWorker")).setInputData(build)).build());
                    return;
                } else {
                    return;
                }
            }
        }
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.l(false);
        }
        j6();
    }

    /* access modifiers changed from: private */
    public static final void E5(Updates updates, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            updates.Q2();
            updates.X5(false);
        }
    }

    /* access modifiers changed from: private */
    public final int F5(String str) {
        L l5;
        if (str == null || (l5 = this.f14577Z) == null) {
            return -1;
        }
        kotlin.jvm.internal.t.b(l5);
        ArrayList<Object> b5 = l5.b();
        int i5 = 0;
        for (Object obj : b5) {
            int i6 = i5 + 1;
            if (obj instanceof L.a) {
                Object obj2 = b5.get(i5);
                kotlin.jvm.internal.t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                if (t3.s.E(((L.a) obj2).a().o(), str, true)) {
                    return i5;
                }
            }
            i5 = i6;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final Z0 G5() {
        return (Z0) this.f14574W.getValue();
    }

    /* access modifiers changed from: private */
    public final int H5(String str) {
        ArrayList arrayList;
        L l5 = this.f14577Z;
        ArrayList arrayList2 = null;
        if (l5 != null) {
            arrayList = l5.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        L l6 = this.f14577Z;
        if (l6 != null) {
            arrayList2 = l6.b();
        }
        kotlin.jvm.internal.t.b(arrayList2);
        int i5 = 0;
        for (Object next : arrayList2) {
            int i6 = i5 + 1;
            if ((next instanceof L.a) && t3.s.E(((L.a) next).a().o(), str, true)) {
                return i5;
            }
            i5 = i6;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final a0 I5() {
        return (a0) this.f14575X.getValue();
    }

    private final void J5() {
        G5().f22732l.setVisibility(0);
        G5().f22726f.setVisibility(8);
        RelativeLayout relativeLayout = G5().f22724d;
        kotlin.jvm.internal.t.d(relativeLayout, "rlBottomBoxDownloadButtonUpdates");
        if (relativeLayout.getVisibility() == 0) {
            D2.n nVar = new D2.n(this);
            RelativeLayout relativeLayout2 = G5().f22724d;
            kotlin.jvm.internal.t.d(relativeLayout2, "rlBottomBoxDownloadButtonUpdates");
            nVar.g(relativeLayout2, R.anim.slide_out_bottom, new e(this));
            D2.n nVar2 = new D2.n(this);
            RelativeLayout relativeLayout3 = G5().f22725e;
            kotlin.jvm.internal.t.d(relativeLayout3, "rlBottomBoxShadow");
            nVar2.i(relativeLayout3, R.anim.slide_out_bottom);
            G5().f22724d.setVisibility(8);
        }
    }

    private final void L5() {
        setContentView((View) G5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            G5().f22729i.setNavigationIcon(drawable);
            G5().f22729i.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        G5().f22729i.setNavigationOnClickListener(new N5(this));
        TextView textView = G5().f22734n;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        G5().f22729i.inflateMenu(R.menu.toolbar_menu_updates);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable);
        if (drawable2 != null) {
            G5().f22729i.setOverflowIcon(drawable2);
        }
        a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
        boolean h02 = aVar2.h0(this);
        G5().f22729i.getMenu().findItem(R.id.action_show_system_apps).setChecked(h02);
        G5().f22729i.getMenu().findItem(R.id.action_show_system_services).setChecked(aVar2.i0(this));
        Toolbar toolbar = G5().f22729i;
        kotlin.jvm.internal.t.d(toolbar, "toolbarUpdates");
        x4(R.id.action_show_system_services, h02, toolbar);
        G5().f22729i.setOnMenuItemClickListener(new O5(this));
        G5().f22727g.setLayoutManager(new LinearLayoutManager(this, 1, false));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        G5().f22727g.addItemDecoration(new B2.l(dimension, dimension));
        G5().f22727g.setItemAnimator(defaultItemAnimator);
        G5().f22722b.setOnClickListener(new P5());
        G5().f22732l.setTypeface(aVar.w());
        G5().f22732l.setOnClickListener(new Q5(this));
        G5().f22733m.setTypeface(aVar.w());
        G5().f22731k.setTypeface(aVar.x());
        G5().f22730j.setTypeface(aVar.w());
        G5().f22730j.setOnClickListener(new R5(this));
        G5().f22728h.setColorSchemeColors(ContextCompat.getColor(this, R.color.main_blue), ContextCompat.getColor(this, R.color.main_blue_pressed));
        G5().f22728h.setOnRefreshListener(new S5(this));
    }

    /* access modifiers changed from: private */
    public static final void M5(Updates updates, View view) {
        updates.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean N5(Updates updates, MenuItem menuItem) {
        kotlin.jvm.internal.t.e(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_show_system_apps) {
            boolean isChecked = menuItem.isChecked();
            menuItem.setChecked(!isChecked);
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            Context applicationContext = updates.getApplicationContext();
            kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
            aVar.i1(applicationContext, !isChecked);
            if (isChecked) {
                Context applicationContext2 = updates.getApplicationContext();
                kotlin.jvm.internal.t.d(applicationContext2, "getApplicationContext(...)");
                aVar.j1(applicationContext2, false);
                Toolbar toolbar = updates.G5().f22729i;
                kotlin.jvm.internal.t.d(toolbar, "toolbarUpdates");
                updates.x4(R.id.action_show_system_services, false, toolbar);
                Toolbar toolbar2 = updates.G5().f22729i;
                kotlin.jvm.internal.t.d(toolbar2, "toolbarUpdates");
                updates.N3(R.id.action_show_system_services, false, toolbar2);
                updates.X5(true);
            } else {
                Toolbar toolbar3 = updates.G5().f22729i;
                kotlin.jvm.internal.t.d(toolbar3, "toolbarUpdates");
                updates.x4(R.id.action_show_system_services, true, toolbar3);
                if (UptodownApp.a.O0(UptodownApp.f13477F, updates, false, 2, (Object) null)) {
                    updates.I5().h().setValue(Boolean.TRUE);
                }
            }
        } else if (menuItem.getItemId() == R.id.action_show_system_services) {
            boolean isChecked2 = menuItem.isChecked();
            menuItem.setChecked(!isChecked2);
            a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
            Context applicationContext3 = updates.getApplicationContext();
            kotlin.jvm.internal.t.d(applicationContext3, "getApplicationContext(...)");
            aVar2.j1(applicationContext3, !isChecked2);
            if (isChecked2) {
                updates.X5(true);
            } else if (UptodownApp.a.O0(UptodownApp.f13477F, updates, false, 2, (Object) null)) {
                updates.I5().h().setValue(Boolean.TRUE);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void O5(View view) {
    }

    /* access modifiers changed from: private */
    public static final void P5(Updates updates, View view) {
        if (UptodownApp.f13477F.Z()) {
            updates.A5();
        }
    }

    /* access modifiers changed from: private */
    public static final void Q5(Updates updates, View view) {
        if (UptodownApp.f13477F.Z()) {
            updates.z5();
            updates.j6();
        }
    }

    /* access modifiers changed from: private */
    public static final void R5(Updates updates) {
        if (UptodownApp.a.O0(UptodownApp.f13477F, updates, false, 2, (Object) null)) {
            updates.I5().h().setValue(Boolean.TRUE);
        } else {
            updates.G5().f22728h.setRefreshing(false);
        }
    }

    private final void S5() {
        C2668q qVar;
        if (S1.k.f32g.i() == null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.C() == null) {
                if (!this.f14579n0.isEmpty()) {
                    Object remove = this.f14579n0.remove(0);
                    kotlin.jvm.internal.t.d(remove, "removeAt(...)");
                    C2655d dVar = (C2655d) remove;
                    C2940B.a aVar2 = C2940B.f26458v;
                    Context applicationContext = getApplicationContext();
                    kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
                    C2940B a5 = aVar2.a(applicationContext);
                    a5.a();
                    String o5 = dVar.o();
                    kotlin.jvm.internal.t.b(o5);
                    T G02 = a5.G0(o5);
                    if (G02 != null) {
                        qVar = G02.b(this);
                    } else {
                        qVar = null;
                    }
                    a5.m();
                    h6(dVar.m());
                    if (qVar != null && qVar.f()) {
                        aVar.J0(dVar);
                        File n5 = qVar.n();
                        if (n5 != null) {
                            if (G02.n() == 1) {
                                C4(G02, n5);
                            } else {
                                C2(n5, (String) null);
                            }
                            if (this.f14579n0.isEmpty()) {
                                z5();
                                return;
                            }
                            return;
                        }
                    }
                    C5();
                    return;
                }
                j6();
                return;
            }
        }
        j6();
    }

    /* access modifiers changed from: private */
    public final boolean V5(int i5) {
        ArrayList arrayList;
        ArrayList arrayList2;
        L l5 = this.f14577Z;
        if (l5 == null || i5 < 0) {
            return false;
        }
        kotlin.jvm.internal.t.b(l5);
        if (i5 >= l5.getItemCount()) {
            return false;
        }
        L l6 = this.f14577Z;
        ArrayList arrayList3 = null;
        if (l6 != null) {
            arrayList = l6.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        L l7 = this.f14577Z;
        if (l7 != null) {
            arrayList2 = l7.b();
        } else {
            arrayList2 = null;
        }
        kotlin.jvm.internal.t.b(arrayList2);
        if (arrayList2.size() <= i5) {
            return false;
        }
        L l8 = this.f14577Z;
        if (l8 != null) {
            arrayList3 = l8.b();
        }
        kotlin.jvm.internal.t.b(arrayList3);
        if (arrayList3.get(i5) instanceof L.a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void W5() {
        this.f14585t0.launch(new Intent(getApplicationContext(), GdprPrivacySettings.class), UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: private */
    public final void X5(boolean z4) {
        I5().e(this, z4);
    }

    /* access modifiers changed from: private */
    public final void Y5(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        if (this.f14577Z == null) {
            this.f14577Z = new L(this.f14581p0, this.f14582q0, this.f14583r0, this.f14584s0);
            G5().f22727g.setAdapter(this.f14577Z);
        }
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.j(arrayList, arrayList2, arrayList3, arrayList4, this);
        }
    }

    private final void Z5() {
        if (this.f14579n0.size() > 0) {
            G5().f22732l.setVisibility(8);
            G5().f22726f.setVisibility(0);
        } else {
            G5().f22732l.setVisibility(0);
            G5().f22726f.setVisibility(8);
        }
        RelativeLayout relativeLayout = G5().f22724d;
        kotlin.jvm.internal.t.d(relativeLayout, "rlBottomBoxDownloadButtonUpdates");
        if (relativeLayout.getVisibility() == 8) {
            D2.n nVar = new D2.n(this);
            RelativeLayout relativeLayout2 = G5().f22724d;
            kotlin.jvm.internal.t.d(relativeLayout2, "rlBottomBoxDownloadButtonUpdates");
            nVar.g(relativeLayout2, R.anim.slide_in_bottom, new i(this));
            D2.n nVar2 = new D2.n(this);
            RelativeLayout relativeLayout3 = G5().f22725e;
            kotlin.jvm.internal.t.d(relativeLayout3, "rlBottomBoxShadow");
            nVar2.h(relativeLayout3, R.anim.slide_in_bottom);
            G5().f22724d.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void a6(ArrayList arrayList) {
        if (B4()) {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new j(this, arrayList, (C2308e) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void b6() {
        if (!UptodownApp.f13477F.T("downloadApkWorker", this)) {
            this.f14579n0 = new ArrayList();
            ArrayList arrayList = this.f14576Y;
            kotlin.jvm.internal.t.b(arrayList);
            Iterator it = arrayList.iterator();
            kotlin.jvm.internal.t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.t.d(next, "next(...)");
                this.f14579n0.add(((L.a) next).a());
            }
            ArrayList arrayList2 = this.f14579n0;
            if (arrayList2.size() > 1) {
                C2250q.t(arrayList2, new n(this));
            }
            Iterator it2 = this.f14579n0.iterator();
            kotlin.jvm.internal.t.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                kotlin.jvm.internal.t.d(next2, "next(...)");
                y4((C2655d) next2);
            }
            L l5 = this.f14577Z;
            if (l5 != null) {
                l5.e();
            }
            j6();
            C5();
            return;
        }
        L l6 = this.f14577Z;
        if (l6 != null) {
            l6.l(false);
        }
    }

    /* access modifiers changed from: private */
    public final void f6(String str) {
        T G02;
        if (!this.f14579n0.isEmpty()) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.E() != null) {
                ArrayList E4 = aVar.E();
                kotlin.jvm.internal.t.b(E4);
                if (!E4.isEmpty()) {
                    Object obj = this.f14579n0.get(0);
                    kotlin.jvm.internal.t.d(obj, "get(...)");
                    C2655d dVar = (C2655d) obj;
                    C2940B a5 = C2940B.f26458v.a(this);
                    a5.a();
                    C2668q qVar = null;
                    if (!(str == null || (G02 = a5.G0(str)) == null)) {
                        qVar = G02.b(this);
                    }
                    a5.m();
                    G5().f22726f.setOnClickListener(new T5());
                    G5().f22733m.setText(dVar.m());
                    G5().f22731k.setText(getString(R.string.dialog_update_all_desc, new Object[]{String.valueOf(this.f14579n0.size())}));
                    if (qVar != null) {
                        G5().f22723c.setIndeterminate(false);
                        G5().f22723c.setProgress(qVar.x());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void g6(View view) {
    }

    private final void h6(String str) {
        if (!this.f14579n0.isEmpty()) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.E() != null) {
                ArrayList E4 = aVar.E();
                kotlin.jvm.internal.t.b(E4);
                if (!E4.isEmpty()) {
                    G5().f22733m.setText(str);
                    G5().f22731k.setText(getString(R.string.dialog_update_all_desc, new Object[]{String.valueOf(this.f14579n0.size())}));
                    G5().f22723c.setIndeterminate(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void j6() {
        ArrayList arrayList = this.f14576Y;
        if (arrayList != null) {
            kotlin.jvm.internal.t.b(arrayList);
            if (arrayList.size() > 1) {
                Z5();
                return;
            }
        }
        J5();
    }

    /* access modifiers changed from: private */
    public static final Z0 x5(Updates updates) {
        return Z0.c(updates.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void y5(int i5) {
        if (V5(i5)) {
            L l5 = this.f14577Z;
            kotlin.jvm.internal.t.b(l5);
            Object obj = l5.b().get(i5);
            kotlin.jvm.internal.t.c(obj, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
            L.a aVar = (L.a) obj;
            B5(aVar.a().o());
            G4(aVar.a());
            L l6 = this.f14577Z;
            if (l6 != null) {
                l6.notifyItemChanged(i5);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void z5() {
        ArrayList b5;
        this.f14579n0 = new ArrayList();
        Integer num = null;
        UptodownApp.f13477F.J0((C2655d) null);
        J5();
        L l5 = this.f14577Z;
        if (!(l5 == null || (b5 = l5.b()) == null)) {
            num = Integer.valueOf(b5.size());
        }
        if (num != null && num.intValue() > 0) {
            int intValue = num.intValue();
            for (int i5 = 0; i5 < intValue; i5++) {
                y5(i5);
            }
        }
    }

    public final Object D5(String str, String str2, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new d(str, this, str2, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public void I4(int i5, int i6) {
        X5(false);
    }

    public void J4(int i5, int i6) {
        X5(false);
    }

    public final void K5() {
        TextView textView;
        AlertDialog p22;
        if (w2() && H.f26488a.f()) {
            AlertDialog p23 = p2();
            if (p23 != null) {
                textView = (TextView) p23.findViewById(R.id.tv_title_dialog_no_wifi_connection);
            } else {
                textView = null;
            }
            if (textView != null && (p22 = p2()) != null) {
                p22.dismiss();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void M4() {
        X5(false);
    }

    public void N2() {
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.h();
        }
    }

    public void R3(String str, boolean z4, ArrayList arrayList) {
        kotlin.jvm.internal.t.e(str, "packagename");
        kotlin.jvm.internal.t.e(arrayList, "missingFeatures");
        String string = getString(R.string.msg_warning_incompatible_required_features_to_install);
        kotlin.jvm.internal.t.d(string, "getString(...)");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, str, string, arrayList, z4, (C2308e) null), 2, (Object) null);
    }

    public final void T5() {
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.h();
        }
        UptodownApp.f13477F.J0((C2655d) null);
        C5();
    }

    public final void U5(String str) {
        String m5;
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.h();
        }
        L l6 = this.f14577Z;
        if (l6 != null) {
            l6.g(this, str);
        }
        UptodownApp.f13477F.J0((C2655d) null);
        C5();
        C2655d C4 = new C2954m().C(this, str);
        if (C4 != null && (m5 = C4.m()) != null && m5.length() != 0) {
            String string = getString(R.string.install_compatibility_error, new Object[]{C4.m()});
            kotlin.jvm.internal.t.d(string, "getString(...)");
            u0(string);
        }
    }

    public void V2(File file) {
        kotlin.jvm.internal.t.e(file, "xapkFile");
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.h();
        }
        L l6 = this.f14577Z;
        if (l6 != null) {
            l6.f(file, this);
        }
    }

    public void W2(File file, int i5) {
        kotlin.jvm.internal.t.e(file, "file");
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.f(file, this);
        }
    }

    public void Z2(File file) {
        kotlin.jvm.internal.t.e(file, "xapkFile");
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.k(file, this);
        }
    }

    public final void c6(Boolean bool, Integer num) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new o(this, bool, num, (C2308e) null), 2, (Object) null);
    }

    public final void d6() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new p(this, (C2308e) null), 2, (Object) null);
    }

    public final void e6(int i5, String str, Bundle bundle) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new r(i5, bundle, this, str, (C2308e) null), 2, (Object) null);
    }

    public final void i6(int i5, String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new s(this, str, i5, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L5();
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
        this.f14578m0 = aVar.Y(applicationContext);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new h(this, (C2308e) null), 2, (Object) null);
        getOnBackPressedDispatcher().addCallback(this, this.f14586u0);
        X5(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (DownloadWorker.f21359d.h()) {
            WorkManager.Companion.getInstance(this).cancelAllWorkByTag("DownloadUpdatesWorker");
            UptodownApp.f13477F.g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        L l5 = this.f14577Z;
        if (l5 != null) {
            l5.notifyDataSetChanged();
        }
        z2.M.f26506a.h(this);
        C5();
    }
}
