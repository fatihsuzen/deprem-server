package com.uptodown.activities;

import O1.I3;
import O1.J3;
import O1.K3;
import O1.L3;
import O1.M3;
import O1.N3;
import O1.O3;
import O1.P3;
import R1.C0988t;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.B;
import h2.C2432p0;
import k2.C2594d;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2644D;
import l2.C2657f;
import l2.C2668q;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;
import z3.w;

public final class OrganizationActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14288K = m.b(new P3(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14289L = new ViewModelLazy(M.b(B.class), new d(this), new c(this), new e((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public C0988t f14290M;

    public static final class a implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OrganizationActivity f14291a;

        a(OrganizationActivity organizationActivity) {
            this.f14291a = organizationActivity;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z()) {
                this.f14291a.H2(fVar.e());
            }
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OrganizationActivity f14293b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OrganizationActivity f14294a;

            a(OrganizationActivity organizationActivity) {
                this.f14294a = organizationActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (t.a(o5, O.a.f26507a)) {
                    if (this.f14294a.f14290M == null) {
                        this.f14294a.u3().f23431g.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (!((B.a) cVar.a()).a()) {
                        this.f14294a.w3(((B.a) cVar.a()).b());
                        this.f14294a.t3(((B.a) cVar.a()).b());
                    } else {
                        C0988t o32 = this.f14294a.f14290M;
                        t.b(o32);
                        o32.a(((B.a) cVar.a()).b().j());
                    }
                    this.f14294a.u3().f23431g.setVisibility(8);
                    this.f14294a.u3().f23435k.setVisibility(0);
                    C0988t o33 = this.f14294a.f14290M;
                    if (o33 != null) {
                        o33.c(false);
                    }
                } else if (t.a(o5, O.b.f26508a)) {
                    C0988t o34 = this.f14294a.f14290M;
                    if (o34 != null) {
                        o34.c(false);
                    }
                } else {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OrganizationActivity organizationActivity, C2308e eVar) {
            super(2, eVar);
            this.f14293b = organizationActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14293b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14292a;
            if (i5 == 0) {
                u.b(obj);
                D h5 = this.f14293b.v3().h();
                a aVar = new a(this.f14293b);
                this.f14292a = 1;
                if (h5.collect(aVar, this) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14295a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.f14295a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14295a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class d extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14296a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
            super(0);
            this.f14296a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14296a.getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14297a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14298b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14297a = aVar;
            this.f14298b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14297a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14298b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.OrganizationActivity.e.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14299a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2668q f14300b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OrganizationActivity f14301c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C2668q qVar, OrganizationActivity organizationActivity, C2308e eVar) {
            super(2, eVar);
            this.f14300b = qVar;
            this.f14301c = organizationActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f14300b, this.f14301c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String w4;
            C2316b.f();
            if (this.f14299a == 0) {
                u.b(obj);
                C2668q qVar = this.f14300b;
                if (!(qVar == null || (w4 = qVar.w()) == null || w4.length() == 0 || this.f14301c.f14290M == null)) {
                    C0988t o32 = this.f14301c.f14290M;
                    t.b(o32);
                    String w5 = this.f14300b.w();
                    t.b(w5);
                    RecyclerView recyclerView = this.f14301c.u3().f23434j;
                    t.d(recyclerView, "rvOrganization");
                    o32.d(w5, recyclerView);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(OrganizationActivity organizationActivity, C2644D d5, View view) {
        if (!organizationActivity.isFinishing()) {
            C2962v vVar = new C2962v();
            String l5 = d5.l();
            t.b(l5);
            C2962v.u(vVar, organizationActivity, l5, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void B3(C2644D d5, C2432p0 p0Var, View view) {
        String a5 = d5.a();
        if (a5 != null && a5.length() != 0) {
            if (p0Var.f23442r.getVisibility() == 0) {
                p0Var.f23439o.setText(R.string.read_less_desc_app_detail);
                p0Var.f23442r.setVisibility(8);
                p0Var.f23437m.setMaxLines(Integer.MAX_VALUE);
                p0Var.f23437m.setEllipsize((TextUtils.TruncateAt) null);
                return;
            }
            p0Var.f23439o.setText(R.string.read_more_desc_app_detail);
            p0Var.f23442r.setVisibility(0);
            p0Var.f23437m.setMaxLines(6);
            p0Var.f23437m.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    private final void C3() {
        setContentView((View) u3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        C2432p0 u32 = u3();
        if (drawable != null) {
            u32.f23436l.setNavigationIcon(drawable);
            u32.f23436l.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        u32.f23436l.setNavigationOnClickListener(new I3(this));
        u32.f23440p.setTypeface(k.f32g.w());
        u32.f23434j.setLayoutManager(new LinearLayoutManager(this, 1, false));
        u32.f23434j.setItemAnimator((RecyclerView.ItemAnimator) null);
        if (((CharSequence) v3().k().getValue()).length() > 0) {
            u32.f23440p.setText((CharSequence) v3().k().getValue());
        }
        u32.f23435k.getViewTreeObserver().addOnScrollChangedListener(new J3(this, u32));
    }

    /* access modifiers changed from: private */
    public static final void D3(OrganizationActivity organizationActivity, View view) {
        organizationActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void E3(OrganizationActivity organizationActivity, C2432p0 p0Var) {
        if (!organizationActivity.v3().i() && !organizationActivity.v3().g()) {
            ScrollView scrollView = p0Var.f23435k;
            if (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() - (p0Var.f23435k.getHeight() + p0Var.f23435k.getScrollY()) <= 0 && !organizationActivity.v3().i() && !organizationActivity.v3().g()) {
                C0988t tVar = organizationActivity.f14290M;
                if (tVar != null) {
                    tVar.c(true);
                }
                organizationActivity.G3();
            }
        }
    }

    private final void F3() {
        v3().e(this);
    }

    private final void G3() {
        v3().f(this);
    }

    /* access modifiers changed from: private */
    public static final C2432p0 s3(OrganizationActivity organizationActivity) {
        return C2432p0.c(organizationActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void t3(C2644D d5) {
        String k5;
        if (!(this.f14290M != null || (k5 = d5.k()) == null || k5.length() == 0)) {
            a aVar = new a(this);
            String k6 = d5.k();
            t.b(k6);
            this.f14290M = new C0988t(aVar, k6);
            u3().f23434j.setAdapter(this.f14290M);
        }
        C0988t tVar = this.f14290M;
        if (tVar != null) {
            tVar.b(d5.i(), d5.g(), d5.b(), d5.j());
        }
    }

    /* access modifiers changed from: private */
    public final C2432p0 u3() {
        return (C2432p0) this.f14288K.getValue();
    }

    /* access modifiers changed from: private */
    public final B v3() {
        return (B) this.f14289L.getValue();
    }

    /* access modifiers changed from: private */
    public final void w3(C2644D d5) {
        String a5;
        String e5;
        if (!v3().l()) {
            C2432p0 u32 = u3();
            u32.f23440p.setText(d5.k());
            String c5 = d5.c();
            if (c5 == null || c5.length() == 0 || (a5 = d5.a()) == null || a5.length() == 0 || (e5 = d5.e()) == null || e5.length() == 0) {
                u3().f23433i.setVisibility(8);
            } else {
                String c6 = d5.c();
                if (!(c6 == null || c6.length() == 0)) {
                    s.h().l(d5.d()).n(UptodownApp.f13477F.f0(this)).i(u32.f23426b);
                }
                String e6 = d5.e();
                if (!(e6 == null || e6.length() == 0)) {
                    s.h().l(d5.f()).n(UptodownApp.f13477F.g0(this)).i(u32.f23428d);
                }
                TextView textView = u32.f23438n;
                k.a aVar = k.f32g;
                textView.setTypeface(aVar.w());
                u32.f23438n.setText(d5.k());
                u32.f23441q.setTypeface(aVar.w());
                u32.f23441q.setOnClickListener(new K3(d5, this));
                String m5 = d5.m();
                if (!(m5 == null || m5.length() == 0)) {
                    u32.f23430f.setVisibility(0);
                    u32.f23430f.setOnClickListener(new L3(this, d5));
                }
                String h5 = d5.h();
                if (!(h5 == null || h5.length() == 0)) {
                    u32.f23427c.setVisibility(0);
                    u32.f23427c.setOnClickListener(new M3(this, d5));
                }
                String l5 = d5.l();
                if (!(l5 == null || l5.length() == 0)) {
                    u32.f23429e.setVisibility(0);
                    u32.f23429e.setOnClickListener(new N3(this, d5));
                }
                u32.f23437m.setTypeface(aVar.x());
                u32.f23437m.setText(d5.a());
                u32.f23439o.setTypeface(aVar.w());
                u32.f23439o.setOnClickListener(new O3(d5, u32));
            }
            v3().o(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void x3(C2644D d5, OrganizationActivity organizationActivity, View view) {
        if (d5.n() != null) {
            C2962v vVar = new C2962v();
            String n5 = d5.n();
            t.b(n5);
            vVar.t(organizationActivity, n5, d5.k());
        }
    }

    /* access modifiers changed from: private */
    public static final void y3(OrganizationActivity organizationActivity, C2644D d5, View view) {
        if (!organizationActivity.isFinishing()) {
            C2962v vVar = new C2962v();
            String m5 = d5.m();
            t.b(m5);
            C2962v.u(vVar, organizationActivity, m5, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void z3(OrganizationActivity organizationActivity, C2644D d5, View view) {
        if (!organizationActivity.isFinishing()) {
            C2962v vVar = new C2962v();
            String h5 = d5.h();
            t.b(h5);
            C2962v.u(vVar, organizationActivity, h5, (String) null, 4, (Object) null);
        }
    }

    public final void H3(C2668q qVar) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new f(qVar, this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("organizationID")) {
                v3().j().setValue(Long.valueOf(extras.getLong("organizationID")));
            }
            if (extras.containsKey("organizationName")) {
                w k5 = v3().k();
                String string = extras.getString("organizationName");
                t.b(string);
                k5.setValue(string);
            }
        }
        C3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        F3();
    }
}
