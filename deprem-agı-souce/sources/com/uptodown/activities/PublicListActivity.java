package com.uptodown.activities;

import O1.C0831l4;
import O1.C0839m4;
import O1.C0847n4;
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
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
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
import h2.G0;
import java.io.File;
import java.util.ArrayList;
import k2.C2610u;
import k2.X;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
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
import z3.w;

public final class PublicListActivity extends T2 {

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14363W = m.b(new C0839m4(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14364X = new ViewModelLazy(M.b(C0847n4.class), new f(this), new e(this), new g((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public T f14365Y;

    /* renamed from: Z  reason: collision with root package name */
    private b f14366Z = new b(this);

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f14367a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f14368b;

        a(LinearLayoutManager linearLayoutManager, PublicListActivity publicListActivity) {
            this.f14367a = linearLayoutManager;
            this.f14368b = publicListActivity;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f14367a.findFirstVisibleItemPosition();
                int childCount = this.f14367a.getChildCount();
                int itemCount = this.f14367a.getItemCount();
                if (!this.f14368b.d5().f() && !this.f14368b.d5().e() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    T V4 = this.f14368b.f14365Y;
                    t.b(V4);
                    V4.f(true);
                    this.f14368b.d5().d(this.f14368b);
                }
            }
        }
    }

    public static final class b implements X {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f14369a;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicListActivity f14370a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f14371b;

            a(PublicListActivity publicListActivity, int i5) {
                this.f14370a = publicListActivity;
                this.f14371b = i5;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                String p5 = fVar.p();
                if (p5 == null || p5.length() == 0) {
                    PublicListActivity publicListActivity = this.f14370a;
                    String string = publicListActivity.getString(R.string.dialog_msg_download_not_available, new Object[]{fVar.N()});
                    t.d(string, "getString(...)");
                    publicListActivity.a2(string);
                } else if (new C2954m().v(fVar.S(), this.f14370a)) {
                    this.f14370a.H4(new C2954m().C(this.f14370a, fVar.S()));
                } else {
                    this.f14370a.h5(fVar, this.f14371b);
                }
            }

            public void d(int i5) {
                String h5;
                T V4 = this.f14370a.f14365Y;
                t.b(V4);
                Object obj = V4.b().get(this.f14371b);
                t.d(obj, "get(...)");
                Y y4 = (Y) obj;
                if (y4.j() || (h5 = y4.h()) == null || h5.length() == 0) {
                    PublicListActivity publicListActivity = this.f14370a;
                    String string = publicListActivity.getString(R.string.error_cant_enqueue_download);
                    t.d(string, "getString(...)");
                    publicListActivity.u0(string);
                    return;
                }
                C2962v vVar = new C2962v();
                PublicListActivity publicListActivity2 = this.f14370a;
                String h6 = y4.h();
                t.b(h6);
                C2962v.u(vVar, publicListActivity2, h6, (String) null, 4, (Object) null);
            }
        }

        b(PublicListActivity publicListActivity) {
            this.f14369a = publicListActivity;
        }

        public void a(int i5) {
            if (UptodownApp.f13477F.Z() && this.f14369a.f14365Y != null) {
                T V4 = this.f14369a.f14365Y;
                t.b(V4);
                if (!V4.b().isEmpty()) {
                    T V42 = this.f14369a.f14365Y;
                    t.b(V42);
                    Object obj = V42.b().get(i5);
                    t.d(obj, "get(...)");
                    Y y4 = (Y) obj;
                    this.f14369a.I2(y4.a(), y4.h());
                }
            }
        }

        public void b(View view, int i5) {
            t.e(view, "v");
        }

        public void c(int i5) {
            if (this.f14369a.f14365Y != null) {
                T V4 = this.f14369a.f14365Y;
                t.b(V4);
                if (!V4.b().isEmpty()) {
                    PublicListActivity publicListActivity = this.f14369a;
                    T V42 = publicListActivity.f14365Y;
                    t.b(V42);
                    new C2388j(publicListActivity, ((Y) V42.b().get(i5)).a(), new a(this.f14369a, i5), LifecycleOwnerKt.getLifecycleScope(this.f14369a));
                }
            }
        }

        public void d(int i5) {
            if (this.f14369a.f14365Y != null) {
                T V4 = this.f14369a.f14365Y;
                t.b(V4);
                if (!V4.b().isEmpty()) {
                    T V42 = this.f14369a.f14365Y;
                    t.b(V42);
                    Object obj = V42.b().get(i5);
                    t.d(obj, "get(...)");
                    Y y4 = (Y) obj;
                    String g5 = y4.g();
                    if (g5 == null || g5.length() == 0) {
                        PublicListActivity publicListActivity = this.f14369a;
                        String string = publicListActivity.getString(R.string.error_open_app, new Object[]{y4.f()});
                        t.d(string, "getString(...)");
                        publicListActivity.a2(string);
                        return;
                    }
                    PackageManager packageManager = this.f14369a.getPackageManager();
                    String g6 = y4.g();
                    t.b(g6);
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(g6);
                    if (launchIntentForPackage != null) {
                        this.f14369a.startActivity(launchIntentForPackage);
                        return;
                    }
                    PublicListActivity publicListActivity2 = this.f14369a;
                    String string2 = publicListActivity2.getString(R.string.error_open_app, new Object[]{y4.f()});
                    t.d(string2, "getString(...)");
                    publicListActivity2.a2(string2);
                }
            }
        }

        public void e(long j5, C2660i iVar) {
            t.e(iVar, "category");
            if (UptodownApp.f13477F.Z()) {
                this.f14369a.i5(j5, iVar);
            }
        }

        public void f(int i5) {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f14373b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicListActivity f14374a;

            a(PublicListActivity publicListActivity) {
                this.f14374a = publicListActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    if (this.f14374a.f14365Y == null) {
                        this.f14374a.c5().f22374b.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((ArrayList) cVar.a()).size() == 0) {
                        this.f14374a.c5().f22377e.setVisibility(0);
                    } else {
                        this.f14374a.b5((ArrayList) cVar.a());
                    }
                    this.f14374a.c5().f22374b.setVisibility(8);
                } else if (o5 instanceof O.b) {
                    this.f14374a.c5().f22374b.setVisibility(8);
                    if (this.f14374a.f14365Y != null) {
                        T V4 = this.f14374a.f14365Y;
                        t.b(V4);
                        V4.f(false);
                        T V42 = this.f14374a.f14365Y;
                        t.b(V42);
                        if (V42.b().isEmpty()) {
                            this.f14374a.c5().f22377e.setVisibility(0);
                        }
                    }
                } else {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PublicListActivity publicListActivity, C2308e eVar) {
            super(2, eVar);
            this.f14373b = publicListActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14373b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14372a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f14373b.d5().g();
                a aVar = new a(this.f14373b);
                this.f14372a = 1;
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class d implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f14375a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2660i f14376b;

        d(PublicListActivity publicListActivity, C2660i iVar) {
            this.f14375a = publicListActivity;
            this.f14376b = iVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f14375a.isFinishing()) {
                Intent intent = new Intent(this.f14375a, AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                intent.putExtra("viewCategory", this.f14376b);
                PublicListActivity publicListActivity = this.f14375a;
                publicListActivity.startActivity(intent, UptodownApp.f13477F.a(publicListActivity));
            }
        }

        public void d(int i5) {
            PublicListActivity publicListActivity = this.f14375a;
            String string = publicListActivity.getString(R.string.app_detail_not_found);
            t.d(string, "getString(...)");
            publicListActivity.u0(string);
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14377a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f14377a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14377a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14378a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14378a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14378a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14379a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14380b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14379a = aVar;
            this.f14380b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14379a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14380b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PublicListActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14381a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicListActivity f14382b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14383c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(PublicListActivity publicListActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14382b = publicListActivity;
            this.f14383c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f14382b, this.f14383c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object obj2;
            C2316b.f();
            if (this.f14381a == 0) {
                u.b(obj);
                if (this.f14382b.f14365Y != null) {
                    T V4 = this.f14382b.f14365Y;
                    t.b(V4);
                    if (!(V4.b().isEmpty() || (str = this.f14383c) == null || str.length() == 0)) {
                        T V42 = this.f14382b.f14365Y;
                        t.b(V42);
                        ArrayList b5 = V42.b();
                        String str2 = this.f14383c;
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
                        T V43 = this.f14382b.f14365Y;
                        t.b(V43);
                        int R4 = C2250q.R(V43.b(), (Y) obj2);
                        if (R4 > -1) {
                            T V44 = this.f14382b.f14365Y;
                            t.b(V44);
                            V44.notifyItemChanged(R4);
                        } else {
                            this.f14382b.g5();
                        }
                        return J.f19942a;
                    }
                }
                this.f14382b.g5();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final G0 a5(PublicListActivity publicListActivity) {
        return G0.c(publicListActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void b5(ArrayList arrayList) {
        T t5 = this.f14365Y;
        if (t5 == null) {
            this.f14365Y = new T(arrayList, this, this.f14366Z);
            c5().f22375c.setAdapter(this.f14365Y);
            return;
        }
        t.b(t5);
        t5.a(arrayList);
        T t6 = this.f14365Y;
        if (t6 != null) {
            t6.f(false);
        }
    }

    /* access modifiers changed from: private */
    public final G0 c5() {
        return (G0) this.f14363W.getValue();
    }

    /* access modifiers changed from: private */
    public final C0847n4 d5() {
        return (C0847n4) this.f14364X.getValue();
    }

    private final void e5(V v5) {
        setContentView((View) c5().getRoot());
        c5().f22376d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        c5().f22376d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        c5().f22376d.setNavigationOnClickListener(new C0831l4(this));
        TextView textView = c5().f22378f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5().f22377e.setTypeface(aVar.x());
        c5().f22378f.setText(getString(R.string.user_recommended_apps, new Object[]{v5.k()}));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        c5().f22375c.setLayoutManager(linearLayoutManager);
        c5().f22375c.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        c5().f22375c.addItemDecoration(new B2.l(dimension, dimension));
        c5().f22375c.setItemAnimator(defaultItemAnimator);
        c5().f22375c.addOnScrollListener(new a(linearLayoutManager, this));
    }

    /* access modifiers changed from: private */
    public static final void f5(PublicListActivity publicListActivity, View view) {
        publicListActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void g5() {
        T t5 = this.f14365Y;
        if (t5 != null) {
            t5.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void h5(C2657f fVar, int i5) {
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
                aVar2.a(j02);
                T t5 = this.f14365Y;
                if (t5 != null) {
                    t5.notifyItemChanged(i5);
                }
            } else if (j02.f()) {
                File n5 = j02.n();
                if (n5 != null) {
                    UptodownApp.f13477F.W(n5, this, fVar.O());
                }
            } else if (j02.M()) {
                j02.T(this);
                T t6 = this.f14365Y;
                if (t6 != null) {
                    t6.notifyItemChanged(i5);
                }
            }
        } else {
            UptodownApp.f13477F.a0(fVar, this);
            T t7 = this.f14365Y;
            if (t7 != null) {
                t.b(t7);
                ((Y) t7.b().get(i5)).o(fVar.A());
                T t8 = this.f14365Y;
                if (t8 != null) {
                    t8.notifyItemChanged(i5);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void M4() {
    }

    public final void i5(long j5, C2660i iVar) {
        t.e(iVar, "floatingCategory");
        if (j5 > 0) {
            new C2388j(this, j5, new d(this, iVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        K2();
        J j6 = J.f19942a;
    }

    public final void j5(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new h(this, str, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        V v5;
        String j5;
        Bundle extras;
        super.onCreate(bundle);
        if (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user")) {
            v5 = null;
        } else {
            v5 = (V) extras.getParcelable("user");
        }
        if (!(v5 == null || (j5 = v5.j()) == null || j5.length() == 0)) {
            e5(v5);
            w h5 = d5().h();
            String j6 = v5.j();
            t.b(j6);
            h5.setValue(j6);
            d5().d(this);
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
    }
}
