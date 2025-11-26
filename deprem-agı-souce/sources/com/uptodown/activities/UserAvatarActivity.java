package com.uptodown.activities;

import B2.r;
import O1.A6;
import O1.B6;
import O1.C0936y6;
import O1.C0944z6;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.graphics.drawable.Drawable;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.activities.c0;
import h2.e1;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.C2596f;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2659h;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z2.Z;
import z3.C2973f;
import z3.D;

public final class UserAvatarActivity extends C1598a {

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14672K = m.b(new B6(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2223l f14673L = new ViewModelLazy(M.b(c0.class), new g(this), new f(this), new h((C2616a) null, this));
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public R1.M f14674M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public R1.M f14675N;

    /* renamed from: O  reason: collision with root package name */
    private int f14676O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public final AtomicBoolean f14677P = new AtomicBoolean(false);

    /* renamed from: Q  reason: collision with root package name */
    private final c f14678Q = new c(this);

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14679a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f14680b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(UserAvatarActivity userAvatarActivity, C2308e eVar) {
            super(2, eVar);
            this.f14680b = userAvatarActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f14680b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14679a;
            if (i5 == 0) {
                u.b(obj);
                if (this.f14680b.f14677P.compareAndSet(false, true)) {
                    UserAvatarActivity userAvatarActivity = this.f14680b;
                    this.f14679a = 1;
                    if (userAvatarActivity.B3(this) == f5) {
                        return f5;
                    }
                }
                return J.f19942a;
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f14680b.f14677P.set(false);
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14681a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f14682b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UserAvatarActivity userAvatarActivity, C2308e eVar) {
            super(2, eVar);
            this.f14682b = userAvatarActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f14682b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14681a == 0) {
                u.b(obj);
                this.f14682b.v3();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class c implements C2596f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f14683a;

        c(UserAvatarActivity userAvatarActivity) {
            this.f14683a = userAvatarActivity;
        }

        public void a(C2659h hVar, int i5) {
            t.e(hVar, "avatar");
            if (this.f14683a.w3().f().getValue() != null) {
                Object value = this.f14683a.w3().f().getValue();
                t.b(value);
                if (((V) value).p(this.f14683a)) {
                    Object value2 = this.f14683a.w3().f().getValue();
                    t.b(value2);
                    if (((V) value2).q()) {
                        R1.M k32 = this.f14683a.f14674M;
                        if (k32 == null || k32.c() != -1) {
                            R1.M k33 = this.f14683a.f14674M;
                            t.b(k33);
                            k33.d(-1);
                            R1.M k34 = this.f14683a.f14674M;
                            t.b(k34);
                            k34.notifyDataSetChanged();
                        }
                        R1.M m32 = this.f14683a.f14675N;
                        if (m32 != null) {
                            R1.M m33 = this.f14683a.f14675N;
                            t.b(m33);
                            m32.notifyItemChanged(m33.c());
                        }
                        R1.M m34 = this.f14683a.f14675N;
                        if (m34 != null) {
                            m34.d(i5);
                        }
                        R1.M m35 = this.f14683a.f14675N;
                        if (m35 != null) {
                            m35.notifyItemChanged(i5);
                            return;
                        }
                        return;
                    }
                }
            }
            C2962v.u(new C2962v(), this.f14683a, Z.f26527b.c(this.f14683a), (String) null, 4, (Object) null);
        }

        public void b(C2659h hVar, int i5) {
            t.e(hVar, "avatar");
            if (this.f14683a.f14675N != null) {
                R1.M m32 = this.f14683a.f14675N;
                t.b(m32);
                if (m32.c() != -1) {
                    R1.M m33 = this.f14683a.f14675N;
                    t.b(m33);
                    R1.M m34 = this.f14683a.f14675N;
                    t.b(m34);
                    m33.notifyItemChanged(m34.c());
                    R1.M m35 = this.f14683a.f14675N;
                    t.b(m35);
                    m35.d(-1);
                    R1.M m36 = this.f14683a.f14675N;
                    t.b(m36);
                    m36.notifyItemChanged(i5);
                }
            }
            R1.M k32 = this.f14683a.f14674M;
            t.b(k32);
            k32.d(i5);
            R1.M k33 = this.f14683a.f14674M;
            t.b(k33);
            k33.notifyDataSetChanged();
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14684a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f14685b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserAvatarActivity f14686a;

            a(UserAvatarActivity userAvatarActivity) {
                this.f14686a = userAvatarActivity;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f14686a.t3().f22972d.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    this.f14686a.t3().f22972d.setVisibility(8);
                    this.f14686a.t3().f22978j.setVisibility(0);
                    O.c cVar = (O.c) o5;
                    this.f14686a.s3(((c0.a) cVar.a()).a(), ((c0.a) cVar.a()).b());
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UserAvatarActivity userAvatarActivity, C2308e eVar) {
            super(2, eVar);
            this.f14685b = userAvatarActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14685b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14684a;
            if (i5 == 0) {
                u.b(obj);
                D d5 = this.f14685b.w3().d();
                a aVar = new a(this.f14685b);
                this.f14684a = 1;
                if (d5.collect(aVar, this) == f5) {
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
        int f14687a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserAvatarActivity f14688b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UserAvatarActivity f14689a;

            a(UserAvatarActivity userAvatarActivity) {
                this.f14689a = userAvatarActivity;
            }

            public final Object b(boolean z4, C2308e eVar) {
                if (z4) {
                    UserAvatarActivity userAvatarActivity = this.f14689a;
                    String string = userAvatarActivity.getString(R.string.avatar_activity_changed_success);
                    t.d(string, "getString(...)");
                    userAvatarActivity.u0(string);
                    this.f14689a.setResult(10);
                    this.f14689a.finish();
                }
                return J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Boolean) obj).booleanValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(UserAvatarActivity userAvatarActivity, C2308e eVar) {
            super(2, eVar);
            this.f14688b = userAvatarActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14688b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14687a;
            if (i5 == 0) {
                u.b(obj);
                D e5 = this.f14688b.w3().e();
                a aVar = new a(this.f14688b);
                this.f14687a = 1;
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

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14690a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.f14690a = componentActivity;
        }

        public final ViewModelProvider.Factory invoke() {
            return this.f14690a.getDefaultViewModelProviderFactory();
        }
    }

    public static final class g extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14691a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.f14691a = componentActivity;
        }

        public final ViewModelStore invoke() {
            return this.f14691a.getViewModelStore();
        }
    }

    public static final class h extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f14692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ComponentActivity f14693b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(C2616a aVar, ComponentActivity componentActivity) {
            super(0);
            this.f14692a = aVar;
            this.f14693b = componentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
            /*
                r1 = this;
                k3.a r0 = r1.f14692a
                if (r0 == 0) goto L_0x000e
                java.lang.Object r0 = r0.invoke()
                androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
                if (r0 != 0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                return r0
            L_0x000e:
                androidx.activity.ComponentActivity r0 = r1.f14693b
                androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserAvatarActivity.h.invoke():androidx.lifecycle.viewmodel.CreationExtras");
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(UserAvatarActivity userAvatarActivity, View view) {
        C2962v.u(new C2962v(), userAvatarActivity, Z.f26527b.c(userAvatarActivity), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object B3(b3.C2308e r7) {
        /*
            r6 = this;
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r6)
            w3.I0 r1 = w3.C2865c0.c()
            com.uptodown.activities.UserAvatarActivity$e r3 = new com.uptodown.activities.UserAvatarActivity$e
            r7 = 0
            r3.<init>(r6, r7)
            r4 = 2
            r5 = 0
            r2 = 0
            w3.C2908y0 unused = w3.C2876i.d(r0, r1, r2, r3, r4, r5)
            R1.M r0 = r6.f14674M
            r1 = -1
            if (r0 == 0) goto L_0x003b
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.c()
            if (r0 == r1) goto L_0x003b
            R1.M r7 = r6.f14674M
            kotlin.jvm.internal.t.b(r7)
            java.util.ArrayList r7 = r7.b()
            R1.M r0 = r6.f14674M
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.c()
            java.lang.Object r7 = r7.get(r0)
            l2.h r7 = (l2.C2659h) r7
            goto L_0x0060
        L_0x003b:
            R1.M r0 = r6.f14675N
            if (r0 == 0) goto L_0x0060
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.c()
            if (r0 == r1) goto L_0x0060
            R1.M r7 = r6.f14675N
            kotlin.jvm.internal.t.b(r7)
            java.util.ArrayList r7 = r7.b()
            R1.M r0 = r6.f14675N
            kotlin.jvm.internal.t.b(r0)
            int r0 = r0.c()
            java.lang.Object r7 = r7.get(r0)
            l2.h r7 = (l2.C2659h) r7
        L_0x0060:
            if (r7 == 0) goto L_0x0069
            com.uptodown.activities.c0 r0 = r6.w3()
            r0.g(r6, r7)
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.UserAvatarActivity.B3(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final e1 r3(UserAvatarActivity userAvatarActivity) {
        return e1.c(userAvatarActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void s3(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        boolean z4;
        int i5 = 0;
        if (this.f14674M == null) {
            arrayList3 = arrayList;
            this.f14674M = new R1.M(arrayList3, this.f14678Q, 0, this.f14676O, false, 16, (C2633k) null);
            t3().f22973e.setAdapter(this.f14674M);
            t3().f22976h.setVisibility(0);
        } else {
            arrayList3 = arrayList;
        }
        t3().f22971c.setVisibility(8);
        if (!arrayList2.isEmpty()) {
            t3().f22971c.setVisibility(0);
            V h5 = V.f24870q.h(this);
            if (h5 != null) {
                z4 = h5.q();
            } else {
                z4 = false;
            }
            if (this.f14675N == null) {
                arrayList4 = arrayList2;
                this.f14675N = new R1.M(arrayList4, this.f14678Q, 1, 0, z4, 8, (C2633k) null);
                t3().f22974f.setAdapter(this.f14675N);
                t3().f22974f.setVisibility(0);
            } else {
                arrayList4 = arrayList2;
            }
        } else {
            arrayList4 = arrayList2;
            t3().f22971c.setVisibility(8);
            t3().f22974f.setVisibility(8);
        }
        int size = arrayList3.size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                i6 = -1;
                break;
            }
            Object obj = arrayList3.get(i7);
            i7++;
            if (((C2659h) obj).b() == 1) {
                break;
            }
            i6++;
        }
        int size2 = arrayList4.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size2) {
                i5 = -1;
                break;
            }
            Object obj2 = arrayList4.get(i8);
            i8++;
            if (((C2659h) obj2).b() == 1) {
                break;
            }
            i5++;
        }
        if (i6 > -1) {
            R1.M m5 = this.f14674M;
            if (m5 != null) {
                m5.d(i6);
            }
            R1.M m6 = this.f14674M;
            if (m6 != null) {
                m6.notifyItemChanged(i6);
            }
        } else if (i5 > -1) {
            R1.M m7 = this.f14675N;
            if (m7 != null) {
                m7.d(i5);
            }
            R1.M m8 = this.f14675N;
            if (m8 != null) {
                m8.notifyItemChanged(i5);
            }
        }
    }

    /* access modifiers changed from: private */
    public final e1 t3() {
        return (e1) this.f14672K.getValue();
    }

    private final int u3() {
        int i5 = getResources().getDisplayMetrics().widthPixels;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.margin_m);
        int i6 = 6;
        while (true) {
            if ((i5 - ((i6 + 1) * dimensionPixelSize)) / i6 > getResources().getDimensionPixelSize(R.dimen.icon_size_l)) {
                break;
            }
            i6--;
            if (i6 <= 0) {
                i6 = 1;
                break;
            }
        }
        this.f14676O = (i5 - (dimensionPixelSize * (i6 + 1))) / i6;
        return i6;
    }

    /* access modifiers changed from: private */
    public final void v3() {
        w3().c(this);
    }

    /* access modifiers changed from: private */
    public final c0 w3() {
        return (c0) this.f14673L.getValue();
    }

    private final void x3() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        e1 t32 = t3();
        if (drawable != null) {
            t32.f22975g.setNavigationIcon(drawable);
            t32.f22975g.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        t32.f22975g.setNavigationOnClickListener(new C0936y6(this));
        TextView textView = t32.f22979k;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        t32.f22978j.setTypeface(aVar.w());
        t32.f22977i.setTypeface(aVar.w());
        t32.f22976h.setTypeface(aVar.w());
        t32.f22980l.setTypeface(aVar.w());
        t32.f22977i.setOnClickListener(new C0944z6(this));
        if (w3().f().getValue() != null) {
            Object value = w3().f().getValue();
            t.b(value);
            if (((V) value).q()) {
                t32.f22970b.setOnClickListener(new A6(this));
            }
        }
        t32.f22973e.setLayoutManager(new GridLayoutManager(this, u3()));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        t32.f22973e.setItemAnimator(defaultItemAnimator);
        t32.f22974f.setLayoutManager(new LinearLayoutManager(this, 0, false));
        t32.f22974f.addItemDecoration(new r(this));
        t32.f22974f.setItemAnimator(defaultItemAnimator);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new b(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void y3(UserAvatarActivity userAvatarActivity, View view) {
        userAvatarActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void z3(UserAvatarActivity userAvatarActivity, View view) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), (C2312i) null, (w3.O) null, new a(userAvatarActivity, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) t3().getRoot());
        w3().f().setValue(V.f24870q.h(this));
        x3();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }
}
