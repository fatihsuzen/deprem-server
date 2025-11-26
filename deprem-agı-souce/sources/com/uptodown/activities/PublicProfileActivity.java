package com.uptodown.activities;

import O1.C0855o4;
import O1.C0863p4;
import O1.C0871q4;
import O1.C0878r4;
import O1.C0886s4;
import O1.C0894t4;
import O1.C0902u4;
import O1.C0910v4;
import O1.C0918w4;
import O1.C0926x4;
import O1.C0934y4;
import R1.C0994z;
import R1.a0;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.m;
import W2.q;
import W2.u;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import c3.C2316b;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.J;
import com.uptodown.util.views.UsernameTextView;
import g2.C2391m;
import h2.H0;
import java.util.ArrayList;
import java.util.Collection;
import k2.C2589F;
import k2.C2592b;
import k2.N;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.O;
import l2.V;
import q3.C2729e;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;

public final class PublicProfileActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14384K = m.b(new C0934y4(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14385L = new ViewModelLazy(M.b(J.class), new f(this), new e(this), new g((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public a0 f14386M;

    /* renamed from: N  reason: collision with root package name */
    private final ActivityResultLauncher f14387N;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14388a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f14389b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f14390c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ V f14391d;

        /* renamed from: com.uptodown.activities.PublicProfileActivity$a$a  reason: collision with other inner class name */
        static final class C0132a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f14392a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ L f14393b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ V f14394c;

            /* renamed from: com.uptodown.activities.PublicProfileActivity$a$a$a  reason: collision with other inner class name */
            public static final class C0133a implements C2592b {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ PublicProfileActivity f14395a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ O f14396b;

                C0133a(PublicProfileActivity publicProfileActivity, O o5) {
                    this.f14395a = publicProfileActivity;
                    this.f14396b = o5;
                }

                public void a(int i5) {
                    this.f14395a.I2(((C2657f) ((J.a) ((O.c) this.f14396b).a()).a().get(i5)).e(), ((C2657f) ((J.a) ((O.c) this.f14396b).a()).a().get(i5)).y0());
                }

                public void b(int i5) {
                }
            }

            /* renamed from: com.uptodown.activities.PublicProfileActivity$a$a$b */
            public static final class b implements C2589F {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ O f14397a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ L f14398b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ PublicProfileActivity f14399c;

                b(O o5, L l5, PublicProfileActivity publicProfileActivity) {
                    this.f14397a = o5;
                    this.f14398b = l5;
                    this.f14399c = publicProfileActivity;
                }

                public void a(int i5) {
                }

                public void b(int i5) {
                    Object obj = ((J.a) ((O.c) this.f14397a).a()).b().get(i5);
                    t.d(obj, "get(...)");
                    this.f14399c.z3().q(this.f14399c, (l2.O) obj);
                }

                public void c() {
                    this.f14399c.d3();
                }

                public void d(int i5) {
                    Object obj = ((J.a) ((O.c) this.f14397a).a()).b().get(i5);
                    t.d(obj, "get(...)");
                    this.f14399c.H2(((l2.O) obj).b());
                }

                public void e(int i5) {
                    String str;
                    Object obj = ((J.a) ((O.c) this.f14397a).a()).b().get(i5);
                    t.d(obj, "get(...)");
                    l2.O o5 = (l2.O) obj;
                    String e5 = o5.e();
                    V v5 = (V) this.f14398b.f24690a;
                    String str2 = null;
                    if (v5 != null) {
                        str = v5.j();
                    } else {
                        str = null;
                    }
                    o5.C(str);
                    Intent intent = new Intent(this.f14399c, RepliesActivity.class);
                    intent.putExtra("review", o5);
                    intent.putExtra("appName", o5.c());
                    intent.putExtra("appIconUrl", e5);
                    intent.putExtra("username", o5.n());
                    V v6 = (V) this.f14398b.f24690a;
                    if (v6 != null) {
                        str2 = v6.a();
                    }
                    intent.putExtra("userAvatarUrl", str2);
                    PublicProfileActivity publicProfileActivity = this.f14399c;
                    publicProfileActivity.startActivity(intent, UptodownApp.f13477F.a(publicProfileActivity));
                }
            }

            C0132a(PublicProfileActivity publicProfileActivity, L l5, V v5) {
                this.f14392a = publicProfileActivity;
                this.f14393b = l5;
                this.f14394c = v5;
            }

            /* access modifiers changed from: private */
            public static final void g(L l5, V v5, PublicProfileActivity publicProfileActivity, View view) {
                String str;
                Object obj = l5.f24690a;
                t.b(obj);
                String j5 = ((V) obj).j();
                if (v5 != null) {
                    str = v5.j();
                } else {
                    str = null;
                }
                if (t.a(j5, str)) {
                    publicProfileActivity.startActivity(new Intent(publicProfileActivity, RecommendedActivity.class), UptodownApp.f13477F.a(publicProfileActivity));
                    return;
                }
                Intent intent = new Intent(publicProfileActivity, PublicListActivity.class);
                intent.putExtra("user", (Parcelable) l5.f24690a);
                publicProfileActivity.startActivity(intent, UptodownApp.f13477F.a(publicProfileActivity));
            }

            /* access modifiers changed from: private */
            public static final void h(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.x3();
            }

            /* access modifiers changed from: private */
            public static final void i(PublicProfileActivity publicProfileActivity, L l5, View view) {
                String str;
                V v5 = (V) l5.f24690a;
                if (v5 != null) {
                    str = v5.j();
                } else {
                    str = null;
                }
                publicProfileActivity.L3(str);
            }

            /* access modifiers changed from: private */
            public static final void j(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.x3();
            }

            /* renamed from: f */
            public final Object emit(O o5, C2308e eVar) {
                String str;
                String str2;
                String str3;
                if (o5 instanceof O.a) {
                    this.f14392a.y3().f22390j.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    String str4 = null;
                    if (!((J.a) cVar.a()).a().isEmpty()) {
                        this.f14392a.y3().f22391k.f22417e.setAdapter(new C0994z(((J.a) cVar.a()).a(), new C0133a(this.f14392a, o5)));
                        this.f14392a.y3().f22391k.getRoot().setVisibility(0);
                        this.f14392a.y3().f22391k.f22416d.setOnClickListener(new D(this.f14393b, this.f14394c, this.f14392a));
                    } else {
                        V v5 = (V) this.f14393b.f24690a;
                        if (v5 != null) {
                            str2 = v5.j();
                        } else {
                            str2 = null;
                        }
                        V v6 = this.f14394c;
                        if (v6 != null) {
                            str3 = v6.j();
                        } else {
                            str3 = null;
                        }
                        if (t.a(str2, str3)) {
                            this.f14392a.y3().f22391k.f22417e.setVisibility(8);
                            this.f14392a.y3().f22391k.f22415c.setVisibility(0);
                            this.f14392a.y3().f22391k.f22418f.setOnClickListener(new E(this.f14392a));
                        }
                    }
                    if (!((J.a) cVar.a()).b().isEmpty()) {
                        this.f14392a.y3().f22392l.f22417e.setAdapter(new a0(((J.a) cVar.a()).b(), new b(o5, this.f14393b, this.f14392a)));
                        this.f14392a.y3().f22392l.getRoot().setVisibility(0);
                        this.f14392a.y3().f22392l.f22416d.setOnClickListener(new F(this.f14392a, this.f14393b));
                    } else {
                        V v7 = (V) this.f14393b.f24690a;
                        if (v7 != null) {
                            str = v7.j();
                        } else {
                            str = null;
                        }
                        V v8 = this.f14394c;
                        if (v8 != null) {
                            str4 = v8.j();
                        }
                        if (t.a(str, str4)) {
                            this.f14392a.y3().f22392l.getRoot().setVisibility(0);
                            this.f14392a.y3().f22392l.f22417e.setVisibility(8);
                            this.f14392a.y3().f22392l.f22415c.setVisibility(0);
                            this.f14392a.y3().f22392l.f22418f.setOnClickListener(new G(this.f14392a));
                        }
                    }
                    this.f14392a.y3().f22390j.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PublicProfileActivity publicProfileActivity, L l5, V v5, C2308e eVar) {
            super(2, eVar);
            this.f14389b = publicProfileActivity;
            this.f14390c = l5;
            this.f14391d = v5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14389b, this.f14390c, this.f14391d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14388a;
            if (i5 == 0) {
                u.b(obj);
                D m5 = this.f14389b.z3().m();
                C0132a aVar = new C0132a(this.f14389b, this.f14390c, this.f14391d);
                this.f14388a = 1;
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
            return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14400a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f14401b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f14402c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ V f14403d;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f14404a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ L f14405b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ V f14406c;

            /* renamed from: com.uptodown.activities.PublicProfileActivity$b$a$a  reason: collision with other inner class name */
            public static final class C0134a implements C2592b {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ PublicProfileActivity f14407a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ O f14408b;

                C0134a(PublicProfileActivity publicProfileActivity, O o5) {
                    this.f14407a = publicProfileActivity;
                    this.f14408b = o5;
                }

                public void a(int i5) {
                    this.f14407a.I2(((C2657f) ((ArrayList) ((O.c) this.f14408b).a()).get(i5)).e(), ((C2657f) ((ArrayList) ((O.c) this.f14408b).a()).get(i5)).y0());
                }

                public void b(int i5) {
                }
            }

            a(PublicProfileActivity publicProfileActivity, L l5, V v5) {
                this.f14404a = publicProfileActivity;
                this.f14405b = l5;
                this.f14406c = v5;
            }

            /* access modifiers changed from: private */
            public static final void e(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.startActivity(new Intent(publicProfileActivity, WishlistActivity.class));
            }

            /* access modifiers changed from: private */
            public static final void f(PublicProfileActivity publicProfileActivity, View view) {
                publicProfileActivity.x3();
            }

            /* renamed from: d */
            public final Object emit(O o5, C2308e eVar) {
                String str;
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (!((Collection) cVar.a()).isEmpty()) {
                            this.f14404a.y3().f22406z.f22417e.setAdapter(new C0994z((ArrayList) cVar.a(), new C0134a(this.f14404a, o5)));
                            this.f14404a.y3().f22406z.getRoot().setVisibility(0);
                            this.f14404a.y3().f22406z.f22417e.setVisibility(0);
                            this.f14404a.y3().f22406z.f22415c.setVisibility(8);
                            this.f14404a.y3().f22406z.f22416d.setOnClickListener(new H(this.f14404a));
                        } else {
                            V v5 = (V) this.f14405b.f24690a;
                            String str2 = null;
                            if (v5 != null) {
                                str = v5.j();
                            } else {
                                str = null;
                            }
                            V v6 = this.f14406c;
                            if (v6 != null) {
                                str2 = v6.j();
                            }
                            if (t.a(str, str2)) {
                                this.f14404a.y3().f22406z.getRoot().setVisibility(0);
                                this.f14404a.y3().f22406z.f22417e.setVisibility(8);
                                this.f14404a.y3().f22406z.f22415c.setVisibility(0);
                                this.f14404a.y3().f22406z.f22418f.setOnClickListener(new I(this.f14404a));
                            }
                        }
                        this.f14404a.y3().f22390j.setVisibility(8);
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PublicProfileActivity publicProfileActivity, L l5, V v5, C2308e eVar) {
            super(2, eVar);
            this.f14401b = publicProfileActivity;
            this.f14402c = l5;
            this.f14403d = v5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14401b, this.f14402c, this.f14403d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14400a;
            if (i5 == 0) {
                u.b(obj);
                D p5 = this.f14401b.z3().p();
                a aVar = new a(this.f14401b, this.f14402c, this.f14403d);
                this.f14400a = 1;
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
            return ((b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14409a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f14410b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f14411a;

            a(PublicProfileActivity publicProfileActivity) {
                this.f14411a = publicProfileActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((O.c) cVar.a()).b() == 1) {
                            a0 s32 = this.f14411a.f14386M;
                            if (s32 != null) {
                                s32.d(((O.c) cVar.a()).a());
                            }
                        } else {
                            PublicProfileActivity publicProfileActivity = this.f14411a;
                            String string = publicProfileActivity.getString(R.string.error_generico);
                            t.d(string, "getString(...)");
                            publicProfileActivity.u0(string);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PublicProfileActivity publicProfileActivity, C2308e eVar) {
            super(2, eVar);
            this.f14410b = publicProfileActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14410b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14409a;
            if (i5 == 0) {
                u.b(obj);
                D l5 = this.f14410b.z3().l();
                a aVar = new a(this.f14410b);
                this.f14409a = 1;
                if (l5.collect(aVar, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14412a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f14413b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PublicProfileActivity f14414a;

            a(PublicProfileActivity publicProfileActivity) {
                this.f14414a = publicProfileActivity;
            }

            public final Object b(int i5, C2308e eVar) {
                if (i5 == 1) {
                    this.f14414a.y3().f22397q.setText(this.f14414a.getString(R.string.unfollow));
                    this.f14414a.y3().f22397q.setBackground(ContextCompat.getDrawable(this.f14414a, R.drawable.ripple_stroke_blue_primary));
                    this.f14414a.y3().f22397q.setTextColor(ContextCompat.getColor(this.f14414a, R.color.blue_primary));
                    this.f14414a.y3().f22399s.setText(new C2962v().k(this.f14414a.z3().k()));
                } else {
                    this.f14414a.y3().f22397q.setText(this.f14414a.getString(R.string.follow));
                    this.f14414a.y3().f22397q.setBackground(ContextCompat.getDrawable(this.f14414a, R.drawable.ripple_blue_primary_button));
                    this.f14414a.y3().f22397q.setTextColor(ContextCompat.getColor(this.f14414a, R.color.white));
                    this.f14414a.y3().f22399s.setText(new C2962v().k(this.f14414a.z3().k()));
                }
                return W2.J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PublicProfileActivity publicProfileActivity, C2308e eVar) {
            super(2, eVar);
            this.f14413b = publicProfileActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14413b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14412a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f14413b.z3().j();
                a aVar = new a(this.f14413b);
                this.f14412a = 1;
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
            return ((d) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14415a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
            super(0);
            this.f14415a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14415a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14416a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14416a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14416a.getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14417a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14418b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14417a = aVar;
            this.f14418b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14417a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14418b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PublicProfileActivity.g.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    public static final class h implements N {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PublicProfileActivity f14419a;

        h(PublicProfileActivity publicProfileActivity) {
            this.f14419a = publicProfileActivity;
        }

        public void a() {
        }

        public void b(V v5) {
            t.e(v5, "user");
            this.f14419a.M3(v5);
        }
    }

    public PublicProfileActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0863p4(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14387N = registerForActivityResult;
    }

    private final void A3(V v5) {
        String str;
        setContentView((View) y3().getRoot());
        y3().f22394n.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.vector_arrow_left_white));
        y3().f22394n.setNavigationContentDescription((CharSequence) getString(R.string.back));
        y3().f22394n.setNavigationOnClickListener(new C0855o4(this));
        y3().f22393m.getViewTreeObserver().addOnScrollChangedListener(new C0871q4(this));
        UsernameTextView usernameTextView = y3().f22402v;
        k.a aVar = k.f32g;
        usernameTextView.setTypeface(aVar.w());
        y3().f22403w.setTypeface(aVar.x());
        y3().f22395o.setTypeface(aVar.w());
        y3().f22397q.setTypeface(aVar.w());
        y3().f22400t.setTypeface(aVar.x());
        y3().f22401u.setTypeface(aVar.w());
        y3().f22404x.setTypeface(aVar.x());
        y3().f22405y.setTypeface(aVar.w());
        y3().f22398r.setTypeface(aVar.x());
        y3().f22399s.setTypeface(aVar.w());
        y3().f22391k.f22420h.setTypeface(aVar.w());
        y3().f22391k.f22418f.setTypeface(aVar.w());
        y3().f22391k.f22419g.setTypeface(aVar.x());
        y3().f22406z.f22420h.setTypeface(aVar.w());
        y3().f22406z.f22418f.setTypeface(aVar.w());
        y3().f22406z.f22419g.setTypeface(aVar.x());
        y3().f22392l.f22420h.setTypeface(aVar.w());
        y3().f22392l.f22418f.setTypeface(aVar.w());
        y3().f22392l.f22419g.setTypeface(aVar.x());
        M3(v5);
        y3().f22391k.f22417e.setLayoutManager(new LinearLayoutManager(this, 0, false));
        y3().f22391k.f22417e.setItemAnimator((RecyclerView.ItemAnimator) null);
        y3().f22392l.f22417e.setLayoutManager(new LinearLayoutManager(this, 0, false));
        y3().f22386f.setOnClickListener(new C0878r4(this, v5));
        y3().f22387g.setOnClickListener(new C0886s4(this, v5));
        y3().f22388h.setOnClickListener(new C0894t4(this, v5));
        V h5 = V.f24870q.h(this);
        String j5 = v5.j();
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (t.a(j5, str)) {
            y3().f22406z.f22417e.setLayoutManager(new LinearLayoutManager(this, 0, false));
            y3().f22406z.f22417e.setItemAnimator((RecyclerView.ItemAnimator) null);
            y3().f22406z.f22420h.setText(getString(R.string.my_wishlist));
            y3().f22406z.f22420h.setText(getString(R.string.my_wishlist));
            y3().f22391k.f22420h.setText(getString(R.string.my_recommended_apps));
            y3().f22392l.f22419g.setText(getString(R.string.my_profile_no_review));
            y3().f22392l.f22420h.setText(getString(R.string.public_profile_my_reviews));
            y3().f22395o.setVisibility(0);
            y3().f22395o.setOnClickListener(new C0902u4(h5, this));
            y3().f22383c.setOnClickListener(new C0910v4(this, v5));
            y3().f22396p.setTypeface(aVar.w());
            y3().f22396p.setVisibility(0);
            y3().f22396p.setOnClickListener(new C0918w4(this));
            y3().f22397q.setVisibility(8);
            return;
        }
        y3().f22395o.setVisibility(8);
        y3().f22397q.setVisibility(0);
        y3().f22397q.setOnClickListener(new C0926x4(h5, this, v5));
        y3().f22391k.f22420h.setText(getString(R.string.recommended_apps));
        y3().f22392l.f22420h.setText(getString(R.string.public_profile_activity_reviews_any_user_title));
    }

    /* access modifiers changed from: private */
    public static final void B3(PublicProfileActivity publicProfileActivity, View view) {
        publicProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void C3(PublicProfileActivity publicProfileActivity) {
        int scrollY = publicProfileActivity.y3().f22393m.getScrollY();
        float dimension = publicProfileActivity.getResources().getDimension(R.dimen.public_profile_header_size) * 0.7f;
        int alphaComponent = ColorUtils.setAlphaComponent(ContextCompat.getColor(publicProfileActivity, R.color.background_color), (int) (C2729e.g(((float) scrollY) / dimension, 0.0f, 1.0f) * ((float) 255)));
        if (((double) scrollY) >= ((double) dimension) * 0.5d) {
            publicProfileActivity.y3().f22394n.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, R.drawable.core_vector_back));
        } else {
            publicProfileActivity.y3().f22394n.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, R.drawable.vector_arrow_left_white));
        }
        publicProfileActivity.y3().f22394n.setBackgroundColor(alphaComponent);
    }

    /* access modifiers changed from: private */
    public static final void D3(PublicProfileActivity publicProfileActivity, V v5, View view) {
        if (UptodownApp.f13477F.Z()) {
            publicProfileActivity.K3(1, v5.k(), v5.j());
        }
    }

    /* access modifiers changed from: private */
    public static final void E3(PublicProfileActivity publicProfileActivity, V v5, View view) {
        if (UptodownApp.f13477F.Z()) {
            publicProfileActivity.K3(2, v5.k(), v5.j());
        }
    }

    /* access modifiers changed from: private */
    public static final void F3(PublicProfileActivity publicProfileActivity, V v5, View view) {
        if (UptodownApp.f13477F.Z()) {
            publicProfileActivity.L3(v5.j());
        }
    }

    /* access modifiers changed from: private */
    public static final void G3(V v5, PublicProfileActivity publicProfileActivity, View view) {
        if (v5 != null && v5.p(publicProfileActivity)) {
            publicProfileActivity.f14387N.launch(new Intent(publicProfileActivity, UserEditProfileActivity.class), UptodownApp.f13477F.b(publicProfileActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void H3(PublicProfileActivity publicProfileActivity, V v5, View view) {
        Intent intent = new Intent(publicProfileActivity, UserAvatarActivity.class);
        intent.putExtra("user", v5);
        publicProfileActivity.f14387N.launch(intent, UptodownApp.f13477F.b(publicProfileActivity));
    }

    /* access modifiers changed from: private */
    public static final void I3(PublicProfileActivity publicProfileActivity, View view) {
        publicProfileActivity.startActivity(new Intent(publicProfileActivity, FeedActivity.class), UptodownApp.f13477F.a(publicProfileActivity));
    }

    /* access modifiers changed from: private */
    public static final void J3(V v5, PublicProfileActivity publicProfileActivity, V v6, View view) {
        String j5;
        if (v5 == null || !v5.p(publicProfileActivity) || (j5 = v6.j()) == null || j5.length() == 0) {
            publicProfileActivity.startActivity(new Intent(publicProfileActivity, LoginActivity.class), UptodownApp.f13477F.a(publicProfileActivity));
            return;
        }
        J z32 = publicProfileActivity.z3();
        String j6 = v6.j();
        t.b(j6);
        z32.i(publicProfileActivity, j6);
    }

    private final void K3(int i5, String str, String str2) {
        Intent intent = new Intent(this, FollowListActivity.class);
        intent.putExtra(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
        intent.putExtra("username", str);
        intent.putExtra("userID", str2);
        startActivity(intent, UptodownApp.f13477F.a(this));
    }

    /* access modifiers changed from: private */
    public final void L3(String str) {
        Intent intent = new Intent(this, UserCommentsActivity.class);
        intent.putExtra("userID", str);
        startActivity(intent, UptodownApp.f13477F.a(this));
    }

    /* access modifiers changed from: private */
    public final void M3(V v5) {
        UsernameTextView.a aVar = UsernameTextView.f21329k;
        UsernameTextView usernameTextView = y3().f22402v;
        t.d(usernameTextView, "tvNamePublicProfile");
        aVar.a(usernameTextView, v5.q(), v5.o());
        y3().f22402v.setText(v5.k());
        y3().f22403w.setText(v5.l());
        String d5 = v5.d();
        if (!(d5 == null || d5.length() == 0 || y3().f22382b.getDrawable() != null)) {
            s.h().l(v5.d()).f().i(y3().f22382b);
        }
        String b5 = v5.b();
        if (!(b5 == null || b5.length() == 0)) {
            s.h().l(V.f24870q.d(v5.a())).n(UptodownApp.f13477F.i0(this)).i(y3().f22383c);
            y3().f22383c.setBackground(ContextCompat.getDrawable(this, R.drawable.shadow_user_icon));
        }
        if (v5.q()) {
            C2962v.a aVar2 = C2962v.f26557a;
            ImageView imageView = y3().f22383c;
            t.d(imageView, "ivIconPublicProfile");
            aVar2.b(imageView);
            y3().f22384d.setVisibility(0);
        }
        y3().f22401u.setText(new C2962v().k(v5.f()));
        y3().f22405y.setText(String.valueOf(v5.m()));
    }

    /* access modifiers changed from: private */
    public static final void N3(PublicProfileActivity publicProfileActivity, ActivityResult activityResult) {
        V h5;
        String j5;
        if (activityResult.getResultCode() == 10 && (h5 = V.f24870q.h(publicProfileActivity)) != null && (j5 = h5.j()) != null && j5.length() != 0) {
            new C2391m(publicProfileActivity, LifecycleOwnerKt.getLifecycleScope(publicProfileActivity)).c(String.valueOf(h5.j()), new h(publicProfileActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final H0 w3(PublicProfileActivity publicProfileActivity) {
        return H0.c(publicProfileActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void x3() {
        setResult(1);
        finish();
    }

    /* access modifiers changed from: private */
    public final H0 y3() {
        return (H0) this.f14384K.getValue();
    }

    /* access modifiers changed from: private */
    public final J z3() {
        return (J) this.f14385L.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        L l5 = new L();
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user"))) {
            l5.f24690a = extras.getParcelable("user");
        }
        Object obj = l5.f24690a;
        if (obj != null) {
            A3((V) obj);
            z3().g(this, String.valueOf(((V) l5.f24690a).j()), ((V) l5.f24690a).i(), ((V) l5.f24690a).e());
        }
        V h5 = V.f24870q.h(this);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new a(this, l5, h5, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new b(this, l5, h5, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused4 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }
}
