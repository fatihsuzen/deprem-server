package com.uptodown.activities;

import O1.C5;
import O1.D5;
import O1.E5;
import O1.F5;
import O1.G5;
import O1.H5;
import O1.I5;
import O1.J5;
import O1.K5;
import O1.T2;
import R1.F;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.C2388j;
import h2.C2442v;
import h2.T0;
import java.util.ArrayList;
import k2.C2592b;
import k2.C2610u;
import k2.L;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import z2.C2962v;
import z2.O;
import z2.P;
import z3.C2973f;
import z3.D;

public final class SecurityActivity extends T2 {

    /* renamed from: W  reason: collision with root package name */
    private final C2223l f14543W = m.b(new F5(this));

    /* renamed from: X  reason: collision with root package name */
    private final C2223l f14544X = new ViewModelLazy(M.b(K5.class), new g(this), new f(this), new h((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public boolean f14545Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public F f14546Z;

    /* renamed from: m0  reason: collision with root package name */
    private j f14547m0 = new j(this);

    /* renamed from: n0  reason: collision with root package name */
    private final b f14548n0 = new b(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14549a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f14550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T0 f14551c;

        /* renamed from: com.uptodown.activities.SecurityActivity$a$a  reason: collision with other inner class name */
        static final class C0137a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f14552a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T0 f14553b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0137a(T0 t02, C2308e eVar) {
                super(2, eVar);
                this.f14553b = t02;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0137a(this.f14553b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f14552a == 0) {
                    u.b(obj);
                    this.f14553b.f22641c.setVisibility(0);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((C0137a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SecurityActivity securityActivity, T0 t02, C2308e eVar) {
            super(2, eVar);
            this.f14550b = securityActivity;
            this.f14551c = t02;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14550b, this.f14551c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14549a;
            if (i5 == 0) {
                u.b(obj);
                I0 c5 = C2865c0.c();
                C0137a aVar = new C0137a(this.f14551c, (C2308e) null);
                this.f14549a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f14550b.F4();
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class b implements C2592b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f14554a;

        b(SecurityActivity securityActivity) {
            this.f14554a = securityActivity;
        }

        public void a(int i5) {
            if (UptodownApp.f13477F.Z() && !this.f14554a.f14545Y) {
                F b5 = this.f14554a.f14546Z;
                t.b(b5);
                if (b5.b().get(i5) instanceof C2655d) {
                    F b52 = this.f14554a.f14546Z;
                    t.b(b52);
                    Object obj = b52.b().get(i5);
                    t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                    this.f14554a.h5((C2655d) obj);
                }
            }
        }

        public void b(int i5) {
            if (UptodownApp.f13477F.Z() && !this.f14554a.f14545Y) {
                F b5 = this.f14554a.f14546Z;
                t.b(b5);
                if (b5.b().get(i5) instanceof C2655d) {
                    F b52 = this.f14554a.f14546Z;
                    t.b(b52);
                    Object obj = b52.b().get(i5);
                    t.c(obj, "null cannot be cast to non-null type com.uptodown.models.App");
                    C2655d dVar = (C2655d) obj;
                    if (dVar.b() > 0) {
                        this.f14554a.H2(dVar.b());
                    }
                }
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14555a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f14556b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SecurityActivity f14557a;

            a(SecurityActivity securityActivity) {
                this.f14557a = securityActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14557a.m5().f22641c.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((ArrayList) cVar.a()).isEmpty()) {
                        this.f14557a.m5().f22642d.setVisibility(0);
                        this.f14557a.m5().f22643e.setVisibility(8);
                        this.f14557a.m5().f22646h.setText(this.f14557a.getString(R.string.uptodown_last_analysis, new Object[]{String.valueOf(new C2962v().o(com.uptodown.activities.preferences.a.f15150a.p(this.f14557a)))}));
                    } else {
                        this.f14557a.m5().f22643e.setVisibility(0);
                        this.f14557a.m5().f22642d.setVisibility(8);
                        this.f14557a.v5((ArrayList) cVar.a());
                    }
                    this.f14557a.m5().f22641c.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SecurityActivity securityActivity, C2308e eVar) {
            super(2, eVar);
            this.f14556b = securityActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14556b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14555a;
            if (i5 == 0) {
                u.b(obj);
                D b5 = this.f14556b.n5().b();
                a aVar = new a(this.f14556b);
                this.f14555a = 1;
                if (b5.collect(aVar, this) == f5) {
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
        final /* synthetic */ SecurityActivity f14558a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2655d f14559b;

        d(SecurityActivity securityActivity, C2655d dVar) {
            this.f14558a = securityActivity;
            this.f14559b = dVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (fVar.c()) {
                Intent intent = new Intent(this.f14558a.getApplicationContext(), OldVersionsActivity.class);
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f14559b);
                intent.putExtra("appInfo", fVar);
                SecurityActivity securityActivity = this.f14558a;
                securityActivity.startActivity(intent, UptodownApp.f13477F.a(securityActivity));
                return;
            }
            SecurityActivity securityActivity2 = this.f14558a;
            String string = securityActivity2.getString(R.string.rollback_not_available, new Object[]{fVar.N()});
            t.d(string, "getString(...)");
            securityActivity2.u0(string);
        }

        public void d(int i5) {
            SecurityActivity securityActivity = this.f14558a;
            String string = securityActivity.getString(R.string.rollback_not_available, new Object[]{this.f14559b.m()});
            t.d(string, "getString(...)");
            securityActivity.u0(string);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14560a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f14561b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(SecurityActivity securityActivity, C2308e eVar) {
            super(2, eVar);
            this.f14561b = securityActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14561b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14560a == 0) {
                u.b(obj);
                this.f14561b.m5().f22641c.setVisibility(8);
                this.f14561b.m5().f22646h.setText(this.f14561b.getString(R.string.uptodown_last_analysis, new Object[]{String.valueOf(new C2962v().o(com.uptodown.activities.preferences.a.f15150a.p(this.f14561b)))}));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14562a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14562a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14562a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14563a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14563a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14563a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14564a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14565b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14564a = aVar;
            this.f14565b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14564a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14565b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.SecurityActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14566a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f14567b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(SecurityActivity securityActivity, C2308e eVar) {
            super(2, eVar);
            this.f14567b = securityActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f14567b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14566a == 0) {
                u.b(obj);
                this.f14567b.u5();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class j implements L {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SecurityActivity f14568a;

        j(SecurityActivity securityActivity) {
            this.f14568a = securityActivity;
        }

        public void a() {
        }

        public void b() {
            this.f14568a.F4();
        }
    }

    /* access modifiers changed from: private */
    public static final T0 g5(SecurityActivity securityActivity) {
        return T0.c(securityActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void h5(C2655d dVar) {
        if (!isFinishing() && dVar != null) {
            C2442v c5 = C2442v.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            P2(new AlertDialog.Builder(this).setView(c5.getRoot()).create());
            TextView textView = c5.f23623d;
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            c5.f23623d.setText(dVar.m());
            c5.f23621b.setImageDrawable(P.f26510a.j(this, dVar.o()));
            if (dVar.o() == null || dVar.k() == null || dVar.b() <= 0) {
                c5.f23624e.setVisibility(8);
                c5.f23627h.setVisibility(8);
                c5.f23625f.setVisibility(8);
            } else {
                c5.f23624e.setTypeface(aVar.x());
                c5.f23624e.setOnClickListener(new G5(this, dVar));
                c5.f23627h.setTypeface(aVar.x());
                c5.f23627h.setOnClickListener(new H5(this, dVar));
                c5.f23625f.setTypeface(aVar.x());
                c5.f23625f.setOnClickListener(new I5(this, dVar));
            }
            if (!s.E(getPackageName(), dVar.o(), true)) {
                c5.f23626g.setTypeface(aVar.x());
                c5.f23626g.setOnClickListener(new J5(dVar, this));
            } else {
                c5.f23626g.setVisibility(8);
            }
            if (!isFinishing()) {
                AlertDialog p22 = p2();
                t.b(p22);
                Window window = p22.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p23 = p2();
                t.b(p23);
                p23.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void i5(SecurityActivity securityActivity, C2655d dVar, View view) {
        securityActivity.H2(dVar.b());
        AlertDialog p22 = securityActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void j5(SecurityActivity securityActivity, C2655d dVar, View view) {
        securityActivity.L2(dVar.r());
        AlertDialog p22 = securityActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void k5(SecurityActivity securityActivity, C2655d dVar, View view) {
        securityActivity.t5(dVar);
        AlertDialog p22 = securityActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void l5(C2655d dVar, SecurityActivity securityActivity, View view) {
        if (dVar.o() != null) {
            S1.j jVar = new S1.j(securityActivity);
            String o5 = dVar.o();
            t.b(o5);
            jVar.h(o5);
        }
        AlertDialog p22 = securityActivity.p2();
        t.b(p22);
        p22.dismiss();
    }

    /* access modifiers changed from: private */
    public final T0 m5() {
        return (T0) this.f14543W.getValue();
    }

    /* access modifiers changed from: private */
    public final K5 n5() {
        return (K5) this.f14544X.getValue();
    }

    private final void o5() {
        setContentView((View) m5().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            m5().f22644f.setNavigationIcon(drawable);
            m5().f22644f.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        T0 m5 = m5();
        m5.f22644f.setNavigationOnClickListener(new C5(this));
        TextView textView = m5.f22648j;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        m5.f22643e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        m5.f22643e.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) m5.f22643e.getItemAnimator();
        t.b(simpleItemAnimator);
        simpleItemAnimator.setSupportsChangeAnimations(false);
        m5.f22643e.addItemDecoration(new B2.l((int) getResources().getDimension(R.dimen.margin_m), 0));
        m5.f22641c.setOnClickListener(new D5());
        m5.f22647i.setTypeface(aVar.w());
        m5.f22646h.setTypeface(aVar.x());
        m5.f22645g.setTypeface(aVar.w());
        m5.f22645g.setOnClickListener(new E5(this, m5));
    }

    /* access modifiers changed from: private */
    public static final void p5(SecurityActivity securityActivity, View view) {
        securityActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void q5(View view) {
    }

    /* access modifiers changed from: private */
    public static final void r5(SecurityActivity securityActivity, T0 t02, View view) {
        if (UptodownApp.f13477F.Z()) {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(securityActivity), C2865c0.b(), (w3.O) null, new a(securityActivity, t02, (C2308e) null), 2, (Object) null);
        }
    }

    private final void s5() {
        n5().a(this);
    }

    private final void t5(C2655d dVar) {
        new C2388j(this, dVar.b(), new d(this, dVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void v5(ArrayList arrayList) {
        F f5 = this.f14546Z;
        if (f5 == null) {
            b bVar = this.f14548n0;
            j jVar = this.f14547m0;
            t.b(jVar);
            this.f14546Z = new F(arrayList, this, bVar, jVar);
            m5().f22643e.setAdapter(this.f14546Z);
            return;
        }
        t.b(f5);
        f5.c(arrayList);
    }

    /* access modifiers changed from: protected */
    public void M4() {
        s5();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o5();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i5 != 82) {
            return super.onKeyDown(i5, keyEvent);
        }
        m5().f22644f.showOverflowMenu();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        F4();
        z2.M.f26506a.h(this);
    }

    public final void u5() {
        View view = m5().f22641c;
        t.d(view, "loadingViewSecurity");
        if (view.getVisibility() == 8) {
            F4();
            s5();
        }
    }

    public final void w5() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new i(this, (C2308e) null), 2, (Object) null);
    }
}
