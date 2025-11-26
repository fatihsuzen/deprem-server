package com.uptodown.activities;

import O1.C0829l2;
import O1.C0837m2;
import O1.C0845n2;
import O1.C0853o2;
import O1.C0861p2;
import O1.C0869q2;
import O1.C0876r2;
import O1.T2;
import R1.C0984o;
import R1.L;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1618v;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.GenerateQueueWorker;
import g2.C2379a;
import h2.C2418i0;
import h2.C2438t;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import k2.C2592b;
import k2.C2597g;
import k2.C2612w;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2668q;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import z2.C2940B;
import z2.O;
import z3.C2973f;
import z3.D;

public final class MyApps extends T2 {

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14133W = m.b(new C0829l2(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14134X = new ViewModelLazy(M.b(C1618v.class), new h(this), new g(this), new i((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public C0984o f14135Y;

    /* renamed from: Z  reason: collision with root package name */
    private final a f14136Z = new a(this);

    /* renamed from: m0  reason: collision with root package name */
    private final j f14137m0 = new j(this);

    /* renamed from: n0  reason: collision with root package name */
    private final c f14138n0 = new c(this);

    public static final class a implements C2592b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f14139a;

        a(MyApps myApps) {
            this.f14139a = myApps;
        }

        public void a(int i5) {
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (this.f14139a.x5(i5)) {
                C0984o a5 = this.f14139a.f14135Y;
                t.b(a5);
                Object obj = a5.b().get(i5);
                t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                this.f14139a.c4((C2655d) obj, i5);
            } else if (this.f14139a.y5(i5)) {
                C0984o a52 = this.f14139a.f14135Y;
                t.b(a52);
                Object obj2 = a52.b().get(i5);
                t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f14139a.c4(((L.a) obj2).a(), i5);
            }
        }

        public void b(int i5) {
            C2655d dVar;
            if (UptodownApp.f13477F.Z()) {
                if (this.f14139a.x5(i5)) {
                    C0984o a5 = this.f14139a.f14135Y;
                    t.b(a5);
                    Object obj = a5.b().get(i5);
                    t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                    dVar = (C2655d) obj;
                } else if (this.f14139a.y5(i5)) {
                    C0984o a52 = this.f14139a.f14135Y;
                    t.b(a52);
                    Object obj2 = a52.b().get(i5);
                    t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                    dVar = ((L.a) obj2).a();
                } else {
                    dVar = null;
                }
                if (dVar != null && dVar.b() > 0) {
                    this.f14139a.H2(dVar.b());
                }
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14140a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f14141b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14142c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f14143d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MyApps myApps, String str, String str2, C2308e eVar) {
            super(2, eVar);
            this.f14141b = myApps;
            this.f14142c = str;
            this.f14143d = str2;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14141b, this.f14142c, this.f14143d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
            if (r0.equals("app_updated") != false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            if (r0.equals("app_installed") == false) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                c3.C2316b.f()
                int r0 = r3.f14140a
                if (r0 != 0) goto L_0x006d
                W2.u.b(r4)
                com.uptodown.activities.MyApps r4 = r3.f14141b
                java.lang.String r0 = r3.f14142c
                int r4 = r4.m5(r0)
                java.lang.String r0 = r3.f14143d
                int r1 = r0.hashCode()
                r2 = -1972881700(0xffffffff8a6836dc, float:-1.11807116E-32)
                if (r1 == r2) goto L_0x0059
                r2 = -1487908707(0xffffffffa750509d, float:-2.89095E-15)
                if (r1 == r2) goto L_0x0050
                r2 = 389690339(0x173a33e3, float:6.016533E-25)
                if (r1 == r2) goto L_0x0028
                goto L_0x006a
            L_0x0028:
                java.lang.String r1 = "app_uninstalled"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0031
                goto L_0x006a
            L_0x0031:
                if (r4 < 0) goto L_0x006a
                com.uptodown.activities.MyApps r0 = r3.f14141b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                r0.remove(r4)
                com.uptodown.activities.MyApps r0 = r3.f14141b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemRemoved(r4)
                goto L_0x006a
            L_0x0050:
                java.lang.String r1 = "app_updated"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x006a
                goto L_0x0062
            L_0x0059:
                java.lang.String r1 = "app_installed"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0062
                goto L_0x006a
            L_0x0062:
                if (r4 < 0) goto L_0x006a
                com.uptodown.activities.MyApps r4 = r3.f14141b
                r0 = 0
                r4.A5(r0)
            L_0x006a:
                W2.J r4 = W2.J.f19942a
                return r4
            L_0x006d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c implements C2612w {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f14144a;

        c(MyApps myApps) {
            this.f14144a = myApps;
        }

        public void a() {
            if (UptodownApp.f13477F.Z()) {
                MyApps myApps = this.f14144a;
                String string = myApps.getString(R.string.disabled_apps_explanation);
                t.d(string, "getString(...)");
                myApps.a2(string);
            }
        }
    }

    public static final class d implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f14145a;

        d(MyApps myApps) {
            this.f14145a = myApps;
        }

        public boolean onQueryTextChange(String str) {
            t.e(str, "newText");
            this.f14145a.i5(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            this.f14145a.i5(str);
            return true;
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14146a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f14147b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyApps f14148a;

            /* renamed from: com.uptodown.activities.MyApps$e$a$a  reason: collision with other inner class name */
            static final class C0126a extends kotlin.coroutines.jvm.internal.l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f14149a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ MyApps f14150b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0126a(MyApps myApps, C2308e eVar) {
                    super(2, eVar);
                    this.f14150b = myApps;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0126a(this.f14150b, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f14149a == 0) {
                        u.b(obj);
                        this.f14150b.l5().f23229c.setVisibility(0);
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((C0126a) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            static final class b extends kotlin.coroutines.jvm.internal.l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f14151a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ MyApps f14152b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ O f14153c;

                /* renamed from: com.uptodown.activities.MyApps$e$a$b$a  reason: collision with other inner class name */
                public static final class C0127a implements C2597g {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ MyApps f14154a;

                    /* renamed from: com.uptodown.activities.MyApps$e$a$b$a$a  reason: collision with other inner class name */
                    static final class C0128a extends kotlin.coroutines.jvm.internal.l implements p {

                        /* renamed from: a  reason: collision with root package name */
                        int f14155a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ MyApps f14156b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ String f14157c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ long f14158d;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        C0128a(MyApps myApps, String str, long j5, C2308e eVar) {
                            super(2, eVar);
                            this.f14156b = myApps;
                            this.f14157c = str;
                            this.f14158d = j5;
                        }

                        public final C2308e create(Object obj, C2308e eVar) {
                            return new C0128a(this.f14156b, this.f14157c, this.f14158d, eVar);
                        }

                        public final Object invokeSuspend(Object obj) {
                            ArrayList arrayList;
                            C2316b.f();
                            if (this.f14155a == 0) {
                                u.b(obj);
                                int c5 = this.f14156b.m5(this.f14157c);
                                if (c5 >= 0 && this.f14156b.f14135Y != null) {
                                    C0984o a5 = this.f14156b.f14135Y;
                                    t.b(a5);
                                    if (a5.b().get(c5) instanceof C2655d) {
                                        C0984o a52 = this.f14156b.f14135Y;
                                        if (a52 != null) {
                                            arrayList = a52.b();
                                        } else {
                                            arrayList = null;
                                        }
                                        t.b(arrayList);
                                        Object obj2 = arrayList.get(c5);
                                        t.c(obj2, "null cannot be cast to non-null type com.uptodown.models.App");
                                        ((C2655d) obj2).b0(this.f14158d);
                                        C0984o a53 = this.f14156b.f14135Y;
                                        if (a53 != null) {
                                            a53.notifyItemChanged(this.f14156b.m5(this.f14157c));
                                        }
                                    }
                                }
                                return J.f19942a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Object invoke(w3.M m5, C2308e eVar) {
                            return ((C0128a) create(m5, eVar)).invokeSuspend(J.f19942a);
                        }
                    }

                    C0127a(MyApps myApps) {
                        this.f14154a = myApps;
                    }

                    public void a(String str, long j5) {
                        t.e(str, "packageName");
                        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this.f14154a), C2865c0.c(), (w3.O) null, new C0128a(this.f14154a, str, j5, (C2308e) null), 2, (Object) null);
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(MyApps myApps, O o5, C2308e eVar) {
                    super(2, eVar);
                    this.f14152b = myApps;
                    this.f14153c = o5;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new b(this.f14152b, this.f14153c, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f14151a == 0) {
                        u.b(obj);
                        this.f14152b.l5().f23229c.setVisibility(8);
                        this.f14152b.l5().f23228b.getRoot().setVisibility(0);
                        this.f14152b.B5(((C1618v.a) ((O.c) this.f14153c).a()).a(), ((C1618v.a) ((O.c) this.f14153c).a()).e(), ((C1618v.a) ((O.c) this.f14153c).a()).c(), ((C1618v.a) ((O.c) this.f14153c).a()).b(), ((C1618v.a) ((O.c) this.f14153c).a()).d());
                        if (!((Boolean) this.f14152b.n5().d().getValue()).booleanValue()) {
                            new C2379a(new C0127a(this.f14152b), LifecycleOwnerKt.getLifecycleScope(this.f14152b), this.f14152b);
                            this.f14152b.n5().d().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        }
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            a(MyApps myApps) {
                this.f14148a = myApps;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    Object g5 = C2872g.g(C2865c0.c(), new C0126a(this.f14148a, (C2308e) null), eVar);
                    if (g5 == C2316b.f()) {
                        return g5;
                    }
                    return J.f19942a;
                } else if (o5 instanceof O.c) {
                    Object g6 = C2872g.g(C2865c0.c(), new b(this.f14148a, o5, (C2308e) null), eVar);
                    if (g6 == C2316b.f()) {
                        return g6;
                    }
                    return J.f19942a;
                } else if (o5 instanceof O.b) {
                    return J.f19942a;
                } else {
                    throw new q();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MyApps myApps, C2308e eVar) {
            super(2, eVar);
            this.f14147b = myApps;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14147b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14146a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14147b.n5().e();
                a aVar = new a(this.f14147b);
                this.f14146a = 1;
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14159a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f14160b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f14161c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(MyApps myApps, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f14160b = myApps;
            this.f14161c = arrayList;
        }

        /* access modifiers changed from: private */
        public static final void f(MyApps myApps, View view) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                myApps.startActivity(new Intent(myApps.getApplicationContext(), PreferencesActivity.class), aVar.a(myApps));
                AlertDialog p22 = myApps.p2();
                if (p22 != null) {
                    p22.dismiss();
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void j(MyApps myApps, View view) {
            AlertDialog p22 = myApps.p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }

        /* access modifiers changed from: private */
        public static final void l(ArrayList arrayList, MyApps myApps, View view) {
            if (arrayList != null && arrayList.size() > 0) {
                GenerateQueueWorker.f21366e.a(myApps, true, ((C2655d) arrayList.get(0)).o());
            }
            AlertDialog p22 = myApps.p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f14160b, this.f14161c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14159a == 0) {
                u.b(obj);
                AlertDialog p22 = this.f14160b.p2();
                if (p22 != null) {
                    p22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f14160b);
                C2438t c5 = C2438t.c(this.f14160b.getLayoutInflater());
                t.d(c5, "inflate(...)");
                MyApps myApps = this.f14160b;
                ArrayList arrayList = this.f14161c;
                TextView textView = c5.f23552f;
                k.a aVar = S1.k.f32g;
                textView.setTypeface(aVar.w());
                c5.f23549c.setTypeface(aVar.x());
                c5.f23551e.setTypeface(aVar.w());
                c5.f23548b.setTypeface(aVar.w());
                c5.f23550d.setTypeface(aVar.w());
                c5.f23551e.setOnClickListener(new C1615s(myApps));
                c5.f23548b.setOnClickListener(new C1616t(myApps));
                c5.f23550d.setOnClickListener(new C1617u(arrayList, myApps));
                builder.setView(c5.getRoot());
                this.f14160b.P2(builder.create());
                if (!this.f14160b.isFinishing() && this.f14160b.p2() != null) {
                    this.f14160b.b3();
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14162a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14162a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14162a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14163a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f14163a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14163a.getViewModelStore();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14165b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14164a = aVar;
            this.f14165b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14164a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14165b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.i.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class j implements k2.J {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyApps f14166a;

        j(MyApps myApps) {
            this.f14166a = myApps;
        }

        public void a(int i5) {
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (this.f14166a.x5(i5)) {
                C0984o a5 = this.f14166a.f14135Y;
                t.b(a5);
                Object obj = a5.b().get(i5);
                t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                this.f14166a.c4((C2655d) obj, i5);
            } else if (this.f14166a.y5(i5)) {
                C0984o a52 = this.f14166a.f14135Y;
                t.b(a52);
                Object obj2 = a52.b().get(i5);
                t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f14166a.c4(((L.a) obj2).a(), i5);
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
                com.uptodown.activities.MyApps r0 = r6.f14166a
                R1.o r0 = r0.f14135Y
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
                com.uptodown.activities.MyApps r0 = r6.f14166a
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData"
                kotlin.jvm.internal.t.c(r7, r0)
                R1.L$a r7 = (R1.L.a) r7
                l2.d r1 = r7.a()
                goto L_0x006f
            L_0x003e:
                com.uptodown.activities.MyApps r0 = r6.f14166a
                R1.o r0 = r0.f14135Y
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
                com.uptodown.activities.MyApps r0 = r6.f14166a
                R1.o r0 = r0.f14135Y
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
                com.uptodown.activities.MyApps r7 = r6.f14166a
                long r0 = r1.b()
                r7.H2(r0)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.j.b(int):void");
        }

        public void c(int i5) {
            if (this.f14166a.x5(i5)) {
                C0984o a5 = this.f14166a.f14135Y;
                t.b(a5);
                Object obj = a5.b().get(i5);
                t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                ((C2655d) obj).a0(true);
                C0984o a52 = this.f14166a.f14135Y;
                t.b(a52);
                a52.notifyItemChanged(i5);
            } else if (this.f14166a.y5(i5)) {
                C0984o a53 = this.f14166a.f14135Y;
                t.b(a53);
                Object obj2 = a53.b().get(i5);
                t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((L.a) obj2).a().a0(true);
                C0984o a54 = this.f14166a.f14135Y;
                t.b(a54);
                a54.notifyItemChanged(i5);
            }
        }

        public void d(int i5) {
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (this.f14166a.x5(i5)) {
                C0984o a5 = this.f14166a.f14135Y;
                t.b(a5);
                Object obj = a5.b().get(i5);
                t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                C2655d dVar = (C2655d) obj;
                if (dVar.w() == C2655d.c.OUTDATED) {
                    this.f14166a.H4(dVar);
                }
            } else if (this.f14166a.y5(i5)) {
                C0984o a52 = this.f14166a.f14135Y;
                t.b(a52);
                Object obj2 = a52.b().get(i5);
                t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                this.f14166a.H4(((L.a) obj2).a());
            }
        }

        public void e(int i5) {
            if (UptodownApp.f13477F.Z()) {
                if (this.f14166a.x5(i5)) {
                    C0984o a5 = this.f14166a.f14135Y;
                    t.b(a5);
                    Object obj = a5.b().get(i5);
                    t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                    this.f14166a.G4((C2655d) obj);
                } else if (this.f14166a.y5(i5)) {
                    C0984o a52 = this.f14166a.f14135Y;
                    t.b(a52);
                    Object obj2 = a52.b().get(i5);
                    t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                    this.f14166a.G4(((L.a) obj2).a());
                }
                C0984o a53 = this.f14166a.f14135Y;
                if (a53 != null) {
                    a53.notifyItemChanged(i5);
                }
            }
        }

        public void f(int i5) {
            if (this.f14166a.x5(i5)) {
                C0984o a5 = this.f14166a.f14135Y;
                t.b(a5);
                Object obj = a5.b().get(i5);
                t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                ((C2655d) obj).a0(false);
                C0984o a52 = this.f14166a.f14135Y;
                t.b(a52);
                a52.notifyItemChanged(i5);
            } else if (this.f14166a.y5(i5)) {
                C0984o a53 = this.f14166a.f14135Y;
                t.b(a53);
                Object obj2 = a53.b().get(i5);
                t.c(obj2, "null cannot be cast to non-null type com.uptodown.adapters.UpdatesAdapter.AppUpdateData");
                ((L.a) obj2).a().a0(false);
                C0984o a54 = this.f14166a.f14135Y;
                t.b(a54);
                a54.notifyItemChanged(i5);
            }
        }
    }

    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14167a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyApps f14168b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14169c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f14170d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MyApps myApps, String str, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14168b = myApps;
            this.f14169c = str;
            this.f14170d = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f14168b, this.f14169c, this.f14170d, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                c3.C2316b.f()
                int r0 = r6.f14167a
                if (r0 != 0) goto L_0x00fe
                W2.u.b(r7)
                com.uptodown.activities.MyApps r7 = r6.f14168b
                R1.o r7 = r7.f14135Y
                if (r7 == 0) goto L_0x00fb
                com.uptodown.activities.MyApps r7 = r6.f14168b
                java.lang.String r0 = r6.f14169c
                int r7 = r7.m5(r0)
                r0 = -1
                r1 = 1
                r2 = 0
                if (r7 <= r0) goto L_0x0021
                r0 = r1
                goto L_0x0022
            L_0x0021:
                r0 = r2
            L_0x0022:
                int r3 = r6.f14170d
                r4 = 306(0x132, float:4.29E-43)
                if (r3 != r4) goto L_0x0048
                if (r0 == 0) goto L_0x00fb
                com.uptodown.activities.MyApps r0 = r6.f14168b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                java.util.ArrayList r0 = r0.b()
                r0.remove(r7)
                com.uptodown.activities.MyApps r0 = r6.f14168b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemRemoved(r7)
                goto L_0x00fb
            L_0x0048:
                r4 = 301(0x12d, float:4.22E-43)
                if (r3 != r4) goto L_0x005c
                if (r0 == 0) goto L_0x00fb
                com.uptodown.activities.MyApps r0 = r6.f14168b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r7)
                goto L_0x00fb
            L_0x005c:
                r4 = 305(0x131, float:4.27E-43)
                if (r3 == r4) goto L_0x00fb
                r4 = 302(0x12e, float:4.23E-43)
                if (r3 != r4) goto L_0x007b
                if (r0 == 0) goto L_0x0074
                com.uptodown.activities.MyApps r0 = r6.f14168b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r7)
                goto L_0x00fb
            L_0x0074:
                com.uptodown.activities.MyApps r7 = r6.f14168b
                r7.A5(r2)
                goto L_0x00fb
            L_0x007b:
                if (r0 == 0) goto L_0x00af
                com.uptodown.activities.MyApps r3 = r6.f14168b
                R1.o r3 = r3.f14135Y
                kotlin.jvm.internal.t.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r7)
                boolean r3 = r3 instanceof l2.C2655d
                if (r3 == 0) goto L_0x00af
                com.uptodown.activities.MyApps r3 = r6.f14168b
                R1.o r3 = r3.f14135Y
                kotlin.jvm.internal.t.b(r3)
                java.util.ArrayList r3 = r3.b()
                java.lang.Object r3 = r3.get(r7)
                java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.models.App"
                kotlin.jvm.internal.t.c(r3, r4)
                l2.d r3 = (l2.C2655d) r3
                java.lang.String r3 = r3.m()
                goto L_0x00b0
            L_0x00af:
                r3 = 0
            L_0x00b0:
                int r4 = r6.f14170d
                r5 = 304(0x130, float:4.26E-43)
                if (r4 == r5) goto L_0x00d2
                r5 = 307(0x133, float:4.3E-43)
                if (r4 == r5) goto L_0x00c8
                com.uptodown.activities.MyApps r4 = r6.f14168b
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r2] = r3
                r2 = 2131952111(0x7f1301ef, float:1.9540656E38)
                java.lang.String r1 = r4.getString(r2, r1)
                goto L_0x00db
            L_0x00c8:
                com.uptodown.activities.MyApps r1 = r6.f14168b
                r2 = 2131952026(0x7f13019a, float:1.9540483E38)
                java.lang.String r1 = r1.getString(r2)
                goto L_0x00db
            L_0x00d2:
                com.uptodown.activities.MyApps r1 = r6.f14168b
                r2 = 2131952349(0x7f1302dd, float:1.9541138E38)
                java.lang.String r1 = r1.getString(r2)
            L_0x00db:
                com.uptodown.activities.MyApps r2 = r6.f14168b
                r2.a2(r1)
                if (r0 == 0) goto L_0x00ef
                com.uptodown.activities.MyApps r0 = r6.f14168b
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r7)
                goto L_0x00fb
            L_0x00ef:
                com.uptodown.activities.MyApps r7 = r6.f14168b
                R1.o r7 = r7.f14135Y
                kotlin.jvm.internal.t.b(r7)
                r7.c()
            L_0x00fb:
                W2.J r7 = W2.J.f19942a
                return r7
            L_0x00fe:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class l extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14171a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14172b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f14173c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MyApps f14174d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f14175e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(int i5, Bundle bundle, MyApps myApps, String str, C2308e eVar) {
            super(2, eVar);
            this.f14172b = i5;
            this.f14173c = bundle;
            this.f14174d = myApps;
            this.f14175e = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new l(this.f14172b, this.f14173c, this.f14174d, this.f14175e, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x00c0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                c3.C2316b.f()
                int r0 = r3.f14171a
                if (r0 != 0) goto L_0x00e3
                W2.u.b(r4)
                int r4 = r3.f14172b
                r0 = 102(0x66, float:1.43E-43)
                java.lang.String r1 = "getString(...)"
                if (r4 == r0) goto L_0x008d
                r0 = 108(0x6c, float:1.51E-43)
                if (r4 == r0) goto L_0x007a
                r0 = 110(0x6e, float:1.54E-43)
                if (r4 == r0) goto L_0x0072
                r0 = 201(0xc9, float:2.82E-43)
                if (r4 == r0) goto L_0x0063
                switch(r4) {
                    case 104: goto L_0x0053;
                    case 105: goto L_0x0034;
                    case 106: goto L_0x0023;
                    default: goto L_0x0021;
                }
            L_0x0021:
                goto L_0x00b7
            L_0x0023:
                com.uptodown.activities.MyApps r4 = r3.f14174d
                r0 = 2131951976(0x7f130168, float:1.9540382E38)
                java.lang.String r0 = r4.getString(r0)
                kotlin.jvm.internal.t.d(r0, r1)
                r4.u0(r0)
                goto L_0x00b7
            L_0x0034:
                android.os.Bundle r4 = r3.f14173c
                if (r4 == 0) goto L_0x00b7
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 33
                java.lang.String r2 = "apps_parcelable"
                if (r0 < r1) goto L_0x0047
                java.lang.Class<l2.d> r0 = l2.C2655d.class
                java.util.ArrayList r4 = r4.getParcelableArrayList(r2, r0)
                goto L_0x004b
            L_0x0047:
                java.util.ArrayList r4 = r4.getParcelableArrayList(r2)
            L_0x004b:
                if (r4 == 0) goto L_0x00b7
                com.uptodown.activities.MyApps r0 = r3.f14174d
                r0.C5(r4)
                goto L_0x00b7
            L_0x0053:
                com.uptodown.activities.MyApps r4 = r3.f14174d
                r0 = 2131952451(0x7f130343, float:1.9541345E38)
                java.lang.String r0 = r4.getString(r0)
                kotlin.jvm.internal.t.d(r0, r1)
                r4.u0(r0)
                goto L_0x00b7
            L_0x0063:
                com.uptodown.activities.MyApps r4 = r3.f14174d
                R1.o r4 = r4.f14135Y
                if (r4 == 0) goto L_0x0070
                java.lang.String r0 = r3.f14175e
                r4.d(r0)
            L_0x0070:
                r4 = 0
                goto L_0x00b8
            L_0x0072:
                com.uptodown.activities.a$b r4 = new com.uptodown.activities.a$b
                com.uptodown.activities.MyApps r0 = r3.f14174d
                r4.<init>()
                goto L_0x00b7
            L_0x007a:
                java.lang.String r4 = r3.f14175e
                if (r4 == 0) goto L_0x00b7
                int r4 = r4.length()
                if (r4 != 0) goto L_0x0085
                goto L_0x00b7
            L_0x0085:
                com.uptodown.activities.MyApps r4 = r3.f14174d
                java.lang.String r0 = r3.f14175e
                r4.z5(r0)
                goto L_0x00b7
            L_0x008d:
                android.os.Bundle r4 = new android.os.Bundle
                r4.<init>()
                java.lang.String r0 = r3.f14175e
                if (r0 == 0) goto L_0x009b
                java.lang.String r2 = "packagename"
                r4.putString(r2, r0)
            L_0x009b:
                com.uptodown.activities.MyApps r0 = r3.f14174d
                z2.F r0 = r0.s2()
                if (r0 == 0) goto L_0x00a8
                java.lang.String r2 = "update_download_failed"
                r0.d(r2, r4)
            L_0x00a8:
                com.uptodown.activities.MyApps r4 = r3.f14174d
                r0 = 2131951922(0x7f130132, float:1.9540272E38)
                java.lang.String r0 = r4.getString(r0)
                kotlin.jvm.internal.t.d(r0, r1)
                r4.u0(r0)
            L_0x00b7:
                r4 = 1
            L_0x00b8:
                com.uptodown.activities.MyApps r0 = r3.f14174d
                boolean r0 = r0.E4()
                if (r0 == 0) goto L_0x00c7
                com.uptodown.activities.MyApps r0 = r3.f14174d
                int r1 = r3.f14172b
                r0.R4(r1)
            L_0x00c7:
                if (r4 == 0) goto L_0x00e0
                com.uptodown.activities.MyApps r4 = r3.f14174d
                java.lang.String r0 = r3.f14175e
                int r4 = r4.m5(r0)
                r0 = -1
                if (r4 <= r0) goto L_0x00e0
                com.uptodown.activities.MyApps r0 = r3.f14174d
                R1.o r0 = r0.f14135Y
                kotlin.jvm.internal.t.b(r0)
                r0.notifyItemChanged(r4)
            L_0x00e0:
                W2.J r4 = W2.J.f19942a
                return r4
            L_0x00e3:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyApps.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((l) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final void B5(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        if (this.f14135Y == null) {
            this.f14135Y = new C0984o(this.f14136Z, this.f14137m0, this.f14138n0);
            l5().f23231e.setAdapter(this.f14135Y);
        }
        String g5 = n5().g();
        if (g5 == null || g5.length() == 0 || !arrayList2.isEmpty() || !arrayList3.isEmpty() || !arrayList4.isEmpty() || !arrayList5.isEmpty()) {
            l5().f23234h.setVisibility(8);
        } else {
            l5().f23234h.setText(getString(R.string.no_results_filtered, new Object[]{n5().g()}));
            l5().f23234h.setVisibility(0);
        }
        C0984o oVar = this.f14135Y;
        t.b(oVar);
        oVar.g(arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }

    /* access modifiers changed from: private */
    public final void i5(String str) {
        n5().i(str);
        A5(true);
    }

    /* access modifiers changed from: private */
    public static final C2418i0 j5(MyApps myApps) {
        return C2418i0.c(myApps.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final C2418i0 l5() {
        return (C2418i0) this.f14133W.getValue();
    }

    /* access modifiers changed from: private */
    public final int m5(String str) {
        ArrayList arrayList;
        C0984o oVar = this.f14135Y;
        ArrayList arrayList2 = null;
        if (oVar != null) {
            arrayList = oVar.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        C0984o oVar2 = this.f14135Y;
        if (oVar2 != null) {
            arrayList2 = oVar2.b();
        }
        t.b(arrayList2);
        int i5 = 0;
        for (Object next : arrayList2) {
            int i6 = i5 + 1;
            if (((next instanceof T) && s.E(((T) next).h(), str, true)) || (((next instanceof C2655d) && s.E(((C2655d) next).o(), str, true)) || ((next instanceof L.a) && s.E(((L.a) next).a().o(), str, true)))) {
                return i5;
            }
            i5 = i6;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final C1618v n5() {
        return (C1618v) this.f14134X.getValue();
    }

    private final void o5() {
        setContentView((View) l5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            l5().f23233g.setNavigationIcon(drawable);
            l5().f23233g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        l5().f23233g.setNavigationOnClickListener(new C0837m2(this));
        l5().f23233g.inflateMenu(R.menu.toolbar_menu_my_apps);
        TextView textView = l5().f23235i;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        l5().f23234h.setTypeface(aVar.x());
        a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
        boolean h02 = aVar2.h0(this);
        l5().f23233g.getMenu().findItem(R.id.action_show_system_apps).setChecked(h02);
        l5().f23233g.getMenu().findItem(R.id.action_show_system_services).setChecked(aVar2.i0(this));
        Toolbar toolbar = l5().f23233g;
        t.d(toolbar, "toolbarMyApps");
        x4(R.id.action_show_system_services, h02, toolbar);
        l5().f23233g.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.vector_menu_dots_color_adaptable));
        l5().f23233g.setOnMenuItemClickListener(new C0845n2(this));
        l5().f23228b.f22371c.setTypeface(aVar.x());
        l5().f23228b.f22372d.setTypeface(aVar.w());
        l5().f23228b.f22372d.setText(getString(R.string.order_by_name));
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.order_by_name));
        hashMap.put(1, getString(R.string.order_by_last_update));
        hashMap.put(2, getString(R.string.order_by_size));
        l5().f23228b.getRoot().setOnClickListener(new C0853o2(this, hashMap));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        l5().f23231e.addItemDecoration(new B2.l(dimension, dimension));
        l5().f23231e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        l5().f23231e.setItemAnimator(new DefaultItemAnimator());
        NestedScrollView nestedScrollView = l5().f23230d;
        t.d(nestedScrollView, "nsvMyApps");
        hideKeyboardOnScroll(nestedScrollView);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) l5().f23231e.getItemAnimator();
        t.b(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
        l5().f23232f.setOnQueryTextListener(new d(this));
        EditText editText = (EditText) l5().f23232f.findViewById(R.id.search_src_text);
        editText.setTypeface(aVar.x());
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        l5().f23232f.setOnClickListener(new C0861p2(this));
        l5().f23229c.setOnClickListener(new C0869q2());
    }

    /* access modifiers changed from: private */
    public static final void p5(MyApps myApps, View view) {
        myApps.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean q5(MyApps myApps, MenuItem menuItem) {
        t.e(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_show_system_apps) {
            boolean isChecked = menuItem.isChecked();
            menuItem.setChecked(!isChecked);
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            Context applicationContext = myApps.getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            aVar.i1(applicationContext, !isChecked);
            if (isChecked) {
                Context applicationContext2 = myApps.getApplicationContext();
                t.d(applicationContext2, "getApplicationContext(...)");
                aVar.j1(applicationContext2, false);
                Toolbar toolbar = myApps.l5().f23233g;
                t.d(toolbar, "toolbarMyApps");
                myApps.x4(R.id.action_show_system_services, false, toolbar);
                Toolbar toolbar2 = myApps.l5().f23233g;
                t.d(toolbar2, "toolbarMyApps");
                myApps.N3(R.id.action_show_system_services, false, toolbar2);
            } else {
                Toolbar toolbar3 = myApps.l5().f23233g;
                t.d(toolbar3, "toolbarMyApps");
                myApps.x4(R.id.action_show_system_services, true, toolbar3);
            }
            myApps.A5(true);
        } else if (menuItem.getItemId() == R.id.action_show_system_services) {
            boolean isChecked2 = menuItem.isChecked();
            menuItem.setChecked(!isChecked2);
            a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
            Context applicationContext3 = myApps.getApplicationContext();
            t.d(applicationContext3, "getApplicationContext(...)");
            aVar2.j1(applicationContext3, !isChecked2);
            myApps.A5(true);
        } else if (menuItem.getItemId() == R.id.action_search) {
            if (myApps.l5().f23232f.getVisibility() == 0) {
                myApps.l5().f23232f.setVisibility(8);
                myApps.l5().f23232f.clearFocus();
            } else {
                myApps.l5().f23232f.setVisibility(0);
                myApps.l5().f23232f.requestFocus();
                SearchView searchView = myApps.l5().f23232f;
                t.d(searchView, "searchViewMyApps");
                myApps.showKeyboard(searchView);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void r5(MyApps myApps, HashMap hashMap, View view) {
        t.b(view);
        new D2.q(myApps, view, hashMap, new C0876r2(myApps)).c();
    }

    /* access modifiers changed from: private */
    public static final J s5(MyApps myApps, int i5, String str) {
        t.e(str, "selectedOption");
        if (((Number) myApps.n5().f().getValue()).intValue() != i5) {
            myApps.n5().f().setValue(Integer.valueOf(i5));
            myApps.l5().f23228b.f22372d.setText(str);
            myApps.i5(myApps.l5().f23232f.getQuery().toString());
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void t5(MyApps myApps, View view) {
        myApps.l5().f23232f.setIconified(false);
    }

    /* access modifiers changed from: private */
    public static final void u5(View view) {
    }

    /* access modifiers changed from: private */
    public final boolean x5(int i5) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C0984o oVar = this.f14135Y;
        if (oVar == null) {
            return false;
        }
        ArrayList arrayList3 = null;
        if (oVar != null) {
            arrayList = oVar.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        C0984o oVar2 = this.f14135Y;
        if (oVar2 != null) {
            arrayList2 = oVar2.b();
        } else {
            arrayList2 = null;
        }
        t.b(arrayList2);
        if (arrayList2.size() <= i5) {
            return false;
        }
        C0984o oVar3 = this.f14135Y;
        if (oVar3 != null) {
            arrayList3 = oVar3.b();
        }
        t.b(arrayList3);
        if (arrayList3.get(i5) instanceof C2655d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean y5(int i5) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C0984o oVar = this.f14135Y;
        if (oVar == null) {
            return false;
        }
        ArrayList arrayList3 = null;
        if (oVar != null) {
            arrayList = oVar.b();
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        C0984o oVar2 = this.f14135Y;
        if (oVar2 != null) {
            arrayList2 = oVar2.b();
        } else {
            arrayList2 = null;
        }
        t.b(arrayList2);
        if (arrayList2.size() <= i5) {
            return false;
        }
        C0984o oVar3 = this.f14135Y;
        if (oVar3 != null) {
            arrayList3 = oVar3.b();
        }
        t.b(arrayList3);
        if (arrayList3.get(i5) instanceof L.a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void z5(String str) {
        C2668q qVar;
        C2940B.a aVar = C2940B.f26458v;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        C2940B a5 = aVar.a(applicationContext);
        a5.a();
        T G02 = a5.G0(str);
        if (G02 != null) {
            qVar = G02.b(this);
        } else {
            qVar = null;
        }
        C2655d Y4 = a5.Y(str);
        a5.m();
        if (qVar != null && qVar.f()) {
            UptodownApp.f13477F.J0(Y4);
            File n5 = qVar.n();
            if (n5 == null) {
                return;
            }
            if (G02.n() == 1) {
                C4(G02, n5);
            } else {
                C2(n5, (String) null);
            }
        }
    }

    public final void A5(boolean z4) {
        n5().c(this, z4);
    }

    public final void C5(ArrayList arrayList) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new f(this, arrayList, (C2308e) null), 2, (Object) null);
    }

    public final void D5(int i5, String str) {
        t.e(str, "packageName");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new k(this, str, i5, (C2308e) null), 2, (Object) null);
    }

    public final void E5(int i5, String str, Bundle bundle) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new l(i5, bundle, this, str, (C2308e) null), 2, (Object) null);
    }

    public void I4(int i5, int i6) {
        A5(false);
    }

    public void J4(int i5, int i6) {
        A5(false);
    }

    /* access modifiers changed from: protected */
    public void M4() {
        A5(false);
    }

    public void N2() {
        C0984o oVar = this.f14135Y;
        if (oVar != null) {
            oVar.f();
        }
    }

    public void V2(File file) {
        t.e(file, "xapkFile");
        C0984o oVar = this.f14135Y;
        if (oVar != null) {
            oVar.f();
        }
        C0984o oVar2 = this.f14135Y;
        if (oVar2 != null) {
            oVar2.e(file, this);
        }
    }

    public void W2(File file, int i5) {
        t.e(file, "file");
        C0984o oVar = this.f14135Y;
        if (oVar != null) {
            oVar.e(file, this);
        }
    }

    public void Z2(File file) {
        t.e(file, "xapkFile");
        C0984o oVar = this.f14135Y;
        if (oVar != null) {
            oVar.h(file, this);
        }
    }

    public final Object k5(String str, String str2, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new b(this, str2, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o5();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new e(this, (C2308e) null), 3, (Object) null);
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i5 != 82) {
            return super.onKeyDown(i5, keyEvent);
        }
        l5().f23233g.showOverflowMenu();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        A5(true);
        z2.M.f26506a.h(this);
    }

    public final void v5() {
        C0984o oVar = this.f14135Y;
        if (oVar != null) {
            oVar.f();
        }
    }

    public final void w5(String str) {
        C0984o oVar = this.f14135Y;
        if (oVar != null) {
            oVar.f();
        }
        if (str != null && str.length() != 0) {
            String string = getString(R.string.install_compatibility_error, new Object[]{str});
            t.d(string, "getString(...)");
            u0(string);
        }
    }
}
