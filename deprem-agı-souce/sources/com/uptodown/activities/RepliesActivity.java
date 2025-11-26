package com.uptodown.activities;

import D2.n;
import O1.C0741a5;
import O1.K4;
import O1.L4;
import O1.M4;
import O1.N4;
import O1.O4;
import O1.P4;
import O1.Q4;
import O1.R4;
import O1.S4;
import O1.T4;
import O1.U4;
import O1.V4;
import O1.W4;
import O1.X4;
import O1.Y4;
import O1.Z4;
import R1.A;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
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
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.K;
import com.uptodown.activities.preferences.a;
import com.uptodown.util.views.UsernameTextView;
import g2.C2391m;
import h2.L0;
import java.util.ArrayList;
import k2.C2588E;
import k2.N;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2651K;
import l2.O;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;
import z3.w;

public final class RepliesActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14450K = m.b(new K4(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14451L = new ViewModelLazy(M.b(K.class), new i(this), new h(this), new j((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public A f14452M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public final g f14453N = new g(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14454a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14455b;

        /* renamed from: com.uptodown.activities.RepliesActivity$a$a  reason: collision with other inner class name */
        static final class C0135a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f14456a;

            C0135a(RepliesActivity repliesActivity) {
                this.f14456a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    if (this.f14456a.f14452M == null) {
                        this.f14456a.E3().f22472h.setVisibility(0);
                    }
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (((K.b) cVar.a()).a()) {
                        A w32 = this.f14456a.f14452M;
                        if (w32 != null) {
                            w32.a(((K.b) cVar.a()).b());
                        }
                    } else if (!((K.b) cVar.a()).b().isEmpty()) {
                        RepliesActivity repliesActivity = this.f14456a;
                        ArrayList b5 = ((K.b) cVar.a()).b();
                        Context applicationContext = this.f14456a.getApplicationContext();
                        t.d(applicationContext, "getApplicationContext(...)");
                        repliesActivity.f14452M = new A(b5, applicationContext, this.f14456a.f14453N);
                        this.f14456a.E3().f22480p.setAdapter(this.f14456a.f14452M);
                    } else {
                        this.f14456a.E3().f22485u.setVisibility(0);
                        this.f14456a.E3().f22480p.setVisibility(8);
                    }
                    this.f14456a.E3().f22474j.setVisibility(0);
                    this.f14456a.E3().f22472h.setVisibility(8);
                    A w33 = this.f14456a.f14452M;
                    if (w33 != null) {
                        w33.c(false);
                    }
                } else if (o5 instanceof O.b) {
                    A w34 = this.f14456a.f14452M;
                    if (w34 != null) {
                        w34.c(false);
                    }
                } else {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(RepliesActivity repliesActivity, C2308e eVar) {
            super(2, eVar);
            this.f14455b = repliesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14455b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14454a;
            if (i5 == 0) {
                u.b(obj);
                D p5 = this.f14455b.G3().p();
                C0135a aVar = new C0135a(this.f14455b);
                this.f14454a = 1;
                if (p5.collect(aVar, this) == f5) {
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
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14457a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14458b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f14459a;

            a(RepliesActivity repliesActivity) {
                this.f14459a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((O.c) cVar.a()).b() == 1) {
                            this.f14459a.E3().f22475k.f22514r.setText(String.valueOf(((O.c) cVar.a()).a().h()));
                        } else {
                            RepliesActivity repliesActivity = this.f14459a;
                            String string = repliesActivity.getString(R.string.error_generico);
                            t.d(string, "getString(...)");
                            repliesActivity.u0(string);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RepliesActivity repliesActivity, C2308e eVar) {
            super(2, eVar);
            this.f14458b = repliesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14458b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14457a;
            if (i5 == 0) {
                u.b(obj);
                D s5 = this.f14458b.G3().s();
                a aVar = new a(this.f14458b);
                this.f14457a = 1;
                if (s5.collect(aVar, this) == f5) {
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

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14460a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14461b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f14462a;

            a(RepliesActivity repliesActivity) {
                this.f14462a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((K.c) cVar.a()).a() == 1) {
                            A w32 = this.f14462a.f14452M;
                            if (w32 != null) {
                                w32.d(((K.c) cVar.a()).b());
                            }
                        } else {
                            RepliesActivity repliesActivity = this.f14462a;
                            String string = repliesActivity.getString(R.string.error_generico);
                            t.d(string, "getString(...)");
                            repliesActivity.u0(string);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RepliesActivity repliesActivity, C2308e eVar) {
            super(2, eVar);
            this.f14461b = repliesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14461b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14460a;
            if (i5 == 0) {
                u.b(obj);
                D r5 = this.f14461b.G3().r();
                a aVar = new a(this.f14461b);
                this.f14460a = 1;
                if (r5.collect(aVar, this) == f5) {
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

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14463a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14464b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f14465a;

            a(RepliesActivity repliesActivity) {
                this.f14465a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((K.d) cVar.a()).c() == 1) {
                            l2.O o6 = new l2.O();
                            V h5 = V.f24870q.h(this.f14465a);
                            if (h5 != null) {
                                o6.D(h5.k());
                                o6.u(h5.c());
                            }
                            o6.z(((K.d) cVar.a()).d());
                            this.f14465a.E3().f22466b.setText("");
                            RepliesActivity repliesActivity = this.f14465a;
                            String string = repliesActivity.getString(R.string.review_sended);
                            t.d(string, "getString(...)");
                            repliesActivity.u0(string);
                        } else if (((K.d) cVar.a()).b() == 401) {
                            this.f14465a.Q3();
                        } else if (((K.d) cVar.a()).b() == 403) {
                            RepliesActivity repliesActivity2 = this.f14465a;
                            String string2 = repliesActivity2.getString(R.string.email_validation_msg);
                            t.d(string2, "getString(...)");
                            repliesActivity2.u0(string2);
                        } else {
                            String a5 = ((K.d) cVar.a()).a();
                            if (!(a5 == null || a5.length() == 0)) {
                                this.f14465a.u0(((K.d) cVar.a()).a());
                            }
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(RepliesActivity repliesActivity, C2308e eVar) {
            super(2, eVar);
            this.f14464b = repliesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14464b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14463a;
            if (i5 == 0) {
                u.b(obj);
                D w4 = this.f14464b.G3().w();
                a aVar = new a(this.f14464b);
                this.f14463a = 1;
                if (w4.collect(aVar, this) == f5) {
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14467b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RepliesActivity f14468a;

            a(RepliesActivity repliesActivity) {
                this.f14468a = repliesActivity;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                C2651K k5;
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((K.a) cVar.a()).b() != -1) {
                            if (this.f14468a.f14452M != null) {
                                A w32 = this.f14468a.f14452M;
                                t.b(w32);
                                k5 = (C2651K) w32.b().get(((K.a) cVar.a()).b());
                            } else {
                                k5 = null;
                            }
                            if (k5 != null) {
                                k5.n(((K.a) cVar.a()).a());
                                A w33 = this.f14468a.f14452M;
                                if (w33 != null) {
                                    w33.d(k5);
                                }
                            }
                        } else if (this.f14468a.G3().v().getValue() != null) {
                            l2.O o6 = (l2.O) this.f14468a.G3().v().getValue();
                            if (o6 != null) {
                                o6.v(((K.a) cVar.a()).a());
                            }
                            RepliesActivity repliesActivity = this.f14468a;
                            Object value = repliesActivity.G3().v().getValue();
                            t.b(value);
                            repliesActivity.U3((l2.O) value);
                        }
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(RepliesActivity repliesActivity, C2308e eVar) {
            super(2, eVar);
            this.f14467b = repliesActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14467b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14466a;
            if (i5 == 0) {
                u.b(obj);
                D q5 = this.f14467b.G3().q();
                a aVar = new a(this.f14467b);
                this.f14466a = 1;
                if (q5.collect(aVar, this) == f5) {
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

    public static final class f implements N {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14469a;

        f(RepliesActivity repliesActivity) {
            this.f14469a = repliesActivity;
        }

        public void a() {
        }

        public void b(V v5) {
            t.e(v5, "user");
            Intent intent = new Intent(this.f14469a, PublicProfileActivity.class);
            intent.putExtra("user", v5);
            RepliesActivity repliesActivity = this.f14469a;
            repliesActivity.startActivity(intent, UptodownApp.f13477F.a(repliesActivity));
        }
    }

    public static final class g implements C2588E {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RepliesActivity f14470a;

        g(RepliesActivity repliesActivity) {
            this.f14470a = repliesActivity;
        }

        public void a(int i5) {
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (V.f24870q.h(this.f14470a) != null) {
                if (i5 == -1 && this.f14470a.G3().v().getValue() != null) {
                    Object value = this.f14470a.G3().v().getValue();
                    t.b(value);
                    String m5 = ((l2.O) value).m();
                    if (!(m5 == null || m5.length() == 0)) {
                        K G32 = this.f14470a.G3();
                        RepliesActivity repliesActivity = this.f14470a;
                        Object value2 = repliesActivity.G3().v().getValue();
                        t.b(value2);
                        int f5 = ((l2.O) value2).f();
                        Object value3 = this.f14470a.G3().v().getValue();
                        t.b(value3);
                        String m6 = ((l2.O) value3).m();
                        t.b(m6);
                        G32.j(repliesActivity, f5, m6, -1);
                        return;
                    }
                }
                if (this.f14470a.f14452M != null) {
                    K G33 = this.f14470a.G3();
                    RepliesActivity repliesActivity2 = this.f14470a;
                    A w32 = repliesActivity2.f14452M;
                    t.b(w32);
                    int c5 = ((C2651K) w32.b().get(i5)).c();
                    A w33 = this.f14470a.f14452M;
                    t.b(w33);
                    String h5 = ((C2651K) w33.b().get(i5)).h();
                    t.b(h5);
                    G33.j(repliesActivity2, c5, h5, i5);
                    return;
                }
                return;
            }
            this.f14470a.S3();
        }

        public void c() {
            this.f14470a.d3();
        }

        public void d(C2651K k5) {
            t.e(k5, "reply");
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (!C2651K.f24779m.c(k5.d())) {
                this.f14470a.G3().z(this.f14470a, k5);
                return;
            }
            RepliesActivity repliesActivity = this.f14470a;
            String string = repliesActivity.getString(R.string.review_already_liked);
            t.d(string, "getString(...)");
            repliesActivity.u0(string);
        }

        public void e(C2651K k5) {
            t.e(k5, "reply");
            this.f14470a.T3(k5.h());
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14471a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.f14471a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14471a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class i extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14472a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.f14472a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14472a.getViewModelStore();
        }
    }

    public static final class j extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14473a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14474b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14473a = aVar;
            this.f14474b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14473a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14474b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.RepliesActivity.j.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final L0 D3(RepliesActivity repliesActivity) {
        return L0.c(repliesActivity.getLayoutInflater());
    }

    private final void F3(long j5) {
        G3().g(this, j5);
    }

    private final void H3() {
        Object systemService = getSystemService("input_method");
        t.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(E3().f22466b.getWindowToken(), 0);
    }

    private final void I3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            E3().f22482r.setNavigationIcon(drawable);
            E3().f22482r.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        E3().f22482r.setNavigationOnClickListener(new L4(this));
        TextView textView = E3().f22486v;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        E3().f22483s.setTypeface(aVar.x());
        E3().f22484t.setTypeface(aVar.w());
        E3().f22484t.setText((CharSequence) G3().n().getValue());
        s.h().l((String) G3().l().getValue()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this)).i(E3().f22467c);
        E3().f22470f.setOnClickListener(new M4(this));
        E3().f22471g.setVisibility(0);
        E3().f22471g.setOnClickListener(new N4(this));
        E3().f22485u.setTypeface(aVar.x());
        e4();
        E3().f22468d.setOnClickListener(new O4(this));
        E3().f22473i.setOnClickListener(new P4(this));
        E3().f22466b.setTypeface(aVar.x());
        E3().f22466b.setOnEditorActionListener(new Q4(this));
        f4();
        E3().f22480p.setLayoutManager(new LinearLayoutManager(this, 1, false));
        E3().f22480p.setItemAnimator(new DefaultItemAnimator());
        E3().f22474j.getViewTreeObserver().addOnScrollChangedListener(new R4(this));
        if (G3().v().getValue() != null) {
            Object value = G3().v().getValue();
            t.b(value);
            F3(((l2.O) value).g());
            Object value2 = G3().v().getValue();
            t.b(value2);
            U3((l2.O) value2);
            return;
        }
        finish();
    }

    /* access modifiers changed from: private */
    public static final void J3(RepliesActivity repliesActivity, View view) {
        repliesActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void K3(RepliesActivity repliesActivity, View view) {
        if (repliesActivity.G3().v().getValue() != null) {
            Object value = repliesActivity.G3().v().getValue();
            t.b(value);
            repliesActivity.H2(((l2.O) value).b());
        }
    }

    /* access modifiers changed from: private */
    public static final void L3(RepliesActivity repliesActivity, View view) {
        repliesActivity.I2(((Number) repliesActivity.G3().m().getValue()).longValue(), (String) repliesActivity.G3().o().getValue());
    }

    /* access modifiers changed from: private */
    public static final void M3(RepliesActivity repliesActivity, View view) {
        repliesActivity.R3();
    }

    /* access modifiers changed from: private */
    public static final void N3(RepliesActivity repliesActivity, View view) {
        repliesActivity.S3();
    }

    /* access modifiers changed from: private */
    public static final boolean O3(RepliesActivity repliesActivity, TextView textView, int i5, KeyEvent keyEvent) {
        if (i5 != 6) {
            return false;
        }
        repliesActivity.R3();
        return true;
    }

    /* access modifiers changed from: private */
    public static final void P3(RepliesActivity repliesActivity) {
        if (!repliesActivity.G3().t() && !repliesActivity.G3().k() && repliesActivity.E3().f22480p.getLayoutManager() != null) {
            RecyclerView.LayoutManager layoutManager = repliesActivity.E3().f22480p.getLayoutManager();
            t.b(layoutManager);
            int childCount = layoutManager.getChildCount();
            RecyclerView.LayoutManager layoutManager2 = repliesActivity.E3().f22480p.getLayoutManager();
            t.b(layoutManager2);
            int itemCount = layoutManager2.getItemCount();
            RecyclerView.LayoutManager layoutManager3 = repliesActivity.E3().f22480p.getLayoutManager();
            t.b(layoutManager3);
            if (childCount + ((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition() >= itemCount - 10) {
                A a5 = repliesActivity.f14452M;
                if (a5 != null) {
                    a5.c(true);
                }
                K G32 = repliesActivity.G3();
                Object value = repliesActivity.G3().v().getValue();
                t.b(value);
                long g5 = ((l2.O) value).g();
                A a6 = repliesActivity.f14452M;
                t.b(a6);
                G32.h(repliesActivity, g5, a6.getItemCount());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Q3() {
        V.f24870q.b(this);
        S3();
    }

    private final void R3() {
        H3();
        if (E3().f22466b.getText() == null || t3.s.W0(E3().f22466b.getText().toString()).toString().length() <= 0) {
            if (t3.s.W0(E3().f22466b.getText().toString()).toString().length() == 0) {
                String string = getString(R.string.empty_answer_error);
                t.d(string, "getString(...)");
                u0(string);
            }
        } else if (!l2.O.f24814p.e(this, E3().f22466b.getText().toString())) {
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            Context applicationContext = getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            aVar.R0(applicationContext, E3().f22466b.getText().toString());
            Context applicationContext2 = getApplicationContext();
            t.d(applicationContext2, "getApplicationContext(...)");
            aVar.S0(applicationContext2, String.valueOf(System.currentTimeMillis()));
            K G32 = G3();
            String obj = E3().f22466b.getText().toString();
            Object value = G3().v().getValue();
            t.b(value);
            G32.B(this, obj, ((l2.O) value).g());
        } else {
            E3().f22466b.setText("");
        }
    }

    /* access modifiers changed from: private */
    public final void S3() {
        if (!isFinishing()) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class), UptodownApp.f13477F.a(this));
        }
    }

    /* access modifiers changed from: private */
    public final void T3(String str) {
        if (str != null && str.length() != 0) {
            new C2391m(this, LifecycleOwnerKt.getLifecycleScope(this)).c(str, new f(this));
        }
    }

    /* access modifiers changed from: private */
    public final void U3(l2.O o5) {
        l2.O o6 = o5;
        if (o6.p()) {
            if (o6.a() > 0) {
                E3().f22476l.f22572u.setTypeface(k.f32g.x());
                if (o6.a() == 1) {
                    E3().f22476l.f22572u.setText(getString(R.string.replies_counter_single));
                } else {
                    E3().f22476l.f22572u.setText(getString(R.string.replies_counter_multiple, new Object[]{String.valueOf(o6.a())}));
                }
            } else {
                E3().f22476l.f22564m.setVisibility(8);
            }
            E3().f22476l.f22563l.setOnClickListener(new S4(this, o6));
            if (l2.O.f24814p.d(o6.g())) {
                E3().f22476l.f22556e.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_heart_red));
            }
            TextView textView = E3().f22476l.f22570s;
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.x());
            E3().f22476l.f22570s.setText(String.valueOf(o6.h()));
            E3().f22476l.f22557f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            E3().f22476l.f22558g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            E3().f22476l.f22559h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            E3().f22476l.f22560i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            E3().f22476l.f22561j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
            if (o6.i() >= 2) {
                E3().f22476l.f22558g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            if (o6.i() >= 3) {
                E3().f22476l.f22559h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            if (o6.i() >= 4) {
                E3().f22476l.f22560i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            if (o6.i() == 5) {
                E3().f22476l.f22561j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
            }
            V.b bVar = V.f24870q;
            V h5 = bVar.h(this);
            if (h5 == null || !t.a(h5.j(), o6.m())) {
                E3().f22476l.f22555d.setVisibility(0);
                if (o6.f() == 1) {
                    E3().f22476l.f22555d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_following));
                } else {
                    E3().f22476l.f22555d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_follow));
                }
            } else {
                E3().f22476l.f22555d.setVisibility(8);
            }
            E3().f22476l.f22555d.setOnClickListener(new T4(h5, this));
            E3().f22476l.f22574w.setTypeface(aVar.w());
            E3().f22476l.f22569r.setTypeface(aVar.x());
            E3().f22476l.f22568q.setTypeface(aVar.x());
            E3().f22476l.f22571t.setTypeface(aVar.x());
            CharSequence charSequence = (CharSequence) G3().x().getValue();
            if (charSequence == null || charSequence.length() == 0) {
                String d5 = bVar.d(o6.e());
                if (d5 == null || d5.length() == 0) {
                    s.h().j(R.drawable.vector_user_default).n(UptodownApp.f13477F.g0(this)).i(E3().f22476l.f22554c);
                } else {
                    s.h().l(bVar.d(o6.e())).n(UptodownApp.f13477F.g0(this)).i(E3().f22476l.f22554c);
                }
            } else {
                s.h().l(bVar.d((String) G3().x().getValue())).n(UptodownApp.f13477F.g0(this)).i(E3().f22476l.f22554c);
            }
            String n5 = o6.n();
            if (n5 == null || n5.length() == 0) {
                CharSequence charSequence2 = (CharSequence) G3().y().getValue();
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    E3().f22476l.f22574w.setText((CharSequence) G3().y().getValue());
                    UsernameTextView.a aVar2 = UsernameTextView.f21329k;
                    UsernameTextView usernameTextView = E3().f22476l.f22574w;
                    t.d(usernameTextView, "tvUsernameReview");
                    aVar2.a(usernameTextView, o6.p(), o6.o());
                }
            } else {
                E3().f22476l.f22574w.setText(o6.n());
                UsernameTextView.a aVar3 = UsernameTextView.f21329k;
                UsernameTextView usernameTextView2 = E3().f22476l.f22574w;
                t.d(usernameTextView2, "tvUsernameReview");
                aVar3.a(usernameTextView2, o6.p(), o6.o());
            }
            String l5 = o6.l();
            if (!(l5 == null || l5.length() == 0)) {
                E3().f22476l.f22569r.setText(o6.l());
            }
            String j5 = o6.j();
            if (j5 == null || j5.length() == 0) {
                E3().f22476l.f22568q.setVisibility(8);
            } else {
                E3().f22476l.f22568q.setMaxLines(Integer.MAX_VALUE);
                TextView textView2 = E3().f22476l.f22568q;
                Spanned k5 = o6.k();
                textView2.setText(k5 != null ? t3.s.W0(k5) : null);
                if (o6.a() > 1) {
                    E3().f22476l.f22571t.setText(String.valueOf(o6.a()));
                }
            }
            if (o6.d() == 1) {
                E3().f22476l.f22553b.setVisibility(0);
            }
            String m5 = o6.m();
            if (!(m5 == null || m5.length() == 0)) {
                E3().f22476l.f22574w.setOnClickListener(new U4(this, o6));
                E3().f22476l.f22554c.setOnClickListener(new V4(this, o6));
            }
            E3().f22476l.f22562k.setOnClickListener(new W4(this));
            E3().f22476l.f22562k.setVisibility(0);
            C2962v.a aVar4 = C2962v.f26557a;
            ImageView imageView = E3().f22476l.f22554c;
            t.d(imageView, "ivAvatarReview");
            aVar4.b(imageView);
            E3().f22476l.getRoot().setVisibility(0);
            E3().f22475k.getRoot().setVisibility(8);
            return;
        }
        if (o6.a() > 0) {
            E3().f22475k.f22516t.setTypeface(k.f32g.x());
            if (o6.a() == 1) {
                E3().f22475k.f22516t.setText(getString(R.string.replies_counter_single));
            } else {
                E3().f22475k.f22516t.setText(getString(R.string.replies_counter_multiple, new Object[]{String.valueOf(o6.a())}));
            }
        } else {
            E3().f22475k.f22509m.setVisibility(8);
        }
        E3().f22475k.f22509m.setVisibility(8);
        E3().f22475k.f22508l.setOnClickListener(new X4(this, o6));
        if (l2.O.f24814p.d(o6.g())) {
            E3().f22475k.f22501e.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_heart_red));
        }
        TextView textView3 = E3().f22475k.f22514r;
        k.a aVar5 = k.f32g;
        textView3.setTypeface(aVar5.x());
        E3().f22475k.f22514r.setText(String.valueOf(o6.h()));
        E3().f22475k.f22502f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        E3().f22475k.f22503g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        E3().f22475k.f22504h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        E3().f22475k.f22505i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        E3().f22475k.f22506j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
        if (o6.i() >= 2) {
            E3().f22475k.f22503g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        if (o6.i() >= 3) {
            E3().f22475k.f22504h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        if (o6.i() >= 4) {
            E3().f22475k.f22505i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        if (o6.i() == 5) {
            E3().f22475k.f22506j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
        }
        V.b bVar2 = V.f24870q;
        V h6 = bVar2.h(this);
        if (h6 == null || !t.a(h6.j(), o6.m())) {
            E3().f22475k.f22500d.setVisibility(0);
            if (o6.f() == 1) {
                E3().f22475k.f22500d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_following));
            } else {
                E3().f22475k.f22500d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_follow));
            }
        } else {
            E3().f22475k.f22500d.setVisibility(8);
        }
        E3().f22475k.f22500d.setOnClickListener(new Y4(h6, this));
        E3().f22475k.f22518v.setTypeface(aVar5.w());
        E3().f22475k.f22513q.setTypeface(aVar5.x());
        E3().f22475k.f22512p.setTypeface(aVar5.x());
        E3().f22475k.f22515s.setTypeface(aVar5.x());
        CharSequence charSequence3 = (CharSequence) G3().x().getValue();
        if (charSequence3 == null || charSequence3.length() == 0) {
            String d6 = bVar2.d(o6.e());
            if (d6 == null || d6.length() == 0) {
                s.h().j(R.drawable.vector_user_default).n(UptodownApp.f13477F.g0(this)).i(E3().f22475k.f22499c);
            } else {
                s.h().l(bVar2.d(o6.e())).n(UptodownApp.f13477F.g0(this)).i(E3().f22475k.f22499c);
            }
        } else {
            s.h().l(bVar2.d((String) G3().x().getValue())).n(UptodownApp.f13477F.g0(this)).i(E3().f22475k.f22499c);
        }
        String n6 = o6.n();
        if (n6 == null || n6.length() == 0) {
            CharSequence charSequence4 = (CharSequence) G3().y().getValue();
            if (!(charSequence4 == null || charSequence4.length() == 0)) {
                E3().f22475k.f22518v.setText((CharSequence) G3().y().getValue());
                UsernameTextView.a aVar6 = UsernameTextView.f21329k;
                UsernameTextView usernameTextView3 = E3().f22475k.f22518v;
                t.d(usernameTextView3, "tvUsernameReview");
                aVar6.a(usernameTextView3, o6.p(), o6.o());
            }
        } else {
            E3().f22475k.f22518v.setText(o6.n());
            UsernameTextView.a aVar7 = UsernameTextView.f21329k;
            UsernameTextView usernameTextView4 = E3().f22475k.f22518v;
            t.d(usernameTextView4, "tvUsernameReview");
            aVar7.a(usernameTextView4, o6.p(), o6.o());
        }
        String l6 = o6.l();
        if (!(l6 == null || l6.length() == 0)) {
            E3().f22475k.f22513q.setText(o6.l());
        }
        String j6 = o6.j();
        if (j6 == null || j6.length() == 0) {
            E3().f22475k.f22512p.setVisibility(8);
        } else {
            E3().f22475k.f22512p.setMaxLines(Integer.MAX_VALUE);
            TextView textView4 = E3().f22475k.f22512p;
            Spanned k6 = o6.k();
            textView4.setText(k6 != null ? t3.s.W0(k6) : null);
            if (o6.a() > 0) {
                E3().f22475k.f22515s.setText(String.valueOf(o6.a()));
            }
        }
        if (o6.d() == 1) {
            E3().f22475k.f22498b.setVisibility(0);
        }
        String m6 = o6.m();
        if (m6 != null && m6.length() != 0) {
            E3().f22475k.f22518v.setOnClickListener(new Z4(this, o6));
            E3().f22475k.f22499c.setOnClickListener(new C0741a5(this, o6));
        }
    }

    /* access modifiers changed from: private */
    public static final void V3(RepliesActivity repliesActivity, l2.O o5, View view) {
        if (UptodownApp.f13477F.Z()) {
            n nVar = new n(repliesActivity);
            ImageView imageView = repliesActivity.E3().f22476l.f22556e;
            t.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!l2.O.f24814p.d(o5.g())) {
                repliesActivity.G3().A(repliesActivity, o5);
                repliesActivity.E3().f22476l.f22570s.setText(String.valueOf(o5.h() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void W3(V v5, RepliesActivity repliesActivity, View view) {
        if (v5 != null) {
            repliesActivity.f14453N.a(-1);
        } else {
            repliesActivity.S3();
        }
    }

    /* access modifiers changed from: private */
    public static final void X3(RepliesActivity repliesActivity, l2.O o5, View view) {
        repliesActivity.T3(o5.m());
    }

    /* access modifiers changed from: private */
    public static final void Y3(RepliesActivity repliesActivity, l2.O o5, View view) {
        repliesActivity.T3(o5.m());
    }

    /* access modifiers changed from: private */
    public static final void Z3(RepliesActivity repliesActivity, View view) {
        repliesActivity.d3();
    }

    /* access modifiers changed from: private */
    public static final void a4(RepliesActivity repliesActivity, l2.O o5, View view) {
        if (UptodownApp.f13477F.Z()) {
            n nVar = new n(repliesActivity);
            ImageView imageView = repliesActivity.E3().f22475k.f22501e;
            t.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!l2.O.f24814p.d(o5.g())) {
                repliesActivity.G3().A(repliesActivity, o5);
                repliesActivity.E3().f22475k.f22514r.setText(String.valueOf(o5.h() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(V v5, RepliesActivity repliesActivity, View view) {
        if (v5 != null) {
            repliesActivity.f14453N.a(-1);
        } else {
            repliesActivity.S3();
        }
    }

    /* access modifiers changed from: private */
    public static final void c4(RepliesActivity repliesActivity, l2.O o5, View view) {
        repliesActivity.T3(o5.m());
    }

    /* access modifiers changed from: private */
    public static final void d4(RepliesActivity repliesActivity, l2.O o5, View view) {
        repliesActivity.T3(o5.m());
    }

    private final void e4() {
        String str;
        V.b bVar = V.f24870q;
        V h5 = bVar.h(this);
        if (h5 != null) {
            str = h5.a();
        } else {
            str = null;
        }
        if (str != null) {
            s.h().l(bVar.d(h5.a())).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this)).i(E3().f22469e);
            if (h5.q()) {
                C2962v.a aVar = C2962v.f26557a;
                ImageView imageView = E3().f22469e;
                t.d(imageView, "ivUserAvatarReply");
                aVar.c(imageView);
                return;
            }
            return;
        }
        E3().f22469e.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_user_default));
    }

    private final void f4() {
        String str;
        V h5 = V.f24870q.h(this);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str != null) {
            String j5 = h5.j();
            t.b(j5);
            if (j5.length() > 0) {
                E3().f22473i.setVisibility(8);
                return;
            }
        }
        E3().f22473i.setVisibility(0);
    }

    public final L0 E3() {
        return (L0) this.f14450K.getValue();
    }

    public final K G3() {
        return (K) this.f14451L.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        setContentView((View) E3().getRoot());
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            if (extras.containsKey("review")) {
                w v5 = G3().v();
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("review", l2.O.class);
                } else {
                    parcelable = extras.getParcelable("review");
                }
                v5.setValue(parcelable);
            }
            if (extras.containsKey("appName")) {
                G3().n().setValue(extras.getString("appName"));
            }
            if (extras.containsKey("username")) {
                G3().y().setValue(extras.getString("username"));
            }
            if (extras.containsKey("appIconUrl")) {
                G3().l().setValue(extras.getString("appIconUrl"));
            }
            if (extras.containsKey("userAvatarUrl")) {
                G3().x().setValue(extras.getString("userAvatarUrl"));
            }
            if (extras.containsKey("appId")) {
                G3().m().setValue(Long.valueOf(extras.getLong("appId")));
            }
            if (extras.containsKey("appUrl")) {
                G3().o().setValue(extras.getString("appUrl"));
            }
        }
        I3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new a(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused4 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused5 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new e(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        f4();
        e4();
    }
}
