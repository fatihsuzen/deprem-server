package com.uptodown.activities;

import O1.A7;
import O1.B7;
import O1.T2;
import O1.t7;
import O1.u7;
import O1.v7;
import O1.w7;
import O1.x7;
import O1.y7;
import O1.z7;
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
import com.uptodown.activities.j0;
import com.uptodown.workers.DownloadWorker;
import g2.C2388j;
import g2.w;
import h2.y1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import k2.C2610u;
import k2.S;
import k2.X;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.Q;
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

public final class WishlistActivity extends T2 {

    /* renamed from: n0  reason: collision with root package name */
    public static final a f14786n0 = new a((C2633k) null);

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14787W = m.b(new u7(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14788X = new ViewModelLazy(M.b(j0.class), new h(this), new g(this), new i((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public T f14789Y;

    /* renamed from: Z  reason: collision with root package name */
    private d f14790Z = new d(this);

    /* renamed from: m0  reason: collision with root package name */
    private final ActivityResultLauncher f14791m0;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements S {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f14792a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14793b;

        b(WishlistActivity wishlistActivity, int i5) {
            this.f14792a = wishlistActivity;
            this.f14793b = i5;
        }

        public void a() {
            WishlistActivity wishlistActivity = this.f14792a;
            String string = wishlistActivity.getString(R.string.error_generico);
            t.d(string, "getString(...)");
            wishlistActivity.u0(string);
        }

        public void f() {
            ArrayList b5;
            T d5 = this.f14792a.f14789Y;
            if (!(d5 == null || (b5 = d5.b()) == null)) {
                Y y4 = (Y) b5.remove(this.f14793b);
            }
            T d52 = this.f14792a.f14789Y;
            if (d52 != null) {
                d52.notifyItemRemoved(this.f14793b);
            }
        }
    }

    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f14794a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f14795b;

        c(LinearLayoutManager linearLayoutManager, WishlistActivity wishlistActivity) {
            this.f14794a = linearLayoutManager;
            this.f14795b = wishlistActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f14794a.findFirstVisibleItemPosition();
                int childCount = this.f14794a.getChildCount();
                int itemCount = this.f14794a.getItemCount();
                if (!this.f14795b.n5().g() && !this.f14795b.n5().e() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    T d5 = this.f14795b.f14789Y;
                    t.b(d5);
                    d5.f(true);
                    this.f14795b.n5().d(this.f14795b);
                }
            }
        }
    }

    public static final class d implements X {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f14796a;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WishlistActivity f14797a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f14798b;

            a(WishlistActivity wishlistActivity, int i5) {
                this.f14797a = wishlistActivity;
                this.f14798b = i5;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                String p5 = fVar.p();
                if (p5 == null || p5.length() == 0) {
                    WishlistActivity wishlistActivity = this.f14797a;
                    String string = wishlistActivity.getString(R.string.dialog_msg_download_not_available, new Object[]{fVar.N()});
                    t.d(string, "getString(...)");
                    wishlistActivity.a2(string);
                } else if (new C2954m().v(fVar.S(), this.f14797a)) {
                    this.f14797a.H4(new C2954m().C(this.f14797a, fVar.S()));
                } else {
                    this.f14797a.A5(fVar, this.f14798b);
                }
            }

            public void d(int i5) {
                String h5;
                T d5 = this.f14797a.f14789Y;
                t.b(d5);
                Object obj = d5.b().get(this.f14798b);
                t.d(obj, "get(...)");
                Y y4 = (Y) obj;
                if (y4.j() || (h5 = y4.h()) == null || h5.length() == 0) {
                    WishlistActivity wishlistActivity = this.f14797a;
                    String string = wishlistActivity.getString(R.string.error_cant_enqueue_download);
                    t.d(string, "getString(...)");
                    wishlistActivity.u0(string);
                    return;
                }
                C2962v vVar = new C2962v();
                WishlistActivity wishlistActivity2 = this.f14797a;
                String h6 = y4.h();
                t.b(h6);
                C2962v.u(vVar, wishlistActivity2, h6, (String) null, 4, (Object) null);
            }
        }

        d(WishlistActivity wishlistActivity) {
            this.f14796a = wishlistActivity;
        }

        public void a(int i5) {
            if (UptodownApp.f13477F.Z() && this.f14796a.f14789Y != null) {
                T d5 = this.f14796a.f14789Y;
                t.b(d5);
                if (!d5.b().isEmpty()) {
                    T d52 = this.f14796a.f14789Y;
                    t.b(d52);
                    Object obj = d52.b().get(i5);
                    t.d(obj, "get(...)");
                    Y y4 = (Y) obj;
                    this.f14796a.I2(y4.a(), y4.h());
                }
            }
        }

        public void b(View view, int i5) {
            t.e(view, "v");
            if (UptodownApp.f13477F.Z() && this.f14796a.f14789Y != null) {
                T d5 = this.f14796a.f14789Y;
                t.b(d5);
                if (!d5.b().isEmpty()) {
                    WishlistActivity wishlistActivity = this.f14796a;
                    T d52 = wishlistActivity.f14789Y;
                    t.b(d52);
                    Object obj = d52.b().get(i5);
                    t.d(obj, "get(...)");
                    wishlistActivity.k5((Y) obj, i5);
                }
            }
        }

        public void c(int i5) {
            if (this.f14796a.f14789Y != null) {
                T d5 = this.f14796a.f14789Y;
                t.b(d5);
                if (!d5.b().isEmpty()) {
                    WishlistActivity wishlistActivity = this.f14796a;
                    T d52 = wishlistActivity.f14789Y;
                    t.b(d52);
                    new C2388j(wishlistActivity, ((Y) d52.b().get(i5)).a(), new a(this.f14796a, i5), LifecycleOwnerKt.getLifecycleScope(this.f14796a));
                }
            }
        }

        public void d(int i5) {
            if (this.f14796a.f14789Y != null) {
                T d5 = this.f14796a.f14789Y;
                t.b(d5);
                if (!d5.b().isEmpty()) {
                    T d52 = this.f14796a.f14789Y;
                    t.b(d52);
                    Object obj = d52.b().get(i5);
                    t.d(obj, "get(...)");
                    Y y4 = (Y) obj;
                    String g5 = y4.g();
                    if (g5 == null || g5.length() == 0) {
                        WishlistActivity wishlistActivity = this.f14796a;
                        String string = wishlistActivity.getString(R.string.error_open_app, new Object[]{y4.f()});
                        t.d(string, "getString(...)");
                        wishlistActivity.a2(string);
                        return;
                    }
                    PackageManager packageManager = this.f14796a.getPackageManager();
                    String g6 = y4.g();
                    t.b(g6);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(g6);
                    if (launchIntentForPackage != null) {
                        this.f14796a.startActivity(launchIntentForPackage);
                        return;
                    }
                    WishlistActivity wishlistActivity2 = this.f14796a;
                    String string2 = wishlistActivity2.getString(R.string.error_open_app, new Object[]{y4.f()});
                    t.d(string2, "getString(...)");
                    wishlistActivity2.a2(string2);
                }
            }
        }

        public void e(long j5, C2660i iVar) {
            t.e(iVar, "category");
            if (UptodownApp.f13477F.Z()) {
                this.f14796a.B5(j5, iVar);
            }
        }

        public void f(int i5) {
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14799a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f14800b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WishlistActivity f14801a;

            a(WishlistActivity wishlistActivity) {
                this.f14801a = wishlistActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    if (this.f14801a.f14789Y == null) {
                        this.f14801a.m5().f23685b.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    this.f14801a.j5(((j0.a) cVar.a()).a());
                    if (((j0.a) cVar.a()).a().isEmpty()) {
                        this.f14801a.m5().f23689f.setVisibility(0);
                        this.f14801a.m5().f23688e.setVisibility(0);
                    }
                    this.f14801a.m5().f23685b.setVisibility(8);
                } else if (o5 instanceof O.b) {
                    T d5 = this.f14801a.f14789Y;
                    if (d5 != null) {
                        d5.f(false);
                    }
                } else {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(WishlistActivity wishlistActivity, C2308e eVar) {
            super(2, eVar);
            this.f14800b = wishlistActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14800b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14799a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f14800b.n5().f();
                a aVar = new a(this.f14800b);
                this.f14799a = 1;
                if (f6.collect(aVar, this) == f5) {
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

    public static final class f implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f14802a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2660i f14803b;

        f(WishlistActivity wishlistActivity, C2660i iVar) {
            this.f14802a = wishlistActivity;
            this.f14803b = iVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f14802a.isFinishing()) {
                Intent intent = new Intent(this.f14802a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                intent.putExtra("viewCategory", this.f14803b);
                WishlistActivity wishlistActivity = this.f14802a;
                wishlistActivity.startActivity(intent, UptodownApp.f13477F.a(wishlistActivity));
            }
        }

        public void d(int i5) {
            WishlistActivity wishlistActivity = this.f14802a;
            String string = wishlistActivity.getString(R.string.app_detail_not_found);
            t.d(string, "getString(...)");
            wishlistActivity.u0(string);
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14804a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14804a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14804a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14805a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f14805a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14805a.getViewModelStore();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14806a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14807b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14806a = aVar;
            this.f14807b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14806a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14807b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.WishlistActivity.i.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14808a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WishlistActivity f14809b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14810c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(WishlistActivity wishlistActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14809b = wishlistActivity;
            this.f14810c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f14809b, this.f14810c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            C2316b.f();
            if (this.f14808a == 0) {
                u.b(obj);
                if (this.f14809b.f14789Y != null) {
                    T d5 = this.f14809b.f14789Y;
                    t.b(d5);
                    if (!(d5.b().isEmpty() || (str = this.f14810c) == null || str.length() == 0)) {
                        T d52 = this.f14809b.f14789Y;
                        t.b(d52);
                        ArrayList b5 = d52.b();
                        String str2 = this.f14810c;
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
                        T d53 = this.f14809b.f14789Y;
                        t.b(d53);
                        int R4 = C2250q.R(d53.b(), (Y) obj2);
                        if (R4 > -1) {
                            T d54 = this.f14809b.f14789Y;
                            t.b(d54);
                            d54.notifyItemChanged(R4);
                        } else {
                            this.f14809b.z5();
                        }
                        return J.f19942a;
                    }
                }
                this.f14809b.z5();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public WishlistActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new v7());
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14791m0 = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public final void A5(C2657f fVar, int i5) {
        C2940B.a aVar = C2940B.f26458v;
        Context applicationContext = getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        C2940B a5 = aVar.a(applicationContext);
        a5.a();
        C2668q j02 = a5.j0(String.valueOf(fVar.S()));
        a5.m();
        if (j02 != null) {
            int x4 = j02.x();
            if (1 <= x4 && x4 < 100) {
                DownloadWorker.a aVar2 = DownloadWorker.f21359d;
                aVar2.d(fVar.e());
                z2.M.f26506a.h(this);
                a5.a();
                a5.A(j02);
                j02.g();
                a5.m();
                aVar2.o();
            } else if (!j02.f() || j02.n() == null) {
                j02.T(this);
                T t5 = this.f14789Y;
                if (t5 != null) {
                    t5.notifyItemChanged(i5);
                }
            } else {
                UptodownApp.a aVar3 = UptodownApp.f13477F;
                File n5 = j02.n();
                t.b(n5);
                aVar3.W(n5, this, fVar.O());
            }
        } else {
            UptodownApp.f13477F.a0(fVar, this);
            T t6 = this.f14789Y;
            if (t6 != null) {
                t.b(t6);
                ((Y) t6.b().get(i5)).o(fVar.A());
                T t7 = this.f14789Y;
                if (t7 != null) {
                    t7.notifyItemChanged(i5);
                }
            }
        }
    }

    private final void C5() {
        this.f14791m0.launch(new Intent(this, LoginActivity.class), UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: private */
    public static final y1 i5(WishlistActivity wishlistActivity) {
        return y1.c(wishlistActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void j5(ArrayList arrayList) {
        T t5 = this.f14789Y;
        if (t5 == null) {
            this.f14789Y = new T(arrayList, this, this.f14790Z);
            m5().f23686c.setAdapter(this.f14789Y);
            return;
        }
        t.b(t5);
        t5.a(arrayList);
        T t6 = this.f14789Y;
        if (t6 != null) {
            t6.f(false);
        }
    }

    /* access modifiers changed from: private */
    public final void k5(Y y4, int i5) {
        Q q5 = Q.f24695a;
        String string = getString(R.string.dialog_wishlist_msg);
        t.d(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{y4.f()}, 1));
        t.d(format, "format(...)");
        U1(format, new B7(this, y4, i5));
    }

    /* access modifiers changed from: private */
    public static final J l5(WishlistActivity wishlistActivity, Y y4, int i5) {
        b bVar = new b(wishlistActivity, i5);
        if (UptodownApp.f13477F.Z()) {
            new w(wishlistActivity, LifecycleOwnerKt.getLifecycleScope(wishlistActivity)).g(y4.a(), bVar);
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final y1 m5() {
        return (y1) this.f14787W.getValue();
    }

    /* access modifiers changed from: private */
    public final j0 n5() {
        return (j0) this.f14788X.getValue();
    }

    private final void o5() {
        setContentView((View) m5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        y1 m5 = m5();
        if (drawable != null) {
            m5.f23687d.setNavigationIcon(drawable);
            m5.f23687d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        m5.f23687d.setNavigationOnClickListener(new w7(this));
        TextView textView = m5.f23690g;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        m5.f23686c.setLayoutManager(linearLayoutManager);
        m5.f23686c.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        m5().f23686c.addItemDecoration(new B2.l(dimension, dimension));
        m5.f23686c.setItemAnimator(defaultItemAnimator);
        m5.f23689f.setTypeface(aVar.x());
        m5.f23688e.setTypeface(aVar.w());
        m5.f23688e.setOnClickListener(new x7(this));
        m5.f23685b.setOnClickListener(new y7());
        m5.f23686c.addOnScrollListener(new c(linearLayoutManager, this));
    }

    /* access modifiers changed from: private */
    public static final void p5(WishlistActivity wishlistActivity, View view) {
        wishlistActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void q5(WishlistActivity wishlistActivity, View view) {
        wishlistActivity.setResult(1);
        wishlistActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void r5(View view) {
    }

    private final void u5() {
        V h5 = V.f24870q.h(this);
        if (h5 == null || !h5.p(this)) {
            new Handler(Looper.getMainLooper()).postDelayed(new t7(this), 500);
        } else {
            n5().d(this);
        }
    }

    /* access modifiers changed from: private */
    public static final void v5(WishlistActivity wishlistActivity) {
        String string = wishlistActivity.getString(R.string.wishlist_login_msg);
        t.d(string, "getString(...)");
        wishlistActivity.V1(string, new z7(wishlistActivity), new A7(wishlistActivity));
    }

    /* access modifiers changed from: private */
    public static final J w5(WishlistActivity wishlistActivity) {
        wishlistActivity.C5();
        AlertDialog p22 = wishlistActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J x5(WishlistActivity wishlistActivity) {
        wishlistActivity.finish();
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void y5(ActivityResult activityResult) {
        activityResult.getResultCode();
    }

    /* access modifiers changed from: private */
    public final void z5() {
        T t5 = this.f14789Y;
        if (t5 != null) {
            t5.notifyDataSetChanged();
        }
    }

    public final void B5(long j5, C2660i iVar) {
        t.e(iVar, "floatingCategory");
        if (j5 > 0) {
            new C2388j(this, j5, new f(this, iVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        K2();
        J j6 = J.f19942a;
    }

    public final void D5(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new j(this, str, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void M4() {
    }

    public void N2() {
        T t5 = this.f14789Y;
        if (t5 != null) {
            t5.d();
        }
    }

    public void V2(File file) {
        t.e(file, "xapkFile");
        T t5 = this.f14789Y;
        if (t5 != null) {
            t5.d();
        }
        T t6 = this.f14789Y;
        if (t6 != null) {
            t6.c(file, this);
        }
    }

    public void W2(File file, int i5) {
        t.e(file, "file");
        T t5 = this.f14789Y;
        if (t5 != null) {
            t5.c(file, this);
        }
    }

    public void Z2(File file) {
        t.e(file, "xapkFile");
        T t5 = this.f14789Y;
        if (t5 != null) {
            t5.e(file, this);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o5();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        u5();
    }

    public final void s5() {
        T t5 = this.f14789Y;
        if (t5 != null) {
            t5.d();
        }
    }

    public final void t5(String str) {
        T t5 = this.f14789Y;
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
