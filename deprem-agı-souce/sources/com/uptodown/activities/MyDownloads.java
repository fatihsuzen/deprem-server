package com.uptodown.activities;

import O1.C0798h3;
import O1.C0806i3;
import O1.C0814j3;
import O1.C0822k3;
import O1.C0830l3;
import O1.C0838m3;
import O1.C0846n3;
import O1.C0854o3;
import O1.C0862p3;
import O1.C0870q3;
import O1.C0877r3;
import O1.W2;
import O1.X2;
import O1.Y2;
import O1.Z2;
import R1.C0971b;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.q;
import W2.u;
import X2.C2250q;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2279K;
import b2.C2290j;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1620x;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadWorker;
import h2.C2420j0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import k2.C2602l;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2661j;
import l2.C2668q;
import l2.r;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2940B;
import z2.C2962v;
import z2.E;
import z2.O;
import z3.C2973f;
import z3.D;

public final class MyDownloads extends C1598a {

    /* renamed from: R  reason: collision with root package name */
    public static final a f14176R = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14177K = W2.m.b(new W2(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14178L = new ViewModelLazy(M.b(C1620x.class), new l(this), new k(this), new m((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0971b f14179M;

    /* renamed from: N  reason: collision with root package name */
    private C1620x.b f14180N = C1620x.b.DATE;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public boolean f14181O;

    /* renamed from: P  reason: collision with root package name */
    private final i f14182P = new i(this);

    /* renamed from: Q  reason: collision with root package name */
    private final f f14183Q = new f(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f14184a;

        public b(int i5) {
            this.f14184a = i5;
        }

        public void run() {
            int i5 = this.f14184a;
            if (i5 == 302 || i5 == 352) {
                MyDownloads.this.D4(false);
            } else {
                MyDownloads.this.C4();
            }
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14187b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f14188c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MyDownloads myDownloads, boolean z4, C2308e eVar) {
            super(2, eVar);
            this.f14187b = myDownloads;
            this.f14188c = z4;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14187b, this.f14188c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14186a == 0) {
                u.b(obj);
                if (this.f14187b.f14179M != null) {
                    C0971b H32 = this.f14187b.f14179M;
                    t.b(H32);
                    if (H32.d().size() > 0) {
                        if (this.f14188c) {
                            C0971b H33 = this.f14187b.f14179M;
                            t.b(H33);
                            Iterator it = H33.d().iterator();
                            t.d(it, "iterator(...)");
                            while (it.hasNext()) {
                                Object next = it.next();
                                t.d(next, "next(...)");
                                MyDownloads myDownloads = this.f14187b;
                                C0971b H34 = myDownloads.f14179M;
                                t.b(H34);
                                myDownloads.U3(H34.d().indexOf((C2668q) next));
                            }
                        } else {
                            C0971b H35 = this.f14187b.f14179M;
                            t.b(H35);
                            Iterator it2 = H35.d().iterator();
                            t.d(it2, "iterator(...)");
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                t.d(next2, "next(...)");
                                C2668q qVar = (C2668q) next2;
                                if (!qVar.M() && !DownloadWorker.f21359d.k(qVar.h(), qVar.E())) {
                                    MyDownloads myDownloads2 = this.f14187b;
                                    C0971b H36 = myDownloads2.f14179M;
                                    t.b(H36);
                                    myDownloads2.U3(H36.d().indexOf(qVar));
                                }
                            }
                        }
                        this.f14187b.I4();
                        this.f14187b.D4(false);
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

    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f14189a;

        /* renamed from: b  reason: collision with root package name */
        int f14190b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14191c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f14192d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MyDownloads myDownloads, int i5, C2308e eVar) {
            super(2, eVar);
            this.f14191c = myDownloads;
            this.f14192d = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14191c, this.f14192d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2668q qVar;
            Object f5 = C2316b.f();
            int i5 = this.f14190b;
            if (i5 == 0) {
                u.b(obj);
                C0971b H32 = this.f14191c.f14179M;
                t.b(H32);
                Object obj2 = H32.d().get(this.f14192d);
                t.d(obj2, "get(...)");
                C2668q qVar2 = (C2668q) obj2;
                C1620x I32 = this.f14191c.q4();
                MyDownloads myDownloads = this.f14191c;
                this.f14189a = qVar2;
                this.f14190b = 1;
                Object j5 = I32.j(myDownloads, qVar2, this);
                if (j5 == f5) {
                    return f5;
                }
                qVar = qVar2;
                obj = j5;
            } else if (i5 == 1) {
                qVar = (C2668q) this.f14189a;
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((Boolean) obj).booleanValue()) {
                C0971b H33 = this.f14191c.f14179M;
                t.b(H33);
                H33.d().remove(qVar);
                C0971b H34 = this.f14191c.f14179M;
                t.b(H34);
                H34.notifyItemRemoved(this.f14192d);
                C0971b H35 = this.f14191c.f14179M;
                t.b(H35);
                if (H35.d().isEmpty()) {
                    this.f14191c.o4().f23252h.setVisibility(0);
                }
            }
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f14193a;

        /* renamed from: b  reason: collision with root package name */
        int f14194b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14195c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MyDownloads myDownloads, C2308e eVar) {
            super(2, eVar);
            this.f14195c = myDownloads;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14195c, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f14194b
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r5.f14193a
                java.util.Iterator r1 = (java.util.Iterator) r1
                W2.u.b(r6)
                goto L_0x003d
            L_0x0013:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001b:
                W2.u.b(r6)
                com.uptodown.activities.MyDownloads r6 = r5.f14195c
                R1.b r6 = r6.f14179M
                if (r6 == 0) goto L_0x0061
                com.uptodown.activities.MyDownloads r6 = r5.f14195c
                R1.b r6 = r6.f14179M
                kotlin.jvm.internal.t.b(r6)
                java.util.ArrayList r6 = r6.g()
                java.util.Iterator r6 = r6.iterator()
                java.lang.String r1 = "iterator(...)"
                kotlin.jvm.internal.t.d(r6, r1)
                r1 = r6
            L_0x003d:
                boolean r6 = r1.hasNext()
                if (r6 == 0) goto L_0x0061
                java.lang.Object r6 = r1.next()
                java.lang.String r3 = "next(...)"
                kotlin.jvm.internal.t.d(r6, r3)
                l2.q r6 = (l2.C2668q) r6
                com.uptodown.activities.MyDownloads r3 = r5.f14195c
                com.uptodown.activities.x r3 = r3.q4()
                com.uptodown.activities.MyDownloads r4 = r5.f14195c
                r5.f14193a = r1
                r5.f14194b = r2
                java.lang.Object r6 = r3.j(r4, r6, r5)
                if (r6 != r0) goto L_0x003d
                return r0
            L_0x0061:
                com.uptodown.activities.MyDownloads r6 = r5.f14195c
                r0 = 0
                r6.D4(r0)
                com.uptodown.activities.MyDownloads r6 = r5.f14195c
                r6.I4()
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyDownloads.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f implements C2602l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14196a;

        f(MyDownloads myDownloads) {
            this.f14196a = myDownloads;
        }

        public void a(int i5) {
            C0971b H32 = this.f14196a.f14179M;
            t.b(H32);
            if (H32.h()) {
                C0971b H33 = this.f14196a.f14179M;
                t.b(H33);
                H33.m(i5);
                this.f14196a.F4();
            } else if (UptodownApp.f13477F.Z()) {
                C0971b H34 = this.f14196a.f14179M;
                t.b(H34);
                Object obj = H34.d().get(i5);
                t.d(obj, "get(...)");
                this.f14196a.f4((C2668q) obj, i5);
            }
        }

        public void b(int i5) {
            if (UptodownApp.f13477F.Z()) {
                C0971b H32 = this.f14196a.f14179M;
                t.b(H32);
                Object obj = H32.d().get(i5);
                t.d(obj, "get(...)");
                C2668q qVar = (C2668q) obj;
                if (qVar.h() >= 0) {
                    this.f14196a.H2(qVar.h());
                }
            }
        }

        public void c(int i5) {
            if (UptodownApp.f13477F.Z()) {
                this.f14196a.Y3(i5);
            }
        }

        public void d(int i5) {
            if (this.f14196a.f14179M != null) {
                C0971b H32 = this.f14196a.f14179M;
                t.b(H32);
                if (!H32.h()) {
                    C0971b H33 = this.f14196a.f14179M;
                    t.b(H33);
                    C0971b H34 = this.f14196a.f14179M;
                    t.b(H34);
                    H33.n(!H34.h());
                    C0971b H35 = this.f14196a.f14179M;
                    t.b(H35);
                    H35.m(i5);
                    this.f14196a.H4();
                    this.f14196a.f14181O = true;
                    this.f14196a.o4().f23249e.smoothScrollToPosition(i5);
                }
            }
        }

        public void e(int i5) {
            if (UptodownApp.f13477F.Z()) {
                C0971b H32 = this.f14196a.f14179M;
                t.b(H32);
                if (H32.d().size() > 0) {
                    C0971b H33 = this.f14196a.f14179M;
                    t.b(H33);
                    if (i5 < H33.d().size()) {
                        C0971b H34 = this.f14196a.f14179M;
                        t.b(H34);
                        Object obj = H34.d().get(i5);
                        t.d(obj, "get(...)");
                        DownloadWorker.a aVar = DownloadWorker.f21359d;
                        if (aVar.m((C2668q) obj) && aVar.h()) {
                            aVar.o();
                        }
                    }
                }
            }
        }
    }

    public static final class g implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14197a;

        g(MyDownloads myDownloads) {
            this.f14197a = myDownloads;
        }

        public boolean onQueryTextChange(String str) {
            t.e(str, "newText");
            this.f14197a.Q3(str);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            this.f14197a.Q3(str);
            return true;
        }
    }

    public static final class h implements RecyclerView.OnItemTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14198a;

        h(MyDownloads myDownloads) {
            this.f14198a = myDownloads;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            t.e(recyclerView, CampaignEx.JSON_KEY_REWARD_TEMPLATE);
            t.e(motionEvent, "e");
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f14198a.f14181O = false;
            } else if (action == 2 && this.f14198a.f14181O) {
                return true;
            }
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z4) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            t.e(recyclerView, CampaignEx.JSON_KEY_REWARD_TEMPLATE);
            t.e(motionEvent, "e");
        }
    }

    public static final class i extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14199a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(MyDownloads myDownloads) {
            super(true);
            this.f14199a = myDownloads;
        }

        public void handleOnBackPressed() {
            C0971b H32 = this.f14199a.f14179M;
            if (H32 == null || !H32.h()) {
                this.f14199a.finish();
            } else {
                this.f14199a.I4();
            }
        }
    }

    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14201b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MyDownloads f14202a;

            a(MyDownloads myDownloads) {
                this.f14202a = myDownloads;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14202a.o4().f23246b.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    this.f14202a.o4().f23246b.setVisibility(8);
                    this.f14202a.o4().f23247c.getRoot().setVisibility(0);
                    O.c cVar = (O.c) o5;
                    this.f14202a.E4(((C1620x.a) cVar.a()).a(), ((C1620x.a) cVar.a()).b());
                    if (!this.f14202a.isFinishing()) {
                        if (((C1620x.a) cVar.a()).a().size() == 0 && ((C1620x.a) cVar.a()).b().size() == 0) {
                            this.f14202a.o4().f23252h.setVisibility(0);
                            this.f14202a.o4().f23249e.setVisibility(8);
                        } else {
                            this.f14202a.o4().f23252h.setVisibility(8);
                            this.f14202a.o4().f23249e.setVisibility(0);
                        }
                        this.f14202a.o4().f23246b.setVisibility(8);
                    }
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(MyDownloads myDownloads, C2308e eVar) {
            super(2, eVar);
            this.f14201b = myDownloads;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f14201b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14200a;
            if (i5 == 0) {
                u.b(obj);
                D m5 = this.f14201b.q4().m();
                a aVar = new a(this.f14201b);
                this.f14200a = 1;
                if (m5.collect(aVar, this) == f5) {
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
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class k extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14203a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(ComponentActivity componentActivity) {
            super(0);
            this.f14203a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14203a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class l extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14204a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(ComponentActivity componentActivity) {
            super(0);
            this.f14204a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14204a.getViewModelStore();
        }
    }

    public static final class m extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14206b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14205a = aVar;
            this.f14206b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14205a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14206b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyDownloads.m.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class n extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14207a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MyDownloads f14208b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f14209c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2668q f14210d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MyDownloads myDownloads, int i5, C2668q qVar, C2308e eVar) {
            super(2, eVar);
            this.f14208b = myDownloads;
            this.f14209c = i5;
            this.f14210d = qVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new n(this.f14208b, this.f14209c, this.f14210d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14207a == 0) {
                u.b(obj);
                if (this.f14208b.f14179M != null) {
                    int i5 = this.f14209c;
                    if (i5 == 202 || i5 == 203) {
                        this.f14208b.D4(false);
                    } else if (i5 != 207) {
                        C2668q qVar = this.f14210d;
                        if (qVar != null) {
                            int G32 = this.f14208b.p4(qVar.w());
                            if (G32 > -1) {
                                C0971b H32 = this.f14208b.f14179M;
                                t.b(H32);
                                H32.d().set(G32, this.f14210d);
                                C0971b H33 = this.f14208b.f14179M;
                                t.b(H33);
                                H33.notifyItemChanged(G32);
                            } else {
                                this.f14208b.D4(false);
                            }
                        }
                    } else {
                        C0971b H34 = this.f14208b.f14179M;
                        t.b(H34);
                        if (C2250q.E(H34.d(), this.f14210d)) {
                            C0971b H35 = this.f14208b.f14179M;
                            t.b(H35);
                            C0971b H36 = this.f14208b.f14179M;
                            t.b(H36);
                            H35.notifyItemRemoved(C2250q.R(H36.d(), this.f14210d));
                            C0971b H37 = this.f14208b.f14179M;
                            t.b(H37);
                            ArrayList d5 = H37.d();
                            S.a(d5).remove(this.f14210d);
                            C0971b H38 = this.f14208b.f14179M;
                            t.b(H38);
                            if (H38.d().isEmpty()) {
                                this.f14208b.o4().f23252h.setVisibility(0);
                            }
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((n) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final void C4() {
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void E4(ArrayList arrayList, ArrayList arrayList2) {
        if (!isFinishing()) {
            if (this.f14179M == null) {
                this.f14179M = new C0971b(this.f14183Q);
                o4().f23249e.setAdapter(this.f14179M);
            }
            C0971b bVar = this.f14179M;
            t.b(bVar);
            bVar.k(arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: private */
    public final void F4() {
        int i5;
        boolean z4;
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            t.b(bVar);
            i5 = bVar.c();
            TextView textView = o4().f23247c.f23283d;
            C0971b bVar2 = this.f14179M;
            t.b(bVar2);
            if (bVar2.d().size() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            textView.setEnabled(z4);
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            o4().f23247c.f23284e.setEnabled(true);
            o4().f23247c.f23284e.setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_blue_primary_button));
        } else {
            o4().f23247c.f23284e.setEnabled(false);
            o4().f23247c.f23284e.setBackground(ContextCompat.getDrawable(this, R.drawable.ripple_light_grey));
        }
        o4().f23247c.f23285f.setText(getString(R.string.core_x_items_selected, new Object[]{String.valueOf(i5)}));
    }

    private final void G4(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(str));
            intent.setType(getContentResolver().getType(uriForFile));
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            startActivity(Intent.createChooser(intent, getString(R.string.intent_chooser_title_share_file)));
        }
    }

    /* access modifiers changed from: private */
    public final void H4() {
        o4().f23247c.getRoot().setVisibility(0);
        o4().f23247c.f23282c.setVisibility(0);
        o4().f23247c.f23281b.getRoot().setVisibility(4);
        F4();
    }

    /* access modifiers changed from: private */
    public final void I4() {
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            bVar.n(false);
        }
        o4().f23247c.getRoot().setVisibility(0);
        o4().f23247c.f23281b.getRoot().setVisibility(0);
        o4().f23247c.f23282c.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void Q3(String str) {
        q4().r(str);
        D4(false);
    }

    /* access modifiers changed from: private */
    public static final C2420j0 R3(MyDownloads myDownloads) {
        return C2420j0.c(myDownloads.getLayoutInflater());
    }

    private final void S3(File file) {
        C2279K.a aVar = C2279K.f20490b;
        String name = file.getName();
        t.d(name, "getName(...)");
        if (aVar.a(name)) {
            C2279K k5 = new C2279K();
            boolean f5 = k5.f(file);
            if (k5.c(file) && !new C2290j().e().canWrite()) {
                if (X()) {
                    c3(0);
                } else {
                    o0();
                }
                f5 = false;
            }
            if (f5) {
                C1598a.D2(this, file, (String) null, 2, (Object) null);
                return;
            }
            return;
        }
        C1598a.D2(this, file, (String) null, 2, (Object) null);
    }

    private final void T3(boolean z4) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new c(this, z4, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void U3(int i5) {
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            t.b(bVar);
            if (bVar.d().size() > 0) {
                C0971b bVar2 = this.f14179M;
                t.b(bVar2);
                if (i5 < bVar2.d().size()) {
                    C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new d(this, i5, (C2308e) null), 3, (Object) null);
                }
            }
        }
    }

    private final void V3() {
        String str;
        DownloadWorker.f21359d.n();
        if (new C2962v().l(this).size() > 1) {
            Q q5 = Q.f24695a;
            String string = getString(R.string.dialog_cancel_downloads_msg);
            t.d(string, "getString(...)");
            str = String.format(string, Arrays.copyOf(new Object[0], 0));
            t.d(str, "format(...)");
        } else {
            Q q6 = Q.f24695a;
            String string2 = getString(R.string.dialog_cancel_download_msg);
            t.d(string2, "getString(...)");
            str = String.format(string2, Arrays.copyOf(new Object[0], 0));
            t.d(str, "format(...)");
        }
        V1(str, new C0806i3(this), new C0814j3(this));
    }

    /* access modifiers changed from: private */
    public static final J W3(MyDownloads myDownloads) {
        myDownloads.T3(true);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J X3(MyDownloads myDownloads) {
        myDownloads.T3(false);
        DownloadWorker.f21359d.o();
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void Y3(int i5) {
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            t.b(bVar);
            Object obj = bVar.d().get(i5);
            t.d(obj, "get(...)");
            C2668q qVar = (C2668q) obj;
            DownloadWorker.a aVar = DownloadWorker.f21359d;
            if (aVar.k(qVar.h(), qVar.E())) {
                aVar.n();
            }
            String string = getString(R.string.download_cancel_confimation_title);
            t.d(string, "getString(...)");
            V1(string, new Y2(this, i5), new Z2());
        }
    }

    /* access modifiers changed from: private */
    public static final J Z3(MyDownloads myDownloads, int i5) {
        myDownloads.U3(i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J a4() {
        DownloadWorker.f21359d.o();
        return J.f19942a;
    }

    private final void b4() {
        Q q5 = Q.f24695a;
        String string = getString(R.string.dialog_delete_all_download_msg);
        t.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        t.d(format, "format(...)");
        U1(format, new C0877r3(this));
    }

    /* access modifiers changed from: private */
    public static final J c4(MyDownloads myDownloads) {
        if (UptodownApp.f13477F.T("downloadApkWorker", myDownloads)) {
            myDownloads.V3();
        } else {
            myDownloads.T3(false);
        }
        return J.f19942a;
    }

    private final void d4() {
        Q q5 = Q.f24695a;
        String string = getString(R.string.dialog_delete_selected_download_msg);
        t.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        t.d(format, "format(...)");
        U1(format, new X2(this));
    }

    /* access modifiers changed from: private */
    public static final J e4(MyDownloads myDownloads) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(myDownloads), (C2312i) null, (w3.O) null, new e(myDownloads, (C2308e) null), 3, (Object) null);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f4(l2.C2668q r12, int r13) {
        /*
            r11 = this;
            kotlin.jvm.internal.L r0 = new kotlin.jvm.internal.L
            r0.<init>()
            android.view.LayoutInflater r1 = r11.getLayoutInflater()
            h2.r r1 = h2.r.c(r1)
            java.lang.String r2 = "inflate(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            android.widget.TextView r2 = r1.f23496l
            S1.k$a r3 = S1.k.f32g
            android.graphics.Typeface r4 = r3.w()
            r2.setTypeface(r4)
            android.widget.TextView r2 = r1.f23497m
            android.graphics.Typeface r4 = r3.w()
            r2.setTypeface(r4)
            java.lang.String r2 = r12.D()
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0052
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0035
            goto L_0x0052
        L_0x0035:
            com.squareup.picasso.s r2 = com.squareup.picasso.s.h()
            java.lang.String r6 = r12.D()
            com.squareup.picasso.w r2 = r2.l(r6)
            com.uptodown.UptodownApp$a r6 = com.uptodown.UptodownApp.f13477F
            D2.h r6 = r6.g0(r11)
            com.squareup.picasso.w r2 = r2.n(r6)
            android.widget.ImageView r6 = r1.f23486b
            r2.i(r6)
            goto L_0x0109
        L_0x0052:
            android.graphics.drawable.Drawable r2 = r12.p()
            if (r2 == 0) goto L_0x0063
            android.widget.ImageView r2 = r1.f23486b
            android.graphics.drawable.Drawable r6 = r12.p()
            r2.setImageDrawable(r6)
            goto L_0x0109
        L_0x0063:
            java.util.ArrayList r2 = r12.o()
            int r2 = r2.size()
            r6 = 2131230935(0x7f0800d7, float:1.8077937E38)
            if (r2 != r4) goto L_0x0100
            java.util.ArrayList r2 = r12.o()
            java.lang.Object r2 = r2.get(r5)
            l2.r r2 = (l2.r) r2
            java.lang.String r2 = r2.a()
            if (r2 == 0) goto L_0x00f6
            java.util.ArrayList r2 = r12.o()
            java.lang.Object r2 = r2.get(r5)
            l2.r r2 = (l2.r) r2
            java.lang.String r2 = r2.a()
            kotlin.jvm.internal.t.b(r2)
            r7 = 2
            r8 = 0
            java.lang.String r9 = ".apk"
            boolean r2 = t3.s.D(r2, r9, r5, r7, r8)
            if (r2 == 0) goto L_0x00ca
            b2.j r2 = new b2.j
            r2.<init>()
            java.util.ArrayList r6 = r12.o()
            java.lang.Object r6 = r6.get(r5)
            l2.r r6 = (l2.r) r6
            java.lang.String r6 = r6.a()
            kotlin.jvm.internal.t.b(r6)
            android.graphics.drawable.Drawable r2 = r2.h(r11, r6)
            if (r2 == 0) goto L_0x00c1
            android.widget.ImageView r2 = r1.f23486b
            android.graphics.drawable.Drawable r6 = r12.p()
            r2.setImageDrawable(r6)
            goto L_0x0109
        L_0x00c1:
            android.widget.ImageView r2 = r1.f23486b
            r6 = 2131230917(0x7f0800c5, float:1.80779E38)
            r2.setImageResource(r6)
            goto L_0x0109
        L_0x00ca:
            b2.K$a r2 = b2.C2279K.f20490b
            java.util.ArrayList r7 = r12.o()
            java.lang.Object r7 = r7.get(r5)
            l2.r r7 = (l2.r) r7
            java.lang.String r7 = r7.a()
            kotlin.jvm.internal.t.b(r7)
            boolean r2 = r2.a(r7)
            if (r2 == 0) goto L_0x00ec
            android.widget.ImageView r2 = r1.f23486b
            r6 = 2131230964(0x7f0800f4, float:1.8077996E38)
            r2.setImageResource(r6)
            goto L_0x0109
        L_0x00ec:
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r11, r6)
            android.widget.ImageView r6 = r1.f23486b
            r6.setImageDrawable(r2)
            goto L_0x0109
        L_0x00f6:
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r11, r6)
            android.widget.ImageView r6 = r1.f23486b
            r6.setImageDrawable(r2)
            goto L_0x0109
        L_0x0100:
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r11, r6)
            android.widget.ImageView r6 = r1.f23486b
            r6.setImageDrawable(r2)
        L_0x0109:
            android.widget.TextView r2 = r1.f23489e
            java.lang.String r6 = r12.i()
            r2.setText(r6)
            android.widget.TextView r2 = r1.f23489e
            android.graphics.Typeface r6 = r3.w()
            r2.setTypeface(r6)
            boolean r2 = r11.n4(r12)
            r6 = 8
            if (r2 != 0) goto L_0x013d
            boolean r2 = r12.M()
            if (r2 != 0) goto L_0x013d
            android.widget.TextView r2 = r1.f23492h
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            android.widget.TextView r2 = r1.f23492h
            O1.a3 r7 = new O1.a3
            r7.<init>(r0, r12, r11)
            r2.setOnClickListener(r7)
            goto L_0x0142
        L_0x013d:
            android.widget.TextView r2 = r1.f23492h
            r2.setVisibility(r6)
        L_0x0142:
            android.widget.TextView r2 = r1.f23494j
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            android.widget.TextView r2 = r1.f23494j
            O1.b3 r7 = new O1.b3
            r7.<init>(r11, r13, r0)
            r2.setOnClickListener(r7)
            android.widget.TextView r2 = r1.f23493i
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            com.uptodown.workers.DownloadWorker$a r2 = com.uptodown.workers.DownloadWorker.f21359d
            boolean r7 = r2.m(r12)
            if (r7 == 0) goto L_0x0195
            android.widget.TextView r7 = r1.f23493i
            r7.setVisibility(r5)
            boolean r2 = r2.h()
            if (r2 == 0) goto L_0x017e
            android.widget.TextView r2 = r1.f23493i
            r7 = 2131952834(0x7f1304c2, float:1.9542122E38)
            java.lang.String r7 = r11.getString(r7)
            r2.setText(r7)
            goto L_0x018a
        L_0x017e:
            android.widget.TextView r2 = r1.f23493i
            r7 = 2131951656(0x7f130028, float:1.9539733E38)
            java.lang.String r7 = r11.getString(r7)
            r2.setText(r7)
        L_0x018a:
            android.widget.TextView r2 = r1.f23493i
            O1.c3 r7 = new O1.c3
            r7.<init>(r0)
            r2.setOnClickListener(r7)
            goto L_0x019a
        L_0x0195:
            android.widget.TextView r2 = r1.f23493i
            r2.setVisibility(r6)
        L_0x019a:
            android.widget.TextView r2 = r1.f23495k
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            android.widget.TextView r2 = r1.f23495k
            O1.d3 r7 = new O1.d3
            r7.<init>(r0, r12, r11)
            r2.setOnClickListener(r7)
            java.util.ArrayList r2 = r12.o()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x01c1
            android.widget.TextView r2 = r1.f23495k
            r2.setVisibility(r6)
            android.widget.TextView r2 = r1.f23497m
            r2.setVisibility(r6)
        L_0x01c1:
            long r7 = r12.h()
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 < 0) goto L_0x01df
            android.widget.TextView r2 = r1.f23488d
            android.graphics.Typeface r7 = r3.x()
            r2.setTypeface(r7)
            android.widget.TextView r2 = r1.f23488d
            O1.e3 r7 = new O1.e3
            r7.<init>(r0, r11, r12)
            r2.setOnClickListener(r7)
            goto L_0x01e4
        L_0x01df:
            android.widget.TextView r12 = r1.f23488d
            r12.setVisibility(r6)
        L_0x01e4:
            android.widget.TextView r12 = r1.f23490f
            android.graphics.Typeface r2 = r3.x()
            r12.setTypeface(r2)
            android.widget.TextView r12 = r1.f23490f
            O1.f3 r2 = new O1.f3
            r2.<init>(r0, r11, r13)
            r12.setOnClickListener(r2)
            R1.b r12 = r11.f14179M
            kotlin.jvm.internal.t.b(r12)
            java.util.ArrayList r12 = r12.d()
            java.lang.Object r12 = r12.get(r13)
            l2.q r12 = (l2.C2668q) r12
            java.util.ArrayList r12 = r12.o()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0243
            R1.b r12 = r11.f14179M
            kotlin.jvm.internal.t.b(r12)
            java.util.ArrayList r12 = r12.d()
            java.lang.Object r12 = r12.get(r13)
            l2.q r12 = (l2.C2668q) r12
            java.util.ArrayList r12 = r12.o()
            java.lang.Object r12 = r12.get(r5)
            l2.r r12 = (l2.r) r12
            java.lang.String r12 = r12.a()
            if (r12 == 0) goto L_0x0243
            android.widget.TextView r12 = r1.f23491g
            android.graphics.Typeface r2 = r3.x()
            r12.setTypeface(r2)
            android.widget.TextView r12 = r1.f23491g
            O1.g3 r2 = new O1.g3
            r2.<init>(r0, r11, r13)
            r12.setOnClickListener(r2)
            goto L_0x0248
        L_0x0243:
            android.widget.TextView r12 = r1.f23491g
            r12.setVisibility(r6)
        L_0x0248:
            android.app.AlertDialog$Builder r12 = new android.app.AlertDialog$Builder
            r12.<init>(r11)
            android.widget.RelativeLayout r13 = r1.getRoot()
            r12.setView(r13)
            r12.setCancelable(r4)
            android.app.AlertDialog r12 = r12.create()
            r0.f24690a = r12
            boolean r12 = r11.isFinishing()
            if (r12 != 0) goto L_0x027e
            java.lang.Object r12 = r0.f24690a
            if (r12 == 0) goto L_0x027e
            android.app.AlertDialog r12 = (android.app.AlertDialog) r12
            android.view.Window r12 = r12.getWindow()
            if (r12 == 0) goto L_0x0277
            android.graphics.drawable.ColorDrawable r13 = new android.graphics.drawable.ColorDrawable
            r13.<init>(r5)
            r12.setBackgroundDrawable(r13)
        L_0x0277:
            java.lang.Object r12 = r0.f24690a
            android.app.AlertDialog r12 = (android.app.AlertDialog) r12
            r12.show()
        L_0x027e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MyDownloads.f4(l2.q, int):void");
    }

    /* access modifiers changed from: private */
    public static final void g4(MyDownloads myDownloads, int i5, L l5, View view) {
        C0971b bVar = myDownloads.f14179M;
        t.b(bVar);
        bVar.n(true);
        C0971b bVar2 = myDownloads.f14179M;
        t.b(bVar2);
        bVar2.m(i5);
        myDownloads.H4();
        myDownloads.F4();
        AlertDialog alertDialog = (AlertDialog) l5.f24690a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void h4(L l5, View view) {
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        if (aVar.h()) {
            aVar.o();
        } else {
            aVar.n();
        }
        AlertDialog alertDialog = (AlertDialog) l5.f24690a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void i4(L l5, C2668q qVar, MyDownloads myDownloads, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog alertDialog = (AlertDialog) l5.f24690a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (qVar.f() && qVar.o().size() == 1) {
                myDownloads.G4(((r) qVar.o().get(0)).a());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void j4(L l5, MyDownloads myDownloads, C2668q qVar, View view) {
        if (UptodownApp.f13477F.Z()) {
            AlertDialog alertDialog = (AlertDialog) l5.f24690a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            myDownloads.H2(qVar.h());
        }
    }

    /* access modifiers changed from: private */
    public static final void k4(L l5, MyDownloads myDownloads, int i5, View view) {
        AlertDialog alertDialog = (AlertDialog) l5.f24690a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        myDownloads.U3(i5);
    }

    /* access modifiers changed from: private */
    public static final void l4(L l5, MyDownloads myDownloads, int i5, View view) {
        String str;
        AlertDialog alertDialog = (AlertDialog) l5.f24690a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        C0971b bVar = myDownloads.f14179M;
        t.b(bVar);
        String a5 = ((r) ((C2668q) bVar.d().get(i5)).o().get(0)).a();
        if (a5 != null && a5.length() != 0) {
            C0971b bVar2 = myDownloads.f14179M;
            t.b(bVar2);
            String a6 = ((r) ((C2668q) bVar2.d().get(i5)).o().get(0)).a();
            t.b(a6);
            File parentFile = new File(a6).getParentFile();
            if (parentFile != null) {
                str = parentFile.getAbsolutePath();
            } else {
                str = null;
            }
            if (str != null) {
                Intent intent = new Intent(myDownloads.getApplicationContext(), FileExplorerActivity.class);
                intent.putExtra("subdir", str);
                myDownloads.startActivity(intent);
                return;
            }
            String string = myDownloads.getString(R.string.installable_files_not_found);
            t.d(string, "getString(...)");
            myDownloads.u0(string);
        }
    }

    /* access modifiers changed from: private */
    public static final void m4(L l5, C2668q qVar, MyDownloads myDownloads, View view) {
        String a5;
        AlertDialog alertDialog = (AlertDialog) l5.f24690a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (t.a(qVar.w(), myDownloads.getPackageName())) {
            if (qVar.o().isEmpty() || ((r) qVar.o().get(0)).a() == null) {
                String string = myDownloads.getString(R.string.installable_files_not_found);
                t.d(string, "getString(...)");
                myDownloads.u0(string);
                return;
            }
            String a6 = ((r) qVar.o().get(0)).a();
            t.b(a6);
            File file = new File(a6);
            if (file.exists()) {
                PackageManager packageManager = myDownloads.getPackageManager();
                t.d(packageManager, "getPackageManager(...)");
                String absolutePath = file.getAbsolutePath();
                t.d(absolutePath, "getAbsolutePath(...)");
                PackageInfo c5 = C2301u.c(packageManager, absolutePath, 128);
                if (c5 == null) {
                    String string2 = myDownloads.getString(R.string.installable_files_not_found);
                    t.d(string2, "getString(...)");
                    myDownloads.u0(string2);
                    return;
                }
                E e5 = new E();
                String name = file.getName();
                t.d(name, "getName(...)");
                String k5 = e5.k(name);
                if (k5 == null) {
                    C1598a.D2(myDownloads, file, (String) null, 2, (Object) null);
                } else if (new C2290j().m(c5) > 694) {
                    C1598a.D2(myDownloads, file, (String) null, 2, (Object) null);
                } else {
                    myDownloads.J2(k5, (C2661j) null);
                }
            } else {
                String string3 = myDownloads.getString(R.string.installable_files_not_found);
                t.d(string3, "getString(...)");
                myDownloads.u0(string3);
            }
        } else if (qVar.o().size() != 1 || (a5 = ((r) qVar.o().get(0)).a()) == null || a5.length() == 0) {
            File n5 = qVar.n();
            if (n5 != null) {
                C1598a.D2(myDownloads, n5, (String) null, 2, (Object) null);
                return;
            }
            String string4 = myDownloads.getString(R.string.installable_files_not_found);
            t.d(string4, "getString(...)");
            myDownloads.u0(string4);
        } else {
            String a7 = ((r) qVar.o().get(0)).a();
            t.b(a7);
            File file2 = new File(a7);
            if (file2.exists()) {
                myDownloads.S3(file2);
                return;
            }
            String string5 = myDownloads.getString(R.string.installable_files_not_found);
            t.d(string5, "getString(...)");
            myDownloads.u0(string5);
        }
    }

    private final boolean n4(C2668q qVar) {
        if (qVar == null || qVar.x() <= 0 || qVar.x() >= 100) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final C2420j0 o4() {
        return (C2420j0) this.f14177K.getValue();
    }

    /* access modifiers changed from: private */
    public final int p4(String str) {
        if (!(str == null || str.length() == 0)) {
            C0971b bVar = this.f14179M;
            t.b(bVar);
            ArrayList d5 = bVar.d();
            int size = d5.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = d5.get(i5);
                t.d(obj, "get(...)");
                if (s.E(((C2668q) obj).w(), str, true)) {
                    return i5;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final C1620x q4() {
        return (C1620x) this.f14178L.getValue();
    }

    private final void r4() {
        setContentView((View) o4().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o4().f23251g.setNavigationIcon(drawable);
            o4().f23251g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        k.a aVar = S1.k.f32g;
        ((TextView) findViewById(R.id.tv_toolbar_title_downloads)).setTypeface(aVar.w());
        o4().f23251g.setNavigationOnClickListener(new C0798h3(this));
        o4().f23251g.inflateMenu(R.menu.toolbar_menu_my_downloads);
        o4().f23251g.setOnMenuItemClickListener(new C0822k3(this));
        o4().f23250f.setOnQueryTextListener(new g(this));
        o4().f23250f.setOnClickListener(new C0830l3(this));
        ((ImageView) o4().f23250f.findViewById(R.id.search_close_btn)).setBackgroundResource(R.drawable.core_shape_transparent);
        EditText editText = (EditText) o4().f23250f.findViewById(R.id.search_src_text);
        editText.setTypeface(aVar.x());
        editText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.core_search_view_color));
        o4().f23247c.f23281b.f22371c.setTypeface(aVar.x());
        o4().f23247c.f23281b.f22372d.setTypeface(aVar.w());
        o4().f23247c.f23281b.f22372d.setText(getString(R.string.order_by_date));
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.order_by_name));
        hashMap.put(1, getString(R.string.order_by_date));
        hashMap.put(2, getString(R.string.order_by_size));
        o4().f23247c.f23281b.getRoot().setOnClickListener(new C0838m3(this, hashMap));
        o4().f23249e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        o4().f23249e.addItemDecoration(new B2.l(dimension, dimension));
        o4().f23249e.setItemAnimator((RecyclerView.ItemAnimator) null);
        o4().f23249e.addOnItemTouchListener(new h(this));
        o4().f23252h.setTypeface(aVar.x());
        TextView textView = o4().f23247c.f23284e;
        o4().f23247c.f23285f.setTypeface(aVar.x());
        o4().f23247c.f23283d.setTypeface(aVar.w());
        o4().f23247c.f23283d.setOnClickListener(new C0846n3(this));
        o4().f23247c.f23284e.setTypeface(aVar.w());
        o4().f23247c.f23284e.setOnClickListener(new C0854o3(this));
        o4().f23246b.setOnClickListener(new C0862p3());
        I4();
        NestedScrollView nestedScrollView = o4().f23248d;
        t.d(nestedScrollView, "nsvMyDownloads");
        hideKeyboardOnScroll(nestedScrollView);
        p0();
        getOnBackPressedDispatcher().addCallback(this, this.f14182P);
    }

    /* access modifiers changed from: private */
    public static final void s4(MyDownloads myDownloads, View view) {
        myDownloads.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final boolean t4(MyDownloads myDownloads, MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_file_explorer) {
            myDownloads.startActivity(new Intent(myDownloads, FileExplorerActivity.class));
        }
        if (menuItem.getItemId() != R.id.action_search) {
            return true;
        }
        SearchView searchView = myDownloads.o4().f23250f;
        t.d(searchView, "searchViewMyDownloads");
        if (searchView.getVisibility() == 0) {
            myDownloads.o4().f23250f.setVisibility(8);
            myDownloads.o4().f23250f.clearFocus();
            return true;
        }
        myDownloads.o4().f23250f.setVisibility(0);
        myDownloads.o4().f23250f.requestFocus();
        SearchView searchView2 = myDownloads.o4().f23250f;
        t.d(searchView2, "searchViewMyDownloads");
        myDownloads.showKeyboard(searchView2);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void u4(MyDownloads myDownloads, View view) {
        myDownloads.o4().f23250f.setIconified(false);
    }

    /* access modifiers changed from: private */
    public static final void v4(MyDownloads myDownloads, HashMap hashMap, View view) {
        t.b(view);
        new D2.q(myDownloads, view, hashMap, new C0870q3(myDownloads)).c();
    }

    /* access modifiers changed from: private */
    public static final J w4(MyDownloads myDownloads, int i5, String str) {
        C1620x.b bVar;
        t.e(str, "selectedOption");
        if (i5 == 0) {
            C1620x.b bVar2 = myDownloads.f14180N;
            C1620x.b bVar3 = C1620x.b.NAME;
            if (bVar2 != bVar3) {
                myDownloads.f14180N = bVar3;
            }
        } else if (i5 == 1) {
            C1620x.b bVar4 = myDownloads.f14180N;
            C1620x.b bVar5 = C1620x.b.DATE;
            if (bVar4 != bVar5) {
                myDownloads.f14180N = bVar5;
            }
        } else if (i5 == 2 && myDownloads.f14180N != (bVar = C1620x.b.SIZE)) {
            myDownloads.f14180N = bVar;
        }
        if (((Number) myDownloads.q4().o().getValue()).intValue() != i5) {
            myDownloads.q4().o().setValue(Integer.valueOf(i5));
            myDownloads.o4().f23247c.f23281b.f22372d.setText(str);
            myDownloads.Q3(myDownloads.o4().f23250f.getQuery().toString());
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void x4(MyDownloads myDownloads, View view) {
        myDownloads.b4();
    }

    /* access modifiers changed from: private */
    public static final void y4(MyDownloads myDownloads, View view) {
        myDownloads.d4();
    }

    /* access modifiers changed from: private */
    public static final void z4(View view) {
    }

    public final void A4() {
        Integer num;
        C0971b bVar;
        C0971b bVar2 = this.f14179M;
        if (bVar2 != null) {
            num = Integer.valueOf(bVar2.f());
        } else {
            num = null;
        }
        if (!(num == null || num.intValue() < 0 || (bVar = this.f14179M) == null)) {
            bVar.notifyItemChanged(num.intValue());
        }
        C0971b bVar3 = this.f14179M;
        if (bVar3 != null) {
            bVar3.j();
        }
    }

    public final void B4(String str) {
        C0971b bVar;
        if (str != null && (bVar = this.f14179M) != null) {
            t.b(bVar);
            if (!bVar.d().isEmpty()) {
                C0971b bVar2 = this.f14179M;
                t.b(bVar2);
                int e5 = bVar2.e(str);
                if (e5 >= 0) {
                    C0971b bVar3 = this.f14179M;
                    t.b(bVar3);
                    bVar3.notifyItemChanged(e5);
                    C0971b bVar4 = this.f14179M;
                    t.b(bVar4);
                    String string = getString(R.string.install_compatibility_error, new Object[]{((C2668q) bVar4.d().get(e5)).i()});
                    t.d(string, "getString(...)");
                    u0(string);
                }
                C0971b bVar5 = this.f14179M;
                t.b(bVar5);
                bVar5.j();
            }
        }
    }

    public final void D4(boolean z4) {
        q4().k(this, this.f14180N, z4);
    }

    public final void J4(int i5, C2668q qVar) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new n(this, i5, qVar, (C2308e) null), 2, (Object) null);
    }

    public void N2() {
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void V2(File file) {
        t.e(file, "xapkFile");
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            bVar.j();
        }
        C0971b bVar2 = this.f14179M;
        if (bVar2 != null) {
            bVar2.i(file, this);
        }
    }

    public void W2(File file, int i5) {
        t.e(file, "file");
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            bVar.i(file, this);
        }
    }

    public void Z2(File file) {
        t.e(file, "xapkFile");
        C0971b bVar = this.f14179M;
        if (bVar != null) {
            bVar.l(file, this);
        }
    }

    public void e3(C2657f fVar) {
        t.e(fVar, "appInfo");
        if (!isFinishing()) {
            Intent intent = new Intent(this, AppDetailActivity.class);
            intent.putExtra("appInfo", fVar);
            startActivity(intent, UptodownApp.f13477F.a(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("remoteInstallPath")) {
            Bundle extras2 = getIntent().getExtras();
            if (extras2 != null) {
                str = extras2.getString("remoteInstallPath");
            } else {
                str = null;
            }
            t.b(str);
            File file = new File(str);
            if (file.exists()) {
                C1598a.D2(this, file, (String) null, 2, (Object) null);
            }
            z2.M.f26506a.c(this);
        }
        r4();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new j(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            C2940B a5 = C2940B.f26458v.a(this);
            a5.a();
            a5.u1();
            a5.m();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        z2.M.f26506a.h(this);
        D4(true);
    }
}
