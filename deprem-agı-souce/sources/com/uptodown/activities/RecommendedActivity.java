package com.uptodown.activities;

import O1.A4;
import O1.B4;
import O1.C0942z4;
import O1.C4;
import O1.D4;
import O1.E4;
import O1.F4;
import O1.G4;
import O1.H4;
import O1.I4;
import O1.J4;
import O1.T2;
import R1.T;
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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import g2.C2388j;
import g2.C2395q;
import h2.J0;
import java.io.File;
import java.util.ArrayList;
import k2.C2610u;
import k2.S;
import k2.X;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.C2668q;
import l2.V;
import l2.Y;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;

public final class RecommendedActivity extends T2 {

    /* renamed from: n0  reason: collision with root package name */
    public static final a f14422n0 = new a((C2633k) null);

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14423W = m.b(new A4(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14424X = new ViewModelLazy(M.b(J4.class), new i(this), new h(this), new j((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public T f14425Y;

    /* renamed from: Z  reason: collision with root package name */
    private d f14426Z = new d(this);

    /* renamed from: m0  reason: collision with root package name */
    private final ActivityResultLauncher f14427m0;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements S {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14428a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14429b;

        b(RecommendedActivity recommendedActivity, int i5) {
            this.f14428a = recommendedActivity;
            this.f14429b = i5;
        }

        public void a() {
            RecommendedActivity recommendedActivity = this.f14428a;
            String string = recommendedActivity.getString(R.string.error_generico);
            t.d(string, "getString(...)");
            recommendedActivity.u0(string);
        }

        public void f() {
            ArrayList b5;
            T e5 = this.f14428a.f14425Y;
            if (!(e5 == null || (b5 = e5.b()) == null)) {
                Y y4 = (Y) b5.remove(this.f14429b);
            }
            T e52 = this.f14428a.f14425Y;
            if (e52 != null) {
                e52.notifyItemRemoved(this.f14429b);
            }
        }
    }

    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f14430a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14431b;

        c(LinearLayoutManager linearLayoutManager, RecommendedActivity recommendedActivity) {
            this.f14430a = linearLayoutManager;
            this.f14431b = recommendedActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f14430a.findFirstVisibleItemPosition();
                int childCount = this.f14430a.getChildCount();
                int itemCount = this.f14430a.getItemCount();
                if (!this.f14431b.o5().h() && !this.f14431b.o5().g() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    T e5 = this.f14431b.f14425Y;
                    t.b(e5);
                    e5.f(true);
                    this.f14431b.o5().f(this.f14431b);
                }
            }
        }
    }

    public static final class d implements X {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14432a;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecommendedActivity f14433a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f14434b;

            a(RecommendedActivity recommendedActivity, int i5) {
                this.f14433a = recommendedActivity;
                this.f14434b = i5;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                String p5 = fVar.p();
                if (p5 == null || p5.length() == 0) {
                    RecommendedActivity recommendedActivity = this.f14433a;
                    String string = recommendedActivity.getString(R.string.dialog_msg_download_not_available, new Object[]{fVar.N()});
                    t.d(string, "getString(...)");
                    recommendedActivity.a2(string);
                } else if (new C2954m().v(fVar.S(), this.f14433a)) {
                    this.f14433a.H4(new C2954m().C(this.f14433a, fVar.S()));
                } else {
                    this.f14433a.C5(fVar, this.f14434b);
                }
            }

            public void d(int i5) {
                String h5;
                T e5 = this.f14433a.f14425Y;
                t.b(e5);
                Object obj = e5.b().get(this.f14434b);
                t.d(obj, "get(...)");
                Y y4 = (Y) obj;
                if (y4.j() || (h5 = y4.h()) == null || h5.length() == 0) {
                    RecommendedActivity recommendedActivity = this.f14433a;
                    String string = recommendedActivity.getString(R.string.error_cant_enqueue_download);
                    t.d(string, "getString(...)");
                    recommendedActivity.u0(string);
                    return;
                }
                C2962v vVar = new C2962v();
                RecommendedActivity recommendedActivity2 = this.f14433a;
                String h6 = y4.h();
                t.b(h6);
                C2962v.u(vVar, recommendedActivity2, h6, (String) null, 4, (Object) null);
            }
        }

        d(RecommendedActivity recommendedActivity) {
            this.f14432a = recommendedActivity;
        }

        public void a(int i5) {
            if (UptodownApp.f13477F.Z() && this.f14432a.f14425Y != null) {
                T e5 = this.f14432a.f14425Y;
                t.b(e5);
                if (!e5.b().isEmpty()) {
                    T e52 = this.f14432a.f14425Y;
                    t.b(e52);
                    Object obj = e52.b().get(i5);
                    t.d(obj, "get(...)");
                    Y y4 = (Y) obj;
                    this.f14432a.I2(y4.a(), y4.h());
                }
            }
        }

        public void b(View view, int i5) {
            t.e(view, "v");
            if (UptodownApp.f13477F.Z() && this.f14432a.f14425Y != null) {
                T e5 = this.f14432a.f14425Y;
                t.b(e5);
                if (!e5.b().isEmpty()) {
                    RecommendedActivity recommendedActivity = this.f14432a;
                    T e52 = recommendedActivity.f14425Y;
                    t.b(e52);
                    Object obj = e52.b().get(i5);
                    t.d(obj, "get(...)");
                    recommendedActivity.l5((Y) obj, i5);
                }
            }
        }

        public void c(int i5) {
            if (this.f14432a.f14425Y != null) {
                T e5 = this.f14432a.f14425Y;
                t.b(e5);
                if (!e5.b().isEmpty()) {
                    RecommendedActivity recommendedActivity = this.f14432a;
                    T e52 = recommendedActivity.f14425Y;
                    t.b(e52);
                    new C2388j(recommendedActivity, ((Y) e52.b().get(i5)).a(), new a(this.f14432a, i5), LifecycleOwnerKt.getLifecycleScope(this.f14432a));
                }
            }
        }

        public void d(int i5) {
            if (this.f14432a.f14425Y != null) {
                T e5 = this.f14432a.f14425Y;
                t.b(e5);
                if (!e5.b().isEmpty()) {
                    T e52 = this.f14432a.f14425Y;
                    t.b(e52);
                    Object obj = e52.b().get(i5);
                    t.d(obj, "get(...)");
                    Y y4 = (Y) obj;
                    String g5 = y4.g();
                    if (g5 == null || g5.length() == 0) {
                        RecommendedActivity recommendedActivity = this.f14432a;
                        String string = recommendedActivity.getString(R.string.error_open_app, new Object[]{y4.f()});
                        t.d(string, "getString(...)");
                        recommendedActivity.a2(string);
                        return;
                    }
                    PackageManager packageManager = this.f14432a.getPackageManager();
                    String g6 = y4.g();
                    t.b(g6);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(g6);
                    if (launchIntentForPackage != null) {
                        this.f14432a.startActivity(launchIntentForPackage);
                        return;
                    }
                    RecommendedActivity recommendedActivity2 = this.f14432a;
                    String string2 = recommendedActivity2.getString(R.string.error_open_app, new Object[]{y4.f()});
                    t.d(string2, "getString(...)");
                    recommendedActivity2.a2(string2);
                }
            }
        }

        public void e(long j5, C2660i iVar) {
            t.e(iVar, "category");
            if (UptodownApp.f13477F.Z()) {
                this.f14432a.D5(j5, iVar);
            }
        }

        public void f(int i5) {
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14435a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14436b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecommendedActivity f14437a;

            a(RecommendedActivity recommendedActivity) {
                this.f14437a = recommendedActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    if (this.f14437a.f14425Y == null) {
                        this.f14437a.n5().f22434b.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((ArrayList) cVar.a()).size() == 0) {
                        this.f14437a.n5().f22440h.setVisibility(0);
                        this.f14437a.n5().f22438f.setVisibility(0);
                    } else {
                        this.f14437a.n5().f22436d.setVisibility(0);
                        this.f14437a.n5().f22439g.setVisibility(0);
                        this.f14437a.k5((ArrayList) cVar.a());
                    }
                    this.f14437a.n5().f22434b.setVisibility(8);
                } else if (o5 instanceof O.b) {
                    T e5 = this.f14437a.f14425Y;
                    if (e5 != null) {
                        e5.f(false);
                    }
                } else {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(RecommendedActivity recommendedActivity, C2308e eVar) {
            super(2, eVar);
            this.f14436b = recommendedActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14436b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14435a;
            if (i5 == 0) {
                u.b(obj);
                D i6 = this.f14436b.o5().i();
                a aVar = new a(this.f14436b);
                this.f14435a = 1;
                if (i6.collect(aVar, this) == f5) {
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

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14438a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14439b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecommendedActivity f14440a;

            a(RecommendedActivity recommendedActivity) {
                this.f14440a = recommendedActivity;
            }

            public final Object b(boolean z4, C2308e eVar) {
                this.f14440a.n5().f22436d.setChecked(!z4);
                if (z4) {
                    this.f14440a.n5().f22439g.setText(this.f14440a.getString(R.string.private_list));
                } else {
                    this.f14440a.n5().f22439g.setText(this.f14440a.getString(R.string.public_list));
                }
                return J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Boolean) obj).booleanValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(RecommendedActivity recommendedActivity, C2308e eVar) {
            super(2, eVar);
            this.f14439b = recommendedActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f14439b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14438a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f14439b.o5().j();
                a aVar = new a(this.f14439b);
                this.f14438a = 1;
                if (j5.collect(aVar, this) == f5) {
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

    public static final class g implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14441a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2660i f14442b;

        g(RecommendedActivity recommendedActivity, C2660i iVar) {
            this.f14441a = recommendedActivity;
            this.f14442b = iVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f14441a.isFinishing()) {
                Intent intent = new Intent(this.f14441a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                intent.putExtra("viewCategory", this.f14442b);
                RecommendedActivity recommendedActivity = this.f14441a;
                recommendedActivity.startActivity(intent, UptodownApp.f13477F.a(recommendedActivity));
            }
        }

        public void d(int i5) {
            RecommendedActivity recommendedActivity = this.f14441a;
            String string = recommendedActivity.getString(R.string.app_detail_not_found);
            t.d(string, "getString(...)");
            recommendedActivity.u0(string);
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14443a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f14443a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14443a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14444a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f14444a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14444a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14445a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14446b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14445a = aVar;
            this.f14446b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14445a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14446b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.RecommendedActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecommendedActivity f14448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14449c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(RecommendedActivity recommendedActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14448b = recommendedActivity;
            this.f14449c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f14448b, this.f14449c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            C2316b.f();
            if (this.f14447a == 0) {
                u.b(obj);
                if (this.f14448b.f14425Y != null) {
                    T e5 = this.f14448b.f14425Y;
                    t.b(e5);
                    if (!(e5.b().isEmpty() || (str = this.f14449c) == null || str.length() == 0)) {
                        T e52 = this.f14448b.f14425Y;
                        t.b(e52);
                        ArrayList b5 = e52.b();
                        String str2 = this.f14449c;
                        int size = b5.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                obj2 = null;
                                break;
                            }
                            obj2 = b5.get(i5);
                            i5++;
                            if (t.a(((Y) obj2).g(), str2)) {
                                break;
                            }
                        }
                        T e53 = this.f14448b.f14425Y;
                        t.b(e53);
                        int R4 = C2250q.R(e53.b(), (Y) obj2);
                        if (R4 > -1) {
                            T e54 = this.f14448b.f14425Y;
                            t.b(e54);
                            e54.notifyItemChanged(R4);
                        } else {
                            this.f14448b.B5();
                        }
                        return J.f19942a;
                    }
                }
                this.f14448b.B5();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public RecommendedActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new B4());
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14427m0 = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void A5(ActivityResult activityResult) {
        activityResult.getResultCode();
    }

    /* access modifiers changed from: private */
    public final void B5() {
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void C5(C2657f fVar, int i5) {
        C2940B.a aVar = C2940B.f26458v;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        C2940B a5 = aVar.a(applicationContext);
        a5.a();
        C2668q j02 = a5.j0(String.valueOf(fVar.S()));
        a5.m();
        if (j02 != null) {
            DownloadWorker.a aVar2 = DownloadWorker.f21359d;
            if (aVar2.m(j02)) {
                aVar2.d(fVar.e());
                UptodownApp.a aVar3 = UptodownApp.f13477F;
                String S4 = fVar.S();
                t.b(S4);
                aVar3.d0(S4);
                z2.M.f26506a.h(this);
            } else if (j02.f() && j02.n() != null) {
                UptodownApp.a aVar4 = UptodownApp.f13477F;
                File n5 = j02.n();
                t.b(n5);
                aVar4.W(n5, this, fVar.O());
            } else if (j02.M()) {
                j02.T(this);
                T t5 = this.f14425Y;
                if (t5 != null) {
                    t5.notifyItemChanged(i5);
                }
            }
        } else {
            UptodownApp.f13477F.a0(fVar, this);
            T t6 = this.f14425Y;
            if (t6 != null) {
                t.b(t6);
                ((Y) t6.b().get(i5)).o(fVar.A());
                T t7 = this.f14425Y;
                if (t7 != null) {
                    t7.notifyItemChanged(i5);
                }
            }
        }
    }

    private final void E5() {
        this.f14427m0.launch(new Intent(this, LoginActivity.class), UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: private */
    public static final J0 j5(RecommendedActivity recommendedActivity) {
        return J0.c(recommendedActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void k5(ArrayList arrayList) {
        T t5 = this.f14425Y;
        if (t5 == null) {
            this.f14425Y = new T(arrayList, this, this.f14426Z);
            n5().f22435c.setAdapter(this.f14425Y);
            return;
        }
        t.b(t5);
        t5.a(arrayList);
        T t6 = this.f14425Y;
        if (t6 != null) {
            t6.f(false);
        }
    }

    /* access modifiers changed from: private */
    public final void l5(Y y4, int i5) {
        String string = getString(R.string.dialog_recommended_remove_msg, new Object[]{y4.f()});
        t.d(string, "getString(...)");
        U1(string, new G4(this, y4, i5));
    }

    /* access modifiers changed from: private */
    public static final J m5(RecommendedActivity recommendedActivity, Y y4, int i5) {
        b bVar = new b(recommendedActivity, i5);
        if (UptodownApp.f13477F.Z()) {
            new C2395q(recommendedActivity, LifecycleOwnerKt.getLifecycleScope(recommendedActivity)).c(y4.a(), bVar);
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final J0 n5() {
        return (J0) this.f14423W.getValue();
    }

    /* access modifiers changed from: private */
    public final J4 o5() {
        return (J4) this.f14424X.getValue();
    }

    private final void p5() {
        setContentView((View) n5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        J0 n5 = n5();
        if (drawable != null) {
            n5.f22437e.setNavigationIcon(drawable);
            n5.f22437e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        n5.f22437e.setNavigationOnClickListener(new C4(this));
        TextView textView = n5.f22441i;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        n5.f22435c.setLayoutManager(linearLayoutManager);
        n5.f22435c.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        n5.f22435c.addItemDecoration(new B2.l(dimension, dimension));
        n5.f22435c.setItemAnimator(defaultItemAnimator);
        n5.f22439g.setTypeface(aVar.x());
        n5.f22440h.setTypeface(aVar.x());
        n5.f22438f.setTypeface(aVar.x());
        n5.f22438f.setOnClickListener(new D4(this));
        n5().f22436d.setOnClickListener(new E4(this));
        n5.f22434b.setOnClickListener(new F4());
        n5.f22435c.addOnScrollListener(new c(linearLayoutManager, this));
    }

    /* access modifiers changed from: private */
    public static final void q5(RecommendedActivity recommendedActivity, View view) {
        recommendedActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void r5(RecommendedActivity recommendedActivity, View view) {
        recommendedActivity.setResult(1);
        recommendedActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void s5(RecommendedActivity recommendedActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            recommendedActivity.o5().e(recommendedActivity);
        }
    }

    /* access modifiers changed from: private */
    public static final void t5(View view) {
    }

    private final void w5() {
        String j5;
        V h5 = V.f24870q.h(this);
        if (h5 == null || (j5 = h5.j()) == null || j5.length() == 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new C0942z4(this), 500);
        } else {
            o5().f(this);
        }
    }

    /* access modifiers changed from: private */
    public static final void x5(RecommendedActivity recommendedActivity) {
        String string = recommendedActivity.getString(R.string.recommended_login_msg);
        t.d(string, "getString(...)");
        recommendedActivity.V1(string, new H4(recommendedActivity), new I4(recommendedActivity));
    }

    /* access modifiers changed from: private */
    public static final J y5(RecommendedActivity recommendedActivity) {
        recommendedActivity.E5();
        AlertDialog p22 = recommendedActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J z5(RecommendedActivity recommendedActivity) {
        recommendedActivity.finish();
        return J.f19942a;
    }

    public final void D5(long j5, C2660i iVar) {
        t.e(iVar, "floatingCategory");
        if (j5 > 0) {
            new C2388j(this, j5, new g(this, iVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        K2();
        J j6 = J.f19942a;
    }

    public final void F5(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new k(this, str, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void M4() {
    }

    public void N2() {
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.d();
        }
    }

    public void V2(File file) {
        t.e(file, "xapkFile");
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.d();
        }
        T t6 = this.f14425Y;
        if (t6 != null) {
            t6.c(file, this);
        }
    }

    public void W2(File file, int i5) {
        t.e(file, "file");
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.c(file, this);
        }
    }

    public void Z2(File file) {
        t.e(file, "xapkFile");
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.e(file, this);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p5();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new f(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        w5();
    }

    public final void u5() {
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.d();
        }
    }

    public final void v5(String str) {
        T t5 = this.f14425Y;
        if (t5 != null) {
            t5.d();
        }
        if (str != null && str.length() != 0) {
            String string = getString(R.string.install_compatibility_error, new Object[]{str});
            t.d(string, "getString(...)");
            u0(string);
        }
    }
}
